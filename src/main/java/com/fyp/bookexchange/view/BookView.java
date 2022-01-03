package com.fyp.bookexchange.view;

import com.fyp.bookexchange.entity.Book;
import com.fyp.bookexchange.entity.User;
import com.fyp.bookexchange.repository.UserRepository;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;
import java.util.List;

@PermitAll
//@Route( value ="home" ,layout = MainView.class)
public class BookView extends FormLayout {

   // public BookView(String name, String imageUrl, String price, String condition, String reason, User user){
//        Image image=new Image(imageUrl, "My Alt Image");
//        VerticalLayout verticalLayout=new VerticalLayout();
//        HorizontalLayout horizontalLayout=new HorizontalLayout();
//
//        TextArea reasonTextArea=new TextArea(reason);
//        reasonTextArea.setReadOnly(true);
//        verticalLayout.add(new H2(name));
//        verticalLayout.add(new H4(price));
//        verticalLayout.add(new H4(condition));
//        verticalLayout.add(reasonTextArea);
//        setSizeFull();
//        getStyle().set("border","0");
//        verticalLayout.add(reasonTextArea);
//        Avatar avatarName = new Avatar(user.getName());
//        horizontalLayout.add(image,avatarName);
//        add(horizontalLayout,verticalLayout);

    public BookView(){
    for (int i=0;i<5;i++){
        i();
    }


    }
    void i(){
HorizontalLayout horizontalLayout=new HorizontalLayout();
        StreamResource imageResource = new StreamResource("img.png",
                () -> getClass().getResourceAsStream("/images/img.png"));

        Image image=new Image(imageResource, "My Alt Image");
        image.setWidth(148, Unit.PIXELS);
        image.setHeight(162, Unit.PIXELS);
        VerticalLayout verticalLayout=new VerticalLayout();
        VerticalLayout verticalLayout2=new VerticalLayout();

        TextArea reasonTextArea=new TextArea("reason OF Exchange");
        reasonTextArea.setValue("dshklfkldsfjsdjljfdskl\nsdfdshfdsjkhjkds");
        reasonTextArea.setReadOnly(true);
        verticalLayout.add(new H2("name"));
        verticalLayout.add(new H4("price : <h2>Free<h2>"));
        verticalLayout.add(new H4("condition : New"));
        verticalLayout.add(reasonTextArea);
        setSizeFull();
        getStyle().set("border","0");
        Avatar avatarName = new Avatar("husam");
//        Dialog dialog = new Dialog();
//        dialog.getElement().setAttribute("aria-label", "Create new employee");
//
//        VerticalLayout dialogLayout = new MessageListDocumentation(null);
//        dialog.add(dialogLayout);
//
//        Button button = new Button("Show dialog", e -> dialog.open());
//        add(dialog, button);
        verticalLayout2.add(image,avatarName);
        horizontalLayout.add(verticalLayout2,verticalLayout);
        horizontalLayout.setSpacing(true);
        horizontalLayout.getStyle().set("border","1rem solid");
        horizontalLayout.getStyle().set("marginH1u2s3a4m5" +
                "","5%");
        add(horizontalLayout);
    }

//    public void bookCard(List<Book> books){
//        for (int i = 0; i < books.size(); i++) {
//            StreamResource imageResource = new StreamResource("img.png",
//                    () -> getClass().getResourceAsStream(books.get(i).getImageUrl()));
//
//            Image image=new Image(imageResource, "My Alt Image");
//            image.setWidth(148, Unit.PIXELS);
//            image.setHeight(162, Unit.PIXELS);
//            HorizontalLayout horizontalLayout=new HorizontalLayout();
//            VerticalLayout verticalLayout=new VerticalLayout();
//            VerticalLayout verticalLayout2=new VerticalLayout();
//
//            TextArea reasonTextArea=new TextArea("reason OF Exchange");
//            reasonTextArea.setValue(books.get(i).getReason());
//            reasonTextArea.setReadOnly(true);
//            verticalLayout.add(new H2("name: "+books.get(i).getName()));
//            verticalLayout.add(new H4("price :"+books.get(i).getPrice()));
//            verticalLayout.add(new H4("condition :"+books.get(i).getConditions()));
//            verticalLayout.add(reasonTextArea);
//            setSizeFull();
//            getStyle().set("border","0");
//            Avatar avatarName = new Avatar(books.get(i).getUser().getName());
//            verticalLayout2.add(image,avatarName);
//            horizontalLayout.add(verticalLayout2,verticalLayout);
//            horizontalLayout.setSpacing(true);
//            horizontalLayout.getStyle().set("border","1rem solid");
//            horizontalLayout.getStyle().set("marginH1u2s3a4m5" +
//                    "","5%");
//            add(horizontalLayout);
//        }
//    }

}
