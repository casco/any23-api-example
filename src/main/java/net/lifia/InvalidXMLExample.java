package net.lifia;

import net.lifia.validation.ItemscopeWithoutEqualsFix;
import net.lifia.validation.ItemscopeWithoutEqualsRule;
import org.apache.any23.extractor.ExtractionException;
import org.apache.any23.source.FileDocumentSource;
import org.apache.any23.validator.DefaultDOMDocument;
import org.apache.any23.validator.DefaultValidator;
import org.apache.any23.validator.Validator;
import org.apache.any23.validator.ValidatorException;
import org.apache.any23.writer.TripleHandlerException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by alejandrofernandez on 6/23/14.
 */
public class InvalidXMLExample extends Example {

    public static void main(String[] args) {
        InvalidXMLExample exa = new InvalidXMLExample();

        try {
            File file = new File("data/artery-microdata-faulty.html");
            //exa.validateAndFix(file);
            String n3 = exa.extract(new FileDocumentSource(file));
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

    /**
     * TODO: try to use this to fix the problem...
     * @param file
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws java.io.IOException
     * @throws org.xml.sax.SAXException
     * @throws org.apache.any23.validator.ValidatorException
     */
    public void validateAndFix(File file) throws ParserConfigurationException, IOException, SAXException, ValidatorException {

        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
        //The missing equals problems raises an exception in the parser.
        factory.setValidating(false);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(file);
        Validator validator = new DefaultValidator();
        validator.addRule(ItemscopeWithoutEqualsRule.class, ItemscopeWithoutEqualsFix.class);
        validator.validate(new DefaultDOMDocument(file.toURI(),doc), true);

    }
}
