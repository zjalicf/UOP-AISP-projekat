package GUI.Dispecer;

import GUI.FrameLauncher;
import entiteti.Dispecer;
import entiteti.Korisnik;
import entiteti.Vozac;
import fileIO.KorisnikIO;
import utility.Svasta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.BorderFactory.createEmptyBorder;

public class ListaKorisnikaFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JButton btnDodaj = new JButton("Dodaj novog korisnika");
    private JButton btnIzmeni = new JButton("Izmeni korisnika");
    private JButton btnIzbrisi = new JButton("Obrisi korisnika");
    private JTable tabela;
    private DefaultTableModel tabelaModel;

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
        btnIzbrisi.setBounds(15,110,150,24);
        btnDodaj.setBounds(200,110,150,24);
        btnIzmeni.setBounds(370,110,150,24);
    }

    public void addComponentsToContainer() {
        container.add(btnDodaj);
        container.add(btnIzbrisi);
        container.add(btnIzmeni);
    }

    public void addActionEvent() {
        btnIzmeni.addActionListener(this);
        btnDodaj.addActionListener(this);
        btnIzbrisi.addActionListener(this);
    }

    public void initGUI(int tip) {
        if (tip == 0) {
            String[] title = new String[] {"ID" ,"Ime", "Prezime", "Pol", "Adresa", "Broj telefona", "Kor ime", "Plata", "Broj karte", "ID Automobila"};
            Object[][] sadrzaj = new Object[Svasta.getVozaci().size()][title.length];

            for(int i = 0; i < Svasta.getVozaci().size(); i++) {
                Vozac vozac = Svasta.getVozaci().get(i);
                sadrzaj[i][0] = vozac.getIdKorisnika();
                sadrzaj[i][1] = vozac.getIme();
                sadrzaj[i][2] = vozac.getPrezime();
                sadrzaj[i][3] = vozac.getPol();
                sadrzaj[i][4] = vozac.getAdresa();
                sadrzaj[i][5] = vozac.getBrojTelefona();
                sadrzaj[i][6] = vozac.getUsername();
                sadrzaj[i][7] = vozac.getPlata();
                sadrzaj[i][8] = vozac.getBrKarte();
                sadrzaj[i][9] = vozac.getIdAutomobila();
            }
            createTable(title, sadrzaj);

        } else if (tip == 1) {
            String[] title = new String[] {"ID" ,"Ime", "Prezime", "Pol", "Adresa", "Broj telefona", "Kor ime", "Plata", "Odeljenje", "Broj linije"};
            Object[][] sadrzaj = new Object[Svasta.getDispeceri().size()][title.length];

            for(int i = 0; i < Svasta.getDispeceri().size(); i++) {
                Dispecer dispecer = Svasta.getDispeceri().get(i);
                sadrzaj[i][0] = dispecer.getIdKorisnika();
                sadrzaj[i][1] = dispecer.getIme();
                sadrzaj[i][2] = dispecer.getPrezime();
                sadrzaj[i][3] = dispecer.getPol();
                sadrzaj[i][4] = dispecer.getAdresa();
                sadrzaj[i][5] = dispecer.getBrojTelefona();
                sadrzaj[i][6] = dispecer.getUsername();
                sadrzaj[i][7] = dispecer.getPlata();
                sadrzaj[i][8] = dispecer.getOdeljenje();
                sadrzaj[i][9] = dispecer.getBrTelefonskeLinije();
            }
            createTable(title, sadrzaj);
        }
    }

    private void createTable(String[] title, Object[][] sadrzaj) {
        tabelaModel = new DefaultTableModel(sadrzaj, title);
        tabela = new JTable(tabelaModel);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBorder(createEmptyBorder());
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getTableHeader().setReorderingAllowed(false);
        scrollPane.setBounds(0,0,1100,100);
        container.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int red = tabela.getSelectedRow();
        if (e.getSource() == btnIzbrisi) {
            if(red == -1) {
                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
            }else {
                String korisnikId = tabela.getValueAt(red, 0).toString();
                ArrayList<Korisnik> korisnici = Svasta.getKorisnici();
                int izbor = JOptionPane.showConfirmDialog(null,
                        "Da li ste sigurni da zelite da obrisete korisnika?",
                        " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
                if(izbor == JOptionPane.YES_OPTION) {
                    for (Korisnik korisnik: korisnici) {
                        if (korisnik.getIdKorisnika().equals(korisnikId)) {
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
        } else if (e.getSource() == btnDodaj) {
            FrameLauncher.launchDodajKorisnikaFrame();
//            DefaultTableModel dtm = (DefaultTableModel)tabela.getModel();
//            dtm.addRow();
        }
    }
}

