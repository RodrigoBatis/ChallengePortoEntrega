package br.com.porto.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Path;

import br.com.porto.beans.Administrador;
import br.com.porto.bo.AdministradorBo;

@Path("/administrador")
public class AdministradorResources {

private AdministradorBo administradorBo = new AdministradorBo();
	
	public ArrayList<Administrador> selecionar() throws ClassNotFoundException, SQLException{
		return (ArrayList<Administrador>) administradorBo.selecionarBO();
	}
	
}
