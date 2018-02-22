package com.lynas.service;

import com.lynas.exception.EntityNotFoundException;
import com.lynas.model.ReviewAspect;
import com.lynas.repository.ReviewAspectRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewAspectService {
    private final ReviewAspectRepository reviewAspectRepository;

    public ReviewAspectService(ReviewAspectRepository reviewAspectRepository) {
        this.reviewAspectRepository = reviewAspectRepository;
    }

    public ReviewAspect findById(Long id) throws EntityNotFoundException {
        final ReviewAspect reviewAspect = reviewAspectRepository.findOne(id);
        if (reviewAspect == null) {
            throw new EntityNotFoundException("ReviewAspect not found with id: " + id);
        }
        return reviewAspect;
    }
}
