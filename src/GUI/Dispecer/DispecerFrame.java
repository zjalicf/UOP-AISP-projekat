package GUI.Dispecer;//vozac je 0, dispecer 1

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DispecerFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JButton vozaciButton = new JButton("Vozaci");
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
        vozaciButton.setBounds(15,15,130,28);
        dispeceriButton.setBounds(15,60,130,28);
        potvrdaVoznjeButton.setBounds(15,105,130,28);
        slika.setBounds(166, 32, 150,125);
        odjavaButton.setBounds(15,150,130,28);
    }

    public void addComponentsToContainer() {
        container.add(vozaciButton);
        container.add(dispeceriButton);
        container.add(potvrdaVoznjeButton);
        container.add(slika);
        container.add(odjavaButton);
    }

    public void addActionEvent() {
        vozaciButton.addActionListener(this);
        dispeceriButton.addActionListener(this);
        potvrdaVoznjeButton.addActionListener(this);
        odjavaButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vozaciButton) {
            launchListaKorisnikaFrame(0);
        } else if (e.getSource() == dispeceriButton){
            launchListaKorisnikaFrame(1);
        } else if (e.getSource() == potvrdaVoznjeButton) {
//            launchListaVoznjiFrame();
        } else if (e.getSource() == odjavaButton){
            this.dispose();
            this.setVisible(false);
        }
    }

    private void launchListaKorisnikaFrame(int tip) {
        ListaKorisnikaFrame listaKorisnikaFrame = new ListaKorisnikaFrame(tip);
        listaKorisnikaFrame.setVisible(true);
        listaKorisnikaFrame.setBounds(20, 20, 1200, 200);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaKorisnikaFrame.setResizable(false);
    }
}