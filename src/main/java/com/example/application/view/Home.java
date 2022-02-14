package com.example.application.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;


@AnonymousAllowed
@Route("local")
public class Home extends FormLayout {

    Button register =new Button("Register");
    Button login=new Button("Login");
     public Home(){
        register.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        register.setIcon(new Icon(VaadinIcon.TOUCH));
        login.addThemeVariants(ButtonVariant.LUMO_ERROR);
        login.setIcon(new Icon(VaadinIcon.TOUCH));
        register.getStyle().set("margin","10%");
        login.getStyle().set("margin","10%");
        register.getStyle().set("height","200px");
         login.getStyle().set("height","200px");

login.addClickListener(buttonClickEvent -> {
    UI.getCurrent().navigate(LoginView.class);
});
register.addClickListener(buttonClickEvent -> {
    UI.getCurrent().navigate(Register.class);
});
        add(register,login);
    }
}
