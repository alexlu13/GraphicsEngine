package myGUIEngine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GridInfo {

	private int xSize;
	private int ySize;
	
	private int[] gridTextures;
	
	private char[] textureKey;
	
	
	//Constructor
	public GridInfo(int xSize, int ySize){
		this.xSize = xSize;
		this.ySize = ySize;
	}
	
	//Accessors and mutators
	public int getXSize(){
		return xSize;
	}
	
	public int getYSize(){
		return ySize;
	}
	
	public void setXSize(int xSize){
		this.xSize = xSize;
	}
	
	public void setYSize(int ySize){
		this.ySize = ySize;
	}
	
	public void setGridTextures(int[] gridTextures){
		this.gridTextures = gridTextures;
	}
	
	// Method used to read information for the grid texture key
	// Note that the texture key should be mapped such that textureKey[0]
	// has the corresponding grid texture at gridTexture[0]
	public void readKeyInfo(String location){
		try{
			BufferedReader in = 
					new BufferedReader (new FileReader (location));
			
			int numKeys = (Integer.parseInt(in.readLine()));
			textureKey = new char[numKeys];
			
			for(int i = 0; i < numKeys; i++){
				textureKey[i] = in.readLine().charAt(0);
			}
			
			in.close();
			
		}catch(IOException iox){
			iox.printStackTrace();
		}
	}
	
}
