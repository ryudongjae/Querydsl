package com.example.Querydsl.repository;

import com.example.Querydsl.domain.Post;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import static com.example.Querydsl.domain.QPost.post;
import static com.example.Querydsl.domain.QTeam.team;
import static com.example.Querydsl.domain.QUser.user;

@RequiredArgsConstructor
public class CustomizedPostRepositoryImpl implements CustomizedPostRepository {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<Post> descPostId() {
        return jpaQueryFactory
                .selectFrom(post)
                .orderBy(post.id.desc())
                .fetch();
    }

    @Override
    public List<Post> ascPostId() {
        return jpaQueryFactory
                .selectFrom(post)
                .orderBy(post.id.asc())
                .fetch();
    }

    @Override
    public List<Post> resultPost() {
        return jpaQueryFactory
                .selectFrom(post)
                .orderBy(post.id.desc(),post.title.asc())
                .fetch();
    }

    @Override
    public List<Post> result() {
        return jpaQueryFactory
                .selectFrom(post)
                .orderBy(post.id.desc(),post.title.asc().nullsLast())
                .fetch();
    }

    @Override
    public List<Post> fetchList() {
        return jpaQueryFactory
                .selectFrom(post)
                .fetch();
    }

    @Override
    public Post fetchOne() {
        return jpaQueryFactory
                .selectFrom(post)
                .fetchOne();
    }

    @Override
    public Post fetchFirst() {
        return jpaQueryFactory
                .selectFrom(post)
                .fetchFirst();
    }

    @Override
    public QueryResults<Post> fetchResult() {
        return jpaQueryFactory
                .selectFrom(post)
                .fetchResults();
    }

    @Override
    public long fetchCount() {
        return jpaQueryFactory
                .selectFrom(post)
                .fetchCount();
    }

    @Override
    public List<Post> pagingResult() {
         QueryResults<Post> result = jpaQueryFactory
                .selectFrom(post)
                .orderBy(post.id.desc())
                .offset(0)
                .limit(3)
                .fetchResults();

        long total =  result.getTotal();
        long limit = result.getLimit();
        long offset = result.getOffset();
        List<Post> results = result.getResults();

        return results;
    }

    @Override
    public List<Tuple> aggregationResult() {
         List<Tuple> result = jpaQueryFactory
                .select(
                      team.name,
                        user.age.avg(),
                        user.age.min(),
                        user.age.max()
                )
                .from(user)
                .join(user.team, team)
                .groupBy(team.name)
                .having(team.name.eq("A"))
                 .fetch();

        Tuple team1 = result.get(0);

        String teamName = team1.get(team.name);
        Long team1Cnt = team1.get(user.count());
        Double team1AgeAvg = team1.get(user.age.avg());
        Integer team1MinAge = team1.get(user.age.min());
        Integer team1MaxAge = team1.get(user.age.max());


        return result;
    }
}
