import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        File file = new File(path);
        if (!file.isFile())
            System.out.println("По данному пути файла не существует");
        else
            new WordsCounter(file);

    }


}
