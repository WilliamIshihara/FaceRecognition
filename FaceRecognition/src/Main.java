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
//������
public class Main extends Application{
	//����ͷ��İ�ť���Ա�ϵͳ����
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
		Image img1 = new Image("file:F:/JavaProject/facePicture/ע��.PNG");
		ImageView imgView1 =new ImageView(img1);
		Button startOfFirst = new Button("",imgView1);
		startOfFirst.setMinSize(300, 30);
		startOfFirst.setStyle("-fx-background-color:ANTIQUEWHITE");
		
		Image img2 = new Image("file:F:/JavaProject/facePicture/��½.PNG");
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
		
		//��½֮�󣬵��ͷ����Բ鿴�û���ϸ��Ϣ
		
		//------button ��Ӧ
		startOfFirst.setOnAction(e->LogOn(arg0));
		//��½����
		start.setOnAction(e->LogIn(arg0));
	}
	//��½����
	public void LogIn(Stage oldStage) {
		//ֱ����ʾ����ͷ������ʶ������ж�������һλ���ж����֮����ʾ����ӭxxx
		//���ߵ�½ʧ�ܣ�����ע�ᣬ
		//���Ѿ����̫���ˣ��Ҷ��ϲ�������
		//���ݻ��ݳ��ֱ���δע�������ע���������ע�ᣬ�Ҳ���ʶ������������Ѿ�����ʶ���ˡ�

		//Ȼ�����������
		mainScene(oldStage);
	}
	
	//������
	public void mainScene(Stage stage) {
		Stage mainStage = new Stage();
		//�����
		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-image:url(file:F:/JavaProject/facePicture/3.jpeg)");
		
		//���Ͻ�ͷ�����½��˳�,�м�ѡ��ͼƬ
		Button head = new Button();
		Button exit = new Button();
	
		
		Image img1 = new Image("file:F:/JavaProject/facePicture/ѡ��.PNG");
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
	        //�쳣�������δѡ��ͼƬ����ʾѡ��ͼƬ
	        if(file!=null) {
	        	System.out.println(file);
	        	choosePicture(file);
	        }
	        else
	        	System.out.println("��ѡ��ͷ��");
		});
	}
	
	//ѡ����Ƭ
	public void choosePicture(File picture) {
		//�ļ�ѡ����
		FileChooser chooser = new FileChooser();
	}
	
	//ע�����
	
	public void LogOn(Stage oldStage) {
		//һ���˵���Ϣ��Ҫ����һ����Ϣ��һ��ͷ��һ������ʶ��Ķ���
		//1200��632
		
		Stage stage = new Stage();
		
		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-image:url(file:F:/JavaProject/facePicture/2.jpeg)");
		
		
		Image img1 = new Image("file:F:/JavaProject/facePicture/ע��2.PNG");
		ImageView imgView1 = new ImageView(img1);
		
		//ע�᲼��
		VBox minPane = new VBox(30);
		//ͷ��
		
		head.setStyle("-fx-background-image:url(file:F:/JavaProject/facePicture/�Ӻ�_��ͼ��.jpg)");
		head.setMinSize(70, 70);
		
		//�������Ա�����
		Text text1 = new Text(20, 40, "����");
		name.setEditable(true);//�ɱ༭
		HBox hbox1 = new HBox();
		hbox1.getChildren().add(text1);
		hbox1.getChildren().add(name);
		
		Text text2 = new Text(20, 40, "�Ա�");
		name.setEditable(true);//�ɱ༭
		HBox hbox2 = new HBox();
		hbox2.getChildren().add(text2);
		hbox2.getChildren().add(sex);
		
		Text text3 = new Text(20, 40, "����");
		name.setEditable(true);//�ɱ༭
		HBox hbox3 = new HBox();
		hbox3.getChildren().add(text3);
		hbox3.getChildren().add(old);
		
		//�ύ��ť���Զ�������ͷ

		Image img4 = new Image("file:F:/JavaProject/facePicture/�ύ.PNG");
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
		//����ע�����
		borderPane.setTop(imgView1);
		borderPane.setLeft(minPane);
		BorderPane.setAlignment(minPane, Pos.CENTER);
		
		Scene scene = new Scene(borderPane);
		stage.setScene(scene);
		stage.setHeight(632);
		stage.setWidth(1200);
		stage.setResizable(false);
		stage.setTitle("ע��");
		stage.show();
		oldStage.close();
		
		//�����ť����һ���ļ�ѡ������ѡ��ͼƬ
		//��ʱ��ͼƬ���ǰ���ѡ��ã���С���кã����߿��Ե�api���Լ���
		head.setOnAction(e->{
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("choose your head portrait");
			fileChooser.setInitialDirectory(new File("F:\\JavaProject\\facePicture\\ͷ��"));
	        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All Images", "*.*");
	        fileChooser.getExtensionFilters().add(extFilter);
	        File file = fileChooser.showOpenDialog(stage);
	        //�쳣�������δѡ��ͼƬ����ʾѡ��ͼƬ
	        if(file!=null) {
	        System.out.println(file.toString());
	        //�����file�浽text�ļ���
	        String headPicture = new String(file.toString());
	        headPicture = "file:F:/JavaProject/facePicture/�Ӻ�_��ͼ��.jpg";
	        head.setStyle("-fx-background-image:url(file:F:/JavaProject/facePicture/ͷ��/ͷ��.jpg)");
	        }
	        else
	        	System.out.println("��ѡ��ͷ��");
		});
		//���еĿ��ǿյ�ʱ����ת������̨��ʾ������������ȷ����Ϣ
		//��Ϊ�յ�ʱ�򣬴�����ͷ��������Ƭ��������Ϣ���浽�ļ��д洢��
		submit.setOnAction(e->{
			//
			//
			//*****************************************************************************
			//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
			//
			//��textField�������ʱ�򣬷���ֵΪ""���������ж���ʱ������==����Ϊ����Ƚϵ��ǵ�ַ��Ӧ����equals���Ƚ�
			if(!name.getText().equals("")&&!sex.getText().equals("")&&!old.getText().equals("") ) {
				System.out.println(name.getText());
				System.out.println(sex.getText());
				System.out.println(old.getText());
				getCamera(stage);
			}
			else
				System.out.println("����������");
		});
		
		
		
	}
	
	//��ȡ��������������������䱣�棨�Լ��ϱߵ���������ݣ�
	public void getCamera(Stage stage) {
		//������������ֱ��ȡ����ͷ�������ͻ�ȡ����ͷ�ڵ�ͼ��������ȡ����ͼ������һ��swing��component�����
		//public static Player = null; 
		//��ȡͷ��Ȼ�󱣴浽�ļ���
		ShowVedio showVedio = new ShowVedio();
		showVedio.Start();
		//private TextField name = new TextField();
		//private TextField sex = new TextField();
		//private TextField old = new TextField();
		String fileName = "F:\\JavaProject\\facePicture\\data\\"+name.getText()+".txt";
	        try {
	            File file1 = new File(fileName);
	           
	            PrintStream ps = new PrintStream(new FileOutputStream(file1));
	            ps.print(name.getText()+",");// ���ļ���д���ַ���
	            ps.append(sex.getText()+",");// �����еĻ���������ַ���
	            ps.append(old.getText());// �����еĻ���������ַ���
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
