package com.example.simulation_operations_of_an_ngo.Ripa.Doner;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;

public class Contact extends User implements Serializable {
    private int messId;
    private int donarId;
    private String resNAme;
    private String messageBody;
    private String subject;

    public Contact(String email, String password, int messId, int donarId, String resNAme, String messageBody, String subject) {
        super(email, password);
        this.messId = messId;
        this.donarId = donarId;
        this.resNAme = resNAme;
        this.messageBody = messageBody;
        this.subject = subject;
    }

    public int getMessId() {
        return messId;
    }

    public void setMessId(int messId) {
        this.messId = messId;
    }

    public int getDonarId() {
        return donarId;
    }

    public void setDonarId(int donarId) {
        this.donarId = donarId;
    }

    public String getResNAme() {
        return resNAme;
    }

    public void setResNAme(String resNAme) {
        this.resNAme = resNAme;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "messId=" + messId +
                ", donarId=" + donarId +
                ", resNAme='" + resNAme + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
