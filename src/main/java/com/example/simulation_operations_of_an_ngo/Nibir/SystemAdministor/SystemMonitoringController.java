package com.example.simulation_operations_of_an_ngo.Nibir.SystemAdministor;

public class SystemMonitoringController {
    @javafx.fxml.FXML
    private TextField memoryThresholdTextField;
    @javafx.fxml.FXML
    private TableColumn colCurrentValue;
    @javafx.fxml.FXML
    private TableColumn colMetric;
    @javafx.fxml.FXML
    private ComboBox nodeComboBox;
    @javafx.fxml.FXML
    private TextField cpuThresholdTextField;
    @javafx.fxml.FXML
    private Label activityLogLabel;
    @javafx.fxml.FXML
    private TextField bandwidthThresholdTextField;
    @javafx.fxml.FXML
    private TableColumn colAverage;
    @javafx.fxml.FXML
    private TableColumn colMax;
    @javafx.fxml.FXML
    private TableView metricsTableView;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void handleSetThresholdsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLoadMetricsButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleExportReportButton(ActionEvent actionEvent) {
    }
}
