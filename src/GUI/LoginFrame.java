package GUI;

import entiteti.Dispecer;
import entiteti.Korisnik;
import entiteti.Musterija;
import entiteti.Vozac;
import fileIO.KorisnikIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel logo = new JLabel(new ImageIcon("src/img/logotemp.gif"));
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JCheckBox showPassword = new JCheckBox("Show Password");

    public LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        logo.setBounds(12,30,500,350);
        userLabel.setBounds(50, 420, 100, 24);
        passwordLabel.setBounds(50, 460, 100, 24);
        usernameField.setBounds(160, 420, 150, 24);
        passwordField.setBounds(160, 460, 150, 24);
        showPassword.setBounds(330, 416, 120, 30);
        loginButton.setBounds(334, 459, 120, 24);
    }

    public void addComponentsToContainer() {
        container.add(logo);
        container.add(userLabel);
        container.add(showPassword);
        container.add(passwordLabel);
        container.add(usernameField);
        container.add(passwordField);
        container.add(loginButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String usernameText = String.valueOf(usernameField.getText());
            String passwordText = String.valueOf(passwordField.getPassword());
            Korisnik ulogovani = login(usernameText, passwordText);
            if(ulogovani == null) {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
            else {
                if (ulogovani instanceof Dispecer) {
                    JOptionPane.showMessageDialog(this, "DISPECER");
                }
                else if(ulogovani instanceof Musterija) {
                    JOptionPane.showMessageDialog(this, "MUSTERIJA");
                }
                else if(ulogovani instanceof Vozac) {
                    JOptionPane.showMessageDialog(this, "VOZAC");
                }
            }
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }
    static ArrayList<Korisnik> sviKorisnici = KorisnikIO.korisnikCitanje();
    public static ArrayList<Korisnik> getKorisnici() {
        return sviKorisnici;
    }
    public static Korisnik login(String username, String password) {
        for (Korisnik korisnik : getKorisnici()) {
            if (korisnik.getUsername().equalsIgnoreCase(username) && korisnik.getPassword().equalsIgnoreCase(password)) {
                return korisnik;
            }
        }
        return null;
    }
}