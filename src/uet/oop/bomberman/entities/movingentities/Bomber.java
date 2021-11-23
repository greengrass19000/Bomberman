package uet.oop.bomberman.entities.movingentities;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.MovingEntity;
import uet.oop.bomberman.graphics.Sprite;

import uet.oop.bomberman.sound.Sound;


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
        if (xa != 0 || ya != 0) {
            moving = true;
            changeDirection(xa, ya);
            if(direction == 0 || direction == 2) {
                if(animate % 20 == 0)
                    Sound.play("verticalmove");
            } else {
                if (animate % 20 == 0)
                    Sound.play("horizonalmove");
            }
        } else {
            if(moving) {
                Sound.stop("verticalmove");
                Sound.stop("horizonalmove");
                moving = false;
            }
        }
        //This's just for testing
        if(!canMove(x + xa, y + ya)) {
            if(!canMove2(x + xa, y, xa) && !canMove2(x, y + ya, xa)) {
                return;
            }
        }


        if (xa != 0 || ya != 0) {
            //Todo: Change the bomber's speed after obtaining the "speed" ability.
            move(xa, ya);
            moving = true;
        }
    }
    //Make the character can slide
    public boolean canMove2(double xa, double ya, double a) {
        if (xa < 32 || ya < 32 || xa > (WIDTH - 2) * 32 || ya > (HEIGHT - 2) * 32) {
            return false;
        }
        double tmpy = ya % 64;
        double tmpx = xa % 64;
        if (tmpy > 22 && tmpy < 32) {
            if(tmpx > 22 && tmpx < 50) {
                ++y;
                return true;
            }
            if(x % 64 < 45) {
                ++y;
                return true;
            }
            return false;
        }
        if (tmpy > 32 && tmpy < 42) {
            if(tmpx > 22 && tmpx < 50) {
                --y;
                return true;
            }
            if (tmpx < 50) {
                --y;
                return true;
            }
            return false;
        }
        if(tmpx > 22 && tmpx < 32) {
            ++x;
            return true;
        }
        if(tmpx > 32 && tmpx < 50) {
            --x;
            return true;
        }
        return false;
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
            if (x % 64 < 32 || x % 64 > 40) {
                return false;
            }
        }
        return true;
    }
    public void changeDirection(double xa, double ya) {
        if (xa > 0) direction = 1;
        if (xa < 0) direction = 3;
        if (ya > 0) direction = 2;
        if (ya < 0) direction = 0;
    }

    @Override
    public void move(double xa, double ya) {
        //TODO Make the bomber slide
        y += ya;
        x += xa;
        if(animate % 20 == 0) {
            Sound.play("horizonalmove");
        }
    }

    private void chooseSprite() {
        switch (direction) {
            case 0:
                img = Sprite.player_up.getFxImage();
                if (moving) {
                    img = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, animate, 20).getFxImage();
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