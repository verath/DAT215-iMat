/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FirstCheckoutView.java
 *
 * Created on Feb 27, 2013, 11:18:00 AM
 */
package Views.Checkout;

import java.awt.CardLayout;
import java.util.List;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Philip
 */
public class FirstCheckoutView extends javax.swing.JPanel {

    /** Creates new form FirstCheckoutView */
    public FirstCheckoutView() {
        initComponents();
        sumOfItems.setAsSumItem();
        CheckoutShoppingItem item1 = new CheckoutShoppingItem();
        //checkoutItemsHolder.add(item1);        
    }
    
    public void addItemToItemsHolder( ShoppingItem si){
        CheckoutShoppingItem cosi = new CheckoutShoppingItem();
        cosi.setCheckoutShoppingItem(si);
        checkoutItemsHolder.add(cosi);
    }
    
    private void clearCheckoutView(){
        checkoutItemsHolder.removeAll();
    }
    
    public void setItemsInCheckoutView( List<ShoppingItem> items ){
        if( items == null ) return;
        
        clearCheckoutView();
        
        for(ShoppingItem si : items){
            addItemToItemsHolder(si);
        }

        checkoutItemsHolder.validate();
        checkoutItemsHolder.repaint();
        
        //------------------------------------
        //Måste fixa så att totalsumman visas rätt
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkoutItemsHolder = new javax.swing.JPanel();
        sumOfItems = new Views.Checkout.CheckoutShoppingItem();

        checkoutItemsHolder.setName("checkoutItemsHolder"); // NOI18N
        checkoutItemsHolder.setLayout(new javax.swing.BoxLayout(checkoutItemsHolder, javax.swing.BoxLayout.Y_AXIS));

        sumOfItems.setName("sumOfItems"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, checkoutItemsHolder, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(sumOfItems, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(checkoutItemsHolder, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sumOfItems, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel checkoutItemsHolder;
    private Views.Checkout.CheckoutShoppingItem sumOfItems;
    // End of variables declaration//GEN-END:variables

}
