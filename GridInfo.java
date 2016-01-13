package myGUIEngine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GridInfo {

	private int xSize;
	private int ySize;
	
	private int[] gridTextures;
	
	private char[] textureKey;
	
	private char[][] grid;
	
	//Constructor
	public GridInfo(String gridFile){
		readGridInfo(gridFile);
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
	// The first line of the file should have the number of keys, n, then
	// followed by n lines with a single character, representing the keys
	public void readKeyInfo(String location){
		try{
			BufferedReader in = new BufferedReader (new FileReader (location));
			
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
	
	// Method to read information for the grid layout
	// The first two lines should have the x and y sizes of the grid, then
	// followed by a grid of x by y dimensions
	public void readGridInfo(String gridFile){
		try{
			BufferedReader in = new BufferedReader (new FileReader (gridFile));
			
			xSize = Integer.parseInt(in.readLine());
			ySize = Integer.parseInt(in.readLine());
			
			// Variable for temporarily holding the current string
			String holder;
			
			for(int i = xSize; i >= 0; i--){
				
				holder = in.readLine();
				
				for(int k = 0; k < ySize; k++){
					grid[i][k] = holder.charAt(k); 
				}
			}
			
			in.close();
		}catch(IOException iox){
			iox.printStackTrace();
		}
	}
	
	// Method to load the textures
	public void loadTextures(String location, String fileName,
			String extension){
		gridTextures = new int[textureKey.length];
		
		String[] textureLocations = new String[gridTextures.length];
		for(int i = 0; i < textureLocations.length; i++){
			textureLocations[i] = location + fileName + i + extension;
		}
		
		gridTextures = TextureLoader.loadTextures(textureLocations);
	}
	
	// Method to give the corresponding tile texture at a given coordinate
	public int textureAt(int xCor, int yCor){
		return getCorrespondingTexture(grid[xCor][yCor]);
	}
	
	// Method to give the corresponding tile texture given a key
	private int getCorrespondingTexture(char key){
		for(int i = 0; i < textureKey.length; i++){
			if (textureKey[i] == key){
				return gridTextures[i];
			}
		}
		return -1;
	}
}
