package maven.demo.model;

import maven.demo.dao.UsuarioDAO;

/**
 * Código retirado de https://github.com/icei-pucminas/ti2cc.
 * Adaptação por Fernando Campos Silva Dal Maria
 */
public class Usuario {
	private static UsuarioDAO uDAO = new UsuarioDAO();
	private int codigo;
	private String login;
	private String senha;
	private char sexo;
	private static int nextCode = uDAO.getLastCode() + 1;
	
	public Usuario() {
		this.codigo = -1;
		this.login = "";
		this.senha = "";
		this.sexo = '*';
	}
	
	public Usuario(int codigo, String login, String senha, char sexo) {
		this.codigo = codigo;
		this.login = login;
		this.senha = senha;
		this.sexo = sexo;
	}

	public static int getNextCode() {
		return nextCode;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo() {
		this.codigo = getNextCode();
		increment();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public static void increment() {
		nextCode++;
	}
	
	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", login=" + login + ", senha=" + senha + ", sexo=" + sexo + "]";
	}	
}
