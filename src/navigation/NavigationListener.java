package navigation;

/**
 * An interface implemented by classes listening for navigation events.
 * 
 * @author Peter
 */
public interface NavigationListener {
    public void onNavigate(NavigationEvent navEvent);
}
