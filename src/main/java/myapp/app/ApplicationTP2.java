package myapp.app;

import myapp.Stockable.EndOfListException;
import myapp.Stockable.Iterator;
import myapp.Stockable.List;
import myapp.tools.FileReader;
import myapp.tools.TextFileTools;

import java.io.IOException;

public class ApplicationTP2 {
    public void exo3(FileReader reader) throws IOException, EndOfListException {
        List<String> wordList = TextFileTools.readFile(reader);
        wordList.sort(String::compareToIgnoreCase);
        Iterator<String> it = new Iterator<>(wordList);
        while (it.hasNext()) {
            System.out.format("%s ", it.next());
        }
    }

    public void exo4(String path) throws IOException, EndOfListException  {
        Iterator<List<String>> mainIt = new Iterator<>(TextFileTools.readDirectory(path));
        while (mainIt.hasNext()) {
            System.out.println("-------------------------------------------");
            Iterator<String> wordIt = new Iterator<>(mainIt.next());
            while (wordIt.hasNext()) {
                System.out.format("%s ", wordIt.next());
            }
            System.out.println();
        }
    }
}
