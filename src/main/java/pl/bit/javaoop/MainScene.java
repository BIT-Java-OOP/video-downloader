package pl.bit.javaoop;

import com.sapher.youtubedl.YoutubeDLRequest;
import com.sapher.youtubedl.YoutubeDLResponse;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class MainScene {
    private VideoDownloader videoDownloader = new VideoDownloader();
    private Scene scene;

    public MainScene() {
        initializeScene();
    }

    public void downloadVideoFromUrl(String videoUrl) {
        YoutubeDLRequest request = videoDownloader.prepareRequest(videoUrl);
        YoutubeDLResponse response = videoDownloader.downloadMovie(request);
        System.out.println("Done!\n" + response.getOut());
    }

    private void initializeScene() {
        FXMLLoader fxmlLoader = new FXMLLoader(MainScene.class.getResource("main_view.fxml"));
        try {
            scene = new Scene(fxmlLoader.load());
            MainViewController controller = fxmlLoader.getController();
            controller.setModel(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return this.scene;
    }
}
