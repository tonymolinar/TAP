package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class Hilo extends Thread{

    /* 1) Crear la clase y heredar el Thread
    2) Sobreescribir el metodo run
    3) Crear while infinito
    4) Crear plataform
    5) Programar Logica

     */

    private int cont=0;
    private Label label;
    public Hilo(Label label){
        this.label=label;
    }

    @Override
    public void run(){
        while(true){


            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(cont+"");
                        label.setText(cont+"");
                        cont++;
                    }
                });

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
