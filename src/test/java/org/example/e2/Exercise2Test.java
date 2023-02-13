package org.example.e2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Exercise2Test {
    @Test
    @DisplayName("Query - to be not - n=1 - Should return document 1")
    public void solution1Test() {
        Exercise2 exercise2 = new Exercise2();

        String query = "to be not";
        int n = 1;

        assertEquals("to be or not to be that is the question", exercise2.solution(query, n).get(0));
    }

    @Test
    @DisplayName("Query - to or to - n=1 - Should return 0 documents")
    public void solution2Test() {
        Exercise2 exercise2 = new Exercise2();

        String query = "to or to";
        int n = 1;

        assertEquals(0, exercise2.solution(query, n).size());
    }

    @Test
    @DisplayName("Query - to - n=1 - Should return 2 document")
    public void solution3Test() {
        Exercise2 exercise2 = new Exercise2();

        String query = "to";
        int n = 1;

        assertEquals(2, exercise2.solution(query, n).size());
    }

    @Test
    @DisplayName("Query - long story short - n=0 - Should return doc 2")
    public void solution4Test() {
        Exercise2 exercise2 = new Exercise2();

        String query = "long story short";
        int n = 0;

        assertEquals("make a long story short", exercise2.solution(query, n).get(0));
    }

    @Test
    @DisplayName("Query - long short - n=0 - Should return 0 document")
    public void solution5Test() {
        Exercise2 exercise2 = new Exercise2();

        String query = "long short";
        int n = 0;

        assertEquals(0, exercise2.solution(query, n).size());
    }

    @Test
    @DisplayName("Query - long short - n=1 - Should return doc 2")
    public void solution6Test() {
        Exercise2 exercise2 = new Exercise2();

        String query = "long short";
        int n = 1;

        assertEquals("make a long story short", exercise2.solution(query, n).get(0));
    }

    @Test
    @DisplayName("Query - long short - n=0 - Should return 0 document")
    public void solution7Test() {
        Exercise2 exercise2 = new Exercise2();

        String query = "long short";
        int n = 0;

        assertEquals(0, exercise2.solution(query, n).size());
    }

    @Test
    @DisplayName("Query - story long - n=0 - Should return 0 document")
    public void solution8Test() {
        Exercise2 exercise2 = new Exercise2();

        String query = "story long";
        int n = 0;

        assertEquals(0, exercise2.solution(query, n).size());
    }
}
