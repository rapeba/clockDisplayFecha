
/**
 * Write a description of class ClockDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplay
{
    // Guarda la hora
	private NumberDisplay horas;
    // Guarda los minutos
	private NumberDisplay minutos;
    // Almacena la hora actual con 5 caracteres
	private String horaActual;
	// Hora de mañana
	private String am;
	// Hora de tarde
	private String pm;
	// hora mañana o tarde
	private boolean ampm;
	

	/**
	 * Crea un objeto ClockDisplay con horario 12 horas
	 */
	public ClockDisplay()
	{
		horas = new NumberDisplay(13);
		minutos = new NumberDisplay(60);
		am = "am";
		pm ="pm";
		horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();		
		
		
	}
	
	/** 
	 * Crea un objeto ClockDisplay con la hora y los minutos dados
	 */
	public ClockDisplay (int horasX, int minutosX)
	{
		horas =   new NumberDisplay(13);
		minutos = new NumberDisplay(60);	
		horas.setValue(horasX);	
		minutos.setValue(minutosX);
		horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();		
	}
	
	/**
	 * Fija la hora del reloj a la hora y los minutos dados
	 */
	public void setTime(int horaY, int minutoY)
	{
		horas.setValue(horaY);	
		minutos.setValue(minutoY);
		horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
	}
	
	/**
	 * Devuelve la hora del reloj como una cadena de 5 caracteres
	 */
	 public String getTime()
	 {
		return horaActual;
	 }
	 
	 /**
	  * Hace avanzar la hora 1 minuto
	  */
	 public void timeTick()
	 {
		minutos.increment();
		if ( minutos.getValue() == 0) {
			horas.increment();
		}
		horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
	 }
	 
	 /**
	  * Método que crea un reloj formato doce horas
	  */
	 public void relojDoceHoras(boolean horario, int horasX, int minutosX)
	 {
	 horario = ampm;
     horas =   new NumberDisplay(13);
     minutos = new NumberDisplay(60);	
     horas.setValue(horasX);	
	 minutos.setValue(minutosX);
	 
	 if (ampm == true)
	 {
	     horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + "am";
	 }  
	     else
	     {
	     
	        horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue() + "pm";
	     
	 
	     }
	 }
}
