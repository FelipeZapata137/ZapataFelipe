import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JButton IngresarBTN;
    private JLabel UsuarioLBL;
    private JLabel contrasenaLBL;
    private JPasswordField ContrasenaTXT;
    private JTextField UsuarioTXT;
    private JPanel LoginPanel;

    public Login() {

        setTitle("Inicio de Sesión");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(LoginPanel);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        setResizable(false);

        IngresarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String usuario = UsuarioTXT.getText();
                String contrasena = new String(ContrasenaTXT.getPassword());

                if (usuario.isEmpty() || contrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (usuario.equals("FelipeZapata123") && contrasena.equals("clave123")) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                    dispose();
                    new Principal();
                    LoginPanel.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
