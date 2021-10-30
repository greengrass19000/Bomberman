package uet.oop.bomberman.entities.movingentities;

import uet.oop.bomberman.input.Keyboard;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


public class Bomber extends movingentity {
    protected Keyboard input;
    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {
        movement();
    }

    protected void movement() {

    }


}
