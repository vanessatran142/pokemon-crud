package com.pokemon;

import com.pokemon.repository.PokemonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PokemonRepository pokemonRepository;

    @BeforeEach
    public void setUp() {
        pokemonRepository.deleteAll();
    }

    @Test
    @DisplayName("Create a pokemon")
    public void shouldCreatePokemon() throws Exception {
        var pokemon = DataUtil.createPokemonContent("Bulbasaur", 1);
        mockMvc.perform(post("/pokemon").content(
                pokemon)).andExpect(
                status().isCreated()).andExpect(
                header().string("Location", containsString("pokemon/")));
    }

    @Test
    @DisplayName("Get a pokemon")
    public void shouldGetAPokemon() throws Exception {
        var pokemon = DataUtil.createPokemonContent("ABC", 1);
        var result = mockMvc.perform(post("/pokemon").content(pokemon))
                .andExpect((
                        status().isCreated()
                        )).andReturn();
        String location = result.getResponse().getHeader("Location");
        mockMvc.perform(get(location)).andExpect((status().isOk())).andExpect(
                jsonPath("$.name").value("ABC"))
                .andExpect(jsonPath("$.orderNumber").value(1)
        );
    }

    @Test
    @DisplayName("Find a pokemon by name")
    public void shouldQueryPokemonByName() throws Exception {
        var pokemon = DataUtil.createPokemonContent("ABC", 1);
        mockMvc.perform(post("/pokemon").content(pokemon))
                .andExpect((
                        status().isCreated()
                ));
        mockMvc.perform(
                get("/pokemon/search/findByName?name={name}", "ABC")
        ).andExpect(status().isOk()).andExpect(jsonPath("$._embedded.pokemon[0].name").value("ABC"));
    }

    @Test
    @DisplayName("Should update a pokemon")
    public void shouldUpdatePokemon() throws Exception {
        var pokemon = DataUtil.createPokemonContent("ABC", 1);
        var result = mockMvc.perform(post("/pokemon").content(pokemon))
                .andExpect((
                        status().isCreated()
                )).andReturn();

        String location = result.getResponse().getHeader("Location");
        var updatePokemon = DataUtil.createPokemonContent("DEF",2);

        assertThat(location).isNotNull();
        mockMvc.perform(put(location).content(
            updatePokemon
        )).andExpect(status().isNoContent());
        mockMvc.perform(get(location)).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("DEF"))
                .andExpect(jsonPath("$.orderNumber").value(2));
    }

    @Test
    @DisplayName("Partially update a pokemon")
    public void shouldPartiallyUpdateAPokemon() throws Exception {
        var pokemon = DataUtil.createPokemonContent("ABC", 1);
        var result = mockMvc.perform(post("/pokemon").content(pokemon))
                .andExpect((
                        status().isCreated()
                )).andReturn();

        String location = result.getResponse().getHeader("Location");

        assertThat(location).isNotNull();
        mockMvc.perform(patch(location).content("{\"name\": \"Kangaroo\"}"))
                .andExpect(status().isNoContent());

        mockMvc.perform(get(location)).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Kangaroo"));
    }

    @Test
    @DisplayName("Should delete a pokemon")
    public void shouldDeleteAPokemon() throws Exception {
        var pokemon = DataUtil.createPokemonContent("ABC", 1);
        var result = mockMvc.perform(post("/pokemon").content(pokemon))
                .andExpect((
                        status().isCreated()
                )).andReturn();

        String location = result.getResponse().getHeader("Location");
        assertThat(location).isNotNull();
        mockMvc.perform(delete(location)).andExpect(status().isNoContent());

        mockMvc.perform(get(location)).andExpect(status().isNotFound());
    }
}
