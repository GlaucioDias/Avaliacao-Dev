package br.com.soc.sistema.dao.relatorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.vo.ExameRealizadoVo;
import br.com.soc.sistema.vo.ExameVo;
import br.com.soc.sistema.vo.FuncionarioVo;

public class RelatorioDao extends Dao {

    public List<ExameRealizadoVo> filterAllExamesRealizadosNoIntervalo(String dataInicial, String dataFinal) {
	List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
	StringBuilder query = new StringBuilder("SELECT f.rowid AS rowid_funcionario, f.nm_funcionario, e.rowid AS rowid_exame, e.nm_exame, ef.dt_exame ")
		.append("FROM exame_funcionario ef ")
		.append("JOIN funcionario f ON ef.rowid_funcionario = f.rowid ")
		.append("JOIN exame e ON ef.rowid_exame = e.rowid ")
		.append("WHERE ef.dt_exame BETWEEN ? AND ?");
	try(
		Connection con = getConexao();
		PreparedStatement ps = con.prepareStatement(query.toString());
	) {
	    ps.setString(1, dataInicial);
	    ps.setString(2, dataFinal);
	    try(ResultSet rs = ps.executeQuery()) {
		while(rs.next()) {
		    ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
		    FuncionarioVo funcionarioVo = new FuncionarioVo(rs.getString("rowid_funcionario"), rs.getString("nm_funcionario"));
		    ExameVo exameVo = new ExameVo(rs.getString("rowid_exame"), rs.getString("nm_exame"));
		    exameRealizadoVo.setFuncionarioVo(funcionarioVo);
		    exameRealizadoVo.setExameVo(exameVo);
		    exameRealizadoVo.setDataExame(rs.getDate("dt_exame"));
		    examesRealizados.add(exameRealizadoVo);
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	return examesRealizados;
    }

}
