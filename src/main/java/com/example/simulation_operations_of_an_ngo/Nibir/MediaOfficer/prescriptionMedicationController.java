package com.example.simulation_operations_of_an_ngo.Nibir.MediaOfficer;

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

public class prescriptionMedicationController {

    @FXML
    private TextField patientIdTextField;

    @FXML
    private TextField diagnosisTextField;

    @FXML
    private TableColumn<prescriptionMedication, String> colPatientName;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TableColumn<prescriptionMedication, String> colDiagnosis;

    @FXML
    private TableColumn<prescriptionMedication, String> colGender;

    @FXML
    private TableColumn<prescriptionMedication, String> colPhone;

    @FXML
    private ComboBox<String> genderComboBox;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private TableView<prescriptionMedication> patientTableView;

    @FXML
    private TableColumn<prescriptionMedication, String> colPatientId;


    @FXML
    public void initialize() {

        genderComboBox.getItems().addAll("Male", "Female", "Other");


        colPatientId.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        colPatientName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colDiagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
    }


    @FXML
    public void savePatientButton(ActionEvent actionEvent) {
        String id = patientIdTextField.getText();
        String name = patientNameTextField.getText();
        String gender = genderComboBox.getValue();
        String phone = phoneTextField.getText();
        String diagnosis = diagnosisTextField.getText();

        if (id == null || id.isEmpty() ||
                name == null || name.isEmpty() ||
                gender == null || gender.isEmpty()) {


            System.out.println("Required fields missing (ID, Name, Gender).");
            return;
        }

        prescriptionMedication p = new prescriptionMedication(
                id,
                name,
                gender,
                phone,
                diagnosis
        );


        patientTableView.getItems().add(p);


        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("PatientRecords.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(p);

        } catch (IOException ex) {
            Logger.getLogger(prescriptionMedicationController.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(prescriptionMedicationController.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }


    @FXML
    public void showAllPatientsButton(ActionEvent actionEvent) {
        patientTableView.getItems().clear();
        loadAllPatients();
    }

    private void loadAllPatients() {
        ObjectInputStream ois = null;
        try {
            File f = new File("PatientRecords.bin");
            if (!f.exists()) {

                return;
            }

            ois = new ObjectInputStream(new FileInputStream(f));
            while (true) {
                prescriptionMedication p = (prescriptionMedication) ois.readObject();
                patientTableView.getItems().add(p);
            }
        } catch (EOFException eof) {

        } catch (Exception ex) {
            Logger.getLogger(prescriptionMedicationController.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }
    }


    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {

            reset();
        }
    }
}
