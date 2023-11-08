package br.com.porto.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Path;

import br.com.porto.beans.CategoriaTarifaria;
import br.com.porto.bo.CategoriaTarifariaBo;

@Path("/categoriaTarifaria")
public class CategoriaTarifariaResources {

	private CategoriaTarifariaBo categoriaTarifariaBo = new CategoriaTarifariaBo();

	public ArrayList<CategoriaTarifaria> selecionar() throws ClassNotFoundException, SQLException {
		return (ArrayList<CategoriaTarifaria>) categoriaTarifariaBo.selecionarBO();
	}
	
}
