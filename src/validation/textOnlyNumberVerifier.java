/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Peter
 */
public class textOnlyNumberVerifier extends InputVerifier {

    private Pattern pattern = Pattern.compile("^[\\d\\s]+$");
    private Matcher matcher;
    private String placeholder;

    public textOnlyNumberVerifier(String placeholder) {
        this.placeholder = placeholder;
    }

    public textOnlyNumberVerifier() {
        this(null);
    }

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        matcher = pattern.matcher(text);
        return matcher.matches();
    }

    @Override
    public boolean shouldYieldFocus(JComponent input) {
        if (!verify(input)) {
            if (input instanceof JTextField && placeholder != null) {
                ((JTextField) input).setText(placeholder);
            }
        }
        return true;
    }
}
