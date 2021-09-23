package com.example.Querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.Querydsl.QPost.post;

@Repository
@RequiredArgsConstructor
public class PostQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;



    public List<Post>findByTitle(String title){
        return jpaQueryFactory.selectFrom(post)
                .where(post.title.eq(title))
                .fetch();
    }
}
