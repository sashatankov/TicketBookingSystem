package com.sashatankov.booking;

import com.sashatankov.events.EntertainmentEvent;
import com.sashatankov.events.EventVenue;

import java.util.*;

/**
 * a class that schedules events to their corresponding venues.
 */
public class VenuePlanner {

    private Map<EntertainmentEvent, EventVenue> screeningSeating;
    private Set<Long> venueIds;

    /**
     * a default constructor, empty scheduler is created
     */
    public VenuePlanner() {

        this.venueIds = new HashSet<>();
        this.screeningSeating = new HashMap<>();

    }

    /**
     * constructor that creates a scheduler, with an initial
     * set of venues
     * @param venueIds ids of venues
     */
    public VenuePlanner(Collection<Long> venueIds) {

        this.venueIds = new HashSet<>();
        this.venueIds.addAll(venueIds);
        this.screeningSeating = new HashMap<>();

    }

    /**
     * adds an event and its venue to the planner. the venue is where
     * the event is hosted at.
     * @param event at event
     * @param venue the venue, the event is hosted at
     */
    public void addVenueToEvent(EntertainmentEvent event, EventVenue venue) {

        if(this.venueIds.contains(venue.getId()))
            this.screeningSeating.put(event, venue);

        // TODO to throw an exception
    }

    /**
     * remove the event and the associated venue from the planner
     * @param event an event to add
     * @param venue a venue the event is hosted at
     */
    public void removeVenueFromEvent(EntertainmentEvent event, EventVenue venue) {

        if(this.venueIds.contains(venue.getId()))
            this.screeningSeating.remove(event, venue);

        // TODO to throw an exception
    }

    /**
     * add a venue to the colleaction of available venues for events
     * in the planner.
     * @param venueId an id of a venue
     * @return true if added
     */
    public boolean addVenue(long venueId) {
        return this.venueIds.add(venueId);
    }


}
