package Operation;

import models.TrainerPkmn;
import models.Pokemon;
import models.Pokedex;
import models.Badges;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Random;
import java.io.*;
import java.util.*;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Operation {
    //NO SE SI ESTA JODA FUNCIONE :D
    public static String IdTrainer(){
        Set<String> Usados = new HashSet<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader("trainers.csv"))){
            String line;
            while ((line = buffer.readLine()) != null){
                Usados.add(line.split(",")[0]);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        Random random = new Random();
        String nuevo;

        do {
            nuevo = String.valueOf(100000 + random.nextInt(900000));
        }

        while (Usados.contains(nuevo));
        return nuevo;
    }

    public  static void saveTrainer(TrainerPkmn trainerToSave) {
        trainerToSave.setId(IdTrainer());

        try (FileWriter writer = new FileWriter("trainers.csv", true);){
            writer.write(trainerToSave.trainerToCSV());
            writer.write("\n");
            writer.close();
            System.out.println("Trainer saved successfully");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void UpdateTrainer(TrainerPkmn trainerToUpdate) {
        StringBuilder contenido = new StringBuilder();
        boolean encontrado = false;

        try {
            FileReader reader = new FileReader("trainers.csv");
            BufferedReader buffer = new BufferedReader(reader);
            String trainerReader;

            while ((trainerReader = buffer.readLine()) != null){
                if (trainerReader.isBlank()) continue;
                String[] d = trainerReader.split(",", -1);
                if (d.length < 4) continue;

                if (!encontrado && d[1].equalsIgnoreCase(trainerToUpdate.getTrainerName())){
                    encontrado = true;
                    if (d.length < 4){
                        d = Arrays.copyOf(d, 4);
                    }
                    d[2] = String.valueOf(trainerToUpdate.getBadges());
                    d[3] = String.valueOf(trainerToUpdate.getEquipoPkmn());
                }
                contenido.append(String.join(",", d)).append("\n");
            }
            buffer.close();

            if (encontrado){
                FileWriter writer = new FileWriter("trainers.csv", false);
                writer.write(contenido.toString());
                writer.close();
                System.out.println("Trainer updated successfully");
            }
            else  {
                System.out.println("No se pudo actualizar el trainer");
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void DeleteTrainer(TrainerPkmn trainerToDelete) {
        StringBuilder contenido = new StringBuilder();
        boolean encontrado = false;

        try {
            FileReader reader = new FileReader("trainers.csv");
            BufferedReader buffer = new BufferedReader(reader);
            String trainerReader;

            while ((trainerReader = buffer.readLine()) != null){
                if (trainerReader.isBlank()) continue;
                String[] d = trainerReader.split(",");
                if (d.length < 4) continue;

                if (d[1].equalsIgnoreCase(trainerToDelete.getTrainerName())){
                    encontrado = true;
                    continue;
                }
                contenido.append(trainerReader).append("\n");
            }
            buffer.close();

            if (encontrado){
                FileWriter writer = new FileWriter("trainers.csv", false);
                writer.write(contenido.toString());
                writer.close();
                System.out.println("Trainer deleted successfully");
            }
            else {
                System.out.println("Trainer not deleted successfully");
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<TrainerPkmn> ReadTrainer() {
        File archive = new File("trainers.csv");
        if (!archive.exists()) {
            System.out.println("No se encontro el trainer");
        }
        try (BufferedReader buffer = new BufferedReader(new FileReader(archive))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                String[] d = line.split(",", -1);
                if (d.length < 4) {
                    continue;
                }
                System.out.println("ID: " + d[0] + " | Nombre: " + d[1] + " | Medallas: " + d[2] + " | Pokemones: " + d[3]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }
//TODO:Toca incluir los pokemones de pokedex apartir de aqui
    public static String PkmnId(){
        Set<String> Usados = new HashSet<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader("Pokemon.csv"))){
            String line;
            while ((line = buffer.readLine()) != null){
                Usados.add(line.split(",")[0]);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        Random random = new Random();
        String nuevo;

        do {
            nuevo = String.valueOf(100000 + random.nextInt(900000));
        }

        while (Usados.contains(nuevo));
        return nuevo;
    }

    public static void savePkmn(Pokemon pokemonToSave) {
        pokemonToSave.setPkmnId(PkmnId());

        try (FileWriter writer = new FileWriter("Pokemon.csv", true);){
            writer.write(pokemonToSave.PokemonToCSV());
            writer.write("\n");
            writer.close();
            System.out.println("Pokemon saved successfully");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void UpdatePkmn(Pokemon pokemonToUpdate) {
        StringBuilder contenido = new StringBuilder();
        boolean encontrado = false;

        try {
            FileReader reader = new FileReader("Pokemon.csv");
            BufferedReader buffer = new BufferedReader(reader);
            String pokemonReader;

            while ((pokemonReader = buffer.readLine()) != null){
                if (pokemonReader.isBlank()) continue;
                String[] d = pokemonReader.split(",");
                if (d.length < 4) continue;

                if (!encontrado && d[1].equalsIgnoreCase(pokemonToUpdate.getPkmnName())) {
                    encontrado = true;
                    if (d.length < 4) {
                        d = Arrays.copyOf(d, 4);
                    }
                    d[2] = String.valueOf(pokemonToUpdate.getPkmnLvl());
                    d[3] = String.valueOf(pokemonToUpdate.getTrainer());
                }
                contenido.append(pokemonReader).append("\n");
            }
            buffer.close();
            if (encontrado){
                FileWriter writer = new FileWriter("Pokemon.csv", false);
                writer.write(contenido.toString());
                writer.close();
                System.out.println("Pokemon updated successfully");
            }
            else  {
                System.out.println("No se pudo actualizar el pokemon");
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void DeletePkmn(Pokemon pokemonToDelete) {
        StringBuilder contenido = new StringBuilder();
        boolean encontrado = false;

        try {
            FileReader reader = new FileReader("Pokemon.csv");
            BufferedReader buffer = new BufferedReader(reader);
            String pokemonReader;

            while ((pokemonReader = buffer.readLine()) != null){
                if (pokemonReader.isBlank()) continue;
                String[] d = pokemonReader.split(",");
                if (d.length < 4) continue;

                if (!encontrado && d[1].equalsIgnoreCase(pokemonToDelete.getPkmnName())) {
                    encontrado = true;
                    continue;
                }
                contenido.append(pokemonReader).append("\n");
            }
            buffer.close();
            if (encontrado){
                FileWriter writer = new FileWriter("Pokemon.csv", false);
                writer.write(contenido.toString());
                writer.close();
                System.out.println("Pokemon deleted successfully");
            }
            else   {
                System.out.println("No se pudo actualizar el pokemon");
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Pokemon> ReadPokemon() {
        File archive = new File("Pokemon.csv");
        if (!archive.exists()) {
            System.out.println("No se encontro el pokemon");
        }
        try (BufferedReader buffer = new BufferedReader(new FileReader(archive))){
            String line;
            while ((line = buffer.readLine()) != null){
                if (line.isBlank()) {
                    continue;
                }
                String[] d = line.split(",", -1);
                if (d.length < 4) {
                    continue;
                }
                System.out.println("ID: "+d[0]+ " | Nombre: "+d[1]+ " | Nivel: "+d[2]+ " | Entrenador: "+d[3]);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        return List.of();
    }
}
