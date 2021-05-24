package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

import java.util.WeakHashMap;

public class Controller {
    @FXML Canvas lienzo;
    GraphicsContext context;
    @FXML ColorPicker colorP;
    @FXML Slider slider;
    @FXML ComboBox comboOpciones;
    Color colorpincel = Color.BLACK;

    @FXML protected void initialize(){
        context= lienzo.getGraphicsContext2D();
        comboOpciones.getItems().addAll("Cuadricula","Ajedrez","Estrella","Estrella Doble","Estrella Tapiz","Circulos");
    }

    public void dibujar(int valor){

        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,500,500);
        context.setStroke(colorpincel);
        System.out.println(valor);

        if (comboOpciones.getSelectionModel().getSelectedIndex()==0){

            double division = lienzo.getWidth() / valor;
            for (int x=0;x<valor;x++){

                context.strokeLine(0,x*division,lienzo.getWidth(),x*division);
                context.strokeLine(x*division,0,x*division,lienzo.getHeight());
            }
            context.strokeLine(0,lienzo.getHeight(),lienzo.getWidth(),lienzo.getHeight());
            context.strokeLine(lienzo.getWidth(),0,lienzo.getWidth(),lienzo.getHeight());

        }
        else if (comboOpciones.getSelectionModel().getSelectedIndex()==1){

            context.setFill(Color.WHITE);
            context.fillRect(0,0,lienzo.getWidth(),lienzo.getHeight());

            double division = lienzo.getWidth() / valor;

            for (int j = 0; j < valor; j++) {
                for (int i = 0; i < valor; i++) {
                    if ((j % 2) != 0) {
                        context.setFill(colorpincel);
                        context.fillRect(2 * division * i, division * j, division, division);
                    }
                    if ((i % 2) != 0) {
                        context.setFill(colorpincel);
                        context.fillRect(division * i, 2 * division * j, division, division);
                    }
                }
            }

        }
        else if (comboOpciones.getSelectionModel().getSelectedIndex()==2){

            int mitadAncho = (int) lienzo.getWidth()/2;
            int mitadAlto = (int) lienzo.getHeight()/2;

            context.strokeLine(0,lienzo.getHeight()/2,lienzo.getWidth(),lienzo.getHeight()/2);
            context.strokeLine(lienzo.getWidth()/2,0,lienzo.getWidth()/2,lienzo.getHeight());

            double divisiones = (double) mitadAncho/valor;

            for (int j=1;j<valor+1;j++){
                context.strokeLine(mitadAncho,divisiones*j,mitadAncho+(divisiones*j),mitadAlto);
            }
            for (int j=1;j<valor+1;j++){
                context.strokeLine(mitadAncho,divisiones*j,mitadAncho-(divisiones*j),mitadAlto);
            }
            for (int j=1;j<valor+1;j++){
                context.strokeLine(mitadAncho,lienzo.getHeight()-(divisiones*j),mitadAncho+(divisiones*j),mitadAlto);
            }
            for (int j=1;j<valor+1;j++){
                context.strokeLine(mitadAncho,lienzo.getHeight()-(divisiones*j),mitadAncho-(divisiones*j),mitadAlto);
            }

        }
        else if (comboOpciones.getSelectionModel().getSelectedIndex()==3){

            int mitadAncho = (int) lienzo.getWidth()/2;
            int mitadAlto = (int) lienzo.getHeight()/2;

            double divisiones = (double) mitadAncho/valor;

            context.setStroke(Color.BLACK);

            context.strokeLine(0,lienzo.getHeight(),lienzo.getWidth(),0);
            context.strokeLine(0,0,lienzo.getWidth(),lienzo.getHeight());


            for (int j=1;j<valor+1;j++){

                context.strokeLine(mitadAncho-(j*divisiones),mitadAlto+(j*divisiones),(j*divisiones),(j*divisiones));
                context.strokeLine(mitadAncho+(j*divisiones),mitadAlto-(j*divisiones),(j*divisiones),(j*divisiones));
                context.strokeLine((j*divisiones),lienzo.getHeight()-(j*divisiones),mitadAncho+(j*divisiones),mitadAlto+(j*divisiones));
                context.strokeLine(mitadAncho+(j*divisiones),mitadAlto+(j*divisiones),lienzo.getWidth()-(j*divisiones),(j*divisiones));

            }

            context.setStroke(colorpincel);

            context.strokeLine(0,lienzo.getHeight()/2,lienzo.getWidth(),lienzo.getHeight()/2);
            context.strokeLine(lienzo.getWidth()/2,0,lienzo.getWidth()/2,lienzo.getHeight());

            for (int j=1;j<valor+1;j++){
                context.strokeLine(mitadAncho,divisiones*j,mitadAncho+(divisiones*j),mitadAlto);
                context.strokeLine(mitadAncho,divisiones*j,mitadAncho-(divisiones*j),mitadAlto);
                context.strokeLine(mitadAncho,lienzo.getHeight()-(divisiones*j),mitadAncho+(divisiones*j),mitadAlto);
                context.strokeLine(mitadAncho,lienzo.getHeight()-(divisiones*j),mitadAncho-(divisiones*j),mitadAlto);
            }

            for (int j=1;j<valor+1;j++){
                context.strokeLine(mitadAncho+(divisiones*j),0,lienzo.getWidth(),divisiones*j);
                context.strokeLine(mitadAncho-(divisiones*j),0,0,divisiones*j);
                context.strokeLine(mitadAncho+(divisiones*j),lienzo.getHeight(),lienzo.getWidth(),lienzo.getHeight()-(divisiones*j));
                context.strokeLine(mitadAncho-(divisiones*j),lienzo.getHeight(),0,lienzo.getHeight()-(divisiones*j));
            }



        }else if (comboOpciones.getSelectionModel().getSelectedIndex()==4){

            int mitadAncho = (int) lienzo.getWidth()/2;
            int mitadAlto = (int) lienzo.getHeight()/2;

            double divisiones = (double) mitadAncho/valor;

            context.setStroke(Color.BLACK);

            for (int j=1;j<valor+1;j++){
                context.strokeLine(mitadAncho,mitadAlto+(divisiones*j),mitadAncho+(divisiones*j),lienzo.getHeight());
                context.strokeLine(mitadAncho,mitadAlto+(divisiones*j),mitadAncho-(divisiones*j),lienzo.getHeight());
                context.strokeLine(mitadAncho,mitadAlto-(divisiones*j),mitadAncho+(divisiones*j),0);
                context.strokeLine(mitadAncho,mitadAlto-(divisiones*j),mitadAncho-(divisiones*j),0);

                context.strokeLine(0,divisiones*j,(divisiones*j),mitadAlto);
                context.strokeLine(0,lienzo.getHeight()-(divisiones*j),(divisiones*j),mitadAlto);
                context.strokeLine(lienzo.getWidth(),divisiones*j,lienzo.getWidth()-(divisiones*j),mitadAlto);
                context.strokeLine(lienzo.getWidth(),lienzo.getHeight()-(divisiones*j),lienzo.getWidth()-(divisiones*j),mitadAlto);
            }

            context.setStroke(colorpincel);

            context.strokeLine(0,lienzo.getHeight()/2,lienzo.getWidth(),lienzo.getHeight()/2);
            context.strokeLine(lienzo.getWidth()/2,0,lienzo.getWidth()/2,lienzo.getHeight());

            for (int j=1;j<valor+1;j++){
                context.strokeLine(mitadAncho,divisiones*j,mitadAncho+(divisiones*j),mitadAlto);
                context.strokeLine(mitadAncho,divisiones*j,mitadAncho-(divisiones*j),mitadAlto);
                context.strokeLine(mitadAncho,lienzo.getHeight()-(divisiones*j),mitadAncho+(divisiones*j),mitadAlto);
                context.strokeLine(mitadAncho,lienzo.getHeight()-(divisiones*j),mitadAncho-(divisiones*j),mitadAlto);
            }




        }


