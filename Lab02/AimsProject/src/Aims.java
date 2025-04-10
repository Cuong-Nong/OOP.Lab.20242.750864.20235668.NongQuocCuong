
public class Aims {

	public static void main(String[] args) {
		
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 82, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);	
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc[] itemsOrdered = anOrder.getItemsOrdered();
		for (int i = 0; i < anOrder.getQtyOrdered(); i++) {
		    DigitalVideoDisc disc = itemsOrdered[i];
		    System.out.printf("%d %s - $%.2f\n", i + 1, disc.getTitle(), disc.getCost());
		}
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());

		System.out.println("Removing disc...");
		anOrder.removeDigitalVideoDisc(dvd3);
		
		itemsOrdered = anOrder.getItemsOrdered();
		for (int i = 0; i < anOrder.getQtyOrdered(); i++) {
		    DigitalVideoDisc disc = itemsOrdered[i];
		    System.out.printf("%d %s - $%.2f\n", i + 1, disc.getTitle(), disc.getCost());
		}
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
		System.out.println("Total discs created: " + DigitalVideoDisc.getNbDigitalVideoDisc());
	}

}
