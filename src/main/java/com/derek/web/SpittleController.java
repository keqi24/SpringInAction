package com.derek.web;

import com.derek.model.Spittle;
import com.derek.repository.SpittleRepository;
import com.derek.web.exception.DuplicateSpittleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by qux on 19/8/17.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);
    public static final String MAX_ID_LONG = "223372036854775807";
    private SpittleRepository spittleRepository;

    @Autowired
    public void setSpittleRepository(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
//        model.addAttribute("spittleList", spittleRepository.findSpittle(Long.MAX_VALUE, 20));
//        return "spittles";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_ID_LONG) long max,
            @RequestParam(value = "count", defaultValue = "20") int count
    ) {
        return spittleRepository.findSpittle(max, count);
    }


    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model
    ) {
        model.addAttribute("spittle", spittleRepository.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm form, Model model) {
        spittleRepository.save(new Spittle(0, form.getMessage(), System.currentTimeMillis()));
        return "redirect:/spittles";
    }

    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateError() {
        return "error/duplicate";
    }
}
