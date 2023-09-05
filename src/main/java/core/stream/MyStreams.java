package core.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyStreams {

    public Map<Integer, Integer> frequencyMap(int[] nums) {

        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), val -> 1, (oldVal, newVal) -> oldVal+1));
    }

    public List<Integer> flatMapping(List<List<Integer>> nums) {

        return nums.stream()
                .flatMap(Collection::stream)
                .toList();
    }

    public static void main(String[] args) {

        MyStreams ms = new MyStreams();

        var result = ms.frequencyMap(new int[] { 1, 2, 3, 2, 3, 4, 5, 6, 4, 6, 8, 3 });

        System.out.println(result);
        System.out.println(result instanceof HashMap<Integer, Integer>);

        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(List.of(4, 5, 6));
        listOfLists.add(List.of(1, 7, 2, 9));
        listOfLists.add(List.of(2, 6, 5, 0));

        var flatList = ms.flatMapping(listOfLists);

        System.out.println(flatList);
    }
}
