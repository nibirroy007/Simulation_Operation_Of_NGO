package com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuditController {

    @FXML
    private TableColumn<Audit, LocalDate> auditDateColumn;

    @FXML
    private TableColumn<Audit, Integer> auditIdColumn;

    @FXML
    private TextField auditName;

    @FXML
    private TableColumn<Audit, String> auditNameColumn;

    @FXML
    private TextField auditStatusTextField;

    @FXML
    private TableColumn<Audit, String> auditStatuscolumn;

    @FXML
    private TextField auditTextfield;

    @FXML
    private DatePicker auditadatePicker;

    @FXML
    private TableView<Audit> tableview;

    @javafx.fxml.FXML
    public void initialize() {
        auditStatuscolumn.setCellValueFactory(new PropertyValueFactory<>("auditStatus"));
        auditNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        auditIdColumn.setCellValueFactory(new PropertyValueFactory<>("auditId"));
        auditDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @FXML
    void viewAllButton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();
    }

    @FXML
    void viewReportButton(ActionEvent event) {
        tableview.getItems().clear();
        String auditorName=auditName.getText();
        String status=auditStatusTextField.getText();
        LocalDate date=auditadatePicker.getValue();
        int audit=Integer.parseInt(auditTextfield.getText());
        String email=null;
        String password=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("AuditAndCompliance.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Audit y=new Audit(email,password,audit,auditorName,date,status);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(AuditController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(AuditController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            Audit y;
            ois = new ObjectInputStream(new FileInputStream("AuditAndCompliance.bin"));
            while (true) {
                y = (Audit) ois.readObject();
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

}
