package university;

public class Teacher extends Person {

    public Long number;
    private RedBlackBST_AED2<Integer, Attendance> attendanceBST = new RedBlackBST_AED2<>();


    public Teacher(String name, String address, Date birth, String email, Date registration, Long number) {
        super(name, address, birth, email, registration);
        this.number = number;
    }

    /**
     * Adiciona um horario de atendimento aos horarios de atendimento de teacher
     * @param attendance horario de atendimento a ser inserido
     */
    public void addAttendance(Attendance attendance){
        if(this.getAttendanceBST().contains(attendance.getStarthour().dateToInt())){
            System.out.println("Este horario de atendimento já se encontra ocupado");
            return;
        }

        // verifica se teacher já está ocupado no horario de attendance
        Lesson lesson = new Lesson(0, attendance.getStarthour(), attendance.getEndhour());
        if(this.checkSchedule(lesson)){
            this.getAttendanceBST().put(attendance.getStarthour().dateToInt(),attendance);
        }

    }

    /**
     * Remove um horario de atendimento a teacher, se teacher tiver algum atendimento na hora recebida
     * @param startHour hora inicio do atendimento
     * @return Attendance se for removido com sucesso
     * @return null se não for removido
     */
    public Attendance deleteAttendance(DateSchedule startHour){
        if(!this.getAttendanceBST().contains(startHour.dateToInt())){
            System.out.println("Não existe nenhum horario de atendimento a começar na hora: " + startHour.toString());
            return null;
        }
        Attendance attendance = this.getAttendanceBST().get(startHour.dateToInt());
        this.getAttendanceBST().delete(startHour.dateToInt());
        return attendance;
    }

    public void printAttendance(){
        for(Integer key: this.attendanceBST.keys()){
            Attendance attendance = this.attendanceBST.get(key);
            System.out.println(attendance);
        }
    }

    
    public RedBlackBST_AED2<Integer, Attendance> getAttendanceBST() {
        return attendanceBST;
    }

    public void setAttendanceBST(RedBlackBST_AED2<Integer, Attendance> attendanceBST) {
        this.attendanceBST = attendanceBST;
    }

    public Long getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}