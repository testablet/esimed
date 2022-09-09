package myapp.app;

import myapp.tools.FileReader;
import myapp.tools.TextFileTools;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationHelloWorld app = new ApplicationHelloWorld();
        app.sayHello();

        FileReader fileReader = new FileReader(args[0]);
        ApplicationTP1 applicationTP1 = new ApplicationTP1();

        int nombreDeAl = applicationTP1.countAl(fileReader);
        int nombreDeMots = applicationTP1.countWords(fileReader);
        System.out.format("Nombre suite de 'al' : ",nombreDeAl);
        System.out.format("Nombre de mots : ",nombreDeMots);

        for(ApplicationTP1.Occurrences occurrences : applicationTP1.countPunctuations(fileReader))
        {
            System.out.format("%c : %d\n", occurrences.getCharacter(), occurrences.getCount());
        }

        fileReader = new FileReader(args[0]);
        nombreDeMots = TextFileTools.countWords(fileReader, "et");

        System.out.format("il y a %d fois %s dans le texte", nombreDeMots, "et");

        applicationTP1.DirectoryCount("textes");
        System.out.format("------------\n");
        applicationTP1.displayFilesWithWord("textes","conformément");
    }
}
