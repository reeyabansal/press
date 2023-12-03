package interface_adapters.TopNews;

import interface_adapters.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TopNewsViewModel extends ViewModel {
    private TopNewsState state = new TopNewsState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public TopNewsViewModel() {
        super("TopNews");
    }


    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("topNewsState", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public TopNewsState getState() {
        return state;
    }

    public void setState(TopNewsState state) {
        this.state = state;
    }
}
