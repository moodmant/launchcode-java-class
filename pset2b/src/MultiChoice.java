/**
 * Created by taylor on 5/5/15.
 */
public class MultiChoice extends Question {
    private String[] choices;

    public MultiChoice(String question, String answer, String choices[]){
        super(question, answer);
        this.choices = choices;
    }

    public void ask(){
        super.ask();
        for (int i = 0; i < choices.length; i++){
            String choice = choices[i];
            System.out.println(choice);
        }
    }

    public boolean check(Object userAnswer){
        return super.check(userAnswer);
    }

}
