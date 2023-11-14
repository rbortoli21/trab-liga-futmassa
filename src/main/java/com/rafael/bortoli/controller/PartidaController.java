package com.rafael.bortoli.controller;

import com.rafael.bortoli.dtos.PartidaRequestDto;
import com.rafael.bortoli.dtos.PartidaResponseDto;
import com.rafael.bortoli.model.Clube;
import com.rafael.bortoli.model.Partida;
import com.rafael.bortoli.service.ClubeService;
import com.rafael.bortoli.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PartidaController {
    @Autowired
    PartidaService partidaService;
    @Autowired
    ClubeService clubeService;

    @GetMapping("/showNewPartidaForm")
    public String showNewPartidaForm(Model model) {
        PartidaRequestDto partidaRequest = new PartidaRequestDto();
        List<Clube> clubes = clubeService.getAll();
        if (clubes == null || clubes.isEmpty())
            model.addAttribute("erro", "Não é possível iniciar uma partida se não há times.");

        model.addAttribute("partida", partidaRequest);
        model.addAttribute("clubes", clubes);
        return "new_partida";
    }

    @GetMapping("/showLastPartidas")
    public String showLastPartidas(Model model) {
        List<Partida> partidas = partidaService.getAll();
        model.addAttribute("partidas", partidas);

        return "ultimas_partidas";
    }

    @PostMapping("/savePartida")
    public String savePartida(Model model, @ModelAttribute("partida") PartidaRequestDto partidaRequestDto) {
        PartidaResponseDto response = partidaService.save(partidaRequestDto);
        if (response.getErrors() != null && response.getErrors().isEmpty())
            return "redirect:/";

        model.addAttribute("errors", response.getErrors());
        return showNewPartidaForm(model);
    }

}
