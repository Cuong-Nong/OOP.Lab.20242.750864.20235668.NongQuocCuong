package hust.soict.hedspi.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, director, 0);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " has been added to the CD " + getTitle());
        } else {
            System.out.println("Track " + track.getTitle() + " is already in the CD " + getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " has been removed from the CD " + getTitle());
        } else {
            System.out.println("Track " + track.getTitle() + " is not in the CD " + getTitle());
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        System.out.println("Artist: " + this.artist);
        for (Track track : tracks) {
            track.play();
        }
    }
    
	@Override
	public String toString() {
	    return "CD - Title: " + getTitle() + " - Artist: " + getArtist() + " - Cost: $" + getCost();
	}
}