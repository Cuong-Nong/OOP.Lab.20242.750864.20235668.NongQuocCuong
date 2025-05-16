package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setTitle("Add Item");
        setSize(400, 300); // Giảm kích thước để phù hợp với form nhập liệu
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Sử dụng DISPOSE_ON_CLOSE thay vì EXIT_ON_CLOSE

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
    }

    protected JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(StoreManagerScreen.createMenuBar(store, this)); // Sử dụng phương thức static
        north.add(StoreManagerScreen.createHeader()); // Sử dụng phương thức static
        return north;
    }

    protected abstract JPanel createCenter(); // override in subclasses
}