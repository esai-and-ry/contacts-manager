import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class contactList implements contactMenu {



    public static void main(String[] args) {

        contactList c = new contactList();

        c.menu();






    }





    private static void createDir(Path aDir) {
        if (Files.notExists(aDir)) {
            try {
                Files.createDirectory(aDir);
            } catch (IOException e) {
                System.out.println("Problems creating the directory");
                e.printStackTrace();
            }
        }
    }

    private static void createAndCheckFile(Path aFile) {
        if (Files.notExists(aFile)) {
            try {
                Files.createFile(aFile);
            } catch (IOException e) {
                System.out.println("Problems creating the file");
                e.printStackTrace();
            }
        }
    }

    public static void writeFile(Path aFile, List<String> aList){
        try {
            Files.write(aFile, aList);
//            Files.write(aFile, aList, StandardOpenOption.APPEND);
        } catch (IOException e){
            System.out.println("Problems writing in the file");
            e.printStackTrace();
        }
    }

    public static List<String> readFile(Path aFile, boolean print){
        List<String> contacts;
        try{
            contacts = Files.readAllLines(aFile);
            if(print == true){
                for (String line: contacts) {
                    System.out.println("Contact = " + line);
                }
                return null;
            }
            return contacts;
        } catch (IOException e){
            System.out.println("Problems reading the file");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void menu() {
        System.out.println("1. View Contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");

        System.out.println("Enter an option (1, 2, 3, 4 or 5):");

        Scanner scan = new Scanner(System.in);

        int userInput = Integer.parseInt(scan.nextLine());

        if(userInput == 1){
            String directory = "data";
            String filename = "contacts.txt";
            List<String> contactList = new ArrayList<>();

            contactList.add ("John | 0000000000");
            contactList.add ("Doe | 1111111111");

//        Where Folder is Gonna Live
            Path dataDirectory = Paths.get(directory);

            // where the file is gonna live
            Path numbersFilePath = Paths.get(directory, filename);

            createDir(dataDirectory);

            createAndCheckFile(numbersFilePath);

            writeFile(numbersFilePath, contactList);

            readFile(numbersFilePath, true);

        }
    }


}
