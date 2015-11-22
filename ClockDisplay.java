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
    // Almacena el día, el mes y el año actuales
    private String fechaActual;
    // Permite elegir si estamos en formato 12 horas(true) o 24 horas(false)
    private boolean relojDe12Horas;
    // Guarda el día 
    private NumberDisplay dia;
    // Guarda el mes
    private NumberDisplay mes;
    //Guarda el año
    private NumberDisplay año;

    /**
     * Crea un objeto ClockDisplay con hora por defecto 00:00
     * Es posible elegir el modelo horario en el que el reloj
     * muestra la hora: si reloj12Horas es true entonces funciona 
     * como un reloj en formato de 12 horas; en caso contrario,
     * como un reloj de 24 horas. El reloj muestra el día, mes y año, 
     * poniendo por defecto el 20/11/15.
     */
    public ClockDisplay(boolean reloj12Horas)
    {
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        dia = new NumberDisplay(20);
        mes = new NumberDisplay(11);
        año = new NumberDisplay(15);
        fechaActual = dia.getDisplayValue() + "/" + mes.getDisplayValue() + "/" + año.getDisplayValue();
        relojDe12Horas = reloj12Horas;
        updateHoraActual();		
    }

    /** 
     * Crea un objeto ClockDisplay con la hora y los minutos dados
     * Es posible elegir el modelo horario en el que el reloj
     * muestra la hora: si reloj12Horas es true entonces funciona 
     * como un reloj en formato de 12 horas; en caso contrario,
     * como un reloj de 24 horas. El reloj muestra el día (30 días), mes (12 meses) y año (84 años hasta 2099).
     */
    public ClockDisplay (int horasX, int minutosX, boolean reloj12Horas,int diaX, int mesX, int añoX) 
    {
        horas =   new NumberDisplay(24);
        minutos = new NumberDisplay(60);	
        horas.setValue(horasX);	
        minutos.setValue(minutosX);
        dia = new NumberDisplay(30);
        mes = new NumberDisplay(12);
        año = new NumberDisplay(84);
        dia.setValue(diaX);
        mes.setValue(mesX);
        año.setValue(añoX);
        fechaActual = dia.getDisplayValue() + "/" + mes.getDisplayValue() + "/" + año.getDisplayValue();
        relojDe12Horas = reloj12Horas;
        updateHoraActual();   
    }

    /**
     * Fija la hora del reloj a la hora y los minutos dados y el día, mes y año
     */
    public void setTime(int horaY, int minutoY, int diaY, int mesY, int añoY)
    {
        horas.setValue(horaY);	
        minutos.setValue(minutoY);
        dia.setValue(diaY);
        mes.setValue(mesY);
        año.setValue(añoY);
        fechaActual = dia.getDisplayValue() + "/" + mes.getDisplayValue() + "/" + año.getDisplayValue();
        updateHoraActual();
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
        updateHoraActual();
    }

    /**
     * Actualiza el atributo horaActual siguiendo las normas de un
     * reloj de 12 horas.
     */
    public void updateHoraActual()
    {
    	if (relojDe12Horas) {
	 		String formato = "a.m";
		    int horaAhora = horas.getValue(); 
		    if (horaAhora >= 12){
		        formato = "p.m.";
		    }

		    if (horaAhora > 12) {
		        horaAhora = horaAhora - 12;
		    }
		    else if (horaAhora == 0) {
		        horaAhora = 12;
		    }
		    horaActual = horaAhora + ":" + minutos.getDisplayValue() + " " + formato;
		}
		else {
			horaActual = horas.getDisplayValue() + ":" + minutos.getDisplayValue();     
		}
    }
    
    /**
     * Método que permite alternar entre los modos del reloj
     */
    public void changeFormat()
    {
    	if (relojDe12Horas) {
    		relojDe12Horas = false;
    	}
    	else {
    		relojDe12Horas = true;
    	}
    	fechaActual = dia.getDisplayValue() + "/" + mes.getDisplayValue() + "/" + año.getDisplayValue();
    	updateHoraActual();	
    }	
}


