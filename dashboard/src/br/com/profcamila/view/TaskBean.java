package br.com.profcamila.view;

import java.util.ArrayList;
import java.util.List;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import br.com.profcamila.data.Task;
import br.com.profcamila.data.UsuarioLogado;
import br.com.profcamila.service.TaskService;

public class TaskBean {

	private static UsuarioLogado usuario;
	private Task task;
	private List<Task> listaTasks;
	private TaskService taskService;
	private List<UploadedFile> arquivos;
	private UploadedFile arquivo;
	private String arq;
	
	private String titulo;
	
	public String novo() {
		
		this.task = new Task();
		return "novo";
	}
	
	public String listar() {
		
		setListaTasks(getTaskService().listar());
		
		return "lista";
	}
	
	public String salvar() {

		task.setUsuario(usuario.getEmail());
		getTaskService().salvar(task, arquivos);
		setListaTasks(getTaskService().listar());
		
		return "lista";
	}
	
	public void iniciar(String nome, String email) {
		
		usuario = new UsuarioLogado();
		usuario.setUsuario(nome);
		usuario.setEmail(email);
		
	}
	
	public String alterar() {
		System.out.println("Alterar");
		return "novo";
	}
	
	public String excluir() {
		
		System.out.println("Excluir");
		getTaskService().excluir(task);
		
		return null;
	}
	
	public String upload() {
		
		getArquivos().add(arquivo);
		
		return "";
	}
	
	public String concluir() {
		
		getTaskService().concluir(task, usuario.getEmail());
		return "";
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
	
	public TaskService getTaskService() {
		if(taskService == null) {
			taskService = new TaskService();
		}
		return taskService;
	}
	
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	
	public List<UploadedFile> getArquivos() {
		if(this.arquivos == null) {
			this.arquivos = new ArrayList<UploadedFile>();
		}
		return arquivos;
	}
	
	public void setArquivos(List<UploadedFile> arquivos) {
		this.arquivos = arquivos;
	}
	
	public UploadedFile getArquivo() {
		return arquivo;
	}
	
	public void setArquivo(UploadedFile arquivo) {
		this.arquivo = arquivo;
	}
	
	public String getArq() {
		return arq;
	}
	
	public void setArq(String arq) {
		this.arq = arq;
	}
	
	public UsuarioLogado getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioLogado usuario) {
		TaskBean.usuario = usuario;
	}
}
