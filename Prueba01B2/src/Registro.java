import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends JFrame {
    private JPanel RegistroPanel;
    private JButton GuardarBTN;
    private JButton LimpiarBTN;
    private JButton MenuBTN;
    private JTextField CodigoTXT;
    private JTextField PrecioUniTXT;
    private JTextField DetalleTXT;
    private JTextField StockTXT;
    private JTextField NombreTXT;

    public Registro() {
        GuardarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        LimpiarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CodigoTXT.setText("");
                PrecioUniTXT.setText("");
                DetalleTXT.setText("");
                StockTXT.setText("");
                NombreTXT.setText("");
            }
        });

        MenuBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Principal();
            }
        });
    }
}
