import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Gift{
static int counter//for timer
,chance //number of al prizes
, i;
static boolean sw  ;

Gift(Ball ball){
//	speed
	sw = true ;
	chance ++ ;
	Timer timer = new Timer();
	timer.scheduleAtFixedRate(new TimerTask(){
	public void run() {
	if(counter <= 15 ){
		counter++;
		System.out.println(counter);
		if(sw){
		ball.setSpeedY(ball.getSpeedY() / 2);
		ball.setSpeedX(ball.getSpeedX() / 2);
		ball.circle.setFill(Color.RED);
		sw = false ;
					System.out.println("ball");
		}
	}
	else{
		ball.circle.setFill(Color.BLUE);
		ball.setSpeedY(ball.getSpeedY() * 2);
		ball.setSpeedX(ball.getSpeedX() * 2);
	}
	}//run
	}, new Date(), 1000);
}
Gift (Racket racket ,Ball ball){
	//width
	chance ++ ;
	Timer timer = new Timer();
	timer.scheduleAtFixedRate(new TimerTask(){
	public void run() {
	if(counter <= 10 ){
		counter++;
		System.out.println(counter);
		racket.setWidth(240);
		ball.circle.setFill(Color.RED);
		System.out.println("racket");

	}
	else{
	racket.setWidth(120);
	ball.circle.setFill(Color.BLUE);
	}
	}//run
	}, new Date(), 1000);
}

Gift(ArrayList <Brick> bricks, Pane pane , Ball ball){
//score
	counter = 0;
	sw = true ;
	chance ++ ;
	Timer timer = new Timer();
	timer.scheduleAtFixedRate(new TimerTask(){
	public void run() {
	if(counter <= 20 ){
					System.out.println(counter);
		counter++;
		if(sw){
		for(i = 0 ; i < 100 ; i++)
			bricks.get(i).sw = true;
		ball.circle.setFill(Color.RED);
		System.out.println("brick");
		sw = false ;
		}
	}
	else{
		for(i = 0 ; i < 100 ; i++)
			bricks.get(i).sw = false;
		ball.circle.setFill(Color.BLUE);
	}
	}//run
	}, new Date(), 1000);
}

}