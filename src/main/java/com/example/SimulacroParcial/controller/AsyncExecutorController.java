package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.models.AllContent;
import com.example.SimulacroParcial.models.Comentary;
import com.example.SimulacroParcial.models.Publication;
import com.example.SimulacroParcial.models.User;
import com.example.SimulacroParcial.service.AsyncExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/allContent")
public class AsyncExecutorController {

    @Autowired
    AsyncExecutorService service;

    @GetMapping("/mostrar")
    public ResponseEntity<AllContent> getSuma(){
        CompletableFuture<List<User>> users = service.getAllUsers();
        CompletableFuture<List<Publication>> publications = service.getAllPublications();
        CompletableFuture<List<Comentary>> comentaries = service.getAllComentaries();
        AllContent content = new AllContent(users.join(), publications.join(), comentaries.join());
        return ResponseEntity.status(200).body(content);
    }
}