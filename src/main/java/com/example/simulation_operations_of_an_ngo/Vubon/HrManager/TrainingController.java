package com.example.simulation_operations_of_an_ngo.Vubon.HrManager;

import com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager.AppendableObjectOutPutStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrainingController {

    @FXML
    private TableColumn<Training, String> programTitleColumn;

    @FXML
    private TextField programTitletextField;

    @FXML
    private TableView<Training> tableView;

    @FXML
    private TableColumn<Training, String> targetGroupColumn;

    @FXML
    private ComboBox<String> targetGroupCombobox;

    @FXML
    private TextField trainIdTextfield;

    @FXML
    private ComboBox<String> traincategorycomboox;

    @FXML
    private TableColumn<Training, String> trainerNameColumn;

    @FXML
    private TextField trainerTextfield;

    @FXML
    private TableColumn<Training, String> trainingCategoryColumn;

    @FXML
    private TableColumn<Training, String> trainingidColumn;

    @javafx.fxml.FXML
    public void initialize() {
        traincategorycomboox.getItems().addAll("Skill Development","Leadership","Orientation", "Safety");
        targetGroupCombobox.getItems().addAll("Employees ","Volunteers");
        trainingidColumn.setCellValueFactory(new PropertyValueFactory<>("trainId"));
        trainingCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("trainCategory"));
        trainerNameColumn.setCellValueFactory(new PropertyValueFactory<>("trainerName"));
        targetGroupColumn.setCellValueFactory(new PropertyValueFactory<>("targetGroup"));
        programTitleColumn.setCellValueFactory(new PropertyValueFactory<>("programTitle"));


    }

    @FXML
    void addTraningbutton(ActionEvent event) {
        tableView.getItems().clear();
        int trainId=Integer.parseInt(trainIdTextfield.getText());
        String trainingTitle=programTitletextField.getText();
        String name=trainerTextfield.getText();
        String targetGroup=targetGroupCombobox.getValue();
        String category=traincategorycomboox.getValue();
        String email=null;
        String password=null;
        File f= null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f=new File("Training.bin");
            if(f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutPutStream(fos);
            }
            else{
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }
            Training y=new Training(email,password,trainId,trainingTitle,name,category,targetGroup);
            tableView.getItems().add(y);

            oos.writeObject(y);

        }catch(IOException ex){
            Logger.getLogger(TrainingController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(oos!=null){
                    oos.close();
                }
            }catch(IOException ex){
                Logger.getLogger(TrainingController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    void showAllButton(ActionEvent event) {
        tableView.getItems().clear();
        loadAll();


    }
    public void loadAll() {
        ObjectInputStream ois = null;
        try {
            Training y;
            ois = new ObjectInputStream(new FileInputStream("Training.bin"));
            while (true) {
                y = (Training) ois.readObject();
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

    @FXML
    public void backButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Vubon/HrManager/hrDashboard.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Recruit");
        window.setScene(scene2);
        window.show();
    }
}
