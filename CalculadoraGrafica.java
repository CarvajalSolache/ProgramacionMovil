import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraGrafica extends JFrame {

    JTextField num1, num2;
    JButton btnSumar, btnRestar, btnMultiplicar, btnDividir;
    JLabel resultado;
    Font fuente = new Font("Arial", 1, 60);

    public CalculadoraGrafica() {
        setTitle("casio");
        setSize(400, 400);
        setDefaultCloseOperation(3);
        setLayout(new GridLayout(4, 1));

        num1 = new JTextField(10);
        num1.setFont(fuente);

        num2 = new JTextField(10);
        num2.setFont(fuente);

        btnSumar = new JButton("+");
        btnRestar = new JButton("-");
        btnMultiplicar = new JButton("x");
        btnDividir = new JButton("/");

        JPanel pOpciones = new JPanel();
        pOpciones.add(btnSumar);
        pOpciones.add(btnRestar);
        pOpciones.add(btnMultiplicar);
        pOpciones.add(btnDividir);

        resultado = new JLabel();
        resultado.setFont(fuente);

        add(num1);
        add(num2);
        add(pOpciones);
        add(resultado);

        // TODOS los listeners con lambda
        btnSumar.addActionListener(e -> {
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            resultado.setText((n1 + n2) + "");
        });

        btnRestar.addActionListener(e -> {
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            resultado.setText((n1 - n2) + "");
        });

        btnMultiplicar.addActionListener(e -> {
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            resultado.setText((n1 * n2) + "");
        });

        btnDividir.addActionListener(e -> {
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            resultado.setText((n1 / n2) + "");
        });
    }

    public static void main(String[] args) {
        CalculadoraGrafica cg = new CalculadoraGrafica();
        cg.setVisible(true);
    }
}