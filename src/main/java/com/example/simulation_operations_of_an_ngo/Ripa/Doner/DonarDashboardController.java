package com.example.simulation_operations_of_an_ngo.Ripa.Doner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DonarDashboardController {

    @FXML
    void contactNGO(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Ripa/Doner/contactNgo.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("ContactNgo");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void giveFeedback(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Ripa/Doner/projectFeedBack.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("ContactNgo");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void inviteIthersButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Ripa/Doner/inviteOthers.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("ContactNgo");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void joineventButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Ripa/Doner/joinEvent.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Joint Event");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void makeDonationButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Ripa/Doner/makeDonation.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Make Donation");
        window.setScene(scene2);
        window.show();

    }

    @FXML
    public void selecteProject(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/simulation_operations_of_an_ngo/Ripa/Doner/selectProject.fxml")));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Make Donation");
        window.setScene(scene2);
        window.show();
    }
}
