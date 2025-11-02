package com.yash.Joblisting.controller;

import com.yash.Joblisting.Repository.PostRepository;
import com.yash.Joblisting.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private PostRepository repo;

    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal OAuth2User principal) {
        if(principal != null) {
            String name = principal.getAttribute("name");
            model.addAttribute("username", name);
        }
        return "home"; // home.jsp
    }

    @GetMapping("/findJob")
    public String findJob(Model model, @RequestParam(value = "search", required = false) String search) {
        List<Post> jobs;
        if (search != null && !search.isEmpty()) {
            jobs = repo.findAll().stream()
                    .filter(job -> job.getProfile().toLowerCase().contains(search.toLowerCase())
                            || job.getDesc().toLowerCase().contains(search.toLowerCase()))
                    .toList();
        } else {
            jobs = repo.findAll();
        }
        model.addAttribute("jobs", jobs);
        return "findJob"; // findJob.jsp
    }

    @GetMapping("/registerJob")
    public String registerJobForm() {
        return "registerJob"; // registerJob.jsp
    }

    @PostMapping("/registerJob")
    public String submitJob(@RequestParam String profile,
                            @RequestParam int exp,
                            @RequestParam String desc,
                            @RequestParam String techs) {
        Post post = new Post();
        post.setProfile(profile);
        post.setExp(exp);
        post.setDesc(desc);
        post.setTechs(Arrays.stream(techs.split(",")).map(String::trim).toArray(String[]::new));

        repo.save(post);
        return "redirect:/findJob";
    }
}
