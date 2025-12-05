package com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageDonationController {

    @FXML
    private TextField approveAmountTextField;

    @FXML
    private TableColumn<ManageDonation, Integer> approveamountColumn;

    @FXML
    private TableColumn<ManageDonation, Integer> projectIdColumn;

    @FXML
    private TextField projectIdTextField;

    @FXML
    private TableColumn<ManageDonation, String> projectNameColumn;

    @FXML
    private TextField projectNameTextField;

    @FXML
    private TextField projectStatusTextfield;

    @FXML
    private TableColumn<ManageDonation, String> projectstatusColumn;

    @FXML
    private TextField requestAmountTextField;

    @FXML
    private TableColumn<ManageDonation, Integer> requestamountColumn;

    @FXML
    private TableView<ManageDonation> tableview;

    @javafx.fxml.FXML
    public void initialize() {
        projectstatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        requestamountColumn.setCellValueFactory(new PropertyValueFactory<>("reqamount"));
        projectNameColumn.setCellValueFactory(new PropertyValueFactory<>("reqNAme"));
        projectIdColumn.setCellValueFactory(new PropertyValueFactory<>("reqId"));
        approveamountColumn.setCellValueFactory(new PropertyValueFactory<>("approvemaount"));

    }

    @FXML
    void currentStatusbutton(ActionEvent event) {
        tableview.getItems().clear();
        int reqAmount=Integer.parseInt(requestAmountTextField.getText());
        String status=projectStatusTextfield.getText();
        String name=projectNameTextField.getText();
        int proId=Integer.parseInt(projectIdTextField.getText());
        int appAmount=Integer.parseInt(approveAmountTextField.getText());
        String email=null;
        String password=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("ManageDonation.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            ManageDonation y=new ManageDonation(email,password,proId,name,appAmount,reqAmount,status);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(ManageDonationController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(ManageDonationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    void showallButton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            ManageDonation y;
            ois = new ObjectInputStream(new FileInputStream("ManageDonation.bin"));
            while (true) {
                y = (ManageDonation) ois.readObject();
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
