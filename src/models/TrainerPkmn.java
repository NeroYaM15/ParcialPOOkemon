package models;

import java.util.ArrayList;
import java.util.List;

public class TrainerPkmn {
    private String trainerName;
    private String Id;
    private String Badges;
    private List<TrainerPkmn> equipoPkmn = new ArrayList<>();

    public TrainerPkmn(String trainerName, String Id) {
        this.trainerName = trainerName;
        this.Id = Id;
    }
    public String getTrainerName() {
        return trainerName;
    }
    public void setTrainerName(String trainerName) {  // No se que hacer apartir de aqui, Ayuda :c

    }
}
