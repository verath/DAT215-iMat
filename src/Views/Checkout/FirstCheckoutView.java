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

import Main.NumberUtil;
import Main.ShoppingCartWrapper;
import java.awt.CardLayout;
import java.util.List;
import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Philip
 */
public class FirstCheckoutView extends javax.swing.JPanel implements ShoppingCartListener{

    /** Creates new form FirstCheckoutView */
    public FirstCheckoutView() {
        initComponents();
        sumOfItems.setAsSumItem();
        CheckoutShoppingItem item1 = new CheckoutShoppingItem();
        ShoppingCartWrapper.INSTANCE.addShoppingCartListener(this);
    }
    
    public void addItemToItemsHolder( ShoppingItem si, boolean isEven){
        CheckoutShoppingItem cosi = new CheckoutShoppingItem();
        cosi.setCheckoutShoppingItem(si);
        cosi.setEvenItem(isEven);
        checkoutItemsHolder.add(cosi);
    }
    
    private void clearCheckoutView(){
        checkoutItemsHolder.removeAll();
    }
    
    public void setItemsInCheckoutView( List<ShoppingItem> items ){
        if( items == null ) return;
        
        clearCheckoutView();
        
        int i=0;
        for(ShoppingItem si : items){
            addItemToItemsHolder(si, (i%2 == 0));
            i++;
        }
        
        sumOfItems.setPriceLabelOnSumItem(NumberUtil.roundTwoDecimals(ShoppingCartWrapper.INSTANCE.getTotal()));

        checkoutItemsHolder.validate();
        checkoutItemsHolder.repaint();
           
    }
    
    public void updateTotalPriceCheckoutView () {
        sumOfItems.setPriceLabelOnSumItem(NumberUtil.roundTwoDecimals(ShoppingCartWrapper.INSTANCE.getTotal()));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sumOfItems = new Views.Checkout.CheckoutShoppingItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        checkoutItemsHolder = new javax.swing.JPanel();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getResourceMap(FirstCheckoutView.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N

        sumOfItems.setName("sumOfItems"); // NOI18N
        sumOfItems.setOpaque(false);

        jScrollPane1.setBackground(resourceMap.getColor("jScrollPane1.background")); // NOI18N
        jScrollPane1.setBorder(null);
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        checkoutItemsHolder.setBackground(resourceMap.getColor("checkoutItemsHolder.background")); // NOI18N
        checkoutItemsHolder.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("checkoutItemsHolder.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("checkoutItemsHolder.border.titleFont"))); // NOI18N
        checkoutItemsHolder.setName("checkoutItemsHolder"); // NOI18N
        checkoutItemsHolder.setLayout(new javax.swing.BoxLayout(checkoutItemsHolder, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(checkoutItemsHolder);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 564, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(sumOfItems, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sumOfItems, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel checkoutItemsHolder;
    private javax.swing.JScrollPane jScrollPane1;
    private Views.Checkout.CheckoutShoppingItem sumOfItems;
    // End of variables declaration//GEN-END:variables

    /**
     * Listen for changes to the shopping cart and update total
     * @param ce 
     */
    public void shoppingCartChanged(CartEvent ce) {
        setItemsInCheckoutView(ShoppingCartWrapper.INSTANCE.getItems());
        updateTotalPriceCheckoutView();
    }
}
