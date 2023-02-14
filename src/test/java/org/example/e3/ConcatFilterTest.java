package org.example.e3;

import org.apache.lucene.analysis.core.WhitespaceTokenizerFactory;
import org.apache.lucene.analysis.custom.CustomAnalyzer;
import org.example.e1.Exercise1;
import org.example.e2.Exercise2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcatFilterTest {
    @Test
    //@DisplayName("Query lqdocs - should return lucene/queryparser/docs/xml/img/plus.gif")
    public void solutionTest() {
        Exercise3 exercise = new Exercise3();

        String query = "to be";
        String expected = "make a long story short";

        assertEquals(expected, exercise.solution(query).get(0));
    }
}
