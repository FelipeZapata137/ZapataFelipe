import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Ventas extends JFrame {
    private JButton calcularButton;
    private JButton volverAlMenúButton;
    private JLabel PrintTotalLBL;
    private JTextField CodigoTXT;
    private JTextField ProductoTXT;
    private JTextField PrecioTXT;
    private JTextField CantidadTXT;
    private JLabel PrintSubTotalLBL;
    private JLabel PrintIvaLBL;
    private JPanel VentasPanel;
    private DecimalFormat df = new DecimalFormat("#.##");

    public Ventas() {

        setTitle("Ventas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(VentasPanel);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        setResizable(false);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = CodigoTXT.getText();
                String producto = ProductoTXT.getText();
                String precioStr = PrecioTXT.getText();
                String cantidadStr = CantidadTXT.getText();

                if (codigo.isEmpty() || producto.isEmpty() || precioStr.isEmpty() || cantidadStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double precio = Double.parseDouble(precioStr);
                    int cantidad = Integer.parseInt(cantidadStr);
                    double subTotal = precio * cantidad;
                    double iva = subTotal * 0.15;
                    double total = subTotal + iva;

                    PrintSubTotalLBL.setText("SubTotal: " + df.format(subTotal));
                    PrintIvaLBL.setText("IVA: " + df.format(iva));
                    PrintTotalLBL.setText("Total: " + df.format(total));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Precio inválido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        volverAlMenúButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(volverAlMenúButton);
                if (frame != null) {
                    frame.dispose();
                }
                new Principal();
            }
        });
    }
}
