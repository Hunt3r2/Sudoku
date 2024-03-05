import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.util.Random;

public class Juego_sudoku extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tablero[][] = new JTextField[9][9];
    int dificultad;

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public void iniciarJuego() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Juego_sudoku frame = new Juego_sudoku(null, dificultad);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Juego_sudoku(JFrame juego, int dificultad) {
        super(juego, true);
        setResizable(false);
        setTitle("SUDOKU");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1089, 825);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 128));
        contentPane.setForeground(new Color(0, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelJuego = new JPanel();
        panelJuego.setBackground(new Color(224, 255, 255));
        panelJuego.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panelJuego.setBounds(219, 47, 641, 589);
        contentPane.add(panelJuego);
        panelJuego.setLayout(new GridLayout(9, 9, 0, 0));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField casilla = new JTextField("");
                casilla.setHorizontalAlignment(SwingConstants.CENTER);
                casilla.setForeground(Color.RED);

                casilla.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char numero = e.getKeyChar();

                        if (!(Character.isDigit(numero)  && numero >= '1' && numero <= '9')) {
                        	e.consume();
                        	Toolkit.getDefaultToolkit().beep();

                            if ((casilla.getText().length() == 1)) {
                            	e.consume();
                            	Toolkit.getDefaultToolkit().beep();
                            }
                        }
                    }
                });

                
                int arriba, izq, abajo, dech;
                arriba = izq = abajo = dech = 1;
                if (i % 3 == 0)
                    arriba = 3;
                if ((i + 1) % 3 == 0)
                    abajo = 3;
                if (j % 3 == 0)
                    izq = 3;
                if ((j + 1) % 3 == 0)
                    dech = 3;
                casilla.setBorder(BorderFactory.createMatteBorder(arriba, izq, abajo, dech, Color.black));
                casilla.setBackground(Color.WHITE);
                panelJuego.add(casilla);
                tablero[i][j] = casilla;
            }
        }

        switch (dificultad) {
            case 1:
                generarTableroFacil();
                System.out.println("facil");
                break;
            case 2:
                generarTableroMedio();
                System.out.println("medio");
                break;
            case 3:
                generarTableroDificil();
                System.out.println("dificil");
                break;
        }

        JButton btnVerificar = new JButton("Verificar");
        btnVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarSudoku();
            }
        });
        btnVerificar.setBounds(470, 677, 150, 35);
        contentPane.add(btnVerificar);
    }

    public void generarTableroFacil() {
        generarTablero(2);
    }

    public void generarTableroMedio() {
        generarTablero(40);
    }

    public void generarTableroDificil() {
        generarTablero(50);
    }

    public void generarTablero(int celdasVacias) {
        int[][] tableroResuelto = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        Random rand_celdas = new Random();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tablero[i][j].setText(String.valueOf(tableroResuelto[i][j]));

                if (tableroResuelto[i][j] != 0) {
                    tablero[i][j].setEditable(false);
                }
            }
        }

        for (int i = 0; i < celdasVacias; i++) {
            int fila, columna;
            do {
                fila = rand_celdas.nextInt(9);
                columna = rand_celdas.nextInt(9);
            } while (tablero[fila][columna].getText().equals(""));

            tablero[fila][columna].setText("");

            tablero[fila][columna].setEditable(true);
        }
    }

    private void verificarSudoku() {
        if (todasCasillasLlenas() && sudokuValido()) {
            mensajeVictoria();
        } else {
            JOptionPane.showMessageDialog(this, "El Sudoku no es válido. ¡Sigue intentándolo!");
        }
    }

    private void mensajeVictoria() {
        JOptionPane.showMessageDialog(this, "¡Felicidades! Has resuelto el Sudoku.", getTitle(), getDefaultCloseOperation());
    }

    private boolean todasCasillasLlenas() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (tablero[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean sudokuValido() {
        // Verificar filas
        for (int i = 0; i < 9; i++) {
            boolean[] existentes = new boolean[9];
            for (int j = 0; j < 9; j++) {
                String valor = tablero[i][j].getText();
                if (!valor.isEmpty() && !existentes[Integer.parseInt(valor) - 1]) {
                    existentes[Integer.parseInt(valor) - 1] = true;
                } else {
                    return false; // Número duplicado en la fila
                }
            }
        }

        // Verificar columnas
        for (int j = 0; j < 9; j++) {
            boolean[] existentes = new boolean[9];
            for (int i = 0; i < 9; i++) {
                String valor = tablero[i][j].getText();
                if (!valor.isEmpty() && !existentes[Integer.parseInt(valor) - 1]) {
                    existentes[Integer.parseInt(valor) - 1] = true;
                } else {
                    return false; // Número duplicado en la columna
                }
            }
        }

        // Verificar bloques
        for (int bloque = 0; bloque < 9; bloque++) {
            boolean[] existentes = new boolean[9];
            for (int i = bloque / 3 * 3; i < bloque / 3 * 3 + 3; i++) {
                for (int j = bloque % 3 * 3; j < bloque % 3 * 3 + 3; j++) {
                    String valor = tablero[i][j].getText();
                    if (!valor.isEmpty() && !existentes[Integer.parseInt(valor) - 1]) {
                        existentes[Integer.parseInt(valor) - 1] = true;
                    } else {
                        return false; // Número duplicado en el bloque
                    }
                }
            }
        }

        return true; // Sudoku válido
    }
}
