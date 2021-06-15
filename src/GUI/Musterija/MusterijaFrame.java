package GUI.Musterija;

import GUI.FrameLauncher;
import entiteti.Korisnik;
import enums.Pol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusterijaFrame extends JFrame implements ActionListener {
    private Korisnik ulogovani;
    Container container = getContentPane();
    private final JButton sveVoznjeButton= new JButton("Moje voznje");
    private final JButton naruciVoznjuButton = new JButton("Naruci voznju");
    private final JButton odjavaButton = new JButton("Odjava");
    private JLabel slika;

    public MusterijaFrame(Korisnik ulogovani) {
        this.ulogovani = ulogovani;
        setSlika(ulogovani);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setSlika(Korisnik ulogovani) {
        if (ulogovani.getPol().equals(Pol.Muski)) {
            slika = new JLabel(new ImageIcon("src/img/muska_musterija.png"));
        } else if (ulogovani.getPol().equals(Pol.Zenski)) {
            slika = new JLabel(new ImageIcon("src/img/zenska_musterija.png"));
        }
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        sveVoznjeButton.setBounds(15,15,130,24);
        naruciVoznjuButton.setBounds(15,60,130,24);
        slika.setBounds(166, 32, 150,125);
        odjavaButton.setBounds(15,150,130,24);
    }

    public void addComponentsToContainer() {
        container.add(sveVoznjeButton);
        container.add(naruciVoznjuButton);
        container.add(odjavaButton);
        container.add(slika);
    }

    public void addActionEvent() {
        sveVoznjeButton.addActionListener(this);
        naruciVoznjuButton.addActionListener(this);
        odjavaButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sveVoznjeButton) {
            FrameLauncher.launchListaVoznjiMusterijaFrame();
        } else if (e.getSource() == naruciVoznjuButton){
            FrameLauncher.launchNaruciVoznjuFrame(ulogovani);
        } else if (e.getSource() == odjavaButton){
            this.dispose();
            this.setVisible(false);
        }
    }
}
