package org.example.utils;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;

import java.io.IOException;
import java.util.List;

public class DocsUtils {
    public void writeDocs(Analyzer analyzer, Directory directory, String name, List<String> docs) throws IOException {
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);

        docs.stream()
                .forEach(d -> {
                    Document doc = new Document();
                    doc.add(new TextField(name, d, Field.Store.YES));
                    try {
                        iwriter.addDocument(doc);
                    } catch (IOException ioException) {
                        System.out.println(ioException.getMessage());
                    }
                });

        iwriter.close();
    }

    public void writeDocs(Analyzer analyzer, Directory directory, String name, String document) throws Exception {
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter iwriter = new IndexWriter(directory, config);

        Document doc = new Document();
        doc.add(new TextField(name, document, Field.Store.YES));

        iwriter.addDocument(doc);

        iwriter.close();
    }
}
