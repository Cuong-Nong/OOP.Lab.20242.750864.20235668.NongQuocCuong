package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfId;
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfDirector;
    private JTextField tfArtist;
    private JTextField tfTrackTitle;
    private JTextField tfTrackLength;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to Store");
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

        center.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        center.add(tfArtist);

        center.add(new JLabel("Track Title:"));
        tfTrackTitle = new JTextField();
        center.add(tfTrackTitle);

        center.add(new JLabel("Track Length (secs):"));
        tfTrackLength = new JTextField();
        center.add(tfTrackLength);

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
            String artist = tfArtist.getText();

            CompactDisc cd = new CompactDisc(id, title, category, cost, director, artist);
            if (!tfTrackTitle.getText().isEmpty() && !tfTrackLength.getText().isEmpty()) {
                int trackLength = Integer.parseInt(tfTrackLength.getText());
                cd.addTrack(new Track(tfTrackTitle.getText(), trackLength));
            }

            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "CD added successfully!");
            dispose();
            new StoreManagerScreen(store);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for ID, Cost, or Track Length!");
        }
    }
}