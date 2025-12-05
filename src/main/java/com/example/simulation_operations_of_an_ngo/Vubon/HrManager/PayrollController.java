package com.example.simulation_operations_of_an_ngo.Vubon.HrManager;

import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PayrollController {

    @FXML
    private DatePicker auditDate;

    @FXML
    private TableColumn<Payroll, Integer> auditIdColumn;

    @FXML
    private TextField auditIdtextField;

    @FXML
    private TableColumn<Payroll, String> auditNameColumn;

    @FXML
    private TextField auditNameTextfield;

    @FXML
    private TextField auditOrgTextField;

    @FXML
    private ComboBox<String> auditTypeCombobox;

    @FXML
    private TableColumn<Payroll, String> auditTypecolumn;

    @FXML
    private TableColumn<Payroll, LocalDate> auditdate;

    @FXML
    private TableColumn<Payroll, String> auditorgColumn;

    @FXML
    private TableView<Payroll> tableview;
    @javafx.fxml.FXML
    public void initialize() {
        auditTypeCombobox.getItems().addAll("Internal Audit","External Audit","Financial Audit","HR Audit","Operational Audit");
        auditTypecolumn.setCellValueFactory(new PropertyValueFactory<>("auditType"));
        auditNameColumn.setCellValueFactory(new PropertyValueFactory<>("auName"));
        auditorgColumn.setCellValueFactory(new PropertyValueFactory<>("orgName"));
        auditdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        auditIdColumn.setCellValueFactory(new PropertyValueFactory<>("auId"));
    }

    @FXML
    void addbutton(ActionEvent event) {
        tableview.getItems().clear();
        int auId=Integer.parseInt(auditIdtextField.getText());
        String auName=auditNameTextfield.getText();
        String autype=auditTypeCombobox.getValue();
        LocalDate date=auditDate.getValue();
        String orgType=auditOrgTextField.getText();
        String email = null;
        String password = null;
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Payroll.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            Payroll y = new Payroll(email, password,auId,auName,orgType,autype,date);
            tableview.getItems().add(y);

            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(PayrollController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(PayrollController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Vubon/HrManager/hrDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            Payroll y;
            ois = new ObjectInputStream(new FileInputStream("Payroll.bin"));
            while (true) {
                y = (Payroll) ois.readObject();
                tableview.getItems().add(y);
            }
        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }
    }

    @FXML
    void showall(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }

}
