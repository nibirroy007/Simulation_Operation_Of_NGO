package com.example.simulation_operations_of_an_ngo.Ripa.Doner;

import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.AppendableObjectOutPutStream;
import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.Approve;
import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.ApproveTransactionController;
import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.Audit;
import com.example.simulation_operations_of_an_ngo.Vubon.HrManager.Payroll;
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

public class JoinEventController {

    @FXML
    private ComboBox<String> AttendedStatusCombobox;

    @FXML
    private TableColumn<JointEvent, String> attendedStatusColumn;

    @FXML
    private TableColumn<JointEvent, String> descriptionColumn;

    @FXML
    private TextField descriptionTextfield;

    @FXML
    private TableColumn<JointEvent, LocalDate> eventDateColumn;

    @FXML
    private DatePicker eventDatePicker;

    @FXML
    private TableColumn<JointEvent, String> eventTypeColumn;

    @FXML
    private ComboBox<String> eventTypeCombobox;

    @FXML
    private TableView<JointEvent> tableview;


    @javafx.fxml.FXML
    public void initialize() {
        eventTypeCombobox.getItems().addAll("NGO Event","Annual Donor Meeting","Fundraising Event","Awareness Campaign");
        AttendedStatusCombobox.getItems().addAll("Good","Bad");
        eventTypeColumn.setCellValueFactory(new PropertyValueFactory<>("eventType"));
        eventDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        attendedStatusColumn.setCellValueFactory(new PropertyValueFactory<>("attendedStatus"));
    }

    @FXML
    void joinEventButton(ActionEvent event) {
        tableview.getItems().clear();
        String eventtype=eventTypeCombobox.getValue();
        LocalDate date=eventDatePicker.getValue();
        String des=descriptionTextfield.getText();
        String atten=AttendedStatusCombobox.getValue();
        String email=null;
        String pass=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("jonEvent.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            JointEvent y=new JointEvent(email,pass,eventtype,date,atten,des);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(JoinEventController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(JoinEventController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    void showAllEventButton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();
    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            JointEvent y;
            ois = new ObjectInputStream(new FileInputStream("jonEvent.bin"));
            while (true) {
                y = (JointEvent) ois.readObject();
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
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Ripa/Doner/donarDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Recruit");
        window.setScene(scene2);
        window.show();
    }
}
