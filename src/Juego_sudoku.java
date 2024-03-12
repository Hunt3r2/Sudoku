import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.ImageIcon;

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
                    generarTablero(dificultad);
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
        panelJuego.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        panelJuego.setBorder(new LineBorder(Color.CYAN, 10));
        panelJuego.setBounds(219, 47, 641, 589);
        contentPane.add(panelJuego);
        panelJuego.setLayout(new GridLayout(9, 9, 0, 0));
        
        JLabel lblElmo = new JLabel("");
        lblElmo.setIcon(new ImageIcon(Juego_sudoku.class.getResource("/Imagenes/bf49097a-5a54-4930-87f9-e6368b119736_output.png")));
        lblElmo.setBounds(9, 122, 200, 500);
        lblElmo.setBorder(new LineBorder(Color.yellow, 5));
        contentPane.add(lblElmo);
        lblElmo.setVisible(false);
        
        JLabel lblNick = new JLabel("");
        lblNick.setIcon(new ImageIcon(Juego_sudoku.class.getResource("/Imagenes/nick_tablero_output.png")));
        lblNick.setBorder(new LineBorder(Color.yellow, 5));
        lblNick.setBounds(870, 122, 200, 500);
        contentPane.add(lblNick);
        lblNick.setVisible(false);
        
                JButton btnVerificar = new JButton("Verificar");
                btnVerificar.setBackground(new Color(102, 204, 102));
                btnVerificar.setBorder(new LineBorder(new Color(50, 205, 50), 3, true));
                btnVerificar.setFocusable(false);
                btnVerificar.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
                btnVerificar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        verificarSudoku();
                    }
                });
                btnVerificar.setBounds(470, 677, 150, 35);
                contentPane.add(btnVerificar);
        
        JLabel lblTitulo = new JLabel("MODO DIFICIL");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Impact", Font.BOLD, 45));
        lblTitulo.setBounds(432, 0, 275, 50);
        contentPane.add(lblTitulo);
        lblTitulo.setVisible(false);
        
        JLabel lblOjo = new JLabel("");
        lblOjo.setBorder(new LineBorder(new Color(51, 51, 153), 4, true));
        lblOjo.setIcon(new ImageIcon(Juego_sudoku.class.getResource("/Imagenes/c2f12796597a0ece9ac91cafcef5f0d9fcd16b18_output.gif")));
        lblOjo.setBounds(9, 649, 200, 100);
        contentPane.add(lblOjo);
        
        JLabel lblOjo_1 = new JLabel("");
        lblOjo_1.setBorder(new LineBorder(new Color(51, 51, 153), 3, true));
        lblOjo_1.setIcon(new ImageIcon(Juego_sudoku.class.getResource("/Imagenes/c2f12796597a0ece9ac91cafcef5f0d9fcd16b18_output.gif")));
        lblOjo_1.setBounds(868, 649, 200, 100);
        contentPane.add(lblOjo_1);
        
        JLabel lblOjo_1_1 = new JLabel("");
        lblOjo_1_1.setBorder(new LineBorder(new Color(51, 51, 153), 4, true));
        lblOjo_1_1.setIcon(new ImageIcon(Juego_sudoku.class.getResource("/Imagenes/c2f12796597a0ece9ac91cafcef5f0d9fcd16b18_output.gif")));
        lblOjo_1_1.setBounds(870, 11, 200, 100);
        contentPane.add(lblOjo_1_1);
        
        JLabel lblOjo_1_1_1 = new JLabel("");
        lblOjo_1_1_1.setBorder(new LineBorder(new Color(51, 51, 153), 3, true));
        lblOjo_1_1_1.setIcon(new ImageIcon(Juego_sudoku.class.getResource("/Imagenes/c2f12796597a0ece9ac91cafcef5f0d9fcd16b18_output.gif")));
        lblOjo_1_1_1.setBounds(9, 11, 200, 100);
        contentPane.add(lblOjo_1_1_1);
        
        JButton btnNewButtonOjos = new JButton("Desactivar ojos");
        btnNewButtonOjos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (btnNewButtonOjos.getText() == "Activar ojos") {
        			lblOjo.setVisible(true);
            		lblOjo_1.setVisible(true);
            		lblOjo_1_1.setVisible(true);
            		lblOjo_1_1_1.setVisible(true);
            		btnNewButtonOjos.setText("Desactivar ojos");
        		}else {
	        		lblOjo.setVisible(false);
	        		lblOjo_1.setVisible(false);
	        		lblOjo_1_1.setVisible(false);
	        		lblOjo_1_1_1.setVisible(false);
	        		btnNewButtonOjos.setText("Activar ojos");
        		}
        	
        	}
        });
        btnNewButtonOjos.setBounds(480, 723, 135, 23);
        contentPane.add(btnNewButtonOjos);
        
        JLabel lblFondoDificil = new JLabel("");
        lblFondoDificil.setIcon(new ImageIcon(Juego_sudoku.class.getResource("/Imagenes/5yE_output.gif")));
        lblFondoDificil.setBounds(0, 0, 1089, 825);
        contentPane.add(lblFondoDificil);
        lblFondoDificil.setVisible(false);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField casilla = new JTextField("");
                casilla.setHorizontalAlignment(SwingConstants.CENTER);
                casilla.setForeground(Color.RED);

                casilla.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char numero = e.getKeyChar();

                        if (!(Character.isDigit(numero) && numero >= '1' && numero <= '9')) {
                            e.consume();
                        }

                        if (casilla.getText().length() == 1) {
                            e.consume();
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
                btnNewButtonOjos.setVisible(false);
                lblTitulo.setVisible(true);
                lblTitulo.setText("MODO FACIL");
                lblOjo.setVisible(false);
        		lblOjo_1.setVisible(false);
        		lblOjo_1_1.setVisible(false);
        		lblOjo_1_1_1.setVisible(false);
                break;
            case 2:
                generarTableroMedio();
                System.out.println("medio");
                lblTitulo.setVisible(true);
                lblTitulo.setText("MODO MEDIO");
                lblOjo.setVisible(true);
        		lblOjo_1.setVisible(true);
        		lblOjo_1_1.setVisible(true);
        		lblOjo_1_1_1.setVisible(true);
                break;
            case 3:
                generarTableroDificil();
                System.out.println("dificil");
                lblNick.setVisible(true);
                lblFondoDificil.setVisible(true);
                lblElmo.setVisible(true);
                lblTitulo.setVisible(true);
                panelJuego.setBorder(new LineBorder(Color.orange, 10));
                break;
        }


    }

    public void generarTableroFacil() {
        generarTablero(30);
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
                	Font font = new Font("Arial", Font.PLAIN, 25);
                    tablero[i][j].setFont(font);
                	tablero[i][j].setForeground(Color.black);
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
            tablero[fila][columna].setForeground(Color.red);
            tablero[fila][columna].setEditable(true);
            
        }
    }

    private void verificarSudoku() {
        if (sudokuValido()) {
            mensajeVictoria();
        } else {
            JOptionPane.showMessageDialog(this, "ERROR, el sudoku es erroneo. ¡Sigue intentándolo! :D");
        }
    }

    private void mensajeVictoria() {
        JOptionPane.showMessageDialog(this, "¡Felicidades! Has acabado el Sudoku. >:D ", getTitle(), getDefaultCloseOperation());
    }


    private boolean sudokuValido() {
        // Verificar filas
        for (int i = 0; i < 9; i++) {
            boolean[] existentes = new boolean[9];
            for (int j = 0; j < 9; j++) {
                String valor = tablero[i][j].getText();
                if (!valor.isEmpty() && !existentes[Integer.parseInt(valor) - 	1]) {
                    existentes[Integer.parseInt(valor) - 1] = true;
                } else {
                    return false; // devuelvo que el número está duplicado en la fila
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
                    return false; // devuelvo que el número está duplicado en la columna
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
                        return false; // devuelvo que el número está duplicado en el bloque
                    }
                }
            }
        }

        return true;
    }
}
