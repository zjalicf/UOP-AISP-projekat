package GUI.Musterija;

import entiteti.Voznja;
import enums.StatusVoznje;
import fileIO.VoznjaIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OceniVoznjuFrame extends JFrame implements ActionListener {
    private final String voznjaId;
    Container container = getContentPane();
    private final JButton confirmButton = new JButton("Potvrdi");
    private final JButton cancelButton = new JButton("Odustani");
    private final JLabel ocenaLabel = new JLabel("Ocena: ");
    private final JTextField ocenaField = new JTextField(10);

    public OceniVoznjuFrame(String voznjaId) {
        this.voznjaId = voznjaId;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        ocenaLabel.setBounds(5,5,100,20);
        ocenaField.setBounds(110,5,100,20);

        confirmButton.setBounds(5,130,100,24);
        cancelButton.setBounds(110,130,100,24);
    }

    public void addComponentsToContainer() {
        container.add(ocenaLabel);
        container.add(ocenaField);
        container.add(confirmButton);
        container.add(cancelButton);
    }

    public void addActionEvent() {
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    public boolean provera() {
        boolean correct = true;
        String output = "Greske:\n";

        if (this.ocenaField.getText().trim().equals("")) {
            output = output + "Unesite ocenu\n";
            correct = false;
        }

        if (Integer.parseInt(this.ocenaField.getText().trim()) < 1 || Integer.parseInt(this.ocenaField.getText().trim()) > 5) {
            output = output + "Ocena mora biti od 1 do 5\n";
            correct = false;
        }

        for (Voznja voznja : VoznjaIO.getVoznje()) {
            if (voznjaId.equals(voznja.getIdVoznje()) && voznja.getStatusVoznje() != StatusVoznje.ZAVRSENA) {
                output = output + "Voznja mora biti zavrsena\n";
                correct = false;
            }
        }

        if (!correct) {
            JOptionPane.showMessageDialog(null, output, "STATIM", JOptionPane.WARNING_MESSAGE);
        }

        return correct;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            if (provera()) {
                int ocena = Integer.parseInt(ocenaField.getText().trim());
                for (Voznja voznja : VoznjaIO.getVoznje()) {
                    if (voznjaId.equals(voznja.getIdVoznje())) {
                        voznja.setOcenaVoznje(ocena);
                    }
                }
                ArrayList<Voznja> sve = VoznjaIO.getVoznje();
                VoznjaIO.voznjaUpis(sve);
                this.dispose();
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Uspesno ste ocenili voznju", "STATIM", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == cancelButton){
            this.dispose();
            this.setVisible(false);
        }
    }
}
