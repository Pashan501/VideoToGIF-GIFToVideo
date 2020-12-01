package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private Label hello;
    @FXML private Button mp4;
    @FXML private Button gif;


    public void changeScreenButtonPusherGIF(ActionEvent event) throws IOException {
        Parent gifConverterParent = FXMLLoader.load(getClass().getResource("GIF.fxml"));
        Scene gifConverter = new Scene(gifConverterParent);
        // gets Stage info
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(gifConverter);
        window.show();
    }
    public void changeScreenButtonPusherMP4(ActionEvent event) throws IOException {
        Parent mp4ConverterParent = FXMLLoader.load(getClass().getResource("MP4.fxml"));
        Scene mp4Converter = new Scene(mp4ConverterParent);
        // gets Stage info
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(mp4Converter);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
