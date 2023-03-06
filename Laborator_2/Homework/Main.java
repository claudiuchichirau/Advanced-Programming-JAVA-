package laborator_2.homework;

/**
 * The main class that contains the main method.
 */
public class Main {

    /**
     * The main method of application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a "ProblemInstance" type object called "instance"
        ProblemInstance instance = new ProblemInstance();

        // create several "Location" type objects with their various attributes
        University universityUAIC = new University("Universitatea Alexandru Ioan Cuza", 47.173598, 27.574102, 27000);
        University universityAsachi = new University("Universitatea Tehnica Gheorghe Asachi din Iasi", 47.1670319, 27.5731605, 22000);
        PublicInstitution cityHallIasi = new PublicInstitution("Palatul Roznovanu", 47.1611312, 27.5842603, 3000);
        Mall palasMall = new Mall("Palas Mall", 47.166765, 27.586613, 270);
        Mall palasMallBun = new Mall("Palas Mall", 47.166765, 27.586613, 270);
        Airport iasiAirport = new Airport("Aeroportul International Iasi", 47.1782766, 27.6193838, 2);
        Airport otopeniAirport = new Airport("Aeroportul Henri Coanda Otopeni", 44.57115, 26.08415, 4);
        Airport timisoaraAirport = new Airport("Aeroportul Traian Vuia Timisoara", 45.8083, 21.3379, 3);
        Airport clujAirport = new Airport("Aeroportul International Cluj-Napoca", 46.7822, 23.6877, 1);
        Airport clujAirporta = new Airport("Aeroportul International Cluj-Napoca", 46.7822, 23.6877, 1);

            // System.out.println(universityUAIC);
            // System.out.println(cityHallIasi);


        // create several "Road" type objects with their various attributes
        Freeway iasiAirportOtopeniAirport = new Freeway(386, 130, iasiAirport, otopeniAirport, 56);
        Freeway otopeniAirportTimisoaraAirport = new Freeway(549, 130, otopeniAirport, timisoaraAirport, 56);
        CountyRoad uaicAsachiUniversity = new CountyRoad(4, 60, universityUAIC, universityAsachi, "Iasi");
        ExpressRoad palasMallClujAirport = new ExpressRoad(385, 100, palasMall, clujAirport, 2);
        ExpressRoad clujAirportPalasMall = new ExpressRoad(385, 100, palasMall, clujAirport, 2);
        ExpressRoad clujAirportTimisoaraAirport = new ExpressRoad(325, 120, clujAirport, timisoaraAirport, 3);


        // Display locations
        System.out.println("\nLocations:");
        for (Location loc : instance.getLocations()) {
            System.out.println(loc.getName());
        }

        // Display roads
        System.out.println("\nRoads:");
        for (Road road : instance.getRoads()) {
            System.out.println(road.getLocationStart().getName() + " -> " + road.getLocationEnd().getName() + " (" + road.getLength() + " km)");
        }

        System.out.println("\n");

        System.out.println(ProblemInstance.canTravelBetween(timisoaraAirport, palasMall));
        System.out.println(ProblemInstance.canTravelBetween(palasMall, universityUAIC));

    }
}
