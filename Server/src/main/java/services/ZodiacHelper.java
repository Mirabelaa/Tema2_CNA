package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.*;

public class ZodiacHelper {
    ZodiacHelper()
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

    public boolean isDateValid( String date){
        try{
            DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            dateFormat.parse(date);
            return true;
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
            return false;
        }
        catch (InputMismatchException ex)
        {
            System.out.println(ex);
            return false;
        }

        catch (DateTimeException ex)
        {
            System.out.println(ex);
            return false;
        }

    }


    public String findZodiacSign(String date) throws FileNotFoundException, ParseException {
        Map<Map<String,String>,String> zodiacSigns=new HashMap<>();
        try {
            zodiacSigns = readZodiacSignsFormFile("/facultate/an2/sem2/CNA/tema2/Server/src/main/resources/zodiac.txt");
        }
        catch(java.io.FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = dateFormat.parse(date);


        DateFormat dateFormat2 = new SimpleDateFormat("YYYY");
        String year = "/" + dateFormat2.format(date1).toUpperCase();

        for(Map.Entry<Map<String,String>,String> entry : zodiacSigns.entrySet())
        {
            Map<String,String> dates = entry.getKey();
            String name = entry.getValue();
            for(Map.Entry<String,String> entry1 : dates.entrySet()) {

                String b= entry1.getKey()+ year;

                Date begin = dateFormat.parse(b);

                String e= entry1.getValue() + year;

                Date end = dateFormat.parse(e);

                if (date1.after(begin) && date1.before(end) || date1.equals(begin) || date1.equals(end)) {
                    return name;
                }
            }


        }
        return "not found";
    }


    public String findChineseZodiacSign(String date) throws FileNotFoundException, ParseException {
        Map<ArrayList<String>, String> zodiacSigns = new HashMap<>();
        try {
            zodiacSigns = readChineseZodiacSignsFormFile("/facultate/an2/sem2/CNA/tema2/Server/src/main/resources/chineseZodiac.txt");
        } catch (java.io.FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String year = date.substring(date.length()-4);

        for (Map.Entry<ArrayList<String>, String> entry : zodiacSigns.entrySet()) {
            ArrayList<String> years = entry.getKey();
            String name = entry.getValue();
            for (String s : years) {

                if (year.equals(s)) {
                    return name;
                }
            }
        }
        return "not found";
    }
}
