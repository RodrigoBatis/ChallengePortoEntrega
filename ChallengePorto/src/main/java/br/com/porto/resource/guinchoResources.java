package br.com.porto.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Path;

import br.com.porto.beans.Guincho;
import br.com.porto.bo.GuinchoBo;

@Path("/guincho")
public class guinchoResources {

	private GuinchoBo guinchoBo = new GuinchoBo();

	public ArrayList<Guincho> selecionar() throws ClassNotFoundException, SQLException {
		return (ArrayList<Guincho>) guinchoBo.selecionarBO();
	}
	
}
