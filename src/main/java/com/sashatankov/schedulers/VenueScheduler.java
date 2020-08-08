package com.sashatankov.schedulers;

import com.sashatankov.events.EntertainmentEvent;
import com.sashatankov.events.EventVenue;

import java.util.*;

/**
 * a class that schedules events to their corresponding venues.
 */
public class VenueScheduler {

    private Map<EntertainmentEvent, EventVenue> screeningSeating;
    private Set<Long> venueIds;

    /**
     * a default constructor, empty scheduler is created
     */
    public VenueScheduler() {

        this.venueIds = new HashSet<>();
        this.screeningSeating = new HashMap<>();

    }

    /**
     * constructor that creates a scheduler, with an initial
     * set of venues
     * @param venueIds ids of venues
     */
    public VenueScheduler(Collection<Long> venueIds) {

        this.venueIds = new HashSet<>();
        this.venueIds.addAll(venueIds);
        this.screeningSeating = new HashMap<>();

    }

    /**
     * adds an event and its venue to the scheduler. the venue is where
     * the event is hosted at. the venue must exist in the scheduler
     * @param event at event
     * @param venue the venue, the event is hosted at
     */
    public void addVenueToEvent(EntertainmentEvent event, EventVenue venue) {

        if(this.venueIds.contains(venue.getId()))
            this.screeningSeating.put(event, venue);

        // TODO to throw an exception
    }

    /**
     * remove the event and the associated venue from the scheduler
     * @param event an event to add
     * @param venue a venue the event is hosted at
     */
    public void removeVenueFromEvent(EntertainmentEvent event, EventVenue venue) {

        if(this.venueIds.contains(venue.getId()))
            this.screeningSeating.remove(event, venue);

        // TODO to throw an exception
    }

    /**
     * add a venue to the collection of available venues for events
     * in the scheduler.
     * @param venueId an id of a venue
     * @return true if added
     */
    public boolean addVenue(long venueId) {
        return this.venueIds.add(venueId);
    }

    /**
     * method return the venue seating for a particular event
     * @param event
     * @return the venue seating of the event
     */
    public EventVenue getVenue(EntertainmentEvent event) {
        return this.screeningSeating.get(event);
    }

    /**
     * check if a venue exist for a particular event
     * @param event
     * @return true if venue for event exist
     */
    public boolean venueExist(EntertainmentEvent event) {
        return this.screeningSeating.containsKey(event);
    }




}
