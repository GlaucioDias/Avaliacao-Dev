package br.com.soc.sistema.vo;

import java.util.Date;

public class ExameRealizadoVo {
    private FuncionarioVo funcionarioVo;
    private ExameVo exameVo;
    private Date dataExame;
    
    public ExameRealizadoVo() {}
    
    public ExameRealizadoVo(FuncionarioVo funcionarioVo, ExameVo exameVo, Date dataExame) {
	this.funcionarioVo = funcionarioVo;
	this.exameVo = exameVo;
	this.dataExame = dataExame;
    }

    public FuncionarioVo getFuncionarioVo() {
        return funcionarioVo;
    }
    
    public void setFuncionarioVo(FuncionarioVo funcionarioVo) {
        this.funcionarioVo = funcionarioVo;
    }
    
    public ExameVo getExameVo() {
        return exameVo;
    }
    
    public void setExameVo(ExameVo exameVo) {
        this.exameVo = exameVo;
    }
    
    public Date getDataExame() {
        return dataExame;
    }
    
    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    @Override
    public String toString() {
	return "ExameRealizadoVo [funcionarioVo=" + funcionarioVo + ", exameVo=" + exameVo + ", dataExame=" + dataExame
		+ "]";
    }
    
    
}
