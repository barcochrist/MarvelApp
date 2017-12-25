package co.hackaton.marvelapp.domain.model;

import java.io.Serializable;

/**
 * Created by casa on 14/12/17.
 */

public class Comic implements Serializable {

    private int id;
    private String title;
    private String description;
    private String imageCover;

    public Comic() {
    }

    public Comic(int id, String title, String description, String imageCover) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageCover = imageCover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageCover() {
        return imageCover;
    }

    public void setImageCover(String imageCover) {
        this.imageCover = imageCover;
    }
}
