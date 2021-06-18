package com.callor.score.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ScoreVO {

	Integer sc_seq;
	Integer sc_stnum;
	String sc_subject;
	Integer sc_score;

	
}
