package com.accolite.hiring.demo.entity;

import java.util.Date;

public class Slot {
    private String emailId ;
    private Date slotStartTime;

    public Slot() {
    }

    public Slot(String emailId, Date slotStartTime) {
        this.emailId = emailId;
        this.slotStartTime = slotStartTime;
    }

    public String getEmailId() {
        return emailId;
    }

    public Date getSlotStartTime() {
        return slotStartTime;
    }


}
