package com.example.Querydsl;

import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class QuerydslApplicationTests {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostRepositorySupport postRepositorySupport;

	@Autowired
	private PostQueryRepository postQueryRepository;

	@After
	public void tearDown()throws Exception{
		postRepository.deleteAllInBatch();
	}

	@BeforeEach
	public void clean(){
		postRepository.deleteAll();
	}

	@Test
	@DisplayName("기본 설정")
	void querydsl1()throws Exception{
	    //given
		postRepository.saveAll(Arrays.asList(
			new Post("title","content1"),
			new Post("title","content2"),
			new Post("title","content3"),
			new Post("title","content4"),
			new Post("title","content5")

		));
	    //when
		List<Post> title = postRepositorySupport.findByTitle("title");
		//then
		Assertions.assertAll(
				()-> org.assertj.core.api.Assertions.assertThat(title).hasSize(5),
				() -> org.assertj.core.api.Assertions.assertThat(title.get(0).getTitle()).isEqualTo("title")
		);

	}

	@Test
	@DisplayName("CustomRepository 적용")
	void querydsl2()throws Exception{
		//given
		postRepository.saveAll(Arrays.asList(
				new Post("title","content1"),
				new Post("title","content2"),
				new Post("title","content3"),
				new Post("title","content4"),
				new Post("title","content5")

		));
		//when
		List<Post> title = postRepositorySupport.findByTitle("title");
		//then
		Assertions.assertAll(
				()-> org.assertj.core.api.Assertions.assertThat(title).hasSize(5),
				() -> org.assertj.core.api.Assertions.assertThat(title.get(0).getTitle()).isEqualTo("title")
		);

	}

	@Test
	@DisplayName("상속 구현 없은 Repository , Querydsl 만 사용")
	void querydsl3()throws Exception{
		//given
		postRepository.saveAll(Arrays.asList(
				new Post("title","content1"),
				new Post("title","content2"),
				new Post("title","content3"),
				new Post("title","content4"),
				new Post("title","content5")

		));
		//when
		List<Post> title = postQueryRepository.findByTitle("title");
		//then
		Assertions.assertAll(
				()-> org.assertj.core.api.Assertions.assertThat(title).hasSize(5),
				() -> org.assertj.core.api.Assertions.assertThat(title.get(0).getTitle()).isEqualTo("title")
		);

	}

}
