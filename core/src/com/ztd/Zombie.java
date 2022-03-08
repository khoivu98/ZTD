package com.ztd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Zombie {
    int x, y, w, h;
    Texture texture;
    boolean isActive = true;

    //Animation stuff
    Animation anim;
    TextureRegion[] frames;
    TextureRegion frame;
    float frameTime = 0.2f;
    int cols = 4, rows = 1;

    Zombie(int x, int y){
        this.x = x;
        this.y = y;
        texture = new Texture(Gdx.files.internal("Zombies.png"));
        w = texture.getWidth()/cols;
        h = texture.getHeight()/rows;
        InitAnimation();
    }

    void InitAnimation() {
        //Splits texture into individual cells
        TextureRegion[][] sheet = TextureRegion.split(texture, w, h);

        //Init number of frames to total frames created (vertical + horizontal)
        frames = new TextureRegion[rows * cols];

        //Loop through sheets and fill frames array in order
        int index = 0;
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++)
                frames[index++] = sheet[r][c];

            anim = new Animation(frameTime, frames);
    }

    void Update(){
        x -= 3;
        isActive = !(x < -w);

    }

    void Draw(SpriteBatch spriteBatch){
        frameTime += Gdx.graphics.getDeltaTime();
        frame = (TextureRegion)anim.getKeyFrame(frameTime, true);
        spriteBatch.draw(frame, x, y, w, h);
    }
}
