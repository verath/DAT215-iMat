
/*
 * CategoriesView.java
 *
 * Created on Feb 25, 2013, 9:44:55 AM
 */
package Views.Categories;

import Main.MainController;
import navigation.NavigationListener;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JSeparator;
import navigation.NavigationEvent;
import navigation.NavigationSearchEvent;
import navigation.NavigationShoppingListsEvent;
import se.chalmers.ait.dat215.project.ProductCategory;

/**
 *
 * @author Peter
 */
public class CategoriesView extends javax.swing.JPanel implements NavigationListener {

    /**
     * A map, mapping a "human readable" string to one or more categories.
     */
    public static final Map<String, Set<ProductCategory>> categoryItemProducts = new HashMap<String, Set<ProductCategory>>();
    //<editor-fold defaultstate="collapsed" desc="Mapping of name -> Category">

    static {
        Set<ProductCategory> prodCategories;
        // Frukt & Grönt
        prodCategories = new HashSet<ProductCategory>();
        prodCategories.add(ProductCategory.ROOT_VEGETABLE);
        prodCategories.add(ProductCategory.POD);
        prodCategories.add(ProductCategory.CABBAGE);
        prodCategories.add(ProductCategory.VEGETABLE_FRUIT);
        categoryItemProducts.put("Grönsaker", prodCategories);

        // Kött
        prodCategories = new HashSet<ProductCategory>();
        prodCategories.add(ProductCategory.MEAT);
        prodCategories.add(ProductCategory.FISH);
        categoryItemProducts.put("Kött", prodCategories);

        //Mejeriproduktrer
        prodCategories = new HashSet<ProductCategory>();
        prodCategories.add(ProductCategory.DAIRIES);
        categoryItemProducts.put("Mejeriprodukter", prodCategories);

        //Skafferi
        prodCategories = new HashSet<ProductCategory>();
        prodCategories.add(ProductCategory.FLOUR_SUGAR_SALT);
        prodCategories.add(ProductCategory.PASTA);
        prodCategories.add(ProductCategory.POTATO_RICE);
        categoryItemProducts.put("Skafferi", prodCategories);

        //Nötter & Örter
        prodCategories = new HashSet<ProductCategory>();
        prodCategories.add(ProductCategory.HERB);
        prodCategories.add(ProductCategory.NUTS_AND_SEEDS);
        categoryItemProducts.put("Nötter & Örter", prodCategories);

        //Sötsaker
        prodCategories = new HashSet<ProductCategory>();
        prodCategories.add(ProductCategory.SWEET);
        categoryItemProducts.put("Sötsaker", prodCategories);

        //Bröd
        prodCategories = new HashSet<ProductCategory>();
        prodCategories.add(ProductCategory.BREAD);
        categoryItemProducts.put("Bröd", prodCategories);

        //Dryck
        prodCategories = new HashSet<ProductCategory>();
        prodCategories.add(ProductCategory.COLD_DRINKS);
        prodCategories.add(ProductCategory.HOT_DRINKS);
        categoryItemProducts.put("Drycker", prodCategories);

        //Frukt & Bär
        prodCategories = new HashSet<ProductCategory>();
        prodCategories.add(ProductCategory.BERRY);
        prodCategories.add(ProductCategory.EXOTIC_FRUIT);
        prodCategories.add(ProductCategory.CITRUS_FRUIT);
        prodCategories.add(ProductCategory.MELONS);
        prodCategories.add(ProductCategory.FRUIT);
        categoryItemProducts.put("Frukt & Bär", prodCategories);
    }
    //</editor-fold>
    private List<CategoryItemView> categoryViews = new ArrayList<CategoryItemView>(10);

    /** Creates new form CategoriesView */
    public CategoriesView() {
        initComponents();

        MainController.INSTANCE.addNavigationListener(this);

        // Add the categories
        for (String name : categoryItemProducts.keySet()) {
            Set<ProductCategory> productCategories = categoryItemProducts.get(name);
            CategoryItemView civ = new CategoryItemView();
            civ.setCategoryName(name);
            civ.setSearchCategories(productCategories);
            add(civ);
            categoryViews.add(civ);
        }

        JSeparator seperator = new JSeparator(JSeparator.HORIZONTAL);
        seperator.setPreferredSize(new Dimension(100, 1));
        seperator.setMinimumSize(new Dimension(10, 1));
        seperator.setMaximumSize(new Dimension(10000, 1));
        add(seperator);


        // Show a special label for favorites
        CategoryItemView civ = new CategoryItemView();
        civ.setCategoryName("Favoriter");
        civ.setIsFavoriteLabel(true);
        add(civ);
        categoryViews.add(civ);

        // Show a special label for shoppinglists
        CategoryItemView sliv = new CategoryItemView();
        sliv.setCategoryName("Inköpslistor");
        sliv.setIsShoppingListLabel(true);
        add(sliv);
        categoryViews.add(sliv);

        validate();
        repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getResourceMap(CategoriesView.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    /**
     * Called by the controller when a search occurs.
     * Forward event to all CategoryItemView.
     * @param NavigationEvent The type of navigation event that occurred. 
     */
    public void onNavigate(NavigationEvent NavEvent) {
        if (NavEvent instanceof NavigationSearchEvent) {
            NavigationSearchEvent ev = (NavigationSearchEvent) NavEvent;
            for (CategoryItemView civ : categoryViews) {
                civ.onSearchChange(ev.getSearchQuery());
            }
        } else if (NavEvent instanceof NavigationShoppingListsEvent) {
            NavigationShoppingListsEvent ev = (NavigationShoppingListsEvent) NavEvent;
            for (CategoryItemView civ : categoryViews) {
                civ.onShoppingListShown();
            }
        } else {
            for (CategoryItemView civ : categoryViews) {
                civ.onOtherNavigation();
            }
        }
    }
}
