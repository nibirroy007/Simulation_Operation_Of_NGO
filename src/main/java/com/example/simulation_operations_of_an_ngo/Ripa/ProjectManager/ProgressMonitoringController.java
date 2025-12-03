package com.example.simulation_operations_of_an_ngo.Ripa.ProjectManager;

import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgressMonitoringController {

    @FXML
    private TableColumn<ProgressMonitoring, String> noteColumn;

    @FXML
    private TextField noteTextField;

    @FXML
    private ComboBox<String> progressCombobox;

    @FXML
    private TableColumn<ProgressMonitoring, String> projectProgressColumn;

    @FXML
    private TextField remainingResourceTextfield;

    @FXML
    private TableColumn<ProgressMonitoring, String> remainingresourceColumn;

    @FXML
    private TextField resourceUsedTextField;

    @FXML
    private TableColumn<ProgressMonitoring, String> resourceusedColumn;

    @FXML
    private TableView<ProgressMonitoring> tableview;
    @javafx.fxml.FXML
    public void initialize() {
        projectProgressColumn.setCellValueFactory(new PropertyValueFactory<>("projectProgress"));
        remainingresourceColumn.setCellValueFactory(new PropertyValueFactory<>("reamingres"));
        resourceusedColumn.setCellValueFactory(new PropertyValueFactory<>("resourceUsed"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));
        progressCombobox.getItems().addAll("Not Started","In Progress","Completed","Delayed");

    }

    @FXML
    void progressButton(ActionEvent event) {
        tableview.getItems().clear();
        String proprogress=progressCombobox.getValue();
        String resUsed=resourceUsedTextField.getText();
        String note=noteTextField.getText();
        String remaininres=remainingResourceTextfield.getText();
        String email=null;
        String password=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("ProjectMonitor.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            ProgressMonitoring y=new ProgressMonitoring(email,password,proprogress,resUsed,remaininres,note);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(ProgressMonitoringController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(ProgressMonitoringController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    void showAllbutton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            ProgressMonitoring y;
            ois = new ObjectInputStream(new FileInputStream("ProjectMonitor.bin"));
            while (true) {
                y = (ProgressMonitoring) ois.readObject();
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
