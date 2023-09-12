package br.com.porto.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.porto.beans.TipoUsuario;
import br.com.porto.dao.TipoUsuarioDAO;

public class TipoUsuarioInsert {

	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static Long id (String j) {
		return Long.parseLong(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		TipoUsuarioDAO dao = new TipoUsuarioDAO();
		TipoUsuario objTipoUsuario = new TipoUsuario();
		
		objTipoUsuario.setIdTipoUsuario(id("Digite o ID Tipo Usuario: "));
		objTipoUsuario.setNivelAcesso(texto("Digite o Nivel de Acesso: "));
		
		System.out.println(dao.insert(objTipoUsuario));

	}

}
