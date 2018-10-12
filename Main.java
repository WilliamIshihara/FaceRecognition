import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
//主界面
public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage arg0) throws Exception {
		//751  500
		
		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-image:url(file:F:/JavaProject/facePicture/start.jpeg)");
		//button
		Image img1 = new Image("file:F:/JavaProject/facePicture/注册.PNG");
		ImageView imgView1 =new ImageView(img1);
		Button startOfFirst = new Button("",imgView1);
		startOfFirst.setMinSize(300, 30);
		startOfFirst.setStyle("-fx-background-color:ANTIQUEWHITE");
		
		Image img2 = new Image("file:F:/JavaProject/facePicture/登陆.PNG");
		ImageView imgView2 =new ImageView(img2);
		Button start = new Button("",imgView2);
		start.setMinSize(300, 30);
		start.setStyle("-fx-background-color:ANTIQUEWHITE");
		
		VBox box = new VBox(30);
		box.getChildren().add(startOfFirst);
		box.getChildren().add(start);
		box.setAlignment(Pos.CENTER);
		
		Image Title = new Image("file:F:/JavaProject/facePicture/title.PNG"); 
		ImageView imageView = new ImageView(Title);
		HBox box2 = new HBox();
		box2.getChildren().add(imageView);
		box2.setAlignment(Pos.CENTER);
		
		borderPane.setBottom(box);
		borderPane.setTop(box2);
		BorderPane.setAlignment(box2, Pos.CENTER);
		BorderPane.setAlignment(box, Pos.BOTTOM_CENTER);
		
		Scene scene = new Scene(borderPane);
		arg0.setScene(scene);
		arg0.setHeight(751);
		arg0.setWidth(500);
		arg0.setResizable(false);
		arg0.setTitle("ViVi'Face Recognition");
		arg0.show();
		
		//登陆之后，点击头像可以查看用户详细信息
		
		//------button 响应
		startOfFirst.setOnAction(e->LogOn(arg0));
	}
	
	//注册界面
	
	public void LogOn(Stage oldStage) {
		//一个人的信息需要储存一份信息，一个头像，一个人脸识别的东西
		//1200，632
		
		Stage stage = new Stage();
		
		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-image:url(file:F:/JavaProject/facePicture/2.jpeg)");
		
		
		Image img1 = new Image("file:F:/JavaProject/facePicture/注册2.PNG");
		ImageView imgView1 = new ImageView(img1);
		
		//注册布局
		VBox minPane = new VBox();
		//头像
		Button head = new Button();
		head.setStyle("-fx-background-image:url(file:F:/JavaProject/facePicture/加号_看图王.jpg)");
		head.setMinSize(70, 70);
		//姓名，性别，年龄
		
		minPane.getChildren().add(head);
		
		
		//左侧放注册界面
		borderPane.setTop(imgView1);
		borderPane.setLeft(minPane);
		
		
		Scene scene = new Scene(borderPane);
		stage.setScene(scene);
		stage.setHeight(632);
		stage.setWidth(1200);
		stage.setResizable(false);
		stage.setTitle("注册");
		stage.show();
		oldStage.close();
		
		//点击按钮出现一个文件选择器，选择图片
		//暂时的图片我们帮助选择好，大小剪切好，或者可以调api，自己查
		head.setOnAction(e->{
			
		});
		
	}

}
