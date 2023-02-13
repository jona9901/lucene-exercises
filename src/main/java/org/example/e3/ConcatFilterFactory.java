package org.example.e3;

import org.apache.lucene.analysis.TokenFilterFactory;
import org.apache.lucene.analysis.TokenStream;

import java.util.Map;

public class ConcatFilterFactory extends TokenFilterFactory {
    public ConcatFilterFactory(Map<String, String> args) {
        super(args);
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new ConcatFilter(tokenStream);
    }
}
