/*
 * GUIProjektGrupp13View.java
 */
package Main;

import Views.listOrderDetails.ListOrderDetailsView.ListOrderType;
import java.awt.CardLayout;
import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import javax.swing.JDialog;
import javax.swing.JFrame;
import se.chalmers.ait.dat215.project.Product;

/**
 * The application's main frame.
 */
public class MainView extends FrameView {

    public MainView(SingleFrameApplication app) {
        super(app);
        
        
        initComponents();
        MainController.INSTANCE.setView(this);
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = MainApp.getApplication().getMainFrame();
            aboutBox = new MainAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        MainApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        mainCard = new javax.swing.JPanel();
        headerBar = new Views.HeaderBar.HeaderBarView();
        jSplitPane1 = new javax.swing.JSplitPane();
        categoriesPanel = new Views.Categories.CategoriesView();
        centerCardContainer = new javax.swing.JPanel();
        mainPanel1 = new Views.StartPage.MainPanel();
        listOrderDetailsView1 = new Views.listOrderDetails.ListOrderDetailsView();
        searchResultsView1 = new Views.SearchResults.SearchResultsView();
        detailedProductView1 = new Views.DetailedProduct.DetailedProductView();
        shoppingCart = new Views.ShoppingCart.ShoppingCartView();
        checkoutCard = new javax.swing.JPanel();
        cardLayoutCheckoutView1 = new Views.Checkout.CardLayoutCheckoutView();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        showPrevOrdersMenuItem = new javax.swing.JMenuItem();
        showShoppingListsMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        showAccSettingsMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getResourceMap(MainView.class);
        mainPanel.setBackground(resourceMap.getColor("mainPanel.background")); // NOI18N
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.CardLayout());

        mainCard.setBackground(resourceMap.getColor("mainCard.background")); // NOI18N
        mainCard.setName("mainCard"); // NOI18N
        mainCard.setOpaque(false);

        headerBar.setName("headerBar"); // NOI18N

        jSplitPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSplitPane1.setName("jSplitPane1"); // NOI18N
        jSplitPane1.setOpaque(false);

        categoriesPanel.setName("categoriesPanel"); // NOI18N
        jSplitPane1.setLeftComponent(categoriesPanel);

        centerCardContainer.setName("centerCardContainer"); // NOI18N
        centerCardContainer.setOpaque(false);
        centerCardContainer.setLayout(new java.awt.CardLayout());

        mainPanel1.setName("mainPanel1"); // NOI18N
        centerCardContainer.add(mainPanel1, "start");

        listOrderDetailsView1.setName("listOrderDetailsView1"); // NOI18N
        centerCardContainer.add(listOrderDetailsView1, "listorderdetail");

        searchResultsView1.setName("searchResultsView1"); // NOI18N
        centerCardContainer.add(searchResultsView1, "searchresults");

        detailedProductView1.setName("detailedProductView1"); // NOI18N
        centerCardContainer.add(detailedProductView1, "productDetails");

        jSplitPane1.setRightComponent(centerCardContainer);

        shoppingCart.setMaximumSize(new java.awt.Dimension(284, 20000));
        shoppingCart.setName("shoppingCart"); // NOI18N

