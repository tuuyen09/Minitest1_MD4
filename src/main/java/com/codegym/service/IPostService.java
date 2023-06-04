package com.codegym.service;

import com.codegym.model.Post;

import java.util.List;

public interface IPostService {
    public List<Post> findAll();
    public void savePost(Post post);
    public Post findPostById(int id);
    public void removePostById(int id);
    public void updatePostById(int id,Post post);
}
