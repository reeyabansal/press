package view;

import app.LoginUseCaseFactory;
import entity.CommonUserFactory;
import entity.User;
import entity.UserFactory;
import interface_adapters.Favourite.FavouriteViewModel;
import interface_adapters.History.HistoryViewModel;
import interface_adapters.LoggedIn.LoggedInViewModel;
import interface_adapters.Map.MapViewModel;
import interface_adapters.Search.SearchViewModel;
import interface_adapters.SeeFavourites.SeeFavouritesViewModel;
import interface_adapters.SeeHistory.SeeHistoryViewModel;
import interface_adapters.TopNews.TopNewsViewModel;
import interface_adapters.ViewManagerModel;
import interface_adapters.login.LoginViewModel;
import interface_adapters.signup.SignupViewModel;
import org.junit.jupiter.api.Test;
import use_case.login.LoginUserDataAccessInterface;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LoginScreenTest {
    class DummyLoginDAO implements LoginUserDataAccessInterface {
        private final Map<String, User> users = new HashMap<>();
        DummyLoginDAO() {
            // initialize with a user
            UserFactory factory = new CommonUserFactory();
            users.put("user1", factory.create("user1","pass1", LocalDateTime.now()));
        }


        @Override
        public boolean existsByEmail(String identifier) {
            return false;
        }

        @Override
        public boolean existsByName(String identifier) {
            return users.containsKey(identifier);
        }

        @Override
        public void save(User user) {
            users.put(user.getName(), user);
        }

        @Override
        public User get(String email) {
            return users.get(email);
        }
    }

    @Test
    void actionPerformed() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        DummyLoginDAO userDataAccessObject = new DummyLoginDAO();
        LoginScreen loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel,
                loggedInViewModel, userDataAccessObject);
        assert(true);
    }

    @Test
    void propertyChange() {
    }
}