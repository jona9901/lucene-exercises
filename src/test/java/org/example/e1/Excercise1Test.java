package org.example.e1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Excercise1Test {
    @Test
    @DisplayName("Query lqdocs - should return lucene/queryparser/docs/xml/img/plus.gif")
    public void solution_lqdocsTest() {
        Exercise1 exercise1 = new Exercise1();

        String query = "lqdocsplg";
        String expected = "lucene/queryparser/docs/xml/img/plus.gif";

        assertEquals(expected, exercise1.solution(query).get(0));
    }

    @Test
    @DisplayName("Query lqd///gif - should return 3 documents")
    public void solution_lqdgifTest() {
        Exercise1 exercise1 = new Exercise1();

        String query = "lqd///gif";
        int expected = 3;

        assertEquals(expected, exercise1.solution(query).size());
    }

    @Test
    @DisplayName("Query minusbottom.gif - should return lucene/queryparser/docs/xml/img/minusbottom.gif")
    public void solution_minusbottomTest() {
        Exercise1 exercise1 = new Exercise1();

        String query = "minus";
        String expected = "lucene/queryparser/docs/xml/img/minusbottom.gif";

        assertEquals(expected, exercise1.solution(query).get(0));
    }

    @Test
    @DisplayName("Query kjbhjg - should return no matches")
    public void solution_lqdocsNotFoundTest() {
        Exercise1 exercise1 = new Exercise1();

        String query = "kjbhjg";
        int expected = 0;

        assertEquals(expected, exercise1.solution(query).size());
    }
}
