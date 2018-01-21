package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
