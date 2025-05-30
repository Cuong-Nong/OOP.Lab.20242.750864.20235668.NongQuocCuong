package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfId;
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(0, 2, 5, 5));
        center.add(new JLabel("ID:"));
        tfId = new JTextField();
        center.add(tfId);

        center.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        center.add(tfTitle);

        center.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        center.add(tfCategory);

        center.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        center.add(tfCost);

        center.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Length (mins):"));
        tfLength = new JTextField();
        center.add(tfLength);

        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> submitMedia());
        center.add(new JLabel());
        center.add(submit);

        return center;
    }

    private void submitMedia() {
        try {
            int id = Integer.parseInt(tfId.getText());
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD added successfully!");
            dispose();
            new StoreManagerScreen(store);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for ID, Cost, or Length!");
        }
    }
}