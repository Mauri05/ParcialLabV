package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.interfaces.PublicacionesXUsuario;
import com.example.SimulacroParcial.interfaces.PublicacionesXUsuarioRepo;
import com.example.SimulacroParcial.interfaces.UserRepository;
import com.example.SimulacroParcial.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PublicacionesXUsuario publixUserRepo;

    @PostMapping("")
    public void addUser(@RequestBody User user, HttpServletRequest request){
        user.setBrowser(this.getUserAgent(request));
        userRepository.save(user);
    }

    @GetMapping("")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userRepository.getOne(id);
    }

    @PatchMapping("/modify/{id}")
    @Modifying
    public void modifyUser(@PathVariable("id") Integer id, @RequestBody User user){
        User aux = userRepository.getOne(id);
        aux = user;
        userRepository.save(aux);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }

    @GetMapping("/nativeRepository")
    public List<PublicacionesXUsuarioRepo> getPublicacionesPorUsuario(){
        return userRepository.getPublicacionesPorUsuario();
    }

    @GetMapping("/nativeClass")
    public List<PublicacionesXUsuarioRepo> getPublicacionesPorUsuarioClass(){
        return userRepository.getPublicacionesPorUsuario();
    }

    private String getUserAgent(HttpServletRequest request) {
        return request.getHeader("user-agent");
    }
}
