package net.lifia;

import org.apache.any23.Any23;
import org.apache.any23.extractor.ExtractionException;
import org.apache.any23.source.DocumentSource;
import org.apache.any23.source.FileDocumentSource;
import org.apache.any23.validator.ValidatorException;
import org.apache.any23.writer.NTriplesWriter;
import org.apache.any23.writer.TripleHandler;
import org.apache.any23.writer.TripleHandlerException;
import org.xml.sax.SAXException;

import javax.print.DocFlavor;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by alejandrofernandez on 6/23/14.
 */
public class WellFormedFileExample extends Example {

    public static void main(String[] args) {
        WellFormedFileExample exa = new WellFormedFileExample();

        try {
            String n3 = exa.extract(new FileDocumentSource(new File("data/artery-microdata-ok.html")));
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
