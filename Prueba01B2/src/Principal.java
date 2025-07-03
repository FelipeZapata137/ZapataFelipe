import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private CardLayout cl = new CardLayout();
    private JPanel PanelPrincipal;
    private JPanel panelPrincipal = new JPanel(cl);
    private JButton RegistroBTN;
    private JButton VentasBTN;
    private JButton ProductosBTN;
    private JLabel menuLBL;
    private JPanel RegistroPanel = new JPanel();
    private JPanel VentasPanel = new JPanel();
    private JPanel ProductosPanel = new JPanel();

    public Principal() {

        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(PanelPrincipal);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        setResizable(false);

        RegistroBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelPrincipal, "RegistroPanel");
            }
        });

        VentasBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelPrincipal, "VentasPanel");
            }
        });

        ProductosBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelPrincipal, "ProductosPanel");
            }
        });
    }
}
