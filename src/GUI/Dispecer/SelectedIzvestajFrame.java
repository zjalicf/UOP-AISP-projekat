//package GUI.Dispecer;
//
//import entiteti.Voznja;
//import fileIO.VoznjaIO;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import static javax.swing.BorderFactory.createEmptyBorder;
//
//public class SelectedIzvestajFrame extends JFrame implements ActionListener {
//    Container container = getContentPane();
//    private JTable tabela;
//    private DefaultTableModel tabelaModel;
//    private final JButton nazadButton = new JButton("Nazad");
//
//    public SelectedIzvestajFrame() {
//        setLayoutManager();
//        setLocationAndSize();
//        addComponentsToContainer();
//        addActionEvent();
//    }
//
//    public void setLayoutManager() {
//        container.setLayout(null);
//    }
//
//    public void setLocationAndSize() {
//        nazadButton.setBounds(50,210,110,24);
//    }
//
//    public void addComponentsToContainer() {
//        container.add(nazadButton);
//    }
//
//    public void addActionEvent() {
//        nazadButton.addActionListener(this);
//    }
//
//    public void initGUI() {
//        String[] title = new String[] {"Datum" ,"Polazak", "Destinacija", "ID Musterije", "ID Vozaca", "km", "Trajanje", "Status", "ID Voznje",
//                "Ocena"};
//        Object[][] sadrzaj = new Object[VoznjaIO.getVoznje().size()][title.length];
//
//        for(int i = 0; i < VoznjaIO.getVoznje().size(); i++) {
//            Voznja voznja = VoznjaIO.getVoznje().get(i);
//            if (voznja.getDatumPorudzbine().substring(0,6))
//            sadrzaj[i][0] = voznja.getDatumPorudzbine();
//            sadrzaj[i][1] = voznja.getAdresaPolaska();
//            sadrzaj[i][2] = voznja.getAdresaDestinacije();
//            sadrzaj[i][3] = voznja.getIdMusterije();
//            sadrzaj[i][4] = voznja.getIdVozaca();
//            sadrzaj[i][5] = voznja.getPredjenoKm();
//            sadrzaj[i][6] = voznja.getTrajanjeVoznje();
//            sadrzaj[i][7] = voznja.getStatusVoznje();
//            sadrzaj[i][8] = voznja.getIdVoznje();
//            sadrzaj[i][9] = voznja.getOcenaVoznje();
//        }
//        createTable(title, sadrzaj);
//    }
//
//    private void createTable(String[] title, Object[][] sadrzaj) {
//        tabelaModel = new DefaultTableModel(sadrzaj, title);
//        tabela = new JTable(tabelaModel);
//        JScrollPane scrollPane = new JScrollPane(tabela);
//        scrollPane.setBorder(createEmptyBorder());
//        tabela.setRowSelectionAllowed(true);
//        tabela.setColumnSelectionAllowed(false);
//        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        tabela.setDefaultEditor(Object.class, null);
//        tabela.getTableHeader().setReorderingAllowed(false);
//        tabela.setAutoCreateRowSorter(true);
//        scrollPane.setBounds(0,0,1200,100);
//        container.add(scrollPane);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == godisnjiIzvestaj) {
//
//        } else if (e.getSource() == mesecniIzvestaj) {
//
//        } else if (e.getSource() == nedeljniIzvestaj) {
//
//        } else if (e.getSource() == dnevniIzvestaj) {
//
//        } else if (e.getSource() == cancelButton) {
//
//        }
//    }
//}
