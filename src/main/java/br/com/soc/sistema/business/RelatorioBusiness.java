package br.com.soc.sistema.business;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.dao.relatorio.RelatorioDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.ExameRealizadoVo;

public class RelatorioBusiness {
    private RelatorioDao dao;
    
    public RelatorioBusiness() {
	this.dao = new RelatorioDao();
    }

    public List<ExameRealizadoVo> filtrarExamesRealizadosNoIntervalo(String dataInicial, String dataFinal) {
	List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
	try {
	    examesRealizados.addAll(dao.filterAllExamesRealizadosNoIntervalo(dataInicial, dataFinal));
	} catch (Exception e) {
	    throw new BusinessException("Não foi possívelfiltrar os exames realizados no intervalo informado");
	}
	return examesRealizados;
    }
}
