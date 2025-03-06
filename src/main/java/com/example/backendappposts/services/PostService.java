package com.example.backendappposts.services;

import com.example.backendappposts.entities.Post;
import com.example.backendappposts.repositories.PostReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostService {
    @Autowired
    private PostReposetory postReposetory;
    public PostService(PostReposetory postReposetory) {
        this.postReposetory = postReposetory;

    }

    public List<Post> findAll() {
        return postReposetory.findAll();
    };

    public Post findById(Long id) {
        return postReposetory.findById(id).orElse(null);
    }

    public Post save(Post post) {
        return postReposetory.save(post);
    }

    public  Post update(Long id, Post postDetails) {
         return  postReposetory.findById(id).map( post -> {
                 post.setTitle(postDetails.getTitle());
                 post.setBody(postDetails.getBody());
                 post.setUserId(postDetails.getUserId());
                 return postReposetory.save(post);

                 }).orElseThrow(() -> new RuntimeException("Could not find post"));
    }
    public void deletePost(Long id) {
        postReposetory.deleteById(id);
    }


}
