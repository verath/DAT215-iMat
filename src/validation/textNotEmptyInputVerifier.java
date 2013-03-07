package validation;

import java.awt.Toolkit;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Peter
 */
public class textNotEmptyInputVerifier extends InputVerifier {

    private String placeholder;
    
    public textNotEmptyInputVerifier(String placeholder){
        this.placeholder = placeholder;
    }
    public textNotEmptyInputVerifier(){
        this(null);
    }

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        return !text.isEmpty();
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
