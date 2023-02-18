import java.util.Scanner;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.geometry.Bounds;

public class Ball{
	private int level ;
	private float speedX , speedY ;
	void setLevel(int a){
		level = a ;
		speedX = a;
		speedY = a ;
		}
	 Circle circle;

	float getSpeedX(){
		return speedX;
		}
	void setSpeedX(float speed){
		speedX = level * speed ;
		while(speedX > level * 2){
		speedX -= level ;
		}
		while(speedX < level * -1 * 2){
		speedX += level ;
		}
		}
	float getSpeedY(){
		return speedY;
		}
	void setSpeedY(float speed){
		speedY = level * speed ;
		while(speedY > level * 2){
		speedY -= level ;
		}
		while(speedY < level * -1 *2){
		speedY += level ;
		}
		}
	float getX(){
		return (float) circle.getCenterX();
		}
	float getY(){
		return (float) circle.getCenterY();
	}
	void setX(float x){
		circle.setCenterX(x) ;
		}
	void setY(float y){
		circle.setCenterY(y) ;
		}
	Ball(Pane pane){
		circle = new Circle(50 ,350 ,10);
		circle.setFill(Color.BLUE);
		pane.getChildren().add(circle);
	}
	   void  createBounds(Bounds bounds) {
	        circle.setCenterX(bounds.getMinX());
	        circle.setCenterY(bounds.getMinY());
	        circle.setRadius(bounds.getWidth());
      }
}