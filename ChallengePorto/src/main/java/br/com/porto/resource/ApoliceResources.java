package br.com.porto.resource;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.ws.rs.Path;

import br.com.porto.beans.Apolice;
import br.com.porto.bo.ApoliceBo;

@Path("/apolice")
public class ApoliceResources {

	private ApoliceBo apoliceBo = new ApoliceBo();

	public ArrayList<Apolice> selecionar() throws ClassNotFoundException, SQLException, ParseException {
		return (ArrayList<Apolice>) apoliceBo.selecionarBO();
	}
	
}
