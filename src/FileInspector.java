import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

/**
 * @author wulft
 * Uses the thread-safe NIO library to read a file and summarize its contents.
 */
public class FileInspector {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try {
            // Open the JFileChooser in the src directory
            File workingDirectory = new File(System.getProperty("user.dir") + File.separator + "src");
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String rec;
                while ((rec = reader.readLine()) != null) {
                    lineCount++;
                    charCount += rec.length();

                    String[] words = rec.trim().split("\\s+");
                    if (!rec.trim().isEmpty()) {
                        wordCount += words.length;
                    }

                    // Echo the line
                    System.out.printf("Line %4d: %s%n", lineCount, rec);
                }

                reader.close();
                System.out.println("\n--- File Summary ---");
                System.out.println("File Name        : " + selectedFile.getName());
                System.out.println("Total Lines      : " + lineCount);
                System.out.println("Total Words      : " + wordCount);
                System.out.println("Total Characters : " + charCount);

            } else {
                System.out.println("No file selected!!! ... exiting.\nRun the program again and select a file.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

