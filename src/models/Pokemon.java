package models;

public class Pokemon {
    public String nombre;
    private String animal;
    public int nivel;
    private String numero;
    public String entrenador;
    private String tipo;

    //obtener el animal
    public String getAnimal() {
        return animal;
    }
    public void setAnimal(String animal) {
        this.animal = animal;
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
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pokemon[" +
                "Nombre: " + nombre +
                "| animal: " + animal +
                "| nivel: " + nivel +
                "| numero: " + numero +
                "| tipo: " + tipo +
                "]";
    }

}
