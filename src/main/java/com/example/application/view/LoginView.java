package com.example.application.view;


import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("Login | Book")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {


    private final LoginForm login = new LoginForm();

    public LoginView(){
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        login.setAction("login");

        add(new H1("Book Exchange"), login);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // inform the user about an authentication error
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }
}


//import com.fyp.bookexchange.entity.User;
//import com.fyp.bookexchange.service.LoginService;
//import com.vaadin.flow.component.login.LoginForm;
//import com.vaadin.flow.component.login.LoginI18n;
//import com.vaadin.flow.component.notification.Notification;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.Route;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
////@Route(value = "lo", layout = MainView.class)
//@Route("login")
//    public class LoginView extends VerticalLayout {
//        @Autowired
//        LoginService loginService;
//    public LoginView() {
//        LoginI18n i18n = LoginI18n.createDefault();
//        LoginI18n.Form i18nForm = i18n.getForm();
//        i18nForm.setTitle("Login");
//        i18nForm.setUsername("Email");
//        i18nForm.setPassword("Password");
//        i18nForm.setSubmit("Login");
//        i18nForm.setForgotPassword("Forgot Password?");
//        i18n.setForm(i18nForm);
//
//        LoginI18n.ErrorMessage i18nErrorMessage = i18n.getErrorMessage();
//        i18nErrorMessage.setTitle("Error");
//        i18nErrorMessage.setMessage("Invalid Username/Password.");
//        i18n.setErrorMessage(i18nErrorMessage);
//
//        LoginForm loginForm = new LoginForm();
//        loginForm.setI18n(i18n);
//        // loginForm.getElement().getThemeList().add("dark");
//        loginForm.addLoginListener(event->{
//
////                    LoginService service = new LoginService();
////                    User user= service.verifyUser(event.getUsername(),event.getPassword());
////                    if (user!=null) {
////                        VaadinService.getCurrentRequest().getWrappedSession().setAttribute("User Login", user);
////                        VaadinSession.getCurrent().getSession().setAttribute("User Login", user);
////                        User user1= (User) VaadinService.getCurrentRequest().getAttribute("User Login");
////                        User user2 = (User) VaadinSession.getCurrent().getSession().getAttribute("User Login");
////
////                        Notification.show(user1.getEmail());
////                        Notification.show(user2.getName());
////                    }else {
////                        i18nForm.setUsername("");
////                        i18nForm.setPassword("");
////                    }
//            loginService.verifyUser(event.getUsername(),event.getPassword());
//
//                });
//
//        add(loginForm);
//        this.setAlignItems(Alignment.CENTER);
//    }
// }
