package org.example.e3;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
public final class ConcatFilter extends TokenFilter {
    private final CharTermAttribute termAtt = (CharTermAttribute)this.addAttribute(CharTermAttribute.class);

    public ConcatFilter(TokenStream in) {
        super(in);
    }

    @Override
    public boolean incrementToken() throws IOException {
        if (this.input.incrementToken()) {
            String term = termAtt.toString();
            String termBuff = term.replace(" ", "");

            termAtt.setEmpty();
            termAtt.copyBuffer(termBuff.toCharArray(), 0, termBuff.length());
            return true;
        } else {
            return false;
        }
    }
}
