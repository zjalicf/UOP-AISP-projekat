package GUI.Dispecer;

import entiteti.Korisnik;
import fileIO.KorisnikIO;
import utility.Svasta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaKorisnikaFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JButton btnDodaj = new JButton("Dodaj novog korisnika");
    private JButton btnIzmeni = new JButton("Izmeni korisnika");
    private JButton btnIzbrisi = new JButton("Obrisi korisnika");
    private JTable tabela;
    private DefaultTableModel tabelaModel;
    JPanel panel = new JPanel();

    public ListaKorisnikaFrame(int tip) {
        setLayoutManager();
        initGUI(tip);
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        btnIzbrisi.setBounds(15,250,111,30);
        btnDodaj.setBounds(15,300,111,30);
        btnIzmeni.setBounds(15,350,111,30);
        panel.setBounds(0,0,1000,1000);
        tabela.setBounds(0,0,1000,1000);
    }

    public void addComponentsToContainer() {
        container.add(btnDodaj);
        container.add(btnIzbrisi);
        container.add(btnIzmeni);
        container.add(panel);
    }

    public void addActionEvent() {
        btnIzmeni.addActionListener(this);
        btnIzbrisi.addActionListener(this);
    }

    public void initGUI(int tip) {
        String[] title = new String[] {"ID" ,"Ime", "Prezime", "Pol", "Adresa", "Broj telefona"};
        if (tip == 0) {
            Object[][] sadrzaj = new Object[Svasta.getVozaci().size()][title.length];

            for(int i = 0; i < Svasta.getVozaci().size(); i++) {
                Korisnik korisnik = Svasta.getVozaci().get(i);
                sadrzaj[i][0] = korisnik.getIdKorisnika();
                sadrzaj[i][1] = korisnik.getIme();
                sadrzaj[i][2] = korisnik.getPrezime();
                sadrzaj[i][3] = korisnik.getPol();
                sadrzaj[i][4] = korisnik.getAdresa();
                sadrzaj[i][5] = korisnik.getBrojTelefona();
            }
            createTable(title, sadrzaj);

        } else if (tip == 1) {
            Object[][] sadrzaj = new Object[Svasta.getDispeceri().size()][title.length];

            for(int i = 0; i < Svasta.getDispeceri().size(); i++) {
                Korisnik korisnik = Svasta.getDispeceri().get(i);
                sadrzaj[i][0] = korisnik.getIdKorisnika();
                sadrzaj[i][1] = korisnik.getIme();
                sadrzaj[i][2] = korisnik.getPrezime();
                sadrzaj[i][3] = korisnik.getPol();
                sadrzaj[i][4] = korisnik.getAdresa();
                sadrzaj[i][5] = korisnik.getBrojTelefona();
            }
            createTable(title, sadrzaj);
        }
    }

    private void createTable(String[] title, Object[][] sadrzaj) {
        tabelaModel = new DefaultTableModel(sadrzaj, title);
        tabela = new JTable(tabelaModel);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setSize(1000,1000);
        tabela.setSize(1000,1000);
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getTableHeader().setReorderingAllowed(false);
        panel.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIzbrisi) {
            int red = tabela.getSelectedRow();
            if(red == -1) {
                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
            }else {
                String korisnikId = tabela.getValueAt(red, 0).toString();
                ArrayList<Korisnik> korisnici = Svasta.getKorisnici();
                int izbor = JOptionPane.showConfirmDialog(null,
                        "Da li ste sigurni da zelite da obrisete servisera?",
                        " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
                if(izbor == JOptionPane.YES_OPTION) {
                    for (Korisnik korisnik: korisnici) {
                        if (korisnik.getIdKorisnika() == Integer.parseInt(korisnikId)) {
                            korisnik.setObrisan(true);
                            KorisnikIO.korisnikUpis(korisnici);
                        }
                    }
                    DefaultTableModel dtm = (DefaultTableModel)tabela.getModel();
                    dtm.removeRow(red);
                }
            }
        } else if (e.getSource() == btnIzmeni) {
//            int red = tabela.getSelectedRow();
//            if(red == -1) {
//                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
//            }else {
//                String korisnikId = tabela.getValueAt(red, 0).toString();
//                ArrayList<Korisnik> korisnici = Svasta.getKorisnici();
//
//
//            }
        }
    }
}

