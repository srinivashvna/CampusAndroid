package com.campuz.model;

public class SyllabusModel {

    private String chapter;
    private String chapter_title;

    public SyllabusModel(String chapter, String chapter_title) {
        this.chapter = chapter;
        this.chapter_title = chapter_title;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getChapter_title() {
        return chapter_title;
    }

    public void setChapter_title(String chapter_title) {
        this.chapter_title = chapter_title;
    }

}
