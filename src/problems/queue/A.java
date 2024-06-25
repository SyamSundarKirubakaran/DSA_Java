package problems.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SYAM K
 * @problem : Circular tour that visit all gasoline stations before running out of gas.
 */
public class A {

    // can be done in-place without using queue
    private static Queue<PetrolPump> queue = new LinkedList<>();

    public static void main(String[] args) {
        PetrolPump[] arr = {new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)};

        int start = printTour(arr, arr.length);

        System.out.println(start == -1 ? "No Solution" : "Start @ " + start);
    }

    static int printTour(PetrolPump[] arr, int n) {
        int start = 0;
        int end = 1;
        int currPetrol = arr[start].petrol - arr[start].distance;
        queue.add(arr[start]);
        while (end != start || currPetrol < 0) {
            while (currPetrol < 0 && start != end) {
                // remove from start
                PetrolPump removedStart = queue.remove();
                currPetrol = currPetrol + removedStart.distance - removedStart.petrol;
                start = (start + 1) % n;
                if (start == 0)
                    return -1;
            }
            currPetrol = currPetrol - arr[end].distance + arr[end].petrol;
            queue.add(arr[end]);
            end = (end + 1) % n;
        }
        return start;
    }

    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

}
