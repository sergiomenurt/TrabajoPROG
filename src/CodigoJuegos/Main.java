package CodigoJuegos;

import CodigoJuegos.RompeLadrillos.raqueta;
import CodigoJuegos.Snake.Snake;
import CodigoJuegos.Tractor.Tractor.Principal;

import javax.swing.*;

public class Main {
    
    public static void main(String []args){
        
     boolean salir = false;
        int opcion = 0;
        
            do {

                //creamos un menú para elegir el juego que se quiera jugar
                
                JOptionPane.showMessageDialog(null, "BIENVENIDO");
                
                opcion = Integer.parseInt(JOptionPane.showInputDialog(" Seleccione el juego que desee juger:\n 1.Rompe Ladrillos\n 2.Snake\n 3.Saltar vacas  "));
                switch (opcion) {
                    case 1:
                        JOptionPane.showMessageDialog(null, " Has seleccionado el Rompe Ladrillos ");
                        raqueta.main(args);
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null, " Has seleccionado el Snake ");
                        Snake.main(args);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, " Has seleccionado el juego de saltar vacas ");
                        Principal.PrimerMinijuego();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, " FIN DEL MINIJUEGO ");
                        System.exit(0);
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, " Solo números entre el 1 y el 4 ");
                        
                }
            } while (salir=false);
        }
}

