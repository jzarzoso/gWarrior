package com.models;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import com.commons.gameObject;
import com.parts.gameAnimatedPart;

public class gameShoot extends gameObject{

	public gameAnimatedPart shootBody;
	
	public gameShoot(int tid,float tX_parent,float tY_parent,TiledTextureRegion tTTexture,float trotation_parent,float tvelocity)
	{
		this.id=tid;
		
		float tfinal_X=0;
		float tfinal_Y=0;

	    tfinal_X=tX_parent + (float) (40 * Math.cos(Math.toRadians(trotation_parent) - Math.toRadians(270)));
		tfinal_Y=tY_parent + (float) (40 * Math.sin(Math.toRadians(trotation_parent) - Math.toRadians(270)));
	    
		this.shootBody=new gameAnimatedPart(tfinal_X,tfinal_Y,10,tTTexture);
		this.shootBody.setRotation(trotation_parent);
		this.shootBody.oPhysicsHandler.setVelocity((float)(Math.cos(Math.toRadians(trotation_parent) + Math.toRadians(-90))*-tvelocity), (float)(Math.sin(Math.toRadians(trotation_parent) + Math.toRadians(-90)))*-tvelocity);
		
	}
	
	@Override
	public void move(float tvelocity) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

}
