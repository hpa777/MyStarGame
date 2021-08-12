package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;


public class MainShip extends Sprite {

    private Vector2 touch;
    private Vector2 speed;

    private final float V_LEN = .001f;

    private Rect worldBounds;

    private boolean pressed;

    public MainShip(TextureRegion region) {
        super(region);
        speed = new Vector2();
        touch = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        float height = 0.1f;
        setHeightProportion(height);
        pos.set(0, 0);
        setBottom(worldBounds.getBottom() + .1f);
    }

    @Override
    public void update(float delta) {
        if (pressed && getLeft() >= worldBounds.getLeft() && getRight() <= worldBounds.getRight()) {
            pos.add(speed);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.pressed = true;
        speed.set(touch.cpy().sub(pos)).setLength(V_LEN);
        speed.y = 0;
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        stopMove();
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == 21) {
            speed.set(0 - V_LEN, 0);
            pressed = true;
        }
        if (keycode == 22) {
            speed.set(V_LEN, 0);
            pressed = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == 21 || keycode == 22) {
            stopMove();
        }
        return false;
    }

    private void stopMove() {
        this.pressed = false;
        if (getLeft() < worldBounds.getLeft()) {
            setLeft(worldBounds.getLeft());
        }
        if (getRight() > worldBounds.getRight()) {
            setRight(worldBounds.getRight());
        }
    }
}
