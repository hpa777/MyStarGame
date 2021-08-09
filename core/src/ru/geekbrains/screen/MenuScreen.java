package ru.geekbrains.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.ExitButton;
import ru.geekbrains.sprite.Logo;
import ru.geekbrains.sprite.PlayButton;
import ru.geekbrains.sprite.Star;

public class MenuScreen extends BaseScreen {

    private static final int STAR_COUNT = 256;

    private final Game game;

    public MenuScreen(Game game) {
        this.game = game;
    }

    private Texture backgroundImage;
    private Background background;

    private TextureAtlas atlas;

    private Star[] stars;

    private ExitButton exitButton;
    private PlayButton playButton;

    @Override
    public void show() {
        super.show();
        backgroundImage = new Texture("star-wars-space-background.jpg");
        background = new Background(backgroundImage);
        atlas = new TextureAtlas("textures/menuAtlas.tpack");

        stars = new Star[STAR_COUNT];
        for (int i=0; i< STAR_COUNT; i++) {
            stars[i] = new Star(atlas);
        }

        exitButton = new ExitButton(atlas);
        playButton = new PlayButton(atlas, game);
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        exitButton.resize(worldBounds);
        playButton.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        exitButton.touchDown(touch, pointer, button);
        playButton.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        exitButton.touchUp(touch, pointer, button);
        playButton.touchUp(touch, pointer, button);
        return false;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    private void update(float delta) {
        for (Star star: stars) {
            star.update(delta);
        }
    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        for (Star star: stars) {
            star.draw(batch);
        }
        exitButton.draw(batch);
        playButton.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();

        backgroundImage.dispose();
        atlas.dispose();
    }
}
