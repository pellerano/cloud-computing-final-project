package es.uah.peliculasAPIUsers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private Integer year;
    private Integer duration;
    private String director;
    private String genre;
    private String synopsis;
    private String cover_img_url;

    @ManyToMany
    @JoinTable(
            name = "comment_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    @JsonManagedReference
    @JsonIgnoreProperties({"movie"})
    private List<Comment> comments;
}
