import java.lang.Math;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Bounds;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class BricksBracker extends Application{
	final int WIDTH = 600;
	final int HEIGHT = 600;
	public int gold = 0 ;
	KeyCode keyCode;
	static int counter = 0;

	private void endPage ( Pane pane , Stage stage , Scene scene){
	//end page
	Text text1 ;
	ImageView iv ;
	//check lose or win ; if sb wins the gold * -1 ;
	if(gold >= 0){
	Image img = new Image("screen.jpg");
	iv = new ImageView(img);
	iv.setFitHeight(600);
	iv.setFitWidth(600);
	text1 = new Text();
	text1.setText(String.valueOf(gold));
	text1.setX(320);
	text1.setY(313);
	text1.setFill(Color.YELLOW);
	text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
	pane.getChildren().add(iv);
	pane.getChildren().add(text1);
		}
	else{
	Image img = new Image("screen2.jpg");
	iv = new ImageView(img);
	iv.setFitHeight(600);
	iv.setFitWidth(600);
	text1 = new Text();
	text1.setText(String.valueOf(gold ));
	text1.setX(350);
	text1.setY(315);
	text1.setFill(Color.YELLOW);
	text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
	pane.getChildren().add(iv);
	pane.getChildren().add(text1);
	}
	stage.setScene(scene);

	}
public static void main(String[] args){
	        launch(args);
    }
public void start(Stage primaryStage){
//music
	String musicFile = "sound.mp3";
	Media sound = new Media(new File(musicFile).toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(sound);
    mediaPlayer.play();
//make objects
	int level = 1;
	int i = 0 , j = 0;
	Pane pane1 = new Pane();
	Pane pane2 = new Pane();
	Pane pane3 = new Pane();
	primaryStage.setTitle("Simple Bricks Bracker");
	Scene scene1 = new Scene(pane1,WIDTH,HEIGHT);
	Scene scene2 = new Scene(pane2,WIDTH,HEIGHT);
	Scene scene3 = new Scene(pane3,WIDTH,HEIGHT);
// start page
	Image img = new Image("start.jpg");
	ImageView iv = new ImageView(img);
	iv.setX(5);
	iv.setY(5);
	iv.setFitHeight(600);
	iv.setFitWidth(600);
	Image im = new Image("tik.jpg");
	ImageView tik = new ImageView(im);
	tik.setX(440);
	tik.setY(270);
	tik.setFitHeight(40);
	tik.setFitWidth(40);
	pane3.getChildren().addAll(iv , tik);

//game page
	Racket racket = new Racket(pane1);
	ArrayList <Brick> bricks = new ArrayList<Brick>();
	for(i=0 ; i<5 ; i++)
		for(j=0 ; j<20 ; j++){
			bricks.add (new Brick(j*30 ,i*30 , pane1));
		}
	Ball ball = new Ball(pane1);
//animation

AnimationTimer animationTimer = new AnimationTimer(){
	boolean sw = true ;
	byte x ;
	Gift gift;
	float a = 1;
	public void handle( long now){
	if(sw){
	x = 0 ;
	//test


	for(int i =0 ; i< 100 ; i++){
//hit bricks
	if(bricks.get(i).getScore() > 0)	x++;
	if(new Rectangle(ball.getX() - 10 , ball.getY() - 10 ,20,20).getBoundsInParent().intersects(bricks.get(i).rectangle.getBoundsInParent()) && bricks.get(i).getScore() > 0){
		bricks.get(i).setScore(bricks.get(i).getScore() - 1 , pane1);
		ball.setSpeedX(ball.getSpeedX() * -1);
		ball.setSpeedY(ball.getSpeedY() * -1);
		//find gifts
		if(bricks.get(i).prize == true && bricks.get(i).getScore() == 0){

			int x = (int)Math.random() +1;
			switch(x){
			case 0:{
			gift = new Gift(ball);
			break;
			}
			case 1:{
			gift = new Gift(racket ,ball);
			break;
			}
			case 2:{
			gift = new Gift(bricks , pane1 ,ball);
			break;
			}
		   }
		  }
		}
	}

//racket

	if(new Rectangle(ball.getX()- 10 , ball.getY()- 10 ,20,20).getBoundsInParent().intersects(racket.rectangle.getBoundsInParent())){
	a = (float)Math.sqrt( Math.abs(Math.tan(Math.toRadians((racket.getX() + racket.getWidth() - ball.getX()) * 60 / (racket.getWidth() / 2) + 30))));

	ball.setSpeedY(a * -1 );
	if((ball.getSpeedX() > 0 && ball.getX() - racket.getX() > racket.getWidth() / 2) || (ball.getSpeedX() < 0 && ball.getX() - racket.getX() < racket.getWidth() / 2) )
	{ball.setSpeedX( 1 / a  );
}
	else 	ball.setSpeedX( -1 / a  );
	}
// wall

	if(ball.getX() >= 590 ){
		ball.setSpeedX(ball.getSpeedX() * -1);
	}
	if(ball.getX() <= 10){
		ball.setSpeedX(ball.getSpeedX() * -1);
	}
	if(ball.getY() <= 10){
		ball.setSpeedY(ball.getSpeedY() * -1);
	}

	ball.setX(ball.getX() + ball.getSpeedX());
	ball.setY(ball.getY() + ball.getSpeedY());

//check loseing
	gold = 0 ;
	for(int i =0 ; i <100 ; i++){
		gold += bricks.get(i).gold ;
		}

	if(ball.getY() >= 590 ){
		endPage(pane2 , primaryStage , scene2);
		sw = false ;
	}

//check wining

	if( x == 0){
		endPage( pane2 , primaryStage , scene2);
		sw = false ;
	}
}}
};
//work with keyboard

// control racket
scene1.setOnKeyPressed(new EventHandler<KeyEvent>() {
	byte a = 1;

        public void handle(KeyEvent keyEvent) {
		if(keyEvent.getCode() == keyCode.SPACE ){
			a++ ;
			if(a % 2 == 1)    mediaPlayer.stop();
			else     mediaPlayer.play();
			}
		if(keyEvent.getCode() == keyCode.RIGHT )
		racket.setX(racket.getX()+ 20 ,WIDTH);

		if(keyEvent.getCode() == keyCode.LEFT )
		racket.setX(racket.getX()- 20 ,WIDTH);

		if(keyEvent.getCode() == keyCode.UP && racket.getY() > 500 )
		racket.setY(racket.getY()- 10 ,WIDTH);

		if(keyEvent.getCode() == keyCode.DOWN && racket.getY() < 570 )
		racket.setY(racket.getY()+ 10 ,WIDTH);
		}
    });

//choose level
    scene3.setOnKeyPressed(new EventHandler<KeyEvent>() {
        public void handle(KeyEvent keyEvent) {
		if(keyEvent.getCode() == keyCode.UP && tik.getY() >= 370)
		tik.setY(tik.getY()- 100);

		if(keyEvent.getCode() == keyCode.DOWN && tik.getY() <= 370)
		tik.setY(tik.getY() + 100);

		if(keyEvent.getCode() == keyCode.ENTER ){
		primaryStage.setScene(scene1);
		animationTimer.start();
		ball.setLevel((int) tik.getY() / 100 - 1);

		}
		}
	});

//end
		primaryStage.setResizable(false);
		primaryStage.setScene(scene3);
		primaryStage.show();

}//close start
	}//close class
