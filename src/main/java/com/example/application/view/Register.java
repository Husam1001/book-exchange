package com.example.application.view;


import com.example.application.entity.User;
import com.example.application.service.UserService;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Route("register")
@AnonymousAllowed
public class Register extends VerticalLayout {

    @Autowired
    UserService registerService;



    H1 lable = new H1("Register");
    TextField fullName = new TextField("Full name");

    EmailField email = new EmailField("Email");

    PasswordField password = new PasswordField("Password");

    RouterLink login = new RouterLink("Login", LoginView.class);

    Button register = new Button("Register");
    public Register() {
         User user=new User();
        addClassName("contact-form");
        lable.getStyle().set("color", "dodgerblue");
        register.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        styleElement();
        register.addClickListener(event->{
            user.setEmail(email.getValue());
            user.setName(fullName.getValue());
            String s=password.getValue();
            user.setPassword(new BCryptPasswordEncoder().encode(s));
            registerService.saveUser(user);
            UI.getCurrent().navigate(LoginView.class);
            Notification.show("User Saved");
//            if (registerService.saveUser(user)) {
//                UI.getCurrent().navigate(LoginView.class);
//                Notification.show("User Saved");
//            }

        });
        add(lable,
                fullName,
                email,
                password,
                register,
                login);
        setAlignItems(Alignment.CENTER);
    }

    public void styleElement(){
        fullName.setWidth(60, Unit.PERCENTAGE);
        fullName.setMaxWidth(3,Unit.INCH);
        email.setWidth(60, Unit.PERCENTAGE);
        email.setMaxWidth(3,Unit.INCH);
        password.setWidth(60, Unit.PERCENTAGE);
        password.setMaxWidth(3,Unit.INCH);
    }

}