package com.sashatankov.events;

import com.sashatankov.schedulers.VenueScheduler;

public class MovieAuditoriumController {

    private VenueScheduler scheduler;

    public MovieAuditoriumController() {
        this.scheduler = new VenueScheduler();
    }

    /**
     * add an auditorium by ID to the collection of auditoriums for
     * movie screenings
     * @param auditoriumId
     * @return true, if added successfully
     */
    public boolean addAuditorium(long auditoriumId) {
        return this.scheduler.addVenue(auditoriumId);
    }

    /**
     * adds a particular screening and its auditorium to the schedule
     * @param screening
     * @param auditorium
     */
    public void addAuditoriumToScreening(MovieScreening screening, Auditorium auditorium) {
        this.scheduler.addVenueToEvent(screening, auditorium);
    }

    /**
     * removes a particular screening and its auditorium from the schedule
     * @param screening
     * @param auditorium
     */
    public void removeAuditoriumFromScreening(MovieScreening screening, Auditorium auditorium) {
        this.scheduler.removeVenueFromEvent(screening, auditorium);
    }

    /**
     *
     * @param screening
     * @return true, if for a particular screening exist an auditorium
     */
    public boolean auditoriumExist(MovieScreening screening) {
        return this.scheduler.venueExist(screening);
    }

    /**
     *
     * @param screening
     * @return the auditorium associated with a particular movie screening
     */
    public Auditorium getAuditorium(MovieScreening screening) {
        return (Auditorium) this.scheduler.getVenue(screening);
    }
}
