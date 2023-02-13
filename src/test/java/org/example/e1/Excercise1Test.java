package org.example.e1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Excercise1Test {
    @Test
    @DisplayName("Query lqdocs - should return lucene/queryparser/docs/xml/img/plus.gif")
    public void solutionTest() {
        Exercise1 exercise1 = new Exercise1();

        String query = "lqdocsplg";
        String expected = "lucene/queryparser/docs/xml/img/plus.gif";

        assertEquals(expected, exercise1.solution(query).get(0));
    }

    @Test
    @DisplayName("Query lqdocs - should return lucene/queryparser/docs/xml/img/plus.gif")
    public void solutionTest() {
        Exercise1 exercise1 = new Exercise1();

        String query = "lqdocsplg";
        String expected = "lucene/queryparser/docs/xml/img/plus.gif";

        assertEquals(expected, exercise1.solution(query).get(0));
    }
}
