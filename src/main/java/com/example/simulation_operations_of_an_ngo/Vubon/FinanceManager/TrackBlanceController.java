package com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrackBlanceController {

    @FXML
    private ComboBox<String> categoryTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableColumn<TrackBalance, LocalDate> datecolumn;

    @FXML
    private ComboBox<String> expenseCategory;

    @FXML
    private TableColumn<TrackBalance, Integer> expenseColumn;

    @FXML
    private TableColumn<TrackBalance, String> expenseSourceColumn;

    @FXML
    private TextField expenseTextfield;

    @FXML
    private TextField icomeTextField;

    @FXML
    private TableColumn<TrackBalance, Integer> incomeAmountColumn;

    @FXML
    private TableColumn<TrackBalance, String> incomesourceColumn;

    @FXML
    private TableView<TrackBalance> tableview;

    @javafx.fxml.FXML
    public void initialize() {
        expenseCategory.getItems().addAll("Staff Salaries & Wages","Volunteer Allowances","Office Rent & Utilities","Training & Workshops","Transportation & Field Visits");
        categoryTextField.getItems().addAll("Donor Contributions","Government Grants","Corporate Sponsorships","Fundraising Events");
        incomesourceColumn.setCellValueFactory(new PropertyValueFactory<>("incomecategory"));
        incomeAmountColumn.setCellValueFactory(new PropertyValueFactory<>("incomeAmount"));
        expenseSourceColumn.setCellValueFactory(new PropertyValueFactory<>("expenseCategory"));
        expenseColumn.setCellValueFactory(new PropertyValueFactory<>("expenseAmount"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    @FXML
    void addButton(ActionEvent event) {
        tableview.getItems().clear();
        int inAmount=Integer.parseInt(icomeTextField.getText());
        String inSource=categoryTextField.getValue();
        int exAmount=Integer.parseInt(expenseTextfield.getText());
        String exCate=expenseCategory.getValue();
        LocalDate date=datePicker.getValue();
        String email=null;
        String password=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("TrackBalance.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            TrackBalance y=new TrackBalance(email,password,inAmount,inSource,exAmount,exCate,date);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(TrackBlanceController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(TrackBlanceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    @FXML
    void allTrackbutton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            TrackBalance y;
            ois = new ObjectInputStream(new FileInputStream("TrackBalance.bin"));
            while (true) {
                y = (TrackBalance) ois.readObject();
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
