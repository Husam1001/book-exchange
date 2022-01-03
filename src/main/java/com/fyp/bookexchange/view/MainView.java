package com.fyp.bookexchange.view;

import com.fyp.bookexchange.security.SecurityService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLink;

import java.util.HashMap;
import java.util.Map;

public class MainView extends AppLayout implements BeforeEnterObserver {
    private final SecurityService securityService;
    private Tabs tabs = new Tabs();
    private Map<Class<? extends Component>, Tab> navigationTargetToTab = new HashMap<>();

    public MainView( SecurityService securityService ) {
        this.securityService = securityService;
//        addMenuTab("Main", DefaultView.class);
//        addMenuTab("Admin", AdminView.class);
//        addMenuTab("Dashboard", DashboardView.class);
//        Button logout = new Button("Log out", e -> securityService.logout());
//        HorizontalLayout header = new HorizontalLayout(logout);
        //addMenuTab("Login", LoginView.class);
       // addMenuTab("Login", LoginView.class);

       // addMenuTab("Register", Register.class);

        HorizontalLayout header;

            Button logout = new Button("Logout", click ->
                    securityService.logout());
            header = new HorizontalLayout( logout);


        // Other page components omitted.
    logout.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
    //logout.getStyle().set("margin-left","100%");

        addMenuTab("Home", HomeView.class);
        addMenuTab("Add Book", AddBookView.class);
        addMenuTab("Chat", MessageListDocumentation.class);
        addMenuTab("Profile", ProfileView.class);
        //this.getElement().getThemeList().add("dark");
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(tabs);
        addToNavbar(new DrawerToggle());
        addToNavbar(header);

    }

    private void addMenuTab(String label, Class<? extends Component> target) {
        Tab tab = new Tab(new RouterLink(label, target));
        navigationTargetToTab.put(target, tab);
        tabs.add(tab);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        tabs.setSelectedTab(navigationTargetToTab.get(event.getNavigationTarget()));
    }
}


