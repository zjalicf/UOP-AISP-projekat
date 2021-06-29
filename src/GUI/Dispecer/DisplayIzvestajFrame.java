package GUI.Dispecer;

import entiteti.Voznja;
import fileIO.VoznjaIO;
import strukture.Lista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BorderFactory.createEmptyBorder;

public class DisplayIzvestajFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JTable tabela;
    private DefaultTableModel tabelaModel;
    private final JButton nazadButton = new JButton("Nazad");

    public DisplayIzvestajFrame(String tip, String value) {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        initGUI(tip, value);
    }

    private void setLayoutManager() {
        container.setLayout(null);
    }

    private void setLocationAndSize() {
        nazadButton.setBounds(50, 210, 110, 24);
    }

    private void addComponentsToContainer() {
        container.add(nazadButton);
    }

    private void addActionEvent() {
        nazadButton.addActionListener(this);
    }

    private void initGUI(String tip, String value) {
        Lista<Voznja> voznjeZaUpis = new Lista<>();
        for (Voznja voznja: VoznjaIO.getVoznje()) {
            if (!voznja.isObrisan()) {
                if (tip.equals("godina") && voznja.getDatumPorudzbine().substring(6, 10).equals(value)) {
                    voznjeZaUpis.add(voznja);
                } else if (tip.equals("mesec") && voznja.getDatumPorudzbine().substring(3, 5).equals(value)) {
                    voznjeZaUpis.add(voznja);
                } else if (tip.equals("nedelja") && voznja.getDatumPorudzbine().substring(0, 0).equals(value)) {
                    //todo
                } else if (tip.equals("dan") && voznja.getDatumPorudzbine().substring(0, 10).equals(value)) {
                    voznjeZaUpis.add(voznja);
                }
            }
        }
        fillTable(voznjeZaUpis);
    }

    private void fillTable(Lista<Voznja> voznjeZaUpis) {
        String[] title = new String[] {"Datum" ,"Polazak", "Destinacija", "ID Musterije", "ID Vozaca", "km", "Trajanje", "Status", "ID Voznje",
                "Ocena"};
        Object[][] sadrzaj = new Object[voznjeZaUpis.getSize()][title.length];
        for (int i = 0; i < voznjeZaUpis.getSize(); i++) {
            for (Voznja voznja: voznjeZaUpis) {
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
        scrollPane.setBounds(0, 0, 1200, 100);
        container.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nazadButton) {
            this.dispose();
            this.setVisible(false);
        }
    }
}
