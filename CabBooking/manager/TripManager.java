package manager;

import model.*;
import java.util.*;

public class TripManager {
    private HashMap<String, Trip> tripMap = new HashMap<>();
    private CabManager cabManager;
    private static int tripCounter = 0;

    public TripManager(CabManager cabManager) {
        this.cabManager = cabManager;
    }

    public Trip bookTrip(User user, double originX, double originY, double destX, double destY) {
        List<Cab> cabs = this.cabManager.getAvailableCabs(originX, originY);
        if (cabs.isEmpty()) {
            System.out.println("No cabs available for user: " + user.getName());
            return null;
        }

        Cab selectedCab = cabs.get(0);
        selectedCab.setAvailable(false);

        String tripId = "T" + tripCounter;
        tripCounter++;
        Trip trip = new Trip(tripId, selectedCab, user, originX, originY, destX, destY);
        tripMap.put(tripId, trip);

        System.out.println("Trip booked with cab " + selectedCab.getCabId() + " for " + user.getName());
        return trip;
    }

    public void endTrip(String tripId) {
        Trip trip = tripMap.get(tripId);
        if (trip != null && !trip.isCompleted()) {
            trip.completeTrip();
            System.out.println("Trip " + tripId + " ended.");
        }
    }

    public List<Trip> getTripsForUser(String userId) {
        List<Trip> userTrips = new ArrayList<>();
        for (Trip t : tripMap.values()) {
            if (t.getUser().getUserId().equals(userId)) {
                userTrips.add(t);
            }
        }
        return userTrips;
    }
}
