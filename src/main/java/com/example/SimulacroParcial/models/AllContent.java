package com.example.SimulacroParcial.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllContent {

    private List<User> listaUsers;
    private List<Publication> listaPublication;
    private List<Comentary> listaComentary;
}
