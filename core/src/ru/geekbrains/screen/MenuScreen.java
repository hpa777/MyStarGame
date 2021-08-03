package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture backgroundImage;

    private Background background;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        backgroundImage = new Texture("star-wars-space-background.jpg");
        background = new Background(backgroundImage);


    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        batch.end();
    }


    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        backgroundImage.dispose();
    }
}
