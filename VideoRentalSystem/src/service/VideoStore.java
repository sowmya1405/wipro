package src.service;
import src.model.Video;
public class VideoStore {

    private Video[] videos = new Video[100];
    private int count = 0;

    public void addVideo(String name) {
        videos[count++] = new Video(name);
        System.out.println("Video \"" + name + "\" added successfully.");
    }

    private Video searchVideo(String name) {

        for (int i = 0; i < count; i++) {

            if (videos[i].getVideoName().equalsIgnoreCase(name)) {
                return videos[i];
            }

        }

        return null;
    }

    public void doCheckout(String name) {

        Video video = searchVideo(name);

        if (video == null) {
            System.out.println("Video not found.");
            return;
        }

        if (video.isCheckedOut()) {
            System.out.println("Video already checked out.");
        } else {
            video.checkout();
            System.out.println("Video \"" + name + "\" checked out successfully.");
        }

    }

    public void doReturn(String name) {

        Video video = searchVideo(name);

        if (video == null) {
            System.out.println("Video not found.");
            return;
        }

        if (!video.isCheckedOut()) {
            System.out.println("Video is already available.");
        } else {
            video.returnVideo();
            System.out.println("Video \"" + name + "\" returned successfully.");
        }

    }

    public void receiveRating(String name, int rating) {

        Video video = searchVideo(name);

        if (video == null) {
            System.out.println("Video not found.");
            return;
        }

        if (rating < 1 || rating > 10) {
            System.out.println("Invalid Rating.");
            return;
        }

        video.setRating(rating);

        System.out.println("Rating \"" + rating + "\" has been mapped to the Video \"" + name + "\".");

    }

    public void listInventory() {

        if (count == 0) {
            System.out.println("Inventory Empty.");
            return;
        }

        System.out.println("--------------------------------------------------------");
        System.out.printf("%-20s %-18s %-8s%n",
                "Video Name",
                "Checkout Status",
                "Rating");
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < count; i++) {

            System.out.printf("%-20s %-18s %-8d%n",
                    videos[i].getVideoName(),
                    videos[i].isCheckedOut(),
                    videos[i].getRating());

        }

        System.out.println("--------------------------------------------------------");

    }

}