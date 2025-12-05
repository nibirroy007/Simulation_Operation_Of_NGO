package com.example.simulation_operations_of_an_ngo.Nibir.MediaOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class AppointmentController {
    @javafx.fxml.FXML
    private TableColumn colDoctor;
    @javafx.fxml.FXML
    private TableColumn colTime;
    @javafx.fxml.FXML
    private ComboBox appointmentTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn colType;
    @javafx.fxml.FXML
    private ComboBox patientComboBox;
    @javafx.fxml.FXML
    private DatePicker datePicker;
    @javafx.fxml.FXML
    private TextField timeTextField;
    @javafx.fxml.FXML
    private TableColumn colPatient;
    @javafx.fxml.FXML
    private TableColumn colDate;
    @javafx.fxml.FXML
    private TableView appointmentTableView;
    @javafx.fxml.FXML
    private ComboBox doctorComboBox;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void handleNewAppointmentButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleConfirmAppointmentButton(ActionEvent actionEvent) {
    }
}
