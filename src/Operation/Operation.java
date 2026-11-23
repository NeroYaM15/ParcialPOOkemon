package Operation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import models.Pokemon;
import models.trainerPkmn;
import models.Type;

public class Operation {
    //NO SE SI ESTA JODA FUNCIONE :D
    public static String IdTrainer(){
        Set<String> Usados = new HashSet<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader("trainer.csv"))){
            String line;
            while ((line = buffer.readLine()) != null){
                Usados.add(line.split(",")[0]);
            }
        }
        catch (IOException e){
        }
        Random random = new Random();
        String nuevo;

        do {
            nuevo = String.valueOf(100000 + random.nextInt(900000));
        }

        while (Usados.contains(nuevo));
        return nuevo;
    }


    public static String IdPokemon;
}
