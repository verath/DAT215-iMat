/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import se.chalmers.ait.dat215.project.ProductCategory;

/**
 *
 * @author Peter
 */
public enum LocaleHandler {
    INSTANCE;
    
    public static Map<ProductCategory, String> productCategoryNames = new EnumMap<ProductCategory, String>(ProductCategory.class);
    static {  
        Map<ProductCategory, String> temp = new EnumMap<ProductCategory, String>(ProductCategory.class);
        temp.put(ProductCategory.BERRY, "Bär");
        temp.put(ProductCategory.BREAD, "Bröd");
        temp.put(ProductCategory.CABBAGE, "Kål");
        temp.put(ProductCategory.CITRUS_FRUIT, "Citrusfrukter");
        temp.put(ProductCategory.COLD_DRINKS, "Kalla Drycker");
        temp.put(ProductCategory.DAIRIES, "Mejeri");
        temp.put(ProductCategory.EXOTIC_FRUIT, "Exotiska Frukter");
        temp.put(ProductCategory.FISH, "Fisk");
        temp.put(ProductCategory.FLOUR_SUGAR_SALT, "Mjöl");
        temp.put(ProductCategory.FRUIT, "Stenfrukter");
        temp.put(ProductCategory.HERB, "Örter");
        temp.put(ProductCategory.HOT_DRINKS, "Varma Drycker");
        temp.put(ProductCategory.MEAT, "Kött");
        temp.put(ProductCategory.MELONS, "Melloner");
        temp.put(ProductCategory.NUTS_AND_SEEDS, "Nötter & Frön");
        temp.put(ProductCategory.PASTA, "Pasta");
        temp.put(ProductCategory.POD, "Baljväxter");
        temp.put(ProductCategory.POTATO_RICE, "Potatis & Ris");
        temp.put(ProductCategory.ROOT_VEGETABLE, "Rotfrukter");
        temp.put(ProductCategory.SWEET, "Sött");
        temp.put(ProductCategory.VEGETABLE_FRUIT, "Grönsaksfrukter");
        productCategoryNames = Collections.unmodifiableMap(temp);
    }
    
    public String getProductCategoryName(ProductCategory pc) {
        String name = productCategoryNames.get(pc);
        if(name == null){
            return pc.toString();
        } else {
            return name;
        }
    }
}
