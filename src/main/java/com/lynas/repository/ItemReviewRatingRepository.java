package com.lynas.repository;

import com.lynas.model.Item;
import com.lynas.model.ItemReviewRating;
import com.lynas.model.ReviewAspect;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemReviewRatingRepository extends CrudRepository<ItemReviewRating, Long> {

    List<ItemReviewRating> findByItemAndReviewAspect(Item item, ReviewAspect reviewAspect);

}
