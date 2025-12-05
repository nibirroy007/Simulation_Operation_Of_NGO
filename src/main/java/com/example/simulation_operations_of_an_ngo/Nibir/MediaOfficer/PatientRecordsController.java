package com.example.simulation_operations_of_an_ngo.Nibir.MediaOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PatientRecordsController {
    @javafx.fxml.FXML
    private TextField patientIdTextField;
    @javafx.fxml.FXML
    private TextField diagnosisTextField;
    @javafx.fxml.FXML
    private TextField phoneTextField;
    @javafx.fxml.FXML
    private TableColumn colGender;
    @javafx.fxml.FXML
    private TableColumn colPhone;
    @javafx.fxml.FXML
    private ComboBox filterGenderComboBox;
    @javafx.fxml.FXML
    private TextField searchTextField;
    @javafx.fxml.FXML
    private TableView patientTableView;
    @javafx.fxml.FXML
    private TableColumn colPatientId;
    @javafx.fxml.FXML
    private TableColumn colPatientName;
    @javafx.fxml.FXML
    private TableColumn colDiagnosis;
    @javafx.fxml.FXML
    private ComboBox genderComboBox;
    @javafx.fxml.FXML
    private TextField treatmentTextField;
    @javafx.fxml.FXML
    private TableColumn colTreatment;
    @javafx.fxml.FXML
    private TextField patientNameTextField;

    @javafx.fxml.FXML
    public void handleSaveButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleNewRecordButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleFilterButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleShowAllButton(ActionEvent actionEvent) {
    }
}
