/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ListOrderDetailsView.java
 *
 * Created on Feb 28, 2013, 7:16:25 PM
 */
package Views.listOrderDetails;

import ShoppingList.ShoppingListChangeListener;
import ShoppingList.ShoppingListsHandler;

/**
 *
 * @author Peter
 */
public class ListOrderDetailsView extends javax.swing.JPanel implements ShoppingListChangeListener {

    /** Creates new form ListOrderDetailsView */
    public ListOrderDetailsView() {
        initComponents();
        ShoppingListsHandler.INSTANCE.addChangeListener(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        detailsContainer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemList = new javax.swing.JList();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getResourceMap(ListOrderDetailsView.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N
        setOpaque(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jSplitPane1.setBackground(resourceMap.getColor("jSplitPane1.background")); // NOI18N
        jSplitPane1.setName("jSplitPane1"); // NOI18N
        jSplitPane1.setOpaque(false);

        detailsContainer.setName("detailsContainer"); // NOI18N
        detailsContainer.setOpaque(false);
        detailsContainer.setLayout(new javax.swing.BoxLayout(detailsContainer, javax.swing.BoxLayout.PAGE_AXIS));
        jSplitPane1.setRightComponent(detailsContainer);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        itemList.setFont(resourceMap.getFont("itemList.font")); // NOI18N
        itemList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        itemList.setFixedCellHeight(48);
        itemList.setName("itemList"); // NOI18N
        itemList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                itemListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(itemList);

        jSplitPane1.setLeftComponent(jScrollPane1);

        add(jSplitPane1);
    }// </editor-fold>//GEN-END:initComponents

private void itemListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_itemListValueChanged
    System.out.println(itemList.getSelectedValue());
}//GEN-LAST:event_itemListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel detailsContainer;
    private javax.swing.JList itemList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables

    public void onChange() {
        System.out.println("ListOrderView: Shopping lists changed");
    }

}
