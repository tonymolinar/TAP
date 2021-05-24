package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML Label label;
    @FXML ImageView liebre;
    @FXML ImageView tortuga;
    Hilo hilo1;
    HiloRace hiloliebre;
    HiloRace hilotortuga;


    public void iniciar(ActionEvent event){
        //hilo1=new Hilo(label);
        //hilo1.start();

        hiloliebre=new HiloRace(liebre,50,"liebre",label);
        hilotortuga=new HiloRace(tortuga,100,"tortuga",label);

        hiloliebre.start();
        hilotortuga.start();

    }
    public void detener(ActionEvent event){
        //hilo1.stop();
    }
}
