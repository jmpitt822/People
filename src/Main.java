import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by jeremypitt on 9/12/16.
 */
public class Main {

    public static List<Person> peopleList = new ArrayList<>();
    public static Map<String, List<Person>> peopleMap = new HashMap();


    public static void main(String[] args) throws FileNotFoundException{



        createMap();

        System.out.println(peopleMap);


    }

    public static void createMap() throws FileNotFoundException{
        File f = new File("people.csv");
        Scanner fileScanner = new Scanner(f);
        String line = fileScanner.nextLine();


        while (fileScanner.hasNextLine()) {



            line = fileScanner.nextLine();
            String[] columns = line.split(",");
            Person person = new Person(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]);
            String keyValue = person.getCountry();

            if (peopleMap.containsKey(keyValue)){
                peopleList = peopleMap.get(keyValue);
                peopleList.add(person);
            } else {
                peopleList.add(person);
                peopleMap.put(keyValue, peopleList);
            }
            peopleList = new ArrayList<>();

        }
    }
}
