package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, null, 0.0f);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, director, 0);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, director, length);
    }

    public boolean isMatch(String title) {
        if (getTitle() == null || title == null) {
            return false;
        }
        String[] keywords = title.toLowerCase().split("\\s+");
        String titleLower = getTitle().toLowerCase();
        for (String keyword : keywords) {
            if (titleLower.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    public static int getNbDigitalVideoDisc() {
        return nbDigitalVideoDiscs;
    }
    
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    
	@Override
	public String toString() {
	    return "DVD - Title: " + getTitle() + " - Director: " + getDirector()
	         + " - Length: " + getLength() + " mins - Cost: $" + getCost();
	}
}
