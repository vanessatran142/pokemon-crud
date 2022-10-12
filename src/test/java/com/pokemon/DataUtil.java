package com.pokemon;

public class DataUtil {
    public static String createPokemonContent(String name, int orderNumber) {
       return "{\n" +
                "    \"orderNumber\": " + orderNumber + ",\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"type1\": \"Grass\",\n" +
                "    \"type2\": \"Poison\",\n" +
                "    \"total\": 318,\n" +
                "    \"hp\": 45,\n" +
                "    \"attack\": 49,\n" +
                "    \"defense\": 49,\n" +
                "    \"spAttack\": 65,\n" +
                "    \"spDefense\": 65,\n" +
                "    \"speed\": 65,\n" +
                "    \"generation\": 1,\n" +
                "    \"legendary\": false\n" +
                "}";
    }
}
