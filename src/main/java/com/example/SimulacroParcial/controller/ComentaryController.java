package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.interfaces.ComentaryRepository;
import com.example.SimulacroParcial.interfaces.PublicationRepository;
import com.example.SimulacroParcial.models.Comentary;
import com.example.SimulacroParcial.models.Publication;
import com.example.SimulacroParcial.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comentary")
public class ComentaryController {

    @Autowired
    ComentaryRepository comentaryRepository;

    @Autowired
    PublicationRepository publicationRepository;

    @PostMapping("/{id}")
    public void addComentary(@RequestBody Comentary comentary, @PathVariable("id") Integer id){
        Publication publication = publicationRepository.getOne(id);
        comentary.setOwner(publication.getUser().getName().concat(" "+publication.getUser().getSurname()));
        comentary.setPublication(publication);

        SimpleDateFormat format= new SimpleDateFormat("dd-MMM-yyyy");
        Date date = new Date(System.currentTimeMillis());
        comentary.setDate(format.format(date));
        comentaryRepository.save(comentary);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComentary(@PathVariable("id") Integer id){
        comentaryRepository.deleteById(id);
    }

    @Scheduled(cron="${cronExpression}")
    public void deleteTime(){
        List<Comentary> list= comentaryRepository.findAll();
        for (Comentary c: list){
            comentaryRepository.deleteById(c.getId());
        }
    }



}
