package com.derek.web;

import com.derek.model.Spitter;
import com.derek.repository.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by qux on 20/8/17.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {


    private SpitterRepository spitterRepository;

    @Autowired
    public void setSpitterRepository(SpitterRepository repository) {
        this.spitterRepository = repository;
    }

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @Valid Spitter spitter,
            Errors errors
    ) {

        System.out.println(spitter.getUsername() + ",  "+ spitter.getPassword());
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                System.out.println(error.toString());
            }
            return "registerForm";
        }

        spitterRepository.save(spitter);

        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public String StringshwoPitterProfile(
        @PathVariable String userName, Model model
    ) {
        Spitter spitter = spitterRepository.findByUserName(userName);
        model.addAttribute(spitter);
        return "profile";
    }
}