        javax.swing.GroupLayout mainCardLayout = new javax.swing.GroupLayout(mainCard);
        mainCard.setLayout(mainCardLayout);
        mainCardLayout.setHorizontalGroup(
            mainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                    .addComponent(headerBar, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shoppingCart, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        mainCardLayout.setVerticalGroup(
            mainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shoppingCart, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                    .addGroup(mainCardLayout.createSequentialGroup()
                        .addComponent(headerBar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mainPanel.add(mainCard, "main");

        checkoutCard.setName("checkoutCard"); // NOI18N
        checkoutCard.setOpaque(false);
        checkoutCard.setLayout(new javax.swing.BoxLayout(checkoutCard, javax.swing.BoxLayout.LINE_AXIS));

        cardLayoutCheckoutView1.setName("cardLayoutCheckoutView1"); // NOI18N
        checkoutCard.add(cardLayoutCheckoutView1);

        mainPanel.add(checkoutCard, "checkout");

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setMnemonic('A');
        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setToolTipText(resourceMap.getString("fileMenu.toolTipText")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getActionMap(MainView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setToolTipText(resourceMap.getString("exitMenuItem.toolTipText")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jMenu1.setMnemonic('K');
        jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N

        showPrevOrdersMenuItem.setMnemonic('T');
        showPrevOrdersMenuItem.setText(resourceMap.getString("showPrevOrdersMenuItem.text")); // NOI18N
        showPrevOrdersMenuItem.setToolTipText(resourceMap.getString("showPrevOrdersMenuItem.toolTipText")); // NOI18N
        showPrevOrdersMenuItem.setName("showPrevOrdersMenuItem"); // NOI18N
        showPrevOrdersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPrevOrdersMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(showPrevOrdersMenuItem);

        showShoppingListsMenuItem.setMnemonic('I');
        showShoppingListsMenuItem.setText(resourceMap.getString("showShoppingListsMenuItem.text")); // NOI18N
        showShoppingListsMenuItem.setToolTipText(resourceMap.getString("showShoppingListsMenuItem.toolTipText")); // NOI18N
        showShoppingListsMenuItem.setName("showShoppingListsMenuItem"); // NOI18N
        showShoppingListsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showShoppingListsMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(showShoppingListsMenuItem);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jMenu1.add(jSeparator1);

        showAccSettingsMenuItem.setMnemonic('K');
        showAccSettingsMenuItem.setText(resourceMap.getString("showAccSettingsMenuItem.text")); // NOI18N
        showAccSettingsMenuItem.setToolTipText(resourceMap.getString("showAccSettingsMenuItem.toolTipText")); // NOI18N
        showAccSettingsMenuItem.setName("showAccSettingsMenuItem"); // NOI18N
        showAccSettingsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAccSettingsMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(showAccSettingsMenuItem);

        menuBar.add(jMenu1);

        helpMenu.setMnemonic('H');
        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setToolTipText(resourceMap.getString("helpMenu.toolTipText")); // NOI18N
        helpMenu.setDoubleBuffered(true);
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setText(resourceMap.getString("aboutMenuItem.text")); // NOI18N
        aboutMenuItem.setToolTipText(resourceMap.getString("aboutMenuItem.toolTipText")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

private void showAccSettingsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAccSettingsMenuItemActionPerformed
    MainController.INSTANCE.showAccountSettingsPopup();
}//GEN-LAST:event_showAccSettingsMenuItemActionPerformed

private void showShoppingListsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showShoppingListsMenuItemActionPerformed
    MainController.INSTANCE.showShoppingLists();
}//GEN-LAST:event_showShoppingListsMenuItemActionPerformed

private void showPrevOrdersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPrevOrdersMenuItemActionPerformed
    MainController.INSTANCE.showOrders();
}//GEN-LAST:event_showPrevOrdersMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.Checkout.CardLayoutCheckoutView cardLayoutCheckoutView1;
    private Views.Categories.CategoriesView categoriesPanel;
    private javax.swing.JPanel centerCardContainer;
    private javax.swing.JPanel checkoutCard;
    private Views.DetailedProduct.DetailedProductView detailedProductView1;
    private Views.HeaderBar.HeaderBarView headerBar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private Views.listOrderDetails.ListOrderDetailsView listOrderDetailsView1;
    private javax.swing.JPanel mainCard;
    private javax.swing.JPanel mainPanel;
    private Views.StartPage.MainPanel mainPanel1;
    private javax.swing.JMenuBar menuBar;
    private Views.SearchResults.SearchResultsView searchResultsView1;
    private Views.ShoppingCart.ShoppingCartView shoppingCart;
    private javax.swing.JMenuItem showAccSettingsMenuItem;
    private javax.swing.JMenuItem showPrevOrdersMenuItem;
    private javax.swing.JMenuItem showShoppingListsMenuItem;
    // End of variables declaration//GEN-END:variables
    private JDialog aboutBox;

    // Protected to force usage of MainController
    
    protected void showMainPanel(){
        ((CardLayout)mainPanel.getLayout()).show(mainPanel, "main");
    }
    
    protected void showCheckoutPanel(){
        cardLayoutCheckoutView1.showFirstCard();
        ((CardLayout)mainPanel.getLayout()).show(mainPanel, "checkout");
    }
    
    protected void showListOrderDetailPanel(ListOrderType listOrderType) {
        ((CardLayout)centerCardContainer.getLayout()).show(centerCardContainer, "listorderdetail");
        listOrderDetailsView1.setListOrderType(listOrderType);
    }
    
    protected void showSearchResultsPanel() {
        ((CardLayout)centerCardContainer.getLayout()).show(centerCardContainer, "searchresults");
    }

    protected void setMenuItemsEnabled(boolean b) {
        showAccSettingsMenuItem.setEnabled(b);
        showPrevOrdersMenuItem.setEnabled(b);
        showShoppingListsMenuItem.setEnabled(b);
    }

    protected void showStartPanel() {
        ((CardLayout)centerCardContainer.getLayout()).show(centerCardContainer, "start");
    }

    protected void showDetailedProductPanel(Product p) {
        detailedProductView1.setProduct(p);
        ((CardLayout)centerCardContainer.getLayout()).show(centerCardContainer, "productDetails");
    }
}
