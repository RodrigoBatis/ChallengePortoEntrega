package br.com.porto.resource;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.ws.rs.Path;

import br.com.porto.beans.OrdemServico;
import br.com.porto.bo.OrdemServicoBo;

@Path("/ordemServico")
public class OrdemServicoResources {

	private OrdemServicoBo ordemServicoBo = new OrdemServicoBo();

	public ArrayList<OrdemServico> selecionar() throws ClassNotFoundException, SQLException, ParseException {
		return (ArrayList<OrdemServico>) ordemServicoBo.selecionarBO();
	}
	
}
