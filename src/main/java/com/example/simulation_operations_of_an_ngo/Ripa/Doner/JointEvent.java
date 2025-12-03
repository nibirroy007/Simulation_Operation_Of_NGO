package com.example.simulation_operations_of_an_ngo.Ripa.Doner;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;
import java.time.LocalDate;

public class JointEvent extends User implements Serializable {
    private String eventType;
    private LocalDate date;
    private String attendedStatus;
    private String description;

    public JointEvent(String email, String password, String eventType, LocalDate date, String attendedStatus, String description) {
        super(email, password);
        this.eventType = eventType;
        this.date = date;
        this.attendedStatus = attendedStatus;
        this.description = description;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAttendedStatus() {
        return attendedStatus;
    }

    public void setAttendedStatus(String attendedStatus) {
        this.attendedStatus = attendedStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "JointEvent{" +
                "eventType='" + eventType + '\'' +
                ", date=" + date +
                ", attendedStatus='" + attendedStatus + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
