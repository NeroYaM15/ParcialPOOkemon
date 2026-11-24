import models.Pokedex;
import javax.swing.*;

public class PokemonGUI extends JFrame {
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

    private JPanel MainMenu;
    private JPanel TrainerPkmnMenu;
    private JTabbedPane PestañasPrincipal;
    private JTextField IdTrainer;
    private JTextField TrainerName;
    private JTextField Badges;
    private JButton GenerarIdTrainer;
    private JButton CrearTrainer;
    private JButton ModificarTrainer;
    private JButton BorrarTrainer;
    private JTable Trainers;
    private JTextField nombraciondelpkmn;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JSpinner spinner1;
    private JComboBox comboBox2;

    private JButton btnNombrepkmn;
    private JButton button3;
    private JButton button4;
    private JTable table1;
    private JLabel NombrePkmn;

}
//ME FALTA TERMINAR LA GUI