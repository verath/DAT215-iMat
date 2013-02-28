/*
 * GUIProjektGrupp13App.java
 */
package Main;

import ShoppingList.ShoppingList;
import ShoppingList.ShoppingListsHandler;
import java.util.EventObject;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import se.chalmers.ait.dat215.project.IMatDataHandler;

/**
 * The main class of the application.
 */
public class MainApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup() {
        show(new MainView(this));        
        // Handle exit
        this.addExitListener(new ExitListener() {
            
            public boolean canExit(EventObject event) {
                return true;
            }
            
            public void willExit(EventObject event) {
                IMatDataHandler.getInstance().shutDown();
                ShoppingListsHandler.INSTANCE.save();
            }
        });
        
        
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override
    protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of GUIProjektGrupp13App
     */
    public static MainApp getApplication() {
        return Application.getInstance(MainApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(MainApp.class, args);
    }
}
