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
	
	
	
	
	private Connection con;
	private Map<String, Object> param ;
	private LogDao logdao;
	public MemberDao() throws SQLException  {
		//db와 연결
		
		String url="jdbc:mysql://localhost:3306/musthave";
		
		con=DriverManager.getConnection(url, "scott","tiger");
		
		param=new HashMap<String,Object>();
		
		logdao = new LogDao();
	}
	
	//db정보 다 가져오기
	public Map<String, Object> getAllMember() throws SQLException{
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
		addLog(param);
		param.put("member", list);
		return param;
	}
	//선택한 것만
	public Map<String, Object>  getMemberById(int id) throws SQLException{
	
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
		addLog(param);
		param.put("member", dto);
		return param;
	}
	//추가
	public Map<String,Object>  addMember(MemberDTO m) throws SQLException{
		
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
		
		m.setRegidate(new Date());
			
		param.put("sqlstring",query);
		param.put("method", "Post");
		addLog(param);
		param.put("member",m);
		if (rs == 1) return param;
		else return null;
		
	}
	//업데이트
	public Map<String,Object>  updateMember(MemberDTO membervo) throws SQLException{
		int result ;
		PreparedStatement pt =null;
		
		String query = "update h2 set pass = ?, name = ?  where id = ?";
	
		pt=con.prepareStatement(query);
		pt.setString(1, membervo.getPass());
		pt.setString(2,membervo.getName());
		pt.setInt(3,membervo.getId());
			
		result =pt.executeUpdate();
		query=pt.toString().split(":")[1];
		membervo.setRegidate(new Date());
		pt.close();
			
		param.put("sqlstring",query);
		param.put("method", "Put");
		addLog(param);
		param.put("member",membervo);
		if (result == 1) return param;
		else return null;
	}
	//삭제
	public Map<String, Object> removeMember(int id) throws SQLException {
		int result;
		PreparedStatement pt =null;
		MemberDTO tmp = (MemberDTO) getMemberById(id).get("member");
	
		String query = "delete from h2 where id = ?";
		pt=con.prepareStatement(query);
		pt.setInt(1, id);
			
		result =pt.executeUpdate();
	
		
		query=pt.toString().split(":")[1];
		
		param.put("sqlstring",query);
		param.put("method", "Delete");
		addLog(param);
		param.put("member",tmp);
		pt.close();

		if (result == 1) return param;
		else return null;
	}
	
	//logdao 호출
	public int addLog(Map<String, Object> param) throws SQLException {
		return logdao.addLog(param);
	}
}