/**
 * Created by taylor on 5/5/15.
 */
public class Numeric extends Question {

    public Numeric(String question, int answer){
        super(question, String.valueOf(answer));
    }

    public void ask(){
        super.ask();
    }

    public boolean check(Object userAnswer){
        return super.check(userAnswer);
    }
}
