import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.geometry.Bounds;

 public class Brick{
	private byte color ;
	private int score = 1;
	int gold = 0 ;
	boolean prize;
	boolean sw = false;
	Text text;
	Rectangle rectangle ;
	 int getScore(){
		 return score;
		 }
void setScore(int a , Pane pane){
//remove zero score bricks
if(sw)gold += 2;
else gold ++ ;
score = a ;
	if(score == 0){
		pane.getChildren().remove(rectangle);
		pane.getChildren().remove(text);
		}
		 else if (score > 0){
			text.setText(String.valueOf(score));
			}
	//	if(score < )
		 }
	int getX(){
		return (int) rectangle.getX();
		}
	int getY(){
		return (int) rectangle.getY() ;
		}
	//Rectangle getRectangle(){
	//	return rectangle ;
		//}
	 Brick(int a , int b , Pane pane){
		score = (int) (Math.random()* 5) + 1 ;
		rectangle = new Rectangle(a, b, 30, 30);
		rectangle.setStroke(Color.BLACK);
		text = new Text();
		text.setText(String.valueOf(score ));
		text.setX(a + 15);
		text.setY(b + 15);

		switch(((a + b * 2) / 30) % 5){
			case 1:{
			rectangle.setFill(Color.AQUA);
				break;
				}
			case 2:{
			rectangle.setFill(Color.VIOLET);
			break ;
			}
			case 3:{
			rectangle.setFill(Color.LIGHTGREEN);
				break;
				}
			case 4:{
			rectangle.setFill(Color.CORAL);
			break;
			}
			case 0:{
			rectangle.setFill(Color.LIGHTPINK);
			break;
			}
			}
			if((Math.random() * 10) > 8){
			rectangle.setFill(Color.GOLD);
			prize = true ;
				}
			createBounds(rectangle.getBoundsInParent());
			pane.getChildren().addAll(rectangle , text);
}
   void  createBounds(Bounds bounds) {
        rectangle.setX(bounds.getMinX());
        rectangle.setY(bounds.getMinY());
        rectangle.setWidth(bounds.getWidth());
        rectangle.setHeight(bounds.getHeight());
      }
	 }