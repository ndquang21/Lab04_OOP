package hust.soict.dsai.aims.screen;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame{
	private Store store;

	JPanel createNorth(){
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JMenuBar createMenuBar() {
	    JMenu menu = new JMenu("Options");

	    JMenu smUpdateStore = new JMenu("Update Store");
	    JMenuItem addBook = new JMenuItem("Add Book");
	    addBook.addActionListener(e -> new AddBookToStoreScreen());
	    smUpdateStore.add(addBook);

	    JMenuItem addCD = new JMenuItem("Add CD");
	    addCD.addActionListener(e -> new AddCompactDiscToStoreScreen());
	    smUpdateStore.add(addCD);

	    JMenuItem addDVD = new JMenuItem("Add DVD");
	    addDVD.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen());
	    smUpdateStore.add(addDVD);

	    menu.add(smUpdateStore);
	    menu.add(new JMenuItem("View Store"));
	    menu.add(new JMenuItem("View Cart"));

	    JMenuBar menuBar = new JMenuBar();
	    menuBar.add(menu);
	    return menuBar;
	}


	JPanel createHeader() {
    	JPanel header = new JPanel();
    	header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

    	JLabel title = new JLabel("AIMS");
    	title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
    	title.setForeground(Color.CYAN);

    	header.add(Box.createRigidArea(new Dimension(10, 10)));
    	header.add(title);
    	header.add(Box.createHorizontalGlue());

    	return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<hust.soict.dsai.aims.media.Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	public StoreScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        
        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		
		store.addMedia(new Book(1, "Book Title1", "Fiction", 10.5f));
	    store.addMedia(new DVD(2, "DVD Title1", "Action", 15.0f, "ab", 2));
	    store.addMedia(new Book(3, "Book Title2", "Fiction", 10.5f));
	    store.addMedia(new DVD(4, "DVD Title2", "Action", 15.0f, "ab", 2));
	    store.addMedia(new Book(5, "Book Title3", "Fiction", 10.5f));
	    store.addMedia(new DVD(6, "DVD Title3", "Action", 15.0f, "ab", 2));
	    store.addMedia(new Book(7, "Book Title4", "Fiction", 10.5f));
	    store.addMedia(new DVD(8, "DVD Title4", "Action", 15.0f, "ab", 2));
	    store.addMedia(new Book(9, "Book Title5", "Fiction", 10.5f));
	    
	    new StoreScreen(store);
    }
}