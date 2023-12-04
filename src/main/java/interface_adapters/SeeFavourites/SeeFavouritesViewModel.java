package interface_adapters.SeeFavourites;

import interface_adapters.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SeeFavouritesViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Articles";
    public static final String EXIT_BUTTON_LABEL = "EXIT";
    private SeeFavouritesState state = new SeeFavouritesState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SeeFavouritesViewModel() {
        super("seeFavourites");
    }

    /**
     *
     * @return
     */
    public SeeFavouritesState getState() {
        return state;
    }

    /**
     *
     * @param seeFavouritesState
     */
    public void setState(SeeFavouritesState seeFavouritesState) {
        this.state = seeFavouritesState;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("seeFavouritesState", null, this.state);
    }

    /**
     *
     * @param listener
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
