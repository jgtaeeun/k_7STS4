package edu.pnu.memberdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.pnu.memberdto.MemberDTO;


@Repository
public class MemberDao {
	private Connection con;
	public MemberDao() throws SQLException {
		//db연결
		String url="jdbc:mysql://localhost:3306/musthave";
		
		con=DriverManager.getConnection(url, "scott","tiger");
	}
	public List<MemberDTO> getAllMember() throws SQLException {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		String query = "select * from h2";
		
		Statement st= null;
		ResultSet rs = null;
		
		st=con.createStatement();
		rs=st.executeQuery(query);
		
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getInt("id"));
			dto.setName(rs.getString("name"));
			dto.setPass(rs.getString("pass"));
			dto.setRegidate(rs.getDate("regidate"));
		
			list.add(dto);
		}
		rs.close();
		st.close();
		
		
		
		return list;
	}
}
