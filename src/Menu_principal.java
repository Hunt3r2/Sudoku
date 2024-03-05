import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class Menu_principal extends JFrame {

    private JPanel contentPane;
    Juego_sudoku juego_sudoku;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu_principal frame = new Menu_principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Menu_principal() {
        setResizable(false);
        setTitle("SUDOKU");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Menu_principal.class.getResource("/Imagenes/nicolas-cage-biografia-fotos.jpg")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(137, 126, 95, 22);
        contentPane.add(panel_1);

        JLabel lblNewLabel_2 = new JLabel("Elegir dificultad: ");
        panel_1.add(lblNewLabel_2);
        lblNewLabel_2.setForeground(Color.RED);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));
        panel.setBackground(Color.CYAN);
        panel.setBounds(152, 11, 146, 43);
        contentPane.add(panel);

        JLabel lblNewLabel = new JLabel("SUDOKU");
        panel.add(lblNewLabel);
        lblNewLabel.setForeground(Color.ORANGE);
        lblNewLabel.setBackground(new Color(255, 255, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 27));

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"FACIL", "MEDIO", "DIFICIL"}));
        comboBox.setMaximumRowCount(3);
        comboBox.setBounds(233, 126, 89, 22);
        contentPane.add(comboBox);

        JButton btnNewButton = new JButton("Empezar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                juego_sudoku = new Juego_sudoku(null, 0);
                String dificultad = comboBox.getSelectedItem().toString();

                switch (dificultad) {
                    case "FACIL":
                        System.out.println("Seleccionaste fácil");
                        juego_sudoku.setDificultad(1);
                        break;
                    case "MEDIO":
                        System.out.println("Seleccionaste medio");
                        juego_sudoku.setDificultad(2);
                        break;
                    case "DIFICIL":
                        System.out.println("Seleccionaste difícil");
                        juego_sudoku.setDificultad(3);
                        break;
                }

                juego_sudoku.iniciarJuego();
            }
        });
        btnNewButton.setBounds(179, 81, 89, 23);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Menu_principal.class.getResource("/Imagenes/prisoners-of-the-ghostland_output.png")));
        lblNewLabel_1.setBounds(0, 0, 434, 261);
        contentPane.add(lblNewLabel_1);
    }
}
