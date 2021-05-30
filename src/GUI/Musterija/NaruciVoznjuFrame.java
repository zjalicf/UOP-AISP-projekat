package GUI.Musterija;

import entiteti.Korisnik;
import entiteti.Voznja;
import enums.StatusVoznje;
import fileIO.VoznjaIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class NaruciVoznjuFrame extends JFrame implements ActionListener {
    private final Korisnik ulogovani;
    Container container = getContentPane();
    private final JLabel adresaPolaskaLabel = new JLabel("Unesite vasu adresu: ");
    private final JTextField adresaPolaskaField = new JTextField(20);
    private final JLabel adresaDolaskaLabel = new JLabel("Unesite destinaciju: ");
    private final JTextField adresaDolaskaField = new JTextField(20);
    private final JButton okButton = new JButton("OK");
    JLabel orderGif = new JLabel(new ImageIcon("src/img/order.gif"));
    private final JButton odjavaButton = new JButton("Odjava");

    public NaruciVoznjuFrame(Korisnik ulogovani) {
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
        adresaPolaskaLabel.setBounds(10,320,130,24);
        adresaPolaskaField.setBounds(140,320,130,24);
        adresaDolaskaLabel.setBounds(10,350,130,24);
        adresaDolaskaField.setBounds(140,350,130,24);
        okButton.setBounds(290,320,80,23);
        orderGif.setBounds(0, 20, 380,280);
        odjavaButton.setBounds(290,350,80,23);
    }

    public void addComponentsToContainer() {
        container.add(adresaPolaskaLabel);
        container.add(adresaPolaskaField);
        container.add(adresaDolaskaLabel);
        container.add(adresaDolaskaField);
        container.add(okButton);
        container.add(orderGif);
        container.add(odjavaButton);
    }

    public void addActionEvent() {
        okButton.addActionListener(this);
        odjavaButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            potvrdiPorudzbinu();
        } else if (e.getSource() == odjavaButton) {
            this.dispose();
            this.setVisible(false);
        }
    }

    private void potvrdiPorudzbinu() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String datum = currentDateTime.format(formatter);
        String adresaPolaska = this.adresaPolaskaField.getText().trim();
        String adresaDestinacije = this.adresaDolaskaField.getText().trim();
        String idMusterije = this.ulogovani.getIdKorisnika();
        String idVozaca = "0";
        Double predjenoKm = 0.0;
        int trajanjeVoznje = 0;
        StatusVoznje statusVoznje = StatusVoznje.KREIRANA;
        String idVoznje = String.valueOf((int) (Math.random() * 999999) + 100000);
        int ocena = 0;

        Voznja novaVoznja = new Voznja(datum, adresaPolaska, adresaDestinacije, idMusterije, idVozaca, predjenoKm, trajanjeVoznje, statusVoznje,
                idVoznje, ocena, false);
        ArrayList<Voznja> sveVoznje = VoznjaIO.voznjaCitanje();
        sveVoznje.add(novaVoznja);
        VoznjaIO.voznjaUpis(sveVoznje);
        JOptionPane.showMessageDialog(null, "Uspesno ste narucili voznju", "STATIM", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        this.setVisible(false);
    }
}
