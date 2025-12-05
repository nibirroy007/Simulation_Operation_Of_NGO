package com.example.simulation_operations_of_an_ngo.Nibir.SystemAdministor;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class SoftwareUpdateController {
    @javafx.fxml.FXML
    private CheckBox restartRequiredCheckBox;
    @javafx.fxml.FXML
    private TableColumn colSelected;
    @javafx.fxml.FXML
    private TableColumn colComponent;
    @javafx.fxml.FXML
    private TableColumn colCurrentVersion;
    @javafx.fxml.FXML
    private TableColumn colImportance;
    @javafx.fxml.FXML
    private TextField selectedComponentsTextField;
    @javafx.fxml.FXML
    private Label updateLogLabel;
    @javafx.fxml.FXML
    private TableView updateTableView;
    @javafx.fxml.FXML
    private TableColumn colNewVersion;

    @javafx.fxml.FXML
    public void handleCheckUpdatesButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleRunUpdateButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleValidateCompatibilityButton(ActionEvent actionEvent) {
    }
}
