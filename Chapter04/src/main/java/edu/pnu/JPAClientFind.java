package edu.pnu;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClientFind {
	public static void main(String args[]) {
		//EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		try {
		
			Board searchBoard=em.find(Board.class, 1L);
			System.out.println("--->"+searchBoard.toString());
		
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			em.close();
			emf.close();
		}
			
	}
}
