package kr.co.ch07.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

// JPA
@Entity
@Table(name="user6")

public class User6VO {
	
	@Id //JPA
	private String uid;
	private String name;
	private String hp;
	private int age;
	
}
