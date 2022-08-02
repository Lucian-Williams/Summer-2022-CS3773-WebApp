package cs3773.application.views.users;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.router.*;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import cs3773.application.data.Role;
import cs3773.application.data.entity.User;
import cs3773.application.data.generator.DataGenerator;
import cs3773.application.data.service.UserService;
import cs3773.application.views.MainLayout;
import elemental.json.Json;
import org.apache.commons.io.input.TeeInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.util.UriUtils;

import javax.annotation.security.RolesAllowed;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.*;

import static cs3773.application.data.Role.USER;

@PageTitle("Users")
@Route(value = "users/:userID?/:action?(edit)", layout = MainLayout.class)
@RolesAllowed("ADMIN")
public class UserView extends Div implements BeforeEnterObserver {

    private final String USER_ID = "userID";
    private final String USER_EDIT_ROUTE_TEMPLATE = "users/%s/edit";

    private Grid<User> grid = new Grid<>(User.class, false);

    private TextField id;
    private TextField username;
    private TextField name;

    private TextField password;
    private Checkbox userCheckBox;
    private Checkbox adminCheckBox;

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private BeanValidationBinder<User> binder;

    private User user;

    private final UserService userService;

    @Autowired
    public UserView(UserService userService) {
        DataGenerator dg = new DataGenerator();


        this.userService = userService;
        addClassNames("users-view");

        // Create UI
        SplitLayout splitLayout = new SplitLayout();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        // Configure Grid
        //grid.addColumn("id").setAutoWidth(true);
        grid.addColumn("username").setAutoWidth(true);
        grid.addColumn("name").setAutoWidth(true);
        grid.addColumn("roles").setAutoWidth(true);

        grid.setItems(query -> userService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                UI.getCurrent().navigate(String.format(USER_EDIT_ROUTE_TEMPLATE, event.getValue().getId()));
            } else {
                clearForm();
                UI.getCurrent().navigate(UserView.class);
            }
        });

        // Configure Form
        binder = new BeanValidationBinder<>(User.class);


        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {


            try {
                if (this.user == null) {
                    this.user = new User();
                }
                binder.writeBean(this.user);

                this.user.clearRoles();

                if(adminCheckBox.getValue()){
                    this.user.setRoles(Set.of(Role.USER, Role.ADMIN));
                } else {
                    this.user.setRoles(Collections.singleton(Role.USER));
                }


                userService.update(this.user);
                clearForm();
                refreshGrid();
                Notification.show("User details stored.");
                UI.getCurrent().navigate(UserView.class);
            } catch (ValidationException validationException) {
                Notification.show("An exception happened while trying to store the user's details.");
            }
        });

    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Optional<UUID> userId = event.getRouteParameters().get(USER_ID).map(UUID::fromString);
        if (userId.isPresent()) {
            Optional<User> userFromBackend = userService.get(userId.get());
            if (userFromBackend.isPresent()) {
                populateForm(userFromBackend.get());
            } else {
                Notification.show(String.format("The requested user was not found, ID = %s", userId.get()), 3000,
                        Notification.Position.BOTTOM_START);
                // when a row is selected but the data is no longer available,
                // refresh grid
                refreshGrid();
                event.forwardTo(UserView.class);
            }
        }
    }



    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorLayoutDiv = new Div();
        editorLayoutDiv.setClassName("editor-layout");

        Div editorDiv = new Div();
        editorDiv.setClassName("editor");
        editorLayoutDiv.add(editorDiv);

        FormLayout formLayout = new FormLayout();
        formLayout.setWidth("400");
        id = new TextField("ID");
        id.setReadOnly(true);
        username = new TextField("Username");
        password = new TextField("Password");
        name = new TextField("Name");
        adminCheckBox = new Checkbox(("Admin"));
        userCheckBox = new Checkbox("User");

        userCheckBox.setEnabled(true);


        Component[] fields = new Component[]{id, username, password, name, userCheckBox, adminCheckBox};

        formLayout.add(fields);
        editorDiv.add(formLayout);
        createButtonLayout(editorLayoutDiv);

        splitLayout.addToSecondary(editorLayoutDiv);
    }

    private void createButtonLayout(Div editorLayoutDiv) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setClassName("button-layout");
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save, cancel);
        editorLayoutDiv.add(buttonLayout);
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setClassName("grid-wrapper");
        splitLayout.addToPrimary(wrapper);
        wrapper.add(grid);
    }

    private void refreshGrid() {
        grid.select(null);
        grid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(User value) {
        this.user = value;
        binder.readBean(this.user);

    }
}
