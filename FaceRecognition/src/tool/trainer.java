package tool;

import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Mat;

//训练集
public class trainer {

	public static void main(String[] args) {
		
		File file = new File("F:\\JavaProject\\facePicture\\Resource\\3D-Face-BMP31-60\\BMP31-60"); 
		//如果此目录不存在，输出提醒
		if(!file.exists()) {
			System.out.println("目录路径错误");
		}
		//存在就进入遍历方法
		else {
			trainer trainer = new trainer();
			
			trainer.travel(file);
		}
		
	
	}
	
	//遍历
	public void travel(File file) {
	//如果是文件，就进行灰度化等一些列操作
		if(file.isFile()) {
		
			//加载lib,这个lib的名称
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			
			//读取图片信息
			Mat image = Highgui.imread(new File(inputImagePath).getAbsolutePath());
		
		
		}
		
		
		
		
		//如果是目录。就获取他底下的元素
		if(file.isDirectory()) {
			//获取底下的元素
			String [] fileList = file.list();
			for(int i=0;i<fileList.length;i++) {
				//遍历底下元素
				travel(new File(fileList[i]));
			}
		}
		
		System.out.println(file+"  灰度化完成");
		
	}

}
