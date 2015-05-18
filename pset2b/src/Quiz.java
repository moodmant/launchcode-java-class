import java.util.Scanner;
/**
 * Created by taylor on 5/6/15.
 */
public class Quiz {
    private  Question[] questions;

    public Quiz(Question[] questions){
        this.questions = questions;
    }
    public Question[] getQuestions() {
        return questions;
    }

    public void administer(){
        for(int i=0; i < this.getQuestions().length;){
            this.getQuestions()[i].ask();

            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (input.equals("")){
                System.out.println("No blank answers please.");
                System.out.println();
            }
            else{
                if(this.getQuestions()[i].check(input)){
                    report("correct");
                    System.out.println();
                }
                else{
                    report("wrong");
                    System.out.println();
                }
                i++;
            }


        }
    }
    public void report(String text){
        System.out.println(text);
    }

    public static void main(String args[]) {
        String[] choices0 = {"jupiter", "mars", "earth"};
        String[] choices1 = {"a)2+2", "b)2x2", "c)6-3"};
        Question q0 = new MultiChoice("What is the largest planet?", "jupiter", choices0);
        Question q1 = new MultiAnswerMC("Which of these is equal to 4?", "a", "b" ,choices1);
        Question q2 = new Fill("The day after Monday is _______.", "tuesday");
        Question q3 = new Numeric("How many hours are in a day?", 24);
        Question[] quizQuestions = {q0, q1, q2, q3};
        Quiz quiz = new Quiz(quizQuestions);

        quiz.administer();
    }
}
