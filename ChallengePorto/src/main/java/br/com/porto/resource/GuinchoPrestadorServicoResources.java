package br.com.porto.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Path;

import br.com.porto.beans.GuinchoPrestadorServico;
import br.com.porto.bo.GuinchoPrestadorServicoBo;

@Path("/guinchoPrestadorServico")
public class GuinchoPrestadorServicoResources {
	
	private GuinchoPrestadorServicoBo guinchoPrestadorServicoBo = new GuinchoPrestadorServicoBo();

	public ArrayList<GuinchoPrestadorServico> selecionar() throws ClassNotFoundException, SQLException {
		return (ArrayList<GuinchoPrestadorServico>) guinchoPrestadorServicoBo.selecionarBO();
	}

	
}
