package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainerPkmn {
    private String trainerName;
    private String Id;
    private List<Badges> Badges = new ArrayList<>();
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
    public List<Badges> getBadges() {
        return Badges;
    }
    public void setBadges(List<Badges> Badges) {
        this.Badges = Badges;
    }
    public List<Pokemon> getEquipoPkmn() {
        return equipoPkmn;
    }
    public void setEquipoPkmn(List<Pokemon> equipoPkmn) {
        this.equipoPkmn = equipoPkmn;
    }

    @Override
    public String toString(){
        return "models.trainerPkmn{;"+
                "TrainerName='"+ trainerName +
                "| Id='" + Id +
                "'}";
    }

    public TrainerPkmn(String trainerName, String Id, List<Badges> Badges, List<Pokemon> equipoPkmn){
        this.trainerName=trainerName;
        this.Id=Id;
        this.Badges=Badges;
        this.equipoPkmn=equipoPkmn;
    }

    public String trainerToCSV(){
        String badge = (Badges==null) ? "No_Badges" : Badges.toString();
        String equipo = equipoPkmn.stream().map(Pokemon::getPkmnId).collect(Collectors.joining(";"));
        return this.getId()+","+this.trainerName+ "," + badge + "," +equipo;
    }
}
