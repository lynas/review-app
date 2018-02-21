package com.lynas;

import com.lynas.model.Item;
import com.lynas.model.Organization;
import com.lynas.model.ProductCategory;
import com.lynas.model.ReviewAspect;
import com.lynas.repository.ItemRepository;
import com.lynas.repository.OrganizationRepository;
import com.lynas.repository.ProductRepository;
import com.lynas.repository.ReviewAspectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer {
    ProductCategory productCategory1 = new ProductCategory(1L, "Food & Drinks");
    ProductCategory productCategory2 = new ProductCategory(2L, "Cloths");
    Organization organization1 = new Organization(1L, "KFC", productCategory1);
    Organization organization2 = new Organization(2L, "BFC", productCategory1);
    ReviewAspect reviewAspect1 = new ReviewAspect(1L, "Taste");
    ReviewAspect reviewAspect2 = new ReviewAspect(2L, "Temperature");
    ReviewAspect reviewAspect3 = new ReviewAspect(3L, "Presentation");

    Item item1 = new Item(1L, "Break Fast", organization1);
    Item item2 = new Item(1L, "Lunch", organization1);
    Item item3 = new Item(1L, "Dinner", organization1);




    @Bean
    public CommandLineRunner productInit(ProductRepository productRepository) {
        return str -> {
            productRepository.save(productCategory1);
            productRepository.save(productCategory2);
            productRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    public CommandLineRunner organizationInit(OrganizationRepository organizationRepository) {
        return str -> {
            organizationRepository.save(organization1);
            organizationRepository.save(organization2);
            organizationRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    public CommandLineRunner reviewInit(ReviewAspectRepository reviewAspectRepository) {
        return str -> {
            reviewAspectRepository.save(reviewAspect1);
            reviewAspectRepository.save(reviewAspect2);
            reviewAspectRepository.save(reviewAspect3);
            reviewAspectRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    public CommandLineRunner itemInit(ItemRepository itemRepository) {
        return str -> {
            Set<ReviewAspect> reviewSet = new HashSet<>();
            reviewSet.add(reviewAspect1);
            reviewSet.add(reviewAspect2);
            reviewSet.add(reviewAspect3);
            item1.setReviewAspects(reviewSet);
            item2.setReviewAspects(reviewSet);
            item3.setReviewAspects(reviewSet);
            itemRepository.save(item1);
            itemRepository.save(item2);
            itemRepository.save(item3);

            itemRepository.findAll().forEach(System.out::println);
        };
    }
}
