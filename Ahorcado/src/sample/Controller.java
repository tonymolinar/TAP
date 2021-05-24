package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Optional;
import java.util.Random;

public class Controller {

    int error=0;

    @FXML HBox contenedor;
    @FXML AnchorPane padre;
    String[] palabras = {"CARTA","SOLDADO","PANTALLA","LUZ","DESIERTO","GRANJA","JAULA"};
    TextField[] arraytxt =  null;
    @FXML protected void initialize(){
        Random random = new Random();
        int aleatorio = random.nextInt(6);
        String palabra = palabras[aleatorio].toLowerCase();
        System.out.println(palabra);
        arraytxt = new TextField[palabra.length()];
        for (int x=0;x<palabra.length();x++){
            arraytxt[x] = new TextField();
            arraytxt[x].setPrefWidth(50);
            arraytxt[x].setPrefHeight(50);
            arraytxt[x].setAlignment(Pos.CENTER);
            arraytxt[x].setFont(new Font(20));
            arraytxt[x].setId("txt-"+x+"-"+palabra.charAt(x));
            String ayuda = palabra.charAt(0)+"";
            arraytxt[0].setText(ayuda);
            arraytxt[0].setDisable(true);
            arraytxt[x].setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    TextField textField = (TextField) keyEvent.getTarget();
                    String[] nombre = textField.getId().split("-");
                    if (nombre[2].equals(textField.getText().toLowerCase())){
                        System.out.println("CORRECTO "+textField.getId());
                        textField.setDisable(true);
                    }else{
                        System.out.println("INCORRECTO "+textField.getId());
                        textField.setText("");
                        pintarCuerpo();
                    }
                }
            });
            contenedor.getChildren().add(arraytxt[x]);
        }
    }



    public void pintarCuerpo(){
        error++;
        if (error>0){
            ImageView cabeza = new ImageView(new Image("sample/img/cabeza.png"));
            cabeza.setFitHeight(80);
            cabeza.setFitWidth(80);
            cabeza.setLayoutX(210);
            cabeza.setLayoutY(200);
            padre.getChildren().add(cabeza);
        }
        if (error>1){
            ImageView cuerpo = new ImageView(new Image("sample/img/cuerpo.png"));
            cuerpo.setFitHeight(80);
            cuerpo.setFitWidth(80);
            cuerpo.setLayoutX(210);
            cuerpo.setLayoutY(280);
            padre.getChildren().add(cuerpo);
        }
        if (error>2){
            ImageView brazos = new ImageView(new Image("sample/img/brazos.png"));
            brazos.setFitHeight(80);
            brazos.setFitWidth(80);
            brazos.setLayoutX(210);
            brazos.setLayoutY(280);
            padre.getChildren().add(brazos);
        }
        if (error>3){
            ImageView piernas = new ImageView(new Image("sample/img/piernas.png"));
            piernas.setFitHeight(80);
            piernas.setFitWidth(80);
            piernas.setLayoutX(210);
            piernas.setLayoutY(360);
            padre.getChildren().add(piernas);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Perdiste");
            alert.setContentText("Se te acabaron los intentos");
            alert.showAndWait();
            System.exit(0);

        }






    }
}
