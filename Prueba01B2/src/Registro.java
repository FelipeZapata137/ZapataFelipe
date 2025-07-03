import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
    public List<String> ListaCodigo = new ArrayList<>();
    public List<String> ListaNombre = new ArrayList<>();
    public List<String> ListaDetalle = new ArrayList<>();
    public List<String> ListaPrecio = new ArrayList<>();
    public List<String> ListaStock = new ArrayList<>();

    public Registro() {

        setTitle("Registro de Productos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(RegistroPanel);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        setResizable(false);

        GuardarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoInput = CodigoTXT.getText();
                String nombreInput = NombreTXT.getText();
                String detalleInput = DetalleTXT.getText();
                String precioInput = PrecioUniTXT.getText();
                String stockInput = StockTXT.getText();

                if (codigoInput.isEmpty() || nombreInput.isEmpty() || detalleInput.isEmpty() || precioInput.isEmpty() || stockInput.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ListaCodigo.add(codigoInput);
                ListaNombre.add(nombreInput);
                ListaDetalle.add(detalleInput);
                ListaPrecio.add(precioInput);
                ListaStock.add(stockInput);
                JOptionPane.showMessageDialog(null, "Producto registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
