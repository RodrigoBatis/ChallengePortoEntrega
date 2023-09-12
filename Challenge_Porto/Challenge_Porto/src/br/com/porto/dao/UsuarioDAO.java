package br.com.porto.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import br.com.porto.beans.Endereco;
import br.com.porto.beans.Usuario;
import br.com.porto.conexoes.ConexaoFactory;

public class UsuarioDAO {

	public Connection guinchAppConexao;
	
	public UsuarioDAO() throws ClassNotFoundException, SQLException{
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}
	
	// Insert
	
		public String insert (Usuario usuario) throws SQLException {
			
			String format = "dd/MM/yyyy";
			SimpleDateFormat simplesFormat = new SimpleDateFormat(format);
			

			PreparedStatement stmt = guinchAppConexao.prepareStatement
					("INSERT INTO T_GPP_USUARIO values(?,?,?,?,?,?,?,?,?,?)");
				stmt.setLong(1, usuario.getIdUsuario());
				stmt.setLong(2, usuario.getIdEndereco());
				stmt.setLong(3, usuario.getIdTipoUsuario());
				stmt.setString(4, usuario.getNome());
				stmt.setString(5, usuario.getEmail());
				stmt.setString(6, usuario.getCpf());
				String dateFormated = simplesFormat.format(usuario.getDataNascimento());
				stmt.setString(7, dateFormated);
				stmt.setString(8, usuario.getCelular());
				stmt.setString(9, usuario.getSenha());
				dateFormated = simplesFormat.format(usuario.getDataCadastro());
				stmt.setString(10, dateFormated);
				stmt.execute();
				stmt.close();
			return "Usuario cadastrado com Sucesso!!!";
		}
	
	// Delete
		
		public String deletar (Usuario usuario) throws SQLException{
			
			PreparedStatement stmt = guinchAppConexao.prepareStatement
					("DELETE FROM T_GPP_USUARIO WHERE id_usuario = ?");
			
			stmt.setLong(1, usuario.getIdUsuario());
			stmt.executeUpdate();
			stmt.close();
			
			return "Usuario Deletado com Sucesso!";
		}
}
