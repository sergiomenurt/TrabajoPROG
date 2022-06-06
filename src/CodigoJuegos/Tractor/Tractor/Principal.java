package CodigoJuegos.Tractor.Tractor;


import CodigoJuegos.Tractor.LecturaFicheros.Main;
import javax.swing.*;

import java.awt.*;

public class Principal {

    public static int reiniciaJuego=-1;

    public static void PrimerMinijuego() {
        JOptionPane.showMessageDialog(null,"¿Estas preparado?");

        JFrame ventana = new JFrame("Jueguito"); // Creo una ventana llamada jueguito
        Juego jueguito = new Juego(); // Creo un objeto llamado jueguito
        ventana.add(jueguito); // Añadimos a la ventana el juego
        ventana.setSize(1300,400); // Establecemos un tamaño

        ventana.setLocationRelativeTo(null);// Establecemos su localización
        ventana.setVisible(true); // Lo hacemos visible
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true){
            if (jueguito.juegoFinalizado){
                reiniciaJuego=JOptionPane.showConfirmDialog(null,"HAS PERDIDO, ¿QUIERES JUGAR DE NUEVO?"," HAS PERDIDO",JOptionPane.YES_NO_OPTION);
                if (reiniciaJuego==0){
                    reiniciaValores();

                }else if(reiniciaJuego==1){
                    ventana.setVisible(false);
                    ventana.dispose();

                    String s = "si";

                    JOptionPane.showMessageDialog(null,"GRACIAS POR JUGAR");
                    break;
                    
 

                }
            }else{
                jueguito.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Juego.pierdeVida==true){
                    JOptionPane.showMessageDialog(null," PELIGRO!!!");
                    Juego.pierdeVida=false;
                    Juego.vidas--;
                    Auto.y_inicial=270;
                    Auto.saltando=false;
                    Obstaculo.x_inicial=1300;
                }

            }
        }
    }
    public static void reiniciaValores(){
        Juego.juegoFinalizado=false;
        Obstaculo.x_auxiliar=-4;
        Juego.puntos=0;
        Juego.nivel=1;
        Juego.vidas=3;
        reiniciaJuego=-1;
        Obstaculo.x_inicial=1300;
    }
}
