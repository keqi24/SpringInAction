package com.derek.web;

import com.derek.model.Spitter;
import com.derek.repository.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

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
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @Valid SpitterForm spitterForm,
            Errors errors, Model model
    ) throws IOException {

        if (errors.hasErrors()) {
            model.addAttribute("spitter", spitterForm);
            System.out.println(errors);
            return "registerForm";
        }

        Spitter spitter = spitterForm.toSpitter();
        spitterRepository.save(spitter);
        MultipartFile profilePicture = spitterForm.getProfilePicture();
        profilePicture.transferTo(new File("/tmp/spittr/" + spitter.getUsername()));
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
