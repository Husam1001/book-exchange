package com.fyp.bookexchange.view;

import com.fyp.bookexchange.entity.Book;
import com.fyp.bookexchange.entity.User;
import com.fyp.bookexchange.repository.UserRepository;
import com.fyp.bookexchange.service.BookService;
import com.fyp.bookexchange.service.UserService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.security.PermitAll;
import java.util.List;

@PermitAll
@Route(value = "profile",layout = MainView.class)
public class ProfileView extends FormLayout {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    UserRepository userRepository;
    UserService userService;
    User currentUser;

    BookService bookService;
    private List<Book> books;


    H1 lable = new H1("Update Profile");
    H1 lable2 = new H1("Book List");
    TextField fullName = new TextField("Full name");
    PasswordField password = new PasswordField("Password");
    EmailField email = new EmailField("Email");
    VerticalLayout updateProfile=new VerticalLayout();
    VerticalLayout booksList=new VerticalLayout();

    @Autowired
    public ProfileView(UserRepository userRepository ,UserService userService,BookService bookService){
        this.userRepository=userRepository;
        this.userService=userService;
        this.bookService=bookService;
        currentUser=userRepository.findByEmail(auth.getName());
        books=bookService.loadBookByUser(currentUser);
        lable2.getStyle().set("color", "dodgerblue");
        booksList.add(lable2);
        bookCard();

        fullName.setValue(currentUser.getName());
        TextField fullName = new TextField("Full name");
        fullName.setValue(currentUser.getName());
        EmailField email = new EmailField("Email");
      email.setValue(currentUser.getEmail());

        Button update = new Button("Update");

            User user=currentUser;
            addClassName("contact-form");
            lable.getStyle().set("color", "dodgerblue");


        update.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            styleElement();
            update.addClickListener(event->{
                user.setEmail(email.getValue());
                user.setName(fullName.getValue());
                String s=password.getValue();
                if(s.equals(null)||s.equals("")){
                    s=user.getPassword();
                    user.setPassword(s);
                }else {
                user.setPassword(new BCryptPasswordEncoder().encode(s));
                }

                userService.updateUser(user.getId(),user.getName(),user.getEmail(),user.getPassword());
                UI.getCurrent().navigate(LoginView.class);
                Notification.show("Profile Updated");

            });
            booksList.getStyle().set("margin","1%");
            updateProfile.setAlignItems(FlexComponent.Alignment.AUTO);
            updateProfile.getStyle().set("border","1rem");
           updateProfile.add(lable,
                    fullName,
                    email,
                    password,
                    update,
                    update);
           add(booksList);
           add(updateProfile);
          // setAlignItems(Alignment.END);

        }

        public void styleElement(){
            fullName.setWidth(60, Unit.PERCENTAGE);
            fullName.setMaxWidth(3,Unit.INCH);
            email.setWidth(60, Unit.PERCENTAGE);
            email.setMaxWidth(3,Unit.INCH);
            password.setWidth(60, Unit.PERCENTAGE);
            password.setMaxWidth(3,Unit.INCH);
        }

    public void bookCard(){
        books=bookService.loadBookByUser(currentUser);
        for (Book book : books) {
            String src = book.getImageUrl();
            String na = book.getImageUrl().replace("/images/", "");
            StreamResource imageResource = new StreamResource(na,
                    () -> getClass().getResourceAsStream(src));

            Image image = new Image(imageResource, "My Alt Image");
            image.setWidth(148, Unit.PIXELS);
            image.setHeight(162, Unit.PIXELS);
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            VerticalLayout verticalLayout = new VerticalLayout();
            VerticalLayout verticalLayout2 = new VerticalLayout();

            TextArea reasonTextArea = new TextArea("reason OF Exchange");
            reasonTextArea.setValue(book.getReason());
            reasonTextArea.setReadOnly(true);
            verticalLayout.add(new H2("name: " + book.getName()));
            verticalLayout.add(new H4("price :" + book.getPrice()));
            verticalLayout.add(new H4("condition :" + book.getConditions()));
            verticalLayout.add(reasonTextArea);
//            setSizeFull();
//            getStyle().set("border","0");
            verticalLayout2.add(image);
            Avatar avatarName = new Avatar(book.getUser().getName());

//            Dialog dialog = new Dialog();
//            dialog.getElement().setAttribute("aria-label", "Create new employee");
//
//            VerticalLayout dialogLayout = new MessageListDocumentation(userRepository);
//            dialog.add(dialogLayout);

//            Button button = new Button("Chat with " + book.getUser().getName(), e -> dialog.open());
//            button.setIcon(new Icon(VaadinIcon.CHAT));
            verticalLayout2.add(avatarName);
            horizontalLayout.add(verticalLayout2, verticalLayout);
            horizontalLayout.setSpacing(true);
            horizontalLayout.getStyle().set("border", "1rem solid");
            horizontalLayout.getStyle().set("margin", "5%");
            booksList.add(horizontalLayout);
        }
    }


    }

