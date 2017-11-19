package br.com.profcamila.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import br.com.profcamila.dao.ArquivoDao;
import br.com.profcamila.dao.TaskDao;
import br.com.profcamila.data.Arquivo;
import br.com.profcamila.data.Task;

public class TaskService {
	
	private TaskDao taskDao;
	private ArquivoDao arquivoDao;
	
	public void salvar(Task task, List<UploadedFile> arquivos) {

		if(task.getId() == 0) {
			task.setId(getTaskDao().salvar(task));	
			
			for(UploadedFile file : arquivos) {
				Arquivo arq = new Arquivo();
				arq.setTask(task);
				InputStream input;
				Blob blob = null;
				byte[] content;
				
				try {
					input = file.getInputStream();				
					content = IOUtils.toByteArray(input);
					blob = new SerialBlob(content);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SerialException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				arq.setArquivo(blob);
				
				getArquivoDao().salvar(arq);
				
			}
		}else {
			getTaskDao().alterar(task);
		}
		
	}
	
	public List<Task> listar() {
		
		return getTaskDao().listarTasks();
		
	}
	
	public void excluir(Task task) {

		getTaskDao().deletar(task.getId());
		
	}
	
	public void concluir(Task task, String email) {
		task.setFinalizado(1);
		task.setUsuarioFinal(email);
		getTaskDao().alterar(task);
	}
	
	public TaskDao getTaskDao() {
		if(this.taskDao == null) {
			this.taskDao = new TaskDao();
		}
		return taskDao;
	}
	
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}
	
	public ArquivoDao getArquivoDao() {
		if(this.arquivoDao == null) {
			this.arquivoDao = new ArquivoDao();
		}
		return arquivoDao;
	}
	
	public void setArquivoDao(ArquivoDao arquivoDao) {
		this.arquivoDao = arquivoDao;
	}
}
