package com.example.Querydsl.repository;

import com.example.Querydsl.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long>, CustomizedPostRepository {
}
