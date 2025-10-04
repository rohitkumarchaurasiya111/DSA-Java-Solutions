package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

//Find Itinerary from Tickets
// "Chennai" -> "Bengaluru"
// "Mumbai" -> "Delhi"
// "Goa" -> "Chennai"
// "Delhi" -> "Goa"
// "Mumbai" -> "Delhi" -> "Goa" -> "Chennai" -> "Benagluru"

public class Find_Itineary_for_ticket {
    public static void find_route(HashMap<String, String> from_to) {
        HashMap<String, String> to_from = new HashMap<>();
        for (String from : from_to.keySet()) {
            String to = from_to.get(from);
            to_from.put(to, from);
        }

        String starting_point = "";
        // We do this as starting point can never be in to
        for (String from : from_to.keySet()) {
            if (!to_from.containsKey(from)) {
                starting_point = from;
            }
        }

        if (starting_point == null) {
            System.out.println("Starting Point is Not Present");
            return;
        }

        ArrayList<String> arr = new ArrayList<>();
        arr.add(starting_point);
        for (int i = 0; i < from_to.size(); i++) {
            starting_point = from_to.get(starting_point);
            if (starting_point == null) {
                break;
            }
            arr.add(starting_point);
        }
        System.out.println(arr);
    }

    public static void main(String[] args) {
        HashMap<String, String> ticket = new HashMap<>();
        ticket.put("Chennai", "Bangalore");
        ticket.put("Mumbai", "Delhi");
        ticket.put("Goa", "Chennai");
        ticket.put("Delhi", "Goa");

        find_route(ticket);
    }
}
