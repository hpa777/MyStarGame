package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;

public class Logo extends Sprite {

    private Vector2 touch;
    private Vector2 speed;

    private final float V_LEN = .1f;

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
        setHeightProportion(.1f);
        pos.set(0f, 0f);
        speed = new Vector2();
        touch = new Vector2(pos);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        if (touch.dst(pos) > V_LEN) {
            pos.add(speed);
        } else {
            pos.set(touch);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch = touch;
        speed.set(touch.cpy().sub(pos)).scl(V_LEN);
        return false;
    }
}
