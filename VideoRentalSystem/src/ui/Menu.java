package src.ui;

import src.service.VideoStore;
import java.util.Scanner;
public class Menu {

    private Scanner sc = new Scanner(System.in);
    private VideoStore store = new VideoStore();

    public void start() {

        int choice;

        do {

            System.out.println("\nMAIN MENU");
            System.out.println("1. Add Videos");
            System.out.println("2. Check Out Video");
            System.out.println("3. Return Video");
            System.out.println("4. Receive Rating");
            System.out.println("5. List Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1..6): ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter the name of the video: ");
                    store.addVideo(sc.nextLine());
                    break;

                case 2:

                    System.out.print("Enter the video name: ");
                    store.doCheckout(sc.nextLine());
                    break;

                case 3:

                    System.out.print("Enter the video name: ");
                    store.doReturn(sc.nextLine());
                    break;

                case 4:

                    System.out.print("Enter the video name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter rating: ");
                    int rating = sc.nextInt();
                    sc.nextLine();

                    store.receiveRating(name, rating);
                    break;

                case 5:

                    store.listInventory();
                    break;

                case 6:

                    System.out.println("Exiting...!!! Thanks for using the application.");
                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 6);

    }

}