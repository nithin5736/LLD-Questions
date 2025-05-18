package manager;

import model.*;
import java.util.*;

public class CabManager {
    private Map<String, Cab> cabMap = new HashMap<>();

    public void registerCab(String cabId, String driverName, double x, double y) {
        Cab cab = new Cab(cabId, driverName, x, y);
        cabMap.put(cabId, cab);
    }

    public void updateCabLocation(String cabId, double x, double y) {
        Cab cab = cabMap.get(cabId);
        if (cab != null)
            cab.setLocation(x, y);
    }

    public List<Cab> getAvailableCabs(double userX, double userY) {
        List<Cab> nearByCabs = new ArrayList<>();
        for (Cab cab : cabMap.values()) {
            if (cab.isAvailable() && distance(cab.getX(), cab.getY(), userX, userY) <= 10) {
                nearByCabs.add(cab);
            }
        }
        return nearByCabs;
    }

    public double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public Cab getCab(String cabId) {
        return this.cabMap.get(cabId);
    }
}
