package com.example.simulation_operations_of_an_ngo.Ripa.Doner;

import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.AppendableObjectOutPutStream;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactNgoController {

    @FXML
    private TableColumn<Contact, Integer> donarIdColumn;

    @FXML
    private TextField donarIdtextField;

    @FXML
    private TableColumn<Contact, String> messageColumn;

    @FXML
    private TableColumn<Contact, String> messageIdColumn;

    @FXML
    private TextField messageIdTextField;

    @FXML
    private TextField messageTExtField;

    @FXML
    private ComboBox<String> resnamecombobox;

    @FXML
    private TableColumn<Contact, String> respectibveColumn;

    @FXML
    private TableColumn<Contact, String> subjectColumnm;

    @FXML
    private TextField subjectTextField;

    @FXML
    private TableView<Contact> tableview;

    @javafx.fxml.FXML
    public void initialize() {
        resnamecombobox.getItems().addAll("Project Manager","Finance Manager","HR Manager","Monitoring & Evaluation Officer");
        respectibveColumn.setCellValueFactory(new PropertyValueFactory<>("resNAme"));
        subjectColumnm.setCellValueFactory(new PropertyValueFactory<>("subject"));
        messageIdColumn.setCellValueFactory(new PropertyValueFactory<>("messId"));
        messageColumn.setCellValueFactory(new PropertyValueFactory<>("messageBody"));
        donarIdColumn.setCellValueFactory(new PropertyValueFactory<>("donarId"));

    }

    @FXML
    public void contactButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        String sub=subjectTextField.getText();
        String mess=messageTExtField.getText();
        int messId=Integer.parseInt(messageIdTextField.getText());
        int donId=Integer.parseInt(donarIdtextField.getText());
        String resNAme=resnamecombobox.getValue();
        String email=null;
        String pass=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("ContactNgo.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Contact y=new Contact(email,pass,messId,donId,resNAme,mess,sub);
            tableview.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(ContactNgoController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(ContactNgoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    @FXML
    public void showAllButton(ActionEvent actionEvent) {
        tableview.getItems().clear();
        loadAll();
    }

    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            Contact y;
            ois = new ObjectInputStream(new FileInputStream("ContactNgo.bin"));
            while (true) {
                y = (Contact) ois.readObject();
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
