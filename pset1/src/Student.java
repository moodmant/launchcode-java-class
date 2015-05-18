/**
 * Created by taylor on 4/28/15.
 */
public class Student {
    private String Name;
    private int StudentID;
    private double Credits;
    private double GPA;

    public Student(String NameF, String NameL, int StudentID, double Credits, double GPA){
        this.Name = NameF + " " + NameL;
        this.StudentID = StudentID;
        this.Credits = Credits;
        this.GPA = GPA;
    }

    public Student(String NameF, String NameL, int StudentID){
        this.Name = NameF + " " + NameL;
        this.StudentID = StudentID;
        this.Credits = 0;
        this.GPA = 0.0;
    }

    public Student(Student Parent1, Student Parent2){
        this.Name = Parent1.getName() + " " + Parent2.getName();
        this.StudentID = (int) (Math.random()*100000)+100000;
        this.Credits = Math.max(Parent1.Credits, Parent2.Credits);
        this.GPA =(Parent1.GPA + Parent2.GPA)/2;
    }

    public String getName() {
        return Name;
    }

    public int getStudentID() {
        return StudentID;
    }

    public double getCredits() {
        return Credits;
    }

    public double getGPA() {
        return GPA;
    }

    public void setCredits(double credits) {
        Credits = credits;
    }

    public String toString(){
        return this.Name + ", " + this.StudentID;
    }

    public String getClassStanding(){
        if (this.Credits > 90){
            return "Senior";
        }
        else if (this.Credits >= 60){
            return "Junior";
        }
        else if (this.Credits >= 30){
            return "Sophomore";
        }
        else if (this.Credits < 30) {
            return "Freshman";
        }
        return null;
    }

    public double submitGrade(double grade, int hours){
        double currentQualityScore = getGPA() * getCredits();
        this.Credits = getCredits() + hours;
        if (Credits > 0) {
            this.GPA = ((grade * hours) + currentQualityScore) / this.Credits;
        }
        else{
                this.GPA = 0;
            }
        return GPA;
    }

    public double computeTuition(){
        double semesters = (int) (this.Credits / 15);
        double extra = (this.Credits % 15);
        if (extra > 7){
            semesters += 1;
        }
        double cost = semesters * 20000;
        return cost;
    }

    public Student createLegacy(Student Parent2){
        Student leg = new Student(this, Parent2);
        return leg;
    }

    public static void main(String args[]) {
        Student a = new Student("John", "Doe", 101010, 30, 1);
        Student b = new Student("Jane", "Doe", 202020, 38, 2);
        Student c = new Student("Jon", "Snow", 303030, 45, 3);
        Student d = new Student("Tyrion", "Lannister", 404040, 80, 4);
        Student e = new Student("Stannis", "Baratheon", 505050, 90, 3.5);

        Course info1 = new Course("Sword Play", 3, 4);
        Course info2 = new Course("Game Theory", 2, 1);

        info1.addStudent(a);
        info1.addStudent(c);
        info1.addStudent(d);
        info2.addStudent(b);
        info2.addStudent(e);

        System.out.println("Students in " + info1.getName() + " are:");
        for(int i = 0; i < info1.getClosedSeats(); i++){
            System.out.println(info1.getRosterOfStudents()[i].getName() + ", " + info1.getRosterOfStudents()[i].getClassStanding());
        }

        System.out.println("Average GPA for students in " + info1.getName() + "is " + info1.averageGPA());
        System.out.println("");
    }
}
