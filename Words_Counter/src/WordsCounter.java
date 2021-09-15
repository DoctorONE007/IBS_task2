import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordsCounter {
    Map<String, Integer> dictionary = new TreeMap<>();
    String s = "";
    double count=0;
    public WordsCounter(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("[\\p{Punct}\\s0-9]+");

        while (scanner.hasNext()) {
            s = scanner.next().toLowerCase();
            count++;
            if (dictionary.containsKey(s))
                dictionary.put(s, dictionary.get(s) + 1);
            else
                dictionary.put(s, 1);
        }
        scanner.close();
        if (dictionary.isEmpty())
            System.out.println("Файл не содержит слов.");
        else {
            System.out.println("Отсортированный в алфавитном порядке список слов и частота с которой они встречаются:");
            for (Map.Entry<String, Integer> entry : dictionary.entrySet())
                System.out.println(entry.getKey() + " - " + entry.getValue() + " - "+String.format("%.2f", entry.getValue()*100/count)  + "%");
            printMaxCount();
        }


    }

    private void printMaxCount() {
        int max = 0;
        for (Map.Entry<String, Integer> entry : dictionary.entrySet())
            if (entry.getValue() > max)
                max = entry.getValue();

        System.out.println("Самые часто встречающиеся слова:");
        for (Map.Entry<String, Integer> entry : dictionary.entrySet())
            if (entry.getValue() == max)
                System.out.println(entry.getKey() + " - " + entry.getValue() + " - "+ String.format("%.2f", entry.getValue()*100/count) + "%");
    }
}
