package com.example.simulation_operations_of_an_ngo.Nibir.SystemAdministor;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ServerMaintenanceController {
    @javafx.fxml.FXML
    private TableView serverStatusTableView;
    @javafx.fxml.FXML
    private TableColumn colMemory;
    @javafx.fxml.FXML
    private TableColumn colCpu;
    @javafx.fxml.FXML
    private TableColumn colDisk;
    @javafx.fxml.FXML
    private TableColumn colServerName;
    @javafx.fxml.FXML
    private TextArea diagnosticsTextArea;
    @javafx.fxml.FXML
    private ListView serverListView;
    @javafx.fxml.FXML
    private Label repairStatusLabel;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void handleSubmitRepairsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleHealthCheckButton(ActionEvent actionEvent) {
    }
}
