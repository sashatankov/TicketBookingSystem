# Ticket Booking System
## Abstract
This is an application for booking movie ticket.
The application also support scheduling movie screenings.
You can add and remove movies and screenings from the movie theater.
For each screening you can plan the seating in the auditorium.
The software is built as a client-server application.
the client has a CLI, he can interact with(UI coming soon...).

# Description

## Interfaces
 - EntertainmentEvent - an abstract cultural event, movie, ballgame, etc.
 - EventEvent - an abstract place that hosts an event, theater, stadium, etc.
 - Ticket - an abstract ticket to an event
 
## Classes
### Data
 - Movie - a  movie that is screening in the movie theater, contains data of the movie
 - MovieScreening - a screening of a particular movie with date and time
 - Auditorium - an auditorium for a **specific** movie screening,
 contains the data the empty and occupied seats.
 - MovieTicket - a movie ticket containing the data of the movie screening.
 
### Controllers and Models
 - MovieScreeningController - a controller class, responsible for the schedule of movie screenings
 - MovieAuditoriumController - a controller class, responsible for assigning auditoriums to movie screenings
 - MovieTicketBookingController - a controller class, responsible for booking a movie ticket.
 - MovieTheaterModel - a complete model of the movie theater with screenings and tickets.
 
### Schedulers
 - EventScheduler - a generic scheduler for events. for every (date, venue) pair, the scheduler has
 a linked list of events that occur on that date an in that partucular venue.
 The list is ordered by their start and end time, in order to avoid collisions
 between events.
 - VenueScheduler - a generic scheduler events. for every the sceduler assigns
 a venue to host that event.
 
### Client/Server
 - MovieTheaterClient - a class from which the user interacts with the system.
 - MovieTheaterServer - a server class that holds the model fir the movie theater.
 serves clients that want to book tickets.



