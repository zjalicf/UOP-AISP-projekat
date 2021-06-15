package GUI.Musterija;

import GUI.FrameLauncher;
import entiteti.Vozac;
import entiteti.Voznja;
import fileIO.KorisnikIO;
import fileIO.VoznjaIO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BorderFactory.createEmptyBorder;

public class ListaVoznjiMusterijaFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private final JButton oceniButton = new JButton("Oceni vozaca");
    private final JButton nazadButton = new JButton("Nazad");
    private JTable tabela;
    private DefaultTableModel tabelaModel;

    public ListaVoznjiMusterijaFrame() {
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
        oceniButton.setBounds(15,110,150,24);
        nazadButton.setBounds(180,110,150,24);
    }

    public void addComponentsToContainer() {
        container.add(oceniButton);
        container.add(nazadButton);
    }

    public void addActionEvent() {
        oceniButton.addActionListener(this);
        nazadButton.addActionListener(this);
    }

    public void initGUI() {
        String[] title = new String[] {"Datum" ,"Polazak", "Destinacija", "Ime Vozaca", "km", "Trajanje", "ID Voznje", "Ocena"};
        Object[][] sadrzaj = new Object[VoznjaIO.getVoznje().size()][title.length];
        for(int i = 0; i < VoznjaIO.getVoznje().size(); i++) {
            Voznja voznja = VoznjaIO.getVoznje().get(i);
            String idVozaca = voznja.getIdVozaca();
            String imeVozaca = "";
            for (Vozac vozac : KorisnikIO.getVozaci()) {
                if (idVozaca.equals(vozac.getIdKorisnika())) {
                    imeVozaca = vozac.getIme();
                }
            }
            sadrzaj[i][0] = voznja.getDatumPorudzbine();
            sadrzaj[i][1] = voznja.getAdresaPolaska();
            sadrzaj[i][2] = voznja.getAdresaDestinacije();
            sadrzaj[i][3] = imeVozaca;
            sadrzaj[i][4] = voznja.getPredjenoKm();
            sadrzaj[i][5] = voznja.getTrajanjeVoznje();
            sadrzaj[i][6] = voznja.getIdVoznje();
            sadrzaj[i][7] = voznja.getOcenaVoznje();
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
        tabela.setAutoCreateRowSorter(true);
        scrollPane.setBounds(0,0,1000,100);
        container.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int red = tabela.getSelectedRow();
        if (e.getSource() == oceniButton) {
            if(red == -1) {
                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli", "STATIM", JOptionPane.WARNING_MESSAGE);
            } else {
                String voznjaId = tabela.getValueAt(red, 6).toString();
                FrameLauncher.launchOceniVoznju(voznjaId);
            }
        }
        else if (e.getSource() == nazadButton) {
            this.dispose();
            this.setVisible(false);
        }
    }
}