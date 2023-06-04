package com.codegym.controller;

import com.codegym.model.Post;
import com.codegym.service.IPostService;
import com.codegym.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/post", produces = "text/html;charset=UTF-8")
public class PostController {
    private final IPostService postService = new PostService();

    @GetMapping("")
    public String home(ModelMap modelMap) {
        List<Post> postList = postService.findAll();
        modelMap.addAttribute("postList", postList);
        return "/home";
    }

    @GetMapping("/create")
    public String create(ModelMap mode) {
        mode.addAttribute("post", new Post());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Post post, RedirectAttributes redirectAttributes) {
        postService.savePost(post);
        redirectAttributes.addFlashAttribute("success", "Add new successful!");
        return "redirect:/post";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("post", postService.findPostById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam int id, Post post, RedirectAttributes redirectAttributes) {
        postService.updatePostById(id, post);
        redirectAttributes.addFlashAttribute("success", "Update successful!");
        return "redirect:/post";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, ModelMap mode) {
        mode.addAttribute("post", postService.findPostById(id));
        return "/view";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, ModelMap mode) {
        mode.addAttribute("post", postService.findPostById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Post post, RedirectAttributes redirectAttributes) {
        postService.removePostById(post.getId());
        redirectAttributes.addFlashAttribute("success", "Delete successful!");
        return "redirect:/post";
    }
}