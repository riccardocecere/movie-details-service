package com.movieplanet.movieinfoservice.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, length = 20 , updatable = false)
    private Long movieId;

    @Column(name="title", nullable = false, length = 1000)
    private String title;

    @Column(name="plot", nullable = false)
    private String plot;

    @Column(name="release_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate;

    @Column(name = "cover_url", length = 1000)
    private String coverUrl;

    @Column(name="category", nullable = false, length = 1000)
    private String category;

    @Column(name="duration", nullable = false)
    private Integer duration;

    @ManyToOne
    @JoinColumn(name="id_producer")
    private Producer producer;

    @Column(name="video_url", length = 1000)
    private String videoUrl;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie-actor",
            joinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_actor",
                    referencedColumnName = "id"))
    private List<Actor> actors;

    public Movie() {}

    public Movie(String title, String plot, Date releaseDate, String coverUrl, String category, Integer duration, Producer producer, String videoUrl, List<Actor> actors) {
        this.title = title;
        this.plot = plot;
        this.releaseDate = releaseDate;
        this.coverUrl = coverUrl;
        this.category = category;
        this.duration = duration;
        this.producer = producer;
        this.videoUrl = videoUrl;
        this.actors = actors;
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
