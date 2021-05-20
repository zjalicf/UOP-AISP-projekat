package GUI.Dispecer;

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
            launchDodajVozacaFrame();
        } else if (e.getSource() == dodajDispeceraButton){
            launchDodajDispeceraFrame();
        } else if (e.getSource() == nazadButton) {
            this.dispose();
            this.setVisible(false);
        }
    }

    private void launchDodajDispeceraFrame() {
//        DodajDispeceraFrame dodajDispeceraFrame = new DodajDispeceraFrame();
//        dodajDispeceraFrame.setVisible(true);
//        dodajDispeceraFrame.setBounds(20, 20, 280, 400);
////        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        dodajDispeceraFrame.setResizable(false);
    }

    private void launchDodajVozacaFrame() {
        DodajVozacaFrame dodajVozacaFrame = new DodajVozacaFrame();
        dodajVozacaFrame.setVisible(true);
        dodajVozacaFrame.setBounds(20, 20, 250, 416);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dodajVozacaFrame.setResizable(false);
    }
}
