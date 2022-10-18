package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity 
@Table(name="recruitment")
@Data
public class Recruitment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "event_info")
	private String event_info;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "member_num")
	private Integer member_num;
	
	@Column(name = "deadline")
	private java.sql.Date deadline;
	
	@Column(name = "contact_info")
	private String contact_info;
	
	@Column(name = "created_at")
	private java.sql.Timestamp created_at;
	
	@Column(name = "updated_at")
	private java.sql.Timestamp updated_at;
}
