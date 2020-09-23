package sample;

import algs4.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import university.*;
import university.Class;
import university.Date;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller extends SearchFunctions implements Initializable {

    private static String FILE_DELIMETER = ";";
    public Group graphGroup;
    public TitledPane aboutPane;
    public TextField abouIdField;
    public TextField aboutFloorField;
    public TextField aboutSizeField;
    public CheckBox freeCheck;
    public TextArea aboutField;
    public TextField classroomAboutFieldSearch;
    public TextField classroom1;
    public TextField classroom2;
    public TitledPane pathPane;
    public AnchorPane pathPopup;
    public TextArea pathField;
    public TitledPane connectedPane;
    public TitledPane passagePane;
    public TextArea passageField;
    public TitledPane nodeInsertPane;
    public TitledPane classroomInsertPane;
    public TextField classroomNameField;
    public TextField classroomXField;
    public TextField classroomYField;
    public TextField classroomFloorField;
    public TitledPane crossingPInsertPane;
    public TextArea classroomConnectedTextAreaField;
    public TextField aboutClassroomField;
    public TextField crossingPNameField;
    public TextField crossingPAboutField;
    public TextField crossingPXField;
    public TextField crossingPYField;
    public TextField crossingPFloorField;
    public TextArea crossingPConnectedField;
    public TextField classroomLimitStudentsPane;
    public TextField noderemovefield;
    public TitledPane nodeRemovePane;
    public TableColumn nameCol;
    public TableColumn floorCol;
    public TableColumn studentsLimitCol;
    public TableColumn aboutCol;
    public TableView classroomTable;
    public TitledPane classroomNowPane;
    public TitledPane classroomStatePane;
    public TableColumn nowNameCol;
    public TableColumn nowFloorCol;
    public TableColumn nowLimitCol;
    public TableColumn nowAboutCol;
    public TableView nowClassroomTable;
    public TextField classroomNowSearch;
    public TextField showClassAtMoment;
    public TitledPane classroomLessonsBetweenPane;
    public TextField classroombetweenSearch;
    public TableView lessonsBetweenTable;
    public TableColumn idLessonsBetweenCol;
    public TableColumn startHLessonsBetweenCol;
    public TableColumn endHLessonsBetweenCol1;
    public TitledPane classroomBetweenPane;
    public TableView betweenClassroomTable;
    public TableColumn betweenNameCol;
    public TableColumn betweenFloorCol;
    public TableColumn betweenLimitCol;
    public TableColumn betweenAboutCol;
    public TitledPane classroombetweenSearchpane;
    public TextField startHourClassroomSearch;
    public TextField endHourClassroomSearch1;
    public TextField dayClassroomSearch;
    public TitledPane classroomBySizeTabPane;
    public TitledPane classroomBySizePane;
    public TextField bysizeClassroomField;
    public TableColumn bySizeNameCol;
    public TableView bySizeClassroomTable;
    public TableColumn bySizeFloorCol;
    public TableColumn bySizeLimitCol;
    public TableColumn bySizeAboutCol;
    public TitledPane lessonsByClassroomSearchPane;
    public TextField lessonsByClassroomField;
    public TextField lessonsStartHourSearchField;
    public TextField lessonsDaySearchField;
    public TableColumn idLessonCol;
    public TableColumn startHLessonCol;
    public TableColumn endHLessonCol;
    public TableView lessonsTable;
    public TitledPane lessonsPane;
    public TextField lessonsEndHourSearchField;
    public TableColumn dayLessonCol;
    public ComboBox startHourComboBox;
    public TitledPane insertLessonPane;
    public ComboBox endHourComboBox1;
    public ComboBox dayComboBox;
    public ComboBox classroomComboBox;
    public ComboBox uCurricComboBox;
    public TextField aClassNameField;
    public TextField aClassSizeField;
    public TextField aClassTypeField;
    public ComboBox teacherComboBox;
    public TableView<Lesson> allLessonsTable;
    public TableColumn<Lesson, String> idLessonsCol;
    public TableColumn<Lesson, String> starthourLessonsCol;
    public TableColumn<Lesson, String> endhourLessonsCol;
    public TableColumn<Lesson, String> dayLessonsCol;
    public TableColumn<Lesson, Classroom> classroomLessonsCol;
    public TableColumn<Lesson, Class> aClassLessonsCol;
    public TitledPane deleteLessonPane;
    public ComboBox allLessonsComboBox;
    public ComboBox allLessonsComboBox1;
    public ComboBox classroomLessonComboBox;
    public TitledPane changeClassroomLessonPane;
    public TableView aClassTable;
    public TableColumn idaClassCol;
    public TableColumn yearaClassCol;
    public TableColumn studentLimitaClassCol;
    public TableColumn typeaClassCol;
    public TableColumn teacheraClassCol;
    public TableColumn ucurraClassCol;
    public TableColumn lessonaClassCol;
    public ComboBox allClassComboBox;
    public TextField sizeChangeClassField;
    public ComboBox teacherChangeClassComboBox;
    public TitledPane changeClassPane;
    public TitledPane addLessontoClassPane;
    public ComboBox startHouraddLessonComboBox;
    public TextField sizeChangeClassField1;
    public ComboBox endHouraddLessonComboBox;
    public ComboBox dayAddLessonComboBox;
    public ComboBox classroomsAddLessonComboBox;
    public ComboBox allaClasswithoutLessonComboBox;
    public TitledPane changeScheduleLessonPane;
    public ComboBox allLessonsComboBoxScheduleEdit;
    public ComboBox editStartHourComboBox;
    public ComboBox editEndHourComboBox;
    public ComboBox editDayComboBox;
    public TableView curricularUnitTable;
    public TableColumn idCurricularUnitCol;
    public TableColumn ectsCurricularUnitCol;
    public TableColumn yearCurricularUnitCol;
    public TableColumn nameCurricularUnitCol;
    public TitledPane removeCurricularUnitPane;
    public ComboBox curricularUnitComboBox;
    public TitledPane curricularUnitNowPane;
    public TableView nowCurricularUnitTable;
    public TableColumn nowCurricularUnitNameCol;
    public TableView studentsTable;
    public TableColumn numberStudentsCol;
    public TableColumn nameStudentsCol;
    public TableColumn emailStudentsCol;
    public TableColumn registrationStudentsCol;
    public TableView teachersTable;
    public TableColumn teacherNumberCol;
    public TableColumn nameTeacherCol;
    public TableColumn registrationTeacherCol;
    public TableColumn emailTeacherCol;
    public TitledPane teacherAttendancePane;
    public ComboBox allTeachersComboBox;
    public TableView attendanceShowTable;
    public TableColumn classroomAttendanceCol;
    public TableColumn startAttendanceCol;
    public TableColumn endAttendanceCol;
    public TableColumn dayattendanceCol;
    public TitledPane teachersBusyPane;
    public TableView busyTeachersTable;
    public TableColumn busyTeacherNumberCol;
    public TableColumn busyTeacherNameCol;
    public TitledPane studentsBusyPane;
    public TableView busyStudentsTable;
    public TableColumn busyStudentsNameCol;
    public TableColumn busyStudentsNumberCol;
    public TitledPane teacheraClassPane;
    public ComboBox allTeachersComboBox1;
    public TableView aClassTeacherShowTable;
    public TableColumn startaClassTeacherCol;
    public TableColumn endaClassTeacherCol;
    public TableColumn dayaClassTeacherCol;
    public TableColumn classroomaClassTeacherCol;
    public TitledPane removeTeacherPane;
    public ComboBox allTeacherToRemoveComboBox;
    public ComboBox allCurricularUnitsComboBox;
    public TableView cUnitsTeachersTable;
    public TableColumn cUnitsTeacherNumberCol;
    public TableColumn cUnitsTeachersNameCol;
    public TableView aClassStudentTable;
    public TitledPane studentsaClassPane;
    public TableColumn aClassStudentsclassroomCol;
    public TableColumn aClassStudentsstartCol;
    public TableColumn aClassStudentsendCol;
    public TableColumn aClassStudentsdayCol;
    public ComboBox allStudentsComboBox;
    public ComboBox allStudentstoRemoveComboBox;
    public TitledPane removeStudentPane;
    public ComboBox allaClassStudentsComboBox;
    public TableView aClassStudentsTable;
    public TableColumn aClassNumberStudentCol;
    public TableColumn aClassNameStudentCol;
    public TitledPane aClassStudentsPane;
    public TextField curricularUnitidField;
    public TextField curricularUnitEctsField;
    public TextField curricularUnitYearField;
    public TextField curricularUnitNameField;
    public ComboBox allCurricularUnitsToAssociateComboBox;
    public ComboBox allTeachersToCurricularComboBox;
    public TitledPane associateTeacherToCurricularUnitPane;
    public TitledPane insertStudentPane;
    public TextField numberInsertStudentField;
    public TextField nameStudentInsertField;
    public TextField addressStudentInsertField;
    public TextField emailStudentInsertField;
    public TextField birthStudentInsertField;
    public TitledPane associateStudentaClassPane;
    public ComboBox allStudentsAssociateaClassComboBox;
    public ComboBox allClasstoAssociateStudentsComboBox;
    public TitledPane cUnitsStudentsAssociatePane;
    public ComboBox allCurricularUnitsAssociateStudentComboBox;
    public ComboBox studentsWithoutcUnitComboBox;
    public TabPane teachersandStudentsCUnitsPane;
    public ComboBox allCurricularUnitsComboBox1;
    public TableView cUnitsStudentsTable;
    public TableColumn cUnitsStudentsNumberCol;
    public TableColumn cUnitsStudentsNameCol;
    private SymbolGraph_PROJ symbolGraph;
    private double radius = 10;

    RedBlackBST_AED2<String, Node> nodesRB = new RedBlackBST_AED2<>();
    SeparateChainingHashST<Long, Teacher> teachersST = new SeparateChainingHashST<>();
    SeparateChainingHashST<String, CurricularUnit> curricularUnitsST = new SeparateChainingHashST<>();
    SeparateChainingHashST<Long, Student> studentsST = new SeparateChainingHashST<>();
    SeparateChainingHashST<String, Class> classST = new SeparateChainingHashST<>();
    SeparateChainingHashST<Integer, Lesson> lessonsST = new SeparateChainingHashST<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillTableCols();
    }

    /**
     * Função utilizada para identificar todas as colunas das tabelas utilizadas.
     */
    private void fillTableCols() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        floorCol.setCellValueFactory(new PropertyValueFactory<>("floor"));
        studentsLimitCol.setCellValueFactory(new PropertyValueFactory<>("studentsLimit"));
        aboutCol.setCellValueFactory(new PropertyValueFactory<>("about"));

        nowNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nowAboutCol.setCellValueFactory(new PropertyValueFactory<>("about"));
        nowFloorCol.setCellValueFactory(new PropertyValueFactory<>("floor"));
        nowLimitCol.setCellValueFactory(new PropertyValueFactory<>("studentsLimit"));

        idLessonsBetweenCol.setCellValueFactory(new PropertyValueFactory<>("classroomName"));
        startHLessonsBetweenCol.setCellValueFactory(new PropertyValueFactory<>("startHour"));
        endHLessonsBetweenCol1.setCellValueFactory(new PropertyValueFactory<>("endHour"));

        bySizeNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        bySizeLimitCol.setCellValueFactory(new PropertyValueFactory<>("studentsLimit"));
        bySizeFloorCol.setCellValueFactory(new PropertyValueFactory<>("floor"));
        bySizeAboutCol.setCellValueFactory(new PropertyValueFactory<>("about"));

        idLessonCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        startHLessonCol.setCellValueFactory(new PropertyValueFactory<>("starthour"));
        endHLessonCol.setCellValueFactory(new PropertyValueFactory<>("endhour"));
        dayLessonCol.setCellValueFactory(new PropertyValueFactory<>("day"));

        idLessonsCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        starthourLessonsCol.setCellValueFactory(new PropertyValueFactory<>("starthour"));
        endhourLessonsCol.setCellValueFactory(new PropertyValueFactory<>("endhour"));
        dayLessonsCol.setCellValueFactory(new PropertyValueFactory<>("day"));
        // problema com associação da Turma na tabela.
        //aClassLessonsCol.setCellValueFactory(new PropertyValueFactory<>("aClass"));
        classroomLessonsCol.setCellValueFactory(new PropertyValueFactory<>("classroom"));

        idaClassCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        yearaClassCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        studentLimitaClassCol.setCellValueFactory(new PropertyValueFactory<>("studentsLimit"));
        typeaClassCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        teacheraClassCol.setCellValueFactory(new PropertyValueFactory<>("teacher"));
        ucurraClassCol.setCellValueFactory(new PropertyValueFactory<>("curricularUnit"));
        lessonaClassCol.setCellValueFactory(new PropertyValueFactory<>("lesson"));

        idCurricularUnitCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        ectsCurricularUnitCol.setCellValueFactory(new PropertyValueFactory<>("ects"));
        nameCurricularUnitCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        yearCurricularUnitCol.setCellValueFactory(new PropertyValueFactory<>("year"));

        nowCurricularUnitNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        numberStudentsCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        nameStudentsCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        registrationStudentsCol.setCellValueFactory(new PropertyValueFactory<>("registration"));
        emailStudentsCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        teacherNumberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        nameTeacherCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        registrationTeacherCol.setCellValueFactory(new PropertyValueFactory<>("registration"));
        emailTeacherCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        classroomAttendanceCol.setCellValueFactory(new PropertyValueFactory<>("classroom"));
        startAttendanceCol.setCellValueFactory(new PropertyValueFactory<>("starthour"));
        endAttendanceCol.setCellValueFactory(new PropertyValueFactory<>("endhour"));
        dayattendanceCol.setCellValueFactory(new PropertyValueFactory<>("day"));

        busyTeacherNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        busyTeacherNumberCol.setCellValueFactory(new PropertyValueFactory<>("number"));

        busyStudentsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        busyStudentsNumberCol.setCellValueFactory(new PropertyValueFactory<>("number"));

        classroomaClassTeacherCol.setCellValueFactory(new PropertyValueFactory<>("classroom"));
        startaClassTeacherCol.setCellValueFactory(new PropertyValueFactory<>("starthour"));
        endaClassTeacherCol.setCellValueFactory(new PropertyValueFactory<>("endhour"));
        dayaClassTeacherCol.setCellValueFactory(new PropertyValueFactory<>("day"));

        cUnitsTeacherNumberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        cUnitsTeachersNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        aClassStudentsclassroomCol.setCellValueFactory(new PropertyValueFactory<>("classroom"));
        aClassStudentsstartCol.setCellValueFactory(new PropertyValueFactory<>("starthour"));
        aClassStudentsendCol.setCellValueFactory(new PropertyValueFactory<>("endhour"));
        aClassStudentsdayCol.setCellValueFactory(new PropertyValueFactory<>("day"));

        aClassNameStudentCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        aClassNumberStudentCol.setCellValueFactory(new PropertyValueFactory<>("number"));

        cUnitsStudentsNumberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        cUnitsStudentsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    /**
     * Função que adiciona as ligações à interface gráfica.
     *
     * @param floor andar que vai ser adicionado a interface gráfica
     */
    private void createGraph(Integer floor) {

        SymbolGraph_PROJ subGraph = createSubEdgeWeightedDiGraph(floor);

        for (int v = 0; v < subGraph.graph().V(); v++) {
            Node nodeFrom = nodesRB.get(subGraph.nameOf(v));

            //ciclo para percorrer todas as ligações
            for (DirectedEdge_PROJ w : subGraph.graph().adj(v)) {
                //verificar se a ligação está habilitada ou desabilitada.
                if (!w.isDisabled()) {
                    Node nodeTo = nodesRB.get(subGraph.nameOf(w.to()));

                        Line line = new Line(nodeFrom.getX(), nodeFrom.getY(), nodeTo.getX(), nodeTo.getY());

                        // dependendo da direção da ligação, a cor da linha é alterada (azul da direita para a esquerda )
                        if (nodeFrom.getX() < nodeTo.getX()) {
                            line.setStroke(Color.BLUE);
                        } else if (nodeFrom.getY() > nodeTo.getY()) {
                            line.setStroke(Color.BLUE);
                        }
                        if (!(nodeFrom instanceof Classroom)) {
                            line.setStartX(nodeFrom.getX() + 10);
                        }
                        if (!(nodeTo instanceof Classroom)) {
                            line.setEndX(nodeTo.getX() + 10);
                        }

                        // ciclo para verificar se existe ligação no sentido contrário.
                        for (DirectedEdge_PROJ w1 : subGraph.graph().adj(subGraph.indexOf((nodeTo).getName()))) {
                            if (!w1.isDisabled()) {
                                Node nd2 = nodesRB.get(subGraph.nameOf(w1.to()));
                                if (nd2 == nodeFrom) {
                                    // se houver ligação para os dois sentidos, a ligação fica da cor verde
                                    line.setStroke(Color.GREEN);
                                }
                            }
                        }
                        graphGroup.getChildren().add(line);
                }
            }
        }
    }


    /**
     * Função que cria os circulos que representam os nodes na interface gráfica
     *
     * @param floor andar que vai ser representado
     */
    public void createCircles(int floor) {

        // percorre todos as salas e pontos de passagem
        for (String id : nodesRB.keys()) {
            Node node = nodesRB.get(id);
            // verifica se o nó recebido da RB faz parte do andar recebido.
            if (node.getFloor() == floor) {
                //criação do circulo para inserção na interface gráfica.
                Circle c = new Circle(node.getX(), node.getY(), radius);
                StackPane stack = new StackPane();

                // se for uma sala fica da cor vermelha e com tamanho = radius
                if (node instanceof Classroom) {
                    c.setFill(Color.RED);
                    Classroom classroom = (Classroom) node;
                    c.setId("" + classroom.getName());
                    Text text = new Text("" + classroom.getName());
                    stack.getChildren().addAll(c, text);
                    stack.setId("" + classroom.getName());

                    // se for um ponto de passagem fica da cor verde e com metade do radius
                } else {
                    c.setRadius(radius - 5);
                    c.setFill(Color.GREEN);
                    CrossingPoint crossingPoint = (CrossingPoint) node;
                    c.setId("" + crossingPoint.getName());
                    Text text = new Text("" + crossingPoint.getName());
                    stack.getChildren().addAll(c, text);
                    stack.setId("" + crossingPoint.getName());
                }
                stack.setLayoutX(node.getX() - radius);
                stack.setLayoutY(node.getY() - radius);
                graphGroup.getChildren().add(stack);
                //System.out.println("id = " + id);
                //System.out.println(node.getX() + " " + node.getY());
            }
        }

    }

    /**
     * Função chamada quando o botão de 1º Andar é pressionado. Faz a representação gráfica do Primeiro Andar
     *
     * @param actionEvent
     */
    public void handleFirstFloorButton(ActionEvent actionEvent) {
        graphGroup.getChildren().clear();
        // criação das linhas das ligações
        createGraph(1);
        // criação dos circulos que representão os nodes
        createCircles(1);

        // criação de linhas na interface gráfica.
        Line lineX = new Line(370, 70, 370, 130);
        Line line1X = new Line(230, 70, 230, 130);
        Line lineY = new Line(370, 70, 230, 70);
        Line line1Y = new Line(370, 130, 230, 130);

        treeMaker(250, 85, 120);
        treeMaker(300, 85, 120);
        treeMaker(350, 85, 120);

        graphGroup.getChildren().add(lineX);
        graphGroup.getChildren().add(line1X);
        graphGroup.getChildren().add(lineY);
        graphGroup.getChildren().add(line1Y);

    }

    /**
     * Função chamada quando o botão de 2º Andar é pressionado. Faz a representação gráfica do Segundo Andar
     *
     * @param actionEvent
     */
    public void handleSecondFloorButton(ActionEvent actionEvent) {
        graphGroup.getChildren().clear();
        createGraph(2);
        createCircles(2);

        // criação de linhas na interface gráfica.
        Line lineX = new Line(370, 70, 370, 130);
        Line line1X = new Line(230, 70, 230, 130);
        Line lineY = new Line(370, 70, 230, 70);
        Line line1Y = new Line(370, 130, 230, 130);

        treeMaker(250, 85, 120);
        treeMaker(300, 85, 120);
        treeMaker(350, 85, 120);

        graphGroup.getChildren().add(lineX);
        graphGroup.getChildren().add(line1X);
        graphGroup.getChildren().add(lineY);
        graphGroup.getChildren().add(line1Y);
    }

    /**
     * Função chamada quando o botão de 3º Andar é pressionado. Faz a representação gráfica do Terceiro Andar
     *
     * @param actionEvent
     */
    public void handleThirdFloorButton(ActionEvent actionEvent) {
        graphGroup.getChildren().clear();
        createGraph(3);
        createCircles(3);

        // criação de linhas na interface gráfica.
        Line lineX = new Line(370, 70, 370, 130);
        Line line1X = new Line(230, 70, 230, 130);
        Line lineY = new Line(370, 70, 230, 70);
        Line line1Y = new Line(370, 130, 230, 130);

        treeMaker(250, 85, 120);
        treeMaker(300, 85, 120);
        treeMaker(350, 85, 120);

        graphGroup.getChildren().add(lineX);
        graphGroup.getChildren().add(line1X);
        graphGroup.getChildren().add(lineY);
        graphGroup.getChildren().add(line1Y);
    }

    /**
     * Função que abre PopUp com informação da sala pedida
     *
     * @param actionEvent
     */
    public void handleAboutClassroom(ActionEvent actionEvent) {
        //verifica se a Pane está visivel ou não
        if (aboutPane.isVisible()) {
            aboutPane.setVisible(false);
            abouIdField.clear();
            aboutFloorField.clear();
            aboutSizeField.clear();
            aboutField.clear();
        } else {
            // limpa o graph que estiver a aparecer na interface gráfica
            graphGroup.getChildren().clear();
            // recebe o nome da sala que vai ser pesquisada
            String classroom = classroomAboutFieldSearch.getText();

            //verifica a existencia dessa sala na RB de nodes.
            if (nodesRB.contains(classroom)) {
                Node nd1 = nodesRB.get(classroom);
                // verifica se é uma sala
                if (nd1 instanceof Classroom) {
                    aboutPane.setVisible(true);
                    Classroom c = (Classroom) nd1;
                    //DateSchedule now = new DateSchedule();
                    DateSchedule nowtest = new DateSchedule(15, 0, 2);
                    abouIdField.setText(c.getName());
                    aboutFloorField.setText(c.getFloor().toString());
                    aboutSizeField.setText(c.getStudentsLimit().toString());
                    if (c.classroomstate(nowtest) == null) {
                        freeCheck.setSelected(false);
                    } else {
                        freeCheck.setSelected(true);
                    }
                    aboutField.setText(c.getAbout());
                    aboutPane.setVisible(true);
                } else {
                    alert(Alert.AlertType.ERROR, "Error", "Ups, algo correu mal", "Não existe nenhuma Sala com esse nome");
                }
            } else {
                alert(Alert.AlertType.ERROR, "Error", "Ups, algo correu mal", "Não existe nenhuma Sala com esse nome");
            }
        }
    }

    /**
     * Função que mostra o Pane com o caminho mais perto entre 2 pontos
     *
     * @param actionEvent
     */
    public void handleGetBestWayButton(ActionEvent actionEvent) {
        if (pathPane.isVisible()) {
            pathPane.setVisible(false);
            classroom1.clear();
            classroom2.clear();

        } else {

            graphGroup.getChildren().clear();


            String classroom = classroom1.getText();
            String classroom1 = classroom2.getText();

            StringBuilder pathDistance = new StringBuilder();
            StringBuilder pathTime = new StringBuilder();

            if (nodesRB.contains(classroom) && nodesRB.contains(classroom1)) {
                //Dijkstra verifica se todos os DirectedEdges estão habilitados, ou não.
                DijkstraSP_PROJ sp = new DijkstraSP_PROJ(symbolGraph.graph(), symbolGraph.indexOf(classroom));

                // Caminho mais curto
                if (sp.pathTo(symbolGraph.indexOf(classroom1)) != null) {
                    for (DirectedEdge_PROJ e : sp.pathTo(symbolGraph.indexOf(classroom1))) {
                        System.out.println(e.from() + "->" + e.to());
                        pathDistance.append(symbolGraph.nameOf(e.from())).append("->").append(symbolGraph.nameOf(e.to())).append("   ");
                    }

                    // Caminho mais rapido
                    for (DirectedEdge_PROJ e : sp.pathToT(symbolGraph.indexOf(classroom1))) {
                        pathTime.append(symbolGraph.nameOf(e.from())).append("->").append(symbolGraph.nameOf(e.to())).append("   ");
                    }

                    pathField.setText("A distancia mais curta entre " + classroom + " e " + classroom1 + " é -> " + sp.distTo(symbolGraph.indexOf(classroom1))
                            + "\nPelo seguinte caminho: " + pathDistance + "\n"
                            + "O caminho mais rapido " + sp.timeTo(symbolGraph.indexOf(classroom1))
                            + "\nPelo seguinte caminho: " + pathTime);

                    pathPane.setVisible(true);
                } else {
                    alert(Alert.AlertType.WARNING, "Warning!", "Ups, algo correu mal", "Não existe nenhum caminho entre " + classroom + " e " + classroom1);
                }

            } else {
                alert(Alert.AlertType.ERROR, "Error", "Ups, algo correu mal", "Apenas podem ser feitas pesquisas a salas/pontos de passagem existentes. Por favor pesquise por eles");
            }
        }
    }

    /**
     * Função que verifica se o primeiro andar é conexo
     *
     * @param actionEvent
     */
    public void handleFirstFloorConnectedButton(ActionEvent actionEvent) {
        isFloorConnected(1);
    }

    /**
     * Função que verifica se o segundo andar é conexo
     *
     * @param actionEvent
     */
    public void handleSecondFloorConnectedButton(ActionEvent actionEvent) {
        isFloorConnected(2);
    }

    /**
     * Função que verifica se o terceiro andar é conexo
     *
     * @param actionEvent
     */
    public void handleThirdFloorConnected(ActionEvent actionEvent) {
        isFloorConnected(3);
    }

    /**
     * Função que verifica se todos os andares são conexos
     *
     * @param actionEvent
     */
    public void handleAllFloorsConnected(ActionEvent actionEvent) {

        // criação do dfs desde o inicio do graph neste caso a entrada
        DepthFirstDirectedPaths_PROJ dfs = new DepthFirstDirectedPaths_PROJ(symbolGraph.graph(), symbolGraph.indexOf("Entrada"));
        System.out.println("\n------ Path to: ------");
        boolean connected = true;

        //Imprimir o "caminho" de source(s) até todos os vértices
        for (int v = 0; v < symbolGraph.graph().V(); v++) {
            if (dfs.hasPathTo(v)) {
                System.out.print(symbolGraph.nameOf(0) + " to " + symbolGraph.nameOf(v) + ": ");
                for (int x : dfs.pathTo(v)) {
                    if (x == 0) System.out.print(symbolGraph.nameOf(x));
                    else System.out.print("-" + symbolGraph.nameOf(x));
                }
            } else {
                connected = false;
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Ups, o edificio não é conexo");
                alert.setContentText(symbolGraph.nameOf(0) + " até " + symbolGraph.nameOf(v) + ": não estão conectados");

                alert.showAndWait();
            }
        }
        if (connected) {
            alert(Alert.AlertType.CONFIRMATION, "Sucesso", "O edificio é conexo!", "Todos os pontos do edificio estão conectados!");
        }
    }

    /**
     * Função que coloca a Pane das opções de conexos visivel ou invisível
     *
     * @param actionEvent
     */
    public void connectedDigraph(ActionEvent actionEvent) {
        connectedPane.setVisible(!connectedPane.isVisible());
    }

    /**
     * Função que coloca a pane das passagem visivel
     *
     * @param actionEvent
     */
    public void handlePassageButton(ActionEvent actionEvent) {
        passagePane.setVisible(true);
    }

    /**
     * Função que coloca a pane das passagem invisivel
     *
     * @param actionEvent
     */
    public void handleClosePassagePopUp(ActionEvent actionEvent) {
        passagePane.setVisible(false);
        passageField.clear();
    }

    /**
     * Função que habilita uma passagem.
     *
     * @param actionEvent
     */
    public void handleEnablePassage(ActionEvent actionEvent) {

        boolean changed;
        boolean updated;
        String passage = passageField.getText();
        String[] lines = passage.split("\n");

        for (String line : lines) {
            changed = false;
            updated = false;
            String[] fields = line.split(FILE_DELIMETER);

            String firstPoint = fields[0];
            String secondPoint = fields[1];

                for (DirectedEdge_PROJ dE : symbolGraph.graph().adj(symbolGraph.indexOf(firstPoint))) {
                    // verificar se a ligação já existe.
                    if (dE.from() == symbolGraph.indexOf(firstPoint) && dE.to() == symbolGraph.indexOf(secondPoint)) {
                        if (fields.length == 3) {
                            dE.setWeight(Double.parseDouble(fields[2]));
                            System.out.println("Peso da ligação " + firstPoint + " para " + secondPoint + " alterado ");
                            updated = true;
                        } else if (fields.length == 4) {
                            dE.setWeight(Double.parseDouble(fields[2]));
                            dE.setTime(Double.parseDouble(fields[3]));
                            System.out.println("Peso da ligação e Tempo" + firstPoint + " para " + secondPoint + " alterado ");
                            updated = true;
                        }
                        dE.setDisabled(false);
                        System.out.println("habilitado de " + firstPoint + " para " + secondPoint);
                        changed = true;

                        if (updated) {
                            alert(Alert.AlertType.CONFIRMATION, "Atualizado!", "Ligação atualizada", "A ligação entre " + firstPoint + " e " + secondPoint + " Foi atualizada!\nDistancia: " + dE.weight() + " Tempo: " + dE.time());
                        }
                    }
                }

            // se changed não foi alterado para true significa que a passagem ainda não existia.
            if (!changed) {
                if (nodesRB.contains(firstPoint) && nodesRB.contains(secondPoint)) {
                    if (fields.length == 4) {
                        System.out.println("length = " + fields.length);
                        double weight = Double.parseDouble(fields[2]);
                        double time = Double.parseDouble(fields[3]);

                        DirectedEdge_PROJ newEdge = new DirectedEdge_PROJ(symbolGraph.indexOf(firstPoint), symbolGraph.indexOf(secondPoint), weight, time);
                        symbolGraph.graph().addEdge(newEdge);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Sucesso!");
                        alert.setContentText("Passagem habilitada com sucesso!");
                        alert.showAndWait();

                    } else {
                        alert(Alert.AlertType.WARNING, "Warning Dialog", "Ups, não existe ligação", "Não existe ligação entre o ponto " + firstPoint + " e " + secondPoint + "\nPara criar ligação acrescente peso e tempo a frente da ligação");
                    }
                } else {
                    alert(Alert.AlertType.WARNING, "Warning Dialog", "Ups, ponto inexistente", "Por favor, selecione 2 pontos existentes");
                }
            }

            createGraph(nodesRB.get(firstPoint).getFloor());
            createCircles(nodesRB.get(firstPoint).getFloor());
            passagePane.setVisible(false);
        }
    }

    /**
     * Função que desabilita uma passagem.
     *
     * @param actionEvent
     */
    public void handledisablePassage(ActionEvent actionEvent) {
        boolean changed;
        String passage = passageField.getText();
        String[] lines = passage.split("\n");

        for (String line : lines) {
            changed = false;
            String[] fields = line.split(FILE_DELIMETER);

            String firstPoint = fields[0];
            String secondPoint = fields[1];


            for (DirectedEdge_PROJ dE : symbolGraph.graph().adj(symbolGraph.indexOf(firstPoint))) {
                if (dE.from() == symbolGraph.indexOf(firstPoint) && dE.to() == symbolGraph.indexOf(secondPoint)) {
                    dE.setDisabled(true);
                    System.out.println("Desabilitado de " + firstPoint + " para " + secondPoint);
                    changed = true;
                }
            }

            // se changed não for igual a true significa que não foi encontrada ligação entre esses 2 pontos
            if (!changed) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Ups, não existe ligação");
                alert.setContentText("Não existe ligação entre o ponto " + firstPoint + " e " + secondPoint + "\n Escolha 2 pontos seguidos");

                alert.showAndWait();
            }

            createGraph(nodesRB.get(firstPoint).getFloor());
            createCircles(nodesRB.get(firstPoint).getFloor());
            passagePane.setVisible(false);
        }
    }

    /**
     * Função que coloca visivel a pane de inserção de uma sala
     *
     * @param actionEvent
     */
    public void handleClassroomInsertButton(ActionEvent actionEvent) {
        classroomInsertPane.setVisible(!classroomInsertPane.isVisible());
    }

    /**
     * Função que coloca visivel a pane de inserção de um ponto de passagem
     *
     * @param actionEvent
     */
    public void handleCPInsert(ActionEvent actionEvent) {
        crossingPInsertPane.setVisible(true);
    }

    /**
     * Função que habilita o popUp de seleção do tipo de inserção
     *
     * @param actionEvent
     */
    public void handleInsertNodee(ActionEvent actionEvent) {
        nodeInsertPane.setVisible(!nodeInsertPane.isVisible());
    }

    /**
     * Função que recebe os argumentos da pane e cria uma Classroom
     *
     * @param actionEvent
     */
    public void handleCreateClassroom(ActionEvent actionEvent) {
        classroomInsertPane.setVisible(false);
        boolean newClassroom;

        String[] lines = classroomConnectedTextAreaField.getText().split("\n");

        // verifica a existencia de uma sala com o mesmo nome
        if (!nodesRB.contains(classroomNameField.getText())) {

            // Percorre todos os nodes e verifica se existe algum já a ocupar a posição pedida
            newClassroom = checkPosition(nodesRB, classroomXField.getText(), classroomYField.getText(), classroomFloorField.getText());

            // se ainda não existir nenhuma sala na posição pedida a sala é criada e guardada na ST de salas
            if (newClassroom) {
                Classroom newClass = new Classroom(classroomNameField.getText(), Integer.parseInt(classroomLimitStudentsPane.getText()), aboutClassroomField.getText(), Integer.parseInt(classroomXField.getText()), Integer.parseInt(classroomYField.getText()), Integer.parseInt(classroomFloorField.getText()), true);
                nodesRB.put(newClass.name, newClass);

                // insere o novo node na symbolgraph
                InsertNodeDiGraph(newClass.name, lines);

            } else {
                alert(Alert.AlertType.WARNING, "Warning Dialog", "Ups, posição ocupada", "Por favor, altere a posição do ponto a inserir");
            }
        } else {
            alert(Alert.AlertType.WARNING, "Warning Dialog", "Ups, sala existente", "Por favor, coloque um nome que ainda não exista");
        }

    }

    /**
     * Função que recebe os argumentos da pane e cria um Ponto de passagem
     *
     * @param actionEvent
     */
    public void handleCreateCrossingP(ActionEvent actionEvent) {
        crossingPInsertPane.setVisible(false);
        boolean newCpt;

        String[] lines = crossingPConnectedField.getText().split("\n");

        if (!nodesRB.contains(crossingPNameField.getText())) {
            // Percorre todos os nodes e verifica se existe algum já a ocupar a posição pedida
            newCpt = checkPosition(nodesRB, crossingPXField.getText(), crossingPYField.getText(), crossingPFloorField.getText());

            if (newCpt) {
                CrossingPoint cpt = new CrossingPoint(crossingPNameField.getText(), crossingPAboutField.getText(), Integer.parseInt(crossingPXField.getText()), Integer.parseInt(crossingPYField.getText()), Integer.parseInt(crossingPFloorField.getText()), false);
                nodesRB.put(cpt.getName(), cpt);
                InsertNodeDiGraph(cpt.getName(), lines);
            } else {
                alert(Alert.AlertType.WARNING, "Warning Dialog", "Ups, posição ocupada", "Por favor, altere a posição do ponto a inserir");
            }

        } else {
            alert(Alert.AlertType.WARNING, "Warning Dialog", "Ups, ponto inexistente", "Por favor, coloque um nome inexistente!");
        }
    }

    /**
     * Função utilizada para criar alertas na interface
     *
     * @param error  tipo de alerta
     * @param title  titulo do alerta
     * @param header
     * @param text
     */
    private void alert(Alert.AlertType error, String title, String header, String text) {
        Alert alert = new Alert(error);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);

        alert.showAndWait();
    }

    /**
     * Função que verifica se um subgraph é conexo ou não
     *
     * @param floor
     */
    public void isFloorConnected(int floor) {

        SymbolGraph_PROJ symbolbyfloor = createSubEdgeWeightedDiGraph(floor);
        DepthFirstDirectedPaths_PROJ dfs = null;
        boolean connected = true;
        String firstEdge = null;

        // cria o dfs conforme o andar onde estamos
        if (floor == 1) {
            dfs = new DepthFirstDirectedPaths_PROJ(symbolbyfloor.graph(), symbolbyfloor.indexOf("Entrada"));
            firstEdge = "Entrada";
        } else if (floor == 2) {
            dfs = new DepthFirstDirectedPaths_PROJ(symbolbyfloor.graph(), symbolbyfloor.indexOf("Escadas2"));
            firstEdge = "Escadas2";
        } else if (floor == 3) {
            dfs = new DepthFirstDirectedPaths_PROJ(symbolbyfloor.graph(), symbolbyfloor.indexOf("Escadas3"));
            firstEdge = "Escadas3";
        }
        System.out.println("\n------ Path to: ------");
        //Imprimir o "caminho" de source(s) até todos os vértices
        for (int v = 0; v < symbolbyfloor.graph().V(); v++) {
            if (nodesRB.get(symbolbyfloor.nameOf(v)).getFloor() == floor) {
                if (dfs.hasPathTo(v)) {
                    System.out.print(firstEdge + " to " + symbolbyfloor.nameOf(v) + ": ");
                    for (int x : dfs.pathTo(v)) {
                        if (x == 0) System.out.print(symbolbyfloor.nameOf(x));
                        else System.out.print("-" + symbolbyfloor.nameOf(x));
                    }
                    System.out.println();
                } else {
                    connected = false;
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("Ups, o andar " + floor + " não é conexo");
                    alert.setContentText(firstEdge + " até " + symbolbyfloor.nameOf(v) + ": não estão conectados");

                    alert.showAndWait();
                }
            }
        }
        if (connected) {
            alert(Alert.AlertType.CONFIRMATION, "Sucesso", "O edificio é conexo!", "Todos os pontos do edificio estão conectados!");
        }

    }


    /**
     * Função utilizada para criar "imagens" dentro do graph
     *
     * @param x
     * @param y
     * @param y1
     */
    public void treeMaker(Integer x, Integer y, Integer y1) {
        Line tri1 = new Line(x, y1 - 10, x, y1);
        Line tri2 = new Line(x, y, x - 10, y1 - 10);
        Line tri3 = new Line(x, y, x + 10, y1 - 10);
        Line tri4 = new Line(x - 10, y1 - 10, x + 10, y1 - 10);

        tri1.setStroke(Color.BROWN);
        tri2.setStroke(Color.GREEN);

        tri3.setStroke(Color.GREEN);
        tri4.setStroke(Color.GREEN);

        graphGroup.getChildren().add(tri1);
        graphGroup.getChildren().add(tri2);
        graphGroup.getChildren().add(tri3);
        graphGroup.getChildren().add(tri4);

    }

    /**
     * Função que adiciona um novo ponto ao symbolgraph
     *
     * @param name  nome que vai ser guardado na symbolgraph
     * @param lines linhas onde estão as ligações que vão ser feitas
     */
    private void InsertNodeDiGraph(String name, String[] lines) {

        //atualização de SymbolGraph para adição da nova sala
        symbolGraph.getSt().put(name, symbolGraph.getSt().size());
        String[] keys = new String[symbolGraph.getSt().size()];

        for (String n : symbolGraph.getSt().keys()) {
            keys[symbolGraph.getSt().get(n)] = n;
        }
        symbolGraph.setKeys(keys);


        for (String line : lines) {
            String[] fields = line.split(";");
            String edge = fields[0];
            Double weight = Double.parseDouble(fields[1]);
            Double time = Double.parseDouble(fields[1]);

            // verifica se a sala/pdp onde vai ser estabelecidade ligação existe.
            if (nodesRB.contains(edge)) {
                EdgeWeightedDigraph_PROJ newDiGraph = new EdgeWeightedDigraph_PROJ(symbolGraph.getSt().size());

                //criação da ligação para os dois sentidos.
                newDiGraph.addEdge(new DirectedEdge_PROJ(symbolGraph.indexOf(name), symbolGraph.indexOf(edge), weight, time));
                newDiGraph.addEdge(new DirectedEdge_PROJ(symbolGraph.indexOf(edge), symbolGraph.indexOf(name), weight, time));

                //coloca todas as ligações já existentes no novo Digraph
                for (int v = 0; v < symbolGraph.graph().V(); v++) {
                    for (DirectedEdge_PROJ w : symbolGraph.graph().adj(v)) {
                        newDiGraph.addEdge(w);
                    }
                }
                //alteração do EdgeWeightedDigraph do symbolGraph
                symbolGraph.setwDiGraph(newDiGraph);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Ups, ponto inexistente");
                alert.setContentText("O ponto " + edge + " ainda não existe, escolha outro");
                classroomConnectedTextAreaField.clear();

                alert.showAndWait();
            }

        }
    }

    /**
     * Função que remove um ponto ao symbolgraph
     *
     * @param name nome do ponto a ser removido
     */
    private void removeNodeDigraph(String name) {

        ST<String, Integer> st = new ST<String, Integer>();
        String[] keys = new String[symbolGraph.getSt().size()];

        for (String key : nodesRB.keys()) {
            if (!nodesRB.get(key).getName().equals(name)) {
                //mapeamento
                if (!st.contains(key))
                    st.put(key, st.size());
            }
        }

        for (String n : st.keys()) {
            keys[st.get(n)] = n;
        }

        EdgeWeightedDigraph_PROJ newDiGraph = new EdgeWeightedDigraph_PROJ(st.size());

        SymbolGraph_PROJ newSymbolGraph = new SymbolGraph_PROJ(st, keys, newDiGraph);

        for (int v = 0; v < symbolGraph.graph().V(); v++) {
            for (DirectedEdge_PROJ w : symbolGraph.graph().adj(v)) {
                // se nenhum dos vertices de edge for igual ao name então adiciona ao novo digraph
                if (!symbolGraph.nameOf(w.from()).equals(name) && !symbolGraph.nameOf(w.to()).equals(name)) {
                    DirectedEdge_PROJ directedEdge_proj = new DirectedEdge_PROJ(newSymbolGraph.indexOf(symbolGraph.nameOf(w.from())), newSymbolGraph.indexOf(symbolGraph.nameOf(w.to())), w.weight(), w.time());
                    directedEdge_proj.setDisabled(w.isDisabled());
                    newDiGraph.addEdge(directedEdge_proj);
                }
            }
        }

        symbolGraph.setwDiGraph(newDiGraph);
        symbolGraph.setKeys(keys);
        symbolGraph.setSt(st);

        if (nodesRB.get(name) instanceof Classroom) {
            deleteClassroom(name, nodesRB, lessonsST, ".//data//dump//classroomsdump.txt");
        } else {
            nodesRB.delete(name);
        }
    }

    /**
     * Função que fecha as panes de inserção de node
     *
     * @param actionEvent
     */
    public void handleCloseClassroomInsertPane(ActionEvent actionEvent) {
        classroomInsertPane.setVisible(false);
        crossingPInsertPane.setVisible(false);
    }

    /**
     * Função que cria um subgraph
     *
     * @param floor
     * @return
     */
    public SymbolGraph_PROJ createSubEdgeWeightedDiGraph(Integer floor) {

        String[] keys;
        ST<String, Integer> st = new ST<String, Integer>();

        for (String key : nodesRB.keys()) {
            if (nodesRB.get(key).getFloor().equals(floor)) {

                //mapeamento
                if (!st.contains(key))
                    st.put(key, st.size());
            }
        }

        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }
        EdgeWeightedDigraph_PROJ subDiGraph = new EdgeWeightedDigraph_PROJ(st.size());

        SymbolGraph_PROJ newSymbolGraph = new SymbolGraph_PROJ(st, keys, subDiGraph);

        for (int v = 0; v < symbolGraph.graph().V(); v++) {
            //verificar se o andar do node é igual ao recebido
            //System.out.println("v = " + v + " symbol = " + symbolGraph.nameOf(v));
            if (nodesRB.get(symbolGraph.nameOf(v)).getFloor().equals(floor)) {
                for (DirectedEdge_PROJ w : symbolGraph.graph().adj(v)) {
                    if (nodesRB.get(symbolGraph.nameOf(w.to())).getFloor().equals(floor)) {
                        DirectedEdge_PROJ directedEdge = new DirectedEdge_PROJ(newSymbolGraph.indexOf(symbolGraph.nameOf(w.from())), newSymbolGraph.indexOf(symbolGraph.nameOf(w.to())), w.weight(), w.time());
                        directedEdge.setDisabled(w.isDisabled());
                        subDiGraph.addEdge(directedEdge);

                    }
                }
            }
        }

        return newSymbolGraph;
    }

    /**
     * Função que coloca invisivel a pane de remover um node
     *
     * @param actionEvent
     */
    public void handleCloseNodeRemovePane(ActionEvent actionEvent) {
        nodeRemovePane.setVisible(false);
    }

    /**
     * Função que coloca visivel a pane de remover um node
     *
     * @param actionEvent
     */
    public void handleRemoveNodeButton(ActionEvent actionEvent) {
        nodeRemovePane.setVisible(true);
    }

    /**
     * Função que faz a remoção completa de um node
     *
     * @param actionEvent
     */
    public void handleRemoveNodeSubmit(ActionEvent actionEvent) {
        String name = noderemovefield.getText();
        System.out.println("nome = " + name);

        if (nodesRB.contains(name)) {
            removeNodeDigraph(name);
        } else {
            alert(Alert.AlertType.ERROR, "Error", "Ups, algo correu mal", "Não existe nenhum Ponto com esse nome, por favor escolha um ponto existente");
        }
    }

    /**
     * Função que mostra a tabela com as salas todas quando a tab é selecionada
     *
     * @param event
     */
    public void showClassroomsTable(Event event) {
        classroomTable.getItems().clear();

        for (String key : nodesRB.keys()) {
            Node node = nodesRB.get(key);
            if (node instanceof Classroom) {
                classroomTable.getItems().add(node);
            }
        }

    }

    /**
     * Função que verifica qual a pane que está visivel a coloca invisivel
     *
     * @param actionEvent
     */
    public void handleClassroomStatusPane(ActionEvent actionEvent) {
        classroomStatePane.setVisible(!classroomStatePane.isVisible());

        if (classroomNowPane.isVisible()) {
            classroomNowPane.setVisible(false);
            classroomNowSearch.clear();
            showClassAtMoment.clear();
            nowClassroomTable.getItems().clear();
        }
        if (classroomBetweenPane.isVisible()) {
            classroomBetweenPane.setVisible(false);
            betweenClassroomTable.getItems().clear();
            classroombetweenSearch.clear();
        } else if (classroombetweenSearchpane.isVisible()) {
            classroombetweenSearchpane.setVisible(false);
            startHourClassroomSearch.clear();
            endHourClassroomSearch1.clear();
        }

    }

    /**
     * Função que coloca a pane da pesquisa de salas no momento visivel e insere na tabela essas mesmas salas
     *
     * @param actionEvent
     */
    public void handleSearchClassroomNow(ActionEvent actionEvent) {
        classroomStatePane.setVisible(false);
        classroomNowPane.setVisible(true);

        ArrayList<Classroom> busyClassroom = classroombusy(new DateSchedule(15, 30, 2), nodesRB);

        nowClassroomTable.getItems().addAll(busyClassroom);
    }

    /**
     * Faz a pesquisa de qual a aula no momento da sala escolhida
     *
     * @param actionEvent
     */
    public void handleShowClassroomClassNow(ActionEvent actionEvent) {
        if (classroomNowSearch.getText() != null) {
            String name = classroomNowSearch.getText();
            Classroom c = (Classroom) nodesRB.get(name);
            Lesson l = c.classroomstate(new DateSchedule(15, 30, 2));

            showClassAtMoment.setText("Turma : " + l.getaClass().getId() + " Aula id : " + l.getId());
            showClassAtMoment.setVisible(true);
        }
    }

    /**
     * Função que coloca visivel a pane da pesquisa entre 2 diferentes horas
     *
     * @param actionEvent
     */
    public void handleSearchClassroomBetween(ActionEvent actionEvent) {
        classroombetweenSearchpane.setVisible(true);
    }

    public void handleSearchClassroomClose(ActionEvent actionEvent) {
        if (classroomLessonsBetweenPane.isVisible()) {
            classroomLessonsBetweenPane.setVisible(false);
            lessonsBetweenTable.getItems().clear();

        }

        showClassAtMoment.clear();
        classroomNowPane.setVisible(false);
        classroomStatePane.setVisible(false);
    }

    /**
     * Função que faz a pesquisa de salas livres entre 2 horarios e coloca os mesmos na tabela da pane
     *
     * @param actionEvent
     */
    public void handleShowClassroomClassBetween(ActionEvent actionEvent) {
        String[] startHour = startHourClassroomSearch.getText().split(":");
        String[] endHour = endHourClassroomSearch1.getText().split(":");
        String day = dayClassroomSearch.getText();

        DateSchedule start = new DateSchedule(Integer.parseInt(startHour[0]), Integer.parseInt(startHour[1]), Integer.parseInt(day));
        DateSchedule end = new DateSchedule(Integer.parseInt(endHour[0]), Integer.parseInt(endHour[1]), Integer.parseInt(day));

        ArrayList<FreeClassroom> freeClass = freeClassroomsbetween(start, end, nodesRB);
        lessonsBetweenTable.getItems().addAll(freeClass);

        classroombetweenSearchpane.setVisible(false);
        classroomLessonsBetweenPane.setVisible(true);
    }

    /**
     * Função que coloca visivel ou invisivel a pane da pesquisa por tamanho.
     *
     * @param actionEvent
     */
    public void handleClassroomBySizePane(ActionEvent actionEvent) {
        classroomBySizePane.setVisible(!classroomBySizePane.isVisible());

        if (classroomBySizeTabPane.isVisible()) {
            classroomBySizeTabPane.setVisible(false);
        }
    }

    /**
     * Faz a pesquisa de salas pelo seu tamanho
     *
     * @param actionEvent
     */
    public void handleShowClassroomBySize(ActionEvent actionEvent) {
        Integer sizeLimit = Integer.parseInt(bysizeClassroomField.getText());

        ArrayList<Classroom> classroomsBySize = classroomsbySize(sizeLimit, nodesRB);

        if (classroomsBySize.size() > 0) {
            bySizeClassroomTable.getItems().addAll(classroomsBySize);
            classroomBySizeTabPane.setVisible(true);
        } else {
            alert(Alert.AlertType.ERROR, "Error", "Ups, algo correu mal", "Não existe nenhuma Sala com lugar para mais de " + sizeLimit + " alunos");
            classroomBySizePane.setVisible(false);
        }
    }

    /**
     * Faz a gestão das panes de mostrar as aulas de uma sala
     *
     * @param actionEvent
     */
    public void handleLessonsByClassroomSearch(ActionEvent actionEvent) {
        lessonsByClassroomSearchPane.setVisible(!lessonsByClassroomSearchPane.isVisible());
        if (lessonsPane.isVisible()) {
            lessonsPane.setVisible(false);
            lessonsTable.getItems().clear();
        }
    }

    /**
     * Função que mostra as aulas de uma sala dentro do intervalo de tempo recebido
     *
     * @param actionEvent
     */
    public void handleShowLessonsByInterval(ActionEvent actionEvent) {

        String classroom = lessonsByClassroomField.getText();
        if (nodesRB.contains(classroom)) {
            lessonsByClassroomField.clear();
            String[] startHour = lessonsStartHourSearchField.getText().split(":");
            lessonsStartHourSearchField.clear();
            String[] endHour = lessonsEndHourSearchField.getText().split(":");
            lessonsEndHourSearchField.clear();
            String day = lessonsDaySearchField.getText();
            lessonsDaySearchField.clear();

            DateSchedule start = new DateSchedule(Integer.parseInt(startHour[0]), Integer.parseInt(startHour[1]), Integer.parseInt(day));
            DateSchedule end = new DateSchedule(Integer.parseInt(endHour[0]), Integer.parseInt(endHour[1]), Integer.parseInt(day));

            Classroom c = (Classroom) nodesRB.get(classroom);

            ArrayList<Lesson> lessonArrayList = classroomwithClassbetween(start, end, c);

            if (lessonArrayList.size() > 0) {
                lessonsTable.getItems().addAll(lessonArrayList);
                lessonsByClassroomSearchPane.setVisible(false);
                lessonsPane.setVisible(true);
            }

        } else {
            alert(Alert.AlertType.ERROR, "Error", "Ups, algo correu mal", "Não existe nenhuma Sala com esse nome");
        }
    }

    /**
     * Mostra todas as aulas de uma determinada sala
     *
     * @param actionEvent
     */
    public void handleShowLessonsByClassroom(ActionEvent actionEvent) {
        // verifica a existencia da sala pretendida
        if (nodesRB.contains(lessonsByClassroomField.getText())) {
            Classroom c = (Classroom) nodesRB.get(lessonsByClassroomField.getText());
            // adiciona a tabela todas as aulas dessa sala
            lessonsTable.getItems().addAll(c.getLessons());
            lessonsPane.setVisible(true);
        } else {
            alert(Alert.AlertType.ERROR, "Error", "Ups, algo correu mal", "Não existe nenhuma Sala com esse nome");
        }
    }

    /**
     * Função que faz coloca disponivel a pane de inserção de uma aula com as comboBox devidamente preenchidas com as horas e dias da semana
     *
     * @param actionEvent
     */
    public void handleInsertLesson(ActionEvent actionEvent) {

        String[] daysWeek = {"Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira"};
        String[] hours = {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"};
        String[] classrooms = getAllClassroomsNames(nodesRB); //função que devolve uma string com o nome de todas as salas
        String[] aClass = getAllUC(curricularUnitsST); //função que devolve uma string com o nome de todas as unidades curriculares


        startHourComboBox.getItems().clear();
        endHourComboBox1.getItems().clear();
        dayComboBox.getItems().clear();
        uCurricComboBox.getItems().clear();
        classroomComboBox.getItems().clear();
        aClassNameField.clear();
        aClassSizeField.clear();
        aClassTypeField.clear();

        startHourComboBox.getItems().addAll(hours);
        endHourComboBox1.getItems().addAll(hours);
        dayComboBox.getItems().addAll(daysWeek);
        classroomComboBox.getItems().addAll(classrooms);
        uCurricComboBox.getItems().addAll(aClass);


        insertLessonPane.setVisible(!insertLessonPane.isVisible());
    }

    /**
     * Função que faz a inserção da aula.
     *
     * @param actionEvent
     */
    public void handleInsertLessonButton(ActionEvent actionEvent) {
        String teacherName = null;
        String classroomid = classroomComboBox.getSelectionModel().getSelectedItem().toString();
        String ucname = uCurricComboBox.getSelectionModel().getSelectedItem().toString();
        String start[] = startHourComboBox.getSelectionModel().getSelectedItem().toString().split(":");
        String end[] = endHourComboBox1.getSelectionModel().getSelectedItem().toString().split(":");
        String day = dayComboBox.getSelectionModel().getSelectedItem().toString();
        String aClass = aClassNameField.getText();
        Integer size = Integer.parseInt(aClassSizeField.getText());
        String type = aClassTypeField.getText();
        Integer year = new Date().getYear();

        DateSchedule startHour = new DateSchedule(Integer.parseInt(start[0]), Integer.parseInt(start[1]), day);
        DateSchedule endHour = new DateSchedule(Integer.parseInt(end[0]), Integer.parseInt(end[1]), day);
        Class c = null;
        Classroom croom = (Classroom) nodesRB.get(classroomid);
        //criação de uma nova aula
        Lesson l = new Lesson(lessonsST.size() + 1, startHour, endHour);

        // verifica a existencia da turma recebida
        if (!classST.contains(aClass)) {
            // criação de uma nova turma
            c = new Class(aClass, year, size, type, curricularUnitsST.get(ucname));
            // faz a associação multipla.
            c.addLesson(l);
            // se a comboBox de professores estiver ativa significa que existem professores daquela Unidade Curricular
            if (!teacherComboBox.isDisable()) {

                teacherName = teacherComboBox.getSelectionModel().getSelectedItem().toString();
                teacherComboBox.getItems().clear();
                teacherComboBox.setDisable(true);
                for (Long key : teachersST.keys()) {
                    if (teachersST.get(key).getName().equals(teacherName)) {
                        // tenta a adição do professor a turma e vice-versa se der erro entra no if
                        if (!(c.addTeacher(teachersST.get(key)))) {
                            alert(Alert.AlertType.ERROR, "Error", "Ups, algo correu mal", "Não foi possivel adicionar o professor " + teacherName + " a turma");
                        }
                    }
                }
            }

            classST.put(c.getId(), c);
            // associação da aula a sala
            if ((!croom.addLesson(l))) {
                alert(Alert.AlertType.WARNING, "Error", "Ups, algo correu mal", "A sala que pretende associar já está ocupada. A turma vai ser criada sem sala atribuida");
                // se não der erro associa a sala à aula também
            } else {
                l.setClassroom(croom);
            }
            // guarda a aula na st de aulas

            lessonsST.put(l.getId(), l);
            insertLessonPane.setVisible(false);
            handleShowLessonsTable(actionEvent);
        }
    }

    /**
     * Função que habilita a comboBox de professores apenas com os professores que lecionam a unidade curricular selecionada
     *
     * @param actionEvent
     */
    public void handleDragToShowTeachersByUcs(ActionEvent actionEvent) {
        String ucname = uCurricComboBox.getSelectionModel().getSelectedItem().toString();
        teacherComboBox.setDisable(false);
        teacherComboBox.getItems().clear();
        CurricularUnit uc = curricularUnitsST.get(ucname);

        if (uc.getTeachers().size() > 0) {
            String[] teacherNames = new String[uc.getTeachers().size()];
            int i = 0;
            for (Long key : uc.getTeachers().keys()) {
                teacherNames[i] = uc.getTeachers().get(key).getName();
                i++;
            }
            teacherComboBox.getItems().addAll(teacherNames);
        }
    }

    /**
     * Função que remove uma aula
     *
     * @param actionEvent
     */
    public void handleRemoveLesson(ActionEvent actionEvent) {
        String lessonId = allLessonsComboBox.getSelectionModel().getSelectedItem().toString();

        System.out.println(lessonId);

        // remover a aula da turma. A turma fica com aula = null
        Lesson lesson = lessonsST.get(Integer.parseInt(lessonId));
        // Remover aula do horario do professor dos alunos e da sala.
        lesson.removeLesson();
        lessonsST.delete(Integer.parseInt(lessonId));
        handleShowLessonsTable(actionEvent);
    }

    /**
     * Função que insere todas as aulas na tabela de aulas
     *
     * @param event
     */
    public void handleShowLessonsTable(Event event) {
        allLessonsTable.getItems().clear();
        for (Integer key : lessonsST.keys()) {
            allLessonsTable.getItems().addAll(lessonsST.get(key));
        }
    }

    /**
     * Função que gere a visualização da pane para remoção de uma aula
     *
     * @param actionEvent
     */
    public void handleRemoveLessonButton(ActionEvent actionEvent) {
        if (deleteLessonPane.isVisible()) {
            deleteLessonPane.setVisible(false);
        } else {
            deleteLessonPane.setVisible(true);
            String[] lessonsname = new String[lessonsST.size()];
            int i = 0;
            for (Integer lessonName : lessonsST.keys()) {
                lessonsname[i] = lessonName.toString();
                i++;
            }
            allLessonsComboBox.getItems().addAll(lessonsname);
        }
    }

    /**
     * Função que gere a visualização da pane para alteração da sala de uma aula
     *
     * @param actionEvent
     */
    public void handleChangeLessonClassroom(ActionEvent actionEvent) {
        if (changeClassroomLessonPane.isVisible()) {
            changeClassroomLessonPane.setVisible(false);
            allLessonsComboBox1.getItems().clear();
            classroomLessonComboBox.getItems().clear();
        } else {

            changeClassroomLessonPane.setVisible(true);

            String[] lessonsname = new String[lessonsST.size()];
            int i = 0;
            for (Integer lessonName : lessonsST.keys()) {
                lessonsname[i] = lessonName.toString();
                i++;
            }

            String[] classroomsnames = getAllClassroomsNames(nodesRB);

            allLessonsComboBox1.getItems().addAll(lessonsname);
            classroomLessonComboBox.getItems().addAll(classroomsnames);
        }
    }

    /**
     * Função que faz a alteração da sala de uma aula
     *
     * @param actionEvent
     */
    public void handleChangeLessonClassroomSubmit(ActionEvent actionEvent) {
        Integer lessonid = Integer.parseInt(allLessonsComboBox1.getSelectionModel().getSelectedItem().toString());
        String classroomiD = classroomLessonComboBox.getSelectionModel().getSelectedItem().toString();

        Lesson l = lessonsST.get(lessonid);
        Class aClass = classST.get(l.getaClass().getId());
        Classroom c = (Classroom) nodesRB.get(classroomiD);
        if (l.editClassroom(c)) {
            aClass.setLesson(l);
            if (aClass.getTeacher() != null) {
                System.out.println("TESTE");
                Teacher t = teachersST.get(aClass.getTeacher().getNumber());
                t.deleteClass(aClass.getId());
                aClass.setTeacher(null);
                aClass.addTeacher(t);
                handleShowLessonsTable(actionEvent);
            }
            for (Long key : studentsST.keys()) {
                Student student = studentsST.get(key);
                if (student.getaClass().contains(aClass.getId())) {
                    student.deleteClass(aClass.getId());
                    student.addClass(aClass);
                }
            }
        } else {
            alert(Alert.AlertType.ERROR, "Error", "Ups, algo correu mal", "Sala " + classroomiD + " já está ocupada no horario da aula");
            handleShowLessonsTable(actionEvent);
        }

    }

    /**
     * Função que adiciona todas as Turmas à tabela de turmas
     *
     * @param event
     */
    public void handleShowaClassTable(Event event) {
        aClassTable.getItems().clear();

        for (String key : classST.keys()) {
            Class aC = classST.get(key);
            aClassTable.getItems().add(aC);
        }
    }

    /**
     * Função que faz a gestão da pane para alteração do tamanho de uma sala
     *
     * @param actionEvent
     */
    public void handleChangeClassSizeButton(ActionEvent actionEvent) {
        if (changeClassPane.isVisible()) {
            allClassComboBox.getItems().clear();
            sizeChangeClassField.setVisible(false);
            changeClassPane.setVisible(false);
        } else {
            String[] names = getAllClassNames(classST);
            allClassComboBox.getItems().addAll(names);
            teacherChangeClassComboBox.setVisible(false);
            sizeChangeClassField.setVisible(true);
            changeClassPane.setVisible(true);
        }
    }

    /**
     * Função que faz a gestão da pane para alteração do professor de uma turma
     *
     * @param actionEvent
     */
    public void handleChangeClassTeacherButton(ActionEvent actionEvent) {
        if (changeClassPane.isVisible()) {
            allClassComboBox.getItems().clear();
            changeClassPane.setVisible(false);
        } else {
            String[] names = getAllClassNames(classST);
            allClassComboBox.getItems().addAll(names);
            changeClassPane.setVisible(true);
            teacherChangeClassComboBox.setVisible(true);
        }
    }

    /**
     * Função que mostra os restantes professores que lecionam a mesma unidade curricular.
     *
     * @param actionEvent
     */
    public void handleShowTeacherComboBox(ActionEvent actionEvent) {
        teacherChangeClassComboBox.getItems().clear();
        String classId = allClassComboBox.getSelectionModel().getSelectedItem().toString();
        Class aC = classST.get(classId);

        CurricularUnit uC = aC.getcUnit();
        String[] teacher = new String[uC.getTeachers().size()];
        int i = 0;
        for (Long key : uC.getTeachers().keys()) {
            if (aC.getTeacher() != null) {
                if (!uC.getTeachers().get(key).getNumber().equals(aC.getTeacher().getNumber())) {
                    teacher[i] = key.toString();
                    System.out.println(teacher[i]);
                    i++;
                }
            } else {
                teacher[i] = key.toString();
                System.out.println(teacher[i]);
                i++;
            }
        }

        teacherChangeClassComboBox.getItems().addAll(teacher);
    }

    /**
     * Função que tenta fazer a alteração do professor da turma/ou do tamanho da turma, se for possivel
     *
     * @param actionEvent
     */
    public void handleChangeClassSubmit(ActionEvent actionEvent) {
        String classId = allClassComboBox.getSelectionModel().getSelectedItem().toString();
        Class aC = classST.get(classId);
        // verifica se a alteração foi no tamanho da turma
        if (sizeChangeClassField.isVisible()) {
            Integer size = Integer.parseInt(sizeChangeClassField.getText());
            if (!aC.setStudentsLimit(size)) {
                alert(Alert.AlertType.ERROR, "Error", "Ups, algo correu mal", "A sala " + aC.getLesson().getClassroom().getName() + " tem limite máximo de " + aC.getLesson().getClassroom().getStudentsLimit());

            }

            // verifica se a alteração foi no professor
        } else if (teacherChangeClassComboBox.isVisible()) {
            Long teacherid = Long.parseLong(teacherChangeClassComboBox.getSelectionModel().getSelectedItem().toString());
            Teacher t = teachersST.get(teacherid);

            if (aC.getLesson() != null) {
                // verifica a possibilidade de adicionar a turma ao professor
                if (t.addClass(aC)) {
                    // remove a turma do horario do professor anterior
                    if (aC.getTeacher() != null) {
                        aC.getTeacher().deleteClass(aC.getId());
                    }
                    // se for possivel adiciona o professor a turma
                    aC.setTeacher(t);
                } else {
                    alert(Alert.AlertType.ERROR, "Error", "Ups, algo correu mal", "O professor " + t.getName() + " está ocupado no horario da aula");
                }
            } else {
                alert(Alert.AlertType.ERROR, "Error", "Ups, algo correu mal", "Associe uma aula antes de associar um professor a uma turma");
            }
            //parte da remoção de uma aula
        } else if (!sizeChangeClassField.isVisible() && !teacherChangeClassComboBox.isVisible()) {
            lessonsST.delete(aC.getLesson().getId());
            aC.removeLesson();
        }

        changeClassPane.setVisible(false);
        handleShowaClassTable(actionEvent);
    }

    /**
     * Função que faz a gestão da visualização da pane para remover uma aula
     *
     * @param actionEvent
     */
    public void handleRemoveClassLessonButton(ActionEvent actionEvent) {
        if (changeClassPane.isVisible()) {
            allClassComboBox.getItems().clear();
            teacherChangeClassComboBox.getItems().clear();
            teacherChangeClassComboBox.setVisible(false);
            allClassComboBox.getItems().clear();
            changeClassPane.setVisible(false);
        } else {
            String[] names = getAllClassNames(classST);
            allClassComboBox.getItems().addAll(names);
            changeClassPane.setVisible(true);
        }
    }

    /**
     * Função que faz a gestão da visualização da pane para adicionar uma aula a uma turma
     *
     * @param actionEvent
     */
    public void handleAddClassLessonButton(ActionEvent actionEvent) {
        if (addLessontoClassPane.isVisible()) {
            startHouraddLessonComboBox.getItems().clear();
            endHouraddLessonComboBox.getItems().clear();
            dayAddLessonComboBox.getItems().clear();
            classroomsAddLessonComboBox.getItems().clear();
            allaClasswithoutLessonComboBox.getItems().clear();
            addLessontoClassPane.setVisible(false);
        } else {

            String[] daysWeek = {"Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira"};
            String[] hours = {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"};

            // apenas são mostradas turmas sem aula.
            String[] aClass = getClasswithouLesson(classST);

            startHouraddLessonComboBox.getItems().addAll(hours);
            endHouraddLessonComboBox.getItems().addAll(hours);
            dayAddLessonComboBox.getItems().addAll(daysWeek);
            allaClasswithoutLessonComboBox.getItems().addAll(aClass);
            addLessontoClassPane.setVisible(true);
        }
    }

    /**
     * Função que faz, se possivel a inserção de uma aula a uma turma
     *
     * @param actionEvent
     */
    public void handleAddLessontoClassSubmit(ActionEvent actionEvent) {
        String[] starthour = startHouraddLessonComboBox.getSelectionModel().getSelectedItem().toString().split(":");
        String[] endhour = endHouraddLessonComboBox.getSelectionModel().getSelectedItem().toString().split(":");
        String day = dayAddLessonComboBox.getSelectionModel().getSelectedItem().toString();
        String aClassiD = allaClasswithoutLessonComboBox.getSelectionModel().getSelectedItem().toString();
        String classroomiD = classroomsAddLessonComboBox.getSelectionModel().getSelectedItem().toString();

        DateSchedule start = new DateSchedule(Integer.parseInt(starthour[0]), Integer.parseInt(starthour[1]), day);
        DateSchedule end = new DateSchedule(Integer.parseInt(endhour[0]), Integer.parseInt(endhour[1]), day);

        Class aClass = classST.get(aClassiD);
        Classroom classroom = (Classroom) nodesRB.get(classroomiD);
        Lesson lesson = new Lesson(lessonsST.size() + 1, start, end);
        lesson.setClassroom(classroom);

        // se o professor da turma estiver ocupado nesse horario vai ser removido da turma e os alunos igualmente
        aClass.addLesson(lesson);
        classroom.addLesson(lesson);

        lessonsST.put(lesson.getId(), lesson);
        addLessontoClassPane.setVisible(false);
        startHouraddLessonComboBox.getItems().clear();
        endHouraddLessonComboBox.getItems().clear();
        dayAddLessonComboBox.getItems().clear();
        allaClasswithoutLessonComboBox.getItems().clear();
        classroomsAddLessonComboBox.getItems().clear();
        handleShowaClassTable(actionEvent);
    }

    /**
     * Função que mostra todas as salas disponiveis num intervalo de tempo
     *
     * @param actionEvent
     */
    public void handleGetallClassroomsFree(ActionEvent actionEvent) {
        String[] starthour = startHouraddLessonComboBox.getSelectionModel().getSelectedItem().toString().split(":");
        String[] endhour = endHouraddLessonComboBox.getSelectionModel().getSelectedItem().toString().split(":");
        String day = dayAddLessonComboBox.getSelectionModel().getSelectedItem().toString();

        DateSchedule start = new DateSchedule(Integer.parseInt(starthour[0]), Integer.parseInt(starthour[1]), day);
        DateSchedule end = new DateSchedule(Integer.parseInt(endhour[0]), Integer.parseInt(endhour[1]), day);

        // apenas vão ser mostradas as salas disponiveis no intervalo de tempo recebido
        ArrayList<FreeClassroom> classrooms = freeClassroomsbetween(start, end, nodesRB);
        ArrayList<Classroom> freeclassrooms = new ArrayList<>();

        for (FreeClassroom fC : classrooms) {
            // verificar se as a sala está disponivel nas horas enviadas
            if (fC.getStartHour().equals(start) && fC.getEndHour().equals(end)) {
                Classroom c = (Classroom) nodesRB.get(fC.getClassroomName());
                freeclassrooms.add(c);
            }
        }

        String[] classroomNames = new String[freeclassrooms.size()];
        int i = 0;
        for (Classroom c1 : freeclassrooms) {
            classroomNames[i] = c1.getName();
            i++;
        }
        classroomsAddLessonComboBox.getItems().addAll(classroomNames);
    }

    /**
     * Função que faz a gestão da pane de alteração de uma aula
     *
     * @param actionEvent
     */
    public void handleChangeLessonSchedule(ActionEvent actionEvent) {
        if (changeScheduleLessonPane.isVisible()) {
            changeScheduleLessonPane.setVisible(false);
            allLessonsComboBoxScheduleEdit.getItems().clear();
            editDayComboBox.getItems().clear();
            editEndHourComboBox.getItems().clear();
            editStartHourComboBox.getItems().clear();
        } else {
            String[] daysWeek = {"Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira"};
            String[] hours = {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"};

            String[] lessonsname = new String[lessonsST.size()];
            int i = 0;
            for (Integer lessonName : lessonsST.keys()) {
                lessonsname[i] = lessonName.toString();
                i++;
            }

            allLessonsComboBoxScheduleEdit.getItems().addAll(lessonsname);
            editStartHourComboBox.getItems().addAll(hours);
            editEndHourComboBox.getItems().addAll(hours);
            editDayComboBox.getItems().addAll(daysWeek);
            changeScheduleLessonPane.setVisible(true);
        }
    }

    /**
     * Função que faz a alteração do horario de uma aula
     *
     * @param actionEvent
     */
    public void handleChangeLessonScheduleSubmit(ActionEvent actionEvent) {
        Integer lessonId = Integer.parseInt(allLessonsComboBoxScheduleEdit.getSelectionModel().getSelectedItem().toString());
        String[] starthour = editStartHourComboBox.getSelectionModel().getSelectedItem().toString().split(":");
        String[] endhour = editEndHourComboBox.getSelectionModel().getSelectedItem().toString().split(":");
        String day = editDayComboBox.getSelectionModel().getSelectedItem().toString();

        DateSchedule start = new DateSchedule(Integer.parseInt(starthour[0]), Integer.parseInt(starthour[1]), day);
        DateSchedule end = new DateSchedule(Integer.parseInt(endhour[0]), Integer.parseInt(endhour[1]), day);

        Lesson lesson = lessonsST.get(lessonId);
        // se entrar no if significa que não foi alterada porque o professor não pode no horario pretendido
        if (!lesson.editSchedule(start, end)) {
            alert(Alert.AlertType.ERROR, "Error", "Ups, algo correu mal", "O professor já está ocupado no horario pretendido");
        } else {
            alert(Alert.AlertType.CONFIRMATION, "Sucesso!", "Alteração efectuada", "O horario da aula foi alterado para " + lesson.getStarthour() + " - " + lesson.getEndhour());

            handleShowLessonsTable(actionEvent);
        }
    }

    /**
     * Função que insere uma nova unidade curricular
     *
     * @param actionEvent
     */
    public void handleAddCurricularUnitSubmit(ActionEvent actionEvent) {
        String id = curricularUnitidField.getText();
        curricularUnitidField.clear();
        String ects = curricularUnitEctsField.getText();
        curricularUnitEctsField.clear();
        String year = curricularUnitYearField.getText();
        curricularUnitYearField.clear();
        String name = curricularUnitNameField.getText();
        curricularUnitNameField.clear();

        if (!curricularUnitsST.contains(id)) {
            CurricularUnit curricularUnit = new CurricularUnit(id, name, Integer.parseInt(ects), Integer.parseInt(year));
            curricularUnitsST.put(curricularUnit.getId(), curricularUnit);
        } else {
            CurricularUnit curricularUnit = curricularUnitsST.get(id);
            curricularUnit.setEcts(Integer.parseInt(ects));
            curricularUnit.setYear(Integer.parseInt(year));
            curricularUnit.setName(name);
        }

        handleShowCurricularUnitsTable(actionEvent);
    }

    /**
     * Função que insere todas as unidades curriculares na tabela das unidades curriculares
     *
     * @param event
     */
    public void handleShowCurricularUnitsTable(Event event) {
        curricularUnitTable.getItems().clear();
        for (String key : curricularUnitsST.keys()) {
            curricularUnitTable.getItems().addAll(curricularUnitsST.get(key));
        }
    }

    /**
     * Função que faz a gestão da pane de remoção de uma unidade curricular
     *
     * @param actionEvent
     */
    public void handleRemoveCurricularUnit(ActionEvent actionEvent) {
        if (removeCurricularUnitPane.isVisible()) {
            removeCurricularUnitPane.setVisible(false);
            curricularUnitComboBox.getItems().clear();
        } else {
            String[] curricularUnitsName = new String[curricularUnitsST.size()];
            int i = 0;
            for (String name : curricularUnitsST.keys()) {
                curricularUnitsName[i] = name;
                i++;
            }
            curricularUnitComboBox.getItems().addAll(curricularUnitsName);
            removeCurricularUnitPane.setVisible(true);
        }
    }

    /**
     * Função que faz a remoção total de uma unidade curricular
     *
     * @param actionEvent
     */
    public void handleRemoveCurricularUnitSubmit(ActionEvent actionEvent) {
        String curricularName = curricularUnitComboBox.getSelectionModel().getSelectedItem().toString();
        deleteCourseClass(curricularName, curricularUnitsST, classST, lessonsST, studentsST, teachersST, nodesRB, ".//data//dump//courseclassdump.txt");
        handleShowCurricularUnitsTable(actionEvent);
    }

    /**
     * Função que faz a gestão da pane que mostra as unidades curriculares no momento
     *
     * @param actionEvent
     */
    public void handleShowNowCurricularUnit(ActionEvent actionEvent) {
        if (curricularUnitNowPane.isVisible()) {
            nowCurricularUnitTable.getItems().clear();
            curricularUnitNowPane.setVisible(false);
        } else {
            ArrayList<CurricularUnit> nowcurricularUnits = curricularUnitsAtMoment(new DateSchedule(15, 30, 2), classST);
            nowCurricularUnitTable.getItems().clear();
            nowCurricularUnitTable.getItems().addAll(nowcurricularUnits);
            curricularUnitNowPane.setVisible(true);
        }
    }

    /**
     * Função que mostra e preenche a tabela de estudantes
     *
     * @param event
     */
    public void handleShowStudentsTable(Event event) {
        studentsTable.getItems().clear();
        for (Long key : studentsST.keys()) {
            studentsTable.getItems().add(studentsST.get(key));
        }
    }

    /**
     * Função que mostra e preenche a tabela de professores
     *
     * @param event
     */
    public void handleShowTeachersTable(Event event) {
        teachersTable.getItems().clear();
        for (Long key : teachersST.keys()) {
            teachersTable.getItems().add(teachersST.get(key));
        }
    }

    /**
     * Mostra horario de atendimento do professor selecionado
     *
     * @param actionEvent
     */
    public void handleShowTeacherAttendance(ActionEvent actionEvent) {
        String teachersName = allTeachersComboBox.getSelectionModel().getSelectedItem().toString();
        attendanceShowTable.getItems().clear();

        for (Long key : teachersST.keys()) {
            //verificar se é o professor que queremos
            if (teachersST.get(key).getName().equals(teachersName)) {
                for (Integer akey : teachersST.get(key).getAttendanceBST().keys()) {
                    attendanceShowTable.getItems().add(teachersST.get(key).getAttendanceBST().get(akey));
                }
            }
        }

    }

    /**
     * Função que faz a gestão da pane do atendimento do professor
     *
     * @param actionEvent
     */
    public void handleShowAttendanceButton(ActionEvent actionEvent) {
        if (teacherAttendancePane.isVisible()) {
            teacherAttendancePane.setVisible(false);
            allTeachersComboBox.getItems().clear();
            attendanceShowTable.getItems().clear();
        } else {
            String[] teachersName = getAllTeachersName(teachersST);
            allTeachersComboBox.getItems().addAll(teachersName);
            teacherAttendancePane.setVisible(true);
        }
    }

    /**
     * Função que faz a gestão da pane que mostra os professores ocupados no momento
     *
     * @param actionEvent
     */
    public void handleShowBusyTeachersNow(ActionEvent actionEvent) {
        if (teachersBusyPane.isVisible()) {
            teachersBusyPane.setVisible(false);
            busyTeachersTable.getItems().clear();
        } else {
            ArrayList<Teacher> teachers = teacherBusy(new DateSchedule(15, 00, 2), teachersST);
            busyTeachersTable.getItems().addAll(teachers);
            teachersBusyPane.setVisible(true);
        }
    }

    /**
     * Função que mostra os professores ocupados no momento
     *
     * @param actionEvent
     */
    public void handleShowBusyStudentsNow(ActionEvent actionEvent) {
        if (studentsBusyPane.isVisible()) {
            studentsBusyPane.setVisible(false);
            busyStudentsTable.getItems().clear();
        } else {
            ArrayList<Student> studentsBusy = studentBusy(new DateSchedule(15, 00, 2), studentsST);
            studentsBusyPane.setVisible(true);
            busyStudentsTable.getItems().addAll(studentsBusy);
        }
    }

    /**
     * Função que faz a gestão da pane que mostra as turmas de um professor
     *
     * @param actionEvent
     */
    public void handleShowaClassTeacherButton(ActionEvent actionEvent) {
        if (teacheraClassPane.isVisible()) {
            teacheraClassPane.setVisible(false);
            allTeachersComboBox1.getItems().clear();
            aClassTeacherShowTable.getItems().clear();
        } else {
            allTeachersComboBox1.getItems().addAll(getAllTeachersName(teachersST));
            teacheraClassPane.setVisible(true);
        }
    }

    /**
     * Função que mostra as turmas/horario de um professor
     *
     * @param actionEvent
     */
    public void handleShowTeacheraClass(ActionEvent actionEvent) {
        String teacherName = allTeachersComboBox1.getSelectionModel().getSelectedItem().toString();
        aClassTeacherShowTable.getItems().clear();

        for (Long key : teachersST.keys()) {
            if (teachersST.get(key).getName().equals(teacherName)) {
                Teacher teacher = teachersST.get(key);
                for (Integer lKey : teacher.getSchedule().keys()) {
                    Lesson lesson = teachersST.get(key).getSchedule().get(lKey);
                    aClassTeacherShowTable.getItems().add(lesson);
                }
            }
        }
    }

    /**
     * Função que faz a gestão da pane para remoção de um professor
     *
     * @param actionEvent
     */
    public void handleRemoveTeacherButton(ActionEvent actionEvent) {
        if (removeTeacherPane.isVisible()) {
            allTeacherToRemoveComboBox.getItems().clear();
            removeTeacherPane.setVisible(false);
        } else {
            allTeacherToRemoveComboBox.getItems().addAll(getAllTeachersName(teachersST));
            removeTeacherPane.setVisible(true);
        }
    }

    /**
     * Função que remove um professor
     *
     * @param actionEvent
     */
    public void handleRemoveTeacherSubmit(ActionEvent actionEvent) {
        String teacherName = allTeacherToRemoveComboBox.getSelectionModel().getSelectedItem().toString();

        for (Long key : teachersST.keys()) {
            Teacher teacher = teachersST.get(key);

            if (teacher.getName().equals(teacherName)) {
                deleteTeacher(teacher.getNumber(), teachersST, curricularUnitsST, classST, ".//data//dump//teachersdump.txt");
            }
        }
        handleShowTeachersTable(actionEvent);
    }

    /**
     * Função que faz a gestão da pane de visualização dos professores de uma unidade curricular
     *
     * @param actionEvent
     */
    public void handleShowCUnitTeachersButton(ActionEvent actionEvent) {
        if (teachersandStudentsCUnitsPane.isVisible()) {
            teachersandStudentsCUnitsPane.setVisible(false);
            allCurricularUnitsComboBox.getItems().clear();
            allCurricularUnitsComboBox1.getItems().clear();
            cUnitsTeachersTable.getItems().clear();
        } else {
            allCurricularUnitsComboBox.getItems().addAll(getAllUC(curricularUnitsST));
            allCurricularUnitsComboBox1.getItems().addAll(getAllUC(curricularUnitsST));
            teachersandStudentsCUnitsPane.setVisible(true);
        }
    }

    /**
     * Função que mostra os professores de uma unidade curricular
     *
     * @param actionEvent
     */
    public void handleShowTeachersCUnits(ActionEvent actionEvent) {
        String uCName = allCurricularUnitsComboBox.getSelectionModel().getSelectedItem().toString();
        CurricularUnit uC = curricularUnitsST.get(uCName);
        cUnitsTeachersTable.getItems().clear();
        for (Long key : uC.getTeachers().keys()) {
            cUnitsTeachersTable.getItems().add(uC.getTeachers().get(key));
        }
    }

    public void handleShowStudentsCUnits(ActionEvent actionEvent) {
        String uCName = allCurricularUnitsComboBox1.getSelectionModel().getSelectedItem().toString();
        cUnitsStudentsTable.getItems().clear();

        for (Long key : studentsST.keys()) {
            Student student = studentsST.get(key);
            if (student.getcUnit().contains(uCName)) {
                cUnitsStudentsTable.getItems().add(student);
            }
        }
    }

    /**
     * Função que mostra a pane com o horario do aluno
     *
     * @param actionEvent
     */
    public void handleShowStudentsaClassButton(ActionEvent actionEvent) {
        if (studentsaClassPane.isVisible()) {
            studentsaClassPane.setVisible(false);
            allStudentsComboBox.getItems().clear();
        } else {
            allStudentsComboBox.getItems().addAll(getAllStudentsNumber(studentsST));
            studentsaClassPane.setVisible(true);
        }
    }

    /**
     * Função que mostra o horario do estudante
     *
     * @param actionEvent
     */
    public void handleShowStudentsaClass(ActionEvent actionEvent) {
        aClassStudentTable.getItems().clear();
        Long studentNumber = Long.parseLong(allStudentsComboBox.getSelectionModel().getSelectedItem().toString());
        Student student = studentsST.get(studentNumber);

        for (Integer lKey : student.getSchedule().keys()) {
            aClassStudentTable.getItems().add(student.getSchedule().get(lKey));
        }
    }

    /**
     * Função que recebe toda a informação dos ficheiros binarios
     *
     * @param actionEvent
     */
    public void getDatafromBinFiles(ActionEvent actionEvent) {
        System.out.println("BIN");
        readBinStudents(studentsST);
        readBinTeachers(teachersST);
        readBinaClass(classST);
        readBinCurricularUnits(curricularUnitsST);
        readBinNodes(nodesRB);
        readBinLessons(lessonsST);
        symbolGraph = readBinSymbolGraph();

        //symbolGraph = new SymbolGraph_PROJ(".//data//graphs//symbolgraph.txt", ";");
    }

    /**
     * Função que recebe toda a informação de ficheiros de texto
     *
     * @param actionEvent
     */
    public void getDataFromTxtFiles(ActionEvent actionEvent) {
        readClassroomsFromFile(nodesRB, ".//data//classrooms.txt");
        readCrossingPointsFromFile(nodesRB, ".//data//CrossingPoints.txt");
        readTeachersFromFile(teachersST, ".//data//teachers.txt");
        readAttendanceFromFile(teachersST, nodesRB, ".//data//attendance.txt");
        readCurricularUnitsFromFile(curricularUnitsST, ".//data//curricularUnits.txt");
        readTeacherCurricularUnitsFromFile(teachersST, curricularUnitsST, ".//data//teacherCourseclass.txt");
        readStudentsFromFile(studentsST, ".//data//students.txt");
        readStudentsCurricularUnitsFromFile(studentsST, curricularUnitsST, ".//data//studentCurricularUnits.txt");
        readClassFromFile(classST, lessonsST, curricularUnitsST, teachersST, ".//data//class.txt");
        readStudentsClassFromFile(studentsST, classST, ".//data//studentsClass.txt");
        readAssociateClassroomsFromFile(nodesRB, lessonsST, ".//data//associateClassrooms.txt");

        symbolGraph = new SymbolGraph_PROJ(".//data//graphs//symbolgraph.txt", ";");
    }

    /**
     * Função que guarda toda a informação em ficheiros binarios
     *
     * @param actionEvent
     */
    public void saveAllDatatoBinFiles(ActionEvent actionEvent) {
        saveBinStudents(studentsST);
        saveBinTeachers(teachersST);
        saveBinaClass(classST);
        saveBinCurricularUnits(curricularUnitsST);
        saveBinNodes(nodesRB);
        saveBinLessons(lessonsST);
        saveBinSymbolGraph(symbolGraph);
    }

    /**
     * Função que faz a gestão da pane para remoção de estudante
     *
     * @param actionEvent
     */
    public void handleRemoveStudentButton(ActionEvent actionEvent) {
        if (removeStudentPane.isVisible()) {
            removeStudentPane.setVisible(false);
        } else {
            allStudentstoRemoveComboBox.getItems().clear();
            String[] studentsNumber = getAllStudentsNumber(studentsST);
            allStudentstoRemoveComboBox.getItems().addAll(studentsNumber);
            removeStudentPane.setVisible(true);
        }
    }

    /**
     * Função que remove um estudante permanentemente
     *
     * @param actionEvent
     */
    public void handleRemoveStudentSubmit(ActionEvent actionEvent) {
        Long studentId = Long.parseLong(allStudentstoRemoveComboBox.getSelectionModel().getSelectedItem().toString());

        deleteStudent(classST, studentsST, studentId, ".//data//dump/studentsdump.txt");
        handleShowStudentsTable(actionEvent);
    }

    /**
     * Função que mostra os estudantes de uma turma
     *
     * @param actionEvent
     */
    public void handleShowaClassStudents(ActionEvent actionEvent) {
        String aClassiD = allaClassStudentsComboBox.getSelectionModel().getSelectedItem().toString();

        Class aClass = classST.get(aClassiD);
        aClassStudentsTable.getItems().clear();
        for (Long key : aClass.getStudents().keys()) {
            Student s = aClass.getStudents().get(key);
            aClassStudentsTable.getItems().add(s);
        }
    }

    /**
     * Função que faz a gestão da pane que mostra os alunos de uma turma
     *
     * @param actionEvent
     */
    public void handleShowaClassStudentsButton(ActionEvent actionEvent) {
        if (aClassStudentsPane.isVisible()) {
            aClassStudentsPane.setVisible(false);
            allaClassStudentsComboBox.getItems().clear();
            aClassStudentsTable.getItems().clear();
        } else {
            String[] aClass = getAllClassNames(classST);
            allaClassStudentsComboBox.getItems().addAll(aClass);
            aClassStudentsPane.setVisible(true);
        }
    }

    /**
     * Função que faz a gestão da pane de associar um professor a uma unidade curricular
     *
     * @param actionEvent
     */
    public void handleAssociateTeacherToCurricularUnitsButton(ActionEvent actionEvent) {
        if (associateTeacherToCurricularUnitPane.isVisible()) {
            associateTeacherToCurricularUnitPane.setVisible(false);
            allCurricularUnitsToAssociateComboBox.getItems().clear();
            allTeachersToCurricularComboBox.getItems().clear();
        } else {
            allCurricularUnitsToAssociateComboBox.getItems().addAll(getAllUC(curricularUnitsST));
            associateTeacherToCurricularUnitPane.setVisible(true);
        }
    }

    public void handleAssociateTeacherToCurricularUnitSubmit(ActionEvent actionEvent) {
        String uCiD = allCurricularUnitsToAssociateComboBox.getSelectionModel().getSelectedItem().toString();
        CurricularUnit uc = curricularUnitsST.get(uCiD);
        String teachersName = allTeachersToCurricularComboBox.getSelectionModel().getSelectedItem().toString();

        for (Long key : teachersST.keys()) {
            if (teachersST.get(key).getName().equals(teachersName)) {
                teachersST.get(key).putcUnit(uc);
            }
        }

    }

    public void handleShowAllTeachersToAssociate(ActionEvent actionEvent) {
        String uCiD = allCurricularUnitsToAssociateComboBox.getSelectionModel().getSelectedItem().toString();
        CurricularUnit uc = curricularUnitsST.get(uCiD);

        ArrayList<Teacher> teachers = new ArrayList<>();
        for (Long key : teachersST.keys()) {
            Teacher t = teachersST.get(key);
            //verifica se esta unidade curricular ainda não faz parte das unidades curriculares do teacher.
            if (!t.getcUnit().contains(uc.getId())) {
                teachers.add(t);
            }
        }

        String[] teachersName = new String[teachers.size()];
        int i = 0;
        for (Teacher teacher : teachers) {
            teachersName[i] = teacher.getName();
            i++;
        }
        allTeachersToCurricularComboBox.getItems().addAll(teachersName);
    }

    public void handleInsertnewStudentButton(ActionEvent actionEvent) {
        if (insertStudentPane.isVisible()) {
            numberInsertStudentField.clear();
            nameStudentInsertField.clear();
            addressStudentInsertField.clear();
            emailStudentInsertField.clear();
            birthStudentInsertField.clear();
            insertStudentPane.setVisible(false);
        } else {
            insertStudentPane.setVisible(true);
        }
    }

    public void handleInsertNewStudentSubmit(ActionEvent actionEvent) {
        String name = nameStudentInsertField.getText();
        Long number = Long.parseLong(numberInsertStudentField.getText());
        String address = addressStudentInsertField.getText();
        String email = emailStudentInsertField.getText();
        String[] birth = birthStudentInsertField.getText().split("/");
        Date biirth = new Date(Integer.parseInt(birth[0]), Integer.parseInt(birth[1]), Integer.parseInt(birth[2]));
        Date registration = new Date();

        Student newStudent = new Student(name, address, biirth, email, registration, number);
        studentsST.put(number, newStudent);
    }

    public void handleAssociateStudentaClassButton(ActionEvent actionEvent) {
        if (associateStudentaClassPane.isVisible()) {
            associateStudentaClassPane.setVisible(false);
            allStudentsAssociateaClassComboBox.getItems().clear();
            allClasstoAssociateStudentsComboBox.getItems().clear();
        } else {
            allClasstoAssociateStudentsComboBox.getItems().addAll(getAllClassNames(classST));
            allStudentsAssociateaClassComboBox.getItems().addAll(getAllStudentsNumber(studentsST));
            associateStudentaClassPane.setVisible(true);
        }
    }

    public void handleAssociateStudentaClassSubmit(ActionEvent actionEvent) {
        String aClassId = allClasstoAssociateStudentsComboBox.getSelectionModel().getSelectedItem().toString();
        Long studentNumber = Long.parseLong(allStudentsAssociateaClassComboBox.getSelectionModel().getSelectedItem().toString());

        Class aClass = classST.get(aClassId);
        Student student = studentsST.get(studentNumber);

        if (student.checkSchedule(aClass.getLesson())) {
            if (!aClass.addStudent(student)) {
                alert(Alert.AlertType.ERROR, "Error", "Ups, algo correu mal", "O aluno não faz parte da unidade curricular da turma " + aClass.getId());
            }
        }
    }

    public void handleAssociateStudentsToCurricularUnitsButton(ActionEvent actionEvent) {
        if (cUnitsStudentsAssociatePane.isVisible()) {
            allCurricularUnitsAssociateStudentComboBox.getItems().clear();
            studentsWithoutcUnitComboBox.getItems().clear();
            cUnitsStudentsAssociatePane.setVisible(false);
        } else {
            allCurricularUnitsAssociateStudentComboBox.getItems().addAll(getAllUC(curricularUnitsST));
            cUnitsStudentsAssociatePane.setVisible(true);
        }
    }

    public void handleShowAllStudentsWithoutcUnit(ActionEvent actionEvent) {
        String ucId = allCurricularUnitsAssociateStudentComboBox.getSelectionModel().getSelectedItem().toString();

        for (Long key : studentsST.keys()) {
            Student student = studentsST.get(key);
            // verificar se a unidade curricular ainda não faz parte das unidades curricular do aluno
            if (!student.getcUnit().contains(ucId)) {
                studentsWithoutcUnitComboBox.getItems().add(student.getNumber());
            }
        }
    }

    public void handleSubmitStudentcUnitSubmit(ActionEvent actionEvent) {
        String ucId = allCurricularUnitsAssociateStudentComboBox.getSelectionModel().getSelectedItem().toString();
        Long studentId = Long.parseLong(studentsWithoutcUnitComboBox.getSelectionModel().getSelectedItem().toString());

        studentsST.get(studentId).putcUnit(curricularUnitsST.get(ucId));
    }

}
