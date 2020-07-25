import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class EventScheduler {


    private Map<LocalDate, Map<Long, LinkedList<EntertainmentEvent>>> screenings;

    public EventScheduler(){
        this.screenings = new HashMap<>();
    }


    public boolean addEvent(EntertainmentEvent event) {


        LocalDate screeningDate = event.getEventDate();

        if(!this.screenings.containsKey(screeningDate))
            this.screenings.put(screeningDate, this.createEmptySchedule());

        Map<Long, LinkedList<EntertainmentEvent>> screeningsOnDate = this.screenings.get(screeningDate);
        for(long auditoriumNumber: screeningsOnDate.keySet()) {
            if(this.insertEventInSchedule(event, screeningsOnDate.get(auditoriumNumber)))
                return true;
        }

        return false;
    }


    public boolean removeEvent(EntertainmentEvent event) {

        MovieScreening screeningToRemove = (MovieScreening) event;
        LocalDate screeningDate = screeningToRemove.getEventDate();

        if(!this.screenings.containsKey(screeningDate))
            return false;

        Map<Long, LinkedList<EntertainmentEvent>> screeningsOnDate = this.screenings.get(screeningDate);
        for(long auditoriumNumber: screeningsOnDate.keySet()) {
            if(this.removeEventInSchedule(screeningToRemove, screeningsOnDate.get(auditoriumNumber)))
                return true;
        }

        return false;
    }

    private boolean insertEventInSchedule(EntertainmentEvent screeningToAdd, LinkedList<EntertainmentEvent> screeningsOnDate) {

        if(screeningsOnDate.isEmpty()){
            screeningsOnDate.addFirst(screeningToAdd);
            return true;
        }

        if(this.canInsertBeforeEvent(screeningsOnDate.get(0), screeningToAdd)){
            screeningsOnDate.addFirst(screeningToAdd);
            return true;
        }
        for(int i = 0; i < screeningsOnDate.size() - 1; ++i) {

            if(canInsertBetweenEvent(screeningsOnDate.get(i),
                    screeningsOnDate.get(i + 1),
                    screeningToAdd)) {
                screeningsOnDate.add(i + 1, screeningToAdd);
                return true;

            }
        }
        if(this.canInsertAfterEvent(screeningsOnDate.getLast(), screeningToAdd)){
            screeningsOnDate.addLast(screeningToAdd);
            return true;
        }
        return false;

    }

    private boolean removeEventInSchedule(MovieScreening screeningToRemove, LinkedList<EntertainmentEvent> screeningsOnDate) {

        // TODO not working, will not remove
        return screeningsOnDate.remove(screeningToRemove);
    }


    private boolean canInsertBetweenEvent(EntertainmentEvent m1, EntertainmentEvent m2, EntertainmentEvent toInsert) {

        return this.canInsertAfterEvent(m1, toInsert) &&
                this.canInsertBeforeEvent(m2, toInsert);

    }

    private boolean canInsertBeforeEvent(EntertainmentEvent m, EntertainmentEvent toInsert) {

        LocalTime mStartTime = m.getStartTime();
        LocalTime toInsertStartTime = toInsert.getStartTime();
        int durationInMinutes = (int)(toInsert.getDurationInHours() * 60);

        return toInsertStartTime.plusMinutes(durationInMinutes).isBefore(mStartTime);
    }

    private boolean canInsertAfterEvent(EntertainmentEvent m, EntertainmentEvent toInsert) {

        LocalTime mStartTime = m.getStartTime();
        LocalTime toInsertStartTime = toInsert.getStartTime();
        int durationInMinutes = (int)(m.getDurationInHours() * 60);

        return mStartTime.plusMinutes(durationInMinutes).isBefore(toInsertStartTime);
    }

    private Map<Long, LinkedList<EntertainmentEvent>> createEmptySchedule(){
        // TODO think of a better name for method

        Map<Long, LinkedList<EntertainmentEvent>> map = new HashMap<>();
        for(long number: Auditorium.getAllAuditoriumNumbers())
            map.put(number, new LinkedList<>());

        return map;
    }


}
