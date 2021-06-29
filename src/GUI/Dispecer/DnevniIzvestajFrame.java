package GUI.Dispecer;

import GUI.FrameLauncher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DnevniIzvestajFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private final JLabel datumLabel = new JLabel("Izaberite datum: ");
    private final JTextField datumField = new JTextField(20);
    private final JButton prikaziButton = new JButton("Prikazi");
    private final JButton cancelButton = new JButton("Nazad");

    public DnevniIzvestajFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        datumLabel.setBounds(5,5,100,24);
        datumField.setBounds(5,36,100,24);
        prikaziButton.setBounds(5,80,100,24);
        cancelButton.setBounds(115,80,100,24);
    }

    public void addComponentsToContainer() {
        container.add(datumField);
        container.add(datumLabel);
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
            String datum = datumField.getText().trim();
            FrameLauncher.launchDisplayIzvestajFrame("dan", datum);
        } else if (e.getSource() == cancelButton) {
            this.dispose();
            this.setVisible(false);
        }
    }
}

