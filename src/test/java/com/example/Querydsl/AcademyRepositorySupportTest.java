package com.example.Querydsl;

import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AcademyRepositorySupportTest {

    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private AcademyRepositorySupport academyRepositorySupport;


    @After
    public void tearDown() throws Exception{
        academyRepository.deleteAllInBatch();
    }

    @Test
    void querydsl()throws Exception{
        //given
        String name = "ryudongjae";
        String address = "rdj1014@naver.com";
        academyRepository.save(new Academy(name,address));
        //when
        List<Academy> result = academyRepositorySupport.findByName(name);

        //then
        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(1);
        org.assertj.core.api.Assertions.assertThat(result.get(0).getAddress()).isEqualTo(address);

    }
}