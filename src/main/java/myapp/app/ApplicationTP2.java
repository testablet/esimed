package myapp.app;

import myapp.Stockable.EndOfListException;
import myapp.Stockable.Iterator;
import myapp.Stockable.List;
import myapp.tools.FileReader;
import myapp.tools.TextFileTools;

import java.io.IOException;

public class ApplicationTP2 {
    public void exo3(FileReader reader) throws EndOfListException
    {
        List<String> list = new List<>();
        TextFileTools textFileTools = new TextFileTools();
        list = textFileTools.readFile(reader);
        Iterator<String> iterator = new Iterator<String>(list);

        while(iterator.hasNext())
        {
            System.out.format("%s ", iterator.next());
        }
    }

    public void exo4(String path) throws IOException, EndOfListException {
        List<List<String>> listeDeListe = TextFileTools.readDirectory(path);
        Iterator<List<String>> iteratorListe = new Iterator<List<String >>(listeDeListe);
        while(iteratorListe.hasNext())
        {
            Iterator<String> iterator = new Iterator<String>(iteratorListe.next());
            while(iterator.hasNext())
            {
                System.out.format("%s ", iterator.next());
            }
        }
    }
}
