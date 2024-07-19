package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository <Board, Long> {
	List<Board> findByTitle(String searchKeyword);
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	List<Board> findByTitleContainingAndContentContaining(String title, String content);
	List<Board> findByTitleContainingOrderBySeqDesc(String title);
	List<Board> findByTitleContaining(String title, Pageable paging);
	
	
	
//	//위치기반 파라미터 사용하기(파라미터 1개)
	@Query("SELECT b FROM Board b WHERE  b.title LIKE %?1% ORDER BY b.seq DESC")
	List<Board> queryAoontationTest1(String searchKeyword);

//	//위치기반 파라미터 사용하기(파라미터 2개)
//	@Query("SELECT b FROM Board b WHERE  b.title LIKE %?1% and b.title LIKE %?2%  ORDER BY b.seq DESC")
//	List<Board> queryAoontationTest1_1(String searchKeyword1,String searchKeyword2);
//	
//	//이름기반 파라미터 사용하기(파라미터 1개)
//	@Query("SELECT b FROM Board b WHERE  b.title LIKE %:searchKeyword%  ORDER BY b.seq DESC")
//	List<Board> queryAoontationTest2(@Param("searchKeyword") String searchKeyword);
//	//특벙변수 조회
//	@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b WHERE  b.title LIKE %?1%  ORDER BY b.seq DESC")
//	List<Object[]> queryAoontationTest3(@Param("searchKeyword") String searchKeyword);
}

