package br.com.profcamila.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="task")
public class Task {

	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String titulo;

	@Column
	private String descricao;

	@Column
	private int prioridade;
	
	@Column
	private String usuario;
	
	@Column
	private int finalizado;
	
	@Column 
	private String usuarioFinal;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getPrioridade() {
		return prioridade;
	}
	
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public int getFinalizado() {
		return finalizado;
	}
	
	public void setFinalizado(int finalizado) {
		this.finalizado = finalizado;
	}
	
	public String getUsuarioFinal() {
		return usuarioFinal;
	}
	
	public void setUsuarioFinal(String usuarioFinal) {
		this.usuarioFinal = usuarioFinal;
	}
}
