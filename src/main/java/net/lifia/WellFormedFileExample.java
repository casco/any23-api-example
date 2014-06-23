package net.lifia;

import org.apache.any23.Any23;
import org.apache.any23.extractor.ExtractionException;
import org.apache.any23.source.DocumentSource;
import org.apache.any23.source.FileDocumentSource;
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
public class WellFormedFileExample {

    /**
     * Basic data extraction is documented in this page: https://any23.apache.org/dev-data-extraction.html
     *
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     * @throws org.apache.any23.extractor.ExtractionException
     * @throws org.apache.any23.writer.TripleHandlerException
     */
    public String extract() throws IOException, URISyntaxException, ExtractionException, TripleHandlerException {
        DocumentSource source = new FileDocumentSource(new File("data/artery-microdata-ok.html"));
        Any23 runner = new Any23();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        TripleHandler handler = new NTriplesWriter(out);
        try {
            runner.extract(source, handler);
        } finally {
            handler.close();
        }
        String n3 = out.toString("UTF-8");
        return n3;
    }

    public static void main(String[] args) {
        WellFormedFileExample exa = new WellFormedFileExample();

        try {
            String n3 = exa.extract();
            System.out.println(n3);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExtractionException e) {
            e.printStackTrace();
        } catch (TripleHandlerException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
