import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.media.Player;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//主界面
public class Main extends Application{
	//放置头像的按钮，以便系统调用
	private Button head = new Button();
	
	
	private TextField name = new TextField();
	private TextField sex = new TextField();
	private TextField old = new TextField();
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
		//登陆界面
		start.setOnAction(e->LogIn(arg0));
	}
	//登陆界面
	public void LogIn(Stage oldStage) {
		//直接显示摄像头，根据识别情况判断你是哪一位，判断完成之后，显示，欢迎xxx
		//或者登陆失败，请先注册，
		//你已经变得太丑了，我都认不出你了
		//整容毁容长胖变瘦未注册的请先注册或者重新注册，我不认识你或者我现在已经不认识你了。

		//然后进入主界面
		mainScene(oldStage);
	}
	
	//主界面
	public void mainScene(Stage stage) {
		Stage mainStage = new Stage();
		//主框架
		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-image:url(file:F:/JavaProject/facePicture/3.jpeg)");
		
		//左上角头像，右下角退出,中间选择图片
		Button head = new Button();
		Button exit = new Button();
	
		
		Image img1 = new Image("file:F:/JavaProject/facePicture/选择.PNG");
		ImageView imgView1 =new ImageView(img1);
		Button choose = new Button("",imgView1);
		choose.setMinSize(100, 30);
		choose.setStyle("-fx-background-color:ANTIQUEWHITE");
		
		borderPane.setCenter(choose);
		BorderPane.setAlignment(choose, Pos.CENTER);
		
		Scene scene  = new Scene(borderPane);
		mainStage.setScene(scene);
		mainStage.setHeight(660);
		mainStage.setWidth(1205);
		mainStage.setResizable(false);
		mainStage.setTitle("ViVi'Main Stage");
		mainStage.show();
		stage.close();
		
		choose.setOnAction(e->{
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("choose your head portrait");
			fileChooser.setInitialDirectory(new File("F:\\JavaProject\\facePicture\\Resource"));
	        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All Images", "*.*");
	        fileChooser.getExtensionFilters().add(extFilter);
	        File file = fileChooser.showOpenDialog(stage);
	        //异常处理，如果未选择图片就提示选择图片
	        if(file!=null) {
	        	System.out.println(file);
	        	choosePicture(file);
	        }
	        else
	        	System.out.println("请选择头像");
		});
	}
	
	//选择照片
	public void choosePicture(File picture) {
		//文件选择器
		FileChooser chooser = new FileChooser();
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
		VBox minPane = new VBox(30);
		//头像
		
		head.setStyle("-fx-background-image:url(file:F:/JavaProject/facePicture/加号_看图王.jpg)");
		head.setMinSize(70, 70);
		
		//姓名，性别，年龄
		Text text1 = new Text(20, 40, "姓名");
		name.setEditable(true);//可编辑
		HBox hbox1 = new HBox();
		hbox1.getChildren().add(text1);
		hbox1.getChildren().add(name);
		
		Text text2 = new Text(20, 40, "性别");
		name.setEditable(true);//可编辑
		HBox hbox2 = new HBox();
		hbox2.getChildren().add(text2);
		hbox2.getChildren().add(sex);
		
		Text text3 = new Text(20, 40, "年龄");
		name.setEditable(true);//可编辑
		HBox hbox3 = new HBox();
		hbox3.getChildren().add(text3);
		hbox3.getChildren().add(old);
		
		//提交按钮，自动打开摄像头

		Image img4 = new Image("file:F:/JavaProject/facePicture/提交.PNG");
		ImageView imgView4 =new ImageView(img4);
		Button submit = new Button("",imgView4);
		submit.setMinSize(160, 30);
		submit.setStyle("-fx-background-color:ANTIQUEWHITE");
		
		
		minPane.getChildren().add(head);
		minPane.getChildren().add(hbox1);
		minPane.getChildren().add(hbox2);
		minPane.getChildren().add(hbox3);
		minPane.getChildren().add(submit);
		
		minPane.setAlignment(Pos.CENTER);
		//左侧放注册界面
		borderPane.setTop(imgView1);
		borderPane.setLeft(minPane);
		BorderPane.setAlignment(minPane, Pos.CENTER);
		
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
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("choose your head portrait");
			fileChooser.setInitialDirectory(new File("F:\\JavaProject\\facePicture\\头像"));
	        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All Images", "*.*");
	        fileChooser.getExtensionFilters().add(extFilter);
	        File file = fileChooser.showOpenDialog(stage);
	        //异常处理，如果未选择图片就提示选择图片
	        if(file!=null) {
	        System.out.println(file.toString());
	        //将这个file存到text文件中
	        String headPicture = new String(file.toString());
	        headPicture = "file:F:/JavaProject/facePicture/加号_看图王.jpg";
	        head.setStyle("-fx-background-image:url(file:F:/JavaProject/facePicture/头像/头像.jpg)");
	        }
	        else
	        	System.out.println("请选择头像");
		});
		//当有的空是空的时候不跳转，控制台显示让他们输入正确的信息
		//不为空的时候，打开摄像头，拍摄照片，并将信息保存到文件中存储。
		submit.setOnAction(e->{
			//
			//
			//*****************************************************************************
			//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
			//
			//当textField不输入的时候，返回值为""，但是在判定的时候不能用==，因为这个比较的是地址，应该用equals来比较
			if(!name.getText().equals("")&&!sex.getText().equals("")&&!old.getText().equals("") ) {
				System.out.println(name.getText());
				System.out.println(sex.getText());
				System.out.println(old.getText());
				getCamera(stage);
			}
			else
				System.out.println("请完善数据");
		});
		
		
		
	}
	
	//获取照相机，拍摄人脸并将其保存（以及上边的输入的数据）
	public void getCamera(Stage stage) {
		//利用这三个类分别获取摄像头驱动，和获取摄像头内的图像流，获取到的图像流是一个swing的component组件类
		//public static Player = null; 
		//获取头像，然后保存到文件里
		ShowVedio showVedio = new ShowVedio();
		showVedio.Start();
		//private TextField name = new TextField();
		//private TextField sex = new TextField();
		//private TextField old = new TextField();
		String fileName = "F:\\JavaProject\\facePicture\\data\\"+name.getText()+".txt";
	        try {
	            File file1 = new File(fileName);
	           
	            PrintStream ps = new PrintStream(new FileOutputStream(file1));
	            ps.print(name.getText()+",");// 往文件里写入字符串
	            ps.append(sex.getText()+",");// 在已有的基础上添加字符串
	            ps.append(old.getText());// 在已有的基础上添加字符串
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        try {
				start(stage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	
	
	
}
