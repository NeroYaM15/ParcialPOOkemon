package models;

public class Pokemon {
    private String pkmnName;
    private int pkmnLvl;
    private String trainer;
    private Enum Pokedex;
    private String pkmnId;

    public String getPkmnIdId() {
        return pkmnId;
    }

    public void setPkmnIdId(String Id) {
        this.pkmnId = Id;
    }

    @Override
    public String toString() {
        return "Pokemon[" +
                "| Id=" + pkmnId +
                "| Nombre: " + pkmnName +
                "| tipo: " + Pokedex +
                "| nivel: " + pkmnLvl +
                "]";
    }

    public Pokemon(String nombre, String raza, int nivel, String numero, String trainer, String Id) {
        this.pkmnName = nombre;
        this.pkmnLvl = nivel;
        this.trainer = trainer;
        this.pkmnId = Id;
    }
}
