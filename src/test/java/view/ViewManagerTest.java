package view;

import interface_adapters.ViewManagerModel;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ViewManagerTest {
    @Test
    void constructor() {
        ViewManager viewManager = new ViewManager(new JPanel(), new CardLayout(), new ViewManagerModel());
        assert(true);
    }
}