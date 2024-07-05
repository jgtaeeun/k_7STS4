package edu.pnu.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MemberVO {
	private int id;
	private String pass;
	private String name;
	private Date regidate;
}
