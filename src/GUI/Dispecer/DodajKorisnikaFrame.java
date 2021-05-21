package GUI.Dispecer;

import GUI.FrameLauncher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajKorisnikaFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JButton dodajVozacaButton = new JButton("Vozaci");
    private JButton dodajDispeceraButton = new JButton("Dispeceri");
    private JButton nazadButton = new JButton("Nazad");

    public DodajKorisnikaFrame () {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        dodajVozacaButton.setBounds(15,15,130,28);
        dodajDispeceraButton.setBounds(15,60,130,28);
        nazadButton.setBounds(15,105,130,28);
    }

    public void addComponentsToContainer() {
        container.add(dodajDispeceraButton);
        container.add(dodajVozacaButton);
        container.add(nazadButton);
    }

    public void addActionEvent() {
        dodajDispeceraButton.addActionListener(this);
        dodajVozacaButton.addActionListener(this);
        nazadButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dodajVozacaButton) {
            FrameLauncher.launchDodajVozacaFrame();
        } else if (e.getSource() == dodajDispeceraButton){
            FrameLauncher.launchDodajDispeceraFrame();
        } else if (e.getSource() == nazadButton) {
            this.dispose();
            this.setVisible(false);
        }
    }
}
