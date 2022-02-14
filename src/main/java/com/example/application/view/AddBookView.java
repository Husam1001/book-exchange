package com.example.application.view;

import com.example.application.service.AddBookService;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;
import java.io.InputStream;

@PermitAll
@Route( value ="addBook" ,layout = MainView.class)
@PageTitle("Add | Book")
public class AddBookView extends FormLayout {

   private String fileName;
    private InputStream fileData;

    @Autowired
    AddBookService bookService;

public AddBookView(){

    H1 header=new H1("Add New book");

    TextField nameTextField=new TextField("Name ");
    TextField descriptionTextField=new TextField("Description");
    TextField priceTextField=new TextField("Price ");
    Select<String> condition = new Select<>();
    condition.setLabel("Condition");
    condition.setItems("New","Used");
    condition.setPlaceholder("Select condition");
    condition.setEmptySelectionAllowed(true);
    TextArea exchangeReason=new TextArea("Exchange Reason ");
    MemoryBuffer memoryBuffer = new MemoryBuffer();
    Upload singleFileUpload = new Upload(memoryBuffer);
    singleFileUpload.setDropAllowed(true);
    //singleFileUpload.setAcceptedFileTypes("images/*");
    //singleFileUpload.setMaxFiles(1);
    Button save=new Button("Save");
    save.getStyle().set("margin","0");
    save.setIcon(new Icon(VaadinIcon.TOUCH));
    save.setIconAfterText(true);
    singleFileUpload.addSucceededListener(event -> {
        // Get information about the uploaded file
         fileData = memoryBuffer.getInputStream();
         fileName = event.getFileName();
        long contentLength = event.getContentLength();
        String mimeType = event.getMIMEType();

        // Do something with the file data
        // processFile(fileData, fileName, contentLength, mimeType);
        Notification.show("File Uploaded");



    });

    save.addClickListener(attachEvent -> {
       bookService.saveBook(nameTextField.getValue().toString(),descriptionTextField.getValue(),priceTextField.getValue(),condition.getValue(),exchangeReason.getValue(),fileName);
        try {
            bookService.saveImage(fileData,fileName);
        }catch (Exception e){
        System.out.println(e.getMessage());}

        UI.getCurrent().navigate(HomeView.class);
    });

    //header.getStyle().set("text-align","center");
    add(header);

    add(nameTextField,descriptionTextField,priceTextField,condition,exchangeReason,singleFileUpload,save);

    setResponsiveSteps(
            // Use one column by default
            new ResponsiveStep("0", 1),
            // Use two columns, if layout's width exceeds 500px
            new ResponsiveStep("1000px", 2)
    );
// Stretch the username field over 2 columns
    setColspan(header, 2);

    this.getStyle().set("margin","5%");

    this.setHeightFull();

}

}
