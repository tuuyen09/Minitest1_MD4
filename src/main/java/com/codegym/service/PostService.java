package com.codegym.service;

import com.codegym.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostService implements IPostService {
    public static final Map<Integer, Post> posts = new HashMap<>();

    static {
        posts.put(1, new Post(1, "A", "a", "10-5-2023"));
        posts.put(2, new Post(2, "B", "b", "30-3-2023"));
        posts.put(3, new Post(3, "C", "c", "2-2-2023"));
        posts.put(4, new Post(4, "D", "d", "19-4-2023"));
        posts.put(5, new Post(5, "E", "e", "5-3-2023"));
        posts.put(6, new Post(6, "F", "f", "1-5-2023"));
        posts.put(7, new Post(7, "G", "g", "20-1-2023"));
        posts.put(8, new Post(8, "H", "h", "4-4-2023"));
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public void savePost(Post post) {
        posts.put(post.getId(), post);
    }

    @Override
    public Post findPostById(int id) {
        return posts.get(id);
    }

    @Override
    public void removePostById(int id) {
        posts.remove(id);
    }

    @Override
    public void updatePostById(int id, Post post) {
        posts.put(id, post);
    }
}
