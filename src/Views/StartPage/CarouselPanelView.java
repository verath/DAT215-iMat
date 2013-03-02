/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * karusellPanel.java
 *
 * Created on Feb 24, 2013, 1:31:51 AM
 */
package Views.StartPage;

import java.util.LinkedList;
import java.util.List;
import javax.swing.Box.Filler;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author Ernst
 */
public class CarouselPanelView extends javax.swing.JPanel {
    
    //Saves a copy of the favourite list
    private static List<Product> favorites = new LinkedList<Product>(IMatDataHandler.getInstance().favorites());
    //Saves a copy of the product list
    private static List<Product> products = new LinkedList<Product>(IMatDataHandler.getInstance().getProducts());
    //Keeps track of when to change an ItemViewPanels colour
    private static boolean changeNextColour = true;
    //Keeps track of which set of the carousel ItemViewPanels currently in view
    private static int carouselNbr = 0;
    
    //A list consisting of (12) random favourite items and/or random products in store
    //depending if there are enough (up to 12) favourites in the list.
    private List<FeatureItemView> featureItemList = new LinkedList<FeatureItemView>();

    /** Creates new form karusellPanel */
    public CarouselPanelView() {
        initComponents();
        
        placeFeatureItems();
        
        resetList();
    }

    //Restores FeatureItemsViews deleted in placeFeatureItems()
    public void resetList(){
        favorites = new LinkedList<Product>(IMatDataHandler.getInstance().favorites());
        products = new LinkedList<Product>(IMatDataHandler.getInstance().getProducts());
    }
    
    
    //Randomizes products to the itemFeatureList as well as adding 4 FeatureItemViews
    //to the carouselPanel. Also deletes all added products to prevent duplicates.
    private void placeFeatureItems(){
        if(IMatDataHandler.getInstance().favorites() != null){
            
            if(favorites.size() < 12){
               
               for(int i = 0; i < favorites.size(); i++){
                   FeatureItemView panel = new FeatureItemView();
                   panel.setProduct(favorites.get(i));
                   if(changeNextColour){
                       panel.changeColour();
                   }
                   changeNextColour = !changeNextColour;
                   karusellPanel.add(panel);
                   featureItemList.add(panel);
               }
               for(int i = 0; i < 12 - favorites.size(); i++){
                   int rand = (int) (products.size()*Math.random());
                   FeatureItemView panel = new FeatureItemView();
                   panel.setProduct(products.get(rand));
                   products.remove(rand);
                   if(changeNextColour){
                       panel.changeColour();
                   }
                   changeNextColour = !changeNextColour;
                   if(i < 4 - favorites.size()){
                       karusellPanel.add(panel);
                   }
                   featureItemList.add(panel);
               }
            }else{
                for(int i = 0; i < 12; i++){
                   int rand = (int) (favorites.size()*Math.random());
                   FeatureItemView panel = new FeatureItemView();
                   panel.setProduct(favorites.get(rand));
                   favorites.remove(rand);
                   if(changeNextColour){
                       panel.changeColour();
                   }
                   changeNextColour = !changeNextColour;
                   if(i < 4){
                       karusellPanel.add(panel);
                   }
                   featureItemList.add(panel);
               }
            }
        }else{
            
            for(int i = 0; i < 12; i++){
                int rand = (int) (products.size()*Math.random());
                FeatureItemView panel = new FeatureItemView();
                panel.setProduct(products.get(rand));
                products.remove(rand);
                if(changeNextColour){
                       panel.changeColour();
                }
                changeNextColour = !changeNextColour;
                if(i < 4){
                    karusellPanel.add(panel);
                }
                featureItemList.add(panel);
            }
        }
        changeNextColour = !changeNextColour;
    } //underbar indentering osv
    
   //Switches between three different positions using the featureItemList,
   //Panels 1-4,5-8 and 9-12 replace eachother on the CarouselView 
   //when pressing the previous/next buttons.
   public void nextButtonPressed(){
        karusellPanel.removeAll();
        karusellPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        carouselNbr = (carouselNbr + 1)%3;
        for(int i = 0; i < 4; i++){
            karusellPanel.add(featureItemList.get(i+4*carouselNbr));
        }
        karusellPanel.validate();
        karusellPanel.repaint();
    }
    
    public void previousButtonPressed(){
        karusellPanel.removeAll();
        karusellPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        carouselNbr = (carouselNbr - 1)%3;
        for(int i = 0; i < 4; i++){
            karusellPanel.add(featureItemList.get(i+4*carouselNbr));
        }
        karusellPanel.validate();
        karusellPanel.repaint();
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        karusellPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(247, 221, 192));
        setPreferredSize(new java.awt.Dimension(750, 190));
        setLayout(new java.awt.BorderLayout());

        karusellPanel.setBackground(new java.awt.Color(255, 246, 241));
        karusellPanel.setMaximumSize(new java.awt.Dimension(750, 190));
        karusellPanel.setPreferredSize(new java.awt.Dimension(750, 190));
        karusellPanel.setLayout(new javax.swing.BoxLayout(karusellPanel, javax.swing.BoxLayout.X_AXIS));
        add(karusellPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel karusellPanel;
    // End of variables declaration//GEN-END:variables
}
