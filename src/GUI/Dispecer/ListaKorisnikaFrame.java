package GUI.Dispecer;

import GUI.FrameLauncher;
import entiteti.Dispecer;
import entiteti.Korisnik;
import entiteti.Vozac;
import fileIO.KorisnikIO;
import strukture.Lista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BorderFactory.createEmptyBorder;

public class ListaKorisnikaFrame extends JFrame implements ActionListener {
    private int tip;
    Container container = getContentPane();
    private final JButton dodajButton = new JButton("Dodaj korisnika");
    private final JButton izmeniButton = new JButton("Izmeni korisnika");
    private final JButton izbrisiButton = new JButton("Obrisi korisnika");
    private final JButton pretraziButton = new JButton("Pretrazi");
    private final JButton nazadButton = new JButton("Nazad");
    private JTable tabela;
    private DefaultTableModel tabelaModel;

    public ListaKorisnikaFrame(int tip) {
        this.tip = tip;
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
        izbrisiButton.setBounds(10,110,130,24);
        dodajButton.setBounds(150,110,130,24);
        izmeniButton.setBounds(290,110,130,24);
        pretraziButton.setBounds(430,110,130,24);
        nazadButton.setBounds(570,110,130,24);
    }

    public void addComponentsToContainer() {
        container.add(dodajButton);
        container.add(izbrisiButton);
        container.add(izmeniButton);
        container.add(nazadButton);
        container.add(pretraziButton);
    }

    public void addActionEvent() {
        izmeniButton.addActionListener(this);
        dodajButton.addActionListener(this);
        izbrisiButton.addActionListener(this);
        nazadButton.addActionListener(this);
        pretraziButton.addActionListener(this);
    }

    public void initGUI(int tip) {
        if (tip == 0) {
            String[] title = new String[] {"ID" ,"Ime", "Prezime", "Pol", "Adresa", "Broj telefona", "Kor ime", "Plata", "Broj karte", "ID Automobila"};
            Object[][] sadrzaj = new Object[KorisnikIO.getVozaci().getSize()][title.length];
            for(int i = 0; i < KorisnikIO.getVozaci().getSize(); i++) {
                Vozac vozac = KorisnikIO.getVozaci().getElement(i);
                if (!vozac.isObrisan()) {
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
            }
            createTable(title, sadrzaj);

        } else if (tip == 1) {
            String[] title = new String[] {"ID" ,"Ime", "Prezime", "Pol", "Adresa", "Broj telefona", "Kor ime", "Plata", "Odeljenje", "Broj linije"};
            Object[][] sadrzaj = new Object[KorisnikIO.getDispeceri().getSize()][title.length];
            for(int i = 0; i < KorisnikIO.getDispeceri().getSize(); i++) {
                Dispecer dispecer = KorisnikIO.getDispeceri().getElement(i);
                if (!dispecer.isObrisan()) {
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
        tabela.setAutoCreateRowSorter(true);
        scrollPane.setBounds(0,0,1100,100);
        container.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int red = tabela.getSelectedRow();
        if (e.getSource() == izbrisiButton) {
            if(red == -1) {
                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli", "STATIM", JOptionPane.WARNING_MESSAGE);
            } else {
                String korisnikId = tabela.getValueAt(red, 0).toString();
                Lista<Korisnik> korisnici = KorisnikIO.getKorisnici();
                int izbor = JOptionPane.showConfirmDialog(null,
                        "Da li sigurno zelite da obrisete korisnika?",
                        "STATIM", JOptionPane.YES_NO_OPTION);
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
        } else if (e.getSource() == izmeniButton) {
            if(red == -1) {
                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli", "STATIM", JOptionPane.WARNING_MESSAGE);
            } else {
                String korisnikId = tabela.getValueAt(red, 0).toString();
                for (Korisnik korisnik: KorisnikIO.getKorisnici()) {
                    if (korisnikId.equals(korisnik.getIdKorisnika()) && korisnik instanceof Dispecer) {
                        FrameLauncher.launchIzmeniDispeceraFrame(korisnikId);
                    } else if (korisnikId.equals(korisnik.getIdKorisnika()) && korisnik instanceof Vozac) {
                        FrameLauncher.launchIzmeniVozacaFrame(korisnikId);
                    }
                }
            }
        } else if (e.getSource() == pretraziButton) {
            FrameLauncher.launchPretraziVoznjeFrame(tabela);
        } else if (e.getSource() == dodajButton) {
            FrameLauncher.launchDodajKorisnikaFrame(tip);
        } else if (e.getSource() == nazadButton) {
            this.dispose();
            this.setVisible(false);
        }
    }
}

