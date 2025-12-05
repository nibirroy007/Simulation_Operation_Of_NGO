module com.example.simulation_operations_of_an_ngo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires javafx.graphics;
    requires java.desktop;


    opens com.example.simulation_operations_of_an_ngo to javafx.fxml;
    exports com.example.simulation_operations_of_an_ngo;
    opens com.example.simulation_operations_of_an_ngo.Juman.FieldOfficer to javafx.fxml;
    exports com.example.simulation_operations_of_an_ngo.Juman.FieldOfficer;
    opens com.example.simulation_operations_of_an_ngo.Juman.Volunteer to javafx.fxml;
    exports com.example.simulation_operations_of_an_ngo.Juman.Volunteer;
    opens com.example.simulation_operations_of_an_ngo.Nibir.MediaOfficer to javafx.fxml;
    exports com.example.simulation_operations_of_an_ngo.Nibir.MediaOfficer;
    opens com.example.simulation_operations_of_an_ngo.Nibir.SystemAdministor to javafx.fxml;
    exports com.example.simulation_operations_of_an_ngo.Nibir.SystemAdministor;
    opens com.example.simulation_operations_of_an_ngo.Ripa.Doner to javafx.fxml;
    exports com.example.simulation_operations_of_an_ngo.Ripa.Doner;
    opens com.example.simulation_operations_of_an_ngo.Ripa.ProjectManager to javafx.fxml;
    exports com.example.simulation_operations_of_an_ngo.Ripa.ProjectManager;
    opens com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager to javafx.fxml;
    exports com.example.simulation_operations_of_an_ngo.Vubon.FinanceManager;
    opens com.example.simulation_operations_of_an_ngo.Vubon.HrManager to javafx.fxml;
    exports com.example.simulation_operations_of_an_ngo.Vubon.HrManager;
}