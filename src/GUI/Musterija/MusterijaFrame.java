package GUI.Musterija;

import entiteti.Korisnik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusterijaFrame extends JFrame implements ActionListener {
    private final Korisnik ulogovani;
    Container container = getContentPane();
    private JButton sveVoznjeButton= new JButton("Moje voznje");
    private JButton naruciVoznjuButton = new JButton("Naruci voznju");
    private JButton oceniButton = new JButton("Oceni vozaca");
    private JButton odjavaButton = new JButton("Odjava");
    private JLabel slika = new JLabel(new ImageIcon("src/img/person.jpg"));

    public MusterijaFrame(Korisnik ulogovani) {
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
        sveVoznjeButton.setBounds(15,15,130,24);
        naruciVoznjuButton.setBounds(15,60,130,24);
        oceniButton.setBounds(15,105,130,24);
        slika.setBounds(166, 32, 150,125);
        odjavaButton.setBounds(15,150,130,24);
    }

    public void addComponentsToContainer() {
        container.add(sveVoznjeButton);
        container.add(naruciVoznjuButton);
        container.add(oceniButton);
        container.add(odjavaButton);
        container.add(slika);
    }

    public void addActionEvent() {
        sveVoznjeButton.addActionListener(this);
        naruciVoznjuButton.addActionListener(this);
        odjavaButton.addActionListener(this);
        oceniButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sveVoznjeButton) {
            JOptionPane.showMessageDialog(this,
                    "sve vzonje");
        } else if (e.getSource() == naruciVoznjuButton){
            launchNaruciVoznjuFrame(ulogovani);
        } else if (e.getSource() == oceniButton) {
            JOptionPane.showMessageDialog(this,
                    "ocena 5");
        } else if (e.getSource() == odjavaButton){
            this.dispose();
            this.setVisible(false);
        }
    }
    private void launchNaruciVoznjuFrame(Korisnik ulogovani) {
        NaruciVoznjuFrame naruciVoznjuFrame = new NaruciVoznjuFrame(ulogovani);
        naruciVoznjuFrame.setVisible(true);
        naruciVoznjuFrame.setBounds(0, 20, 396, 430);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        naruciVoznjuFrame.setResizable(false);
    }
}
