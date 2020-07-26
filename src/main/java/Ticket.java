/**
 * an abstract Ticket to an abstract event
 */
public interface Ticket {

    /**
     *
     * @return the price of the ticket
     */
    double getPrice();

    /**
     *
     * @return th event object, the ticket is for
     */
    EntertainmentEvent getEvent();

    /**
     *
     * @return a string that contains the details of the event
     */
    String getEventDetails();
}
