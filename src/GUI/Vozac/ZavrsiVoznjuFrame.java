package GUI.Vozac;

import entiteti.Voznja;
import enums.StatusVoznje;
import fileIO.VoznjaIO;
import strukture.Lista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZavrsiVoznjuFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private final JLabel predjenoKmLabel = new JLabel("Predjeno km:");
    private final JTextField predjenoKmField = new JTextField(20);
    private final JLabel trajanjeVoznjeLabel = new JLabel("Trajanje voznje:");
    private final JTextField trajanjeVoznjeField = new JTextField(20);
    private final JButton potvrdiButton = new JButton("Potvrdi");
    private final JButton nazadButton = new JButton("Nazad");
    private String voznjaId;

    public ZavrsiVoznjuFrame(String voznjaId) {
        this.voznjaId = voznjaId;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        predjenoKmLabel.setBounds(10,10,100,24);
        predjenoKmField.setBounds(110,10,50,24);
        trajanjeVoznjeLabel.setBounds(10, 40,100,24);
        trajanjeVoznjeField.setBounds(110,40,50,24);
        potvrdiButton.setBounds(40,75,80,24);
        nazadButton.setBounds(40,105,80,24);
    }

    public void addComponentsToContainer() {
        container.add(predjenoKmLabel);
        container.add(predjenoKmField);
        container.add(trajanjeVoznjeLabel);
        container.add(trajanjeVoznjeField);
        container.add(potvrdiButton);
        container.add(nazadButton);
    }

    public void addActionEvent() {
        potvrdiButton.addActionListener(this);
        nazadButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == potvrdiButton) {
            Lista<Voznja> voznje = VoznjaIO.getVoznje();
            for (Voznja voznja: voznje) {
                if (voznja.getIdVoznje().equals(voznjaId)) {
                    voznja.setStatusVoznje(StatusVoznje.ZAVRSENA);
                    voznja.setPredjenoKm(Double.parseDouble(this.predjenoKmField.getText().trim()));
                    voznja.setTrajanjeVoznje(Integer.parseInt(this.trajanjeVoznjeField.getText().trim()));
                    VoznjaIO.voznjaUpis(voznje);
                    this.dispose();
                    this.setVisible(false);
                }
            }
        } else if (e.getSource() == nazadButton) {
            this.dispose();
            this.setVisible(false);
        }
    }
}
