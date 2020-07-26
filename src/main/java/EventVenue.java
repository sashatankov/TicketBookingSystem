/**
 * an abstract place to have an event in
 */
public interface EventVenue {

    /**
     *
     * @return id of the venue
     */
    long getId();

    /**
     *
     * @return a number of people the venue can contain
     */
    long capacity();

    /**
     *
     * @return the name of the venue
     */
    String getName();
}
