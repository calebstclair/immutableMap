import immutable.*;

import java.util.List;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map map = EmptyNode.instance;
        String nextWord = scanner.next();
        while (!nextWord.equals("quit")){
            if (map.getValue(nextWord) == null){
                map = map.setValue(nextWord, 1);
            }
            else {
                map = map.setValue(nextWord, map.getValue(nextWord) + 1);
            }
            nextWord = scanner.next();
        }

        System.out.println("Map has size " + map.size() + " with depth " + map.depth() + "\n");
        List<Map.Entry> listOfNodes = map.entries();
        for (Map.Entry currentNode : listOfNodes) {
            System.out.println(currentNode.getKey() + ": " + currentNode.getValue());
        }
    }
}