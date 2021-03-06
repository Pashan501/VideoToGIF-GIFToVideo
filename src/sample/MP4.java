package sample;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MP4 implements Initializable{
    @FXML private Window win;
    @FXML private Button CON,CON3;
    @FXML private Label Path, Path1;
    @FXML
    public void changeScreenButtonPusherMain2(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene main = new Scene(mainParent);
        // gets Stage info
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(main);
        window.show();
    }
    String filePath,filename;
    String directoryPath;
    @FXML
    private void chooseGIFFile(ActionEvent event) throws IOException {



        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose gif file");


        File file = fileChooser.showOpenDialog(win);


        if(file != null &&file.isFile()){
            filename = file.getName().replaceAll(".gif","");
            Path.setText(file.getAbsolutePath());
            filePath = file.getAbsolutePath();
            DirectoryChooser dc = new DirectoryChooser();
            File sd = dc.showDialog(win);
            directoryPath = sd.getAbsolutePath();
            Path1.setText(directoryPath);
            CON.setDisable(false);
            CON3.setDisable(false);

        }

    }
    @FXML
    public void ConvertToMP4(ActionEvent event) throws IOException {
        Process process = Runtime.getRuntime().exec("cmd /c ffmpeg -i "+ filePath+" "+directoryPath+"//"+filename+".mp4");
    }
    @FXML
    public void ConvertToMP4WITH(ActionEvent event) throws IOException {
        Process process2 = Runtime.getRuntime().exec("cmd /c ffmpeg -i "+ filePath+" -an -c copy "+directoryPath+"//"+filename+".mp4");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
