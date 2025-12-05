package com.example.simulation_operations_of_an_ngo.Ripa.Doner;

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

public class ProjectFeedBackController {

    @FXML
    private TableColumn<Feedback, Integer> donarIdColumn;

    @FXML
    private TextField donarIdtextfield;

    @FXML
    private TextField feedbackIdTextfield;

    @FXML
    private TableColumn<Feedback, String> feedbackMessageColumn;

    @FXML
    private TextField feedbackMessagetextfield;

    @FXML
    private TableColumn<Feedback, Integer> feedbackidcolumn;

    @FXML
    private TableColumn<Feedback, String> projectNameColumn;

    @FXML
    private ComboBox<String> projectNamecombobox;

    @FXML
    private TableView<Feedback> tableView;

    @javafx.fxml.FXML
    public void initialize() {
        projectNamecombobox.getItems().addAll("Project Manager","Finance Manager","HR Manager","Monitoring & Evaluation Officer");
        projectNameColumn.setCellValueFactory(new PropertyValueFactory<>("projectname"));
        feedbackidcolumn.setCellValueFactory(new PropertyValueFactory<>("fedId"));
        feedbackMessageColumn.setCellValueFactory(new PropertyValueFactory<>("fedbackMessage"));
        donarIdColumn.setCellValueFactory(new PropertyValueFactory<>("donarId"));
    }

    @FXML
    void sendFeedBack(ActionEvent event) {
        int donId=Integer.parseInt(donarIdtextfield.getText());
        int fedId=Integer.parseInt(feedbackIdTextfield.getText());
        String fedMess=feedbackMessagetextfield.getText();
        String proName=projectNamecombobox.getValue();
        String email=null;
        String pass=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("Feedback.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Feedback y=new Feedback(email,pass,fedId,donId,proName,fedMess);
            tableView.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(ProjectFeedBackController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(ProjectFeedBackController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    void showAllfeedback(ActionEvent event) {
        tableView.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            Feedback y;
            ois = new ObjectInputStream(new FileInputStream("Feedback.bin"));
            while (true) {
                y = (Feedback) ois.readObject();
                tableView.getItems().add(y);
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
