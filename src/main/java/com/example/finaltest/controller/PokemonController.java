package com.example.finaltest.controller;
import com.example.finaltest.entities.Pokemon;
import com.example.finaltest.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    @Autowired
    PokemonRepository pokemonRepository;
    @GetMapping("/{tipoPokemon}")
    public Pokemon getPokemonsbyTipo(@PathVariable Integer tipoPokemon) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(tipoPokemon);
        if (pokemon.isPresent()) {
            return pokemon.get();
        }
        return null;
    }
    @PostMapping
    public Pokemon postPokemons(@RequestBody Pokemon pokemon) {
        pokemonRepository.save(pokemon);
        return pokemon;
    }
}