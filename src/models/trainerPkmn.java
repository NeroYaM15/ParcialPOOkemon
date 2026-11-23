package models;

import java.util.ArrayList;
import java.util.List;

public class trainerPkmn {
    private String trainerName;
    private String Id;
    private String Badges;
    private List<trainerPkmn> equipoPkmn = new ArrayList<>();

    public trainerPkmn(String trainerName, String Id) {
        this.trainerName = trainerName;
        this.Id = Id;
    }
    public String getTrainerName() {
        return trainerName;
    }
    public void setTrainerName(String trainerName) {  // No se que hacer apartir de aqui, Ayuda :c

    }
    public String getId(){
        return Id;
    }
    public void setId(String Id){
        this.Id=Id;
    }

    @Override
    public String toString(){
        return "models.trainerPkmn{;"+
                "TrainerName='"+ trainerName +
                "| Id='" + Id +
                "'}";
    }
}
