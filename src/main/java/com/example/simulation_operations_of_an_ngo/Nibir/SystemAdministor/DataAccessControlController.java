package com.example.simulation_operations_of_an_ngo.Nibir.SystemAdministor;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class DataAccessControlController {
    @javafx.fxml.FXML
    private CheckBox deleteCheckBox;
    @javafx.fxml.FXML
    private CheckBox readCheckBox;
    @javafx.fxml.FXML
    private ComboBox datasetComboBox;
    @javafx.fxml.FXML
    private TableColumn colTimestamp;
    @javafx.fxml.FXML
    private TableColumn colUser;
    @javafx.fxml.FXML
    private ComboBox userGroupComboBox;
    @javafx.fxml.FXML
    private TableView auditTableView;
    @javafx.fxml.FXML
    private TableColumn colAction;
    @javafx.fxml.FXML
    private TextArea rulesTextArea;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private CheckBox writeCheckBox;

    @javafx.fxml.FXML
    public void handleLoadPermissionsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleApplySaveButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleValidateRulesButton(ActionEvent actionEvent) {
    }
}
