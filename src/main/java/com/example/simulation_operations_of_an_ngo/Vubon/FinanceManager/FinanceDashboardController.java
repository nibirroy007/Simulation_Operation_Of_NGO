package com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FinanceDashboardController {

    @FXML
    void ApproveTransactionButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Vubon/FinanceManager/approveTransaction.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Approve Transaction");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void auditandComplianceButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Vubon/FinanceManager/audit.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Generate Report");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void generateReportButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Vubon/FinanceManager/generateReport.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Generate Report");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void generatereportButtton(ActionEvent event) {

    }

    @FXML
    void managedonationButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Vubon/FinanceManager/manageDonation.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("ManageDonation");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void prepareBudgetbutton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Vubon/FinanceManager/prepareBudget.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("PrepareBudget");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void projectmanagerfundallocationbutton(ActionEvent event) {

    }

    @FXML
    void trackBalancesButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Vubon/FinanceManager/trackBlance.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Track Balance");
        window.setScene(scene2);
        window.show();

    }

}
