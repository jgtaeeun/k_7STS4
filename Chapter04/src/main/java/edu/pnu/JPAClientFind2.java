package edu.pnu;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.pnu.domain.Board;

public class JPAClientFind2 {
	public static void main(String args[]) {
		//EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		try {
//			String jpql = "select b from Board b order by b.seq desc";.
//			String jpql = "select b from Board b order by  b.createDate ";
//			String jpql = "select b from Board b where b.seq >8";
//			TypedQuery<Board> tq= em.createQuery(jpql, Board.class);
//			List <Board> list = tq.getResultList();
//			
//			for (Board m : list) {
//				System.out.println(m.toString());
//			}
			
			//NativeQuery
//			String sql="select b.title from Board b";
//			Query q= em.createNativeQuery(sql);
//
//			List<String> list= q.getResultList();
//			for(String s : list) {
//				System.out.println(s);
//			}
			
			
			String sql="select b.title, b.content from Board b";
			Query q= em.createNativeQuery(sql);
			
			List<Object[]> list= q.getResultList();
			for(Object[] o : list) {
				System.out.println(o[0] + "," + o[1]);
			
			}
			
			
		
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			em.close();
			emf.close();
		}
			
	}
}
