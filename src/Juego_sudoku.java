import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;

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

	/**
	 * Launch the application.
	 */
	public void iniciarJuego() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego_sudoku frame = new Juego_sudoku(null);
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
	public Juego_sudoku(JFrame juego) {
		super(juego, true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\david.lejo\\Desktop\\cr7.jpg"));
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
		
		
		
		
		for (int i = 0; i < 9; i++) { // i es el índice de fila
		    for (int j = 0; j < 9; j++) { // j es el índice de columna
		        JTextField casilla = new JTextField("");
		        casilla.setHorizontalAlignment(SwingConstants.CENTER);
				casilla.setForeground(Color.RED);
				casilla.setBorder(new LineBorder(new Color(12, 128, 98)));
				casilla.setBackground(Color.WHITE);
		        panelJuego.add(casilla);
		        tablero[i][j] = casilla;
		    }
		}
	}
	
	

}
