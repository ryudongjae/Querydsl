package com.example.Querydsl.repository;

import com.example.Querydsl.domain.Post;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;

import java.util.List;

public interface CustomizedPostRepository {
    List<Post> descPostId();
    List<Post> ascPostId();
    List<Post> resultPost();
    List<Post> result();
    List<Post> fetchList();
    Post fetchOne();
    Post fetchFirst();
    QueryResults<Post> fetchResult();
    long fetchCount();
    List<Post> pagingResult();
    List<Tuple> aggregationResult();
}
