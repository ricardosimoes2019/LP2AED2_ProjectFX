package university;



public class Student extends Person {

  public Long number;

  public Student(String name, String address, Date birth, String email, Date registration, Long number) {
    super(name, address, birth, email, registration);
    this.number = number;
  }
  
  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }


}