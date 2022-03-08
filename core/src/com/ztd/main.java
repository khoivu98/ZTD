package com.ztd;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Zombie zombie;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("bg_lab.png"));
		zombie = new Zombie(300, 300);
	}

	@Override
	public void render () {
		Update();

		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		zombie.Draw(batch);
		batch.end();
	}

	public void Update(){
		zombie.Update();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
