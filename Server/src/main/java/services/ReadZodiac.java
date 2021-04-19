package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadZodiac {

    ReadZodiac()
    {

    }
    public Map<Map<String,String>,String> readZodiacSignsFormFile(String fileName) throws FileNotFoundException {
        Map<Map<String,String>,String> zodiacSigns=new HashMap<>();
        try{
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String beginDate = sc.next();
                String endDate = sc.next();
                Map<String,String> dates = new HashMap<>();
                dates.put(beginDate,endDate);
                String zodiacName = sc.next();
                zodiacSigns.put(dates, zodiacName);
            }
            sc.close();
            return zodiacSigns;
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return zodiacSigns;
    }

    public Map<ArrayList<String>,String> readChineseZodiacSignsFormFile(String fileName) throws FileNotFoundException {
        Map<ArrayList<String>,String> zodiacSigns = new HashMap<>();
        try{
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                Scanner line = new Scanner(sc.nextLine());
                String name = line.next();
                ArrayList<String> years = new ArrayList<>();
                while(line.hasNext()) {
                    String year = line.next();
                    years.add(year);
                }
                zodiacSigns.put(years, name);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return zodiacSigns;
    }

}
