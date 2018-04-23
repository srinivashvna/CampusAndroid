package com.campuz.model;

public class HolidayModel {

    String holiday_name;

    public String getHoliday_name() {
        return holiday_name;
    }

    public void setHoliday_name(String holiday_name) {
        this.holiday_name = holiday_name;
    }

    public HolidayModel(String holiday_name) {

        this.holiday_name = holiday_name;
    }
}
