package tool;

import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Mat;

//ѵ����
public class trainer {

	public static void main(String[] args) {
		
		File file = new File("F:\\JavaProject\\facePicture\\Resource\\3D-Face-BMP31-60\\BMP31-60"); 
		//�����Ŀ¼�����ڣ��������
		if(!file.exists()) {
			System.out.println("Ŀ¼·������");
		}
		//���ھͽ����������
		else {
			trainer trainer = new trainer();
			
			trainer.travel(file);
		}
		
	
	}
	
	//����
	public void travel(File file) {
	//������ļ����ͽ��лҶȻ���һЩ�в���
		if(file.isFile()) {
		
			//����lib,���lib������
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			
			//��ȡͼƬ��Ϣ
			Mat image = Highgui.imread(new File(inputImagePath).getAbsolutePath());
		
		
		}
		
		
		
		
		//�����Ŀ¼���ͻ�ȡ�����µ�Ԫ��
		if(file.isDirectory()) {
			//��ȡ���µ�Ԫ��
			String [] fileList = file.list();
			for(int i=0;i<fileList.length;i++) {
				//��������Ԫ��
				travel(new File(fileList[i]));
			}
		}
		
		System.out.println(file+"  �ҶȻ����");
		
	}

}
