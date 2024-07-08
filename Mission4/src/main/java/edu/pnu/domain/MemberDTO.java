package edu.pnu.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
	private String name;
	private int id;
	private String pass;
	private Date regidate;
	
}


