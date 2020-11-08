package sample;

import javafx.scene.control.Button;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Controller {

    @FXML
    private Button btn_Copy;
    @FXML
    private Button btn_Save;
    @FXML
    private Button btn_Import;
    @FXML
    private Button btn_Close;


    @FXML
    private TextArea txtOutput;
        public Controller(){

        }


    @FXML
    public void onClick_btn_Copy(ActionEvent e) {
        String myText = txtOutput.getText().toString();

        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();

        content.putString(myText);
        clipboard.setContent(content);


    }

    @FXML
    public void onClick_btn_Save(ActionEvent e)throws IOException {
        Stage stage = new Stage();
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save File");
        File selectedFile = chooser.showSaveDialog(stage);
        FileWriter FW = new FileWriter(selectedFile.getAbsolutePath());
        FW.write(txtOutput.getText().toString());
        FW.close();
    }

    @FXML
    public void onClick_btn_Import(ActionEvent e)throws IOException{
        Stage stage = new Stage();
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
            File selectedFile = chooser.showOpenDialog(stage);

        FileReader FR = new FileReader(selectedFile.getAbsolutePath().toString());
        BufferedReader BR = new BufferedReader(FR);

        StringBuilder sb = new StringBuilder();

        String myText = "";

        while((myText = BR.readLine())!=null){
            sb.append(myText + "\n");
        }
        txtOutput.setText(sb.toString());

    }

    @FXML
    public void onClick_btn_Close(ActionEvent e){
        Platform.exit();


    }



}
