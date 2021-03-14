package com.midapp.spring_app.controllers;

import com.midapp.spring_app.models.Post;
import com.midapp.spring_app.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class DevController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/dev-section")
    public String devsection(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "dev-section";
    }

    @GetMapping("/dev-section/add")
    public String devAdd(Model model){
        return "dev-add";
    }

    @PostMapping("/dev-section/add")
    public String devPostAdd(@RequestParam String title, @RequestParam String description, @RequestParam String imagesrc, @RequestParam float price, Model model){
        Post post = new Post(title, description, imagesrc, price );
        postRepository.save(post);
        return "redirect:/dev-section";
    }

    @GetMapping("/dev-section/{id}")
    public String devUpdate(@PathVariable(value = "id") long id, Model model){
        if(!postRepository.existsById(id)){
            return "redirect:/dev-section";
        }
        Optional<Post> post=postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "dev-details";
    }

    @GetMapping("/dev-section/{id}/edit")
    public String devEdit(@PathVariable(value = "id") long id, Model model){
        if(!postRepository.existsById(id)){
            return "redirect:/dev-section";
        }
        Optional<Post> post=postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "dev-edit";
    }

    @PostMapping("/dev-section/{id}/edit")
    public String devPostEdit(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String description, @RequestParam String imagesrc, @RequestParam float price, Model model){
        Post post = postRepository.findById(id).orElseThrow(IllegalStateException::new);
        post.setTitle(title);
        post.setDescription(description);
        post.setImagesrc(imagesrc);
        post.setPrice(price);
        postRepository.save(post);
        return "redirect:/dev-section";
    }

    @PostMapping("/dev-section/{id}/delete")
    public String devPostDelete(@PathVariable(value = "id") long id, Model model){
        Post post = postRepository.findById(id).orElseThrow(IllegalStateException::new);

        postRepository.delete(post);
        return "redirect:/dev-section";
    }
}
