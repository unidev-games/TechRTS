package com.wkingtechrts.mygdxgame.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Buildings {

	public int x;
	public int y;
	public boolean isSelected = false;
	public BuildingType type;
	
	private Sprite sprite;
	private Texture texture;
	
	public Buildings(int posx, int posy, BuildingType bt)
	{
		x = posx;
		y = posy;
		type = bt;
		
		switch(bt)
		{
			case CASTLE:texture = new Texture(Gdx.files.internal("data/debug/buildings/castle.png"));break;
			case RESOURCE:texture = new Texture(Gdx.files.internal("data/debug/buildings/farm.png"));break;
					
			default:break;
		}
		TextureRegion tr = new TextureRegion(texture,0,0,texture.getWidth(),texture.getHeight());
		sprite = new Sprite(tr);
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setSize(2, 2);
		sprite.setPosition(x, y);
	}
	
	public boolean isSelected()
	{
		return isSelected;
	}
	
	public void toggleSelect()
	{
		if(isSelected)
		{
			isSelected = false;
		}else{
			isSelected = true;
		}
	}
	
	public Sprite getSprite()
	{
		return sprite;
	}
	
	public boolean onScreen(int sx, int ex, int sy, int ey)
	{
		if(this.sprite.getX() >= sx && this.sprite.getX() <= ex)
			if(this.sprite.getY() >= sy && this.sprite.getY() <= ey)
				return true;
		return false;
	}
}
