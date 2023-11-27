package interface_adapters.Search;

import interface_adapters.Map.MapState;
import interface_adapters.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Articles";
    public static final String EXIT_BUTTON_LABEL = "EXIT";
    private SearchState state = new SearchState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SearchViewModel() {
        super("search");
    }

    public SearchState getState() {
        return state;
    }

    public void setState(SearchState searchState) {
        this.state = searchState;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("searchState", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
