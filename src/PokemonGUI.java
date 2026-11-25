import models.Pokedex;
import javax.swing.*;
import  Operation.Operation;
import models.badges;
import models.Pokemon;
import models.TrainerPkmn;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
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
/*
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

 */

    private List<TrainerPkmn> entrnadores = new ArrayList<>();
    private List<Pokemon> pokemons = new ArrayList<>();

    private final JComboBox<Pokemon> comboVerPokemon = new JComboBox<>();
    private final JLabel lblPkmnNombre = new JLabel("-");
    private final JLabel lblPkmnId = new JLabel("-");
    private final JLabel lblPkmnPokedex = new JLabel("-");
    private final JLabel lblPkmnNivel = new JLabel("-");
    private final JLabel lblPkmnEntrenador = new JLabel("-");

    private final JComboBox<TrainerPkmn> comboVerTrainer = new JComboBox<>();
    private final JLabel lblTrainerNombre = new JLabel("-");
    private final JLabel lblTrainerId = new JLabel("-");
    private final JLabel lblTrainerMedallas = new JLabel("-");
    private final JLabel lblTrainerPokemon = new JLabel("-");

    private String idTrainerGenerado = null;
    private String idPkmnGenerado = null;


    public PokemonGUI(){
        if (!formularioCompleto()){
            System.exit(1);
        }
        //conexion entre enums y combobox
        comboBadges.setModel(new DefaultComboBoxModel<>(badges.values()));
        comboBadges.setSelectedIndex(-1);
        comboPokedex.setModel(new DefaultComboBoxModel<>(Pokedex.values()));
        comboPokedex.setSelectedIndex(-1);
        mostrarBonito(comboBadges);
        mostrarBonito(comboPokedex);
        mostrarBonito(comboEntrenador);
        mostrarBonito(comboVerPokemon);
        mostrarBonito(comboVerTrainer);

        PkmnNivel.setModel(new SpinnerNumberModel(1, 1, 100, 1));

        IDCreado.setText("El ID del entrenador es: (sin generar)");
        RpkmnId.setText("El ID del Pokemon es: (sin generar)");

        //pestaña de consultas
        PestañasPrincipal.addTab("Consultar", crearPanelConsulta());
        conectarEventos();
        recargarDatos();
    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
//ME FALTA TERMINAR LA GUI