package edu.pnu.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LogDTO {
	private int id;
	private String method;
	private String sqlstring;
	private Date regidate;
	private boolean success;
}
