package com.callor.score.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StuDTO {
	
	String st_num; //	CHAR(8)		primary KEY,
	String st_name;	//VARCHAR(20)	NOT NULL	,
	String st_dept;	//VARCHAR(20)	NOT NULL	,
	String st_grade; //	INT	NOT NULL	,
}
