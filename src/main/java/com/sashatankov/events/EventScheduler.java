package com.sashatankov.events;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * an Event Scheduler for entertainment events.
 * Each event is hosted in an Event Venue. When an event is added
 * to the schedule, the scheduer looks for an available venue.
 * For each venue, the scheduler look at the start time the the duration
 * of the event and checks if the event does not conflict with other
 * event in a venue. if not, the event is added to the schedule.
 */
public class EventScheduler {


    private Map<LocalDate, Map<EventVenue, LinkedList<EntertainmentEvent>>> screenings;
    private Set<EventVenue> eventVenues;

    /**
     * a Constructor for tha class, creates a scheduler with empty schedule
     */
    public EventScheduler(){
        this.screenings = new HashMap<>();
    }

    /**
     * adds an event to the schedule.
     * @param event an event to add to the schedule
     * @return true, if event added to the scheduler
     */
    public boolean addEvent(EntertainmentEvent event) {


        LocalDate screeningDate = event.getEventDate();
        if(!this.screenings.containsKey(screeningDate))
            this.screenings.put(screeningDate, this.createEmptyVenueSchedule());

        Map<EventVenue, LinkedList<EntertainmentEvent>> screeningsOnDate = this.screenings.get(screeningDate);
        for(EventVenue venue: screeningsOnDate.keySet()) {
            if(this.insertEventInSchedule(event, screeningsOnDate.get(venue)))
                return true;
        }
        return false;
    }

    /**
     * removes event from the schedule
     * @param event an event to remove
     * @return true, if removed successfully. false, otherwise
     */
    public boolean removeEvent(EntertainmentEvent event) {


        LocalDate screeningDate = event.getEventDate();
        if(!this.screenings.containsKey(screeningDate))
            return false;

        Map<EventVenue, LinkedList<EntertainmentEvent>> screeningsOnDate = this.screenings.get(screeningDate);
        for(EventVenue venue: screeningsOnDate.keySet()) {
            if(this.removeEventInSchedule(event, screeningsOnDate.get(venue)))
                return true;
        }

        return false;
    }

    /**
     * adds venue to a collection of venues in the schedule
     * @param venue a venue to add
     * @return true, if added successfully, false otherwise.
     */
    public boolean addVenue(EventVenue venue) {
        return this.eventVenues.add(venue);
    }

    /**
     * removes a venue from a collection of venues in the schedule
     * @param venue a venue to remove
     * @return true, if removed successfully. false, otherwise.
     */
    public boolean removeVenue(EventVenue venue) {
        return this.eventVenues.remove(venue);
    }

    /**
     * inserts an event in a schedule of a particular venue
     * in a particular date.
     * @param eventToAdd an event
     * @param venueEventsOnDate a schedule of a venue on a date as linked list of event
     * @return
     */
    private boolean insertEventInSchedule(EntertainmentEvent eventToAdd, LinkedList<EntertainmentEvent> venueEventsOnDate) {

        EntertainmentEvent first, second;
        if(venueEventsOnDate.isEmpty()){
            venueEventsOnDate.addFirst(eventToAdd);
            return true;
        }

        if(this.canInsertEventBefore(venueEventsOnDate.get(0), eventToAdd)){
            venueEventsOnDate.addFirst(eventToAdd);
            return true;
        }

        for(int i = 0; i < venueEventsOnDate.size() - 1; ++i) {
            first = venueEventsOnDate.get(i);
            second = venueEventsOnDate.get(i + 1);

            if(canInsertEventBetween(first, second, eventToAdd)) {
                venueEventsOnDate.add(i + 1, eventToAdd);
                return true;
            }
        }

        if(this.canInsertEventAfter(venueEventsOnDate.getLast(), eventToAdd)){
            venueEventsOnDate.addLast(eventToAdd);
            return true;
        }
        return false;

    }

    /**
     * removes an event from a schedule of a venue on a particular date.
     * @param eventToRemove an event
     * @param venueEventsOnDate a schedule of a venue on a date as linked list of event
     * @return
     */
    private boolean removeEventInSchedule(EntertainmentEvent eventToRemove, LinkedList<EntertainmentEvent> venueEventsOnDate) {
        return venueEventsOnDate.remove(eventToRemove);
    }

    /**
     * the method checks if an event can be inserted between 2 events
     * by checking that the start time of toInsert is after the end time
     * of m1. and the end time of to Insert is before the start time of m2.
     * The assumption is that all 3 events are on the same date
     * @param m1 an event to check against
     * @param m2 an event to check against
     * @param toInsert an event to check on
     * @return true, if toInsert can be inserted between m1 and m2
     */
    private boolean canInsertEventBetween(EntertainmentEvent m1, EntertainmentEvent m2, EntertainmentEvent toInsert) {
        return this.canInsertEventAfter(m1, toInsert) && this.canInsertEventBefore(m2, toInsert);
    }

    /**
     * the method checks if an event can be inserted before an event
     * by checking if the end time of toInsert is before the start time of m
     * the assumption is that both events are on the same date
     * @param m an event to check against
     * @param toInsert an event to check on
     * @return true, if toInsert can be inserted before m
     */
    private boolean canInsertEventBefore(EntertainmentEvent m, EntertainmentEvent toInsert) {

        LocalTime mStartTime = m.getStartTime();
        LocalTime toInsertStartTime = toInsert.getStartTime();

        int durationInMinutes = (int)(toInsert.getDurationInHours() * 60);
        return toInsertStartTime.plusMinutes(durationInMinutes).isBefore(mStartTime);
    }

    /**
     * the method checks if an event can be inserted after an event
     * by checking if the end time of toInsert is before the start time of m.
     * the assumption is that both events are on the same date
     * @param m an event to check against
     * @param toInsert an event to check on
     * @return true, if toInsert can be inserted after m
     */
    private boolean canInsertEventAfter(EntertainmentEvent m, EntertainmentEvent toInsert) {

        LocalTime mStartTime = m.getStartTime();
        LocalTime toInsertStartTime = toInsert.getStartTime();

        int durationInMinutes = (int)(m.getDurationInHours() * 60);
        return mStartTime.plusMinutes(durationInMinutes).isBefore(toInsertStartTime);
    }

    /**
     *
     * @return a empty schedule for every venue for an arbitrary date
     */
    private Map<EventVenue, LinkedList<EntertainmentEvent>> createEmptyVenueSchedule(){

        Map<EventVenue, LinkedList<EntertainmentEvent>> map = new HashMap<>();
        for(EventVenue venue: this.eventVenues)
            map.put(venue, new LinkedList<>());
        return map;
    }


}
