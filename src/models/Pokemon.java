package models;

public class Pokemon {
    public String nombre;
    private String raza;
    public int nivel;
    private String numero;
    public String trainer;
    private String type;
    private String Id;

    //obtener el animal
    public String getAnimal() {
        return raza;
    }
    public void setAnimal(String animal) {
        this.raza = animal;
    }

    //obtener el numero
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    //obtener el tipo
    public String getTipo() {
        return type;
    }
    public void setTipo(String tipo) {
        this.type = tipo;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Pokemon[" +
                "| N.°: " + numero +
                "| Id=" + Id +
                "| Nombre: " + nombre +
                "| animal: " + raza +
                "| tipo: " + type +
                "| nivel: " + nivel +
                "]";
    }

}
