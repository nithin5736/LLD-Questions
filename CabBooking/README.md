# Cab Booking Application

### Functional Requirements:

1. Register a cab and driver
2. Register users
3. Update cab location
4. Book the nearest available cab
5. End trip and free the cab
6. View trip history

### Entities:

* `User`: id, name
* `Cab`: id, driver, location, available
* `Trip`: tripId, cab, user, origin, destination, status

### Managers:

* `UserManager`: register and get users
* `CabManager`: register cabs, update location, get available cabs
* `TripManager`: book trip, end trip, track history
