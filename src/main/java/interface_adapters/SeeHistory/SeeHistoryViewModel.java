package interface_adapters.SeeHistory;

import interface_adapters.SeeFavourites.SeeFavouritesState;
import interface_adapters.ViewModel;

import javax.swing.text.View;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SeeHistoryViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Articles";
    public static final String EXIT_BUTTON_LABEL = "EXIT";
    private SeeHistoryState state = new SeeHistoryState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SeeHistoryViewModel() {
        super("seeHistory");
    }

    /**
     *
     * @return
     */
    public SeeHistoryState getState() {
        return state;
    }

    /**
     *
     * @param seeHistoryState
     */
    public void setState(SeeHistoryState seeHistoryState) {
        this.state = seeHistoryState;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("seeHistoryState", null, this.state);
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
