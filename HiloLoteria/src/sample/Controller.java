package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML Label lbl1;
    @FXML Label lbl2;
    @FXML Label lbl3;
    @FXML Label lbl4;
    @FXML Button btn;

    Hilo h1;
    Hilo h2;
    Hilo h3;
    Hilo h4;

    int contador=0;

    public void generar(ActionEvent event){

        if (btn.getText().equals("Generar")){

            btn.setText("Detener");
            btn.setStyle("-fx-background-color:red;-fx-text-fill:white");
            h1 = new Hilo(lbl1);
            h2 = new Hilo(lbl2);
            h3 = new Hilo(lbl3);
            h4 = new Hilo(lbl4);
            h1.start();
            h2.start();
            h3.start();
            h4.start();

        }else{

            int t1 = Integer.parseInt(lbl1.getText());
            int t2 = Integer.parseInt(lbl2.getText());
            int t3 = Integer.parseInt(lbl3.getText());
            int t4 = Integer.parseInt(lbl4.getText());

            switch (contador){
                case 0:{
                    h1.stop();
                    contador++;
                    break;
                }
                case 1:{
                    if (t1!=t2){
                        h2.stop();
                        contador++;
                    }
                    break;
                }
                case 2:{
                    if (t3!=t1 && t3!=t2){
                        h3.stop();
                        contador++;
                    }
                    break;
                }
                case 3:{
                    if (t4!=t1 && t4!=t2 && t4!=t3){
                        h4.stop();
                        btn.setText("Generar");
                        btn.setStyle("-fx-background-color:white;-fx-text-fill:black");
                        contador=0;
                    }
                    break;
                }
            }

        }
    }
}
