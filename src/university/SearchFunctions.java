package university;

import algs4.In;
import algs4.SeparateChainingHashST;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class SearchFunctions extends DumpFiles {

    private static String FILE_DELIMETER = ";";
    private static String DATE_DELIMETER = "/";
    private static String HOUR_DELIMETER = ":";

    /**
     * Função faz a pesquisa de aulas numa sala no intervalo de tempo recebido
     * @param startHour Inicio do intervalo de tempo
     * @param endHour Fim do intervalo de tempo
     * @param classroom Sala pretendida
     */
    public static ArrayList<Lesson> classroomwithClassbetween(DateSchedule startHour, DateSchedule endHour, Classroom classroom){
        System.out.println("A sala " + classroom.getName() + " esta ocupada entre " + startHour + " e " + endHour);
        ArrayList<Lesson> lessons = new ArrayList<>();
        for(Lesson l : classroom.getLessons()){
            if(l.betweendates(startHour, endHour)){
                lessons.add(l);
                System.out.println(l);
            }
        }
        return lessons;
    }

    /**
     * Função faz a pesquisa de salas disponiveis no intervalo de tempo recebido
     * @param startHour Inicio do intervalo
     * @param endHour Fim do intervalo
     * @param classroomsST RedBlack das salas
     */
    public static ArrayList<FreeClassroom> freeClassroomsbetween(DateSchedule startHour, DateSchedule endHour, RedBlackBST_AED2<String, Node> classroomsST) {
        System.out.println("Salas livres entre: " + startHour.dayToString() + " - " + startHour + " e " + endHour.dayToString() + " - " + endHour);
        ArrayList<FreeClassroom> freeClassrooms = new ArrayList<>();

        for (String idClass : classroomsST.keys()) {
            if (classroomsST.get(idClass) instanceof Classroom) {
                Classroom s = (Classroom) classroomsST.get(idClass);

                DateSchedule firstFree = endHour;
                DateSchedule lastFree = startHour;
                FreeClassroom freeclassroom = new FreeClassroom(s.getName(), lastFree, firstFree);
                for (Lesson a : s.getLessons()) {
                    if (a.betweendates(startHour, endHour)) {
                        if (a.getStarthour().beforeDateShedule(firstFree)) {
                            firstFree = a.getStarthour();
                        }
                        if (a.getEndhour().afterDateShedule(lastFree)) {
                            lastFree = a.getEndhour();
                        }
                    }
                }

                if (firstFree == endHour && lastFree == startHour) {
                    System.out.println("A sala " + s.getName() + " está livre entre durante todo o tempo escolhido");
                    freeClassrooms.add(freeclassroom);
                } else if (startHour.beforeDateShedule(firstFree) && firstFree.beforeDateShedule(lastFree) && endHour.afterDateShedule(lastFree)) {
                    System.out.println("A sala " + s.getName() + " está livre entre: " + startHour + " até " + firstFree + " e entre " + lastFree + " até " + endHour);
                    freeclassroom.setEndHour(firstFree);
                    freeClassrooms.add(freeclassroom);
                    FreeClassroom freeClassroom1 = new FreeClassroom(freeclassroom.getClassroomName(), lastFree, endHour);
                    freeClassrooms.add(freeClassroom1);
                } else if ((firstFree.compareTo(startHour) == 0) && (lastFree.afterDateShedule(startHour) && (lastFree.beforeDateShedule(endHour)))) {
                    System.out.println("A sala " + s.getName() + " está livre entre: " + lastFree + " até " + endHour);
                    freeclassroom.setStartHour(lastFree);
                    freeClassrooms.add(freeclassroom);
                } else if ((lastFree.compareTo(endHour) == 0) && (firstFree.afterDateShedule(startHour) && firstFree.beforeDateShedule(endHour))) {
                    System.out.println("A sala " + s.getName() + " está livre entre: " + startHour + " até " + firstFree);
                    freeclassroom.setEndHour(firstFree);
                    freeClassrooms.add(freeclassroom);
                }
            }
        }
        return freeClassrooms;
    }

    /**
     * Função faz a pesquisa de salas livres através do tamanho enviado.
     * @param size tamanho pretendido.
     * @param classroomsST RedBlack de salas.
     */
    public static ArrayList<Classroom> classroomsbySize(Integer size, RedBlackBST_AED2<String, Node> classroomsST){
        System.out.println("Salas com lugar para mais de " + size + " alunos");
        ArrayList<Classroom> classroomsBySize = new ArrayList<>();

        for(String ukey : classroomsST.keys()) {
            if (classroomsST.get(ukey) instanceof Classroom) {
                Classroom s = (Classroom) classroomsST.get(ukey);
                if (s.getStudentsLimit() > size) {
                    classroomsBySize.add(s);
                    //System.out.println("A sala: " + s.getName() + " tem espaço para " + s.getStudentsLimit());
                }
            }
        }
        return classroomsBySize;
    }

    /**
     * Função faz a pesquisa de salas existentes através do piso enviado
     * @param floor piso pretendido
     * @param classroomsST RedBlack de salas
     */
    public static void classroomsbyFloor(Integer floor, RedBlackBST_AED2<String, Node> classroomsST){
        System.out.println("Salas do piso " + floor);

        for(String ukey : classroomsST.keys()){
            if(classroomsST.get(ukey).getFloor().equals(floor)){
                Classroom s = (Classroom) classroomsST.get(ukey);
                System.out.println("A sala: " + s.getName() + " faz parte do piso " + floor);
            }
        }
    }

    /**
     * Função pesquisa um horario de atendimento de teacher livre para o aluno.
     * @param teacher professor
     * @param student estudante que deseja um horario de atendimento
     */
    public static void freeAttendance(Teacher teacher, Student student){
        Boolean free = true;
        for(Integer hkey : teacher.getAttendanceBST().keys()){
            Attendance ho = teacher.getAttendanceBST().get(hkey);
            free = true;
            for(Integer ukey : student.getSchedule().keys()){
                Lesson a = student.getSchedule().get(ukey);
                if(a.betweendates(ho.getStarthour(), ho.getEndhour())){
                    free = false;
                }
            }
            if(free){
                System.out.println("Horario de atendimento disponivel entre as: " + ho.getStarthour() +  " e as " + ho.getEndhour());
            }
        }
    }

    /**
     * Função que mostra o estado da instituição no momento
     * @param classroomsST RedBlack das salas
     * @param teachersST SeparateChaining dos professores
     * @param studentsST SeparateChaining dos estudantes
     * @param classST SeparateChaining das salas.
     */
    public static void now(RedBlackBST_AED2<String, Node> classroomsST, SeparateChainingHashST<Long, Teacher> teachersST, SeparateChainingHashST<Long, Student> studentsST, SeparateChainingHashST<String, Class> classST){
        DateSchedule dateScheduleNow = new DateSchedule(15, 30, 2);
        DateSchedule dateNow = new DateSchedule();

        classroombusy(dateScheduleNow, classroomsST);
        studentBusy(dateScheduleNow, studentsST);
        teacherBusy(dateScheduleNow, teachersST);
        curricularUnitsAtMoment(dateScheduleNow, classST);
    }

    public static ArrayList<Lesson> lessonsNow(DateSchedule dateNow, SeparateChainingHashST<Integer, Lesson> lessonsST){

        ArrayList<Lesson> lessonsAtMoment = new ArrayList<>();

        for (Integer key : lessonsST.keys()) {
            Lesson lesson = lessonsST.get(key);
            if (lesson.getStarthour().beforeDateShedule(dateNow) && lesson.getEndhour().afterDateShedule(dateNow)) {
                lessonsAtMoment.add(lesson);
            }
        }

        return lessonsAtMoment;
    }

    /**
     * Função que verifica as salas ocupadas na data recebida
     * @param dateNow data do momento
     * @param classroomsST RedBlack das salas
     */
    public static ArrayList<Classroom> classroombusy(DateSchedule dateNow, RedBlackBST_AED2<String, Node> classroomsST){

        ArrayList<Classroom> busyClassroom = new ArrayList<>();

        for(String cKey : classroomsST.keys()){
            if(classroomsST.get(cKey) instanceof Classroom) {
                Classroom s = (Classroom) classroomsST.get(cKey);
                Lesson a = s.classroomstate(dateNow);
                if (a != null) {
                    busyClassroom.add(s);
                    System.out.println("Sala " + s.getName() + " ocupada:");
                    System.out.println(a);
                }
            }
        }
        return busyClassroom;
    }

    /**
     * Função que pesquisa os alunos ocupados na data recebida
     * @param dateNow data a pesquisar
     * @param studentsST SeparateChaining de estudantes
     */
    public static ArrayList<Student> studentBusy(DateSchedule dateNow, SeparateChainingHashST<Long, Student> studentsST){
        ArrayList<Student> studentsbusy = new ArrayList<>();
        for(Long idStudent : studentsST.keys()){
            Student s = studentsST.get(idStudent);
            if(s.busy(dateNow)){
                studentsbusy.add(s);
                System.out.println("Aluno: " + s.getName() + ", ocupado");
            }
        }

        return studentsbusy;
    }

    /**
     * Função que pesquisa os professores ocupados na data recebida
     * @param dateNow data a pesquisar
     * @param teachersST SeparateChaining de professores
     * @return busyTeachers
     */
    public static ArrayList<Teacher> teacherBusy(DateSchedule dateNow, SeparateChainingHashST<Long, Teacher> teachersST){
        ArrayList<Teacher> freeTeachers = new ArrayList<>();
        ArrayList<Teacher> busyTeachers = new ArrayList<>();

        for(Long idTeacher : teachersST.keys()){
            Teacher t = teachersST.get(idTeacher);
            if(t.busy(dateNow)){
                System.out.println("Teacher: " + t.getName() + ", ocupado");
                busyTeachers.add(t);
            }else{
                freeTeachers.add(t);
            }
        }

        System.out.println("Professores Livres:");
        for(Teacher te : freeTeachers){
            System.out.println(te);
        }

        return busyTeachers;
    }

    /**
     * Função que verifica as unidades curriculares a serem lecionadas na data recebida
     * @param dateNow data pretendida
     * @param classST SeparateChaining das turmas
     */
    public static ArrayList<CurricularUnit> curricularUnitsAtMoment(DateSchedule dateNow, SeparateChainingHashST<String, Class> classST){
        ArrayList<CurricularUnit> curricularUnits = new ArrayList<>();

        for(String key : classST.keys()){
            Class c = classST.get(key);
            if(c.getLesson().getStarthour().beforeDateShedule(dateNow) && c.getLesson().getEndhour().afterDateShedule(dateNow)){

                // Apenas se a turma tiver um professor associado é que está a aula está a acontecer
                if(c.getTeacher() != null) {
                    if (!curricularUnits.contains(c.getcUnit())) {
                        curricularUnits.add(c.getcUnit());
                    }
                }
            }
        }

        System.out.println("Unidades Curriculares a serem lecionadas agora");
        for(int i = 0; i < curricularUnits.size(); i++){
            System.out.println(curricularUnits.get(i));
        }

        return curricularUnits;
    }

    public static String[] getAllClassroomsNames(RedBlackBST_AED2<String, Node> classroomsST){
        ArrayList<Classroom> classroomsnames = new ArrayList<>();

        for(String name : classroomsST.keys()){
            if(classroomsST.get(name) instanceof Classroom) {
                classroomsnames.add((Classroom) classroomsST.get(name));
            }
        }

        String[] names = new String[classroomsnames.size()];
        int i = 0;

        for(Classroom c : classroomsnames){
            names[i] = c.getName();
            i++;
        }

        return names;
    }

    public static String[] getAllUC(SeparateChainingHashST<String, CurricularUnit> curricularUnitsST) {
        String[] names = new String[curricularUnitsST.size()];
        int i = 0;

        for(String name: curricularUnitsST.keys()){
            names[i] = name;
            i++;
        }

        return names;
    }

    public static String[] getAllClassNames(SeparateChainingHashST<String, Class> classST){
        String[] aClassNames = new String[classST.size()];
        int i = 0;

        for(String name : classST.keys()){
            aClassNames[i] = name;
            i++;
        }

        return aClassNames;
    }

    public static String[] getClasswithouLesson(SeparateChainingHashST<String, Class> classST){
        ArrayList<Class> withouLesson = new ArrayList<>();

        for(String key : classST.keys()){
            if(classST.get(key).getLesson() == null){
                withouLesson.add(classST.get(key));
            }
        }

        String[] classnames = new String[withouLesson.size()];
        int i = 0;

        for(Class aC : withouLesson){
            classnames[i] = aC.getId();
        }

        return classnames;
    }

    public static String[] getAllTeachersName(SeparateChainingHashST<Long, Teacher> teachersST){
        String[] teachersName = new String[teachersST.size()];
        int i = 0;

        for (Long key : teachersST.keys()) {
            teachersName[i] = teachersST.get(key).getName();
            i++;
        }
        return teachersName;
    }

    public static String[] getAllStudentsNumber(SeparateChainingHashST<Long, Student> studentsST){
        String[] allstudents = new String[studentsST.size()];
        int i = 0;

        for (Long key : studentsST.keys()) {
            allstudents[i] = key.toString();
            i++;
        }

        return allstudents;
    }
    /**
     * Função que lê os professores do ficheiro e insere na SeparateChaining de professores.
     * @param teachersST SeparateChaining dos professores
     * @param path caminho para o ficheiro
     */
    public static void readTeachersFromFile(SeparateChainingHashST<Long, Teacher> teachersST, String path) {
        In in = new In(path);
        in.readLine();

        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] fields = line.split(FILE_DELIMETER);

            Long idNumber = Long.parseLong(fields[0]);

            // Verifica a existencia de um professor com o mesmo ID
            if(!teachersST.contains(idNumber)){

                String name = fields[1];
                String address = fields[2];

                String[] dateOfBirth = fields[3].split(DATE_DELIMETER);

                String email = fields[4];

                String[] dateOfRegistration = fields[5].split(DATE_DELIMETER);

                Date dateBirth = new Date(Integer.parseInt(dateOfBirth[0]), Integer.parseInt(dateOfBirth[1]), Integer.parseInt(dateOfBirth[2]));
                Date dateRegistration = new Date(Integer.parseInt(dateOfRegistration[0]), Integer.parseInt(dateOfRegistration[1]), Integer.parseInt(dateOfRegistration[2]));

                Teacher t = new Teacher(name, address, dateBirth, email, dateRegistration, idNumber);
                teachersST.put(t.getNumber(), t);
            }else{
                System.out.println("[ERROR ADD TEACHER] Já existe um professor com o ID " +idNumber);
            }
        }
    }

    /**
     * Função que lê atendimentos dos professores do ficheiro
     * @param teachersST SeparateChaining dos professores
     * @param classRoomsRB RedBlack das salas
     * @param path caminho para o ficheiro
     */
    public static void readAttendanceFromFile(SeparateChainingHashST<Long, Teacher> teachersST, RedBlackBST_AED2<String, Node>classRoomsRB, String path) {
        In in = new In(path);
        in.readLine();

        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] fields = line.split(FILE_DELIMETER);

            Long idTeacher = Long.parseLong(fields[0]);

            // Verifica a existencia de um professor com o id recebido
            if(teachersST.contains(idTeacher)) {
                String idClassroom = fields[1];

                // Verifica a existencia de uma sala com o id recebido
                if(classRoomsRB.contains(idClassroom)) {

                    String[] start = fields[2].split(HOUR_DELIMETER);

                    String[] end = fields[3].split(HOUR_DELIMETER);
                    Integer day = Integer.parseInt(end[2]);

                    DateSchedule startHour = new DateSchedule(Integer.parseInt(start[0]), Integer.parseInt(start[1]), day);
                    DateSchedule endHour = new DateSchedule(Integer.parseInt(end[0]), Integer.parseInt(end[1]), day);

                    Attendance ha = new Attendance((Classroom) classRoomsRB.get(idClassroom), startHour, endHour);

                    teachersST.get(idTeacher).addAttendance(ha);

                }else{
                    System.out.println("[ERROR ATTENDANCE] Não foi encontrada nenhuma sala com o id " + idClassroom);
                }
            }else {
                System.out.println("[ERROR ATTENDANCE] Não foi encontrado nenhum professor com o id " + idTeacher);
            }
        }
    }

    /**
     * Função que lê as unidades curriculares do ficheiro e insere na SeparateChaining das Unidades Curriculares
     * @param curricularUnitsST SeparateChaining das unidades curriculares
     * @param path caminho para o ficheiro
     */
    public static void readCurricularUnitsFromFile(SeparateChainingHashST<String, CurricularUnit> curricularUnitsST, String path) {
        In in = new In(path);
        in.readLine();

        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] fields = line.split(FILE_DELIMETER);

            String id = fields[0];
            if(!curricularUnitsST.contains(id)) {
                String name = fields[1];
                Integer ects = Integer.parseInt(fields[2]);
                Integer year = Integer.parseInt(fields[3]);

                CurricularUnit uc = new CurricularUnit(id, name, ects, year);
                curricularUnitsST.put(uc.getId(), uc);
            }else{
                System.out.println("[ERROR CURRICULAR UNITS] Já existe uma unidade curricular com id " + id);
            }
        }
    }

    /**
     * Função que lê os estudantes do ficheiro e insere na SeparateChaining dos estudantes
     * @param studentsST SeparateChaining dos estudantes
     * @param path caminho para o ficheiro
     */
    public static void readStudentsFromFile(SeparateChainingHashST<Long, Student> studentsST, String path) {
        In in = new In(path);
        in.readLine();

        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] fields = line.split(FILE_DELIMETER);

            Long number = Long.parseLong(fields[0]);
            if(!studentsST.contains(number)) {
                String name = fields[1];
                String address = fields[2];

                String[] dateOfBirth = fields[3].split(DATE_DELIMETER);

                String email = fields[4];

                String[] dateOfRegistration = fields[5].split(DATE_DELIMETER);

                Date dateBirth = new Date(Integer.parseInt(dateOfBirth[0]), Integer.parseInt(dateOfBirth[1]), Integer.parseInt(dateOfBirth[2]));
                Date dateRegistration = new Date(Integer.parseInt(dateOfRegistration[0]), Integer.parseInt(dateOfRegistration[1]), Integer.parseInt(dateOfRegistration[2]));

                Student s = new Student(name, address, dateBirth, email, dateRegistration, number);
                studentsST.put(s.getNumber(), s);

            }else{
                System.out.println("[ERROR STUDENTS] Já existe um estudante com o numero " + number);
            }
        }
    }

    public boolean checkPosition(RedBlackBST_AED2<String, Node> nodesRB,String classroomXField, String classroomYField, String classroomFloorField) {
        for (String key : nodesRB.keys()) {
            Node point = nodesRB.get(key);
            if (point.getX() == Integer.parseInt(classroomXField) && point.getY() == Integer.parseInt(classroomYField) && point.getFloor() == Integer.parseInt(classroomFloorField)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Função que lê do ficheiro as turmas, a aula de cada turma, o professor associado e a unidade curricular da turma
     * @param classST SeparateChaining das turmas
     * @param lessonsST SeparateChaining das aulas
     * @param curricularUnitsST SeparateChaining das Unidades Curriculares
     * @param teachersST SeparateChaining dos professores
     * @param path caminho para o ficheiro
     */
    public static void readClassFromFile(SeparateChainingHashST<String, Class> classST, SeparateChainingHashST<Integer, Lesson> lessonsST, SeparateChainingHashST<String, CurricularUnit> curricularUnitsST, SeparateChainingHashST<Long, Teacher> teachersST, String path) {
        In in = new In(path);
        in.readLine();

        while (!in.isEmpty()) {
            String line = in.readLine();

            String[] fields = line.split(FILE_DELIMETER);

            String idClass = fields[0];

            // A Unidade Curricular aqui é associada na classe Turma mas não na classe UnidadeCurricular, pois teria de usar a função addTurma dessa classe
            if(!classST.contains(idClass)) {

                Integer year = Integer.parseInt(fields[1]);
                Integer studentsLimit = Integer.parseInt(fields[2]);
                Long idTeacher = Long.parseLong(fields[3]);
                String typeTurma = fields[4];
                Integer idLesson = Integer.parseInt(fields[5]);

                String[] start = fields[6].split(HOUR_DELIMETER);

                String[] end = fields[7].split(HOUR_DELIMETER);
                Integer day = Integer.parseInt(end[2]);

                String cUid = fields[8];

                DateSchedule startHour = new DateSchedule(Integer.parseInt(start[0]), Integer.parseInt(start[1]), day);
                DateSchedule endHour = new DateSchedule(Integer.parseInt(end[0]), Integer.parseInt(end[1]), day);

                // verifica se a unidade curricular recebida existe nas unidades curriculares
                if (curricularUnitsST.contains(cUid)) {

                    // A turma é associada a unidade curricular e vice-versa dentro do construtor da turma.
                    Class aClass = new Class(idClass, year, studentsLimit, typeTurma, curricularUnitsST.get(cUid));
                    classST.put(aClass.getId(), aClass);
                    Lesson lesson = new Lesson(idLesson, startHour, endHour);

                    // Verifica se já existe alguma aula com o id recebido
                    if(!lessonsST.contains(idLesson)){
                        lessonsST.put(lesson.getId(), lesson);
                    }else{
                        System.out.println("[ERROR CLASS] Já existe uma Aula com id: " + idLesson + ", o iD vai ser alterado até um iD que não exista");
                        // Incrementar id de aula até um id que não exista.
                        while(lessonsST.contains(idLesson)){
                            idLesson++;
                        }
                        System.out.println("ID alterado para --> " + idLesson);
                        lesson.setId(idLesson);
                        lessonsST.put(lesson.getId(), lesson);
                    }

                    aClass.setLesson(lesson);

                    // verifica se existe um professor com o id recebido
                    if (teachersST.contains(idTeacher)) {
                        Teacher teacher = teachersST.get(idTeacher);
                        aClass.addTeacher(teacher);
                    } else {
                        System.out.println("[ERROR CLASS] Não existe nenhum professor com id: " + idTeacher);
                    }

                } else {
                    System.out.println("[ERROR CLASS] Não existe unidade curricular com id: " + cUid);
                }
            }else{
                System.out.println("[ERROR] Já existe uma turma com o id: " + idClass);
            }
        }
    }

    /**
     * Função que lê do ficheiro e associa uma sala a uma aula.
     * @param classRoomsRB RedBlack das salas
     * @param lessonsST SeparateChaining das aulas
     * @param path caminho para o ficheiro
     */
    public static void readAssociateClassroomsFromFile(RedBlackBST_AED2<String, Node> classRoomsRB, SeparateChainingHashST<Integer, Lesson> lessonsST, String path) {

        In in = new In(path);
        in.readLine();

        while (!in.isEmpty()) {
            String line = in.readLine();

            String[] fields = line.split(FILE_DELIMETER);
            Integer idlesson = Integer.parseInt(fields[0]);
            String idClassroom = fields[1];

            // verifica se existe uma aula com o id recebido
            if(lessonsST.contains(idlesson)){
                Lesson lesson = lessonsST.get(idlesson);
                // verifica se existe uma sala com o id recebido
                if(classRoomsRB.contains(idClassroom)){
                    lesson.addClassroom((Classroom) classRoomsRB.get(idClassroom));
                }else{
                    System.out.println("[ERROR] Não existe nenhuma sala com id: " + idClassroom);
                }
            }else{
                System.out.println("[ERROR] Não existe nenhuma aula com id: " + idlesson);
            }
        }
    }

    /**
     * Função que lê do ficheiro e associa Unidades Curriculares a professores
     * @param teachersST SeparateChaining de professores
     * @param curricularUnitsST SeparateChaining das Unidades Curriculares
     * @param path caminho para o ficheiro
     */
    public static void readTeacherCurricularUnitsFromFile(SeparateChainingHashST<Long, Teacher> teachersST, SeparateChainingHashST<String, CurricularUnit> curricularUnitsST, String path) {
        In in = new In(path);
        in.readLine();

        while (!in.isEmpty()) {
            String line = in.readLine();

            String[] fields = line.split(FILE_DELIMETER);
            Long idTeacher = Long.parseLong(fields[0]);
            String[] idCurricularUnits = fields[1].split("-");

            // Verifica a existencia de um professor com o id recebido
            if (teachersST.contains(idTeacher)) {
                Teacher t = teachersST.get(idTeacher);

                // Percorrer os Ids de unidades curriculares recebidos
                for (int i = 0; i < idCurricularUnits.length; i++){

                    // Verifica a existencia da unidade curricular com o id recebido.
                    if (curricularUnitsST.contains(idCurricularUnits[i])) {
                        CurricularUnit uc = curricularUnitsST.get(idCurricularUnits[i]);
                        t.putcUnit(uc);
                        curricularUnitsST.put(uc.getId(), uc);
                    } else {
                        System.out.println("[ERROR ASSOCIATE CURRICULAR UNITS TO TEACHER] Não existe nenhuma Unidade Curricular com id: " + idCurricularUnits[i]);
                    }
                }
            } else {
                System.out.println("[ERROR ASSOCIATE CURRICULAR UNITS TO TEACHER] Não existe nenhum professor com id: " + idTeacher);
            }
        }
    }

    /**
     * Lê do ficheiro as unidades curriculares associadas a cada estudante
     * @param studentsST SeparateChaining de estudantes
     * @param curricularUnitsST SeparateChaining de Unidades Curriculares
     * @param path caminho para ficheiro
     */
    public static void readStudentsCurricularUnitsFromFile(SeparateChainingHashST<Long, Student> studentsST, SeparateChainingHashST<String, CurricularUnit> curricularUnitsST, String path) {

        In in = new In(path);
        in.readLine();

        while (!in.isEmpty()) {
            String line = in.readLine();

            String[] fields = line.split(FILE_DELIMETER);
            Long idStudent = Long.parseLong(fields[0]);
            String[] idCurricularUnits = fields[1].split("-");

            // Verifica a existencia de um estudante com o id recebido
            if (studentsST.contains(idStudent)){
                Student s = studentsST.get(idStudent);

                // Ciclo para percorrer todos os id's de unidades curriculare recebidos
                for (int i = 0; i < idCurricularUnits.length; i++) {

                    // Verifica a existencia de uma unidade curricular com o id recebido
                    if (curricularUnitsST.contains(idCurricularUnits[i])) {
                        CurricularUnit uc = curricularUnitsST.get(idCurricularUnits[i]);
                        s.putcUnit(uc);
                        curricularUnitsST.put(uc.getId(), uc);
                    } else {
                        System.out.println("[ERROR ASSOCIATE CURRICULAR UNITS TO STUDENT] Não existe nenhuma Unidade Curricular com id: " + idCurricularUnits[i]);
                    }
                }

            }else {
                System.out.println("[ERROR ASSOCIATE CURRICULAR UNITS TO STUDENT] Não existe nenhum estudante com id: " + idStudent);
            }
        }
    }

    /**
     * Lê do ficheiro e associa estudantes as turmas
     * @param studentsST SeparateChaining de estudantes
     * @param classST SeparateChaining de turmas
     * @param path caminho para o ficheiro
     */
    public static void readStudentsClassFromFile(SeparateChainingHashST<Long, Student> studentsST, SeparateChainingHashST<String, Class> classST, String path) {

        In in = new In(path);
        in.readLine();

        while (!in.isEmpty()) {
            String line = in.readLine();

            String[] fields = line.split(FILE_DELIMETER);
            String idClass = fields[0];
            String[] idStudents = fields[1].split("-");

            // Verifica a existencia de uma class com o id recebido
            if(classST.contains(idClass)){
                Class t = classST.get(idClass);

                // Ciclo que percorre todos os estudantes recebidos
                for (int i = 0; i < idStudents.length; i++){

                    // Verifica a existencia do aluno com o id recebido
                    if(studentsST.contains(Long.parseLong(idStudents[i]))){
                        Student s = studentsST.get(Long.parseLong(idStudents[i]));

                        //addStudent adiciona o aluno a turma, e a turma as turmas do aluno
                        t.addStudent(s);
                    }else{
                        System.out.println("[ERROR STUDENTSCLASS] Não existe nenhum aluno com id: " + idStudents[i]);
                    }
                }
            }else{
                System.out.println("[ERROR STUDENTSCLASS] Não existe nenhuma aula com o id: " + idClass);
            }
        }
    }

    /**
     * Função que lê as salas do ficheiro e insere na RedBlack de nodes
     * @param classRoomsRB Redblack de nodes
     * @param path caminho do ficheiro
     */
    public static void readClassroomsFromFile(RedBlackBST_AED2<String, Node> classRoomsRB, String path) {
        In in = new In(path);
        in.readLine();

        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] fields = line.split(FILE_DELIMETER);

            String idclassroom = fields[0];
            Integer studentslimit = Integer.parseInt(fields[1]);
            Integer floor = Integer.parseInt(fields[2]);
            String about = "";
            if(fields.length == 6){
                System.out.println(fields[5]);
                about = fields[5];
            }

            // Verificar a existencia de uma sala com o mesmo ID
            if(!classRoomsRB.contains(idclassroom)) {
                Classroom s = new Classroom(idclassroom, studentslimit, about, Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), floor,true);
                classRoomsRB.put(s.getName(), s);
            }else{
                System.out.println("[ERROR ADD CLASSROOM] Já existe uma sala com o id " + idclassroom);
            }
        }
    }

    /**
     * Função que lê os pontos de passagem do ficheiro e insere na RedBlack de nodes
     * @param classRoomsRB Redblack de nodes
     * @param path caminho do ficheiro
     */
    public static void readCrossingPointsFromFile(RedBlackBST_AED2<String, Node> classRoomsRB, String path){
        In in = new In(path);
        in.readLine();

        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] fields = line.split(FILE_DELIMETER);
            String name = fields[0];
            Integer floor = Integer.parseInt(fields[1]);
            String about = fields[2];
            CrossingPoint crossingPoint = new CrossingPoint(name, about, Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), floor, false);
            crossingPoint.setFloor(floor);
            crossingPoint.setClassroom(false);

            if(!classRoomsRB.contains(name)){
                classRoomsRB.put(crossingPoint.getName(), crossingPoint);
            }else{
                System.out.println("[ERROR ADD CLASSROOM] Já existe um ponto com o id " + crossingPoint.getName());
            }
        }
    }

    public static void writeCrossingPointsToFile(RedBlackBST_AED2<String, Node> classRoomsRB, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);
        if(pw != null){
            pw.write("Name;Floor;About;X;Y\n");
            for(String key : classRoomsRB.keys()){
                if(classRoomsRB.get(key) instanceof CrossingPoint){
                    CrossingPoint crossingPoint = (CrossingPoint) classRoomsRB.get(key);
                    pw.write(crossingPoint.getName() + ";" + crossingPoint.getFloor() + ";" + crossingPoint.getAbout() +";" + crossingPoint.getX() + ";" + crossingPoint.getX() + "\n");
                }
            }
            pw.close();
        }
    }

    public static void writeClassroomsToFile(RedBlackBST_AED2<String, Node> classRoomsRB, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);
        if(pw != null){
            pw.write("id;LimitStudents;piso;x;y\n");
            for(String key : classRoomsRB.keys()){
                if(classRoomsRB.get(key) instanceof Classroom){
                    Classroom classroom = (Classroom) classRoomsRB.get(key);
                    pw.write(classroom.getName() + ";" + classroom.getStudentsLimit() + ";" + classroom.getFloor() + ";" + classroom.getX() + ";" + classroom.getY() + "\n");
                }
            }
            pw.close();
        }
    }

    public static void writeTeachersToFile(SeparateChainingHashST<Long, Teacher> teachersST, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);
        if(pw != null){
            pw.write("idNumber;Name;Adress;Birth;Email;Registration\n");
            for(Long key : teachersST.keys()){
                Teacher teacher = teachersST.get(key);
                pw.write(teacher.getNumber() + ";" + teacher.getName() + ";" + teacher.getAddress() + ";" + teacher.getBirth() + ";" + teacher.getEmail() + ";" + teacher.getRegistration() +"\n");
                }
            }
            pw.close();
        }

    public static void writeStudentsToFile(SeparateChainingHashST<Long, Student> studentsST, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);
        if(pw != null){
            pw.write("Number;Name;Adress;Birth;Email;Registration;\n");
            for(Long key : studentsST.keys()){
                Student student = studentsST.get(key);
                pw.write(student.getNumber() + ";" + student.getName() + ";" + student.getAddress() + ";" + student.getBirth() + ";" + student.getEmail() + ";" + student.getRegistration() + "\n");
            }
        }
        pw.close();
    }

    public static void writeAttendanceToFile(SeparateChainingHashST<Long, Teacher> teachersST,RedBlackBST_AED2<String, Node> classRoomsRB, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);
        if(pw != null){
            pw.write("idTeacher;classroom;HoraInicio;HoraFim;Dia;\n");
            for (Long key : teachersST.keys()) {
                Teacher teacher = teachersST.get(key);
                for (Integer aKey : teacher.getAttendanceBST().keys()) {
                    Attendance attendance = teacher.getAttendanceBST().get(aKey);
                    pw.write(teacher.getNumber() + ";" + attendance.getClassroom().getName() + ";" + attendance.getStarthour().toString() + ";" + attendance.getEndhour().toString() + ";" + attendance.getStarthour().getDay()+ "\n");
                }
            }
        }
        pw.close();
    }

    public static void writeCurricularUnitsToFile(SeparateChainingHashST<String, CurricularUnit> curricularUnitsST, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);
        if(pw != null){
            pw.write("id;name;ects;year\n");
            for (String key : curricularUnitsST.keys()) {
                CurricularUnit curricularUnit = curricularUnitsST.get(key);
                pw.write(curricularUnit.getId() + ";" + curricularUnit.getName() + ";" + curricularUnit.getEcts() + ";" + curricularUnit.getYear() + ";" + "\n");
            }
        }
        pw.close();
    }

    public static void writeTeacherCurricularUnitsToFile(SeparateChainingHashST<Long, Teacher> teachersST, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);
        if(pw != null){
            pw.write("idNumber;idCourseClass;\n");
            for (Long key : teachersST.keys()) {
                Teacher teacher = teachersST.get(key);
                for (String ucKey : teacher.getcUnit().keys()) {
                    CurricularUnit uc = teacher.getcUnit().get(ucKey);
                    pw.write(teacher.getNumber() + ";" + uc.getId() + "\n");
                }
            }
        }
        pw.close();
    }

    public static void writeStudentsCurricularUnitsToFile(SeparateChainingHashST<Long, Student> studentsST, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);
        if(pw != null){
            pw.write("idNumber;idCurricularUnits;\n");
            for (Long key : studentsST.keys()) {
                Student student = studentsST.get(key);
                pw.write(student.getNumber() + ";");
                int i = 0;
                for (String ucKey : student.getcUnit().keys()) {
                    i++;
                    CurricularUnit uc = student.getcUnit().get(ucKey);
                    if(i < student.getcUnit().size()){
                        pw.write(uc.getId() + "-");
                    }else{
                        pw.write(uc.getId());
                    }
                }
            }
        }
        pw.close();
    }

    //incompleto, falta verificar se a turma tem professor.
    /*public static void writeaClassomToFile(SeparateChainingHashST<String, Class> classST, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        PrintWriter pw = new PrintWriter(fw);
        if(pw != null){
            pw.write("id;year;limitStudents;idteacher;type;idClass;horaInicio;horaFim;ucId\n");
            for(String key : classST.keys()){
                Class aClass = classST.get(key);
                pw.write(aClass.getId() + ";" + aClass.getStudentsLimit() + ";" + student.getAddress() + ";" + student.getBirth() + ";" + student.getEmail() + ";" + student.getRegistration() + "\n");
            }
        }
        pw.close();
    }*/
}
