package com.example.simulation_operations_of_an_ngo.Ripa.Doner;
import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.Approve;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.AppendableObjectOutPutStream;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MakeDonationController {

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableColumn<MakeDonation, LocalDate> datecolumn;

    @FXML
    private TextField donRidtEXTFIELD;

    @FXML
    private TableColumn<MakeDonation, Integer> donarIdColumn;

    @FXML
    private TextField donationIdTextfield;

    @FXML
    private TableColumn<MakeDonation, String> donationTypeColumn;

    @FXML
    private ComboBox<String> donationtypeCombobox;

    @FXML
    private TableColumn<MakeDonation, String> paymentMethodColumn;

    @FXML
    private TableColumn<MakeDonation, MakeDonation> projectNameColumn;

    @FXML
    private ComboBox<String> projectNameNamecombobbox;

    @FXML
    private TableView<MakeDonation> tableview;
    @FXML
    private ComboBox<String> paymentMethhodCombobox;

    @javafx.fxml.FXML
    public void initialize() {
        projectNameColumn.setCellValueFactory(new PropertyValueFactory<>("projectName"));
        paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        donationTypeColumn.setCellValueFactory(new PropertyValueFactory<>("donationType"));
        donarIdColumn.setCellValueFactory(new PropertyValueFactory<>("donarId"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        projectNameNamecombobbox.getItems().addAll("Clean Water Project","Women Empowerment","Disaster Relief","Food Distribution Program");
        donationtypeCombobox.getItems().addAll("Money","Goods","Food Supplies","Medical Supplies");
        paymentMethhodCombobox.getItems().addAll("Bkash","Nagad","Cash","Card");
    }

    @FXML
    void makedonationbutton(ActionEvent event) {
        int donId=Integer.parseInt(donationIdTextfield.getText());
        int donarId=Integer.parseInt(donRidtEXTFIELD.getText());
        LocalDate date=datePicker.getValue();
        String donType=donationtypeCombobox.getValue();
        String pay=paymentMethhodCombobox.getValue();
        String proName=projectNameNamecombobbox.getValue();
        String email=null;
        String pass=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("MakeDonation.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            MakeDonation y=new MakeDonation(email,pass,donId,donarId,donType,pay,proName,date);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(MakeDonationController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(MakeDonationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    void showAllDonationButton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            MakeDonation y;
            ois = new ObjectInputStream(new FileInputStream("MakeDonation.bin"));
            while (true) {
                y = (MakeDonation) ois.readObject();
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
    public void backbutton(ActionEvent actionEvent) {
    }
}
