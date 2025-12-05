package com.example.simulation_operations_of_an_ngo.Nibir.MediaOfficer;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;

public class  prescriptionMedication extends User implements Serializable {

    private String patientId;
    private String patientName;
    private String gender;
    private String phone;
    private String diagnosis;

    public prescriptionMedication(String email,
                                  String password,
                                  String patientId,
                                  String patientName,
                                  String gender) {
        super(email, password);
        this.patientId = patientId;
        this.patientName = patientName;
        this.gender = gender;
        this.phone = phone;
        this.diagnosis = diagnosis;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "prescriptionMedication{" +
                "patientId='" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
