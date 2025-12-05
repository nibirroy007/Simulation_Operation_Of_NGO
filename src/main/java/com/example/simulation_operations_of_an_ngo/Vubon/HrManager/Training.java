package com.example.simulation_operations_of_an_ngo.Vubon.HrManager;

import com.example.simulation_operations_of_an_ngo.User;

import java.io.Serializable;

public class Training extends User implements Serializable {
    private int trainId;
    private String programTitle;
    private String trainerName;
    private String trainCategory;
    private String targetGroup;

    public Training(String email, String password, int trainId, String programTitle, String trainerName, String trainCategory, String targetGroup) {
        super(email, password);
        this.trainId = trainId;
        this.programTitle = programTitle;
        this.trainerName = trainerName;
        this.trainCategory = trainCategory;
        this.targetGroup = targetGroup;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getProgramTitle() {
        return programTitle;
    }

    public void setProgramTitle(String programTitle) {
        this.programTitle = programTitle;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainCategory() {
        return trainCategory;
    }

    public void setTrainCategory(String trainCategory) {
        this.trainCategory = trainCategory;
    }

    public String getTargetGroup() {
        return targetGroup;
    }

    public void setTargetGroup(String targetGroup) {
        this.targetGroup = targetGroup;
    }

    @Override
    public String toString() {
        return "Training{" +
                "trainId=" + trainId +
                ", programTitle='" + programTitle + '\'' +
                ", trainerName='" + trainerName + '\'' +
                ", trainCategory='" + trainCategory + '\'' +
                ", targetGroup='" + targetGroup + '\'' +
                '}';
    }
}
