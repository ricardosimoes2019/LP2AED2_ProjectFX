package university;

import algs4.SeparateChainingHashST;
import algs4.SymbolGraph;

import java.io.*;

public abstract class DumpFiles {

    private static final String PATH_STUDENTS_BIN = ".//data//BinFiles//data_students.bin";
    private static final String PATH_TEACHERS_BIN = ".//data//BinFiles//data_teachers.bin";
    private static final String PATH_NODES_BIN = ".//data//BinFiles//data_nodes.bin";
    private static final String PATH_ACLASS_BIN = ".//data//BinFiles//data_aclass.bin";
    private static final String PATH_CUNITS_BIN = ".//data//BinFiles//data_cUnits.bin";
    private static final String PATH_LESSONS_BIN = ".//data//BinFiles//data_lessons.bin";
    private static final String PATH_SYMBOLGRAPH_BIN = ".//data//BinFiles//data_symbolgraph.bin";

    /**
     * Função que elimina um aluno por completo das ST's de alunos e aulas e adiciona num ficheiro de "lixo"
     *
     * @param classST    ST de aulas
     * @param studentsST ST de alunos
     * @param sNumber    número identificador do aluno a eliminar
     * @param path       caminho onde se encontra o ficheiro de "lixo"
     */
    public static void deleteStudent(SeparateChainingHashST<String, Class> classST, SeparateChainingHashST<Long, Student> studentsST, Long sNumber, String path) {
        Boolean newFile = false;

        Student s = studentsST.get(sNumber);
        studentsST.delete(sNumber);

        Date deleteDate = new Date();

        for (String key : classST.keys()) {
            classST.get(key).removeStudent(sNumber);
        }

        File file = new File(path);

        //Create the file
        try {
            if (file.createNewFile()) {
                System.out.println("New Text File is created!");
                newFile = true;
            } else {
                System.out.println("File already exists.");
                newFile = false;
            }
            //Write Content
            FileWriter writer = new FileWriter(file, true);
            if (newFile) {
                writer.write("Students Dump File:");
            }
            writer.write("\n\nRemoved at: " + deleteDate);
            writer.write("\n" + s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Função que elimina um professor por completo das ST de professores, Unidades Curriculares e aulas e o adiciona num ficheiro de "lixo"
     *
     * @param tNumber         número identificador do professor a remover
     * @param teachersST      ST de professores
     * @param curricularUnits ST de Unidades Curriculares
     * @param classST         ST de aulas
     * @param path            caminho para o ficheiro de "lixo"
     */
    public static void deleteTeacher(Long tNumber, SeparateChainingHashST<Long, Teacher> teachersST, SeparateChainingHashST<String, CurricularUnit> curricularUnits, SeparateChainingHashST<String, Class> classST, String path) {
        Boolean newFile = false;
        Date deleteDate = new Date();

        File file = new File(path);

        //Create the file
        try {
            if (file.createNewFile()) {
                System.out.println("New Text File is created!");
                newFile = true;
            } else {
                System.out.println("File already exists.");
                newFile = false;
            }
            //Write Content
            FileWriter writer = new FileWriter(file, true);
            if (newFile) {
                writer.write("Teachers Dump File:");
            }

            if (teachersST.contains(tNumber)) {
                Teacher t = teachersST.get(tNumber);

                writer.write("\n\nRemoved at: " + deleteDate);
                writer.write("\n" + t);

                for (String uKey : curricularUnits.keys()) {
                    CurricularUnit uCur = curricularUnits.get(uKey);
                    if (uCur.deleteTeacher(tNumber) != null) {
                        writer.write("\nRemoved From UC:" + uCur.getName());
                    }
                }

                for (String tKey : classST.keys()) {
                    Class aClass = classST.get(tKey);
                    if (aClass.getTeacher() != null) {
                        if (aClass.getTeacher().getNumber().equals(tNumber)) {
                            aClass.setTeacher(null);
                            writer.write("\nRemoved From Class: " + aClass.getId());
                        }
                    }
                }
                writer.close();
                teachersST.delete(t.getNumber());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Função que elimina uma sala de aula por completo das ST de salas de aula e das aulas e a adiciona a uma ficheiro de "lixo"
     *
     * @param idClassroom  identificador da sala a ser eliminada
     * @param classroomsST ST de salas de aula
     * @param lessonsST    ST de aulas
     * @param path         caminho para o ficheiro de "lixo"
     */
    public static void deleteClassroom(String idClassroom, RedBlackBST_AED2<String, Node> classroomsST, SeparateChainingHashST<Integer, Lesson> lessonsST, String path) {
        Boolean newFile = false;
        Date deleteDate = new Date();

        File file = new File(path);

        //Create the file
        try {
            if (file.createNewFile()) {
                System.out.println("New Text File is created!");
                newFile = true;
            } else {
                System.out.println("File already exists.");
                newFile = false;
            }
            //Write Content
            FileWriter writer = new FileWriter(file, true);
            if (newFile) {
                writer.write("Classrooms Dump File:");
            }
            Classroom s = (Classroom) classroomsST.get(idClassroom);
            writer.write("\n\nRemoved at: " + deleteDate);
            writer.write("\n" + s);

            for (Integer aKey : lessonsST.keys()) {
                Lesson a = lessonsST.get(aKey);
                if (a.getClassroom().getName().equals(idClassroom)) {
                    if (a.deleteClassroom()) {
                        writer.write("\nRemoved from Class: " + lessonsST.get(aKey));
                    }
                }
            }
            writer.close();
            classroomsST.delete(idClassroom);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Função que elimina por completo uma turma das ST's de turmas, aulas, salas de aula, Unidades Curriculares e alunos e a adiciona a um ficheiro de "lixo"
     *
     * @param idClass           identificador da turma a ser removida
     * @param classST           ST de turmas
     * @param curricularUnitsST ST de Unidades Curriculares
     * @param lessonsST         ST de aulas
     * @param classroomsST      ST de salas de aula
     * @param studentsST        ST de alunos
     * @param path              caminho para o ficheiro de "lixo"
     */
    public static void deleteClass(String idClass, SeparateChainingHashST<String, Class> classST, SeparateChainingHashST<String, CurricularUnit> curricularUnitsST, SeparateChainingHashST<Integer, Lesson> lessonsST, RedBlackBST_AED2<String, Node> classroomsST, SeparateChainingHashST<Long, Student> studentsST, String path) {
        Boolean newFile = false;
        Date deleteDate = new Date();

        File file = new File(path);

        //Create the file
        try {
            if (file.createNewFile()) {
                System.out.println("New Text File is created!");
                newFile = true;
            } else {
                System.out.println("File already exists.");
                newFile = false;
            }
            //Write Content
            FileWriter writer = new FileWriter(file, true);
            if (newFile) {
                writer.write("Class Dump File:");
            }
            if (classST.contains(idClass)) {
                Class aClass = classST.get(idClass);
                classST.delete(idClass);
                writer.write("\n\nRemoved at: " + deleteDate);
                writer.write("\n\n" + aClass);
                if (aClass.getLesson() != null && lessonsST.contains(aClass.getLesson().getId())) {
                    lessonsST.delete(aClass.getLesson().getId());
                    writer.write("\nClass " + aClass.getLesson() + ", deleted");
                    if (aClass.getLesson().classroom != null) {
                        classroomsST.delete(aClass.getLesson().getClassroom().getName());
                        writer.write("\nClass removed from Classroom: " + aClass.getLesson().getClassroom().getName());
                    }
                }

                if (curricularUnitsST.contains(aClass.getcUnit().getId())) {
                    curricularUnitsST.get(aClass.getcUnit().getId()).deleteClass(aClass.getId());
                    writer.write("\nClass removed from UC: " + aClass.getcUnit().getName());
                }

                writer.write("\nClass removed from Teacher: " + aClass.removeTeacher());

                writer.write("\nClass removed from this Students:");
                for (Long sKey : studentsST.keys()) {
                    if (studentsST.get(sKey).deleteClass(aClass.getId()) != null) {
                        writer.write("\n" + studentsST.get(sKey));
                    }
                }

            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Função que elimina por completo uma Unidade Curricular das ST's de Unidades Curriculares, aulas, turmas, alunos, professores e salas de aula e adiciona-a a um ficheiro de "lixo"
     *
     * @param idUc              identificador da Unidade Curricular a eliminar
     * @param curricularUnitsST ST de Unidades CUurriculares
     * @param classST           ST de turmas
     * @param lessonsST         ST de aulas
     * @param studentsST        ST de alunos
     * @param teachersST        ST de professores
     * @param classroomsST      ST de salas de aula
     * @param path              caminho para o ficheiro de "lixo"
     */
    public static void deleteCourseClass(String idUc, SeparateChainingHashST<String, CurricularUnit> curricularUnitsST, SeparateChainingHashST<String, Class> classST, SeparateChainingHashST<Integer, Lesson> lessonsST, SeparateChainingHashST<Long, Student> studentsST, SeparateChainingHashST<Long, Teacher> teachersST, RedBlackBST_AED2<String, Node> classroomsST, String path) {
        if (curricularUnitsST.contains(idUc)) {
            CurricularUnit uc = curricularUnitsST.get(idUc);

            Boolean newFile;
            Date deleteDate = new Date();

            File file = new File(path);

            //Create the file
            try {
                if (file.createNewFile()) {
                    System.out.println("New Text File is created!");
                    newFile = true;
                } else {
                    System.out.println("File already exists.");
                    newFile = false;
                }
                //Write Content
                FileWriter writer = new FileWriter(file, true);
                if (newFile) {
                    writer.write("Courseclass Dump File:");
                }
                writer.write("\n\nRemoved at: " + deleteDate);
                writer.write("\n\n" + uc);
                for (String cKey : classST.keys()) {
                    if (classST.get(cKey).getcUnit().getId().equals(uc.getId())) {
                        writer.write("\n" + classST.get(cKey));
                        deleteClass(classST.get(cKey).getId(), classST, curricularUnitsST, lessonsST, classroomsST, studentsST, ".//data//dump//Classdump.txt");
                        //classST.delete(cKey);
                    }
                }

                writer.write("\nCourseclass removed from this Teachers:");
                for (Long tKey : teachersST.keys()) {
                    if (teachersST.get(tKey).deletecUnit(uc.getId()) != null) {
                        writer.write("\n" + teachersST.get(tKey));
                    }
                }

                writer.write("\nCourseclass removed from this Students:");
                for (Long sKey : studentsST.keys()) {
                    if (studentsST.get(sKey).deletecUnit(uc.getId()) != null) {
                        writer.write("\n" + studentsST.get(sKey));
                    }
                }
                writer.close();
                curricularUnitsST.delete(uc.getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveBinStudents(SeparateChainingHashST<Long, Student> studentsST) {
        File f = new File(PATH_STUDENTS_BIN);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(studentsST.size());
            for (Long number : studentsST.keys()) {
                Student student = studentsST.get(number);
                oos.writeObject(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveBinTeachers(SeparateChainingHashST<Long, Teacher> teachersST) {
        File f = new File(PATH_TEACHERS_BIN);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(teachersST.size());
            for (Long number : teachersST.keys()) {
                Teacher teacher = (Teacher) teachersST.get(number);
                oos.writeObject(teacher);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveBinNodes(RedBlackBST_AED2<String, Node> nodesRB) {
        File f = new File(PATH_NODES_BIN);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(nodesRB.size());
            for (String name : nodesRB.keys()) {
                Node node = nodesRB.get(name);
                oos.writeObject(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveBinSymbolGraph(SymbolGraph_PROJ symbolGraph_proj) {
        File f = new File(PATH_SYMBOLGRAPH_BIN);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(symbolGraph_proj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveBinaClass(SeparateChainingHashST<String, Class> classST) {
        File f = new File(PATH_ACLASS_BIN);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(classST.size());
            for (String name : classST.keys()) {
                Class aClass = classST.get(name);
                oos.writeObject(aClass);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveBinCurricularUnits(SeparateChainingHashST<String, CurricularUnit> curricularUnitsST) {
        File f = new File(PATH_CUNITS_BIN);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(curricularUnitsST.size());
            for (String name : curricularUnitsST.keys()) {
                CurricularUnit curricularUnit = curricularUnitsST.get(name);
                oos.writeObject(curricularUnit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveBinLessons(SeparateChainingHashST<Integer, Lesson> lessonsST) {
        File f = new File(PATH_LESSONS_BIN);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(lessonsST.size());
            for (Integer name : lessonsST.keys()) {
                Lesson lesson = lessonsST.get(name);
                oos.writeObject(lesson);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBinCurricularUnits(SeparateChainingHashST<String, CurricularUnit> curricularUnitsST) {
        File f = new File(PATH_CUNITS_BIN);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Integer size = (Integer) ois.readObject();

            for (int i = 0; i < size; i++) {
                CurricularUnit curricularUnit = (CurricularUnit) ois.readObject();
                curricularUnitsST.put(curricularUnit.getId(), curricularUnit);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readBinLessons(SeparateChainingHashST<Integer, Lesson> lessonsST) {
        File f = new File(PATH_LESSONS_BIN);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Integer size = (Integer) ois.readObject();

            for (int i = 0; i < size; i++) {
                Lesson lesson = (Lesson) ois.readObject();
                lessonsST.put(lesson.getId(), lesson);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readBinaClass(SeparateChainingHashST<String, Class> classST) {
        File f = new File(PATH_ACLASS_BIN);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Integer size = (Integer) ois.readObject();

            for (int i = 0; i < size; i++) {
                Class aClass = (Class) ois.readObject();
                classST.put(aClass.getId(), aClass);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readBinNodes(RedBlackBST_AED2<String, Node> nodesRB) {
        File f = new File(PATH_NODES_BIN);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Integer size = (Integer) ois.readObject();

            for (int i = 0; i < size; i++) {
                Node node = (Node) ois.readObject();
                nodesRB.put(node.getName(), node);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readBinStudents(SeparateChainingHashST<Long, Student> studentsST) {
        File f = new File(PATH_STUDENTS_BIN);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Integer size = (Integer) ois.readObject();

            for (int i = 0; i < size; i++) {
                Student student = (Student) ois.readObject();
                studentsST.put(student.getNumber(), student);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readBinTeachers(SeparateChainingHashST<Long, Teacher> teachersST) {
        File f = new File(PATH_TEACHERS_BIN);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Integer size = (Integer) ois.readObject();

            for (int i = 0; i < size; i++) {
                Teacher teacher = (Teacher) ois.readObject();
                teachersST.put(teacher.getNumber(), teacher);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static SymbolGraph_PROJ readBinSymbolGraph() {
        File f = new File(PATH_SYMBOLGRAPH_BIN);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            SymbolGraph_PROJ symbolGraph_proj = (SymbolGraph_PROJ) ois.readObject();
            return symbolGraph_proj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
