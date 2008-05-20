package br.com.caelum.stella.validation;

import static br.com.caelum.stella.validation.NITConstraints.NIT_FORMATED;
import static br.com.caelum.stella.validation.NITConstraints.NIT_UNFORMATED;

import java.util.regex.Matcher;

/**
 * @author Leonardo Bessa
 * 
 */
public class NITFormatter implements Formatter {

    public String format(String value) {
        String result = null;
        if (value != null) {
            Matcher matcher = NIT_UNFORMATED.matcher(value);
            if (matcher.matches()) {
                result = matcher.replaceAll("$1.$2.$3-$4");
            }
        } else {
            throw new IllegalArgumentException();
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.caelum.stella.conversion.Formatter#unformat(java.lang.String)
     */
    public String unformat(String value) {
        String result = null;
        if (value != null) {
            Matcher matcher = NIT_FORMATED.matcher(value);
            if (matcher.matches()) {
                result = matcher.replaceAll("$1$2$3$4");
            }
        } else {
            throw new IllegalArgumentException();
        }
        return result;
    }

}