package interface_adapters.Map;

import interface_adapters.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MapViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Articles";
    public static final String EXIT_BUTTON_LABEL = "EXIT";
    private MapState state = new MapState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public MapViewModel() {
        super("map");
    }

    /** @param mapState */

    public void setState(MapState mapState) {this.state = mapState;}

    public MapState getState() {
        return state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("mapState", null, this.state);
    }

    /**@param listener */

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
