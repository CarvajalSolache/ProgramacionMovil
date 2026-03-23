import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gato extends JFrame implements ActionListener{
    JButton botones [] = new JButton[9];
    boolean turnoX;
    Font fuente  = new Font("Arial", 1, 50);        
    JButton btnReiniciar;
    JPanel panelJuego, panelOpciones;
   
    public Gato(){
        setSize(400,400);
        setTitle("Juego Gato");
        setDefaultCloseOperation(3);
       
        panelJuego = new JPanel(new GridLayout(3, 3));
        panelOpciones = new JPanel();
       
        for(int i=0; i<botones.length;i++){
            botones[i] = new JButton("");
            botones[i].setFont(fuente);
            botones[i].addActionListener(this);
            panelJuego.add(botones[i]);
        }
        btnReiniciar = new JButton("Reiniciar Juego");        
       
        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               for(int i=0; i<botones.length;i++){
                        botones[i].setText("");    
                        botones[i].setEnabled(true);
                        turnoX = true;
                }
            }
        });
   
        panelOpciones.add(btnReiniciar);        
        add(panelJuego, BorderLayout.CENTER);
        add(panelOpciones, BorderLayout.SOUTH);        
    }
   
    public void actionPerformed(ActionEvent e){  
        String letra;
        if(turnoX) {
             letra = "X";
             turnoX=false;
        } else {
            letra = "O";
            turnoX=true;
        }
        for(int i=0;i<botones.length;i++){
            if((e.getSource()==botones[i])){            
                botones[i].setText(letra);
                botones[i].setEnabled(false);
            }  
        }
        verificarGanador();
    }
    
    public void verificarGanador(){
    int[][] combinaciones = {
        {0,1,2},
        {3,4,5},
        {6,7,8},
        {0,3,6},
        {1,4,7},
        {2,5,8},
        {0,4,8},
        {2,4,6}
    };
    
    for(int i=0;i<combinaciones.length;i++){
        int a = combinaciones[i][0];
        int b = combinaciones[i][1];
        int c = combinaciones[i][2];
        
        if(!botones[a].getText().equals("") &&
           botones[a].getText().equals(botones[b].getText()) &&
           botones[a].getText().equals(botones[c].getText())){
            
            JOptionPane.showMessageDialog(null,"Ganó " + botones[a].getText());
            
            for(int j=0;j<botones.length;j++){
                botones[j].setEnabled(false);
            }
        }
    }
}
    public static void main(String[] args) {
        Gato gt01 = new Gato();
        gt01.setVisible(true);
    }
}