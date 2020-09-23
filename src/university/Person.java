package university;


import algs4.SeparateChainingHashST;

import java.io.Serializable;

public abstract class Person implements Serializable {

  private String name;

  private String address;

  private Date birth;

  private String email;

  private Date registration;

  private SeparateChainingHashST<String, CurricularUnit> cUnits = new SeparateChainingHashST<>();

  //String = Turma id
  private SeparateChainingHashST<String, Class> aClass = new SeparateChainingHashST<>();

  private RedBlackBST_AED2<Integer, Lesson> schedule = new RedBlackBST_AED2<>();


  public Person(String name, String address, Date birth, String email, Date registration) {
    this.name = name;
    this.address = address;
    this.birth = birth;
    this.email = email;
    this.registration = registration;
  }


  public int age() {

    Date d = new Date();
    int years = this.birth.differenceYears(d);
    if(this.birth.getMonth() > d.getMonth()){
      years--;
    }else if(this.birth.getMonth() == d.getMonth()){
      if(this.birth.getDay() > d.getDay()){
        years--;
      }
    }
    return years;
  }

  /**
   * Alterar nome de Person
   * @param newName
   */
  public void changeName(String newName){
    this.setName(newName);
  }

  /**
   * Alterar email de person
   * @param newEmail
   */
  public void changeEmail(String newEmail){
    this.setEmail(newEmail);
  }

  /**
   * Função que verifica se um Person (teacher ou student) está ocupado na data recebida
   * @param dateNow data a verifica
   * @return true se estiver ocupado
   * @return false se não estiver ocupado
   */
  public boolean busy(DateSchedule dateNow){
    if(this instanceof Student) {
      for (Integer dKey : this.schedule.keys()) {
        Lesson a = this.schedule.get(dKey);
        if (a.getStarthour().beforeDateShedule(dateNow) && a.getEndhour().afterDateShedule(dateNow)) {
          return true;
        }
      }
      return false;
    }else {
      Teacher t = (Teacher) this;
      for(Integer lKey : t.getSchedule().keys()){
        Lesson a = t.getSchedule().get(lKey);
        if (a.getStarthour().beforeDateShedule(dateNow) && a.getEndhour().afterDateShedule(dateNow)) {
          return true;
        }
      }
      for(Integer hKey : (t.getAttendanceBST().keys())){
        Attendance at = t.getAttendanceBST().get(hKey);
        if(at.getStarthour().beforeDateShedule(dateNow) && at.getEndhour().afterDateShedule(dateNow)){
          return true;
        }
      }
      return false;
    }
  }

  /**
   * Função que adiciona, se for possivel uma turma ao student/Teacher.
   * @param aClass turma a associar.
   * @return true se for possivel.
   * @return false se não for possivel.
   */
  public boolean addClass(Class aClass){
    if(this instanceof Student) {
      Student s = (Student) this;
      // verifica se a turma recebida faz parte das turmas já existentes do student
      if (s.getaClass().contains(aClass.getCurricularUnit().getId())) {
        System.out.println("[ERROR] Esta Turma já faz parte das Turmas do aluno - " + s.getName());
        return false;
      }
      // verifica a quantidade de alunos já existentes na turma.
      if (aClass.getStudentsLimit() <= aClass.getStudents().size()) {
        System.out.println("Não é possivel adicionar este aluno a Turma: " + aClass.getId() + " , porque já se encontra cheia");
        return false;
      }

      // putHorario retorna verdadeiro se for o horario do aluno não estiver ocupado no horario da aula da turma que se pretende adicionar.
      if(this.getcUnit().contains(aClass.getCurricularUnit().getId())) {
        if (putSchedule(aClass.getLesson())) { //adiciona a aula desta turma ao horario do aluno
          s.getaClass().put(aClass.getId(), aClass); //adiciona a turma as turmas do aluno
          return true;
        } else {
          System.out.println("O Aluno não foi adicionado a turma " + aClass.getId());
          return false;
        }
      }else{
        System.out.println("O Aluno não faz parte da unidade curricular da turma" + aClass.getId());
        return false;
      }
    }
    else
    {
      Teacher t = (Teacher) this;
      if(t.getcUnit().contains(aClass.getcUnit().getId())) {

        if (t.getaClass().contains(aClass.getId())) {
          System.out.println("Esta Turma já faz parte das Turmas do professor - " + t.getName());
          return false;
        }

        if (putSchedule(aClass.getLesson())) {
          t.getaClass().put(aClass.getId(), aClass); //adiciona a turma as turmas do professor
          System.out.println("turma adicionada");
        } else {
          System.out.println("A turma " + aClass.getId() + " não foi associada ao professor");
          return false;
        }
      }else{
        return false;
      }
    }
    return true;
  }

