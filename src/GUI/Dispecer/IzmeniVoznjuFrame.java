package GUI.Dispecer;

import entiteti.Vozac;
import entiteti.Voznja;
import enums.StatusVoznje;
import fileIO.KorisnikIO;
import fileIO.VoznjaIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IzmeniVoznjuFrame extends JFrame implements ActionListener {
    private final String voznjaId;
    Container container = getContentPane();
    private final JButton confirmButton = new JButton("Potvrdi");
    private final JButton cancelButton = new JButton("Odustani");
    private final JLabel datumVoznjeLabel = new JLabel("Datum voznje: ");
    private final JTextField datumVoznjeField = new JTextField(20);
    private final JLabel adresaPolaskaLabel = new JLabel("Adresa polaska: ");
    private final JTextField adresaPolaskaField = new JTextField(20);
    private final JLabel adresaDolaskaLabel = new JLabel("Adresa dolaska: ");
    private final JTextField adresaDolaskaField = new JTextField(20);
    private final JLabel idMusterijeLabel = new JLabel("ID musterije: ");
    private final JTextField idMusterijeField = new JTextField(20);
    private final JLabel idVozacaLabel = new JLabel("ID vozaca: ");
    private final JTextField idVozacaField = new JTextField(20);
    private final JLabel predjenoKmLabel = new JLabel("Predjeno km: ");
    private final JTextField predjenoKmField = new JTextField(20);
    private final JLabel trajanjeVoznjeLabel = new JLabel("Trajanje voznje: ");
    private final JTextField trajanjeVoznjeField = new JTextField(20);
    private final JLabel statusVoznjeLabel = new JLabel("Status voznje: ");
    private final JComboBox<StatusVoznje> statusVoznjeCb = new JComboBox(StatusVoznje.values());
    private final JLabel idVoznjeLabel = new JLabel("ID voznje: ");
    private final JTextField idVoznjeField = new JTextField(20);
    private final JLabel ocenaLabel = new JLabel("Ocena voznje: ");
    private final JTextField ocenaField = new JTextField(20);

    public IzmeniVoznjuFrame(String voznjaId) {
        this.voznjaId = voznjaId;
        fill();
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void fill() {
        for (Voznja voznja: VoznjaIO.getVoznje()) {
            if (voznjaId.equals(voznja.getIdVoznje())) {
                datumVoznjeField.setText(voznja.getDatumPorudzbine());
                adresaPolaskaField.setText(voznja.getAdresaPolaska());
                adresaDolaskaField.setText(voznja.getAdresaDestinacije());
                idMusterijeField.setText(voznja.getIdMusterije());
                idMusterijeField.setEditable(false);
                idVozacaField.setText(voznja.getIdVozaca());
                predjenoKmField.setText(String.valueOf(voznja.getPredjenoKm()));
                trajanjeVoznjeField.setText(String.valueOf(voznja.getTrajanjeVoznje()));
                statusVoznjeCb.setSelectedItem(voznja.getStatusVoznje());
                statusVoznjeCb.setEnabled(false);
                idVoznjeField.setText(voznja.getIdVoznje());
                idVoznjeField.setEditable(false);
                ocenaField.setText(String.valueOf(voznja.getOcenaVoznje()));
            }
        }
    }

    public boolean provera() {
        boolean correct = true;
        String output = "Greske:\n";
        ArrayList<String> idVozaca = new ArrayList<>();

        if (this.adresaPolaskaField.getText().trim().equals("")) {
            output = output + "Unesite adresu polaska\n";
            correct = false;
        }

        if (this.adresaDolaskaField.getText().trim().equals("")) {
            output = output + "Unesite adresu dolaska\n";
            correct = false;
        }

        if (this.idVozacaField.getText().trim().equals("")) {
            output = output + "Unesite ID vozaca\n";
            correct = false;
        }

        for (Vozac vozac: KorisnikIO.getVozaci()) {
            if (this.idVozacaField.getText().trim().equals(vozac.getIdKorisnika())) {
                idVozaca.add(vozac.getIdKorisnika());
            }
        }

        if (idVozaca.size() == 0) {
            output = output + "Ne postoji vozac sa takvim ID\n";
            correct = false;
        }

        if (this.predjenoKmField.getText().trim().equals("")) {
            output = output + "Unesite broj predjenih km\n";
            correct = false;
        }

        if (this.predjenoKmField.getText().trim().matches(".*[a-zA-Z]+.*")) {
            output = output + "Broj predjenih km ne sme da sadrzi slova\n";
            correct = false;
        }

        if (this.trajanjeVoznjeField.getText().trim().equals("")) {
            output = output + "Unesite trajanje voznje\n";
            correct = false;
        }

        if (this.trajanjeVoznjeField.getText().trim().matches(".*[a-zA-Z]+.*")) {
            output = output + "Trajanje voznje ne sme da sadrzi slova\n";
            correct = false;
        }

        if (this.ocenaField.getText().trim().equals("")) {
            output = output + "Unesite ocenu\n";
            correct = false;
        }

        if (this.ocenaField.getText().trim().matches(".*[a-zA-Z]+.*") || this.ocenaField.getText().trim().length() != 1 ||
                (Integer.parseInt(this.ocenaField.getText().trim()) < 1 || Integer.parseInt(this.ocenaField.getText().trim()) > 5)) {
            output = output + "Ocena ne sme da sadrzi slova i mora biti od 1 do 5\n";
            correct = false;
        }

        if (!correct) {
            JOptionPane.showMessageDialog(null, output, "STATIM", JOptionPane.WARNING_MESSAGE);
        }
        return correct;
    }

    public void setLocationAndSize() {
        datumVoznjeLabel.setBounds(5,5,100,20);
        adresaPolaskaLabel.setBounds(5,30,100,20);
        adresaDolaskaLabel.setBounds(5,55,100,20);
        idMusterijeLabel.setBounds(5,80,100,20);
        idVozacaLabel.setBounds(5,105,100,20);
        predjenoKmLabel.setBounds(5,130,100,20);
        trajanjeVoznjeLabel.setBounds(5,155,100,20);
        statusVoznjeLabel.setBounds(5,180,100,20);
        idVoznjeLabel.setBounds(5,205,100,20);
        ocenaLabel.setBounds(5,230,100,20);

        datumVoznjeField.setBounds(110,5,100,20);
        adresaPolaskaField.setBounds(110,30,100,20);
        adresaDolaskaField.setBounds(110,55,100,20);
        idMusterijeField.setBounds(110,80,100,20);
        idVozacaField.setBounds(110,105,100,20);
        predjenoKmField.setBounds(110,130,100,20);
        trajanjeVoznjeField.setBounds(110,155,100,20);
        statusVoznjeCb.setBounds(110,180,100,20);
        idVoznjeField.setBounds(110,205,100,20);
        ocenaField.setBounds(110,230,100,20);

        confirmButton.setBounds(5,310,100,24);
        cancelButton.setBounds(110,310,100,24);
    }

    public void addComponentsToContainer() {
        container.add(confirmButton);
        container.add(cancelButton);
        container.add(datumVoznjeLabel);
        container.add(datumVoznjeField);
        container.add(adresaPolaskaLabel);
        container.add(adresaPolaskaField);
        container.add(adresaDolaskaLabel);
        container.add(adresaDolaskaField);
        container.add(idMusterijeLabel);
        container.add(idMusterijeField);
        container.add(idVozacaLabel);
        container.add(idVozacaField);
        container.add(predjenoKmLabel);
        container.add(predjenoKmField);
        container.add(trajanjeVoznjeLabel);
        container.add(trajanjeVoznjeField);
        container.add(statusVoznjeLabel);
        container.add(statusVoznjeCb);
        container.add(idVoznjeLabel);
        container.add(idVoznjeField);
        container.add(ocenaLabel);
        container.add(ocenaField);
    }

    public void addActionEvent() {
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            if (provera()) {
                String datumVoznje = this.datumVoznjeField.getText().trim();
                String adresaPolaska = this.adresaPolaskaField.getText().trim();
                String adresaDolaska = this.adresaPolaskaField.getText().trim();
                String idMusterije = this.idMusterijeField.getText().trim();
                String idVozaca = this.idVozacaField.getText().trim();
                double predjenoKm = Double.parseDouble(this.predjenoKmField.getText().trim());
                int trajanjeVoznje = Integer.parseInt(this.trajanjeVoznjeField.getText().trim());
                StatusVoznje statusVoznje = (StatusVoznje) this.statusVoznjeCb.getSelectedItem();
                String idVoznje = this.idVoznjeField.getText().trim();
                int ocena = Integer.parseInt(this.ocenaField.getText().trim());

                for(Voznja voznja : VoznjaIO.getVoznje()) {
                    if(voznja.getIdVoznje().equals(idVoznje)) {
                        voznja.setDatumPorudzbine(datumVoznje);
                        voznja.setAdresaPolaska(adresaPolaska);
                        voznja.setAdresaDestinacije(adresaDolaska);
                        voznja.setIdMusterije(idMusterije);
                        voznja.setIdVozaca(idVozaca);
                        voznja.setPredjenoKm(predjenoKm);
                        voznja.setTrajanjeVoznje(trajanjeVoznje);
                        voznja.setStatusVoznje(statusVoznje);
                        voznja.setIdVoznje(idVoznje);
                        voznja.setOcenaVoznje(ocena);
                        voznja.setObrisan(false);
                    }
                }
                ArrayList<Voznja> sve = VoznjaIO.getVoznje();
                VoznjaIO.voznjaUpis(sve);
                this.dispose();
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Uspena izmena podataka", "STATIM", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (e.getSource() == cancelButton) {
            this.dispose();
            this.setVisible(false);
        }
    }
}
