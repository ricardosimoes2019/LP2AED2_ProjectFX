package university;


import java.io.Serializable;

public class Class implements Serializable {

  public String id;

  public Integer year;

  public Integer studentsLimit;

  public String type;

  //Inserido automaticamente quando a turma é associada ao Teacher.
  public Teacher teacher;


  public RedBlackBST_AED2<Long, Student> students = new RedBlackBST_AED2();

  private CurricularUnit curricularUnit;


  private Lesson lesson;


  public Class(String id, Integer year, Integer studentsLimit, String type, CurricularUnit cUnit) {
    this.id = id;
    this.year = year;
    this.studentsLimit = studentsLimit;
    this.type = type;
    this.setUCur(cUnit);
  }

  /**
   * Função que adiciona um professor a uma turma, caso ele ainda não esteja associado à mesma
   * @param teacher teacher recebido e que vai ser inserido se possível
   */
  public boolean addTeacher(Teacher teacher){
    if(this.getTeacher() != null) {
      System.out.println("Esta turma já tem um professor associado. Antes de fazer a alteração, remova o professor atual");
      return false;
    }

    // função addClass retorna um boolean true se for possivel adicionar a turma ao professor
    if(teacher.addClass(this)){
      this.setTeacher(teacher);
      System.out.println(" O professor: " + teacher.getName() + " foi associado à turma: " + this.getId());
      return true;
    }else{
      System.out.println("\n[ERROR ASSOCIATE TEACHER !! ]\nO Professor " + teacher.getName() + ", não faz parte da unidade curricular:\n" + this.getcUnit().getName() + "\n");
      return false;
    }
  }

  public void addLesson(Lesson lesson){
    boolean teacherRemoved = false;
    // se o professor estiver ocupado no horario pretendido
    if(this.getTeacher() != null) {
      if (!this.getTeacher().checkSchedule(lesson)) {
        this.removeTeacher();
        teacherRemoved = true;
      } else {
        this.getTeacher().putSchedule(lesson);
      }
    }
    for(Long key : this.getStudents().keys()){
      Student student = this.getStudents().get(key);
      if(!student.checkSchedule(lesson)){
        student.deleteClass(this.getId());
        System.out.println("O aluno " + student.getNumber() + " foi removido da turma " + this.getId());
      }else{
        student.putSchedule(lesson);
      }
    }
    this.setLesson(lesson);
  }

  /**
   * Função que altera um professor associado a uma aula se possível
   * @param newTeacher professor a inserir se for possível
   */
  public void changeTeacher(Teacher newTeacher){

    //Verificar se newTeacher tem disponibilidade no horario da aula desta turma se tiver, removemos o teacher anterior e colocamos o newTeacher como professor da turma
    if(newTeacher.checkSchedule(this.getLesson())){
      this.removeTeacher();
      this.addTeacher(newTeacher);
    }
  }

  /**
   * Função que remove um professor associado a uma turma se possível
   * @return professor removido
   * @return null se não for possível remover
   */
  public Teacher removeTeacher(){
    // verifica se a turma tem um Teacher associado
    if(this.getTeacher() != null){
      Teacher t = this.getTeacher();
      t.deleteClass(this.getId());
      return t;
    }else{
      System.out.println("A turma " + this.getId() + " não tem nenhum professor associado");
    }
    return null;
  }

  /**
   * Função que adiciona um aluno a uma turma se possível.
   * @param student estudante a ser adicionado.
   */
  public boolean addStudent(Student student){
    // verifica se student já existe na turma
    if(this.getStudents().contains(student.getNumber())){
      System.out.println("\n[ERROR ADDSTUDENT !! ]");
      System.out.println("O aluno com o numero " + student.getNumber() + " já se encontra na turma " + this.getId());
      return false;
    }

    // função addClass retorna um boolean true se for possivel adicionar a turma ao aluno
    if(student.addClass(this)) {
      this.students.put(student.getNumber(), student); // adiciona o estudante aos estudantes da turma
      return true;
    }
    return false;
  }

  /**
   * Função que remove um estudante de uma turma
   * @param studentNumber número do aluno a ser removido
   * @return aluno que foi removido
   * @return null se não for possível remover o aluno
   */
  public Student removeStudent(Long studentNumber){

    // Verifica se o aluno faz parte da turma
    if(this.getStudents().contains(studentNumber)){
      Student s = this.getStudents().get(studentNumber);

      this.getStudents().delete(studentNumber); // remove o estudante "s" desta turma
      s.deleteClass(this.getId()); // remove esta turma do estudante "s"
      return s;
    }else{
      System.out.println(" O aluno com id :" + studentNumber + " não faz parte da turma " + this.getId());
    }
    return null;
  }

  /**
   * Funçao que imprime todos estudantes pertencentes à turma.
   */
  public void printStudents(){
    for(Long key : this.getStudents().keys()){
      System.out.println(this.getStudents().get(key));
    }
  }

  public void removeLesson(){
    for (Long key : students.keys()) {
      Student student = students.get(key);
      student.deleteSchedule(this.getLesson().getStarthour());
    }
    this.getTeacher().deleteSchedule(this.getLesson().getStarthour());
    this.lesson = null;
  }


  @Override
  public String toString() {
    return id;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Integer getStudentsLimit() {
    return studentsLimit;
  }

  public boolean setStudentsLimit(Integer limit_students) {

    if(this.getLesson().getClassroom() != null){
      // verificar se o tamanho da sala é maior que o limite de estudantes da turma
      if(this.getLesson().getClassroom().getStudentsLimit() >= limit_students){
        this.studentsLimit = limit_students;
        return true;
      }
    }else{
      this.studentsLimit = limit_students;
      return true;
    }
    return false;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public RedBlackBST_AED2<Long, Student> getStudents() {
    return students;
  }

  public void setStudents(RedBlackBST_AED2<Long, Student> students) {
    this.students = students;
  }



  public CurricularUnit getcUnit() {
    return curricularUnit;
  }

  public void setUCur(CurricularUnit cUnit) {
    this.curricularUnit = cUnit;
    cUnit.addaClass(this);
  }

  public Lesson getLesson() {
    return lesson;
  }

  public void setLesson(Lesson lesson) {
    this.lesson = lesson;
    //faz a associação da turma à aula.
    lesson.setaClass(this);
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public CurricularUnit getCurricularUnit() {
    return curricularUnit;
  }

  public void setCurricularUnit(CurricularUnit curricularUnit) {
    this.curricularUnit = curricularUnit;
  }
}