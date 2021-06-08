package com.callor.jdbc.model;

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
public class AuthorVO {
	
	private Integer au_code;
	private String au_name;
	private String au_tel;
	private String au_addr;
	private String au_genre;


}
