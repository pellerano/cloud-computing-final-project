package es.uah.peliculasAPIUsers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private LocalDate date_created;
    private Integer score;

    @ManyToOne
    @JoinTable(
            name = "comment_user",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonManagedReference
    @JsonIgnoreProperties("comments")
    private User user;

    @ManyToOne
    @JoinTable(
            name = "comment_movie",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    @JsonManagedReference
    @JsonIgnoreProperties("comments")
    private Movie movie;
}
