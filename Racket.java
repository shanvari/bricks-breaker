import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Bounds;

 public class Racket{
	 Rectangle rectangle ;
	private int width ;

	  Racket(Pane pane){
		  width = 120;
		rectangle = new Rectangle(300,520,width ,30);
		rectangle.setFill(Color.GREEN);
    	rectangle.setArcHeight(15);
    	rectangle.setArcWidth(15);
		createBounds(rectangle.getBoundsInParent());
    	pane.getChildren().add(rectangle);
		 }
	  int getWidth(){
		 return width ;
		 }
	  void setWidth(int a){
		rectangle.setWidth(a);
		}
	int getX(){
		return (int)rectangle.getX();
		}
	void setX(double x , int WIDTH){
		if(x < WIDTH - this.width && x > 0)	rectangle.setX(x );
		else if(x <= 0)	rectangle.setX(0);
		else	rectangle.setX(WIDTH - width);
		}
	int getY(){
		return (int)rectangle.getY();
		}
	void setY(double x , int WIDTH){
		rectangle.setY(x );
		}

   void  createBounds(Bounds bounds) {
        rectangle.setX(bounds.getMinX());
        rectangle.setY(bounds.getMinY());
        rectangle.setWidth(bounds.getWidth());
        rectangle.setHeight(bounds.getHeight());
      }
	 }