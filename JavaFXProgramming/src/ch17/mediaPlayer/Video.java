package ch17.mediaPlayer;

import java.net.URI;

public class Video {
    private String fileName;
    private URI uriPath;

    public Video(String fileName, URI uriPath) {
        this.fileName = fileName;
        this.uriPath = uriPath;
    }
    
    public Video() {
        
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public URI getUriPath() {
        return uriPath;
    }

    public void setUriPath(URI uriPath) {
        this.uriPath = uriPath;
    }
    
    
    
}
