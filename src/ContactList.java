import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ContactList {
    private static String directory;
    private static String filename;

    public static void main(String[] args) throws IOException {
        Scanner scan;

        directory = "data";
        filename = "contacts.txt";
        List<String> contactList = new ArrayList<>();
//

//
////        Where Folder is Gonna Live
        Path dataDirectory = Paths.get(directory);
//
//            // where the file is gonna live
        Path contactsFilePath = Paths.get(directory, filename);
//
        createDir(dataDirectory);

        createAndCheckFile(contactsFilePath);

        writeFile(contactsFilePath, contactList);

        readFile(contactsFilePath, true);

        menu(contactsFilePath);

        addContact(contactsFilePath);

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

    public static void addContact(Path aFile) throws IOException {
        Scanner scan = new Scanner(System.in);
        String newName;
        String newNumber;
        System.out.println("Enter New Contact Name: ");
        newName = scan.nextLine();
        System.out.println("Enter New Contact Number: ");
        newNumber = scan.nextLine();
        Contact newContact = new Contact(newName, newNumber);
        Files.write(
                aFile,
                Arrays.asList(newContact.combine()), // list with one item
                StandardOpenOption.APPEND
        );
    }





//    private static List<String> searchItem(Path aFile){
//        Scanner scan = new Scanner(System.in);
//        String search;
//        System.out.println("Search by name: ");
//        String input = scan.nextLine();
//        search = input;
//        List<String> tempList = new ArrayList<>();
//
//        try {
//            List<String> lines = Files.readAllLines(aFile);
//            for (String line : lines) {
//                if(line.contains(search)){
//                    continue;
//                }
//                tempList.add(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return tempList;
//    }



    public static void menu(Path aFile) throws IOException {
        System.out.println("1. View Contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");

        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
        Scanner scan = new Scanner(System.in);

        int userInput = Integer.parseInt(scan.nextLine());
        if(userInput == 1){
            readFile(aFile, true);
            menu(aFile);
        } else if (userInput == 2) {
            addContact(aFile);
            readFile(aFile, true);
            menu(aFile);
        } else if (userInput == 3) {




        }

    }

}













