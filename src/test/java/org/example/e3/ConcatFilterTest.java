package org.example.e3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcatFilterTest {
    @Test
    @DisplayName("Query makealongstoryshort should return makealongstoryshort")
    public void solution_q1_Test() {
        Exercise3 exercise = new Exercise3();

        String query = "makealongstoryshort";
        String expected = "make a long story short";

        assertEquals(expected, exercise.solution(query).get(0));
    }

    @Test
    @DisplayName("Query tobeornottobethatisthequestion should return - to be or not to be that is the question")
    public void solution_q2_Test() {
        Exercise3 exercise = new Exercise3();

        String query = "tobeornottobethatisthequestion";
        String expected = "to be or not to be that is the question";

        assertEquals(expected, exercise.solution(query).get(0));
    }

    @Test
    @DisplayName("Query seeeyetoeye should return - see eye to eye")
    public void solution_q3_Test() {
        Exercise3 exercise = new Exercise3();

        String query = "seeeyetoeye";
        String expected = "see eye to eye";

        assertEquals(expected, exercise.solution(query).get(0));
    }

    @Test
    @DisplayName("Query make a long story short should return makealongstoryshort")
    public void solution2Test() {
        Exercise3 exercise = new Exercise3();

        String query = "make a long story short";
        String expected = "make a long story short";

        assertEquals(expected, exercise.solution(query).get(0));
    }

    @Test
    @DisplayName("Query makealongstorysh should return 0 matches")
    public void solution_errorTest() {
        Exercise3 exercise = new Exercise3();

        String query = "makealongstorysh";
        int expected = 0;

        assertEquals(expected, exercise.solution(query).size());
    }
}
