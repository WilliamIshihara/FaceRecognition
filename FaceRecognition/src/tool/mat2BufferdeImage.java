package tool;

/**mat2BufferedImage.matToBufferedImage(source);
 * ��������ǽ�Opencv��Mat��ʽ��ͼ��ת����Java Swing�е�BufferedImage��ʽ��
 * ��Ϊ��Swing��ֻ֧��BufferedImage��ʽͼ����ʾ���÷����������Լ�д�ģ�
 * ����Ϊ�÷��������Ժ�һֱҪʹ�ã���ˣ���testOpencv���½�һ��tool����
 * Ȼ���ڸð����½�һ��mat2BufferedImage.java�࣬����������£�
	--------------------- 
	���ߣ�spw_1201 
	��Դ��CSDN 
	ԭ�ģ�https://blog.csdn.net/spw_1201/article/details/78436346?utm_source=copy 
	��Ȩ����������Ϊ����ԭ�����£�ת���븽�ϲ������ӣ�
 * @author ����
 * */

import java.awt.image.BufferedImage;
 
import org.opencv.core.Mat;
public class mat2BufferdeImage {
 
	public static BufferedImage matToBufferedImage(Mat matrix) {
		
		int cols=matrix.cols();
		int rows=matrix.rows();
		int elemSize=(int)matrix.elemSize();
		byte[] data=new byte[cols*rows*elemSize];
		int type;
		matrix.get(0 ,0,data);
		switch(matrix.channels()){
		case 1:
			type=BufferedImage.TYPE_BYTE_GRAY;
			break;
		case 3:
			type=BufferedImage.TYPE_3BYTE_BGR;
			byte b;
			for(int i=0;i<data.length;i=i+3){
				b=data[i];
				data[i]=data[i+2];
				data[i+2]=b;
			}
			break;
			default:
				return null;
				
		}
		BufferedImage image2=new BufferedImage(cols,rows,type);
		image2.getRaster().setDataElements(0, 0,cols,rows,data);
		return image2;
	}
 
}