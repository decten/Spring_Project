package com.example.msa.composite.product;


import com.example.msa.util.http.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCompositeServiceImpl implements ProductCompositeService{

    private final ServiceUtil serviceUtil;

    @Autowired
    public ProductCompositeServiceImpl(ProductCompositeRepository repository,
        ProductCompositeMapper mapper, ServiceUtil serviceUtil) {
        this.repository = repository;
        this.mapper = mapper;
        this.serviceUtil = serviceUtil;
    }
}
