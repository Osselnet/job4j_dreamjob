package ru.job4j.dreamjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.store.CandidateStore;

@Controller
public class CandidateController {
    private final CandidateStore store = CandidateStore.instOf();

    @GetMapping("/candidates")
    public String candidates(Model model) {
        model.addAttribute("candidates", store.findAll());
        return "candidates";
    }

    @GetMapping("/formAddCandidate")
    public String postForm(Model model) {
        model.addAttribute("candidate", new Candidate());
        return "addCandidate";
    }

    @PostMapping("/formAddCandidate")
    public String addPost(@ModelAttribute Candidate candidate, Model model) {
        store.addCandidate(candidate);
        model.addAttribute("candidate", candidate);
        return "addCandidate";
    }

}
