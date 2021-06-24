package GUI.Dispecer;

import entiteti.Vozac;
import enums.Pol;
import fileIO.KorisnikIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IzmeniVozacaFrame extends JFrame implements ActionListener {
    private final String korisnikId;
    Container container = getContentPane();
    private final JButton confirmButton = new JButton("Potvrdi");
    private final JButton cancelButton = new JButton("Odustani");
    private final JLabel idLabel = new JLabel("ID: ");
    private final JTextField idField = new JTextField(20);
    private final JLabel imeLabel = new JLabel("Ime: ");
    private final JTextField imeField = new JTextField(20);
    private final JLabel prezimeLabel = new JLabel("Prezime: ");
    private final JTextField prezimeField = new JTextField(20);
    private final JLabel polLabel = new JLabel("Pol: ");
    private final JComboBox<Pol> polCb = new JComboBox(Pol.values());
    private final JLabel adresaLabel = new JLabel("Adresa: ");
    private final JTextField adresaField = new JTextField(20);
    private final JLabel brojTelefonaLabel = new JLabel("Broj telefona: ");
    private final JTextField brojTelefonaField = new JTextField(20);
    private final JLabel jmbgLabel = new JLabel("JMBG: ");
    private final JTextField jmbgField = new JTextField(20);
    private final JLabel usernameLabel = new JLabel("Korisnicko ime: ");
    private final JTextField usernameField = new JTextField(20);
    private final JLabel passwordLabel = new JLabel("Sifra");
    private final JTextField passwordField = new JTextField(20);
    private final JLabel plataLabel = new JLabel("Plata: ");
    private final JTextField plataField = new JTextField(20);
    private final JLabel brKarteLabel = new JLabel("Broj karte: ");
    private final JTextField brKarteField = new JTextField(20);
    private final JLabel idAutomobilaLabel = new JLabel("ID automobila: ");
//    private final JComboBox<String> idAutomobilaCb = new JComboBox<>(AutomobilIO.getIdSvihAutomobila().toArray(new String[AutomobilIO.getIdSvihAutomobila().size()]));

    public IzmeniVozacaFrame(String korisnikId) {
        this.korisnikId = korisnikId;
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
        for (Vozac vozac: KorisnikIO.getVozaci()) {
            if (korisnikId.equals(vozac.getIdKorisnika())) {
                idField.setText(vozac.getIdKorisnika());
                idField.setEditable(false);
                imeField.setText(vozac.getIme());
                prezimeField.setText(vozac.getPrezime());
                polCb.setSelectedItem(vozac.getPol());
                adresaField.setText(vozac.getAdresa());
                brojTelefonaField.setText(vozac.getBrojTelefona());
                jmbgField.setText(vozac.getJmbg());
                usernameField.setText(vozac.getUsername());
                passwordField.setText(vozac.getPassword());
                plataField.setText(String.valueOf(vozac.getPlata()));
                brKarteField.setText(String.valueOf(vozac.getBrKarte()));
//                idAutomobilaCb.setSelectedItem(vozac.getIdAutomobila());
//                for (Voznja voznja: VoznjaIO.getVoznje()) {
//                    if (voznja.getIdVozaca().equals(this.korisnikId) && voznja.getStatusVoznje().equals(StatusVoznje.PRIHVACENA)) {
//                        idAutomobilaCb.setEnabled(false);
//                    }
//                }
            }
        }
    }

    public void setLocationAndSize() {
        idLabel.setBounds(5,5,100,20);
        imeLabel.setBounds(5,30,100,20);
        prezimeLabel.setBounds(5,55,100,20);
        polLabel.setBounds(5,80,100,20);
        adresaLabel.setBounds(5,105,100,20);
        brojTelefonaLabel.setBounds(5,130,100,20);
        jmbgLabel.setBounds(5,155,100,20);
        usernameLabel.setBounds(5,180,100,20);
        passwordLabel.setBounds(5,205,100,20);
        plataLabel.setBounds(5,230,100,20);
        brKarteLabel.setBounds(5,255,100,20);
        idAutomobilaLabel.setBounds(5,280,100,20);

        idField.setBounds(110,5,100,20);
        imeField.setBounds(110,30,100,20);
        prezimeField.setBounds(110,55,100,20);
        polCb.setBounds(110,80,100,20);
        adresaField.setBounds(110,105,100,20);
        brojTelefonaField.setBounds(110,130,100,20);
        jmbgField.setBounds(110,155,100,20);
        usernameField.setBounds(110,180,100,20);
        passwordField.setBounds(110,205,100,20);
        plataField.setBounds(110,230,100,20);
        brKarteField.setBounds(110,255,100,20);
//        idAutomobilaCb.setBounds(110,280,100,20);

        confirmButton.setBounds(5,310,100,24);
        cancelButton.setBounds(110,310,100,24);
    }

    public void addComponentsToContainer() {
        container.add(confirmButton);
        container.add(cancelButton);
        container.add(idLabel);
        container.add(idField);
        container.add(imeLabel);
        container.add(imeField);
        container.add(prezimeLabel);
        container.add(prezimeField);
        container.add(polLabel);
        container.add(polCb);
        container.add(adresaLabel);
        container.add(adresaField);
        container.add(brojTelefonaLabel);
        container.add(brojTelefonaField);
        container.add(jmbgLabel);
        container.add(jmbgField);
        container.add(usernameLabel);
        container.add(usernameField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(plataLabel);
        container.add(plataField);
        container.add(brKarteLabel);
        container.add(brKarteField);
        container.add(idAutomobilaLabel);
//        container.add(idAutomobilaCb);
    }

    public void addActionEvent() {
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    public boolean provera() {
        boolean correct = true;
        String output = "Greske:\n";

        if (this.imeField.getText().trim().equals("")) {
            output = output + "Unesite ime\n";
            correct = false;
        }

        if (this.imeField.getText().trim().matches(".*\\d.*")) {
            output = output + "Ime ne sme da sadrzi brojeve\n";
            correct = false;
        }

        if (this.prezimeField.getText().trim().equals("")) {
            output = output + "Unesite prezime\n";
            correct = false;
        }

        if (this.prezimeField.getText().trim().matches(".*\\d.*")) {
            output = output + "Prezime ne sme da sadrzi brojeve\n";
            correct = false;
        }

        if (this.adresaField.getText().trim().equals("")) {
            output = output + "Unesite adresu\n";
            correct = false;
        }

        if (this.brojTelefonaField.getText().trim().equals("")) {
            output = output + "Unesite broj telefona\n";
            correct = false;
        }

        if (this.brojTelefonaField.getText().trim().matches(".*[a-zA-Z]+.*")) {
            output = output + "Broj telefona ne sme da sadrzi slova\n";
            correct = false;
        }

        if (this.jmbgField.getText().trim().equals("")) {
            output = output + "Unesite jmbg\n";
            correct = false;
        }
        if (this.jmbgField.getText().trim().matches(".*[a-zA-Z]+.*") || this.jmbgField.getText().trim().length() != 13) {
            output = output + "JMBG mora imati 13 cifara i ne sme da sadrzi slova\n";
            correct = false;
        }

        if (this.usernameField.getText().trim().equals("")) {
            output = output + "Unesite korisnicko ime\n";
            correct = false;
        }

        if (this.passwordField.getText().trim().equals("")) {
            output = output + "Unesite sifru\n";
            correct = false;
        }

        if (this.plataField.getText().trim().equals("")) {
            output = output + "Unesite platu\n";
            correct = false;
        }

        try {
            Double.parseDouble(this.plataField.getText().trim());
        } catch (NumberFormatException exception) {
            output = output + "Plata mora imati jednu decimalu!\n";
            correct = false;
        }

        if (this.brKarteField.getText().trim().equals("")) {
            output = output + "Unesite broj karte\n";
            correct = false;
        }

        if (this.brKarteField.getText().trim().matches(".*[a-zA-Z]+.*") && this.brKarteField.getText().trim().length() != 4) {
            output = output + "Broj karte mora imati 4 cifre i ne sme da sadrzi slova\n";
            correct = false;
        }

        try {
            Integer.parseInt(this.brKarteField.getText().trim());
        } catch (NumberFormatException exception) {
            output = output + "Broj karte mora biti ceo broj\n";
            correct = false;
        }
        if (!correct) {
            JOptionPane.showMessageDialog(null, output, "STATIM", JOptionPane.WARNING_MESSAGE);
        }
        return correct;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            if (provera()) {
                String id = this.idField.getText().trim();
                String ime = this.imeField.getText().trim();
                String prezime = this.prezimeField.getText().trim();
                Pol pol = (Pol) this.polCb.getSelectedItem();
                String adresa = this.adresaField.getText().trim();
                String telefon = this.brojTelefonaField.getText().trim();
                String jmbg = this.jmbgField.getText().trim();
                String username = this.usernameField.getText().trim();
                String password = this.passwordField.getText().trim();
                double plata = Double.parseDouble(this.plataField.getText().trim());
                int brKarte = Integer.parseInt(this.brKarteField.getText().trim());
//                String idAutomobila = (String) this.idAutomobilaCb.getSelectedItem();

                for(Vozac vozac : KorisnikIO.getVozaci()) {
                    if(vozac.getIdKorisnika().equals(id)) {
                        vozac.setIme(ime);
                        vozac.setPrezime(prezime);
                        vozac.setPol(pol);
                        vozac.setAdresa(adresa);
                        vozac.setBrojTelefona(telefon);
                        vozac.setJmbg(jmbg);
                        vozac.setUsername(username);
                        vozac.setPassword(password);
                        vozac.setObrisan(false);
                        vozac.setPlata(plata);
                        vozac.setBrKarte(brKarte);
//                        vozac.setIdAutomobila(idAutomobila);
                    }
                }
                KorisnikIO.korisnikUpis(KorisnikIO.getKorisnici());
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

