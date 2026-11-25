package models;

public class Pokemon {
    private String pkmnName;
    private int pkmnLvl;
    private String trainer;
    private Enum Pokedex;
    private String pkmnId;

    public String getPkmnId() {
        return pkmnId;
    }

    public void setPkmnId(String pkmnId) {
        this.pkmnId = pkmnId;
    }

    public int getPkmnLvl() {
        return pkmnLvl;
    }
    public void setPkmnLvl(int pkmnLvl) {
        this.pkmnLvl = pkmnLvl;
    }

    public String getTrainer() {
        return trainer;
    }
    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }
    public String getPkmnName() {
        return pkmnName;
    }
    public void setPkmnName(String pkmnName) {
        this.pkmnName = pkmnName;
    }
//FALTA LA POKEDEX

    @Override
    public String toString() {
        return "Pokemon[" +
                "| Id: " + pkmnId +
                "| Nombre: " + pkmnName +
                "| tipo: " + Pokedex +
                "| nivel: " + pkmnLvl +
                "]";
    }

    public Pokemon(String nombre, int nivel, String trainer, String Id) {
        this.pkmnName = nombre;
        this.pkmnLvl = nivel;
        this.trainer = trainer;
        this.pkmnId = Id;
    }

    public String PokemonToCSV(){
        return this.getPkmnId()+","+this.pkmnName+","+this.pkmnLvl+","+this.trainer;
    }
}
