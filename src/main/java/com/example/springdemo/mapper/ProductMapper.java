package com.example.springdemo.mapper;

import com.example.springdemo.entity.ProductEntity;
import com.example.springdemo.mapper.dto.Product;
import com.example.springdemo.repository.ProducerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class ProductMapper extends AbstractMapper<ProductEntity, Product> {
    private final ProducerRepository producerRepository;
    private final ModelMapper mapper;

    @Autowired
    public ProductMapper(ModelMapper mapper, ProducerRepository repository) {
        super(ProductEntity.class, Product.class);
        this.mapper = mapper;
        this.producerRepository = repository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(ProductEntity.class, Product.class)
                .addMappings(m -> m.skip(Product::setProducerId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(Product.class, ProductEntity.class)
                .addMappings(m -> m.skip(ProductEntity::setProducer)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(ProductEntity source, Product destination) {
        destination.setProducerId(getId(source));
    }

    private Long getId(ProductEntity source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getProducer().getId();
    }

    @Override
    void mapSpecificFields(Product source, ProductEntity destination) {
        destination.setProducer(producerRepository.findById(source.getProducerId()).orElse(null));
    }
}
