package GUI.Dispecer;

import GUI.FrameLauncher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IzvestajiFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private final JButton godisnjiIzvestaj = new JButton("Godisnji");
    private final JButton mesecniIzvestaj = new JButton("Mesecni");
    private final JButton nedeljniIzvestaj = new JButton("Nedeljni");
    private final JButton dnevniIzvestaj = new JButton("Dnevni");
    private final JButton cancelButton = new JButton("Odustani");

    public IzvestajiFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        godisnjiIzvestaj.setBounds(5,50,70,20);
        mesecniIzvestaj.setBounds(90,50,70,20);
        nedeljniIzvestaj.setBounds(175,50,70,24);
        dnevniIzvestaj.setBounds(260,50,70,24);
        cancelButton.setBounds(345,50,70,24);
    }

    public void addComponentsToContainer() {
        container.add(godisnjiIzvestaj);
        container.add(mesecniIzvestaj);
        container.add(nedeljniIzvestaj);
        container.add(dnevniIzvestaj);
        container.add(cancelButton);
    }

    public void addActionEvent() {
        godisnjiIzvestaj.addActionListener(this);
        mesecniIzvestaj.addActionListener(this);
        nedeljniIzvestaj.addActionListener(this);
        dnevniIzvestaj.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == godisnjiIzvestaj) {
            FrameLauncher.launchGodisnjiIzvestajFrame();
        } else if (e.getSource() == mesecniIzvestaj) {
            //godina i mesec
        } else if (e.getSource() == nedeljniIzvestaj) {
            //godina, mesec i broj nedelje
        } else if (e.getSource() == dnevniIzvestaj) {
            //datum
        } else if (e.getSource() == cancelButton) {
            this.dispose();
            this.setVisible(false);
        }
    }
}
