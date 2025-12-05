package com.example.simulation_operations_of_an_ngo.Ripa.ProjectManager;

import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.AppendableObjectOutPutStream;
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

public class ProjectPlaningcontroller {

    @FXML
    private ComboBox<String> cmbTimelineStatus;

    @FXML
    private TableColumn<ProjectPlaning, String> deliveriesColumn;

    @FXML
    private DatePicker dpEndDate;

    @FXML
    private DatePicker dpStartDate;

    @FXML
    private TableColumn<ProjectPlaning, LocalDate> endcolumn;

    @FXML
    private TableColumn<ProjectPlaning, String> projectTitleColumn;

    @FXML
    private TableColumn<ProjectPlaning, LocalDate> startDateColumn;

    @FXML
    private TableView<ProjectPlaning> tableview;

    @FXML
    private TableColumn<ProjectPlaning, LocalDate> timelineColumn;

    @FXML
    private TextField txtDeliverables;

    @FXML
    private TextField txtProjectTitle;

    @javafx.fxml.FXML
    public void initialize() {
        timelineColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startdate"));
        projectTitleColumn.setCellValueFactory(new PropertyValueFactory<>("titleProject"));
        endcolumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        deliveriesColumn.setCellValueFactory(new PropertyValueFactory<>("deliveries"));
        cmbTimelineStatus.getItems().addAll("Not Started","Planning","Scheduled","In Progress");

    }

    @FXML
    void planingProjectButton(ActionEvent event) {
        tableview.getItems().clear();
        String textdel=txtDeliverables.getText();
        String proTitle=txtProjectTitle.getText();
        LocalDate stdate=dpEndDate.getValue();
        LocalDate endDate=dpStartDate.getValue();
        String cmStatus=cmbTimelineStatus.getValue();
        String email=null;
        String password=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("PlaningProject.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            ProjectPlaning y=new ProjectPlaning(email,password,proTitle,stdate,endDate,textdel,cmStatus);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(ProjectPlaningcontroller.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(ProjectPlaningcontroller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    @FXML
    void showAllProjectButton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            ProjectPlaning y;
            ois = new ObjectInputStream(new FileInputStream("PlaningProject.bin"));
            while (true) {
                y = (ProjectPlaning) ois.readObject();
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
