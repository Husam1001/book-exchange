package com.fyp.bookexchange.view;

import com.fyp.bookexchange.entity.User;
import com.fyp.bookexchange.repository.UserRepository;
import com.vaadin.collaborationengine.CollaborationMessageInput;
import com.vaadin.collaborationengine.CollaborationMessageList;
import com.vaadin.collaborationengine.UserInfo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.security.PermitAll;

@PermitAll
@Route(value = "chat",layout = MainView.class)
public class MessageListDocumentation extends VerticalLayout{

  UserRepository userRepository;

    @Autowired
    public MessageListDocumentation(UserRepository userRepository) {
         this.userRepository=userRepository;

        User userEntity =  userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        UserInfo userInfo = new UserInfo(userEntity.getId().toString(),
                userEntity.getName());
        String topicId = "general";

        CollaborationMessageList messageList = new CollaborationMessageList(
                userInfo, topicId);
        CollaborationMessageInput messageInput = new CollaborationMessageInput(
                messageList);


        VerticalLayout chatLayout = new VerticalLayout(messageList,
                messageInput);

        TextField field = new TextField("Message");
        Button button = new Button("Submit");
        button.setEnabled(false);



        chatLayout.setHeight("500px");
        chatLayout.setWidth("400px");
        chatLayout.expand(messageList);
        messageInput.setWidthFull();
        add(chatLayout);


    }


}
