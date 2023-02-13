package org.example.e2;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.IOUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Excercise2 {
    public void e2() throws Exception{
        Analyzer analyzer = new StandardAnalyzer();

        Path indexPath = Files.createTempDirectory("tempIndex");
        Directory directory = FSDirectory.open(indexPath);

        writeDocs(analyzer, directory);

        // Now search the index:
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);

        QueryParser parser = new QueryParser("title", analyzer);

        Query query1 = parser.parse("\"to be not\"~1");
        Query query2 = parser.parse("\"to or to\"~1");
        Query query3 = parser.parse("\"to\"~1");
        Query query4 = parser.parse("\"long story short\"~0");
        Query query5 = parser.parse("\"long short\"~0");
        Query query6 = parser.parse("\"story long\"~1");
        Query query7 = parser.parse("\"story long\"~2");

        ScoreDoc[] hits = isearcher.search(query1, 10).scoreDocs;

        System.out.println("---- Matches ----");
        // Iterate through the results:
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = isearcher.doc(hits[i].doc);
            System.out.println(hitDoc.get("title"));
        }
        System.out.println("---- Matches ----");
        ireader.close();
        directory.close();
        IOUtils.rm(indexPath);
    }

    private static void writeDocs(Analyzer analyzer, Directory directory) throws IOException {
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);

        Document doc = new Document();
        Document doc2 = new Document();
        Document doc3 = new Document();

        doc.add(new TextField("title", "to be or not to be that is the question", Field.Store.YES));
        doc2.add(new TextField("title", "make a long story short", Field.Store.YES));
        doc3.add(new TextField("title", "see eye to eye", Field.Store.YES));

        iwriter.addDocument(doc);
        iwriter.addDocument(doc2);
        iwriter.addDocument(doc3);

        iwriter.close();
    }
}
