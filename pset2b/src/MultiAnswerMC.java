/**
 * Created by taylor on 5/11/15.
 */
public class MultiAnswerMC extends MultiChoice {
    private String[] choices;
    private String otherAnswer;

    public MultiAnswerMC(String question, String answer, String otherAnswer, String choices[]){
        super(question, answer, choices);
        this.choices = choices;
        this.otherAnswer = otherAnswer;
    }

    public void ask(){
        super.ask();
    }
    public String getOtherAnswer() {
        return otherAnswer;
    }

    public boolean check(Object userAnswer){
        if(userAnswer.equals(this.getAnswerText())||userAnswer.equals(this.getOtherAnswer())){
            return true;
        }
        else{
            return false;
        }
    }

}