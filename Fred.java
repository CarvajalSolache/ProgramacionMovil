import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Fred extends JFrame {

    JButton[] casillas = new JButton[4];
    int[] secuencia = new int[5];
    Random random = new Random();

    // Colores asignados a cada botón
    Color[] colores = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

    public Fred() {
        setTitle("Fred20");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(2, 2));

        for (int i = 0; i < 4; i++) {
            casillas[i] = new JButton();
            casillas[i].setBackground(Color.LIGHT_GRAY);

            final int indice = i;

            // 👉 Evento de clic
            casillas[i].addActionListener(e -> encenderBoton(indice));

            add(casillas[i]);
        }

        generarSecuencia();
        mostrarSecuencia();
    }

    public void generarSecuencia() {
        for (int i = 0; i < secuencia.length; i++) {
            secuencia[i] = random.nextInt(4);
        }

        for (int s : secuencia) {
            System.out.print(s + " ");
        }
    }

    // 👉 Método para encender un botón
    public void encenderBoton(int indice) {
        new Thread(() -> {
            try {
                SwingUtilities.invokeLater(() -> {
                    casillas[indice].setBackground(colores[indice]);
                });

                Thread.sleep(500);

                SwingUtilities.invokeLater(() -> {
                    casillas[indice].setBackground(Color.LIGHT_GRAY);
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void mostrarSecuencia() {
        new Thread(() -> {
            try {
                for (int i = 0; i < secuencia.length; i++) {
                    int indice = secuencia[i];

                    SwingUtilities.invokeLater(() -> {
                        casillas[indice].setBackground(colores[indice]);
                    });

                    Thread.sleep(1000);

                    SwingUtilities.invokeLater(() -> {
                        casillas[indice].setBackground(Color.LIGHT_GRAY);
                    });

                    Thread.sleep(500);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        Fred f = new Fred();
        f.setVisible(true);
    }
}