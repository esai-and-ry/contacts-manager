import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class contactList {

    public static void main(String[] args) {

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
        List<String> lines;
        try{
            lines = Files.readAllLines(aFile);
            if(print == true){
                for (String line: lines) {
                    System.out.println("Contact = " + line);
                }
                return null;
            }
            return lines;
        } catch (IOException e){
            System.out.println("Problems reading the file");
            e.printStackTrace();
            return null;
        }
    }

}
