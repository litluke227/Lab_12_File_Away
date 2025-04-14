import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

/**
 * @author wulft
 *
 * Collects user data and writes it as CSV to a file in the src folder.
 */
public class DataSaver {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> recs = new ArrayList<>();
        int idCounter = 1;
        boolean moreData = true;

        System.out.println("Welcome to the CSV Data Entry Program!");

        while (moreData) {

            String firstName = SafeInput.getNonZeroLenString(in, "Enter first name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter last name");
            String id = String.format("%06d", idCounter++);
            String email = SafeInput.getRegExString(in, "Enter email", "^\\S+@\\S+\\.\\S+$");
            int yearOfBirth = SafeInput.getRangedInt(in, "Enter year of birth", 1900, 2024);

            String record = String.join(", ", firstName, lastName, id, email, Integer.toString(yearOfBirth));
            recs.add(record);

            moreData = SafeInput.getYNConfirm(in, "Do you want to enter another record?");
        }

        String fileName = SafeInput.getRegExString(in, "Enter filename to save (no extension)", "^[\\w\\-. ]+$") + ".csv";

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath(), "src", fileName);

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (String rec : recs) {
                writer.write(rec);
                writer.newLine();
            }

            writer.close();
            System.out.println("Data file written successfully to: " + file.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
