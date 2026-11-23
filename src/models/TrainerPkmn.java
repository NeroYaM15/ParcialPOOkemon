package models;

import java.util.ArrayList;
import java.util.List;

public class TrainerPkmn {
    private String trainerName;
    private String Id;
    private String Badges;
    private List<Pokemon> equipoPkmn = new ArrayList<>();

    public TrainerPkmn(String trainerName, String Id) {
        this.trainerName = trainerName;
        this.Id = Id;
    }
    public String getTrainerName() {
        return trainerName;
    }
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;       // No se que hacer apartir de aqui, Ayuda :c
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

    public TrainerPkmn(String trainerName,String Id,String Badges,List<Pokemon> equipoPkmn){
        this.trainerName=trainerName;
        this.Id=Id;
        this.Badges=Badges;
        this.equipoPkmn=equipoPkmn;
    }

    public String trainerToCSV(){
        String badge = (Badges==null) ? "No_Badges" : Badges;
        return this.getId()+","+this.trainerName+","+this.Badges+","+this.equipoPkmn+",";
    }
}
