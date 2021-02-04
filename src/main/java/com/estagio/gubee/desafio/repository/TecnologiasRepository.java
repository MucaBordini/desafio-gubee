package com.estagio.gubee.desafio.repository;

import com.estagio.gubee.desafio.domain.Tecnologias;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TecnologiasRepository extends MongoRepository<Tecnologias, String> {

    @Query("{ $and: [ { stack: {$regex: ?0, $options: 'i'} }, { 'productName': { $regex: ?1, $options: 'i' } } ] }")
    List<Tecnologias> fullSearch(String stack, String product);


}
