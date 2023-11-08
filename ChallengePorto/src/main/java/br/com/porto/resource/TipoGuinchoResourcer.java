package br.com.porto.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Path;

import br.com.porto.beans.TipoGuincho;
import br.com.porto.bo.TipoGuinchoBo;

@Path("/tipoGuincho")
public class TipoGuinchoResourcer {

	private TipoGuinchoBo tipoGuinchoBo = new TipoGuinchoBo();

	public ArrayList<TipoGuincho> selecionar() throws ClassNotFoundException, SQLException {
		return (ArrayList<TipoGuincho>) tipoGuinchoBo.selecionarBO();
	}
	
}
