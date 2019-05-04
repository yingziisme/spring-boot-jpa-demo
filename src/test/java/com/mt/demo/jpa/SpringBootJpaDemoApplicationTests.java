package com.mt.demo.jpa;

import com.alibaba.fastjson.JSON;
import com.github.wenhao.jpa.Specifications;
import com.mt.demo.jpa.entity.AnimalEntity;
import com.mt.demo.jpa.entity.CatEntity;
import com.mt.demo.jpa.entity.DogEntity;
import com.mt.demo.jpa.entity.view.DogView;
import com.mt.demo.jpa.repository.CatRepository;
import com.mt.demo.jpa.repository.DogRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaDemoApplicationTests {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private CatRepository catRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private String[] dogVoice = {"dog corgi", "dog husky", "dog akita", "dog collie", "dog dachshund", "dog poodle", "dog samoyed"};

    private String[] catVoice = {"cat Persian", "cat Birman", "cat Ragdoll", "cat Scottish", "cat Manx"};

    private String[] sex = {"male", "female"};
    private Random random = new Random();

    @Test
    public void contextLoads() {
    }


    private void createAnimal(AnimalEntity animalEntity, int i, int count) {

        animalEntity.setAge(random.nextInt(20));
        animalEntity.setHeight(random.nextInt(5));
        animalEntity.setWeight(random.nextInt(100));
        animalEntity.setName(UUID.randomUUID().toString().replaceAll("-", ""));
        animalEntity.setSex(sex[i & 1]);
        if (count > 0) {
            animalEntity.setPid(new Integer(random.nextInt(count)).longValue());
        }


    }

    private void createAdog(int i) {
        DogEntity dogEntity = new DogEntity();
        dogEntity.setWang(dogVoice[i % dogVoice.length]);

        createAnimal(dogEntity, i, new Long(dogRepository.count()).intValue());
        dogRepository.save(dogEntity);
    }

    private void createAcat(int i) {
        CatEntity catEntity = new CatEntity();
        catEntity.setMiao(catVoice[i % catVoice.length]);

        createAnimal(catEntity, i, new Long(catRepository.count()).intValue());
        catRepository.save(catEntity);
    }

    @Test
    public void createTestData() {

        for (int i = 0; i < 20; i++) {

            createAcat(i);
            createAdog(i);
        }
    }
}
