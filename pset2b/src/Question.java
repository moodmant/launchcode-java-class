
/**
 * Created by taylor on 5/5/15.
 */
public class Question {
    private String questionText;
    private String answerText;

    public Question(String questionText, String answerText) {
        this.questionText = questionText;
        this.answerText = answerText;
    }

    public void ask() {
        System.out.println(this.questionText);
    }

    public boolean check(Object userAnswer){
        return userAnswer.equals(answerText);
    }

    public String getAnswerText() {
        return answerText;
    }

    public String getQuestionText() {
        return questionText;
    }

}