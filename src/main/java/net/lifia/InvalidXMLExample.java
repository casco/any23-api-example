package net.lifia;

import org.apache.any23.Any23;
import org.apache.any23.extractor.ExtractionException;
import org.apache.any23.source.StringDocumentSource;
import org.apache.any23.validator.ValidatorException;
import org.apache.any23.writer.NTriplesWriter;
import org.apache.any23.writer.TripleHandler;
import org.apache.any23.writer.TripleHandlerException;
import org.jsoup.Jsoup;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by alejandrofernandez on 6/23/14.
 */
public class InvalidXMLExample {

    public String extract() throws IOException, URISyntaxException, ExtractionException, TripleHandlerException,
            SAXException, ParserConfigurationException, ValidatorException {

        //If I don't use JSoup it will not work due to malformed html (missing ="" in itemscope attributes)
        String fixedContent = Jsoup.parse(new File("data/artery-microdata-faulty.html"),
                "UTF-8", "http://example.com/").outerHtml();

        Any23 runner = new Any23();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        TripleHandler handler = new NTriplesWriter(out);
        StringDocumentSource documentSource = new StringDocumentSource(fixedContent, "http://example.com/");
        try {
            runner.extract(documentSource, handler);
        } finally {
            handler.close();
        }
        String n3 = out.toString("UTF-8");
        return n3;
    }

    public static void main(String[] args) {
        InvalidXMLExample exa = new InvalidXMLExample();

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
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }

}
