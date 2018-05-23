package pl.bit.javaoop;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainViewController {
    public Button downloadButton;
    public TextField urlTextField;

    private MainScene model;

    public void download(ActionEvent actionEvent) {
        model.downloadVideoFromUrl(urlTextField.getText());
    }

    public void setModel(MainScene model) {
        this.model = model;
    }
}
