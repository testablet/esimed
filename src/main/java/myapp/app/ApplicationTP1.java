package myapp.app;

import myapp.tools.FileReader;
import myapp.tools.ProcessFile;
import myapp.tools.TextFileTools;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;

public class ApplicationTP1 {

    //Exercice 2 : Fonctions, Instanciations, Tests Unitairee
    public Character readChar(FileReader fileReader)
    {
        if(fileReader.isEndOfFile())
        {
            return null;
        }
        else
        {
            return fileReader.readChar();
        }
    }

    //Exercice 3 : Variables, Structures de control
    public int countAl (FileReader fileReader)
    {
        int nombreAl = 0;

        while (!fileReader.isEndOfFile())
        {
            while ((!fileReader.isEndOfFile()) && fileReader.readChar() == 'a')
            {
                if (!fileReader.isEndOfFile() && fileReader.readChar() == 'l')
                {
                    nombreAl++;
                }
            }
        }
        return nombreAl;
    }

    //Exercice 4 : Boucles Imbriquées

    //Méthode 1
    /*public int countWords (FileReader fileReader)
    {
        int nombreMots = 0;

        char espace = ' ';
        char point = '.';
        char deuxPoints = ':';
        char pointVirgule = ';';
        char virgule = ',';
        char retour = '\n';
        char lettre = fileReader.readChar();
        char caracterePrecedent = 0;

        while (!fileReader.isEndOfFile()
                || lettre == espace
                || lettre == pointVirgule
                || lettre == point
                || lettre == deuxPoints
                || lettre == virgule
                || lettre == retour )
        {
            caracterePrecedent = lettre;
            if(!fileReader.isEndOfFile()
                    || caracterePrecedent == espace
                    || caracterePrecedent == pointVirgule
                    || caracterePrecedent == point
                    || caracterePrecedent == deuxPoints
                    || caracterePrecedent == virgule
                    || caracterePrecedent == retour)
            {
                nombreMots++;
            }
        }
        return nombreMots;
    }*/
    //Méthode 2
    public int countWords(FileReader fileReader)
    {
        int nombreMots = 0;
        int nombreCharactereMot = 0;
        char caractere = 0;
        while(!fileReader.isEndOfFile())
        {
            caractere = fileReader.readChar();
            while(caractere != '\n'
                    && caractere != '.'
                    && caractere != ','
                    && caractere != ':'
                    && caractere != ';'
                    && caractere != ' '
                    && caractere != '\r')
            {
                nombreCharactereMot++;
                if(fileReader.isEndOfFile())
                {
                    break;
                }
                caractere = fileReader.readChar();
            }
            if(nombreCharactereMot > 0)
            {
                nombreMots++;
                nombreCharactereMot = 0;
            }
        }
        return nombreMots;
    }
    //Exercice 5 : Tableaux
    public String[] read5Words(FileReader reader)
    {
        String[] words = new String[5];
        int wordCount = 0;
        String word;
        while ((word = TextFileTools.readWord(reader)) != null) {
            words[wordCount] = word;
            wordCount = wordCount + 1;
            if (wordCount == 5) { break; }
        }
        return words;
    }
    //Exercice 6 : Classe Métier
    public static class Occurrences {
        //Variable membre
        private char character;
        private int count;

        //Constructeurs
        public Occurrences(char character, int count) {
            this.character = character;
            this.count = count;
        }

        public Occurrences(char character) {
            this.character = character;
        }

        public int incrementCount() {
            count++;
            return count;
        }

        //HashCode & Equals
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + character;
            result = prime * result + count;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Occurrences other = (Occurrences) obj;
            if (character != other.character)
                return false;
            if (count != other.count)
                return false;
            return true;
        }

        // Accesseurs
        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
    public Occurrences[] countPunctuations(FileReader fileReader)
    {
        Occurrences point = new Occurrences('.');
        Occurrences virgule = new Occurrences(',');
        Occurrences deuxPoints = new Occurrences(':');
        Occurrences pointVirgule = new Occurrences(';');
        //point.incrementCount();
        while(!fileReader.isEndOfFile())
        {
            char c=fileReader.readChar();
            switch (c)
            {
                case '.':
                    point.incrementCount();
                    break;
                case ',':
                    virgule.incrementCount();
                    break;
                case ':':
                    deuxPoints.incrementCount();
                    break;
                case ';':
                    pointVirgule.incrementCount();
                    break;
            }
        }
        Occurrences compteur[]={point,virgule,deuxPoints,pointVirgule};
        return compteur;
    }

    public class DisplayFileName implements ProcessFile {
        @Override
        public void process(Path chemin) {
            // TODO Auto-generated method stub
            System.out.println(chemin);
        }
    }

    public void DirectoryCount (String nameRun) throws IOException
    {
        DisplayFileName name = new DisplayFileName(){};
        TextFileTools.walkDirectory(nameRun , name);
    }
    public void displayFilesWithWord(String nameRun, String word) throws IOException {
        TextFileTools.walkDirectory(nameRun, (Path path) -> {
            if (TextFileTools.countWords(new FileReader(path.toString(),
                            Charset.forName("Windows-1252")),
                    word) >= 1) {
                System.out.println(path);
            }
        });
    }
}
