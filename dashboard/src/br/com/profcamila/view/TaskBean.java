package br.com.profcamila.view;

import java.util.ArrayList;
import java.util.List;

import br.com.profcamila.dao.TaskDao;
import br.com.profcamila.data.Task;

public class TaskBean {

	private Task task;
	private List<Task> listaTasks;
	private TaskDao taskDao;
	
	private String titulo;
	
	public String novo() {
		
		this.task = new Task();
		
		return "novo";
	}
	
	public String listar() {
		
		setListaTasks(getTaskDao().listarTasks());
		
		return "lista";
	}
	
	public String salvar() {

		if(getTask().getId() == 0) {
			getTaskDao().salvar(task);			
		}else {
			getTaskDao().alterar(task);
		}
		
		return "lista";
	}
	
	public String alterar() {
		System.out.println("Alterar");
		return "novo";
	}
	
	public String excluir() {
		System.out.println("Excluir");
		getTaskDao().deletar(task.getId());
		
		return null;
	}
	
	public Task getTask() {
		return task;
	}
	
	public void setTask(Task task) {
		this.task = task;
	}
	
	public List<Task> getListaTasks() {
		if(listaTasks == null) {
			listaTasks = new ArrayList<Task>();
		}
		return listaTasks;
	}
	
	public void setListaTasks(List<Task> listaTasks) {
		this.listaTasks = listaTasks;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public TaskDao getTaskDao() {
		if(taskDao == null) {
			taskDao = new TaskDao();
		}
		return taskDao;
	}
	
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}
}
