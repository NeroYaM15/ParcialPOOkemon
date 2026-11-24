package models;

public class Pokemon {
    private String pkmnName;
    private String pkmnRace;
    private int pkmnLvl;
    private String pkmnNumber;
    private String trainer;
    private Enum type;
    private String pkmnId;

    //obtener el animal
    public String getPkmnRace() {
        return pkmnRace;
    }
    public void setPkmnRace(String race) {
        this.pkmnRace = race;
    }

    //obtener el numero
    public String getPkmnNumber() {
        return pkmnNumber;
    }
    public void setNumero(String number) {
        this.pkmnNumber = number;
    }

    public String getPkmnIdId() {
        return pkmnId;
    }

    public void setPkmnIdId(String Id) {
        this.pkmnId = Id;
    }

    @Override
    public String toString() {
        return "Pokemon[" +
                "| N.°: " + pkmnNumber +
                "| Id=" + pkmnId +
                "| Nombre: " + pkmnName +
                "| animal: " + pkmnRace +
                "| tipo: " + type +
                "| nivel: " + pkmnLvl +
                "]";
    }

    public Pokemon(String nombre, String raza, int nivel, String numero, String trainer, String Id) {
        this.pkmnName = nombre;
        this.pkmnRace = raza;
        this.pkmnLvl = nivel;
        this.pkmnNumber = numero;
        this.trainer = trainer;
        this.pkmnId = Id;
    }
}
