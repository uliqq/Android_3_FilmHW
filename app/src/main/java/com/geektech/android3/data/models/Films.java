package com.geektech.android3.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Films {

    private String id;

    private String title;

    @SerializedName("original_title")
    private String originalTitle;

    private String description;

    private String director;

    @SerializedName("release_date")
    private String releaseDate;

    private List<String> people;

    private String image;

    public Films(String id, String title, String originalTitle, String description, String director, String releaseDate, List<String> people, String image) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.description = description;
        this.director = director;
        this.releaseDate = releaseDate;
        this.people = people;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }
}
