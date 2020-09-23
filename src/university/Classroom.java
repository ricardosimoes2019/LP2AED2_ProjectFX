package university;

import java.util.ArrayList;

public class Classroom extends Node {
    
    private Integer studentsLimit;

    private String about;

    private ArrayList<Lesson> lessons = new ArrayList<>();



    public Classroom(String id, Integer studentsLimit, String about, int x, int y, int floor, boolean classroom) {
        super(id,x,y,floor, classroom);
        this.studentsLimit = studentsLimit;
        this.about = about;
    }

    /**
     * Função que retorna o estado de uma sala de aula num determinado momento
     *
     * @param dateNow data a ser verificada
     * @return null se não existir nenhuma aula na sala que coincida com a data recebida
     */
    public Lesson classroomstate(DateSchedule dateNow) {
        for (Lesson a : this.getLessons()) {
            if (a.getStarthour().beforeDateShedule(dateNow) && a.getEndhour().afterDateShedule(dateNow)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Função que verifica se uma sala está ocupada num intervalo de tempo
     *
     * @param startHour hora de início a verificar
     * @param endHour   hora de fim a verificar
     * @return verdadeiro se a sala não estiver ocupada naquele horário
     */
    public boolean checkAvailability(Lesson lesson) {
        //Lesson lesson = new Lesson(0, startHour, endHour);

        for (Lesson a : this.getLessons()) {
            if (lesson.betweendates(a.getStarthour(), a.getEndhour())) {
                if(!lesson.getId().equals(a.getId())) {
                    System.out.println("\n[ERROR CHECK AVAILABILITY]");
                    System.out.println("Esta sala" + this.getName() + "já está ocupada neste horário:");
                    System.out.println("Horário Enviado: " + lesson.getStarthour() + " - " + lesson.getEndhour());
                    System.out.println("Aula existente: " + a);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Função que adiciona uma aula a uma sala num determinado horário se disponível
     *
     * @param lesson aula que vai ser adicionada
     * @return verdadeiro se for possível adicionar a aula à sala
     */
    public boolean addLesson(Lesson lesson) {
        // percorre todas as aulas da sala e verifica se não existe nenhuma em que os horarios coincidam com a lesson recebida
        for (Lesson a : this.getLessons()) {
            if (lesson.betweendates(a.getStarthour(), a.getEndhour())) {
                System.out.println("\n[ERROR ADDAULA]");
                System.out.println("Esta sala" + this.getName() + "já está ocupada neste horário:");
                System.out.println("Aula existente: " + a);
                System.out.println("Aula pretendida: " + lesson);
                return false;
            }

            // verifica se a sala tem tamanho suficiente para a turma da aula que queremos inserir.
            if (this.getStudentsLimit() < lesson.getaClass().getStudents().size()) {
                System.out.println("Não é possivel utilizar a Sala " + this.getName() + " para a aula " + lesson.getId() + " . O tamanho foi excedido!");
                System.out.println("Tamanho da sala: " + this.getStudentsLimit() + "\nQuantidade de alunos da turma: " + lesson.getaClass().getStudents().size());
                return false;
            }
        }

        this.getLessons().add(lesson);
        return true;
    }

    /**
     * Função para eliminar uma aula associada à sala num determinado horário
     *
     * @param lesson aula a ser removida da sala
     * @return aula que foi removida com sucesso
     */
    public Lesson deleteLesson(Lesson lesson) {
        // verifica se a aula faz parte das aulas da sala
        if (!this.getLessons().contains(lesson)) {
            System.out.println("Esta aula não está atribuida a Sala: " + this.getName());
            return null;
        }

        //remove a aula da sala.
        this.getLessons().remove(lesson);
        System.out.println("Aula: " + lesson.getId() + " removida com sucesso!");
        return lesson;
    }

    /**
     * Função que imprime as todas as aulas da sala
     */
    public void printLessons() {
        for (Lesson a : this.getLessons()) {
            System.out.println(a);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public Integer getStudentsLimit() {
        return studentsLimit;
    }

    public void setStudentsLimit(Integer studentsLimit) {
        this.studentsLimit = studentsLimit;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

}