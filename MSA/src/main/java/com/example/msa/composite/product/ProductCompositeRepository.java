package com.example.msa.composite.product;

import org.springframework.data.repository.PagingAndSortingRepository;
public interface ProductCompositeRepository extends
    PagingAndSortingRepository<ProductCompositeEntity, String>{

}
