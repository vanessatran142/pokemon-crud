package com.pokemon.repository;

import com.pokemon.entity.Pokemon;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "pokemon", path="pokemon")
public interface PokemonRepository extends PagingAndSortingRepository<Pokemon, Long> {
    /**
     * Add a custom query, query pokemons by property "name"
     * @param name
     * @return
     */
    List<Pokemon> findByName(@Param("name") String name);
}