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

public class PrepareBudgetController {

    @FXML
    private TableColumn<prepareBudget, Integer> allocatedBudgetcolumn;

    @FXML
    private TextField allocatedbudgetextfield;

    @FXML
    private TableColumn<prepareBudget, Integer> budgetIdColumn;

    @FXML
    private TextField budgetIdTextfield;

    @FXML
    private TableColumn<prepareBudget, LocalDate> dateColumn;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TableColumn<prepareBudget, String> projectNameColumn;

    @FXML
    private ComboBox<String> projetNameCombobox;

    @FXML
    private TableView<prepareBudget> tableview;

    @FXML
    private TableColumn<prepareBudget, Integer> useBudgetColumn;

    @FXML
    private TextField usebudgetTextield;

    @javafx.fxml.FXML
    public void initialize() {
        projetNameCombobox.getItems().addAll("Child Education Support Program","Women Empowerment Initiative","Clean Water for All Project","Food for the Homeless Program");
        useBudgetColumn.setCellValueFactory(new PropertyValueFactory<>("usebudget"));
        projectNameColumn.setCellValueFactory(new PropertyValueFactory<>("projectName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        budgetIdColumn.setCellValueFactory(new PropertyValueFactory<>("budgetId"));
        allocatedBudgetcolumn.setCellValueFactory(new PropertyValueFactory<>("allocatedBudget"));
    }

    @FXML
    void AllBududgetbutton(ActionEvent event) {
        tableview.getItems().clear();
        int buId=Integer.parseInt(budgetIdTextfield.getText());
        String name=projetNameCombobox.getValue();
        int alloBud=Integer.parseInt(allocatedbudgetextfield.getText());
        int useBud=Integer.parseInt(usebudgetTextield.getText());
        LocalDate date=datepicker.getValue();
        String email=null;
        String password=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("PrepareBudget.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            prepareBudget y=new prepareBudget(email,password,buId,name,alloBud,useBud,date);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(PrepareBudgetController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(PrepareBudgetController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    @FXML
    void showBudgetButton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            prepareBudget y;
            ois = new ObjectInputStream(new FileInputStream("PrepareBudget.bin"));
            while (true) {
                y = (prepareBudget) ois.readObject();
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
