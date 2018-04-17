package com.campuz.model;

/**
 * Created by manikantad on 18-04-2018.
 */

public class DiaryModel {

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(String homeWork) {
        this.homeWork = homeWork;
    }

    private String subject;
    private String homeWork;

    public DiaryModel(String subject, String homeWork) {
        this.subject = subject;
        this.homeWork = homeWork;
    }


}
