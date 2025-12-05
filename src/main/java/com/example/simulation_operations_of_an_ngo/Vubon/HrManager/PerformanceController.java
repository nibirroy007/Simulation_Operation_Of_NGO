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

public class PerformanceController {

    @FXML
    private TextField EmNameTextField;

    @FXML
    private ComboBox<String> employeeCombobox;

    @FXML
    private TableColumn<Performance, String> employeeIdColumn;

    @FXML
    private TableColumn<Performance, String> employeeName;

    @FXML
    private TableColumn<Performance, String> evaluationPeriodColumn;

    @FXML
    private DatePicker evaluationPeriodDatePicker;

    @FXML
    private TableColumn<Performance, String> performanceScoreColumn;

    @FXML
    private ComboBox<String> performanceScoreCombobox;

    @FXML
    private TableView<Performance> tableview;
    @javafx.fxml.FXML
    public void initialize() {
        employeeCombobox.getItems().addAll("121","122","1212","12345","1111");
        performanceScoreCombobox.getItems().addAll("A","B","C");
        performanceScoreColumn.setCellValueFactory(new PropertyValueFactory<>("performanceScore"));
        evaluationPeriodColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        employeeName.setCellValueFactory(new PropertyValueFactory<>("emplName"));
    }

    @FXML
    void addPerformanceButton(ActionEvent event) {
        tableview.getItems().clear();
        LocalDate date=evaluationPeriodDatePicker.getValue();
        String name=EmNameTextField.getText();
        String id=employeeCombobox.getValue();
        String performance=performanceScoreCombobox.getValue();
        String email=null;
        String password=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("Performance.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Performance y=new Performance(email,password,id,name,date,performance);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(PerformanceController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(PerformanceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    @FXML
    void showPerformancebutton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            Performance y;
            ois = new ObjectInputStream(new FileInputStream("Performance.bin"));
            while (true) {
                y = (Performance) ois.readObject();
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
    public void backButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Vubon/HrManager/hrDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Dashboard");
        window.setScene(scene2);
        window.show();
    }
}
