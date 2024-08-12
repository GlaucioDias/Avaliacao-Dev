package br.com.soc.sistema.action.funcionario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.soc.sistema.business.FuncionarioBusiness;
import br.com.soc.sistema.filter.FuncionarioFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesComboBuscar;
import br.com.soc.sistema.vo.FuncionarioVo;

public class FuncionarioAction extends Action {
    private static final long serialVersionUID = -719544693129321127L;
    private List<FuncionarioVo> funcionarios = new ArrayList<>();
    private FuncionarioBusiness business = new FuncionarioBusiness();
    private FuncionarioFilter filtrar = new FuncionarioFilter();
    private FuncionarioVo funcionarioVo = new FuncionarioVo();

    public String todos() {
	funcionarios.addAll(business.trazerTodosOsFuncionarios());
	return SUCCESS;
    }

    public String novo() {
	if (funcionarioVo.getNome() == null) {
	    return INPUT;
	}

	business.salvarfuncionario(funcionarioVo);

	return REDIRECT;
    }
    
    public String atualizar() {
	if(funcionarioVo.getNome() == null) {
	    return ALTERAR;
	}
	business.atualizarFuncionario(funcionarioVo);
	return REDIRECT;
    }
    
    public String editar() {
	if(funcionarioVo.getRowid() == null) {
	    return REDIRECT;
	}
	
	funcionarioVo = business.buscarFuncionarioPor(funcionarioVo.getRowid());
	return ALTERAR;
    }
    
    public String excluir() {
	if(funcionarioVo.getRowid() == null) {
	    return REDIRECT;
	}
	
	business.excluirFuncionario(funcionarioVo);
	
	return REDIRECT;
    }

    public String filtrar() {
	if (filtrar.isNullOpcoesCombo())
	    return REDIRECT;
	funcionarios = business.filtrarFuncionarios(filtrar);

	return SUCCESS;
    }

    public List<OpcoesComboBuscar> getListaOpcoesCombo() {
	return Arrays.asList(OpcoesComboBuscar.values());
    }

    public FuncionarioFilter getFiltrar() {
        return filtrar;
    }

    public void setFiltrar(FuncionarioFilter filtrar) {
        this.filtrar = filtrar;
    }

    public FuncionarioVo getFuncionarioVo() {
        return funcionarioVo;
    }

    public void setFuncionarioVo(FuncionarioVo funcionarioVo) {
        this.funcionarioVo = funcionarioVo;
    }

    public List<FuncionarioVo> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<FuncionarioVo> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
}
