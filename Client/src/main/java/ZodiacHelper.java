import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.InputMismatchException;

public class ZodiacHelper {

    ZodiacHelper(){

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
}
