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
public class ViewDTO {
	
	String st_num;
	String st_name;
	String st_dept;
	String st_grade;
	String sc_subject;
	String sc_score;
	String sc_avg;

}
