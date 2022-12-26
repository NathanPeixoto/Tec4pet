package br.com.tec4me.tec4pet.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.tec4me.tec4pet.model.Pet;
import br.com.tec4me.tec4pet.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService servico;

    @PostMapping
    public ResponseEntity<Pet> cadastrarPet(@RequestBody Pet pet)
    {
        return new ResponseEntity<>(servico.CadastrarPet(pet),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> ObterPets()
    {
        return new ResponseEntity<>(servico.obterTodasOsPets(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> obterPet(@PathVariable String id)
    {
        Optional<Pet> retorno = servico.ObterPetPorID(id);

        if(retorno.isPresent())
        {
            return new ResponseEntity<>(retorno.get(),HttpStatus.FOUND);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet>AtualizarPet(@PathVariable String id, @RequestBody Pet pet)
    {
        Optional<Pet> retorno = servico.AtualizarPetPorID(id, pet);
        
        if(retorno.isPresent())
        {
            return new ResponseEntity<>(retorno.get(),HttpStatus.ACCEPTED);
        }else
        {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPet(@PathVariable String id)
    {
        servico.ExcluirPetPorID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
