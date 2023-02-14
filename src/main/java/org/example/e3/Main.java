package org.example.e3;

import org.apache.lucene.analysis.core.StopFilterFactory;
import org.apache.lucene.analysis.core.WhitespaceTokenizerFactory;
import org.apache.lucene.analysis.custom.CustomAnalyzer;
import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        CustomAnalyzer analyzer = CustomAnalyzer.builder(Paths.get("/path/to/config/dir"))
                .withTokenizer(WhitespaceTokenizerFactory.class)
                .addTokenFilter(ConcatFilterFactory.findSPIName(ConcatFilterFactory.class))
                .addTokenFilter(StopFilterFactory.class, "ignoreCase", "false", "words", "stopwords.txt", "format", "wordset")
                .build();
    }
}
