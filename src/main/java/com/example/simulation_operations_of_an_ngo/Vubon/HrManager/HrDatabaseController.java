package com.example.simulation_operations_of_an_ngo.Vubon.HrManager;

import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HrDatabaseController {

    @FXML
    private TextField emplNameTextfield;

    @FXML
    private TextField employeeIdTextfield;

    @FXML
    private TableColumn<HrDatabase, Integer> employeeIdcolumn;

    @FXML
    private TableColumn<HrDatabase, String> employeeNameColumn;

    @FXML
    private TableColumn<HrDatabase, String> roleColumn;

    @FXML
    private ComboBox<String> rolecombobox;

    @FXML
    private TableColumn<HrDatabase, String> statusColumn;

    @FXML
    private ComboBox<String> statusCombobox;

    @FXML
    private TableView<HrDatabase> tableview;

    @FXML
    private TableColumn<HrDatabase, Integer> volIdColumn;

    @FXML
    private TableColumn<HrDatabase, String> volNameColumn;

    @FXML
    private TextField voleIdtextfield;
    private ArrayList<Numbers> number;

    @javafx.fxml.FXML
    public void initialize() {
        rolecombobox.getItems().addAll("Project Manager", "Finance Manager", "Volunteer", "Field Officer");
        statusCombobox.getItems().addAll("Pending", "Hired", "Onboarded");
        volNameColumn.setCellValueFactory(new PropertyValueFactory<>("volName"));
        volIdColumn.setCellValueFactory(new PropertyValueFactory<>("volId"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        employeeIdcolumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));

    }

    @FXML
    void EmergencyNumberButton(ActionEvent event) {
        number=new ArrayList<>();
        String fireServiceNumber= "102";
        String emergencyNumber="999";
        String dutyOfficer="191";
        String chairman="89";
        String policeNumber="919";
        Numbers temp=new Numbers(fireServiceNumber,emergencyNumber,dutyOfficer,chairman,policeNumber);
        number.add(temp);
        Numbers num = number.get(0);

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Emergency Information");
        a.setHeaderText("Emergency Numbers");
        String content = "Fire Service Number: " + num.getFireServiceNumber() + "\n"
                + "Emergency Number: " + num.getEmergencyNumber() + "\n"
                + "Duty Officer: " + num.getDutyOfficer() + "\n"
                + "Chairman: " + num.getChairman() + "\n"
                + "Police Number: " + num.getPoliceNumber();
        a.setContentText(content);
        a.showAndWait();
    }

    @FXML
    void addDataBasebutton(ActionEvent event) {
        tableview.getItems().clear();
        int id=Integer.parseInt(employeeIdTextfield.getText());
        String name=emplNameTextfield.getText();
        String status=statusCombobox.getValue();
        String role=rolecombobox.getValue();
        int volId=Integer.parseInt(voleIdtextfield.getText());
        String volName=emplNameTextfield.getText();
        String email=null;
        String password=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("HrDatabase.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            HrDatabase y=new HrDatabase(email,password,id,name,status,role,volId,volName);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(HrDatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(HrDatabaseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Vubon/HrManager/hrDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Recruit");
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void showallDataButton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            HrDatabase y;
            ois = new ObjectInputStream(new FileInputStream("HrDatabase.bin"));
            while (true) {
                y = (HrDatabase) ois.readObject();
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
