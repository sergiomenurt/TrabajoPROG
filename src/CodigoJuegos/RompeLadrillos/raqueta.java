package CodigoJuegos.RompeLadrillos;

import javax.swing.JFrame;

public class raqueta extends JFrame {

    public raqueta()
    {
        add(new tablero());
        setTitle("tennis de mesa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(comun.WIDTH, comun.HEIGTH);
        setLocationRelativeTo(null);
        setIgnoreRepaint(true);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new raqueta();
    }
}
