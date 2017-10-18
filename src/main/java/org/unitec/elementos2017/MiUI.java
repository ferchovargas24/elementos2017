package org.unitec.elementos2017;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI
@Theme("valo")
public class MiUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();

        //Generamos una etiqueta
        Label etiqueta = new Label("Aplicacion con mensaje");
        etiqueta.addStyleName(ValoTheme.LABEL_H1);
        layout.addComponent(etiqueta);
        setContent(layout);
    }
}
