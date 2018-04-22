package com.campuz.model;

public class NotificationModel {

    String notification_msg;

    public NotificationModel(String notification_msg) {
        this.notification_msg = notification_msg;
    }

    public String getNotification_msg() {
        return notification_msg;
    }

    public void setNotification_msg(String notification_msg) {
        this.notification_msg = notification_msg;
    }
}
