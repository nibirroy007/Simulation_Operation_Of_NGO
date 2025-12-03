package com.example.simulation_operations_of_an_ngo.Ripa.Doner;

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

public class SelectProjectController {

    @FXML
    private TableColumn<SelectProject, LocalDate> dateColumn;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TableColumn<SelectProject, String> interestColumn;

    @FXML
    private ComboBox<String> interestlavelCombobox;

    @FXML
    private TextField projectDescriptionColumn;

    @FXML
    private TableColumn<SelectProject, String> projectDiscriptioncolumn;

    @FXML
    private TextField projectIDTextField;

    @FXML
    private TableColumn<SelectProject, Integer> projectIdColumn;

    @FXML
    private TableColumn<SelectProject, String> projectNameColumn;

    @FXML
    private TextField projectNameTextField;

    @FXML
    private TableView<SelectProject> tableview;
    @javafx.fxml.FXML
    public void initialize() {
        projectNameColumn.setCellValueFactory(new PropertyValueFactory<>("proName"));
        projectIdColumn.setCellValueFactory(new PropertyValueFactory<>("proID"));
        projectDiscriptioncolumn.setCellValueFactory(new PropertyValueFactory<>("projectdes"));
        interestColumn.setCellValueFactory(new PropertyValueFactory<>("interestlavel"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        interestlavelCombobox.getItems().addAll("Low","Medium","High","Very High");

    }

    @FXML
    void selectprojectbutton(ActionEvent event) {
        tableview.getItems().clear();
        int proId=Integer.parseInt(projectIDTextField.getText());
        String proNAme=projectNameTextField.getText();
        String prodes=projectDescriptionColumn.getText();
        String inteLavel=interestlavelCombobox.getValue();
        LocalDate date=datepicker.getValue();
        String email=null;
        String pass=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("SelectedProject.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            SelectProject y=new SelectProject(email,pass,proId,proNAme,inteLavel,prodes,date);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(SelectProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(SelectProjectController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }

    @FXML
    void viewallProjectbutton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            SelectProject y;
            ois = new ObjectInputStream(new FileInputStream("SelectedProject.bin"));
            while (true) {
                y = (SelectProject) ois.readObject();
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
