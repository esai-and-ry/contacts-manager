import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Contact {

    private String name;
    private String number;

    public Contact (String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName () {
        return name;
    }

    public String getNumber(){
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String combine(){
        return name + "" + " | " + number;
    }
}
