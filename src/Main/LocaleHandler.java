package Main;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import se.chalmers.ait.dat215.project.ProductCategory;

/**
 * A singelton for handling localization of elements in the application. 
 * 
 * @author Peter
 */
public enum LocaleHandler {
    INSTANCE;
    
    public static final Map<ProductCategory, String> productCategoryNames = new EnumMap<ProductCategory, String>(ProductCategory.class);
    //<editor-fold defaultstate="collapsed" desc="Translation Map">
    static {
        productCategoryNames.put(ProductCategory.BERRY, "Bär");
        productCategoryNames.put(ProductCategory.BREAD, "Bröd");
        productCategoryNames.put(ProductCategory.CABBAGE, "Kål");
        productCategoryNames.put(ProductCategory.CITRUS_FRUIT, "Citrusfrukter");
        productCategoryNames.put(ProductCategory.COLD_DRINKS, "Kalla Drycker");
        productCategoryNames.put(ProductCategory.DAIRIES, "Mejeri");
        productCategoryNames.put(ProductCategory.EXOTIC_FRUIT, "Exotiska Frukter");
        productCategoryNames.put(ProductCategory.FISH, "Fisk");
        productCategoryNames.put(ProductCategory.FLOUR_SUGAR_SALT, "Mjöl/Socker/Salt");
        productCategoryNames.put(ProductCategory.FRUIT, "Stenfrukter");
        productCategoryNames.put(ProductCategory.HERB, "Örter");
        productCategoryNames.put(ProductCategory.HOT_DRINKS, "Varma Drycker");
        productCategoryNames.put(ProductCategory.MEAT, "Kött");
        productCategoryNames.put(ProductCategory.MELONS, "Meloner");
        productCategoryNames.put(ProductCategory.NUTS_AND_SEEDS, "Nötter & Frön");
        productCategoryNames.put(ProductCategory.PASTA, "Pasta");
        productCategoryNames.put(ProductCategory.POD, "Baljväxter");
        productCategoryNames.put(ProductCategory.POTATO_RICE, "Potatis & Ris");
        productCategoryNames.put(ProductCategory.ROOT_VEGETABLE, "Rotfrukter");
        productCategoryNames.put(ProductCategory.SWEET, "Sötsaker");
        productCategoryNames.put(ProductCategory.VEGETABLE_FRUIT, "Grönsaksfrukter");
    }
    //</editor-fold>
    
    /**
     * Gets the localized name of a ProductCategory 
     * 
     * @param pc
     * @return 
     */
    public String getProductCategoryName(ProductCategory pc) {
        String name = productCategoryNames.get(pc);
        if(name == null){
            return pc.toString();
        } else {
            return name;
        }
    }
}
