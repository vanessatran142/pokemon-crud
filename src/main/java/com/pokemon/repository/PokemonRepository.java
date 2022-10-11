package com.pokemon.repository;

import com.pokemon.entity.Pokemon;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "pokemon", path="pokemon")
public interface PokemonRepository extends PagingAndSortingRepository<Pokemon, Long> {
}