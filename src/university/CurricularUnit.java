package university;

import algs4.SeparateChainingHashST;

import java.io.Serializable;


public class CurricularUnit implements Serializable {

  public String id;

  public Integer ects;

  public Integer year;

  public String name;


  private SeparateChainingHashST<String, Class> aClass = new SeparateChainingHashST<>();


  private SeparateChainingHashST<Long, Teacher> teachers = new SeparateChainingHashST<>();


  public CurricularUnit(String id, String name, Integer ects, Integer year) {
    this.id = id;
    this.name = name;
    this.ects = ects;
    this.year = year;
  }

  /**
   * Função que adiciona um professor a uma Unidade Curricular
   * @param teacher professor que se pretende adicionar
   */
  public boolean addTeacher(Teacher teacher){
    // verifica se o professor ainda não faz parte da unidade curricular.
    if (this.getTeachers().contains(teacher.getNumber())){
      System.out.println("Este professor já se encontra associado a esta Unidade Curricular");
      return false;
    }

    this.getTeachers().put(teacher.getNumber(), teacher); //adiciona o professor ao array de professores da Unidade Curricular
    return true;
  }

  /**
   * Função que remove um professor de uma Unidade Curricular
   * @param key chave que identifica o professor
   * @return professor que foi removido se a remoção acontecer
   * @return null se não for possível remover o professor da Unidade Curricular
   */
  public Teacher deleteTeacher(Long key){
    // verifica se o professor faz parte dos professores da Unidade Curricular
    if (this.getTeachers().contains(key)){
      Teacher t = this.getTeachers().get(key);
      this.getTeachers().delete(key);
      return t;
    }
    return null;
  }

  /*+
  Função que imprime todos os professores da Unidade Curricular.
   */
  public void printTeachers(){
    for(Long key : this.getTeachers().keys()){
      Teacher t = this.getTeachers().get(key);
      System.out.println(t);
    }
  }

  /**
   * Função que associa uma turma à Unidade Curricular.
   * @param aClass turma que pretendemos associar
   */
  public void addaClass(Class aClass){
    if (this.aClass.contains(aClass.getId())){
      System.out.println("Esta turma já se encontra associada a esta Unidade Curricular");
      return;
    }

    this.getTurma().put(aClass.getId(), aClass); //adiciona a turma ao array de turmas da unidadde curricular
  }

  /**
   * Função que remove uma turma de uma Unidade Curricular
   * @param key chave identificadora da turma
   * @return null se a turma não fizer parte das turmas da Unidade Curricular
   * @return turma que foi removida com sucesso
   */
  public Class deleteClass(String key){

    //verifica se a turma faz parte das turmas da Unidade Curricular
    if (!this.getTurma().contains(key)){
      System.out.println("Esta turma já não faz parte das Turmas desta Unidade Curricular");
      return null;
    }

    Class t = this.getTurma().get(key);
    this.getTurma().delete(key);

    return t;
  }

  /**
   * Função que imprime as turmas associadas a uma Unidade Curricular
   */
  public void printAllClass(){
    for(String key : this.getTurma().keys()){
      Class t = this.getTurma().get(key);
      System.out.println(t);
    }
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getEcts() {
    return ects;
  }

  public void setEcts(Integer ects) {
    this.ects = ects;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public SeparateChainingHashST<String, Class> getTurma() {
    return aClass;
  }

  public SeparateChainingHashST<Long, Teacher> getTeachers() {
    return teachers;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return id;
  }
}