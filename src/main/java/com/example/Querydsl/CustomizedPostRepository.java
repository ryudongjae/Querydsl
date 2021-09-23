package com.example.Querydsl;

import java.util.List;

public interface CustomizedPostRepository {
    List<Post> findByTitle(String title);
}
