package myapp.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import myapp.tools.ProcessFile;

public class TextFileTools {

    public static String readWord(FileReader reader) {
        StringBuilder stringBuilder = new StringBuilder();
        if (reader.isEndOfFile()) return null;
        int charCount = 0;
        char c = reader.readChar();
        while ((' ' != c) &&
                ('.' != c) &&
                (',' != c) &&
                (';' != c) &&
                (':' != c) &&
                ('"' != c) &&
                ('(' != c) &&
                (')' != c) &&
                ('*' != c) &&
                ('-' != c) &&
                ('\n' != c) &&
                ('\r' != c)) {
            stringBuilder.append(c);
            charCount = charCount + 1;
            if (reader.isEndOfFile()) { break; }
            c = reader.readChar();
        }
        if (charCount > 0) {
            return stringBuilder.toString();
        }
        return readWord(reader);
    }

    public static int countWords(FileReader reader, String mot)
    {
        int compteurNombreMots = 0;
        while(!reader.isEndOfFile())
        {
            if(mot.equals(readWord(reader)))
            {
                compteurNombreMots++;
            }
        }
        return compteurNombreMots;
    }

    public static void walkDirectory(String NomRepertoire, ProcessFile processFile) throws IOException {
        Files.walk(Paths.get(NomRepertoire))
                .filter(Files::isRegularFile)
                .forEach(processFile::process);
    }
}
