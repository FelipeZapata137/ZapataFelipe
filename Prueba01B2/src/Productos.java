import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Productos extends Registro {
    private JPanel ProductosPanel;
    private JButton VolverAlMenúButton;
    private JLabel PrintNombreLBL;
    private JLabel PrintDetalleLBL;
    private JLabel PrintStockLBL;
    private JButton buscarButton;
    private JTextField CodigoTXT;

    public Productos() {

        setTitle("Ver Productos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(ProductosPanel);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        setResizable(false);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = CodigoTXT.getText();
                if (codigo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un código", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int limite = ListaCodigo.size();

                if (limite == 0) {
                    JOptionPane.showMessageDialog(null, "No hay productos registrados", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                for (int i = 0; i <= limite - 1; i++) {
                    if (ListaCodigo.get(i).equals(codigo)) {
                        PrintNombreLBL.setText("Nombre: " + ListaNombre.get(i));
                        PrintDetalleLBL.setText("Detalle: " + ListaDetalle.get(i));
                        PrintStockLBL.setText("Stock: " + ListaStock.get(i));
                        return;
                    }
                }
            }
        });

        VolverAlMenúButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductosPanel.setVisible(false);
                new Principal();
            }
        });
    }
}
