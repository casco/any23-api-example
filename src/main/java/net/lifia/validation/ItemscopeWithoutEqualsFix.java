package net.lifia.validation;

import org.apache.any23.validator.DOMDocument;
import org.apache.any23.validator.Fix;
import org.apache.any23.validator.Rule;
import org.apache.any23.validator.RuleContext;

/**
 * Created by alejandrofernandez on 6/23/14.
 */
public class ItemscopeWithoutEqualsFix implements Fix {
    @Override
    public String getHRName() {
        return "missing-equals-for-itemscope-fix";
    }

    @Override
    public void execute(Rule rule, RuleContext ruleContext, DOMDocument domDocument) {
        System.out.println(ruleContext);

    }
}

