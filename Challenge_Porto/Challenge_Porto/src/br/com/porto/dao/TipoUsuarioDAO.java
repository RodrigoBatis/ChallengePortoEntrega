package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.porto.beans.TipoUsuario;
import br.com.porto.conexoes.ConexaoFactory;

public class TipoUsuarioDAO {

	public Connection guinchAppConexao;
	
	public TipoUsuarioDAO() throws ClassNotFoundException, SQLException{
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}
	
	
	// Insert
	
	public String insert (TipoUsuario tipoUsuario) throws SQLException {
		
		PreparedStatement stmt = guinchAppConexao.prepareStatement
				("INSERT INTO T_GPP_TIPO_USUARIO values(?,?)");
			stmt.setLong(1, tipoUsuario.getIdTipoUsuario());
			stmt.setString(2, tipoUsuario.getNivelAcesso());
			stmt.execute();
			stmt.close();
		return "Tipo Usuario cadastrado com Sucesso!!!";
	}
	
	// Delete
	
	public String deletar (TipoUsuario tipoUsuario) throws SQLException{
		
		PreparedStatement stmt = guinchAppConexao.prepareStatement
				("DELETE FROM T_GPP_TIPO_USUARIO WHERE ID_TIPO_USUARIO = ?");
		
		stmt.setLong(1, tipoUsuario.getIdTipoUsuario());
		stmt.executeUpdate();
		stmt.close();
		
		return "Tipo Usuario Deletado com Sucesso!";
	}
	
}
