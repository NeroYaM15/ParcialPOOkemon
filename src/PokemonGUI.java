import models.Pokedex;
import javax.swing.*;
import  Operation.Operation;
import models.badges;
import models.Pokemon;
import models.TrainerPkmn;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PokemonGUI extends JFrame {
    private JPanel MainMenu;
    private JPanel TrainerPkmnMenu;
    private JTabbedPane PestañasPrincipal;
    private JTextField TrainerName;
    private JButton GenerarIdTrainer;
    private JButton CrearTrainer;
    private JButton ModificarTrainer;
    private JButton BorrarTrainer;
    private JTextField nombraciondelpkmn;
    private JComboBox<TrainerPkmn> comboEntrenador;
    private JSpinner PkmnNivel;

    private JButton guardarPokemon;
    private JButton eliminarPokemon;
    private JLabel NombrePkmn;
    private JLabel trainerNameLabel;
    private JLabel EntrenadorPkmn;
    private JButton GidPkmn;
    private JLabel IDCreado;
    private JComboBox<badges> comboBadges;
    private JLabel PkmnId;
    private JLabel RpkmnId;
    private JLabel Nivel;
    private JComboBox <Pokedex> comboPokedex;

    public PokemonGUI(){
        comboPokedex = new JComboBox<>(Pokedex.values());
        JButton GuardarPkmn = new JButton("Guardar Pokemon");
        GuardarPkmn.addActionListener(e -> {
            Pokedex elegido = (Pokedex) comboPokedex.getSelectedItem();
            JOptionPane.showMessageDialog(this, "Se a elegido a: " + elegido);
        });

        add(new JLabel("Elija un Pokemon: "));
        add(comboPokedex);
        add(GuardarPkmn);
    }




    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
//ME FALTA TERMINAR LA GUI