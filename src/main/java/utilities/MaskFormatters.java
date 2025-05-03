package utilities;

import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import java.text.ParseException;

/**
 * Utility class to provide common input masks for form fields
 */
public class MaskFormatters {
    
    /**
     * Applies CPF mask in format ###.###.###-##
     * @param field The field to apply the mask to
     */
    public static void cpfMask(JFormattedTextField field) {
        try {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.setPlaceholderCharacter('_');
            mask.install(field);
        } catch (ParseException ex) {
            handleMaskException("CPF", ex);
        }
    }
    
    /**
     * Applies date mask in format dd/MM/yyyy
     * @param field The field to apply the mask to
     */
    public static void dateMask(JFormattedTextField field) {
        try {
            MaskFormatter mask = new MaskFormatter("##/##/####");
            mask.setPlaceholderCharacter('_');
            mask.install(field);
        } catch (ParseException ex) {
            handleMaskException("Data", ex);
        }
    }
    
    /**
     * Applies phone mask in format (##) #####-####
     * @param field The field to apply the mask to
     */
    public static void phoneMask(JFormattedTextField field) {
        try {
            MaskFormatter mask = new MaskFormatter("(##) #####-####");
            mask.setPlaceholderCharacter('_');
            mask.install(field);
        } catch (ParseException ex) {
            handleMaskException("Telefone", ex);
        }
    }
    
    /**
     * Applies CEP mask in format #####-###
     * @param field The field to apply the mask to
     */
    public static void cepMask(JFormattedTextField field) {
        try {
            MaskFormatter mask = new MaskFormatter("#####-###");
            mask.setPlaceholderCharacter('_');
            mask.install(field);
        } catch (ParseException ex) {
            handleMaskException("CEP", ex);
        }
    }
    
    private static void handleMaskException(String maskType, ParseException ex) {
        System.err.println("Erro ao criar máscara para " + maskType + ": " + ex.getMessage());
        ex.printStackTrace();
    }
}
