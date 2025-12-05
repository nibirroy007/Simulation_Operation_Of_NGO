package com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager;

<<<<<<< HEAD
public class ApproveTransactionController
{
    @javafx.fxml.FXML
    private TextField amountTextFiled;
    @javafx.fxml.FXML
    private TableColumn statuscolumn;
    @javafx.fxml.FXML
    private ComboBox nameCombobox;

    @javafx.fxml.FXML
    public void initialize() {
    }}
=======
import com.example.simulation_operations_of_an_ngo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApproveTransactionController {

    @FXML
    private TableColumn<Approve, Integer> amountcolumn;

    @FXML
    private ComboBox<String> nameCombobox;

    @FXML
    private TableColumn<Approve, String> projectcolumn;

    @FXML
    private TextField requestBycolumn;

    @FXML
    private TextField requestIdTextField;

    @FXML
    private TableColumn<Approve, Integer> requestIdcolumn;

    @FXML
    private TableColumn<Approve, String> requestbycolumn;

    @FXML
    private TextField statusColumn;

    @FXML
    private TableColumn<Approve, String> statuscolumn;

    @FXML
    private TableView<Approve> tableView;
    @FXML
    private TextField amountTextFiled;

    @javafx.fxml.FXML
    public void initialize() {
        nameCombobox.getItems().addAll("Field officer","Volunteer","Media Officer","Donor","Project Manager");
        amountcolumn.setCellValueFactory(new PropertyValueFactory<Approve,Integer>("amount"));
        requestbycolumn.setCellValueFactory(new PropertyValueFactory<>("requestBy"));
        requestIdcolumn.setCellValueFactory(new PropertyValueFactory<>("reqId"));
        statuscolumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        projectcolumn.setCellValueFactory(new PropertyValueFactory<>("projectName"));
    }

    @FXML
    void ApprobveButton(ActionEvent event) {
        tableView.getItems().clear();
        String status=statusColumn.getText();
        String reqBy=requestBycolumn.getText();
        int id=Integer.parseInt(requestIdTextField.getText());
        int amount=Integer.parseInt(amountTextFiled.getText());
        String name=nameCombobox.getValue();
        String email=null;
        String password=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("Approve.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Approve y=new Approve(email,password,name,id,amount,reqBy,status);
            tableView.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(ApproveTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(ApproveTransactionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    @FXML
    void ShowAllButton(ActionEvent event) {
        tableView.getItems().clear();
        loadAll();


    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            Approve y;
            ois = new ObjectInputStream(new FileInputStream("Approve.bin"));
            while (true) {
                y = (Approve) ois.readObject();
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
>>>>>>> da41a62647a20ec72c613b9f173d06e3dc0df6a4
