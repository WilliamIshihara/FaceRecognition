
/**
 * 使用的是一个博主的代码
 * @author https://blog.csdn.net/spw_1201/article/details/78439355?utm_source=copy 
 * */
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgproc.Imgproc;

import tool.mat2BufferdeImage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
public class ShowVedio {
 
	static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
	private JFrame frame;
	static JLabel label;
	static int flag=0;
	/**
	 * Launch the application.
	 */
	
	
	
	public void Start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowVedio window = new ShowVedio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//操作
		VideoCapture camera=new VideoCapture();
		camera.open(0);
		if(!camera.isOpened()){
			System.out.println("Camera Error");
		}
		else{
			Mat frame=new Mat();
			while(flag==0){
				camera.read(frame);
				Mat gray=new Mat(frame.rows(),frame.cols(),frame.type());
				Imgproc.cvtColor(frame, gray, Imgproc.COLOR_RGB2GRAY);
				label.setIcon(new ImageIcon(mat2BufferdeImage.matToBufferedImage(gray)));
				try{
					Thread.sleep(100);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
 
	/**
	 * Create the application.
	 */
	public ShowVedio() {
		initialize();
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 798, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
				
		JButton btnNewButton = new JButton("拍照");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				flag=1;
			}
		});
		btnNewButton.setBounds(20, 20, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		label=new JLabel("");
		label.setBounds(50, 50, 640, 480);
		frame.getContentPane().add(label);
	}
 
}
