package com.example.simulation_operations_of_an_ngo.Vubon.HrManager;

import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.AppendableObjectOutPutStream;
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

public class PoliciesController {

    @FXML
    private TableColumn<Policies, Integer> PoliciesIdColumn;

    @FXML
    private TableColumn<Policies, LocalDate> dateColumn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField policirsIdTextfield;

    @FXML
    private TableColumn<Policies, String> policyCategoryColumn;

    @FXML
    private ComboBox<String> policyCategoryCombobox;

    @FXML
    private TableColumn<Policies, String> policyTitleColumn;

    @FXML
    private TextField policytitleTextfield;

    @FXML
    private TableView<Policies> tableview;

    public void initialize() {
        policyCategoryCombobox.getItems().addAll("Employee Rights","Leaves","Salary Rules","Behavior","Safety","Ethics");
        policyCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("polCat"));
        policyTitleColumn.setCellValueFactory(new PropertyValueFactory<>("polName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        PoliciesIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    @FXML
    void addPolicyButton(ActionEvent event) {
        tableview.getItems().clear();
        int id = Integer.parseInt(policirsIdTextfield.getText());
        String title = policytitleTextfield.getText();
        LocalDate date = datePicker.getValue();
        String polcat = policyCategoryCombobox.getValue();
        String email = null;
        String password = null;
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("Policies.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutPutStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            Policies y = new Policies(email, password, id, title, polcat, date);
            tableview.getItems().add(y);

            oos.writeObject(y);

        } catch (IOException ex) {
            Logger.getLogger(PoliciesController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(PoliciesController.class.getName()).log(Level.SEVERE, null, ex);
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
    void showAllbutton(ActionEvent event) {
        tableview.getItems().clear();
        loadAll();

    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            Policies y;
            ois = new ObjectInputStream(new FileInputStream("Policies.bin"));
            while (true) {
                y = (Policies) ois.readObject();
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
