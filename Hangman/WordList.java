import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class WordList {

   List <String> words = new ArrayList<>();

    public WordList(String fileName) {
        try {
            File file = new File(fileName);
            Scanner text = new Scanner(file);

            while (text.hasNext()) {
                words.add(text.nextLine().toLowerCase());
            }
            text.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> giveWords(){
        return words;
    }
}