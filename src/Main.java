import models.Pokemon;
import models.TrainerPkmn;

import static Operation.Operation.ReadTrainer;
import static Operation.Operation.saveTrainer;

public class Main {
    public static void main(String[] args){
        // esto es una prueba de lo del pokemon no le ponga cuidado
        //Pokemon pk1 = new Pokemon ();
        //pk1.setTipo("juan");
        //pk1.nombre = "Juan";
        //pk1.nivel = 2;
        //pk1.setAnimal("charmander");
        //pk1.setNumero("4");
        //System.out.println(pk1);
        TrainerPkmn trainer = new TrainerPkmn("Ash", null);
        trainer.setBadges("5");
        saveTrainer(trainer);
        ReadTrainer();
    }


}