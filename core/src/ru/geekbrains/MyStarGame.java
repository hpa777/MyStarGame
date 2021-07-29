package ru.geekbrains;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyStarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture backgroundImage;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		backgroundImage = new Texture("star-wars-space-background.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(backgroundImage, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		backgroundImage.dispose();
	}
}
