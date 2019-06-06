package com.example.SimulacroParcial.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Publication {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String description;
    private String photo;
    private String publicationDate;
    private Integer liked;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "publication")
    private List<Comentary> comentaryList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    @JsonIgnore
    @ToString.Exclude
    private User user;
}
