package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Xavier Mora
 */
public class MiBoton implements ActionListener {

    int id;
    Planetas p;

    public MiBoton(int id, Planetas p) {
        this.id = id;
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Planeta planeta = new Planeta();
        planeta.recalcularInformacion(id);
        planeta.setVisible(true);
        p.setVisible(false);
    }
}
