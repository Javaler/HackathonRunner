package com.example.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Recruitment.class)
public abstract class Recruitment_ {

	public static volatile SingularAttribute<Recruitment, Timestamp> createdAt;
	public static volatile SingularAttribute<Recruitment, String> eventInfo;
	public static volatile SingularAttribute<Recruitment, String> contactInfo;
	public static volatile SingularAttribute<Recruitment, String> name;
	public static volatile SingularAttribute<Recruitment, String> comment;
	public static volatile SingularAttribute<Recruitment, Integer> id;
	public static volatile SingularAttribute<Recruitment, Integer> memberNum;
	public static volatile SingularAttribute<Recruitment, Date> deadline;
	public static volatile SingularAttribute<Recruitment, Timestamp> updatedAt;

	public static final String CREATED_AT = "createdAt";
	public static final String EVENT_INFO = "eventInfo";
	public static final String CONTACT_INFO = "contactInfo";
	public static final String NAME = "name";
	public static final String COMMENT = "comment";
	public static final String ID = "id";
	public static final String MEMBER_NUM = "memberNum";
	public static final String DEADLINE = "deadline";
	public static final String UPDATED_AT = "updatedAt";

}

