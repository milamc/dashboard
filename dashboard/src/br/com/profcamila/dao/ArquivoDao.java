package br.com.profcamila.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.profcamila.data.Arquivo;

public class ArquivoDao {

	private static SessionFactory session = null;
	
	public ArquivoDao() {
		session = HibernateUtil.getSessionFactory();		
	}
	
	public Integer salvar(Arquivo arq){
		Session ses = session.openSession();
		Transaction tx = null;
		Integer id = null;
		try{
			tx = ses.beginTransaction();
			id = (Integer) ses.save(arq);
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
}
