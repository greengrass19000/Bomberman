package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public abstract class MovingEntity extends Entity {
    protected int _animate = 0;
    protected final int MAX_ANIMATE = 7500;
    protected int direction = 1;
    protected boolean isMoving = false;
    protected boolean isAlive = true;


    public MovingEntity(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    protected void animate() {
        if(_animate < MAX_ANIMATE) _animate++; else _animate = 0;
    }

    protected abstract void movement();

    protected abstract void move(double xa, double ya);
}
