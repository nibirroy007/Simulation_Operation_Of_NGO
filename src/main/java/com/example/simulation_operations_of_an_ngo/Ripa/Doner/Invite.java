package com.example.simulation_operations_of_an_ngo.Ripa.Doner;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;
import java.time.LocalDate;

public class Invite extends User implements Serializable {
    private int refId;
    private String inviteMAil;
    private String inviteNAme;
    private LocalDate date;
    private String relType;

    public Invite(String email, String password, int refId, String inviteMAil, String inviteNAme, LocalDate date, String relType) {
        super(email, password);
        this.refId = refId;
        this.inviteMAil = inviteMAil;
        this.inviteNAme = inviteNAme;
        this.date = date;
        this.relType = relType;
    }

    public int getRefId() {
        return refId;
    }

    public void setRefId(int refId) {
        this.refId = refId;
    }

    public String getInviteMAil() {
        return inviteMAil;
    }

    public void setInviteMAil(String inviteMAil) {
        this.inviteMAil = inviteMAil;
    }

    public String getInviteNAme() {
        return inviteNAme;
    }

    public void setInviteNAme(String inviteNAme) {
        this.inviteNAme = inviteNAme;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getRelType() {
        return relType;
    }

    public void setRelType(String relType) {
        this.relType = relType;
    }

    @Override
    public String toString() {
        return "Invite{" +
                "refId=" + refId +
                ", inviteMAil='" + inviteMAil + '\'' +
                ", inviteNAme='" + inviteNAme + '\'' +
                ", date=" + date +
                ", relType='" + relType + '\'' +
                '}';
    }
}
