package net.lifia;

import org.apache.any23.Any23;
import org.apache.any23.extractor.ExtractionException;
import org.apache.any23.http.HTTPClient;
import org.apache.any23.source.DocumentSource;
import org.apache.any23.source.FileDocumentSource;
import org.apache.any23.source.HTTPDocumentSource;
import org.apache.any23.writer.NTriplesWriter;
import org.apache.any23.writer.TripleHandler;
import org.apache.any23.writer.TripleHandlerException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by alejandrofernandez on 6/23/14.
 */
public class Example {
    public static void main(String[] args) {
        try {
            exampleOkMicrodata();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ExtractionException e) {
            e.printStackTrace();
        } catch (TripleHandlerException e) {
            e.printStackTrace();
        }

    }


    /**
     * Basic data extraction is documented in this page: https://any23.apache.org/dev-data-extraction.html
     * @throws IOException
     * @throws URISyntaxException
     * @throws ExtractionException
     * @throws TripleHandlerException
     */
    private static void exampleOkMicrodata() throws IOException, URISyntaxException, ExtractionException, TripleHandlerException {
        Any23 runner = new Any23();
        DocumentSource source = new FileDocumentSource(new File("data/artery-microdata-ok.html"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        TripleHandler handler = new NTriplesWriter(out);
        try {
            runner.extract(source, handler);
        } finally {
            handler.close();
        }
        String n3 = out.toString("UTF-8");
        System.out.println(n3);
    }

    /**
     *
     * @throws IOException
     * @throws URISyntaxException
     * @throws ExtractionException
     * @throws TripleHandlerException
     */
    private static void exampleFaultyMicrodata() throws IOException, URISyntaxException, ExtractionException, TripleHandlerException {
        Any23 runner = new Any23();
        DocumentSource source = new FileDocumentSource(new File("data/artery-microdata-faulty.html"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        TripleHandler handler = new NTriplesWriter(out);
        try {
            runner.extract(source, handler);
        } finally {
            handler.close();
        }
        String n3 = out.toString("UTF-8");
        System.out.println(n3);
    }
}
