package com.rafael.bortoli.controller;

import com.rafael.bortoli.model.Clube;
import com.rafael.bortoli.service.ClubeService;
import com.rafael.bortoli.service.ClubeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ClubeService clubeService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Clube> clubes = clubeService.getAllSorted();
        model.addAttribute("listClubes", clubes);

        return "index";
    }
}
