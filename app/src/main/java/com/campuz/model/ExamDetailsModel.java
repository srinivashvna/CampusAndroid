package com.campuz.model;

public class ExamDetailsModel {

    private String subject_name;
    private String chapter_title;

    public ExamDetailsModel(String subject_name, String chapter_title) {
        this.subject_name = subject_name;
        this.chapter_title = chapter_title;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getChapter_title() {
        return chapter_title;
    }

    public void setChapter_title(String chapter_title) {
        this.chapter_title = chapter_title;
    }

}




