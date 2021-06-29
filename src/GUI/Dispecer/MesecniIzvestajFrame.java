package GUI.Dispecer;

import GUI.FrameLauncher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MesecniIzvestajFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private final JLabel mesecLabel = new JLabel("Izaberite mesec: ");
    private final JTextField mesecField = new JTextField(20);
    private final JButton prikaziButton = new JButton("Prikazi");
    private final JButton cancelButton = new JButton("Nazad");

    public MesecniIzvestajFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        mesecLabel.setBounds(5,5,100,24);
        mesecField.setBounds(5,36,100,24);
        prikaziButton.setBounds(5,80,100,24);
        cancelButton.setBounds(115,80,100,24);
    }

    public void addComponentsToContainer() {
        container.add(mesecField);
        container.add(mesecLabel);
        container.add(prikaziButton);
        container.add(cancelButton);
    }

    public void addActionEvent() {
        prikaziButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prikaziButton) {
            String mesec = mesecField.getText().trim();
            FrameLauncher.launchDisplayIzvestajFrame("mesec", mesec);
        } else if (e.getSource() == cancelButton) {
            this.dispose();
            this.setVisible(false);
        }
    }
}
