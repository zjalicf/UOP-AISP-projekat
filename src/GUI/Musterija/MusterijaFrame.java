package GUI.Musterija;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusterijaFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JButton sveVoznjeButton= new JButton("Moje voznje");
    private JButton naruciVoznjuButton = new JButton("Naruci voznju");
    private JButton oceniButton = new JButton("Oceni vozaca");
    private JButton odjavaButton = new JButton("Odjava");
    private JLabel slika = new JLabel(new ImageIcon("src/img/person.jpg"));

    public MusterijaFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        sveVoznjeButton.setBounds(15,15,130,28);
        naruciVoznjuButton.setBounds(15,60,130,28);
        oceniButton.setBounds(15,105,130,28);
        slika.setBounds(166, 32, 150,125);
        odjavaButton.setBounds(15,150,130,28);
    }

    public void addComponentsToContainer() {
        container.add(sveVoznjeButton);
        container.add(naruciVoznjuButton);
        container.add(oceniButton);
        container.add(odjavaButton);
        container.add(slika);
    }

    public void addActionEvent() {
        sveVoznjeButton.addActionListener(this);
        naruciVoznjuButton.addActionListener(this);
        odjavaButton.addActionListener(this);
        oceniButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sveVoznjeButton) {
            JOptionPane.showMessageDialog(this,
                    "sve vzonje");
        } else if (e.getSource() == naruciVoznjuButton){
            JOptionPane.showMessageDialog(this,
                    "naruci");
        } else if (e.getSource() == oceniButton) {
            JOptionPane.showMessageDialog(this,
                    "ocena 5");
        } else if (e.getSource() == odjavaButton){
            this.dispose();
            this.setVisible(false);
        }
    }
}
