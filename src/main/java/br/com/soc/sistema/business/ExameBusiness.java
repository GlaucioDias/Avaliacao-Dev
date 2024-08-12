package br.com.soc.sistema.business;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.dao.exames.ExameDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.ExameFilter;
import br.com.soc.sistema.vo.ExameVo;

public class ExameBusiness {

    private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
    private ExameDao dao;

    public ExameBusiness() {
	this.dao = new ExameDao();
    }

    public List<ExameVo> trazerTodosOsExames() {
	return dao.findAllExames();
    }

    public void salvarExame(ExameVo exameVo) {
	try {
	    if (exameVo.getNome().isEmpty())
		throw new IllegalArgumentException("Nome nao pode ser em branco");

	    dao.insertExame(exameVo);
	} catch (Exception e) {
	    throw new BusinessException("Nao foi possivel realizar a inclusão do registro");
	}

    }

    public List<ExameVo> filtrarExames(ExameFilter filter) {
	List<ExameVo> exames = new ArrayList<>();

	switch (filter.getOpcoesCombo()) {
	case ID:
	    try {
		if(filter.getValorBusca().isEmpty()) {
		    exames.addAll(dao.findAllExames());
		    break;
		}
		Integer codigo = Integer.parseInt(filter.getValorBusca());
		exames.add(dao.findByCodigo(codigo));
	    } catch (NumberFormatException e) {
		throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
	    }
	    break;

	case NOME:
	    exames.addAll(dao.findAllByNome(filter.getValorBusca()));
	    break;
	}

	return exames;
    }

    public ExameVo buscarExamePor(String codigo) {
	try {
	    Integer rowId = Integer.parseInt(codigo);
	    return dao.findByCodigo(rowId);
	} catch (NumberFormatException e) {
	    throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
	}
    }

    public void excluirExame(ExameVo exameVo) {
	try {
	    if (exameVo.getRowid().isEmpty()) {
		throw new IllegalArgumentException("Código não informado");
	    }

	    Integer rowId = Integer.parseInt(exameVo.getRowid());
	    dao.deleteByCodigo(rowId);

	} catch (Exception e) {
	    throw new BusinessException("Não foi possível realizar a exclusão do registro");
	}
    }

    public void atualizarExame(ExameVo exameVo) {
	try {
	    if (exameVo.getNome().isEmpty()) {
		throw new IllegalArgumentException("Nome não pode ser em branco");
	    }

	    dao.updateExame(exameVo);
	} catch (Exception e) {
	    throw new BusinessException("Não foi possível realizar a atualização do registro");
	}

    }
}
