package com.rafael.bortoli.controller;

import java.util.List;

import com.rafael.bortoli.dtos.ClubeResponseDto;
import com.rafael.bortoli.model.Clube;
import com.rafael.bortoli.service.ClubeService;
import com.rafael.bortoli.service.ClubeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClubeController {

    @Autowired
    ClubeService clubeService;

    @GetMapping("/showNewClubeForm")
    public String showNewClubeForm(Model model) {
        Clube clube = new Clube();
        model.addAttribute("clube", clube);
        return "new_clube";
    }

    @PostMapping("/saveClube")
    public String saveClube(@ModelAttribute("clube") Clube clube) {
        clubeService.save(clube);
        return "redirect:/";
    }

    @PostMapping("/editClube/{id}")
    public String editClube(@PathVariable("id") Long id, @ModelAttribute("clube") Clube clube) {
        clubeService.edit(id, clube);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Clube clube = clubeService.findById(id);

        model.addAttribute("clube", clube);
        return "update_clube";
    }

    @GetMapping("/deleteClube/{id}")
    public String deleteClube(Model model, @PathVariable(value = "id") long id) {
        ClubeResponseDto responseDto = clubeService.delete(id);

        List<Clube> clubes = clubeService.getAllSorted();
        model.addAttribute("listClubes", clubes);
        model.addAttribute("errors", responseDto.getErrors());

        return "index";
    }
}
