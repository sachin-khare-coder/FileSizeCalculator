import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class FileProcessor {
    private File file;
    private double fileSizeKB;
    private int wordCount;
    private int charCount;
    private String longestWord;
    private double averageLength;

    public FileProcessor(File file) {
        this.file = file;
        processFile();
    }

    private void processFile() {
        try {
            fileSizeKB = file.length() / 1024.0;
            Scanner sc = new Scanner(file);
            int totalLength = 0;
            int totalWords = 0;
            int totalChars = 0;
            String longest = "";

            while (sc.hasNext()) {
                String word = sc.next();
                totalWords++;
                totalLength += word.length();
                totalChars += word.length();
                if (word.length() > longest.length()) {
                    longest = word;
                }
            }

            sc.close();

            this.wordCount = totalWords;
            this.charCount = totalChars;
            this.longestWord = longest.isEmpty() ? "N/A" : longest;
            this.averageLength = totalWords > 0 ? (double) totalLength / totalWords : 0.0;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getters for the GUI to display results
    public String getFileSize() {
        return new DecimalFormat("#.##").format(fileSizeKB) + " KB";
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getCharCount() {
        return charCount;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public String getAverageLength() {
        return new DecimalFormat("#.##").format(averageLength);
    }
}
