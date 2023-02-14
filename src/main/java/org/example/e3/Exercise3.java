package org.example.e3;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.StopFilterFactory;
import org.apache.lucene.analysis.core.WhitespaceTokenizerFactory;
import org.apache.lucene.analysis.custom.CustomAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.complexPhrase.ComplexPhraseQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.IOUtils;
import org.example.utils.DocsUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Exercise3 {
    DocsUtils utils;
    Analyzer analyzer;
    List<String> matches;
    String name;
    String text1, text2, text3;
    List<String> documents;

    Exercise3() {
        utils = new DocsUtils();
        matches = new ArrayList<>();

        name = "title";
        text1 = "To be Or not to be that is the question";
        text2 = "make a long story short";
        text3 = "see eye to eye";
        documents = List.of(text1, text2, text3);
    }

    public List<String> solution(String queryIn){
        StringBuilder q = new StringBuilder();

        try {
            analyzer = new StandardAnalyzer();

            Path indexPath = Files.createTempDirectory("tempIndex");
            Directory directory = FSDirectory.open(indexPath);

            utils.writeDocs(analyzer, directory, name, documents);

            DirectoryReader ireader = DirectoryReader.open(directory);
            IndexSearcher isearcher = new IndexSearcher(ireader);

            ComplexPhraseQueryParser queryParser = new ComplexPhraseQueryParser(name, analyzer);
            Query query = queryParser.parse(q.toString());

            ScoreDoc[] hits = isearcher.search(query, 10).scoreDocs;

            // Iterate through the results:
            for (int i = 0; i < hits.length; i++) {
                Document hitDoc = isearcher.doc(hits[i].doc);
                matches.add(hitDoc.get(name));
            }

            ireader.close();
            directory.close();
            IOUtils.rm(indexPath);

        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        } catch (ParseException parseException) {
            System.out.println(parseException.getMessage());
        }

        return matches;
    }
}
