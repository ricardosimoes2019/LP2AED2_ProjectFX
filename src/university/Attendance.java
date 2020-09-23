package university;

import java.io.Serializable;

public class Attendance implements Serializable {

  public Classroom classroom;

  public DateSchedule starthour;

  public DateSchedule endhour;

  public String day;


  public Attendance(Classroom classroom, DateSchedule starthour, DateSchedule endhour) {
    this.classroom = classroom;
    this.starthour = starthour;
    this.endhour = endhour;
    this.day = starthour.dayToString();
  }

  /**
   * Função que verifica se um horário de atendimento está entre duas datas passadas como argumentos
   * @param starthour hora de início recebida do atendimento a comparar
   * @param endhour hora de fim recebida do atendimento a comparar
   * @return true se o atendimento a comparar estiver entre as datas
   * @return false se o atendimento a comparar não estiver entre essas datas
   */
  public boolean betweendates(DateSchedule starthour, DateSchedule endhour){
    if(!((this.getEndhour().beforeDateShedule(starthour) || this.getEndhour().compareTo(starthour) == 0) ||
            (this.getStarthour().afterDateShedule(endhour) || this.getStarthour().compareTo(endhour) == 0))){
      return true;
    }

    return false;
  }

  @Override
  public String toString() {
    return "classroom=" + classroom.getName() +
            ", Início = " + starthour +
            ", Fim = " + endhour;
  }

  public Classroom getClassroom() {
    return classroom;
  }

  public void setClassroom(Classroom classroom) {
    this.classroom = classroom;
  }

  public DateSchedule getStarthour() {
    return starthour;
  }

  public void setStarthour(DateSchedule starthour) {
    this.starthour = starthour;
  }

  public DateSchedule getEndhour() {
    return endhour;
  }

  public void setEndhour(DateSchedule endhour) {
    this.endhour = endhour;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }
}