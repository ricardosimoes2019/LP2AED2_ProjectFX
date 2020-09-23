package university;


import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date>, Serializable {


    public int day;

    public int month;

    public int year;

    public int hour;

    public int minute;

  public Date() {
      Calendar gregCalendar = new GregorianCalendar();
      this.day = gregCalendar.get(Calendar.DAY_OF_MONTH);
      this.month = gregCalendar.get(Calendar.MONTH)+1;
      this.year = gregCalendar.get(Calendar.YEAR);
      this.hour = gregCalendar.get(Calendar.HOUR_OF_DAY);
      this.minute = gregCalendar.get(Calendar.MINUTE);
  }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int compareTo(Date d) {
        if (this.day == d.day && this.month == d.month && this.year == d.year) {
            return 0;
        }

        return this.beforeDate(d) ? -1 : 1;
    }

    public boolean beforeDate(Date d) {
        if (this.year < d.year) {
            return true;
        }
        if (this.year == d.year) {
            if (this.month < d.month)
                return true;
            if (this.month == d.month) {
                if (this.day < d.day) {
                    return true;
                }
                if (this.day == d.day) {
                    if (this.hour < d.hour) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public int differenceYears(Date d) {
        return Math.abs(this.year - d.getYear());
    }


    public boolean afterDate(Date d) {
        if (this.day == d.day && this.month == d.month && this.year == d.year && this.hour == d.hour && this.minute == d.minute) {
            return false;
        }
        return !beforeDate(d);
    }



  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }

  public int getMinute() {
    return minute;
  }

  public void setMinute(int minute) {
    this.minute = minute;
  }

  @Override
  public String toString() {
    return this.day + "/" +
            this.month + "/" +
            this.year + " " +
            this.hour + ":" +
            this.minute;
  }
}