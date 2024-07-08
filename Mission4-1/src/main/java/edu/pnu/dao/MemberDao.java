package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import edu.pnu.domain.MemberDTO;

public class MemberDao {

	private LogDao logdao;
	private Map<String, String> param ;
	private Connection con;
	public MemberDao() throws SQLException  {
		//db와 연결
		
		String url="jdbc:mysql://localhost:3306/musthave";
		
		con=DriverManager.getConnection(url, "scott","tiger");
		param=new HashMap<String, String>();
		logdao=new LogDao();
	}
	
	//db정보 다 가져오기
	public List<MemberDTO> getAllMember() throws SQLException{
		List<MemberDTO> list = new Vector<MemberDTO>();
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
		param.put("sqlstring",query);
		param.put("method", "Get");
		logdao.addLog(param);
		return list;
	}
	//선택한 것만
	public MemberDTO getMemberById(int id) throws SQLException{
	
		MemberDTO dto = new MemberDTO();
		
		String query = "select * from h2 where id =?";
		
		PreparedStatement pt =null;
		ResultSet rs = null;
		
		pt=con.prepareStatement(query);
		pt.setInt(1, id);
		rs=pt.executeQuery();
		query=pt.toString().split(":")[1];
		while(rs.next()) {
			
			dto.setId(rs.getInt("id"));
			dto.setName(rs.getString("name"));
			dto.setPass(rs.getString("pass"));
			dto.setRegidate(rs.getDate("regidate"));
		}
		rs.close();
		pt.close();
		param.put("sqlstring",query);
		param.put("method", "Get");
		logdao.addLog(param);
		return dto;
	}
	//추가
	public MemberDTO  addMember(MemberDTO m) throws SQLException{
		
		PreparedStatement pt =null;
		int rs =0;
		String query = "INSERT INTO h2 (id, pass, name) VALUES (?,  ?, ?)";

		pt=con.prepareStatement(query);
		pt.setInt(1, m.getId());
		pt.setString(2, m.getPass());
		pt.setString(3,m.getName());
		
		rs=pt.executeUpdate();
		//	System.out.println(result);
		query=pt.toString().split(":")[1];
		pt.close();
		param.put("sqlstring",query);
		param.put("method", "Put");
		logdao.addLog(param);
		
		m.setRegidate(new Date());
			
		if (rs == 1) return m;
		else return null;
	}
	//업데이트
	public int  updateMember(MemberDTO membervo) throws SQLException{
		int result ;
		PreparedStatement pt =null;
		
		String query = "update h2 set pass = ?, name = ?  where id = ?";
	
		pt=con.prepareStatement(query);
		pt.setString(1, membervo.getPass());
		pt.setString(2,membervo.getName());
		pt.setInt(3,membervo.getId());
			
		result =pt.executeUpdate();
		query=pt.toString().split(":")[1];
		pt.close();
			
		param.put("sqlstring",query);
		param.put("method", "Post");
		logdao.addLog(param);
		
		if (result == 1) return 1;
		else return 0;
	}
	//삭제
	public int removeMember(int id) throws SQLException {
		int result;
		PreparedStatement pt =null;
		
		String query = "delete from h2 where id = ?";
		pt=con.prepareStatement(query);
		pt.setInt(1, id);
			
		result =pt.executeUpdate();
		query=pt.toString().split(":")[1];	
		pt.close();
		param.put("sqlstring",query);
		param.put("method", "Delete");
		logdao.addLog(param);
		if (result == 1) return 1;
		else return 0;
	}
}
