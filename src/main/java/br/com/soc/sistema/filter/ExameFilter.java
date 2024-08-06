package br.com.soc.sistema.filter;

import br.com.soc.sistema.infra.OpcoesComboBuscar;

public class ExameFilter {
	private OpcoesComboBuscar opcoesCombo;
	private String valorBusca;

	public String getValorBusca() {
		return valorBusca;
	}

	public ExameFilter setValorBusca(String valorBusca) {
		this.valorBusca = valorBusca;
		return this;
	}

	public OpcoesComboBuscar getOpcoesCombo() {
		return opcoesCombo;
	}

	public ExameFilter setOpcoesCombo(String codigo) {
		this.opcoesCombo = OpcoesComboBuscar.buscarPor(codigo);
		return this;
	}	
	
	public boolean isNullOpcoesCombo() {
		return this.getOpcoesCombo() == null;
	}
	
	public static ExameFilter builder() {
		return new ExameFilter();
	}
}
