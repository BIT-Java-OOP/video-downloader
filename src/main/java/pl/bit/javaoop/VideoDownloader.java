package pl.bit.javaoop;

import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.YoutubeDLRequest;
import com.sapher.youtubedl.YoutubeDLResponse;

public class VideoDownloader {
    public VideoDownloader() {
        YoutubeDL.setExecutablePath("./youtube-dl.exe");
    }

    public YoutubeDLRequest prepareRequest(String videoUrl) {
        YoutubeDLRequest request = new YoutubeDLRequest(videoUrl, ".");
        request.setOption("ignore-errors");
        request.setOption("output", "%(id)s.%(ext)s");
        request.setOption("retries", 10);
        return request;
    }

    public YoutubeDLResponse downloadMovie(YoutubeDLRequest request) {
        try {
            return YoutubeDL.execute(request);
        } catch (YoutubeDLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
