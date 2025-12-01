package com.example.simulation_operations_of_an_ngo.Ripa.ProjectManager;

import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PerformanceController {

    @FXML
    private TableColumn<Performance, String> evaluationSummaryColumn;

    @FXML
    private TextField evaluationSummaryTextField;

    @FXML
    private TableColumn<Performance, Integer> performanceScoreColumn;

    @FXML
    private TextField performanceTextField;

    @FXML
    private ComboBox<String> projectCombobox;

    @FXML
    private TableColumn<Performance, String> projectNameColumn;

    @FXML
    private TableColumn<Performance, String> reportColumn;

    @FXML
    private ComboBox<String> reportPeriodCombobobx;

    @FXML
    private TextField reviewNAmeTextField;

    @FXML
    private TableColumn<Performance, String> reviewNameColumn;

    @FXML
    private TableView<Performance> tableview;

    @javafx.fxml.FXML
    public void initialize() {
        reviewNameColumn.setCellValueFactory(new PropertyValueFactory<>("reviNAme"));
        reportColumn.setCellValueFactory(new PropertyValueFactory<>("reportPer"));
        projectNameColumn.setCellValueFactory(new PropertyValueFactory<>("proName"));
        performanceScoreColumn.setCellValueFactory(new PropertyValueFactory<>("perSc"));
        evaluationSummaryColumn.setCellValueFactory(new PropertyValueFactory<>("evaSum"));
        projectCombobox.getItems().addAll("Project Manager","Field Officer","Volunteer","Finance Manager","HR Manager");
        reportPeriodCombobobx.getItems().addAll("Morning","Evening","Night");
    }

    @FXML
    void evaluationButton(ActionEvent event) {
        tableview.getItems().clear();
        int perSco=Integer.parseInt(performanceTextField.getText());
        String reviName=reviewNAmeTextField.getText();
        String reportperi=reportPeriodCombobobx.getValue();
        String proje=projectCombobox.getValue();
        String eveSum=evaluationSummaryTextField.getText();
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
            Performance y=new Performance(email,password,perSco,eveSum,reviName,reportperi,proje);
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
    void showAllButton(ActionEvent event) {
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
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Ripa/ProjectManager/projectManagerDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("ContactNgo");
        window.setScene(scene2);
        window.show();
    }
}
