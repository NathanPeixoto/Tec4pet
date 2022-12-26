package br.com.tec4me.tec4pet.service;

import java.util.List;
import java.util.Optional;

import br.com.tec4me.tec4pet.model.Pet;

public interface PetService {

    Pet CadastrarPet(Pet pizza);
    void ExcluirPetPorID(String id);
    Optional<Pet> AtualizarPetPorID(String id, Pet pet);
    public List<Pet> obterTodasOsPets();
    public Optional<Pet> ObterPetPorID(String id);

}
