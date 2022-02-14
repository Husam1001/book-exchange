package com.example.application.view;

import com.example.application.entity.Book;
import com.example.application.repository.UserRepository;
import com.example.application.service.BookService;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;
import java.util.List;
@PermitAll
@Route( value ="" ,layout = MainView.class)

public class HomeView extends FormLayout {


    BookService bookService;
    UserRepository userRepository;
   private List<Book> books;

   @Autowired
    public HomeView(BookService bookService, UserRepository userRepository){
       this.bookService=bookService;
       this.userRepository=userRepository;
        bookCard();
    }
    int s;
    public void bookCard(){
         books=bookService.loadBook();
        for (int i = 0; i < books.size(); i++) {
            String src=books.get(i).getImageUrl();
           String na=books.get(i).getImageUrl().replace("/images/","");
//            StreamResource imageResource = new StreamResource(na,
//                    () -> getClass().getResourceAsStream(src));
//
//            Image image=new Image(imageResource, "My Alt Image");
            StreamResource imageResource = new StreamResource(na,
                    () -> getClass().getResourceAsStream(src));

            Image image = new Image(imageResource, "My Streamed Image");
            add(image);
            image.setWidth(148, Unit.PIXELS);
            image.setHeight(162, Unit.PIXELS);
            HorizontalLayout horizontalLayout=new HorizontalLayout();
            VerticalLayout verticalLayout=new VerticalLayout();
            VerticalLayout verticalLayout2=new VerticalLayout();

            TextArea reasonTextArea=new TextArea("reason OF Exchange");
            reasonTextArea.setValue(books.get(i).getReason());
            reasonTextArea.setReadOnly(true);
            verticalLayout.add(new H2("name: "+books.get(i).getName()));
            verticalLayout.add(new H4("price :"+books.get(i).getPrice()));
            verticalLayout.add(new H4("condition :"+books.get(i).getConditions()));
            verticalLayout.add(reasonTextArea);
            setSizeFull();
            getStyle().set("border","0");
            verticalLayout2.add(image);
            Avatar avatarName = new Avatar(books.get(i).getUser().getName());

            Dialog dialog = new Dialog();
            dialog.getElement().setAttribute("aria-label", "Create new employee");

            //VerticalLayout dialogLayout = new MessageListDocumentation(userRepository);
            //dialog.add(dialogLayout);

            Button button = new Button("Chat with "+books.get(i).getUser().getName(), e -> dialog.open());
            button.setIcon(new Icon(VaadinIcon.CHAT));
            verticalLayout2.add(avatarName,dialog,button);
            horizontalLayout.add(verticalLayout2,verticalLayout);
            horizontalLayout.setSpacing(true);
            horizontalLayout.getStyle().set("border","1rem solid");
            horizontalLayout.getStyle().set("marginH1u2s3a4m5" +
                    "","5%");
            add(horizontalLayout);
        }
    }

}
