package com.campuz.model;

public class ExamsModel {

    private String tests;
    private String test_status;

    public ExamsModel(String tests, String test_status) {
        this.tests = tests;
        this.test_status = test_status;
    }

    public String getTests() {
        return tests;
    }

    public void setTests(String tests) {
        this.tests = tests;
    }

    public String getTest_status() {
        return test_status;
    }

    public void setTest_status(String test_status) {
        this.test_status = test_status;
    }
}
