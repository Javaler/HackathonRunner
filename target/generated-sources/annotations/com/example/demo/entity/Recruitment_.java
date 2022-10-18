package com.example.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Recruitment.class)
public abstract class Recruitment_ {

	public static volatile SingularAttribute<Recruitment, String> event_info;
	public static volatile SingularAttribute<Recruitment, Timestamp> updated_at;
	public static volatile SingularAttribute<Recruitment, Integer> member_num;
	public static volatile SingularAttribute<Recruitment, String> name;
	public static volatile SingularAttribute<Recruitment, Timestamp> created_at;
	public static volatile SingularAttribute<Recruitment, String> comment;
	public static volatile SingularAttribute<Recruitment, Integer> id;
	public static volatile SingularAttribute<Recruitment, String> contact_info;
	public static volatile SingularAttribute<Recruitment, Date> deadline;

	public static final String EVENT_INFO = "event_info";
	public static final String UPDATED_AT = "updated_at";
	public static final String MEMBER_NUM = "member_num";
	public static final String NAME = "name";
	public static final String CREATED_AT = "created_at";
	public static final String COMMENT = "comment";
	public static final String ID = "id";
	public static final String CONTACT_INFO = "contact_info";
	public static final String DEADLINE = "deadline";

}

