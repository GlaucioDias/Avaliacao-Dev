package br.com.soc.sistema.dao.examesrealizados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.vo.ExameRealizadoVo;
import br.com.soc.sistema.vo.ExameVo;
import br.com.soc.sistema.vo.FuncionarioVo;

public class ExameRealizadoDao extends Dao{

    public List<ExameRealizadoVo> findAllExamesRealizados() {
	List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
	
	String query = "SELECT f.rowid AS rowid_funcionario, e.rowid AS rowid_exame, ef.dt_exame "
			+ "FROM exame_funcionario ef "
			+ "JOIN funcionario f ON ef.rowid_funcionario = f.rowid "
			+ "JOIN exame e ON ef.rowid_exame = e.rowid;";
	try(
		Connection con = getConexao();
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
	) {
	    
	    while(rs.next()) {
		ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
		FuncionarioVo funcionarioVo = new FuncionarioVo();
		ExameVo exameVo = new ExameVo();
		funcionarioVo.setRowid(rs.getString("rowid_funcionario"));
		exameVo.setRowid(rs.getString("rowid_exame"));
		exameRealizadoVo.setDataExame(rs.getDate("dt_exame"));
		exameRealizadoVo.setExameVo(exameVo);
		exameRealizadoVo.setFuncionarioVo(funcionarioVo);
		examesRealizados.add(exameRealizadoVo);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return examesRealizados;
    }

    public void insertExameRealizado(ExameRealizadoVo exameRealizadoVo) {
	StringBuilder query = new StringBuilder("INSERT INTO exame_funcionario ")
		.append("(rowid_funcionario, rowid_exame, dt_exame) ")
		.append("VALUES (?,?,?);");
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	try(
		Connection con = getConexao();
		PreparedStatement ps = con.prepareStatement(query.toString())
	) {
	    int i = 1;
	    ps.setString(i++, exameRealizadoVo.getFuncionarioVo().getRowid());
	    ps.setString(i++, exameRealizadoVo.getExameVo().getRowid());
	    ps.setString(i, formatter.format(exameRealizadoVo.getDataExame()));
	    ps.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public void deleteExameRealizado(ExameRealizadoVo exameRealizadoVo) {
	StringBuilder query = new StringBuilder("DELETE FROM exame_funcionario ")
		.append("WHERE rowid_funcionario = ? ")
		.append("AND rowid_exame = ? ")
		.append("AND dt_exame = ?");
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	try(
		Connection con = getConexao();
		PreparedStatement ps = con.prepareStatement(query.toString());
	) {
	    int i = 1;
	    ps.setString(i++, exameRealizadoVo.getFuncionarioVo().getRowid());
	    ps.setString(i++, exameRealizadoVo.getExameVo().getRowid());
	    ps.setString(i, formatter.format(exameRealizadoVo.getDataExame()));
	    ps.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public void updateExameRealizado(ExameRealizadoVo exameRealizadoVo, ExameRealizadoVo novoExame) {
	StringBuilder query = new StringBuilder("UPDATE exame_funcionario ")
		.append("SET rowid_funcionario = ?, rowid_exame = ?, dt_exame = ? ")
		.append("WHERE rowid_funcionario = ? AND rowid_exame = ? AND dt_exame = ?;");
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	try(
		Connection con = getConexao();
		PreparedStatement ps = con.prepareStatement(query.toString());
	) {
	    int i = 1;    
		ps.setString(i++, novoExame.getFuncionarioVo().getRowid());
		ps.setString(i++, novoExame.getExameVo().getRowid());
		ps.setString(i++, formatter.format(novoExame.getDataExame()));

		ps.setString(i++, exameRealizadoVo.getFuncionarioVo().getRowid());
		ps.setString(i++, exameRealizadoVo.getExameVo().getRowid());
		ps.setString(i, formatter.format(exameRealizadoVo.getDataExame()));
		ps.executeUpdate();	    
	    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public ExameRealizadoVo findByCodigo(String codigo) {
	List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
	ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
	StringBuilder query = new StringBuilder("SELECT rowid_funcionario, rowid_exame, dt_exame from exame_funcionario ")
		.append("WHERE rowid_funcionario = ?");
	try(
		Connection con = getConexao();
		PreparedStatement ps = con.prepareStatement(query.toString());
	) {
	    ps.setString(1, codigo);
	    try(ResultSet rs = ps.executeQuery()) {
		FuncionarioVo funcionarioVo = new FuncionarioVo();
		ExameVo exameVo = new ExameVo();
		while(rs.next()) {
		    funcionarioVo.setRowid(rs.getString("rowid_funcionario"));
		    exameVo.setRowid(rs.getString(rs.getString("rowid_exame")));
		    exameRealizadoVo.setDataExame(rs.getDate("dt_exame"));
		    exameRealizadoVo.setExameVo(exameVo);
		    exameRealizadoVo.setFuncionarioVo(funcionarioVo);
		    examesRealizados.add(exameRealizadoVo);
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	return exameRealizadoVo;
    }


    public List<ExameRealizadoVo> filterExamesRealizadosByFuncinarioId(String valorBusca) {
	List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
	StringBuilder query = new StringBuilder("SELECT rowid_funcionario, rowid_exame, dt_exame FROM exame_funcionario ")
		.append("WHERE rowid_funcionario = ?");	
	try(
		Connection con = getConexao();
		PreparedStatement ps = con.prepareStatement(query.toString());
		) {
	    ps.setString(1, valorBusca);
	    try(ResultSet rs = ps.executeQuery()) {
		ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
		FuncionarioVo funcionarioVo = new FuncionarioVo();
		ExameVo exameVo = new ExameVo();
		while(rs.next()) {
		    funcionarioVo.setRowid(rs.getString("rowid_funcionario"));
		    exameVo.setRowid(rs.getString("rowid_exame"));
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

    public List<ExameRealizadoVo> filterExamesRealizadosByExameId(String valorBusca) {
	List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
	StringBuilder query = new StringBuilder("SELECT rowid_funcionario, rowid_exame, dt_exame FROM exame_funcionario ")
		.append("WHERE rowid_exame = ?");	
	try(
		Connection con = getConexao();
		PreparedStatement ps = con.prepareStatement(query.toString());
		) {
	    ps.setString(1, valorBusca);
	    try(ResultSet rs = ps.executeQuery()) {
		ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
		FuncionarioVo funcionarioVo = new FuncionarioVo();
		ExameVo exameVo = new ExameVo();
		while(rs.next()) {
		    funcionarioVo.setRowid(rs.getString("rowid_funcionario"));
		    exameVo.setRowid(rs.getString("rowid_exame"));
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
