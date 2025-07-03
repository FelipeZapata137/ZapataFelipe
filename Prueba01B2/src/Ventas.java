import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Ventas extends Registro {
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
    private JButton buscarButton;
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

                for (int i = 0; i < limite; i++) {
                    if (ListaCodigo.get(i).equals(codigo)) {
                        ProductoTXT.setText(ListaNombre.get(i));
                        PrecioTXT.setText(ListaPrecio.get(i));
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
