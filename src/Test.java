import processing.core.PApplet;
import processing.core.PImage;

//This class creates 3 test objects that must be collected in order for the exam object to become visible and collectable so that you can win the game

public class Test extends PApplet{
	float x,y,w,h; // Position width and height of the test
	boolean disappear; //Whether the test is visible or not
	private PApplet app;
	/**
	 * Creates a test object
	 * @param p - PApplet graphics
	 * @param xpos - xposition of the test
	 * @param ypos - yposition of the test
	 * @param widthp - the width of the test
	 * @param heightp - the height of the test
	 */
	/**
	 */
	Test(PApplet p,float xpos, float ypos, float widthp, float heightp){
		this.app = p;
		x = xpos; 
		y = ypos;
		w = widthp;
		h = heightp; 
		disappear = false;
	}
	/**
	 * Displays the test object if it has noto been collected yet 
	 */
	public void display(){
		if(disappear == false){
			//fill(255);
			//rect(x,y,w,h);
			//image(test,x,y,w,h);
			app.image(app.loadImage("paper pixel art.png"),x,y,w,h);
		}
		//void display2(){
		//if(disappear == false){
		//fill(255,255,0);
		//ellipse(x+8,y+8,w,h);
    
		// }
    }

}
