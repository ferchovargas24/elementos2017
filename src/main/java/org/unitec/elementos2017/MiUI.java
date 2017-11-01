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
        TextField textoTitulo = new TextField();
        //El siguiente es un placeholder
        textoTitulo.setPlaceholder("Escribe Titulo");
        TextArea textoCuerpo = new TextArea();
        textoCuerpo.setPlaceholder("Escribe el cuerpo del mensaje");
        Button boton = new Button("Guardar mensaje");
        boton.addStyleName(ValoTheme.BUTTON_BORDERLESS);

        //Manejamos el evento del boton
        boton.addClickListener(evento -> {

            if(textoCuerpo.getValue().equals("") || textoTitulo.getValue().equals("")){
                Notification.show("Llena todos los campos");
            }else {

                    repoMensa.save(new Mensajito(textoTitulo.getValue(), textoCuerpo.getValue()));
                    Notification.show("Se guardo el mensaje", Notification.Type.ERROR_MESSAGE);
                    grid.setItems((List) repoMensa.findAll());
                }
            });


        // Create a grid bound to the list

        grid.setItems((List)repoMensa.findAll());
        grid.addColumn(Mensajito::getId).setCaption("Id");
        grid.addColumn(Mensajito::getTitulo).setCaption("Titulo");
        grid.addColumn(Mensajito::getCuerpo).setCaption("Cuerpo");


        layout.addComponent(etiqueta);
        layout.addComponent(textoTitulo);
        layout.addComponent(textoCuerpo);
        layout.addComponent(boton);
        layout.addComponent(grid);
        setContent(layout);

        HorizontalLayout layout1=new HorizontalLayout();
        TextField textoId=new TextField();
        textoId.setPlaceholder("introduce el id");
        Button botonBuscarId=new Button("Buscar");
        botonBuscarId.addStyleName(ValoTheme.BUTTON_PRIMARY);


        layout1.addComponent(textoId);
        layout1.addComponent(botonBuscarId);

        layout.addComponent(layout1);

        //Creamos otro layout para los campos de texto
        HorizontalLayout layout2=new HorizontalLayout();
        TextField textoBuscarId=new TextField();
        TextField textoBuscarTitulo=new TextField();
        TextArea textoBuscarCuerpo=new TextArea();
        Button borrarBoton = new Button("Borrar");
        borrarBoton.addStyleName(ValoTheme.BUTTON_DANGER);
        layout2.addComponent(textoBuscarId);
        layout2.addComponent(textoBuscarTitulo);
        layout2.addComponent(textoBuscarCuerpo);
        layout2.addComponent(borrarBoton);
        layout.addComponent(layout2);

        Button botonActualizar=new Button("Actualizar");
        botonActualizar.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        layout.addComponent(botonActualizar);
        setContent(layout);

        botonBuscarId.addClickListener(evento->{
            if(textoId.getValue().equals("")){
                Notification.show("Introduce un ID",Notification.Type.ERROR_MESSAGE);
            }else{
                Mensajito mensa= repoMensa.findOne(Integer.parseInt(textoId.getValue()));
                textoBuscarId.setValue( ""+mensa.getId());
                textoBuscarTitulo.setValue(mensa.getTitulo());
                textoBuscarCuerpo.setValue(mensa.getCuerpo());
            }
        });

        botonActualizar.addClickListener(evento -> {

            if(textoBuscarCuerpo.getValue().equals("") || textoBuscarTitulo.getValue().equals("") || textoBuscarId.getValue().equals("")){
                Notification.show("Busca un mensaje o llena todos los campos", Notification.Type.WARNING_MESSAGE);
            }else {

                repoMensa.save(new Mensajito(Integer.parseInt(textoBuscarId.getValue()) ,textoBuscarTitulo.getValue(),textoBuscarCuerpo.getValue()));
                Notification.show("Se actualizó el mensaje", Notification.Type.HUMANIZED_MESSAGE);
                grid.setItems((List) repoMensa.findAll());
            }
        });

        borrarBoton.addClickListener(evento -> {

            if(textoBuscarCuerpo.getValue().equals("") || textoBuscarTitulo.getValue().equals("") || textoBuscarId.getValue().equals("")){
                Notification.show("Busca un mensaje o llena todos los campos", Notification.Type.WARNING_MESSAGE);
            }else {

                repoMensa.delete(Integer.parseInt(textoBuscarId.getValue()));
                Notification.show("Se borró el mensaje", Notification.Type.HUMANIZED_MESSAGE);
                grid.setItems((List) repoMensa.findAll());
            }
        });
    }
}
