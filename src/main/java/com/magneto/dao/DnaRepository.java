package com.magneto.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magneto.model.Dna;

public interface DnaRepository extends MongoRepository<Dna, String> {

}
