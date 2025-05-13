package cafeteria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.dao.ClienteDAO;

public class TelaLogin extends JFrame {
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private JButton botaoLogin;
    private JButton botaoRegistrar;
    private JButton botaoEsqueciSenha;

    public TelaLogin() {
        setTitle("Login - Cafeteria Java");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Email:"));
        campoEmail = new JTextField();
        add(campoEmail);

        add(new JLabel("Senha:"));
        campoSenha = new JPasswordField();
        add(campoSenha);

        botaoLogin = new JButton("Entrar");
        add(botaoLogin);
        
        botaoRegistrar = new JButton("Registrar");
        add(botaoRegistrar);
        
        botaoEsqueciSenha = new JButton("Esqueci a Senha");
        add(botaoEsqueciSenha);

        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autenticarUsuario();
            }
        });
        
        botaoRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaRegistro().setVisible(true);
                dispose();
            }
        });
        
        botaoEsqueciSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Recuperação de senha ainda não implementada.");
            }
        });
    }

    private void autenticarUsuario() {
        String email = campoEmail.getText();
        String senha = new String(campoSenha.getPassword());
        ClienteDAO clienteDAO = new ClienteDAO();
        
        if (clienteDAO.validarLogin(email, senha)) {
            JOptionPane.showMessageDialog(this, "Login bem-sucedido! Bem-vindo à Cafeteria Java.");
            new TelaPrincipal().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Email ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaLogin().setVisible(true));
    }
}
