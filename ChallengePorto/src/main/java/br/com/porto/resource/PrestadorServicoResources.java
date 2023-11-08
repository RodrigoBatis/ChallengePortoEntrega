package br.com.porto.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Path;

import br.com.porto.beans.PrestadorServico;
import br.com.porto.bo.PrestadorServicoBo;

@Path("/prestadorServico")
public class PrestadorServicoResources {

	private PrestadorServicoBo prestadorServicoBo = new PrestadorServicoBo();

	public ArrayList<PrestadorServico> selecionar() throws ClassNotFoundException, SQLException {
		return (ArrayList<PrestadorServico>) prestadorServicoBo.selecionarBO();
	}
	
}
