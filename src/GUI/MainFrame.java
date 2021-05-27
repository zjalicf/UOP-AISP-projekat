package GUI;

import entiteti.Dispecer;
import entiteti.Korisnik;
import entiteti.Musterija;
import entiteti.Vozac;
import utility.GetUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel logo = new JLabel(new ImageIcon("src/img/logo.gif"));
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton cancelButton = new JButton("IZADJI");
    JCheckBox showPassword = new JCheckBox("Show Password");

    public MainFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        logo.setBounds(2,20,500,350);
        userLabel.setBounds(30, 420, 100, 24);
        passwordLabel.setBounds(30, 460, 100, 24);
        usernameField.setBounds(130, 420, 150, 24);
        passwordField.setBounds(130, 460, 150, 24);
        showPassword.setBounds(302, 416, 120, 30);
        loginButton.setBounds(306, 459, 80, 24);
        cancelButton.setBounds(392,459,80,24);
    }

    public void addComponentsToContainer() {
        container.add(logo);
        container.add(userLabel);
        container.add(showPassword);
        container.add(passwordLabel);
        container.add(usernameField);
        container.add(passwordField);
        container.add(loginButton);
        container.add(cancelButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        showPassword.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String usernameText = String.valueOf(usernameField.getText());
            String passwordText = String.valueOf(passwordField.getPassword());
            Korisnik ulogovani = login(usernameText, passwordText);

            if(ulogovani == null) {
                JOptionPane.showMessageDialog(this,
                        "Pogresan username ili password");
            } else if (ulogovani.isObrisan()){
                JOptionPane.showMessageDialog(this,
                        "Korisnik je obrisan");
            }
            else {
                if (ulogovani instanceof Dispecer) {
                    FrameLauncher.launchDispecerFrame(ulogovani);
                }
                else if(ulogovani instanceof Musterija) {
                    FrameLauncher.launchMusterijaFrame(ulogovani);
                }
                else if(ulogovani instanceof Vozac) {
                    FrameLauncher.launchVozacFrame(ulogovani);
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
        if (e.getSource() == cancelButton) {
            this.dispose();
            this.setVisible(false);
        }
    }

    public Korisnik login(String username, String password) {
        for (Korisnik korisnik : GetUtility.getKorisnici()) {
            if (korisnik.getUsername().equalsIgnoreCase(username) &&
                    korisnik.getPassword().equalsIgnoreCase(password)) {
                return korisnik;
            }
        }
        return null;
    }
}