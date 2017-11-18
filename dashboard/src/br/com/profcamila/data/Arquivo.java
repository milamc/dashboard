package br.com.profcamila.data;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Arquivo {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name= "idtask")
	private Task task;
	
	@Column
	private Blob arquivo;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Task getTask() {
		return task;
	}
	
	public void setTask(Task task) {
		this.task = task;
	}
	
	public Blob getArquivo() {
		return arquivo;
	}
	
	public void setArquivo(Blob arquivo) {
		this.arquivo = arquivo;
	}
}
