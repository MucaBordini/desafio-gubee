package com.estagio.gubee.desafio.resource.adapter;

import com.estagio.gubee.desafio.domain.technologies.model.Technologies;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoTechnologiesRepository extends MongoRepository<Technologies, String> {

    @Query("{ $and: [ { stack: {$regex: ?0, $options: 'i'} }, { 'targetMarket': { $regex: ?1, $options: 'i' } } ] }")
    List<Technologies> fullSearch(String stack, String marketTarget);

    List<Technologies> findAll();

    Technologies save(Technologies technology);

}
