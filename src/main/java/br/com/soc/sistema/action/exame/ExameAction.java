package br.com.soc.sistema.action.exame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.soc.sistema.business.ExameBusiness;
import br.com.soc.sistema.filter.ExameFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesComboBuscar;
import br.com.soc.sistema.vo.ExameVo;

public class ExameAction extends Action {
    private static final long serialVersionUID = 952940925440219357L;
    private List<ExameVo> exames = new ArrayList<>();
    private ExameBusiness business = new ExameBusiness();
    private ExameFilter filtrar = new ExameFilter();
    private ExameVo exameVo = new ExameVo();

    public String todos() {
	exames.addAll(business.trazerTodosOsExames());
	return SUCCESS;
    }

    public String filtrar() {
	if (filtrar.isNullOpcoesCombo())
	    return REDIRECT;

	exames = business.filtrarExames(filtrar);

	return SUCCESS;
    }

    public String novo() {
	if (exameVo.getNome() == null) {
	    return INPUT;
	}

	business.salvarExame(exameVo);

	return REDIRECT;
    }

    public String atualizar() {
	if (exameVo.getNome() == null) {
	    return ALTERAR;
	}
	business.atualizarExame(exameVo);
	return REDIRECT;
    }

    public String editar() {
	if (exameVo.getRowid() == null)
	    return REDIRECT;

	exameVo = business.buscarExamePor(exameVo.getRowid());

	return ALTERAR;
    }

    public String excluir() {
	if (exameVo.getRowid() == null) {
	    return REDIRECT;
	}

	business.excluirExame(exameVo);

	return REDIRECT;
    }

    public List<OpcoesComboBuscar> getListaOpcoesCombo() {
	return Arrays.asList(OpcoesComboBuscar.values());
    }

    public List<ExameVo> getExames() {
	return exames;
    }

    public void setExames(List<ExameVo> exames) {
	this.exames = exames;
    }

    public ExameFilter getFiltrar() {
	return filtrar;
    }

    public void setFiltrar(ExameFilter filtrar) {
	this.filtrar = filtrar;
    }

    public ExameVo getExameVo() {
	return exameVo;
    }

    public void setExameVo(ExameVo exameVo) {
	this.exameVo = exameVo;
    }
}
