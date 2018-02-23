package com.lynas.controller;

import com.lynas.dto.RateItemReviewDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReviewAspectRatingControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void rateReviewAspectOfItemTest() {
        RateItemReviewDTO rateItemReviewDTO = new RateItemReviewDTO(1L, 1L, 5);
        ResponseEntity<HashMap> response = restTemplate.postForEntity(
                "/rate",
                rateItemReviewDTO, HashMap.class);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody().get("success"), true);
    }

    @Test
    public void getItemReviewAspectRatingTest() {
        ResponseEntity<List> response = restTemplate.getForEntity("/rate/item/1", List.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        HashMap hashMap = (HashMap) response.getBody().get(0);
        assertEquals(hashMap.get("avgScore"), 0.0);
        assertEquals(hashMap.get("reviewAspectName"), "Presentation");
    }
}
