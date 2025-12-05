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

public class InviteOthersController {

    @FXML
    private TableColumn<Invite,LocalDate> dateColumn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField inviteEmailTextfield;

    @FXML
    private TableColumn<Invite, String> inviteMailcolumn;

    @FXML
    private TableColumn<Invite, String> inviteOthersColumn;

    @FXML
    private TextField nametextField;

    @FXML
    private TableColumn<Invite, String> referalInColumn;

    @FXML
    private TextField relIDTextField;

    @FXML
    private ComboBox<String> relationShiptypeCombobobx;

    @FXML
    private TableColumn<Invite, String> relationshipTypecolumn;

    @FXML
    private TableView<Invite> tableview;

    @javafx.fxml.FXML
    public void initialize() {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        relationshipTypecolumn.setCellValueFactory(new PropertyValueFactory<>("relType"));
        referalInColumn.setCellValueFactory(new PropertyValueFactory<>("refId"));
        relationShiptypeCombobobx.getItems().addAll("Friend","Family","Colleague","Partner Organization");
        inviteMailcolumn.setCellValueFactory(new PropertyValueFactory<>("inviteNAme"));
        inviteOthersColumn.setCellValueFactory(new PropertyValueFactory<>("inviteMAil"));
    }

    @FXML
    void inviteButton(ActionEvent event) {
        tableview.getItems().clear();
        int relId=Integer.parseInt(relIDTextField.getText());
        String inEmail=inviteEmailTextfield.getText();
        String name=nametextField.getText();
        String relship=relationShiptypeCombobobx.getValue();
        LocalDate date=datePicker.getValue();
        String email = null;
        String password = null;
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("InviteOther.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            Invite y = new Invite(email, password,relId,inEmail,name,date,relship);
            tableview.getItems().add(y);

            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(InviteOthersController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(InviteOthersController.class.getName()).log(Level.SEVERE, null, ex);
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
            Invite y;
            ois = new ObjectInputStream(new FileInputStream("InviteOther.bin"));
            while (true) {
                y = (Invite) ois.readObject();
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
