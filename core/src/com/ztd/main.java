package com.ztd;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

import sun.jvm.hotspot.utilities.BitMap;

public class main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	static ArrayList<Zombie> zombies  = new ArrayList<Zombie>();
	Random r = new Random();
	BitmapFont bitmapFont;

	@Override
	public void create () {
		bitmapFont = new BitmapFont();
		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("bg_lab.png"));
	}

	@Override
	public void render () {
		Update();

		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		bitmapFont.draw(batch, "" + UI.wave, 15, 575);
		for(Zombie z : zombies) z.Draw(batch);
		batch.end();
	}

	public void Update(){
		SpawnZombies();
		for(Zombie z : zombies) z.Update();

		HouseKeeping();
	}

	public void HouseKeeping(){
		for(Zombie z : zombies) if(!z.isActive) {zombies.remove(z); break;}
	}

	public void SpawnZombies(){
		if(zombies.size() > 0 )
			return;

		UI.wave++;
		for(int i = 0; i < 10; i++){
			zombies.add(new Zombie(1024 + (i * 70), r.nextInt(400)));
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
