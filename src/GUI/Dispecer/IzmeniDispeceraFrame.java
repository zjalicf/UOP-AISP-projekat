package GUI.Dispecer;

import entiteti.Dispecer;
import enums.Odeljenje;
import enums.Pol;
import fileIO.KorisnikIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IzmeniDispeceraFrame extends JFrame implements ActionListener {
    private String korisnikId;
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
    private final JLabel odeljenjeLabel = new JLabel("Odeljenje: ");
    private final JTextField odeljenjeField = new JTextField(20);
    private final JLabel brTelefonskeLinijeLabel = new JLabel("Broj linije: ");
    private final JTextField brTelefonskeLinijeField = new JTextField(20);

    public IzmeniDispeceraFrame(String korisnikId) {
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
        for (Dispecer dispecer: KorisnikIO.getDispeceri()) {
            if (korisnikId.equals(dispecer.getIdKorisnika())) {
                idField.setText(dispecer.getIdKorisnika());
                idField.setEditable(false);
                imeField.setText(dispecer.getIme());
                prezimeField.setText(dispecer.getPrezime());
                polCb.setSelectedItem(dispecer.getPol());
                adresaField.setText(dispecer.getAdresa());
                brojTelefonaField.setText(dispecer.getBrojTelefona());
                jmbgField.setText(dispecer.getJmbg());
                usernameField.setText(dispecer.getUsername());
                passwordField.setText(dispecer.getPassword());
                plataField.setText(String.valueOf(dispecer.getPlata()));
                odeljenjeField.setText(String.valueOf(dispecer.getOdeljenje()));
                brTelefonskeLinijeField.setText(String.valueOf(dispecer.getBrTelefonskeLinije()));
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
        odeljenjeLabel.setBounds(5,255,100,20);
        brTelefonskeLinijeLabel.setBounds(5,280,100,20);

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
        odeljenjeField.setBounds(110,255,100,20);
        brTelefonskeLinijeField.setBounds(110,280,100,20);

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
        container.add(odeljenjeLabel);
        container.add(odeljenjeField);
        container.add(brTelefonskeLinijeLabel);
        container.add(brTelefonskeLinijeField);
    }

    public void addActionEvent() {
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
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
            Odeljenje odeljenje = Odeljenje.valueOf(this.odeljenjeField.getText().trim());
            int brTelefonskeLinije = Integer.parseInt(brTelefonskeLinijeField.getText().trim());

            for(Dispecer dispecer : KorisnikIO.getDispeceri()) {
                if(dispecer.getIdKorisnika().equals(id)) {
                    dispecer.setIme(ime);
                    dispecer.setPrezime(prezime);
                    dispecer.setPol(pol);
                    dispecer.setAdresa(adresa);
                    dispecer.setBrojTelefona(telefon);
                    dispecer.setJmbg(jmbg);
                    dispecer.setUsername(username);
                    dispecer.setPassword(password);
                    dispecer.setObrisan(false);
                    dispecer.setPlata(plata);
                    dispecer.setOdeljenje(odeljenje);
                    dispecer.setBrTelefonskeLinije(brTelefonskeLinije);
                }
            }
            fileIO.KorisnikIO.korisnikUpis(KorisnikIO.getKorisnici());
            this.dispose();
            this.setVisible(false);

        } else if (e.getSource() == cancelButton) {
            this.dispose();
            this.setVisible(false);
        }
    }
}
