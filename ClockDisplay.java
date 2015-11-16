
/**
 * Write a description of class ClockDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplay
{
    // instance variables - replace the example below with your own
    private NumberDisplay horas;
    private NumberDisplay minutos;
    private String horaActual;

    /**
     * Constructor que fija la hora a "00:00" 
     */
    public ClockDisplay()
    {
        // initialise instance variables
        int horas = 00;
        int minutos = 00;
        horaActual = "0" + horas + ":0" + minutos;
       
    }

    /**
     * Constructor que representa las horas y los minutos a los que fijar la hora actual.
     */
    public ClockDisplay (int hours, int minutes)
    {
        int horas = hours;
        int minutos = minutes;
        
        if (hours < 10 && minutes < 10)
        {
            horaActual ="0" + horas + ":0" + minutos;
        }
        
        else if (hours > 10 && minutes > 10)
        {
            horaActual = horas + ":" + minutos;
        }
        
        else if (hours < 10 && minutes > 10)
        {
            horaActual = "0" + horas + ":" + minutos;
        }
        else if (hours > 10 && minutes < 10)
        {
            horaActual = horas + ":0" + minutos;
        }
    
}
}