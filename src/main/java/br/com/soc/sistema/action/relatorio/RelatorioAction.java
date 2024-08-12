package br.com.soc.sistema.action.relatorio;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.business.RelatorioBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.RelatorioExamesRealizados;
import br.com.soc.sistema.vo.ExameRealizadoVo;

public class RelatorioAction extends Action {
    private static final long serialVersionUID = 3107168663503766490L;
    private List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
    private RelatorioBusiness business = new RelatorioBusiness();
    private RelatorioExamesRealizados relatorio = new RelatorioExamesRealizados();
    private String dataInicial;
    private String dataFinal;
    
    public String listar() {
	return SUCCESS;
    }
    
    public String filtrar() {
	examesRealizados = business.filtrarExamesRealizadosNoIntervalo(dataInicial, dataFinal);
	relatorio.gerarRelatorio(examesRealizados);
	return SUCCESS;
    }

    public List<ExameRealizadoVo> getExamesRealizados() {
        return examesRealizados;
    }

    public void setExamesRealizados(List<ExameRealizadoVo> examesRealizados) {
        this.examesRealizados = examesRealizados;
    }

    public RelatorioBusiness getBusiness() {
        return business;
    }

    public void setBusiness(RelatorioBusiness business) {
        this.business = business;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }    
    
}
