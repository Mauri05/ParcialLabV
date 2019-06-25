package com.example.SimulacroParcial.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicacionesXUsuario extends JpaRepository<com.example.SimulacroParcial.models.PublicacionesXUsuario, String> {

    String NATIVE_QUERY = "select p.title, u.name, count(c.*) as quantity from user u inner join publication p on u.id = p.id_user " +
            "inner join comentary c on p.id = c.id_publication";

    @Query(value = NATIVE_QUERY , nativeQuery = true)
    List<com.example.SimulacroParcial.models.PublicacionesXUsuario> getPublicacionesPorUsuarioClass();
}
