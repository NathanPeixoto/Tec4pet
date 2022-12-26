package br.com.tec4me.tec4pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tec4me.tec4pet.model.Pet;
import br.com.tec4me.tec4pet.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private PetRepository repositorio;
    
    @Override
    public Pet CadastrarPet(Pet pet) {
        return repositorio.save(pet);
    }

    @Override
    public void ExcluirPetPorID(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public Optional<Pet> AtualizarPetPorID(String id, Pet pet) {
        Optional<Pet> retorno  = repositorio.findById(id);
        
        if(retorno.isPresent()){
            pet.setId(id);
            return Optional.of(repositorio.save(pet));
            
        }else{
            return Optional.empty();
        }
    }

    @Override
    public List<Pet> obterTodasOsPets() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Pet> ObterPetPorID(String id) {
        return repositorio.findById(id);
    }
    
}
