package com.example.simulation_operations_of_an_ngo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginDashboardController {

    @FXML
    private ComboBox<String> userCombobox;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private TextField emailTextfield;

    @FXML
    public void initialize() {
        userCombobox.getItems().addAll(
                "Field Officer",
                "Volunteer",
                "Media Officer",
                "System Administrator",
                "Project Manager",
                "Donor",
                "HR Manager",
                "Finance Manager"
        );
    }

    @FXML
    public void loginButton(ActionEvent actionEvent) {
        String user = userCombobox.getValue();
        String email = emailTextfield.getText();
        String password = passwordfield.getText();

        if (user == null) {
            return; // nothing selected
        }

        if (user.equals("Field Officer") &&
                email.equals("juman@gmail.com") &&
                password.equals("juman1234")) {
            loadScene(actionEvent, "/com/example/simulation_operations_of_an_ngo/Juman/FieldOfficer/fofficerDashboard.fxml");
        }else if (user.equals("Volunteer") &&
                email.equals("juman@gmail.com") &&
                password.equals("juman123456")) {
            loadScene(actionEvent, "/com/example/simulation_operations_of_an_ngo/Juman/Volunteer/volDashboard.fxml");
        }else if (user.equals("Media Officer") &&
                email.equals("nibir@gmail.com") &&
                password.equals("nibir123")) {
            loadScene(actionEvent, "/com/example/simulation_operations_of_an_ngo/Nibir/MediaOfficer/meOfDashboard.fxml");
        }else if (user.equals("System Administrator") &&
                email.equals("nibir@gmail.com") &&
                password.equals("nibir123456")) {
            loadScene(actionEvent, "/com/example/simulation_operations_of_an_ngo/Nibir/SystemAdministor/sysAdDashboard.fxml");
        }else if (user.equals("Donor") &&
                email.equals("ripa@gmail.com") &&
                password.equals("ripa123")) {
            loadScene(actionEvent, "/com/example/simulation_operations_of_an_ngo/Ripa/Doner/donarDashboard.fxml");
        }else if (user.equals("Project Manager") &&
                email.equals("ripa@gmail.com") &&
                password.equals("ripa123456")) {
            loadScene(actionEvent, "/com/example/simulation_operations_of_an_ngo/Ripa/ProjectManager/projectManagerDashboard.fxml");
        }else if (user.equals("Finance Manager") &&
                email.equals("vubon@gmail.com") &&
                password.equals("vubon123")) {
            loadScene(actionEvent, "/com/example/simulation_operations_of_an_ngo/Vubon/FinanceManager/financeDashboard.fxml");
        }else if (user.equals("HR Manager") &&
                email.equals("vubon@gmail.com") &&
                password.equals("vubon123456")) {
            loadScene(actionEvent, "/com/example/simulation_operations_of_an_ngo/Vubon/HrManager/hrDashboard.fxml");
        }
    }

    private void loadScene(ActionEvent event, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
