package br.com.profcamila.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.profcamila.data.Task;

public class TaskDao {

	private static SessionFactory session = null;
	
	public TaskDao() {
		session = HibernateUtil.getSessionFactory();		
	}
	
	public Integer salvar(Task task){
		Session ses = session.openSession();
		Transaction tx = null;
		Integer id = null;
		try{
			tx = ses.beginTransaction();
			id = (Integer) ses.save(task);
			tx.commit();			
		}catch(HibernateException e){
			if (tx != null){
				tx.rollback();
				System.out.println("Erro: "+ e);
			}
		}finally{
			ses.close();			
		}
		
		return id;
	}

	public List<Task> listarTasks(){
		List<Task> tasks = null;
		
		Session ses = session.openSession();
		Transaction tx = null;
		
		try{
			tx = ses.beginTransaction();
			List lista = ses.createCriteria(Task.class).list();
			tx.commit();
			tasks = new ArrayList<Task>();
			
			for(Object o : lista){
				Task u = (Task) o; 
				tasks.add(u);
			}
		}catch(HibernateException e){
			if(tx != null){
				tx.rollback();
			}
		}finally{
			ses.close();
		}
		
		return tasks;
	}

	public Task obterTaskId(int id){

		Task task = null;
		
		Session ses = session.openSession();
		Transaction tx = null;
		Criteria criteria = null;
		
		try{
			tx = ses.beginTransaction();
			
			criteria = ses.createCriteria(Task.class);
			criteria.add(Restrictions.eq("id", id));
			task = (Task) criteria.uniqueResult();
			
			tx.commit();

		}catch(HibernateException e){
			if(tx != null){
				tx.rollback();
			}
		}finally{
			ses.close();
		}
		
		return task;
	}
	
	public void alterar(Task task){
		Session ses = session.openSession();
		Transaction tx = null;
		try{
			tx = ses.beginTransaction();
			ses.update(task);
			tx.commit();			
		}catch(HibernateException e){
			if (tx != null){
				tx.rollback();
				System.out.println("Erro: "+ e);
			}
		}finally{
			ses.close();			
		}
		
	}
	
	
	public void deletar(int id){
		Session ses = session.openSession();
		Transaction tx = null;
		try{
			tx = ses.beginTransaction();
			Task task = (Task) ses.byId(Task.class).load(id);
			ses.delete(task);
			tx.commit();			
		}catch(HibernateException e){
			if (tx != null){
				tx.rollback();
				System.out.println("Erro: "+ e);
			}
		}finally{
			ses.close();			
		}
		
	}

	public List<Task> obterTaskTitulo(String titulo){

		List<Task> tasks = null;
		
		Session ses = session.openSession();
		Transaction tx = null;
		Criteria criteria = null;
		
		try{
			tx = ses.beginTransaction();
			
			criteria = ses.createCriteria(Task.class);
			criteria.add(Restrictions.ilike("title", titulo));
			criteria.addOrder(Order.asc("title"));
			List lista = criteria.list();
			tasks = new ArrayList<Task>();
			
			for(Object o : lista){
				Task u = (Task) o; 
				tasks.add(u);
			}
			tx.commit();

		}catch(HibernateException e){
			if(tx != null){
				tx.rollback();
			}
		}finally{
			ses.close();
		}
		
		return tasks;
	}

}
