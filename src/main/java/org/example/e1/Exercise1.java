package org.example.e1;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
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
import java.util.ArrayList;
import java.util.List;

public class Exercise1 {
    DocsUtils utils;
    Analyzer analyzer;
    List<String> matches;

    String name;
    String url1, url2, url3;
    List<String> documents;

    Exercise1() {
        utils = new DocsUtils();
        analyzer = new KeywordAnalyzer();
        matches = new ArrayList<>();

        name = "url";
        url1 = "lucene/queryparser/docs/xml/img/plus.gif";
        url2 = "lucene/queryparser/docs/xml/img/join.gif";
        url3 = "lucene/queryparser/docs/xml/img/minusbottom.gif";
        documents = List.of(url1, url2, url3);
    }

    public List<String> solution(String queryIn){
        StringBuilder q = new StringBuilder();

        for (int i = 0; i < queryIn.length(); i++) {
            q.append(Character.toChars(queryIn.charAt(i)));
            q.append('*');
        }

        try {
            Path indexPath = Files.createTempDirectory("tempIndex");
            Directory directory = FSDirectory.open(indexPath);

            utils.writeDocs(analyzer, directory, name, documents);

            DirectoryReader ireader = DirectoryReader.open(directory);
            IndexSearcher isearcher = new IndexSearcher(ireader);

            ComplexPhraseQueryParser queryParser = new ComplexPhraseQueryParser("url", analyzer);
            Query query = queryParser.parse(q.toString());

            ScoreDoc[] hits = isearcher.search(query, 10).scoreDocs;

            // Iterate through the results:
            for (int i = 0; i < hits.length; i++) {
                Document hitDoc = isearcher.doc(hits[i].doc);
                matches.add(hitDoc.get("url"));
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
