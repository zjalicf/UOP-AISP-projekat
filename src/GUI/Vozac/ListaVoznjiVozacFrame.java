package GUI.Vozac;

import GUI.FrameLauncher;
import entiteti.Korisnik;
import entiteti.Voznja;
import enums.StatusVoznje;
import fileIO.VoznjaIO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.BorderFactory.createEmptyBorder;

public class ListaVoznjiVozacFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private final JButton prihvatiButton = new JButton("Prihvati");
    private final JButton odbijButton = new JButton("Odbij");
    private final JButton zavrsiButton = new JButton("Zavrsi");
    private final JButton nazad = new JButton("Nazad");
    private JTable tabela;
    private DefaultTableModel tabelaModel;

    public ListaVoznjiVozacFrame(Korisnik ulogovani) {
        setLayoutManager();
        initGUI(ulogovani);
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        prihvatiButton.setBounds(10,110,100,24);
        odbijButton.setBounds(120, 110, 100, 24);
        zavrsiButton.setBounds(230, 110, 100, 24);
        nazad.setBounds(340,110,100,24);
    }

    public void addComponentsToContainer() {
        container.add(prihvatiButton);
        container.add(odbijButton);
        container.add(zavrsiButton);
        container.add(nazad);
    }

    public void addActionEvent() {
        prihvatiButton.addActionListener(this);
        odbijButton.addActionListener(this);
        zavrsiButton.addActionListener(this);
        nazad.addActionListener(this);
    }

    public void initGUI(Korisnik ulogovani) {
        String[] title = new String[] {"Datum" ,"Polazak", "Destinacija", "km", "Trajanje", "Status", "ID Voznje", "Ocena"};
        int brojVoznji = 0;
        for (Voznja voznja: VoznjaIO.getVoznje()) {
            if (voznja.getIdVozaca().equals(ulogovani.getIdKorisnika())) {
                brojVoznji++;
            }
        }
        int brojac = 0;
        Object[][] sadrzajFilter = new Object[brojVoznji][title.length];
        for(int i = 0; i < VoznjaIO.getVoznje().size(); i++) {
            Voznja voznja = VoznjaIO.getVoznje().get(i);

            if (ulogovani.getIdKorisnika().equals(voznja.getIdVozaca())) {
                sadrzajFilter[brojac][0] = voznja.getDatumPorudzbine();
                sadrzajFilter[brojac][1] = voznja.getAdresaPolaska();
                sadrzajFilter[brojac][2] = voznja.getAdresaDestinacije();
                sadrzajFilter[brojac][3] = voznja.getPredjenoKm();
                sadrzajFilter[brojac][4] = voznja.getTrajanjeVoznje();
                sadrzajFilter[brojac][5] = voznja.getStatusVoznje();
                sadrzajFilter[brojac][6] = voznja.getIdVoznje();
                sadrzajFilter[brojac][7] = voznja.getOcenaVoznje();
                brojac++;
            }
        }
        createTable(title, sadrzajFilter);
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
        scrollPane.setBounds(0,0,1200,100);
        container.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int red = tabela.getSelectedRow();
        if (e.getSource() == prihvatiButton) {
            if(red == -1) {
                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli", "STATIM", JOptionPane.WARNING_MESSAGE);
            }else {
                String voznjaId = tabela.getValueAt(red, 6).toString();
                ArrayList<Voznja> voznje = VoznjaIO.getVoznje();
                int izbor = JOptionPane.showConfirmDialog(null,
                        "Da li ste sigurni da zelite da prihvatite voznju?",
                        "STATIM", JOptionPane.YES_NO_OPTION);
                if(izbor == JOptionPane.YES_OPTION) {
                    for (Voznja voznja: voznje) {
                        if (voznja.getIdVoznje().equals(voznjaId)) {
                            voznja.setStatusVoznje(StatusVoznje.PRIHVACENA);
                            VoznjaIO.voznjaUpis(voznje);
                        }
                    }
                }
            }
        } else if (e.getSource() == odbijButton) {
            if(red == -1) {
                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
            }else {
                String voznjaId = tabela.getValueAt(red, 6).toString();
                ArrayList<Voznja> voznje = VoznjaIO.getVoznje();
                int izbor = JOptionPane.showConfirmDialog(null,
                        "Da li sigurno zelite da odbijete voznju?",
                        "STATIM", JOptionPane.YES_NO_OPTION);
                if(izbor == JOptionPane.YES_OPTION) {
                    for (Voznja voznja: voznje) {
                        if (voznja.getIdVoznje().equals(voznjaId)) {
                            voznja.setStatusVoznje(StatusVoznje.ODBIJENA);
                            VoznjaIO.voznjaUpis(voznje);
                        }
                    }
                }
            }
        } else if (e.getSource() == zavrsiButton) {
            if(red == -1) {
                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
            } else if (tabela.getValueAt(red, 5).toString().equals(String.valueOf(StatusVoznje.PRIHVACENA))){
                String voznjaId = tabela.getValueAt(red, 6).toString();
                int izbor = JOptionPane.showConfirmDialog(null,
                        "Da li sigurno zelite da zavrsite voznju?",
                        "STATIM", JOptionPane.YES_NO_OPTION);
                if(izbor == JOptionPane.YES_OPTION) {
                    FrameLauncher.launchZavrsiVoznjuFrame(voznjaId);
                }
            } else if (tabela.getValueAt(red, 5).toString().equals(String.valueOf(StatusVoznje.ZAVRSENA))){
                JOptionPane.showMessageDialog(null, "Vec ste zavrsili ovu voznju", "STATIM",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Voznja se moze zavrsiti samo ako je prethodno PRIHVACENA", "STATIM",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        else if (e.getSource() == nazad) {
            this.dispose();
            this.setVisible(false);
        }
    }
}
