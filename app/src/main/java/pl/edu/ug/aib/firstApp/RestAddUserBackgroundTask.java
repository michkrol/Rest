package pl.edu.ug.aib.firstApp;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

import pl.edu.ug.aib.firstApp.data.EmailAndPassword;
import pl.edu.ug.aib.firstApp.data.Person;
import pl.edu.ug.aib.firstApp.data.User;

@EBean
public class RestAddUserBackgroundTask {

    @RootContext
    AddUserActivity activity;

    @RestService
    PhoneBookRestClient restClient;

    @Background
    void addUser(Person person, String sessionId) {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "phonebook");
            restClient.setHeader("X-Dreamfactory-Session-Token", "phonebook");
            int id = restClient.addUser(person, sessionId);
            publishResult(id);
        } catch (Exception e) {
            publishError(e);
        }
    }

    @UiThread
    void publishResult(int id) {
        activity.addingSuccess(id);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

}
