package br.com.tec4me.tec4pet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tec4me.tec4pet.model.Pet;

public interface PetRepository extends MongoRepository<Pet,String> {
    
}
