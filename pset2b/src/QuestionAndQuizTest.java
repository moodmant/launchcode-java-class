import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by taylor on 5/5/15.
 */
public class QuestionAndQuizTest {
    @Test
    public void testQuestions(){
        Question a = new Question("simple?", "no");
        assertEquals("simple?", a.getQuestionText());
        assertEquals("no", a.getAnswerText());
    }

    @Test
    public void testMultiChoice(){
        String[] choices = {"yes", "no", "maybe"} ;
        MultiChoice a = new MultiChoice("Difficult?", "yes", choices);
        assertEquals(choices[0], a.getAnswerText());
    }

    @Test
    public void testFill(){
        String input = "Tuesday";
        Fill a = new Fill("What is after monday?", "tuesday");
        assertEquals("What is after monday?", a.getQuestionText());
        assertEquals(input.toLowerCase(), a.getAnswerText());
    }

    @Test
    public void testNumeric(){

    }
}
