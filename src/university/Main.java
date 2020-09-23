package university;

import algs4.In;
import algs4.SeparateChainingHashST;

public class Main extends SearchFunctions{

    private static String FILE_DELIMETER = ";";
    private static String DATE_DELIMETER = "/";
    private static String HOUR_DELIMETER = ":";


    public static void main(String[] args) {

        RedBlackBST_AED2<String, Node> classRoomsRB = new RedBlackBST_AED2<>();
        SeparateChainingHashST<Long, Teacher> teachersST = new SeparateChainingHashST<>();
        SeparateChainingHashST<String, CurricularUnit> curricularUnitsST = new SeparateChainingHashST<>();
        SeparateChainingHashST<Long, Student> studentsST = new SeparateChainingHashST<>();
        SeparateChainingHashST<String, Class> classST = new SeparateChainingHashST<>();
        SeparateChainingHashST<Integer, Lesson> lessonsST = new SeparateChainingHashST<>();


        readClassroomsFromFile(classRoomsRB, ".//data//classrooms.txt");
        readTeachersFromFile(teachersST, ".//data//teachers.txt");
        readAttendanceFromFile(teachersST, classRoomsRB, ".//data//attendance.txt");
        readCurricularUnitsFromFile(curricularUnitsST, ".//data//curricularUnits.txt");
        readTeacherCurricularUnitsFromFile(teachersST, curricularUnitsST, ".//data//teacherCourseclass.txt");
        readStudentsFromFile(studentsST, ".//data//students.txt");
        readStudentsCurricularUnitsFromFile(studentsST, curricularUnitsST, ".//data//studentCurricularUnits.txt");
        readClassFromFile(classST, lessonsST, curricularUnitsST, teachersST, ".//data//class.txt");
        readStudentsClassFromFile(studentsST, classST, ".//data//studentsClass.txt");
        readAssociateClassroomsFromFile(classRoomsRB, lessonsST, ".//data//associateClassrooms.txt");

        // Procurar salas disponiveis entre before e after;
        DateSchedule before = new DateSchedule(10,00,2);
        DateSchedule after = new DateSchedule(20,00,2);
        freeClassroomsbetween(before, after, classRoomsRB);

        // Procurar salas disponiveis pesquisa por piso.
        classroomsbyFloor(1,classRoomsRB);

        // Procurar aulas numa sala entre before e after
        Classroom classroom = (Classroom) classRoomsRB.get("104");
        classroomwithClassbetween(before, after, classroom);

        // Pesquisar horario de atendimento livre do professor comparando com o horario do aluno.
        Teacher t = teachersST.get((long) 34678);
        Student s = studentsST.get(Long.parseLong("35188"));
        freeAttendance(t,s);

        // Imprime alunos, professores, e salas ocupadas no momento.
        now(classRoomsRB, teachersST, studentsST, classST);

        /*
        deleteStudent(classST, studentsST, Long.parseLong("35188"), ".//data//dump/studentsdump.txt");
        deleteTeacher("36431", teachersST, curricularUnitsST, classST, ".//data//dump//teachersdump.txt");
        deleteClassroom("205", classRoomsRB, lessonsST, ".//data//dump//classroomsdump.txt");
        deleteClass("LII", classST, curricularUnitsST, lessonsST, classRoomsRB, studentsST, ".//data//dump//Classdump.txt");
        deleteCourseClass("LPI", curricularUnitsST, classST, lessonsST, studentsST, teachersST, classRoomsRB, ".//data//dump//courseclassdump.txt");
        */

        // Imprime toda a informação.
        //printAllData(classRoomsRB, teachersST, curricularUnitsST, studentsST, classST, lessonsST);

    }

    /**
     * Imprime todas as salas.
     * @param classroomsRB RedBlack das salas
     */
    private static void printAllClassRooms(RedBlackBST_AED2<String, Classroom> classroomsRB) {
        System.out.println("*************** SALAS ***************");
        for (String key : classroomsRB.keys()) {
            System.out.println(classroomsRB.get(key));
        }
    }

