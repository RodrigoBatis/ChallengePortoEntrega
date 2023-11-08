package br.com.porto.resource;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.porto.beans.OrdemServico;
import br.com.porto.beans.OrdemServico;
import br.com.porto.bo.OrdemServicoBo;

@Path("/ordemServico")
public class OrdemServicoResources {

	private OrdemServicoBo ordemServicoBo = new OrdemServicoBo();

	// Selecionar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<OrdemServico> selecionar() throws ClassNotFoundException, SQLException, ParseException {
		return (ArrayList<OrdemServico>) ordemServicoBo.selecionarBO();
	}

	// Inserir
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(OrdemServico ordemServico, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		ordemServicoBo.inserirBO(ordemServico);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(ordemServico.getIdOrdemServico()));
		return Response.created(builder.build()).build();
	}

	// Atualizar
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(OrdemServico ordemServico, @PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		ordemServicoBo.atualizarBO(ordemServico);
		return Response.ok().build();
	}

	// Deletar
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) throws ClassNotFoundException, SQLException {
		ordemServicoBo.deletarBO(id);
		return Response.ok().build();
	}

}
