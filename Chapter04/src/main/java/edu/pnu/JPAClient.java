package edu.pnu;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClient {
	public static void main(String args[]) {
		//EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx= em.getTransaction();
		try {
			tx.begin();
			
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			//글 등록
			em.persist(board);
			
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
