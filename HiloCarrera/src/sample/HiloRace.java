package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class HiloRace extends Thread{

    private long time;
    private ImageView image;
    private String id;
    private Label label;

    public HiloRace(ImageView image, long time, String id, Label label){
        this.image=image;
        this.time=time;
        this.id=id;
        this.label=label;
    }

    @Override
    public void run(){
        while(true){
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        if (image.getLayoutX()<700 && image.getLayoutY()<400){
                            image.setLayoutX(image.getLayoutX()+10);
                        }

                        if (image.getLayoutX()>690){
                            if (id.equals("liebre")){stop(); label.setText("La liebre se durmio");}

                             if(image.getLayoutY()<400){
                                 image.setLayoutY(image.getLayoutY()+10);
                             }
                        }

                        if(image.getLayoutY()>390){
                            if (image.getLayoutX()>210){
                                image.setLayoutX(image.getLayoutX()-10);
                            }else{stop(); label.setText("La tortuga llego a la meta");}


                        }

                        System.out.println(image.getLayoutX()+" "+image.getLayoutY());

                    }
                });
                Thread.sleep(time);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
