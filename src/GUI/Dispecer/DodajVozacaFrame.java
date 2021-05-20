package GUI.Dispecer;

        import entiteti.Korisnik;
        import entiteti.Vozac;
        import enums.Pol;
        import fileIO.KorisnikIO;
        import utility.Svasta;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.ArrayList;

public class DodajVozacaFrame extends JFrame implements ActionListener {

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
    private final JTextField idAutomobilaField = new JTextField(20);

    public DodajVozacaFrame () {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
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
        idAutomobilaField.setBounds(110,280,100,20);

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
        container.add(idAutomobilaField);
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
            int brKarte = Integer.parseInt(this.brKarteField.getText().trim());
            int idAutomobila = Integer.parseInt(this.idAutomobilaField.getText().trim());
            String lokacija = "ChIJgwwOOUcQW0cRfFlEgooF9fQ";
            if (Svasta.getIdSvihKorisnika().contains(id)) {
                JOptionPane.showMessageDialog(null, "Korisnik sa tim ID vec postoji!", "Greska pri pravljenju korisnika", 2);
            } else {
                Vozac novi = new Vozac(id, ime, prezime, pol, adresa, telefon, jmbg, username, password, false, plata, brKarte, idAutomobila,
                        lokacija);
                ArrayList<Korisnik> sviKorisnici = KorisnikIO.korisnikCitanje();
                sviKorisnici.add(novi);
                KorisnikIO.korisnikUpis(sviKorisnici);
                this.dispose();
                this.setVisible(false);
            }
        } else if (e.getSource() == cancelButton) {
            this.dispose();
            this.setVisible(false);
        }
    }
}
/*
private boolean validacija(Dispecer dispecer) {
        boolean correct = true;
        String output = "Nastale greske pri unosu:\n";
        if (this.idField.getText().trim().equals("")) {
            output = output + ", Unesite id\n";
            correct = false;
        }

        if (this.imeField.getText().trim().equals("")) {
            output = output + ", Unesite ime\n";
            correct = false;
        }

        if (this.prezimeField.getText().trim().equals("")) {
            output = output + ", Unesite prezime\n";
            correct = false;
        }

        if (this.adresaField.getText().trim().equals("")) {
            output = output + ", Unesite adresu\n";
            correct = false;
        }

        if (this.brojTelefonaField.getText().trim().equals("")) {
            output = output + ", Unesite broj telefona\n";
            correct = false;
        }

        if (this.jmbgField.getText().trim().equals("")) {
            output = output + ", Unesite jmbg\n";
            correct = false;
        }

        if (this.usernameField.getText().trim().equals("")) {
            output = output + ", Unesite korisnicko ime\n";
            correct = false;
        }

        if (this.passwordField.getText().trim().equals("")) {
            output = output + ", Unesite lozinku\n";
            correct = false;
        }

        if (this.plataField.getText().trim().equals("")) {
            output = output + ", Unesite platu\n";
            correct = false;
        }

        try {
            Double.parseDouble(this.plataField.getText().trim());
        } catch (NumberFormatException exception) {
            output = output + ", Plata mora imati jednu decimalu!\n";
            correct = false;
        }

        if (this.brTelefonskeLinijeField.getText().trim().equals("")) {
            output = output + ", Unesite platu\n";
            correct = false;
        }

        try {
            Integer.parseInt(this.plataField.getText().trim());
        } catch (NumberFormatException exception) {
            output = output + ", Broj telefonske linije je mora da bude celobrojna vrednost!\n";
            correct = false;
        }

        if (!correct) {
            JOptionPane.showMessageDialog(null, output, "Pogresno uneti podaci", JOptionPane.WARNING_MESSAGE);
        }
        return correct;
    }
 */
