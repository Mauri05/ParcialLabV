package com.example.SimulacroParcial.service;

import com.example.SimulacroParcial.interfaces.ComentaryRepository;
import com.example.SimulacroParcial.interfaces.PublicationRepository;
import com.example.SimulacroParcial.interfaces.UserRepository;
import com.example.SimulacroParcial.models.Comentary;
import com.example.SimulacroParcial.models.Publication;
import com.example.SimulacroParcial.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncExecutorService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PublicationRepository publicationRepository;

    @Autowired
    ComentaryRepository comentaryRepository;

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<User>> getAllUsers(){
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(userRepository.findAll());
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Publication>> getAllPublications(){
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(publicationRepository.findAll());
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Comentary>> getAllComentaries(){
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(comentaryRepository.findAll());
    }
}
