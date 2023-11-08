package br.com.porto.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TipoUsuario {
	
	private Long idTipoUsuario;
	private String nivelAcesso;
	
	public TipoUsuario() {
		super();
	}

	public TipoUsuario(Long idTipoUsuario, String nivelAcesso) {
		super();
		this.idTipoUsuario = idTipoUsuario;
		this.nivelAcesso = nivelAcesso;
	}


	public void setIdTipoUsuario(Long idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	
	public long getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public String getNivelAcesso() {
		return nivelAcesso;
	}


	
	
	//Verificar nivel Usuario
	
}
