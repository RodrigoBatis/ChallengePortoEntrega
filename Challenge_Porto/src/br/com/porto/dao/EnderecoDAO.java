package br.com.porto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.porto.beans.Endereco;
import br.com.porto.conexoes.ConexaoFactory;

public class EnderecoDAO {

public Connection guinchAppConexao;
	
	public EnderecoDAO() throws ClassNotFoundException, SQLException{
		super();
		this.guinchAppConexao = new ConexaoFactory().conexao();
	}
	
	// Insert
	
			public String insert (Endereco endereco) throws SQLException {
				
				PreparedStatement stmt = guinchAppConexao.prepareStatement
						("INSERT INTO T_GPP_ENDERECO values(?,?,?,?,?,?)");
					stmt.setLong(1, endereco.getIdEndereco());
					stmt.setString(2, endereco.getLogradouro());
					stmt.setString(3, endereco.getCep());
					stmt.setString(4, endereco.getCidade());
					stmt.setString(5, endereco.getEstado());
					stmt.setString(6, endereco.getBairro());
					stmt.execute();
					stmt.close();
				return "Endereço cadastrado com Sucesso!!!";
			}
	
	// Delete
			
			public String deletar (Endereco endereco) throws SQLException{
				
				PreparedStatement stmt = guinchAppConexao.prepareStatement
						("DELETE FROM T_GPP_ENDERECO WHERE id_endereco = ?");
				
				stmt.setLong(1, endereco.getIdEndereco());
				stmt.executeUpdate();
				stmt.close();
				
				return "Endereço Deletado com Sucesso!";
			}
	
}
