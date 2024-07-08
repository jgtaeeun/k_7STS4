package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import edu.pnu.domain.LogDTO;

public class LogDao {
	private Connection con;
	public LogDao() throws SQLException   {
		//db와 연결
		
		String url="jdbc:mysql://localhost:3306/musthave";
		
		con=DriverManager.getConnection(url, "scott","tiger");
		
	}
	public int addLog(Map<String, String> param) throws SQLException{
		
		
		LogDTO logdto = new LogDTO();
		logdto.setSqlstring(param.get("sqlstring"));
		logdto.setMethod(param.get("method"));
		
		PreparedStatement pt =null;
		int rs =0;
		String query = "INSERT INTO dblog (method, sqlstring) VALUES (?, ?)";

		pt=con.prepareStatement(query);
		pt.setString(1,  logdto.getMethod());
		pt.setString(2, logdto.getSqlstring());
		
		rs=pt.executeUpdate();
		//	System.out.println(result);
		
		pt.close();
	
		if (rs == 1) return 1;
		else return 0;
	}
}
