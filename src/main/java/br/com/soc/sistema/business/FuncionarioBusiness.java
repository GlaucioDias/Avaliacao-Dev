package br.com.soc.sistema.business;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.dao.funcionarios.FuncionarioDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.FuncionarioFilter;
import br.com.soc.sistema.vo.FuncionarioVo;

public class FuncionarioBusiness {
    private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
    private FuncionarioDao dao;
    
    public FuncionarioBusiness() {
	this.dao = new FuncionarioDao();
    }
    
    public List<FuncionarioVo> trazerTodosOsFuncionarios() {
	return dao.findAllFuncionarios();
    }
    
    public void salvarfuncionario(FuncionarioVo funcionarioVo) {
	try {
	    if(funcionarioVo.getNome().isEmpty()) {
		throw new IllegalArgumentException("Nome não pode ser em branco");
	    }
	    dao.insertFuncionario(funcionarioVo);
	} catch (Exception e) {
	    throw new BusinessException("Não foi possível realizar a inclusão do registro");
	}
    }

    public FuncionarioVo buscarFuncionarioPor(String codigo) {
	try {
	    Integer cod = Integer.parseInt(codigo);
	    return dao.findByCodigo(cod);
	} catch (Exception e) {
	    throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
	}	
    }

    public void atualizarFuncionario(FuncionarioVo funcionarioVo) {
	try {
	    if(funcionarioVo.getNome().isEmpty()) {
		throw new IllegalArgumentException("Nome não pode ser em branco");
	    }
	    dao.updateFuncionario(funcionarioVo);
	} catch (Exception e) {
	    throw new BusinessException("Não foi possível realizar a atualização do registro");
	}
	
    }

    public void excluirFuncionario(FuncionarioVo funcionarioVo) {
	try {
	    if(funcionarioVo.getRowid().isEmpty()) {
		throw new IllegalArgumentException("Código não informado");
	    }
	    
	    Integer rowId = Integer.parseInt(funcionarioVo.getRowid());
	    dao.deleteByCodigo(rowId);
	} catch (Exception e) {
	    throw new BusinessException("Não foi possível realizar a exclusão do registro");
	}
	
    }

    public List<FuncionarioVo> filtrarFuncionarios(FuncionarioFilter filter) {
	
	List<FuncionarioVo> funcionarios = new ArrayList<>();

	switch (filter.getOpcoesCombo()) {
	case ID:
	    try {
		if(filter.getValorBusca().isEmpty()) {
		    funcionarios.addAll(dao.findAllFuncionarios());
		    break;
		}
		Integer codigo = Integer.parseInt(filter.getValorBusca());
		funcionarios.add(dao.findByCodigo(codigo));
	    } catch (NumberFormatException e) {
		throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
	    }
	    break;

	case NOME:
	    funcionarios.addAll(dao.findAllByNome(filter.getValorBusca()));
	    break;
	}

	return funcionarios;
    }
}
