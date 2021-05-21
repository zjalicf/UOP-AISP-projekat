package GUI.Vozac;

import GUI.FrameLauncher;
import entiteti.Korisnik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VozacFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JButton dodeljeneVoznjeButton= new JButton("Moje voznje");
    private JButton odjavaButton = new JButton("Odjava");
    private JLabel slika = new JLabel(new ImageIcon("src/img/person.jpg"));
    private Korisnik ulogovani;

    public VozacFrame(Korisnik ulogovani) {
        this.ulogovani = ulogovani;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        dodeljeneVoznjeButton.setBounds(15,15,130,28);
        odjavaButton.setBounds(15,15,130,28);
        slika.setBounds(166, 32, 150,125);
    }

    public void addComponentsToContainer() {
        container.add(dodeljeneVoznjeButton);
        container.add(odjavaButton);
        container.add(slika);
    }

    public void addActionEvent() {
        dodeljeneVoznjeButton.addActionListener(this);
        odjavaButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dodeljeneVoznjeButton) {
            FrameLauncher.launchListaVoznjiVozacFrame(ulogovani);
        } else if (e.getSource() == odjavaButton){
            this.dispose();
            this.setVisible(false);
        }
    }
}
