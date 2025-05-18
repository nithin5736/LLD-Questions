import model.*;
import manager.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        CabManager cabManager = new CabManager();
        TripManager tripManager = new TripManager(cabManager);

        // Register users
        userManager.registerUser("u1", "Ravi");
        userManager.registerUser("u2", "Raju");
        userManager.registerUser("u3", "Ram");

        // Register cabs
        cabManager.registerCab("c1", "John", 0, 0);
        cabManager.registerCab("c2", "Mike", 10, 10);
        cabManager.registerCab("c3", "Brad", 20, 20);

        // Get user objects
        User ravi = userManager.getUser("u1");
        User raju = userManager.getUser("u2");
        User ram = userManager.getUser("u3");

        // Book Trips
        Trip trip1 = tripManager.bookTrip(ravi, 1, 1, 10, 10);
        Trip trip2 = tripManager.bookTrip(ram, 7, 6, 7, 8);

        // End Trips
        if (trip1 != null)
            tripManager.endTrip(trip1.getTripId());
        if (trip2 != null)
            tripManager.endTrip(trip2.getTripId());

        // Print trips of all users
        System.out.println("-----------Trip History-----------");
        for (User user : new User[] { ravi, raju, ram }) {
            System.out.println("Trips for: " + user.getName());
            for (Trip t : tripManager.getTripsForUser(user.getUserId())) {
                System.out.println("Trip Id: " + t.getTripId() + " | Cab: " + t.getCab().getCabId() + " | Completed: "
                        + t.isCompleted());
            }
        }
    }
}
