package com.lynas.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReviewAspectRatingControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void rateReviewAspectOfItemTest() {
        ResponseEntity<String> response = restTemplate.postForEntity(
                "/rate/item/1/review_aspect/1/score/4",
                null,String.class);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody(), "true");
    }

    @Test
    public void getItemReviewAspectRatingTest(){
        ResponseEntity<HashMap> response = restTemplate.getForEntity("/rate/item/1",HashMap.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().get("Temperature"), 0.0);
    }
}