  /**
   * Verifica se Person está ocupado no intervalo de tempo recebido
   * @param lesson aula com hora de inicio e hora de fim
   * @return true se não estiver ocupado
   * @return false se estiver ocupado
   */
  public boolean checkSchedule(Lesson lesson){
    if(this instanceof Student){
      Student s = (Student) this;

      for(Integer key : s.getSchedule().keys()){
        Lesson a = s.getSchedule().get(key);

        if(a.betweendates(lesson.getStarthour(), lesson.getEndhour())) {
          if (!lesson.getId().equals(a.getId())) {
            System.out.println("\n[ ERROR - HORARIO OCUPADO !! ]");
            System.out.println("Este horário do aluno numero: " + ((Student) this).getNumber() + " já está ocupado!!");
            System.out.println("Horario: " + lesson.getStarthour() + " -" + lesson.getEndhour());
            System.out.println("Aula existente: " + a);
            return false;
          }
        }
      }
      return true;

    }else{

      Teacher t = (Teacher) this;

      for(Integer key : t.getSchedule().keys()){
        Lesson a = t.getSchedule().get(key);

        if(a.betweendates(lesson.getStarthour(), lesson.getEndhour())) {
          if (!lesson.getId().equals(a.getId())) {
            System.out.println("\n[ ERROR - HORARIO OCUPADO !! ]");
            System.out.println("Este horário do professor: " + this.getName() + " já está ocupado!!");
            System.out.println("Horario: " + lesson.getStarthour() + " -" + lesson.getEndhour());
            System.out.println("Aula existente: " + a);
            return false;
          }
        }
      }

      for(Integer key1: t.getAttendanceBST().keys()){
        Attendance ho = t.getAttendanceBST().get(key1);
        if(ho.betweendates(lesson.getStarthour(), lesson.getEndhour())){
          System.out.println("\n[ ERROR - HORARIO OCUPADO !! ]");
          System.out.println("Este horário do professor: " + this.getName() + " já está ocupado com atendimento!!");
          System.out.println("Horario: " + lesson.getStarthour() + " -" + lesson.getEndhour());
          System.out.println("Horario de atendimento existente: " + ho);
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Remove uma class de Person
   * @param id da class a remover
   * @return Class se for removida
   * @return null se não for removida
   */
  public Class deleteClass(String id){
    if(this instanceof Student) {
      Student s = (Student) this;
      if (!s.getaClass().contains(id)) {
        //System.out.println("Esta turma não faz parte das turmas onde o aluno está inserido");
        return null;
      }

      Class aClass = s.getaClass().get(id);
      s.getaClass().delete(id);  //remove a turma das turmas do aluno.
      s.deleteSchedule(aClass.getLesson().getStarthour()); //remove a aula desta turma do horario do aluno.

      return aClass;
    }
    else{
      // se for professor
      if(!this.getaClass().contains(id)){
        System.out.println("Esta turma não faz parte das turmas que o professor leciona");
        return null;
      }

      Class aClass = this.getaClass().get(id);
      aClass.setTeacher(null);
      this.getaClass().delete(id);
      this.deleteSchedule(aClass.getLesson().getStarthour());

      return aClass;
    }
  }

  /**
   * Adiciona uma Unidade Curricular as unidades curriculares de Person
   * @param cUnit Unidade Curricular a inserir
   */
  public void putcUnit(CurricularUnit cUnit){
    if(this instanceof Student) {

      // verifica se a unidade curricular já faz parte das unidades curriculares do student
      if (this.getcUnit().contains(cUnit.getId())) {
        System.out.println("Esta Unidade Curricular já faz parte das Unidades Curriculares do aluno - " + this.getName());
        return;
      }

      this.getcUnit().put(cUnit.getId(), cUnit);
    }else{

      // verifica se a unidade curricular já faz parte das unidades curriculares do teacher
      if (this.getcUnit().contains(cUnit.getId())) {
        System.out.println("Esta Unidade Curricular já faz parte das Unidades Curriculares do professor - " + this.getName());
        return;
      }
      Teacher t = (Teacher) this;
      if(cUnit.addTeacher(t)){
        this.getcUnit().put(cUnit.getId(), cUnit);
      }
    }
  }

  /**
   * Remove uma unidade curricular das unidades curriculares de Person
   * @param key string que identifica a unidade curricular
   * @return CurricularUnit se for removida com sucesso
   * @return null se não for possivel remover.
   */
  public CurricularUnit deletecUnit(String key){
    if(!this.getcUnit().contains(key)){
      //System.out.println("Esta unidade Curricular não faz parte das Unidadees Curriculares do aluno");
      return null;
    }
    CurricularUnit u = this.getcUnit().get(key);
    // Verificar se this faz parte de alguma turma da unidade curricular removida, se fizer é retirado dessa turma.
    for(String tkey : this.getaClass().keys()){
      if(this.getaClass().get(tkey).getcUnit().getId().compareTo(key) == 0){
        this.deleteClass(tkey);
      }
    }
    this.getcUnit().delete(key);

    return u;
  }

  /**
   * Imprime todas as Unidades Curriculares de Person
   */
  public void printcUnits(){
    for(String key : this.getcUnit().keys()){
      CurricularUnit uCur = this.getcUnit().get(key);
      System.out.println(uCur);
    }
  }

  /**
   * Imprime todas as Turmas de Person
   */
  public void printAllClass(){
    for(String key : this.getaClass().keys()){
      Class aClass = this.getaClass().get(key);
      System.out.println(aClass);
    }
  }

  /**
   * Adiciona uma aula ao horario de person
   * @param lesson aula que vai ser inserida no horario
   * @return true se for possivel adicionar
   * @return false se não for possivel adicionar
   */
  public boolean putSchedule(Lesson lesson){
    if(this instanceof Student){
      // Percorre todas as aulas que já fazem parte do horario de student e verifica se alguma coincide com lesson
    for(Integer key : this.getSchedule().keys()){
      Lesson a = this.getSchedule().get(key);

      if(lesson.betweendates(a.getStarthour(), a.getEndhour())){
        System.out.println("\n[ ERROR - HORARIO OCUPADO !! ]");
        System.out.println("Este horário do aluno numero: " + ((Student) this).getNumber() + " já está ocupado!!");
        System.out.println("Aula existente: " + a);
        System.out.println("Aula pretendida: " + lesson);
        return false;
      }
    }
    }else{

      Teacher t = (Teacher) this;

      // percorre todas as aulas de teacher e verifica se alguma coincide com lesson
      for(Integer key : t.getSchedule().keys()){
        Lesson a = t.getSchedule().get(key);

        if(lesson.betweendates(a.getStarthour(), a.getEndhour())){
          System.out.println("\n[ ERROR - HORARIO OCUPADO !! ]");
          System.out.println("Este horário do professor: " + this.getName() + " já está ocupado!!");
          System.out.println("Aula existente: " + a);
          System.out.println("Aula pretendida: " + lesson);
          return false;
        }
      }

      // percorre todos os horarios de atendimento do professor e verifica se algum coincide com a aula.
      for(Integer key1: t.getAttendanceBST().keys()){
        Attendance ho = t.getAttendanceBST().get(key1);
        if(lesson.betweendates(ho.getStarthour(), ho.getEndhour())){
          System.out.println("\n[ ERROR - HORARIO OCUPADO !! ]");
          System.out.println("Este horário do professor: " + this.getName() + " já está ocupado com atendimento!!");
          System.out.println("Horario de atendimento existente: " + ho);
          System.out.println("Aula pretendida: " + lesson);
          return false;
        }
      }

    }

    this.getSchedule().put(lesson.getStarthour().dateToInt(), lesson);
    return true;
  }

  /**
   * Remove uma aula do horario de Person
   * @param horaInicio hora e dia da aula que vai ser removida do horario
   * @return Lesson se for a aula for removida
   * @return null se não for possivel remover.
   */
  public Lesson deleteSchedule(DateSchedule horaInicio){
    // verifica se o horario de Person tem alguma aula com a data igual a recebida.
    if(!this.schedule.contains(horaInicio.dateToInt())){
      System.out.println("Esta aula não faz parte do horario de ->" + this.toString());
      return null;
    }

    Lesson lesson = this.getSchedule().get(horaInicio.dateToInt());
    this.getSchedule().delete(horaInicio.dateToInt());
    return lesson;
  }

  /**
   * Imprime o horario de Person.
   */
  public void printSchedule(){
    for(Integer key: this.getSchedule().keys()){
      Lesson lesson = this.getSchedule().get(key);
      System.out.println("Dia da semana: " + lesson.starthour.dayToString() + ", hora de inicio: " + lesson.starthour + ", hora de fim: " + lesson.endhour + ", Tipo: " + lesson.getaClass().getType());
      if(lesson.getClassroom() != null) System.out.println("Sala: " + lesson.getClassroom().getName());
      else System.out.println("Sala: sem sala defenida ainda");
    }
  }

  /**
   * Retorna se existir, a aula que tem o horario igual ao recebido
   * @param horaInicio inicio da aula
   * @return Lesson se existir.
   * @return null se não existir.
   */
  public Lesson getAulabyHour(DateSchedule horaInicio){
    if(this.schedule.contains(horaInicio.dateToInt())){
      return this.getSchedule().get(horaInicio.dateToInt());
    }

    System.out.println("Não existe nenhuma aula neste horario -"+ horaInicio);
    return null;
  }


  @Override
  public String toString() {
    return "Person{" +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", birth=" + birth +
            ", email='" + email + '\'' +
            ", age='" + this.age() +
            ", registration=" + registration +
            '}';
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String emailFac) {
    this.email = emailFac;
  }

  public Date getRegistration() {
    return registration;
  }

  public void setRegistration(Date registration) {
    this.registration = registration;
  }

  public SeparateChainingHashST<String, CurricularUnit> getcUnit() {
    return cUnits;
  }

  public SeparateChainingHashST<String, Class> getaClass() {
    return aClass;
  }

  public RedBlackBST_AED2<Integer, Lesson> getSchedule() {
    return schedule;
  }

}