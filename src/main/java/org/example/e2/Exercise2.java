package org.example.e2;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
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
import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
    DocsUtils utils;
    Analyzer analyzer;
    List<String> matches;

    String name;
    String text1, text2, text3;
    List<String> documents;

    Exercise2() {
        utils = new DocsUtils();
        analyzer = new StandardAnalyzer();
        matches = new ArrayList<>();

        name = "title";
        text1 = "to be or not to be that is the question";
        text2 = "make a long story short";
        text3 = "see eye to eye";
        documents = List.of(text1, text2, text3);
    }

    public List<String> solution(String queryIn, int n) {
        String parsedQuery = "\"" + queryIn + "\"~" + Integer.toString(n);
        try {
            Path indexPath = Files.createTempDirectory("tempIndex");
            Directory directory = FSDirectory.open(indexPath);

            utils.writeDocs(analyzer, directory, name, documents);

            DirectoryReader ireader = DirectoryReader.open(directory);
            IndexSearcher isearcher = new IndexSearcher(ireader);

            QueryParser queryParser = new QueryParser(name, analyzer);

            Query query = queryParser.parse(parsedQuery);

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
