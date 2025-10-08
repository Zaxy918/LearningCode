import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class PokerGame {
    private static HashMap<Integer, String> pokerMap = new HashMap<>();
    private ArrayList<Integer> pokerIndex = new ArrayList<>();

    static {
        String[] color = { "S", "H", "C", "D" };
        String[] numbers = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };
        for (String n : numbers) {
            for (String c : color) {
                pokerMap.put(pokerMap.size(), c + n);
            }
        }
        pokerMap.put(pokerMap.size(), "Black Joker");
        pokerMap.put(pokerMap.size(), "Red Joker");
    }

    PokerGame() {
        pokerIndex.addAll(pokerMap.keySet());
        Collections.shuffle(pokerIndex);
        TreeMap<Integer, String> player1 = new TreeMap<>();
        TreeMap<Integer, String> player2 = new TreeMap<>();
        TreeMap<Integer, String> player3 = new TreeMap<>();
        TreeMap<Integer, String> lord = new TreeMap<>();
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer index = pokerIndex.get(i);
            if (i >= 51) {
                lord.put(index, pokerMap.get(index));
            } else if (i % 3 == 0) {
                player1.put(index, pokerMap.get(index));
            } else if (i % 3 == 1) {
                player2.put(index, pokerMap.get(index));
            } else {
                player3.put(index, pokerMap.get(index));
            }
        }
        System.out.println("Player 1: " + player1);
        System.out.println("Player 2: " + player2);
        System.out.println("Player 3: " + player3);
        System.out.println("Lord: " + lord);
    }
}
