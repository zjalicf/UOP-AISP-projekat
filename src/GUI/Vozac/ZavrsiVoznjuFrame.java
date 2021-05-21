package GUI.Vozac;

import entiteti.Voznja;
import enums.StatusVoznje;
import fileIO.VoznjaIO;
import utility.Svasta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZavrsiVoznjuFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JLabel predjenoKmLabel = new JLabel("Predjeno km:");
    private JTextField predjenoKmField = new JTextField(20);
    private JLabel trajanjeVoznjeLabel = new JLabel("Trajanje voznje:");
    private JTextField trajanjeVoznjeField = new JTextField(20);
    private JButton potvrdiButton = new JButton("Potvrdi");
    private JButton nazadButton = new JButton("Nazad");
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
        predjenoKmField.setBounds(120,10,100,24);
        trajanjeVoznjeLabel.setBounds(10, 35,100,24);
        trajanjeVoznjeField.setBounds(120,35,100,24);
        potvrdiButton.setBounds(140,70,80,24);
        nazadButton.setBounds(180,70,80,24);
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
            ArrayList<Voznja> voznje = Svasta.getVoznje();
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
