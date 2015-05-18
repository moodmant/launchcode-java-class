import javax.lang.model.element.Name;

/**
 * Created by taylor on 4/28/15.
*/
public class Course {
    private String name;
    private double credits;
    private int numberOfSeats;
    private int closedSeats;
    private Student[] rosterOfStudents;


    public Course(String name, double credits, int numberOfSeats) {
        this.name = name;
        this.credits = credits;
        this.numberOfSeats = numberOfSeats;
        this.closedSeats = 0;
        this.rosterOfStudents =new Student[numberOfSeats];
    }

    public String getName() {
        return name;
    }

    public double getCredits() {
        return credits;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }

    public int getClosedSeats() {
        return this.closedSeats;
    }

    public Student[] getRosterOfStudents() {
        return this.rosterOfStudents;
    }

    public String toString(){
        return this.name + ", " + this.credits;
    }

    public boolean addStudent(Student someone){
        if(this.search(someone)) {
            return true;
        }
        if (this.closedSeats == this.numberOfSeats) {
            return false;
        }
        this.getRosterOfStudents()[this.closedSeats] = someone;
        this.closedSeats++;
        return true;
    }

    public boolean search(Student someone){
        for (int i = 0; i < this.numberOfSeats; i++) {
            if (this.getRosterOfStudents()[i] == someone) {
                return true;
            }
        }
        return false;
    }

    public void printRoster(){
        for (int i = 0; i < this.getClosedSeats(); i++){
            System.out.println(this.getRosterOfStudents()[i].getName());
        }
    }

    public double averageGPA(){
        double totalGPA = 0;
        for (int i = 0; i < this.getClosedSeats(); i++){
            totalGPA = this.getRosterOfStudents()[i].getGPA() + totalGPA;
        }
        return((double)(Math.round((totalGPA / this.getClosedSeats()) * 10))) / 10;
    }
}