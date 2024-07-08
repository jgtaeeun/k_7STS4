package edu.pnu.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.LogDTO;

@RestController
public class LogController {
	private Connection con;
	public LogController() throws SQLException {
		String url="jdbc:mysql://localhost:3306/musthave";
		
		con=DriverManager.getConnection(url, "scott","tiger");
	}
	@GetMapping("/Log")
	public List<LogDTO> getAllLog() throws SQLException{
		
		List<LogDTO> list = new Vector<LogDTO>();
		String query = "select * from dblog";
		
		Statement st= null;
		ResultSet rs = null;
		
		st=con.createStatement();
		rs=st.executeQuery(query);
		
		while(rs.next()) {
			LogDTO dto = new LogDTO();
			dto.setId(rs.getInt("id"));
			dto.setMethod(rs.getString("method"));
			dto.setSqlstring(rs.getString("sqlstring"));
			dto.setRegidate(rs.getDate("regidate"));
			dto.setSuccess(rs.getBoolean("success"));
		
			list.add(dto);
		}
		rs.close();
		st.close();
		
		return list;
		
	}
}

