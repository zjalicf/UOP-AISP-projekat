package GUI.Dispecer;

import entiteti.Vozac;
import entiteti.Voznja;
import enums.StatusVoznje;
import fileIO.VoznjaIO;
import org.json.JSONException;
import utility.DriverHandler;
import fileIO.KorisnikIO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.BorderFactory.createEmptyBorder;

public class ListaVoznjiDispecerFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JButton izmeniButton = new JButton("Izmeni voznju");
    private JButton izbrisiButton = new JButton("Obrisi voznju");
    private JButton dodeliButton = new JButton("Dodeli vozaca");
    private JButton nazadButton = new JButton("Nazad");
    private JTable tabela;
    private DefaultTableModel tabelaModel;

    public ListaVoznjiDispecerFrame() {
        setLayoutManager();
        initGUI();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        izbrisiButton.setBounds(15,110,150,24);
        izmeniButton.setBounds(200,110,150,24);
        dodeliButton.setBounds(200,140,150,24);
        nazadButton.setBounds(200,180,110,24);
    }

    public void addComponentsToContainer() {
        container.add(izbrisiButton);
        container.add(izmeniButton);
        container.add(nazadButton);
        container.add(dodeliButton);
    }

    public void addActionEvent() {
        izmeniButton.addActionListener(this);
        izbrisiButton.addActionListener(this);
        dodeliButton.addActionListener(this);
        nazadButton.addActionListener(this);
    }
    
    public void initGUI() {
        String[] title = new String[] {"Datum" ,"Polazak", "Destinacija", "ID Musterije", "ID Vozaca", "km", "Trajanje", "Status", "ID Voznje",
                "Ocena"};
        Object[][] sadrzaj = new Object[VoznjaIO.getVoznje().size()][title.length];

        for(int i = 0; i < VoznjaIO.getVoznje().size(); i++) {
            Voznja voznja = VoznjaIO.getVoznje().get(i);
            sadrzaj[i][0] = voznja.getDatumPorudzbine();
            sadrzaj[i][1] = voznja.getAdresaPolaska();
            sadrzaj[i][2] = voznja.getAdresaDestinacije();
            sadrzaj[i][3] = voznja.getIdMusterije();
            sadrzaj[i][4] = voznja.getIdVozaca();
            sadrzaj[i][5] = voznja.getPredjenoKm();
            sadrzaj[i][6] = voznja.getTrajanjeVoznje();
            sadrzaj[i][7] = voznja.getStatusVoznje();
            sadrzaj[i][8] = voznja.getIdVoznje();
            sadrzaj[i][9] = voznja.getOcenaVoznje();
        }
        createTable(title, sadrzaj);
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
        if (e.getSource() == izbrisiButton) {
            if (red == -1) {
                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
            } else {
                String voznjaId = tabela.getValueAt(red, 8).toString();
                String status = tabela.getValueAt(red, 7).toString();
                ArrayList<Voznja> voznje = VoznjaIO.getVoznje();
                int izbor = JOptionPane.showConfirmDialog(null,
                        "Da li ste sigurni da zelite da obrisete voznju?",
                        " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
                if (izbor == JOptionPane.YES_OPTION) {
                    if (status.equals(String.valueOf(StatusVoznje.ODBIJENA)) || status.equals(String.valueOf(StatusVoznje.ZAVRSENA))) {
                        for (Voznja voznja : voznje) {
                            if (voznja.getIdVoznje().equals(voznjaId)) {
                                voznja.setObrisan(true);
                                VoznjaIO.voznjaUpis(voznje);
                            }
                        }
                        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
                        dtm.removeRow(red);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ne mozete obrisati voznju koja nije zavrsena ili odbijena", "Greska",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } else if (e.getSource() == izmeniButton) {
//            int red = tabela.getSelectedRow();
//            if(red == -1) {
//                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
//            }else {
//                String korisnikId = tabela.getValueAt(red, 0).toString();
//                ArrayList<Korisnik> korisnici = GetUtility.getKorisnici();
//
        } else if (e.getSource() == dodeliButton) {
            if (red == -1) {
                JOptionPane.showMessageDialog(null, "Morate izabrati red", "Greska",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                String voznjaId = tabela.getValueAt(red, 8).toString();
                String statusVoznje = tabela.getValueAt(red, 7).toString();
                ArrayList<Voznja> voznje = VoznjaIO.getVoznje();
                String imeVozaca = "";
                String prezimeVozaca = "";
                String idVozaca = "";
                String idAutomobilaVozaca = "";

                try {
                    int brKarteDodeljenog = DriverHandler.osveziVozace(KorisnikIO.getKorisnici(), "Olge Petrov 4").getBrKarte();
                    for (Vozac vozac : KorisnikIO.getVozaci()) {
                        if (brKarteDodeljenog == vozac.getBrKarte()) {
                            imeVozaca = vozac.getIme();
                            prezimeVozaca = vozac.getPrezime();
                            idVozaca = vozac.getIdKorisnika();
                            idAutomobilaVozaca = vozac.getIdAutomobila();
                        }
                    }
                } catch (JSONException | IOException jsonException) {
                    jsonException.printStackTrace();
                }

                if (idAutomobilaVozaca.equals("0")) {
                    String output = "Dodeljivanje voznje vozacu " + imeVozaca + " ID [" + idVozaca + "]" + " neuspesno. \nERR: Vozac nema dodeljen " +
                            "auto";
                    JOptionPane.showMessageDialog(null, output, "Greska",
                            JOptionPane.WARNING_MESSAGE);
                } else if (!statusVoznje.equals(String.valueOf(StatusVoznje.KREIRANA))) {
                    String output = "Dodeljivanje voznje vozacu " + imeVozaca + " ID [" + idVozaca + "]" + " neuspesno. \nERR: Voznja je " + statusVoznje;
                    JOptionPane.showMessageDialog(null, output, "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    int izbor = JOptionPane.showConfirmDialog(null, "Dodeliti voznju vozacu " + imeVozaca + " " + prezimeVozaca +
                            "?", " - Potvrdi akciju", JOptionPane.YES_NO_OPTION);
                    if (izbor == JOptionPane.YES_OPTION) {
                        for (Voznja voznja : voznje) {
                            if (voznja.getIdVoznje().equals(voznjaId)) {
                                voznja.setStatusVoznje(StatusVoznje.DODELJENA);
                                voznja.setIdVozaca(idVozaca);
                                VoznjaIO.voznjaUpis(voznje);
                            }
                        }
                    } else if (e.getSource() == nazadButton) {
                        this.dispose();
                        this.setVisible(false);
                    }
                }
            }
        }
    }
}
