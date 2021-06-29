package GUI.Dispecer;

import strukture.Lista;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PretraziVozaceFrame extends JFrame implements ActionListener {
    private final JTable tabela;
    Container container = getContentPane();
    private final JButton confirmButton = new JButton("Potvrdi");
    private final JButton cancelButton = new JButton("Odustani");
    private final JLabel imeLabel = new JLabel("Ime: ");
    private final JTextField imeField = new JTextField(20);
    private final JLabel prezimeLabel = new JLabel("Prezime: ");
    private final JTextField prezimeField = new JTextField(20);
    private final JLabel plataLabel = new JLabel("Plata: ");
    private final JTextField plataField = new JTextField(20);
    private final JLabel idAutomobilaLabel = new JLabel("ID automobila: ");
    private final JTextField idAutomobilaField = new JTextField(20);

    public PretraziVozaceFrame(JTable tabela) {
        this.tabela = tabela;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        imeLabel.setBounds(5,5,100,20);
        prezimeLabel.setBounds(5,30,100,20);
        plataLabel.setBounds(5,55,100,20);
        idAutomobilaLabel.setBounds(5,80,100,20);

        imeField.setBounds(110,5,100,20);
        prezimeField.setBounds(110,30,100,20);
        plataField.setBounds(110,55,100,20);
        idAutomobilaField.setBounds(110,80,100,20);

        confirmButton.setBounds(5,130,100,24);
        cancelButton.setBounds(110,130,100,24);
    }

    public void addComponentsToContainer() {
        container.add(imeLabel);
        container.add(imeField);
        container.add(prezimeLabel);
        container.add(prezimeField);
        container.add(plataLabel);
        container.add(plataField);
        container.add(idAutomobilaLabel);
        container.add(idAutomobilaField);
        container.add(confirmButton);
        container.add(cancelButton);
    }

    public void addActionEvent() {
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            Lista<RowFilter<Object,Object>> filters = new Lista<>(2);
            filters.add(RowFilter.regexFilter(imeField.getText().trim()));
            filters.add(RowFilter.regexFilter(prezimeField.getText().trim()));
            filters.add(RowFilter.regexFilter(plataField.getText().trim()));
            filters.add(RowFilter.regexFilter(idAutomobilaField.getText().trim()));
            RowFilter<Object, Object> rf = RowFilter.andFilter(filters);
            TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tabela.getModel());
            rowSorter.setRowFilter(rf);
            tabela.setRowSorter(rowSorter);

        } else if (e.getSource() == cancelButton) {
            this.dispose();
            this.setVisible(false);
        }
    }
}