    /**
     * Imprime todos os professores.
     * @param teachersST SeparateChaining de professores
     */
    private static void printAllTeachers(SeparateChainingHashST<Long, Teacher> teachersST) {
        System.out.println("*************** PROFESSORES ***************");
        for (Long key : teachersST.keys()) {
            Teacher t = teachersST.get(key);
            System.out.println("Teacher:");
            System.out.println(t);
            System.out.println("Horario de Atendimento");
            t.printAttendance();
            System.out.println("Horario:");
            t.printSchedule();
            System.out.println("Turmas Lecionadas");
            t.printAllClass();
            System.out.println("--------------------------------------------------------");
        }
    }

    /**
     * Imprime todas as unidades curriculares.
     * @param curricularUnitsST SeparateChaining de Unidades Curriculares
     */
    private static void printAllCourseClass(SeparateChainingHashST<String, CurricularUnit> curricularUnitsST) {
        System.out.println("*************** UNIDADES CURRICULARES ***************");
        for(String k : curricularUnitsST.keys()){
            CurricularUnit uc = curricularUnitsST.get(k);
            System.out.println(uc);
            System.out.println("Professores da U.C");
            uc.printTeachers();
            System.out.println("Turmas da U.C");
            uc.printAllClass();
            System.out.println("--------------------------------------------------------");
        }
    }

    /**
     * Imprime todos os estudantes
     * @param studentsST SeparateChaining de estudantes
     */
    private static void printAllStudents(SeparateChainingHashST<Long, Student> studentsST) {
        System.out.println("*************** STUDENTS ***************");
        for (Long key : studentsST.keys()) {
            Student s = studentsST.get(key);
            System.out.println(s);
            System.out.println("UNIDADES CURRICULARES");
            s.printcUnits();
            System.out.println("TURMAS");
            s.printAllClass();
            System.out.println("HORARIO");
            s.printSchedule();
            System.out.println("--------------------------------------------------------");
        }
    }

    /**
     * Imprime todas as aulas
     * @param lessonsST SeparateChaining de aulas
     */
    private static void printAllAulas(SeparateChainingHashST<Integer, Lesson> lessonsST){
        System.out.println("*************** AULAS ***************");
        for (Integer key : lessonsST.keys()){
            Lesson a = lessonsST.get(key);
            System.out.println(a);
        }
    }

    /**
     * Imprime todas as turmas
     * @param classST SeparateChaining de turmas
     */
    private static void printAllTurmas(SeparateChainingHashST<String, Class> classST) {
        System.out.println("*************** TURMAS ***************");
        for (String key : classST.keys()){
            Class t = classST.get(key);
            System.out.println(t);
            System.out.println("STUDENTS");
            t.printStudents();
            System.out.println("--------------------------------------------------------");
        }
    }

    /**
     * Chama todas as funções de imprimir informação.
     * @param classRoomsRB
     * @param teachersST
     * @param curricularUnitsST
     * @param studentsST
     * @param classST
     * @param lessonsST
     */
    private static void printAllData(RedBlackBST_AED2<String, Classroom> classRoomsRB, SeparateChainingHashST<Long, Teacher> teachersST, SeparateChainingHashST<String, CurricularUnit> curricularUnitsST, SeparateChainingHashST<Long, Student> studentsST, SeparateChainingHashST<String, Class> classST, SeparateChainingHashST<Integer, Lesson> lessonsST){

        printAllClassRooms(classRoomsRB);
        System.out.println();
        printAllTeachers(teachersST);
        System.out.println();
        printAllCourseClass(curricularUnitsST);
        System.out.println();
        printAllStudents(studentsST);
        System.out.println();
        printAllAulas(lessonsST);
        System.out.println();
        printAllTurmas(classST);
        printAllTurmas(classST);
        printAllAulas(lessonsST);

    }
}
