package tool;

/**mat2BufferedImage.matToBufferedImage(source);
 * 这个方法是将Opencv中Mat格式的图像转换成Java Swing中的BufferedImage格式，
 * 因为在Swing中只支持BufferedImage格式图像显示。该方法是我们自己写的，
 * 又因为该方法我们以后一直要使用，因此，在testOpencv中新建一个tool包，
 * 然后在该包下新建一个mat2BufferedImage.java类，该类代码如下：
	--------------------- 
	作者：spw_1201 
	来源：CSDN 
	原文：https://blog.csdn.net/spw_1201/article/details/78436346?utm_source=copy 
	版权声明：本文为博主原创文章，转载请附上博文链接！
 * @author 博主
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