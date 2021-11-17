package uet.oop.bomberman.entities.movingentities;

import uet.oop.bomberman.entities.MovingEntity;
import uet.oop.bomberman.BombermanGame;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


import java.awt.Canvas;


public class Bomber extends MovingEntity {

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        movement();
    }

    protected void movement() {
        int xa = 0, ya = 0;
        if (isUp()) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;

        //This's just for testing
        if(!canMove(x + xa, y + ya))
            return;

        if (xa != 0 || ya != 0) {
            //Todo: Change the bomber's speed after obtaining the "speed" ability.
            move(xa, ya);
            isMoving = true;
        } else {
            isMoving = false;
        }
    }

    public boolean canMove(double x, double y) {
        //Todo: Decide when it can move and when it can't as well.
        if (x < 0 || y < 0 || x > WIDTH * 32 || y > HEIGHT * 32) {
           return false;
        }
        return true;
    }

    @Override
    public void move(double xa, double ya) {
        if (xa > 0) direction = 1;
        if (xa < 0) direction = 3;
        if (ya > 0) direction = 2;
        if (ya < 0) direction = 0;

        if (canMove(0, ya)) { //separate the moves for the player can slide when is colliding
            y += ya;
        }

        if (canMove(xa, 0)) {
            x += xa;
        }
    }
}