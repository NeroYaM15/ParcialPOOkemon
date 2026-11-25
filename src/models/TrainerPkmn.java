package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainerPkmn {
    private String trainerName;
    private String Id;
    private List<badges> badges = new ArrayList<>();
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
    public List<badges> getbadges() {
        return badges;
    }
    public void setBadges(List<badges> Badges) {
        this.badges = Badges;
    }
    public List<Pokemon> getEquipoPkmn() {
        return equipoPkmn;
    }
    public void setEquipoPkmn(List<Pokemon> equipoPkmn) {
        this.equipoPkmn = equipoPkmn;
    }

    //maximo de pokemones por entrenador
    public static final int MAX_POKEMON = 5;

    public boolean agregarPokemon(Pokemon p) {
        if (p == null || equipoPkmn.size() >= MAX_POKEMON) {
            return false;
        }
        equipoPkmn.add(p);
        return true;
    }

    public boolean agregarBadges(badges b) {
        if (b == null || badges.contains(b)) {
            return false;
        }
        badges.add(b);
        return true;
    }

    @Override
    public String toString(){
        return "models.trainerPkmn{;"+
                "TrainerName='"+ trainerName +
                "| Id='" + Id +
                "'}";
    }

    public TrainerPkmn(String trainerName, String Id, List<badges> Badges, List<Pokemon> equipoPkmn){
        this.trainerName=trainerName;
        this.Id=Id;
        this.badges=Badges;
        this.equipoPkmn=equipoPkmn;
    }

    public String trainerToCSV(){
        String badge = (badges==null) ? "No_Badges" : badges.toString();
        String equipo = equipoPkmn.stream().map(Pokemon::getPkmnId).collect(Collectors.joining(";"));
        return this.getId()+","+this.trainerName+ "," + badge + "," +equipo;
    }
}
