package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture backgroundImage;
    private Vector2 pos;
    private Vector2 speed;
    private Vector2 mousePos;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        backgroundImage = new Texture("star-wars-space-background.jpg");
        pos = new Vector2();
        speed = new Vector2();
        mousePos = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(backgroundImage, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        pos.add(speed);
        if (Vector2.dst(mousePos.x, mousePos.y, pos.x, pos.y) < 1f) {
            speed.set(0, 0);
        }
        batch.draw(img, pos.x, pos.y);
        batch.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        mousePos.set(screenX, Gdx.graphics.getHeight() - screenY);
        speed.set(mousePos.cpy().sub(pos).nor());
        return false;
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        backgroundImage.dispose();
    }
}
