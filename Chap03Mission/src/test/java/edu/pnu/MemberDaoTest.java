package edu.pnu;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.memberdao.MemberDao;
import edu.pnu.memberdto.MemberDTO;

@SpringBootTest
public class MemberDaoTest {
	@Autowired
	private MemberDao memberdao;
	
	@Test
	public void test() throws SQLException {
		 List<MemberDTO> list = memberdao.getAllMember();
		 
		 for (MemberDTO m : list) {
			 System.out.println(m.toString());
		 }
	}
}	
