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

public class GenerateReportController {

    @FXML
    private TableColumn<GenerateReport, LocalDate> dateColumn;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TextField incomeTextField;

    @FXML
    private TableColumn<GenerateReport, Integer> monthlyCollumn;

    @FXML
    private TextField monthlyTextfield;

    @FXML
    private ComboBox<String> reportCombobox;

    @FXML
    private TextField reportIdTextfield;

    @FXML
    private TableColumn<GenerateReport, String> reportTypeColumn;

    @FXML
    private TableView<GenerateReport> tableview;

    @FXML
    private TextField totalExpense;

    @FXML
    private TableColumn<GenerateReport, Integer> totalcolumn;

    @FXML
    private TextField yarlyTextField;

    @FXML
    private TableColumn<GenerateReport, Integer> yearlyColumn;

    @javafx.fxml.FXML
    public void initialize() {
        reportCombobox.getItems().addAll("Project-wise Budget Utilization Report","Expense Distribution Report","Department-wise Financial Report","Audit and Compliance Report");
        totalcolumn.setCellValueFactory(new PropertyValueFactory<>("income"));
        reportTypeColumn.setCellValueFactory(new PropertyValueFactory<>("reporttypr"));
        yearlyColumn.setCellValueFactory(new PropertyValueFactory<>("yearly"));
        monthlyCollumn.setCellValueFactory(new PropertyValueFactory<>("monthly"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @FXML
    void allBbutton(ActionEvent event) {
        tableview.getItems().clear();
        String type=reportCombobox.getValue();
        int id=Integer.parseInt(reportIdTextfield.getText());
        int mont=Integer.parseInt(monthlyTextfield.getText());
        int yearly=Integer.parseInt(yarlyTextField.getText());
        int income=Integer.parseInt(totalExpense.getText());
        int expense=Integer.parseInt(incomeTextField.getText());
        LocalDate date=datepicker.getValue();
        String email=null;
        String password=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("GenerateReport.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            GenerateReport y=new GenerateReport(email,password,id,type,yearly,mont,income,expense,date);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(GenerateReportController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(GenerateReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    void generatebutton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            GenerateReport y;
            ois = new ObjectInputStream(new FileInputStream("GenerateReport.bin"));
            while (true) {
                y = (GenerateReport) ois.readObject();
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
