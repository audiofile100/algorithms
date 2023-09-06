package core.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maps {

    public static void main(String[] args) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        // computes the value and inserts (which means you are referencing the current existing value)
        map.computeIfAbsent(1, key -> new ArrayList<>()).add(2);
        map.computeIfAbsent(1, key -> new ArrayList<>()).add(2);

        // returns a new value (which is not part of the hashmap yet)
        map.getOrDefault(2, new ArrayList<>()).add(2);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}
