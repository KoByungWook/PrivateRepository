package ch17.homework0419_advance2;

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
