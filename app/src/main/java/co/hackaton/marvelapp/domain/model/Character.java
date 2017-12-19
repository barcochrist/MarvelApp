package co.hackaton.marvelapp.domain.model;

/**
 * Created by casa on 14/12/17.
 */

public class Character {

    private int id;
    private String name ;
    private String description ;
    private String thumbnail ;

    public Character(int id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnail = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getthumbnail() {
        return thumbnail;
    }

    public void setthumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
