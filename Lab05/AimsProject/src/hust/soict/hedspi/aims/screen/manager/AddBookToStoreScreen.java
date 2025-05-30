package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfId;
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book to Store");
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

            Book book = new Book(id, title, category, cost);
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            dispose();
            new StoreManagerScreen(store);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for ID or Cost!");
        }
    }
}