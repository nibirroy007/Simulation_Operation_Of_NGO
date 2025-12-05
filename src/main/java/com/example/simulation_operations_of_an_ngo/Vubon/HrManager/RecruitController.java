package com.example.simulation_operations_of_an_ngo.Vubon.HrManager;

import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.AppendableObjectOutPutStream;
import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.Approve;
import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.ApproveTransactionController;
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

public class RecruitController {

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableColumn<Recruit, LocalDate> datecolumn;

    @FXML
    private TextField employeeIDTextField;

    @FXML
    private TableColumn<Recruit, Integer> employeeIdColumn;

    @FXML
    private TableColumn<Recruit, String> employeeNameColumn;

    @FXML
    private TextField employeeTextField;

    @FXML
    private TableColumn<Recruit, String> roleColumn;

    @FXML
    private ComboBox<String> roleCombobbox;

    @FXML
    private TableColumn<Recruit, String> statusColumn;

    @FXML
    private ComboBox<String> statusCombobox;

    @FXML
    private TableView<Recruit> tableview;

    @javafx.fxml.FXML
    public void initialize() {
        roleCombobbox.getItems().addAll("Project Manager", "Finance Manager", "Volunteer", "Field Officer");
        statusCombobox.getItems().addAll("Pending", "Hired", "Onboarded");
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));


    }

    @FXML
    void recruitButton(ActionEvent event) {
        tableview.getItems().clear();
        int id=Integer.parseInt(employeeIDTextField.getText());
        LocalDate date=datePicker.getValue();
        String name=employeeTextField.getText();
        String status=statusCombobox.getValue();
        String role=roleCombobbox.getValue();
        String email=null;
        String password=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("Recruit.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Recruit y=new Recruit(email,password,id,name,status,role,date);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(RecruitController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(RecruitController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    void showrecruitButton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            Recruit y;
            ois = new ObjectInputStream(new FileInputStream("Recruit.bin"));
            while (true) {
                y = (Recruit) ois.readObject();
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
        window.setTitle("Recruit");
        window.setScene(scene2);
        window.show();
    }
}
