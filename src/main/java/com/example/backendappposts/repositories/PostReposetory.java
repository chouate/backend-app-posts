package com.example.backendappposts.repositories;

import com.example.backendappposts.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostReposetory extends JpaRepository<Post, Long> {

}
