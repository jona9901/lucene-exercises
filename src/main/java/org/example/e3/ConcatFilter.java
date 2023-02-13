package org.example.e3;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
public class ConcatFilter extends TokenFilter {
    private final CharTermAttribute termAtt = (CharTermAttribute)this.addAttribute(CharTermAttribute.class);

    public ConcatFilter(TokenStream in) {
        super(in);
    }

    @Override
    public boolean incrementToken() throws IOException {
        if (this.input.incrementToken()) {
            String tempToken = "";
            for(char c:termAtt.buffer()){
                //if present character is not a white space then add to it temporary string
                if(c != ' '){
                    tempToken += c;
                }
            }
            termAtt.setEmpty();
            termAtt.copyBuffer(tempToken.toCharArray(), 0, tempToken.toCharArray().length);
            return true;
        } else {
            return false;
        }
    }
}
