package br.com.soc.sistema.business;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.dao.examesrealizados.ExameRealizadoDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.ExameRealizadoVo;

public class ExameRealizadoBusiness {
    private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
    private ExameRealizadoDao dao;

    public ExameRealizadoBusiness() {
	this.dao = new ExameRealizadoDao();
    }

    public List<ExameRealizadoVo> trazerTodosExamesRealizados() {

	return dao.findAllExamesRealizados();
    }

    public void salvarExameRealizado(ExameRealizadoVo exameRealizadoVo) {
	try {
	    dao.insertExameRealizado(exameRealizadoVo);
	} catch (Exception e) {
	    throw new BusinessException("Não foi possível realizar a inclusão do registro");
	}

    }

    public void excluirExameRealizado(ExameRealizadoVo exameRealizadoVo) {
	try {
	    dao.deleteExameRealizado(exameRealizadoVo);
	} catch (Exception e) {
	    throw new BusinessException("Não foi possível realizar a exclusão do registro");
	}

    }

    public void atualizarExamesRealizados(ExameRealizadoVo exameRealizadoVo, ExameRealizadoVo novoExame) {
	try {
	    dao.updateExameRealizado(exameRealizadoVo, novoExame);
	} catch (Exception e) {
	    throw new BusinessException("Não foi possível realizar a atualização do registro");
	}

    }

    public List<ExameRealizadoVo> filtrarExamesRealizados(String tipoFiltro, String valorBusca) {
	List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();

	switch (tipoFiltro) {
	case "FuncionarioID": {
	    try {
		examesRealizados.addAll(dao.filterExamesRealizadosByFuncinarioId(valorBusca));
	    } catch (NumberFormatException e) {
		throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
	    }
	    break;
	}
	case "ExameID": {
	    try {
		examesRealizados.addAll(dao.filterExamesRealizadosByExameId(valorBusca));
	    } catch (NumberFormatException e) {
		throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
	    }
	    break;
	}
	}

	return examesRealizados;
    }

}
