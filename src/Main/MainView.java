/*
 * GUIProjektGrupp13View.java
 */
package Main;

import java.awt.CardLayout;
import java.awt.LayoutManager;
import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * The application's main frame.
 */
public class MainView extends FrameView {

    public MainView(SingleFrameApplication app) {
        super(app);

        initComponents();

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
        searchResultsView1 = new Views.SearchResults.SearchResultsView();
        listOrderDetailsView1 = new Views.listOrderDetails.ListOrderDetailsView();
        detailedProductView1 = new Views.DetailedProduct.DetailedProductView();
        shoppingCart = new Views.ShoppingCart.ShoppingCartView();
        checkoutCard = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
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

        searchResultsView1.setName("searchResultsView1"); // NOI18N
        centerCardContainer.add(searchResultsView1, "card3");

        listOrderDetailsView1.setName("listOrderDetailsView1"); // NOI18N
        centerCardContainer.add(listOrderDetailsView1, "card4");

        detailedProductView1.setName("detailedProductView1"); // NOI18N
        centerCardContainer.add(detailedProductView1, "card4");

        jSplitPane1.setRightComponent(centerCardContainer);

        shoppingCart.setName("shoppingCart"); // NOI18N

        javax.swing.GroupLayout mainCardLayout = new javax.swing.GroupLayout(mainCard);
        mainCard.setLayout(mainCardLayout);
        mainCardLayout.setHorizontalGroup(
            mainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                    .addComponent(headerBar, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shoppingCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        mainCardLayout.setVerticalGroup(
            mainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shoppingCart, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                    .addGroup(mainCardLayout.createSequentialGroup()
                        .addComponent(headerBar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mainPanel.add(mainCard, "main");

        checkoutCard.setName("checkoutCard"); // NOI18N
        checkoutCard.setOpaque(false);

        javax.swing.GroupLayout checkoutCardLayout = new javax.swing.GroupLayout(checkoutCard);
        checkoutCard.setLayout(checkoutCardLayout);
        checkoutCardLayout.setHorizontalGroup(
            checkoutCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1232, Short.MAX_VALUE)
        );
        checkoutCardLayout.setVerticalGroup(
            checkoutCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );

        mainPanel.add(checkoutCard, "card3");

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getActionMap(MainView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N

        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenu1.add(jMenuItem2);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jMenu1.add(jSeparator1);

        showAccSettingsMenuItem.setText(resourceMap.getString("showAccSettingsMenuItem.text")); // NOI18N
        showAccSettingsMenuItem.setName("showAccSettingsMenuItem"); // NOI18N
        showAccSettingsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAccSettingsMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(showAccSettingsMenuItem);

        menuBar.add(jMenu1);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

private void showAccSettingsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAccSettingsMenuItemActionPerformed
    MainController.INSTANCE.showAccountSettingsPopup();
}//GEN-LAST:event_showAccSettingsMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.Categories.CategoriesView categoriesPanel;
    private javax.swing.JPanel centerCardContainer;
    private javax.swing.JPanel checkoutCard;
    private Views.DetailedProduct.DetailedProductView detailedProductView1;
    private Views.HeaderBar.HeaderBarView headerBar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private Views.listOrderDetails.ListOrderDetailsView listOrderDetailsView1;
    private javax.swing.JPanel mainCard;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private Views.SearchResults.SearchResultsView searchResultsView1;
    private Views.ShoppingCart.ShoppingCartView shoppingCart;
    private javax.swing.JMenuItem showAccSettingsMenuItem;
    // End of variables declaration//GEN-END:variables
    private JDialog aboutBox;
}
