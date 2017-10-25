package org.unitec.elementos2017;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ui.UIState;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringUI
@Theme("valo")
public class MiUI extends UI {
    @Autowired
    RepositorioMensajito repoMensa;
    Grid<Mensajito> grid = new Grid<>();
    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();

        //Generamos una etiqueta
        Label etiqueta = new Label("Aplicacion con mensaje");
        etiqueta.addStyleName(ValoTheme.LABEL_H1);
        Label etiquetaGuardar = new Label("Aplicacion con mensaje");
        etiquetaGuardar.addStyleName(ValoTheme.LABEL_H2);
        TextField textoTitulo = new TextField();
        //El siguiente es un placeholder
        textoTitulo.setPlaceholder("Escribe Titulo");
        TextArea textoCuerpo = new TextArea();
        textoCuerpo.setPlaceholder("Escribe el cuerpo del mensaje");
        Button boton = new Button("Guardar mensaje");

        //Manejamos el evento del boton

            if(textoCuerpo.getValue().equals("") && textoTitulo.getValue().equals("")){
                Notification.show("Llena todos los campos");
            }else {
                boton.addClickListener(evento -> {
                    repoMensa.save(new Mensajito(textoTitulo.getValue(), textoCuerpo.getValue()));
                    Notification.show("Se guardo el mensaje", Notification.Type.ERROR_MESSAGE);
                    grid.setItems((List) repoMensa.findAll());
                });
            }


        // Create a grid bound to the list

        grid.setItems((List)repoMensa.findAll());
        grid.addColumn(Mensajito::getTitulo).setCaption("Titulo");
        grid.addColumn(Mensajito::getCuerpo).setCaption("Cuerpo");

        layout.addComponent(etiqueta);
        layout.addComponent(etiquetaGuardar);
        layout.addComponent(textoTitulo);
        layout.addComponent(textoCuerpo);
        layout.addComponent(boton);
        layout.addComponent(grid);
        setContent(layout);
    }
}
