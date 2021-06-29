//package GUI.Dispecer;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class SelectedIzvestajFrame extends JFrame implements ActionListener {
//    Container container = getContentPane();
//    private JTable tabela;
//    private DefaultTableModel tabelaModel;
//    private final JButton cancelButton = new JButton("Nazad");
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
//        cancelButton.setBounds(50,210,110,24);
//    }
//
//    public void addComponentsToContainer() {
//        container.add(cancelButton);
//    }
//
//    public void addActionEvent() {
//        cancelButton.addActionListener(this);
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
