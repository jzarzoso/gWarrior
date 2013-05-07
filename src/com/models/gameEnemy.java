package com.models;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import android.util.Log;

import com.badlogic.gdx.math.Vector2;
import com.commons.gameCommons;
import com.parts.gameAnimatedPart;

public class gameEnemy extends gameWarrior{
	
	public gameEnemy(int tid,int tX,int tY,String tname,TiledTextureRegion tTTexture)
	{
		this.id=tid;
		this.name=tname;
		this.body=new gameAnimatedPart(tX,tY,5,tTTexture);
		
		// Anadimos la imagen del cuerpo como parte del Warrior
		this.parts.add(body);
		
		// Starts thread associated to enemy
		Thread AI = new Thread(this);
        AI.start();
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
		try {
			

	         while(true)
	         {
	 		    //**** Venga ara determina el angle en funcio del player
	 			Vector2 resultv=new Vector2(this.body.getX(),this.body.getY());
	 			Vector2 b=new Vector2(gameCommons.targetPlayer.body.getX(), gameCommons.targetPlayer.body.getY());
	 			
	 			// Resta los dos vectores guarda resultado en resultv
	 			resultv.sub(b);

	 			double angle = 0;

	 			
	             if (resultv.x < 0 && resultv.y > 0) 
	             {
	                 angle = (Math.toDegrees(Math.atan((resultv.y / resultv.x)))) + 180;
	             }  		
	                 else if  (resultv.x < 0 && resultv.y < 0) 
	                 {
	                 	angle = (Math.toDegrees(Math.atan((resultv.y / resultv.x)))) + 180;
	                 }
	                 
	                 else if   (resultv.x > 0 && resultv.y < 0) 
	                 {
	                 	angle = (Math.toDegrees(Math.atan((resultv.y / resultv.x)))) + 360;
	                 }
	                 else
	                 	angle = (Math.toDegrees(Math.atan((resultv.y / resultv.x))));
	             

	            this.body.setRotation((float) (angle - 270));
	            
	            
	            
	            //Log.d(gameCommons.cTag ,"thread "+Thread.currentThread().getName()+" step "+i);
	            //Thread.sleep(500);
	            
	         }
	         
	      } catch (Throwable t) { }
	}
	




}
