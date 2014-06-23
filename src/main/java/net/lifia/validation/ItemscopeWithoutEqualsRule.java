package net.lifia.validation;

import org.apache.any23.validator.DOMDocument;
import org.apache.any23.validator.Rule;
import org.apache.any23.validator.RuleContext;
import org.apache.any23.validator.ValidationReportBuilder;
import org.w3c.dom.Node;

import java.util.List;

/**
 * Created by alejandrofernandez on 6/23/14.
 */
public class ItemscopeWithoutEqualsRule implements Rule {
    @Override
    public String getHRName() {
        return "missing-equals-for-itemscope-rule";
    }

    @Override
    public boolean applyOn(DOMDocument document, RuleContext context, ValidationReportBuilder validationReportBuilder) {
        List<Node> itemScopes = document.getNodes("//@itemscope");
        boolean foundPrecondition = false;
        for (Node itemScope : itemScopes) {

            if( itemScope != null) {
                foundPrecondition = true;
                System.out.println(itemScope.toString());
                break;
            }
        }
        return false;
    }
}
