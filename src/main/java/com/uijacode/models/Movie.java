package com.uijacode.models;

public class Movie {
    private String id;
    private String title;
    private String crew;
    private Float imDbRating;
    private String image;
    private String fullTitle;
    private Integer imDbRatingCount;
    private Integer year;
    private Integer rank;

    public Movie() {}

    public Movie(String id, String title, String crew, Float imDbRating, String image, String fullTitle, Integer imDbRatingCount, Integer year, Integer rank) {
        this.id = id;
        this.title = title;
        this.crew = crew;
        this.imDbRating = imDbRating;
        this.image = image;
        this.fullTitle = fullTitle;
        this.imDbRatingCount = imDbRatingCount;
        this.year = year;
        this.rank = rank;
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

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public Float getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(Float imDbRating) {
        this.imDbRating = imDbRating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public Integer getImDbRatingCount() {
        return imDbRatingCount;
    }

    public void setImDbRatingCount(Integer imDbRatingCount) {
        this.imDbRatingCount = imDbRatingCount;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", crew='" + crew + '\'' +
                ", imDbRating=" + imDbRating +
                ", image='" + image + '\'' +
                ", fullTitle='" + fullTitle + '\'' +
                ", imDbRatingCount=" + imDbRatingCount +
                ", year=" + year +
                ", rank=" + rank +
                '}';
    }

    public Content getContent() {
        return new Content(this.title, this.image);
    }
}
