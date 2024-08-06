package br.com.soc.sistema.business;

import java.util.List;

import br.com.soc.sistema.dao.funcionarios.FuncionarioDao;
import br.com.soc.sistema.exception.BusinessException;
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
}
