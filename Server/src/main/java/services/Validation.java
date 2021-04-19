package services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.InputMismatchException;

public class Validation {

    private static String date_format="dd/MM/yyyy";

    public boolean isDateValid( String date){
        try{
            DateFormat dateFormat= new SimpleDateFormat(date_format);
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
}

