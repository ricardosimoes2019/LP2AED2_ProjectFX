package university;

public class FreeClassroom {

    public String classroomName;
    public DateSchedule startHour;
    public DateSchedule endHour;

    public FreeClassroom(String classroomName, DateSchedule startHour, DateSchedule endHour) {
        this.classroomName = classroomName;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public DateSchedule getStartHour() {
        return startHour;
    }

    public void setStartHour(DateSchedule startHour) {
        this.startHour = startHour;
    }

    public DateSchedule getEndHour() {
        return endHour;
    }

    public void setEndHour(DateSchedule endHour) {
        this.endHour = endHour;
    }
}
