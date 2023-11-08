package br.com.porto.resource;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.ws.rs.Path;

import br.com.porto.beans.Usuario;
import br.com.porto.bo.UsuarioBo;

@Path("/usuario")
public class UsuarioResources {

	private UsuarioBo usuarioBo = new UsuarioBo();

	public ArrayList<Usuario> selecionar() throws ClassNotFoundException, SQLException, ParseException {
		return (ArrayList<Usuario>) usuarioBo.selecionarBO();
	}
	
}
