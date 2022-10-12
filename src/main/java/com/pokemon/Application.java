package com.pokemon;

import com.pokemon.entity.Pokemon;
import com.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private PokemonRepository pokemonRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Initialize the Database at application startup.
     *
     * @param strings
     * @throws Exception
     */
    @Override
    public void run(String... strings) {
        String line = "";
        String splitBy = ",";
        try {
            //parsing a CSV file into BufferedReader class constructor
            InputStream is = Application.class.getResourceAsStream("/pokemon.csv");
            InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null)   //returns a Boolean value
            {
                String[] properties = line.split(splitBy);
                if (!isFirstLine) {
                    this.pokemonRepository.save(
                            new Pokemon(Long.parseLong(properties[0]),
                                    properties[1],
                                    properties[2],
                                    properties[3],
                                    Integer.parseInt(properties[4]),
                                    Integer.parseInt(properties[5]),
                                    Integer.parseInt(properties[6]),
                                    Integer.parseInt(properties[7]),
                                    Integer.parseInt(properties[8]),
                                    Integer.parseInt(properties[9]),
                                    Integer.parseInt(properties[10]),
                                    Integer.parseInt(properties[11]),
                                    Boolean.parseBoolean(properties[12]))
                    );
                }
                isFirstLine = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}