package org.example.SystemDesign.lowLevelDesign.designBookMyShow.MovieTicketBooking;

import java.util.*;

public class MovieTicketBooking {
    public static void main(String[] args) {
        // Initialize controllers
        TheatreController theatreController = new TheatreController();
        MovieController movieController = new MovieController();

        // Add movies
        Movie movie1 = new Movie(1, "Inception", 120);
        Movie movie2 = new Movie(2, "Interstellar", 150);
        movieController.addMovie(movie1, "New York");
        movieController.addMovie(movie2, "New York");

        // Add theatres
        Theatre theatre1 = new Theatre(1, "123 Main St", "New York");
        Theatre theatre2 = new Theatre(2, "456 Broadway", "New York");
        theatreController.addTheatre(theatre1);
        theatreController.addTheatre(theatre2);

        // Add screens to theatres
        Screen screen1 = new Screen(1);
        Screen screen2 = new Screen(2);
        theatre1.addScreen(screen1);
        theatre1.addScreen(screen2);

        // Add seats to screens
        Seat seat1 = new Seat(1, 1, SeatCategory.REGULAR);
        Seat seat2 = new Seat(2, 1, SeatCategory.PREMIUM);
        screen1.addSeat(seat1);
        screen1.addSeat(seat2);

        // Add shows to theatres
        Show show1 = new Show(1, movie1, screen1, System.currentTimeMillis());
        Show show2 = new Show(2, movie2, screen2, System.currentTimeMillis() + 3600000);
        theatre1.addShow(show1);
        theatre1.addShow(show2);

        // Make a booking
        Payment payment = new Payment(1, "Completed");
        List<Seat> bookedSeats = Arrays.asList(seat1, seat2);
        Booking booking = new Booking(show1, bookedSeats, payment);

        // Print booking details
        System.out.println("Booking Details:");
        System.out.println("Movie: " + booking.getShow().getMovie().getName());
        System.out.println("Theatre: " + theatre1.getAddress());
        System.out.println("Seats: ");
        for (Seat seat : booking.getSeats()) {
            System.out.println("  - Seat ID: " + seat.getId() + ", Row: " + seat.getRow() + ", Category: " + seat.getSeatCategory());
        }
        System.out.println("Payment Status: " + booking.getPayment().getStatus());
    }
}

class User {
    private String id;
    private String name;
    private String email;
    private String phone;

    public User(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }
}

class Seat {
    private int id;
    private int row;
    private SeatCategory seatCategory;

    public Seat(int id, int row, SeatCategory seatCategory) {
        this.id = id;
        this.row = row;
        this.seatCategory = seatCategory;
    }

    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }
}

enum SeatCategory {
    REGULAR, PREMIUM, VIP;
}

class Screen {
    private int id;
    private List<Seat> seats;

    public Screen(int id) {
        this.id = id;
        this.seats = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }
}

class Show {
    private int showId;
    private Movie movie;
    private Screen screen;
    private long showTime;
    private List<Integer> bookedSeats;

    public Show(int showId, Movie movie, Screen screen, long showTime) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.showTime = showTime;
        this.bookedSeats = new ArrayList<>();
    }

    public int getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public long getShowTime() {
        return showTime;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public void bookSeat(int seatId) {
        bookedSeats.add(seatId);
    }
}

class Movie {
    private int id;
    private String name;
    private int duration;

    public Movie(int id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}

class Booking {
    private Show show;
    private List<Seat> seats;
    private Payment payment;

    public Booking(Show show, List<Seat> seats, Payment payment) {
        this.show = show;
        this.seats = seats;
        this.payment = payment;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Payment getPayment() {
        return payment;
    }
}

class Payment {
    private int id;
    private String status;

    public Payment(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class Theatre {
    private int id;
    private String address;
    private String city;
    private List<Screen> screens;
    private List<Show> shows;

    public Theatre(int id, String address, String city) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.screens = new ArrayList<>();
        this.shows = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public void addShow(Show show) {
        shows.add(show);
    }
}

class TheatreController {
    private Map<String, List<Theatre>> cityVsTheatre;
    private List<Theatre> allTheatres;

    public TheatreController() {
        this.cityVsTheatre = new HashMap<>();
        this.allTheatres = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre) {
        allTheatres.add(theatre);
        cityVsTheatre.computeIfAbsent(theatre.getCity(), k -> new ArrayList<>()).add(theatre);
    }

    public List<Theatre> getAllTheatres() {
        return allTheatres;
    }

    public List<Theatre> getTheatresByCity(String city) {
        return cityVsTheatre.getOrDefault(city, new ArrayList<>());
    }
}

class MovieController {
    private Map<String, List<Movie>> cityVsMovie;
    private List<Movie> allMovies;

    public MovieController() {
        this.cityVsMovie = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie, String city) {
        allMovies.add(movie);
        cityVsMovie.computeIfAbsent(city, k -> new ArrayList<>()).add(movie);
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public List<Movie> getMoviesByCity(String city) {
        return cityVsMovie.getOrDefault(city, new ArrayList<>());
    }
}

