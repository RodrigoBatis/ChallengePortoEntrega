package br.com.porto.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Path;

import br.com.porto.beans.Cliente;
import br.com.porto.bo.ClienteBo;

@Path("/cliente")
public class ClienteResources {

	private ClienteBo clienteBo = new ClienteBo();

	public ArrayList<Cliente> selecionar() throws ClassNotFoundException, SQLException {
		return (ArrayList<Cliente>) clienteBo.selecionarBO();
	}
	
}
