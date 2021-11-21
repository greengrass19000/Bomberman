package uet.oop.bomberman.entities.movingentities;

import uet.oop.bomberman.entities.MovingEntity;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.sound.Sound.play;


public class Bomber extends MovingEntity {

    public boolean up, down, left, right, bombSetting;
    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setBombSetting(boolean bombSetting) {
        this.bombSetting = bombSetting;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    @Override
    public void update() {
        movement();
        animate();
        chooseSprite();
    }

    protected void movement() {
        int xa = 0, ya = 0;
        if (up) ya--;
        if (down) ya++;
        if (left) xa--;
        if (right) xa++;

        //This's just for testing
        if(!canMove(x + xa, y + ya))
            return;

        if (xa != 0 || ya != 0) {
            //Todo: Change the bomber's speed after obtaining the "speed" ability.
            move(xa, ya);
            moving = true;
        } else {
            moving = false;
        }
    }

    public boolean canMove(double x, double y) {
        //Todo: Decide when it can move and when it can't as well.
        if (x < 32 || y < 32 || x > (WIDTH - 2) * 32 || y > (HEIGHT - 2) * 32) {
           return false;
        }
        //Todo: Làm nhân vật bị cản
        //System.out.print(((int)(x) % 64)+ " " + ((int)y) % 64 + '\n');
        if (y % 64 != 32) {
            //TODO: Make the character can slide
            if (x % 64 < 32 || x % 64 > 41) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void move(double xa, double ya) {
        if (xa > 0) direction = 1;
        if (xa < 0) direction = 3;
        if (ya > 0) direction = 2;
        if (ya < 0) direction = 0;
        y += ya;
        x += xa;
        play();
        //TODO Make the bomber slide
    }

    private void chooseSprite() {
        switch (direction) {
            case 0:
                img = Sprite.player_up.getFxImage();
                if (moving) {
                    img = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, animate, 20).getFxImage();
                }
                break;
            case 1:
                img = Sprite.player_right.getFxImage();
                if (moving) {
                    img = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, animate, 20).getFxImage();
                }
                break;
            case 2:
                img = Sprite.player_down.getFxImage();
                if (moving) {
                    img = Sprite.movingSprite(Sprite.player_down_1, Sprite.player_down_2, animate, 20).getFxImage();
                }
                break;
            case 3:
                img = Sprite.player_left.getFxImage();
                if (moving) {
                    img = Sprite.movingSprite(Sprite.player_left_1, Sprite.player_left_2, animate, 20).getFxImage();
                }
                break;
            default:
                img = Sprite.player_right.getFxImage();
                if (moving) {
                    img = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, animate, 20).getFxImage();
                }
                break;
        }
    }
}