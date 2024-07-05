package edu.pnu.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class MemberDTO {
	private int id;
	private String name;
	private String pass;
	private Date regidate;
}
