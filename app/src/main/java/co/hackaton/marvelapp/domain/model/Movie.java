package co.hackaton.marvelapp.domain.model;

/**
 * Created by casa on 14/12/17.
 */

public class Movie {

    private int id;
    private String title;
    private String description;
    private String imageCover;
    private String url;
    private String releaseDate;

    public Movie() {
    }

    public Movie(int id, String title, String description, String imageCover, String url, String releaseDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageCover = imageCover;
        this.url = url;
        this.releaseDate = releaseDate;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageCover='" + imageCover + '\'' +
                ", url='" + url + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
