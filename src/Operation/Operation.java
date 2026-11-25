package Operation;

import models.TrainerPkmn;
import models.Pokemon;
import models.Pokedex;
import models.badges;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.io.*;
import java.util.*;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Operation {
    /*

    private static final String TRAINERS_FILE = "Trainers.csv";
    private static final String POKEMON_FILE = "Pokemon.csv";

    private static List<String> leerLineas(String archivo) {
        List<String> lineas = new ArrayList<>();
        File f = new File(archivo);
        if (!f.exists()){
            return lineas;
        }
        try (BufferedReader buffer = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = buffer.readLine()) != null){
                if(!line.isBlank()) {
                    lineas.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lineas;
    }

    private static void escribirLineas(String archivo, List<String> lineas) {
        try (FileWriter writer = new FileWriter(archivo, false)) {
            for (String 1 : lineas) {
                writer.write(1 + "\n");
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

     */

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

                if (!encontrado && d[0].equals(trainerToUpdate.getId())){
                    encontrado = true;
                    if (d.length < 4){
                        d = Arrays.copyOf(d, 4);
                    }
                    d = trainerToUpdate.trainerToCSV().split(",", -1);
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
                String[] d = trainerReader.split(",", -1);
                if (d.length < 4) continue;

                if (d[0].equals(trainerToDelete.getId())){
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
                String[] d = pokemonReader.split(",", -1);
                if (d.length < 4) continue;

                if (!encontrado && d[10].equals(pokemonToUpdate.getPkmnId())) {
                    encontrado = true;
                    if (d.length < 4) {
                        d = Arrays.copyOf(d, 4);
                    }
                    d = pokemonToUpdate.PokemonToCSV().split(",", -1);
                }
                contenido.append(String.join(",", d)).append("\n");
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
                String[] d = pokemonReader.split(",",-1);
                if (d.length < 4) continue;

                if (!encontrado && d[0].equals(pokemonToDelete.getPkmnId())) {
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

    //arreglos faltantes
    public static List<Pokemon> ListPokemon() {
        List<Pokemon> lista = new ArrayList<>();
        File archive = new File("Pokemon.csv");
        if (!archive.exists()) {
            return lista;
        }
        try (BufferedReader buffer = new BufferedReader(new FileReader(archive))) {
        String line;
        while ((line = buffer.readLine()) != null){
            if (line.isBlank()) {
                continue;
            }
            String[] d = line.split(",", -1);
            if(d.length < 4){
                continue;
            } try{
                Pokemon p = new Pokemon(d[1], Integer.parseInt(d[2].trim()), d[3], d[0]);
                if (d.length >= 5 && !d[4].isEmpty()) {
                    p.setPokedex(Pokedex.valueOf(d[4]));
                }
                lista.add(p);
            } catch (IllegalArgumentException e) {
                System.out.println("Linea ilegible: " + line);
            }
        }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static List<TrainerPkmn> ListTrainers() {
        List<TrainerPkmn> trainers = new ArrayList<>();
        File archive = new File("trainers.csv");
        if (!archive.exists()) {
            return trainers;
        }
        List<Pokemon> todosPkmn = ListPokemon();
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
                TrainerPkmn t = new TrainerPkmn(d[1], d[0]);
                if (!d[2].isEmpty() && !d[2].equals("No_Badges")) {
                    for (String nombre : d[2].split(":")){
                        try {
                            t.agregarBadges(badges.valueOf(nombre.trim()));
                        } catch (IllegalArgumentException e){

                        }
                    }
                }
                for (Pokemon p : todosPkmn) {
                    if (d[0].equals(p.getTrainer())) {
                        t.agregarPokemon(p);
                    }
                }
                trainers.add(t);
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return trainers;
    }
}
