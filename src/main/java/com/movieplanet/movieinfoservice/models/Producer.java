package com.movieplanet.movieinfoservice.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="producers")
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, length = 20, updatable = false)
    private Long producerId;

    @Column(name="name", nullable = false, length = 1000)
    private String name;

    @Column(name="surname", nullable = false, length = 1000)
    private String surname;

    @Column(name="age", nullable = false)
    private String age;

    @OneToMany(mappedBy = "producer")
    private List<Movie> movies;


    public Producer() {}

    public Producer(Long producerId, String name, String surname, String age, List<Movie> movies) {
        this.producerId = producerId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.movies = movies;
    }

    public Long getProducerId() {
        return producerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
