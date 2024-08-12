package br.com.soc.sistema.action.examerealizado;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.business.ExameRealizadoBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.ExameRealizadoVo;

public class ExameRealizadoAction extends Action {
    private static final long serialVersionUID = 1L;
    
    private ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
    private ExameRealizadoVo novoExame = new ExameRealizadoVo();
    private List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
    private ExameRealizadoBusiness business = new ExameRealizadoBusiness();
    private String dataExame;
    private String tipoFiltro;
    private String valorBusca;
    
    public String todos() {
	examesRealizados.addAll(business.trazerTodosExamesRealizados());
	return SUCCESS;
    }
    
    public String novo() {
	return INPUT;
    }
    
    public String salvar() {	
	business.salvarExameRealizado(exameRealizadoVo);
	return REDIRECT;
    }
    
    public String atualizar() {
	business.atualizarExamesRealizados(exameRealizadoVo, novoExame);
	return REDIRECT;
    }
    
    public String editar() {
	System.out.println(exameRealizadoVo);
	return ALTERAR;
    }
    
    public String excluir() {	
	business.excluirExameRealizado(exameRealizadoVo);
	return REDIRECT;
    }
    
    public String filtrar() {
	if(valorBusca.isEmpty()) {
	    return REDIRECT;
	}
	
	examesRealizados = business.filtrarExamesRealizados(tipoFiltro, valorBusca);
	return SUCCESS;
    }

    public ExameRealizadoVo getExameRealizadoVo() {
        return exameRealizadoVo;
    }

    public void setExameRealizadoVo(ExameRealizadoVo exameRealizadoVo) {
        this.exameRealizadoVo = exameRealizadoVo;
    }

    public List<ExameRealizadoVo> getExamesRealizados() {
        return examesRealizados;
    }

    public void setExamesRealizados(List<ExameRealizadoVo> examesRealizados) {
        this.examesRealizados = examesRealizados;
    }

    public ExameRealizadoBusiness getExameRealizadoBusiness() {
        return business;
    }

    public void setExameRealizadoBusiness(ExameRealizadoBusiness exameRealizadoBusiness) {
        this.business = exameRealizadoBusiness;
    }

    public String getDataExame() {
        return dataExame;
    }

    public void setDataExame(String dataExame) {
        this.dataExame = dataExame;
    }

    public ExameRealizadoVo getNovoExame() {
        return novoExame;
    }

    public void setNovoExame(ExameRealizadoVo novoExame) {
        this.novoExame = novoExame;
    }

    public String getTipoFiltro() {
        return tipoFiltro;
    }

    public void setTipoFiltro(String tipoFiltro) {
        this.tipoFiltro = tipoFiltro;
    }

    public String getValorBusca() {
        return valorBusca;
    }

    public void setValorBusca(String valorBusca) {
        this.valorBusca = valorBusca;
    } 
    
}
