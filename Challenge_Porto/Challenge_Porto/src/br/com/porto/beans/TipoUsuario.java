package br.com.porto.beans;

public class TipoUsuario {
	
	private long idTipoUsuario;
	private String nivelAcesso;
	
	public TipoUsuario() {
		super();
	}

	public TipoUsuario(long idTipoUsuario, String nivelAcesso) {
		super();
		this.idTipoUsuario = idTipoUsuario;
		this.nivelAcesso = nivelAcesso;
	}


	public void setIdTipoUsuario(long idTipoUsuario) {
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
