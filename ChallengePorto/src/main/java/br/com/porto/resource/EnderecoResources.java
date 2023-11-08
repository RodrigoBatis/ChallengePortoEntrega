package br.com.porto.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Path;

import br.com.porto.beans.Endereco;
import br.com.porto.bo.EnderecoBo;

@Path("/endereco")
public class EnderecoResources {

	private EnderecoBo enderecoBo = new EnderecoBo();

	public ArrayList<Endereco> selecionar() throws ClassNotFoundException, SQLException {
		return (ArrayList<Endereco>) enderecoBo.selecionarBO();
	}

}
