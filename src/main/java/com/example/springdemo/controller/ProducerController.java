package com.example.springdemo.controller;

import com.example.springdemo.entity.ProducerEntity;
import com.example.springdemo.mapper.dto.Producer;
import com.example.springdemo.service.ProducerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/producers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerController {
    private final ProducerService service;

    /**
     * @param producer target entity to be created
     * @return created entity, HTTP status OK
     */
    @PostMapping
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Producer> createProducer(@RequestBody Producer producer) {
        service.createProducer(producer);
        return new ResponseEntity<>(producer, HttpStatus.OK);
    }

    /**
     * @param producer target entity to update
     * @return response with updated entity and http status OK
     */
    @PutMapping(path = "/{id}")
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Producer> updateProducer(@RequestBody Producer producer) {
        service.updateProducer(producer);
        return new ResponseEntity<>(producer, HttpStatus.OK);
    }

    /**
     * @return list of all producers
     */
    @GetMapping
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<Producer> findAll() {
        return service.findAll();
    }

    /**
     * @param id target producer id
     * @param entity producerEntity to delete
     * @return Http status with result
     */
    @DeleteMapping(path = "/{id}")
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<ProducerEntity> deleteProducer(@PathVariable(value = "id") Long id, ProducerEntity entity) {
        if (service.findProducerById(id) != null) {
            service.deleteProducer(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(entity, HttpStatus.NOT_FOUND);
    }

    /**
     * @param id target producer id
     * @return response entity with producer inside if present
     */
    @GetMapping(path = "/{id}")
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Producer> getProducer(@PathVariable("id") Long id) {
        Producer producer = service.findProducerById(id);
        if (producer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(producer, HttpStatus.OK);
    }
}
