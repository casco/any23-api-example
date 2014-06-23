package net.lifia;

import net.lifia.validation.ItemscopeWithoutEqualsFix;
import net.lifia.validation.ItemscopeWithoutEqualsRule;
import org.apache.any23.Any23;
import org.apache.any23.extractor.ExtractionException;
import org.apache.any23.source.DocumentSource;
import org.apache.any23.source.FileDocumentSource;
import org.apache.any23.validator.DefaultDOMDocument;
import org.apache.any23.validator.DefaultValidator;
import org.apache.any23.validator.Validator;
import org.apache.any23.validator.ValidatorException;
import org.apache.any23.writer.NTriplesWriter;
import org.apache.any23.writer.TripleHandler;
import org.apache.any23.writer.TripleHandlerException;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by alejandrofernandez on 6/23/14.
 */
public abstract class Example {


    /**
     * Basic data extraction is documented in this page: https://any23.apache.org/dev-data-extraction.html
     *
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     * @throws org.apache.any23.extractor.ExtractionException
     * @throws org.apache.any23.writer.TripleHandlerException
     */
    public String extract(DocumentSource source) throws IOException, URISyntaxException, ExtractionException, TripleHandlerException {
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



}