        if(comboOpciones.getSelectionModel().getSelectedIndex()==5){

            context.strokeLine(0,lienzo.getHeight()/2,lienzo.getWidth(),lienzo.getHeight()/2);
            context.strokeLine(lienzo.getWidth()/2,0,lienzo.getWidth()/2,lienzo.getHeight());

            int mitadAncho = (int) lienzo.getWidth()/2;
            int mitadAlto = (int) lienzo.getHeight()/2;
            context.strokeOval((lienzo.getWidth()/2)-50,(lienzo.getHeight()/2)-50,100,100);
            double division = (double) (100*(Math.PI))/valor;

            for (int x=0;x<valor;x++){


                for (int y=0;y<x;y++){
                    context.strokeOval(x*division,y*division,200,200);
                }
            }


        }

    }

    public void arrastrar(MouseEvent event){
        context.setFill(colorpincel);
        context.fillOval(event.getX(),event.getY(),10,10);
    }

    public void cambiarcolor(ActionEvent event){
        colorpincel = colorP.getValue();
    }

    public void borrar(ActionEvent event){
        context.setFill(Color.WHITESMOKE);
        context.fillRect(0,0,500,500);
    }

    public void scroll(MouseEvent event){
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                dibujar(t1.intValue());
            }
        });
    }
}
