package edu.pnu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClientEdit {
	public static void main(String args[]) {
		//EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx= em.getTransaction();
		try {
			tx.begin();
			
			Board searchBoard=em.find(Board.class, 1L);
			searchBoard.setTitle("수정)JPA제목");
			tx.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			em.close();
			emf.close();
		}
			
	}
}
