package com.example.SimulacroParcial.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comentary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private String date;
    private String owner;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_publication",referencedColumnName = "id")
    @JsonIgnore
    @ToString.Exclude
    private Publication publication;
}
