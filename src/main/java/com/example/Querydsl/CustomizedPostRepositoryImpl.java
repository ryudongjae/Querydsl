package com.example.Querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.Querydsl.QPost.post;
@RequiredArgsConstructor
public class CustomizedPostRepositoryImpl implements CustomizedPostRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Post> findByTitle(String title) {
        return jpaQueryFactory.selectFrom(post)
                .where(post.title.eq(title))
                .fetch();
    }
}
