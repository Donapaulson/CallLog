package com.login_page.hp.calllog;

import java.util.Date;

public class callLog {

    String phoneNumber,duration,call_type,date;

    public callLog(String phoneNumber, String date, String duration, String call_type) {
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.duration = duration;
        this.call_type = call_type;
    }

    public callLog(String number, String call_type, Date d, String duration) {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCall_type() {
        return call_type;
    }

    public void setCall_type(String call_type) {
        this.call_type = call_type;
    }
}
