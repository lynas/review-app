package com.lynas.repository;

import com.lynas.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductCategory, Long>{}
