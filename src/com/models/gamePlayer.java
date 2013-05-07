package com.models;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import com.parts.gameAnimatedPart;

public class gamePlayer extends gameWarrior{
	
	public gamePlayer(int tid,int tX,int tY,String tname,TiledTextureRegion tTTexture)
	{
		this.id=tid;
		this.name=tname;
		this.body=new gameAnimatedPart(tX,tY,5,tTTexture);
		
		// Anadimos la imagen del cuerpo como parte del Warrior
		this.parts.add(body);
	}

	@Override
	public void move(float tvelocity) {
		// Por todas las partes del Single player ....
		for (gameAnimatedPart curr_part : this.parts)
		{
			curr_part.oPhysicsHandler.setVelocity((float)(Math.cos(Math.toRadians(curr_part.getRotation()) + Math.toRadians(-90)))*-tvelocity, (float)(Math.sin(Math.toRadians(curr_part.getRotation()) + Math.toRadians(-90)))*-tvelocity);
			
		}
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void get() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set() {
		// TODO Auto-generated method stub
		
	}

	

	
	@Override
	public void rotate(int tdegree) {
		// Por todas las partes del Single player ....
		for (gameAnimatedPart curr_part : this.parts)
		{
			if (curr_part.getRotation()>=360) curr_part.setRotation(20);
			else 
			{						
				curr_part.setRotation(curr_part.getRotation()+tdegree);
			}
		}
		
	}

	
	// Thread BASE RUN
	public void run() {
		// TODO Auto-generated method stub
		// NOT USED IN SINGLE PLAYER
	}
	




}
