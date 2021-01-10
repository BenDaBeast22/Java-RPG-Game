import processing.core.PApplet;

//The exam class creates exam objects that only become collectable and visible after collecting all 3 tests on the map
//After collecting all three tests and then collecting the exam the exam object triggers the win game and you Win!!!

public class Exam extends PApplet{
	float x,y,w,h; //The position, width and height of the exam object
	boolean disappear; //Whether the exam is visible or not
	int testCounter = 0; //Counts the amount of exams you collected
	boolean collectable = false; //Whether the exam is collectable or not depending on if you collected all tests
	private PApplet app;
	Exam(PApplet p,float xpos,float ypos, float ewidth, float eheight){
		this.app = p;
		x = xpos;
		y = ypos; 
		w = ewidth;
		h = eheight;
		disappear = false;
	}
	/**
	 * Displays the exam object if all tests have been collected
	 */
	public void display(){
		if(disappear == false){
			if(testCounter == 3){
				//fill(255,0,0);
				app.image(app.loadImage("exam pixel art.png"),x,y,w,h);
			}
		}
		
  
	}
	/**
	 * Whether the exam is collectable or not
	 */
	public void Collectable() {
		if(testCounter == 3) {
			collectable = true;
		}
		else {
			collectable = false;
		}
	}
	/**
	 * Counts the amount of test objects collected
	 */
	public void testCount() {
		testCounter+=1;
	}
	
  
}
