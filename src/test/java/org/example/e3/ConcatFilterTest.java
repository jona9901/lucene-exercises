package org.example.e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcatFilterTest {
    @Test
    public void solutionTest() {
        Exercise3 exercise = new Exercise3();

        String query = "makealongstoryshort";
        String expected = "make a long story short";

        assertEquals(expected, exercise.solution(query).get(0));
    }
}
