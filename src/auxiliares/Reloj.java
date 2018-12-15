/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reloj {
    
    private static Date currentTime;
    private final Calendar calendar = Calendar.getInstance();
    
    public Date convertToDate(String format){
        Date timeDate=null;
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            timeDate = hourFormat.parse(format);
        } catch (ParseException ex) {
            Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
        }return timeDate;
    }
    
    public void initTime() {
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        String hour = "13:00:00";
        try {
            currentTime = hourFormat.parse(hour);
        } catch (ParseException ex) {
            Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String convertToString(Date date){
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        return hourFormat.format(date);
    }
    
    public void changeTime(){
        calendar.setTime(currentTime);
        calendar.add(Calendar.HOUR, 2);
        currentTime = calendar.getTime();
    }
    
    public String getCurrentTime(){
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        return hourFormat.format(currentTime);
    }    
}
