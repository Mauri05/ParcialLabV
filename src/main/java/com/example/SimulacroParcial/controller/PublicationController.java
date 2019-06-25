package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.interfaces.PublicationRepository;
import com.example.SimulacroParcial.interfaces.UserRepository;
import com.example.SimulacroParcial.models.Publication;
import com.example.SimulacroParcial.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    @Autowired
    PublicationRepository publicationRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/{id}")
    public void addPublication(@RequestBody Publication publication, @PathVariable("id") Integer id){
        User user = userRepository.getOne(id);
        publication.setUser(user);

        SimpleDateFormat format= new SimpleDateFormat("dd-MMM-yyyy");
        Date date = new Date(System.currentTimeMillis());
        publication.setPublicationDate(format.format(date));
        publicationRepository.save(publication);
    }

    @GetMapping("")
    public List<Publication> getPublications(){
        return publicationRepository.findAll();
    }
}
