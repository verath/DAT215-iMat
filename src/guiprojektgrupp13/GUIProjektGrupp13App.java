/*
 * GUIProjektGrupp13App.java
 */

package guiprojektgrupp13;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class GUIProjektGrupp13App extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new GUIProjektGrupp13View(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of GUIProjektGrupp13App
     */
    public static GUIProjektGrupp13App getApplication() {
        return Application.getInstance(GUIProjektGrupp13App.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(GUIProjektGrupp13App.class, args);
    }
}
