package com.example.demo.form;

import com.example.demo.entity.Recruitment;
import com.example.demo.utils.DateUtils;

import lombok.Data;

@Data
public class RecruitmentForm {

    private String name;
    private String eventInfo;
    private String comment;
    private int memberNum;
    private String deadline;
    private String contactInfo;

    //入力データからEntityを生成して返す
    public Recruitment toEntity() {
        Recruitment recruitment = new Recruitment();

        recruitment.setName(name);
        recruitment.setEventInfo(eventInfo);
        recruitment.setComment(comment);
        recruitment.setMemberNum(memberNum);
        recruitment.setDeadline(DateUtils.strToDate(deadline.replace("/", "-")));
        recruitment.setContactInfo(contactInfo);

        java.util.Date date= new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());

        recruitment.setCreatedAt(timestamp);
        recruitment.setUpdatedAt(timestamp);

        return recruitment;
    }
}
