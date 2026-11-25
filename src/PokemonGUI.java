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

    private void recargarDatos(){
        String IdTrainer = idDe(comboEntrenador.getSelectedItem());
        String IdSawTrainer = idDe(comboVerTrainer.getSelectedItem());
        String IdSawPokemon = idDe(comboVerPokemon.getSelectedItem());

        entrnadores = Operation.ListTrainers();
        pokemons = Operation.ListPokemon();

        comboEntrenador.setModel(new DefaultComboBoxModel<>(entrnadores.toArray(new TrainerPkmn[0])));
        comboVerTrainer.setModel(new DefaultComboBoxModel<>(entrnadores.toArray(new TrainerPkmn[0])));
        comboVerPokemon.setModel(new DefaultComboBoxModel<>(pokemons.toArray(new Pokemon[0])));

        seleccionarPorId(comboEntrenador, idTrainerGenerado);
        seleccionarPorId(comboVerTrainer, idTrainerGenerado);
        seleccionarPorId(comboVerPokemon, idPkmnGenerado);

        mostrarInfoTrainer();
        mostrarInfoPokemon();
    }

    private boolean formularioCompleto() {
        Object[] componentes = {
                MainMenu, PestañasPrincipal, TrainerName, GenerarIdTrainer,CrearTrainer,ModificarTrainer,BorrarTrainer,
                NombrePkmn, PkmnNivel, guardarPokemon, eliminarPokemon, GidPkmn, IDCreado, RpkmnId, comboBadges, comboPokedex, comboEntrenador
        };
        String[] nombres = {
                "MainMenu", "PestañasPrincipales", "TrainerName", "GenerarIdTrainer", "CrearTrainer", "PkmnNivel", "guardarPokemon", "GidPkmn",
                "comboBahges", "comboPokedex", "comboEntrenador", "ModificarTraine", "BorrarTrainer", "NombrePkmn", "RpkmnId", "IDCreado", "eliminarPokemon"
        };

        List<String> faltan = new ArrayList<>();
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] == null) {
                faltan.add(nombres[i]);
            }
        }
        if  (faltan.isEmpty()) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "esto no se enlazo bien " + faltan + "revise el form y el codigo");
        return false;
    }

    private void conectarEventos() {
        GenerarIdTrainer.addActionListener(e -> accionGenerarIdTrainer());
        CrearTrainer.addActionListener(e -> accionCrearTrainer());
        ModificarTrainer.addActionListener(e -> accionModificarTrainer());
        BorrarTrainer.addActionListener(e -> accionEliminarTrainer());

        GidPkmn.addActionListener(e -> accionGenerarIdPokemon());
        guardarPokemon.addActionListener(e -> accionGuardarPokemon());
        eliminarPokemon.addActionListener(e -> accionEliminarPokemon());

        // Al elegir algo en los combos de "Consultar" se muestra su informacion
        comboVerTrainer.addActionListener(e -> mostrarInfoTrainer());
        comboVerPokemon.addActionListener(e -> mostrarInfoPokemon());
    }

    //ENTRENADORES
    private void accionGenerarIdTrainer() {
        idTrainerGenerado = Operation.IdTrainer();
        IDCreado.setText("El ID es: " + idTrainerGenerado);
    }

    private void accionCrearTrainer() {
        String nombre = limpiarTexto(TrainerName.getText());
        if (nombre.isEmpty()) {
            aviso("Ya existe un entrenador llamado " + nombre);
            return;
        }

        TrainerPkmn nuevo = new TrainerPkmn(nombre, idTrainerGenerado);
        badges medalla = (badges) comboBadges.getSelectedItem();
        if (medalla != null) {
            nuevo.agregarBadges(medalla);
        }
        Operation.saveTrainer(nuevo);

        TrainerName.setText("");
        comboBadges.setSelectedIndex(-1);
        idTrainerGenerado = null;
        IDCreado.setText("El ID es: ()sin generar");

        //agrega los entrenadores a la combo
        recargarDatos();
        seleccionarPorId(comboEntrenador, nuevo.getId());
        aviso("Entrenador creado: " + nombre);
    }

    private void accionModificarTrainer() {
        TrainerPkmn t = elegirTrainer("Modificar entrenador");
        if (t == null) {
            return;
        }

        String nuevoNombre = limpiarTexto(TrainerName.getText());
        badges medalla = (badges) comboBadges.getSelectedItem();
        if (nuevoNombre.isEmpty() && medalla == null) {
            aviso("nombre el entrenador y elija su medalla");}return;
        if (!nuevoNombre.isEmpty()) {
            if (buscarTrainerPorNombre(nuevoNombre, t.getId()) != null) {
                aviso("ya hay un entrenador llamado" + nuevoNombre);
                return;
            }
            t.setTrainerName(nuevoNombre);
        }

        String extra = "";
        if (medalla != null && !t.agrgarBadge(medalla)) {
            extra = "\n(Ya poseia esa medalla)";
        }
        Operation.UpdateTrainer(t);
        TrainerName.setText("");
        comboBadges.setSelectedIndex(-1);
        recargarDatos();
        aviso("Entrenador actualizado" + extra);
    }

    private void accionEliminarTrainer(){
        TrainerPkmn t = elegirTrainer("Eliminar entrenador");
        if (t == null) {
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(this, "se eliminara a: " + t.getTrainerName() + "y sus" + t.getEquipoPkmn().size() "Pokemon. ¿Continuar?", "Confirmar", JOptionPane.YES_OPTION);
        if (respuesta != JOptionPane.YES_OPTION) {
            return;
        }

        for (Pokemon p : t.getEquipoPkmn()){
            Operation.DeletePkmn(p);
        }
        Operation.DeleteTrainer(t);
        recargarDatos();
        aviso("Entrenador eliminado");

    }

    //POKEMONES
    private void accionGenerarIdPokemon() {
        idPkmnGenerado = Operation.PkmnId();
        RpkmnId.setText("El ID del pokemon es: " + idPkmnGenerado);
    }

    private void accionGuardarPokemon() {
        Pokedex especie = (Pokedex) comboPokedex.getSelectedItem();
        TrainerPkmn dueño = (TrainerPkmn) comboEntrenador.getSelectedItem();
        String nombre = limpiarTexto(nombraciondelpkmn.getText());
        int nivel = (Integer) PkmnNivel.getValue();

        if (especie == null) {
            aviso("Elija un pokemon de la lista ");
            return;
        }
        if (nombre.isEmpty()) {
            aviso("Escribe el nombre del Pokemon");
            return;
        }
        if (dueño == null) {
            aviso ("Elige un entrenador");
            return;
        }

        Pokemon nuevo = new Pokemon(nombre, nivel, dueño.getId(), idPkmnGenerado);
        if (!dueño.agregarPokemon(nuevo)){
            aviso(dueño.getTrainerName()+" ya tiene "+ TrainerPkmn.MAX_POKEMON+"Pokemon, no puede tener mas.");
            return;
        }
        Operation.savePkmn(nuevo);
        Operation.UpdateTrainer(dueño);

        nombraciondelpkmn.setText("");
        comboVerPokemon.setSelectedIndex(-1);
        PkmnNivel.setValue(1);
        idPkmnGenerado = null;
        RpkmnId.setText("");
        recargarDatos();
        aviso("Pokemon guardado: "+nombre);

    }
    private void accionEliminarPokemon(){
        Pokemon p = elegirPokemon("Eliminar pokemon");
        if (p == null){
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Eliminar a "+p.getPkmnName()+"?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (respuesta != JOptionPane.YES_OPTION){
            return;
        }
        Operation.DeletePkmn(p);
        TrainerPkmn dueño = buscarTrainerPorId(p.getTrainer());
        if (dueño != null){
            dueño.eliminarPokemon(p);
            Operation.UpdateTrainer(dueño);
        }
        recargarDatos();
        aviso("Pokemon eliminado");
    }

    private JPanel crearPanelConsulta() {
        JPanel panel = new JPanel();
        panel.setLayou(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(crearSeccion("Ver informacion de un Pokemon", "Entrenador:", comboVerTrainer));


    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PokemonGUI().setVisible(true));
    }
}
//ME FALTA TERMINAR LA GUi