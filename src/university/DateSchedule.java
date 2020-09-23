package university;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateSchedule implements Comparable<DateSchedule>, Serializable {

    public int hour;

    public int minute;

    //2 - segunda...
    public int day;


    public DateSchedule(){
        Calendar gregCalendar = new GregorianCalendar();
        this.hour = gregCalendar.get(Calendar.HOUR_OF_DAY);
        this.minute = gregCalendar.get(Calendar.MINUTE)+1;
        this.day = gregCalendar.get(Calendar.DAY_OF_WEEK);
    }

    public DateSchedule(int hour, int minute, int day) {
        this.hour = hour;
        this.minute = minute;
        this.day = day;
    }

    public DateSchedule(int hour, int minute, String day){
        this.hour = hour;
        this.minute = minute;
        this.day = dayStringtoint(day);
    }

    public int dayStringtoint(String day){
        if(day.equals("Segunda-Feira")){
            return 2;
        }else if(day.equals("Terça-Feira")){
            return 3;
        }else if(day.equals("Quarta-Feira")){
            return 4;
        }else if(day.equals("Quinta-Feira")){
            return 5;
        }else if(day.equals("Sexta-Feira")){
            return 6;
        }
        return 0;
    }

    /**
     * Função que altera de string para inteiro um dia, uma hora e os minutos
     * @return o inteiro do dia, hora e minuto
     */
    public int dateToInt(){
        String day = String.valueOf(this.day);
        String hour = String.valueOf(this.hour);
        String minute = String.valueOf(this.minute);

        String date = day + hour + minute;
        Integer intdate = Integer.parseInt(date);

        return intdate;
    }

    /**
     * Função que passa os dias passados como inteiros para strings relativamente ao dia da semana
     * @return dia da semana se for possível
     * @return null se não for nenhum dos casos especificados
     */
    public String dayToString() {
        switch (this.day) {
            case 2:
                return "Segunda-Feira";
            case 3:
                return "Terça-Feira";
            case 4:
                return "Quarta-Feira";
            case 5:
                return "Quinta-Feira";
            case 6:
                return "Sexta-Feira";
            default:
                return null;
        }
    }

    public int compareTo(DateSchedule d){
        if(this.day == d.day && this.hour == d.hour && this.minute == d.minute){
            return 0;
        }

        return this.beforeDateShedule(d) ? -1 : 1;
    }

    public boolean beforeDateShedule(DateSchedule d){
        if(this.day < d.day){
            return true;
        }
        if(this.day == d.day){
            if(this.hour < d.hour){
                return true;
            }
            if(this.hour == d.hour){
                if(this.minute < d.minute){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean afterDateShedule(DateSchedule d){
        if(this.day == d.day && this.hour == d.hour && this.minute == d.minute){
            return false;
        }
        return !beforeDateShedule(d);
    }

    @Override
    public String toString() {
        return hour + ":" + minute;
    }

    public int getDay() {
        return day;
    }
}
