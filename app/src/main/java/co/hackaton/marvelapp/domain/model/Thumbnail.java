package co.hackaton.marvelapp.domain.model;

/**
 * Created by casa on 19/12/17.
 */

public class Thumbnail {

    private  String path;
    private  String extension ;

    public Thumbnail() {
        this.path = "";
        this.extension = "";
    }

    public Thumbnail(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
