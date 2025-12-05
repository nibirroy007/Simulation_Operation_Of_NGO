package com.example.simulation_operations_of_an_ngo.Nibir.MediaOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class VaccinationController {
    @javafx.fxml.FXML
    private TableColumn colDateGiven;
    @javafx.fxml.FXML
    private TableColumn colNextDose;
    @javafx.fxml.FXML
    private DatePicker nextDoseDatePicker;
    @javafx.fxml.FXML
    private TableColumn colVaccine;
    @javafx.fxml.FXML
    private TableView vaccinationTableView;
    @javafx.fxml.FXML
    private TextField doseNumberTextField;
    @javafx.fxml.FXML
    private ComboBox patientComboBox;
    @javafx.fxml.FXML
    private DatePicker dateGivenDatePicker;
    @javafx.fxml.FXML
    private TableColumn colDose;
    @javafx.fxml.FXML
    private ComboBox vaccineTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn colPatient;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void handleSaveVaccinationButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleNewBeneficiaryButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleSendReminderButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleViewAnalyticsButton(ActionEvent actionEvent) {
    }
}
