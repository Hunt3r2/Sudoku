import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Juego_sudoku(JFrame juego, int dificultad) {
		super(juego, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\david.lejo\\Deskarriba\\cr7.jpg"));
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
				
				int arriba, izq, abajo, dech;
				arriba = izq = abajo = dech = 1;
				if (i % 3 == 0) arriba = 3;
				if ((i + 1) % 3 == 0) abajo =3;
				if (j % 3 ==0) izq=3;
				if ((j +1)%3==0) dech=3;
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
			generarTableroDificil();
			System.out.println("medio");
			break;
		case 3:
			generarTableroMedio();
			System.out.println("dificil");
			break;		
		}

	}
	
	public void generarTableroFacil() {
	    // Primero, generamos un tablero de Sudoku completamente resuelto
	    // Puedes usar cualquier algoritmo que prefieras para esto
	    generarTablero();

	    // Luego, creamos un objeto Random para seleccionar las celdas a vaciar
	    Random rand = new Random();

	    // Vaciamos 30 celdas al azar
	    for (int i = 0; i < 30; i++) {
	        int fila, columna;
	        do {
	            fila = rand.nextInt(9);
	            columna = rand.nextInt(9);
	        } while (tablero[fila][columna].getText().equals(""));

	        // Vaciamos la celda
	        tablero[fila][columna].setText("");
	    }
	}
	
	public void generarTableroMedio() {
	    // Primero, generamos un tablero de Sudoku completamente resuelto
	    // Puedes usar cualquier algoritmo que prefieras para esto
	    generarTablero();

	    // Luego, creamos un objeto Random para seleccionar las celdas a vaciar
	    Random rand = new Random();

	    // Vaciamos 30 celdas al azar
	    for (int i = 0; i < 40; i++) {
	        int fila, columna;
	        do {
	            fila = rand.nextInt(9);
	            columna = rand.nextInt(9);
	        } while (tablero[fila][columna].getText().equals(""));

	        // Vaciamos la celda
	        tablero[fila][columna].setText("");
	    }
	}
	
	public void generarTableroDificil() {
	    // Primero, generamos un tablero de Sudoku completamente resuelto
	    // Puedes usar cualquier algoritmo que prefieras para esto
	    generarTablero();

	    // Luego, creamos un objeto Random para seleccionar las celdas a vaciar
	    Random rand = new Random();

	    // Vaciamos 30 celdas al azar
	    for (int i = 0; i < 50; i++) {
	        int fila, columna;
	        do {
	            fila = rand.nextInt(9);
	            columna = rand.nextInt(9);
	        } while (tablero[fila][columna].getText().equals(""));

	        // Vaciamos la celda
	        tablero[fila][columna].setText("");
	    }
	}
	
	public void generarTablero() {

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

	    // Llenamos el tablero de la interfaz gráfica con los números del tablero resuelto
	    for (int i = 0; i < 9; i++) {
	        for (int j = 0; j < 9; j++) {
	            tablero[i][j].setText(String.valueOf(tableroResuelto[i][j]));
	        }
	    }
	}


	
	

}
