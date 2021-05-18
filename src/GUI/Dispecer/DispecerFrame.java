//package GUI.Dispecer;
//
//import entiteti.Dispecer;
//import net.miginfocom.swing.MigLayout;
//
//import javax.swing.*;
//
//public class MainFrameDispecer extends JFrame {
//
//    private JButton btnMusterije = new JButton("Musterije");
//    private JButton btnDispeceri = new JButton("Dispeceri");
//    private JButton btnPotvrdaVoznje = new JButton("Narucene voznje");
//    JLabel lblOsobaLogo = new JLabel(new ImageIcon("src/img/osoba.png"));
//
//    public MainFrameDispecer(Dispecer dispecer) {
//        setTitle("Meni za dispecera: " + dispecer.getIme() + " " + dispecer.getPrezime());
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        initGUI();
//        initActions();
//        pack();
//        setLocationRelativeTo(null);
//    }
//
//    public void initGUI() {
//        MigLayout mig = new MigLayout("wrap 2", "[center]10[center][left][c]", "[center]10[center]15[center]15[center]20[center][b]");
//        setLayout(mig);
//        add(lblOsobaLogo, "span 1 5");
//        add(btnMusterije);
//        add(btnDispeceri);
//        add(btnPotvrdaVoznje);
//    }
//
//
//    public void initActions() {
//        btnMusterije.addActionListener(e -> JOptionPane.showMessageDialog(this,
//                "MUSTERIJA"));
//
//        btnDispeceri.addActionListener(e -> JOptionPane.showMessageDialog(this,
//                "DIS"));
//
//        btnPotvrdaVoznje.addActionListener(e -> JOptionPane.showMessageDialog(this,
//                    "Voznje"));
//    }
//}
//
package GUI.Dispecer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DispecerFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JButton musterijeButton = new JButton("Musterije");
    private JButton dispeceriButton = new JButton("Dispeceri");
    private JButton potvrdaVoznjeButton = new JButton("Narucene voznje");
    private JLabel slika = new JLabel(new ImageIcon("src/img/person.jpg"));
    private JButton odjavaButton = new JButton("Odjava");

    public DispecerFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        musterijeButton.setBounds(15,15,130,28);
        dispeceriButton.setBounds(15,60,130,28);
        potvrdaVoznjeButton.setBounds(15,105,130,28);
        slika.setBounds(166, 32, 150,125);
        odjavaButton.setBounds(15,150,130,28);
    }

    public void addComponentsToContainer() {
        container.add(musterijeButton);
        container.add(dispeceriButton);
        container.add(potvrdaVoznjeButton);
        container.add(slika);
        container.add(odjavaButton);
    }

    public void addActionEvent() {
        musterijeButton.addActionListener(this);
        dispeceriButton.addActionListener(this);
        potvrdaVoznjeButton.addActionListener(this);
        odjavaButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == musterijeButton) {
            launchListaMusterijaFrame();
        } else if (e.getSource() == dispeceriButton){
//            launchListaDispeceraFrame();
        } else if (e.getSource() == potvrdaVoznjeButton) {
//            launchListaVoznjiFrame();
        } else if (e.getSource() == odjavaButton){
            this.dispose();
            this.setVisible(false);
        }
    }

    private void launchListaMusterijaFrame() {
        ListaMusterijaFrame musterijaFrame = new ListaMusterijaFrame();
        musterijaFrame.setVisible(true);
        musterijaFrame.setBounds(10, 10, 1100, 200);
//        musterijaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        musterijaFrame.setResizable(false);
    }

//        private void launchListaDispeceraFrame() {
//        ListaDiscpeceraFrame dispecerFrame = new ListaDispeceraFrame();
//        ListaDiscpeceraFrame.setVisible(true);
//        ListaDiscpeceraFrame.setBounds(10, 10, 540, 550);
////        DiscpecerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ListaDiscpeceraFrame.setResizable(false);
//    }
}