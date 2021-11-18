package uet.oop.bomberman;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import uet.oop.bomberman.entities.movingentities.Bomber;

public class Board {
        private Scene scene;

       // private boolean up, down, left, right, bombSetting;

        public Board(Group root) {
                scene = new Scene(root);
                // Listen to the input

        }

        public void initializeInput(Bomber bomberman) {
                scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent event) {
                                switch (event.getCode()) {
                                        case UP:
                                        case W:
                                                bomberman.setUp(true); break;
                                        case DOWN:
                                        case S:
                                                bomberman.setDown(true); break;
                                        case LEFT:
                                        case A:
                                                bomberman.setLeft(true); break;
                                        case RIGHT:
                                        case D:
                                                bomberman.setRight(true); break;
                                        case SPACE:
                                        case ENTER:
                                                bomberman.setBombSetting(true); break;
                                }
                        }
                });
                scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent event) {
                                switch (event.getCode()) {
                                        case UP:
                                        case W:
                                                bomberman.setUp(false); break;
                                        case DOWN:
                                        case S:
                                                bomberman.setDown(false); break;
                                        case LEFT:
                                        case A:
                                                bomberman.setLeft(false); break;
                                        case RIGHT:
                                        case D:
                                                bomberman.setRight(false); break;
                                        case SPACE:
                                        case ENTER:
                                                bomberman.setBombSetting(false); break;
                                }
                        }
                });
        }
        public Scene getScene() {
                return scene;
        }
}

