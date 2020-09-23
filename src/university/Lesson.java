package university;

import java.io.Serializable;

public class Lesson implements Serializable {

    public Integer id;

    public DateSchedule starthour;

    public DateSchedule endhour;

    public String day;

    public Classroom classroom;

    public Class aClass;


    public Lesson(Integer id, DateSchedule starthour, DateSchedule endhour) {
        this.id = id;
        this.starthour = starthour;
        this.endhour = endhour;
        this.day = starthour.dayToString();
    }

    /**
     * Função que edita o horário de uma aula caso seja possível
     * @param starthour nova hora de início
     * @param endhour nova hora de fim
     * @return true se foi possível alterar o horário da aula
     * @return false se não tiver sido possível alterar o horário da aula
     */
    public boolean editSchedule(DateSchedule starthour, DateSchedule endhour) {

        // Se entrar no if significa que foi possivel alterar o horario da aula e manter na mesma sala
        Lesson newLesson = new Lesson(this.getId(), starthour, endhour);
        if(this.getClassroom().checkAvailability(newLesson)){

            // Verificar se o professor tem disponibilidade no horario pretendido
            if(this.getaClass().getTeacher().checkSchedule(newLesson)) {

                //Verificar se os alunos tem disponibilidade neste horario, os que não tiverem são removidos da turma
                for(Long sKey : this.getaClass().getStudents().keys()){
                    Student s = this.getaClass().getStudents().get(sKey);
                    if(!s.checkSchedule(newLesson)){
                        s.deleteClass(this.getaClass().getId());
                        this.getaClass().getStudents().delete(s.getNumber());
                        System.out.println("Aluno " + s.getName() + " foi removido da turma " + this.getaClass() + " por indisponibilidade de horario");
                    }
                }
                this.setStarthour(starthour);
                this.setEndhour(endhour);
                this.setDay(starthour.dayToString());
                return true;
            }else{
                System.out.println("[ERROR EDIT LESSON SCHEDULE] O professor está ocupado no horário pretendido");
            }
        }else{
            System.out.println("A hora da aula não foi possivel ser alterada para a mesma sala");
        }
        return false;
    }



    /**
     * Função que associa se possível uma sala de aula a uma aula
     * @param s sala a associar à aula
     * @return true se foi possível associar
     * @return false se não foi possível
     */
    public boolean addClassroom(Classroom s){
        if(s.addLesson(this)){
            if(this.classroom == null){
                this.setClassroom(s);
            }else{
                this.getClassroom().deleteLesson(this);
                this.setClassroom(s);
            }
            return true;
        }
        System.out.println("Não foi possivel atribuir a Sala: " + s.getName() + " a esta aula");
        return false;
    }

    /**
     * Função que desassocia uma sala de aula a uma aula
     * @return true se foi possível desassociar
     * @return false se não foi possível
     */
    public boolean deleteClassroom(){
        if(this.classroom != null){
            this.classroom.deleteLesson(this);
            this.classroom = null;
            return true;
        }
        return false;
    }

    /**
     * Função que edita a sala de aula associada à aula.
     * @param classroom sala nova a ser associada à aula.
     * @return true se tiver sido possível alterar a sala.
     * @return false se não foi possível alterar.
     */
    public boolean editClassroom(Classroom classroom){

        // Verificar se não existe nenhuma aula na sala no horario da aula que vai ser alterada
        if(classroom.checkAvailability(this) && classroom.getStudentsLimit() >= this.getaClass().getStudentsLimit()){
            System.out.println("Sala alterada com sucesso");
            System.out.println("Antes: " + this.classroom + " Depois: " + classroom);
            this.deleteClassroom();
            this.setClassroom(classroom);
            classroom.getLessons().add(this);
            return true;
        }else{
            System.out.println("Não foi possivel alterar a sala da aula " + this);
            System.out.println("Tamanho da sala: " + classroom.getStudentsLimit() + "tamanho da turma " + this.getaClass().getStudentsLimit());
            return false;
        }
    }

    /**
     * Função que verifica se uma aula está entre duas horas passadas como argumentos
     * @param starthour hora de início a comparar
     * @param endhour hora de fim a comparar
     * @return true se a aula estiver entre as duas horas passadas
     * @return false se não estiver
     */
    public boolean betweendates(DateSchedule starthour, DateSchedule endhour){
        if(!((this.getEndhour().beforeDateShedule(starthour) || this.getEndhour().compareTo(starthour) == 0) ||
                (this.getStarthour().afterDateShedule(endhour) || this.getStarthour().compareTo(endhour) == 0))){
            return true;
        }

        return false;
    }

    public void removeLesson(){
        this.deleteClassroom();
        this.getaClass().removeLesson();
    }

    @Override
    public String toString() {
        return "" + id;
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

    public Classroom getClassroom() {
        return classroom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}