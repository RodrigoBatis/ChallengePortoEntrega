package br.com.porto.resource;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.ws.rs.Path;

import br.com.porto.beans.ChatBot;
import br.com.porto.bo.ChatBotBo;

@Path("/chatBot")
public class ChatBotResources {
	
	private ChatBotBo chatBotBo = new ChatBotBo();

	public ArrayList<ChatBot> selecionar() throws ClassNotFoundException, SQLException, ParseException {
		return (ArrayList<ChatBot>) chatBotBo.selecionarBO();
	}
	
}
