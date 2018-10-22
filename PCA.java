import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

public class PCA {

	// public static void main(String[] args) {
	// PCA pca = new PCA();
	// pca.testDmeo();
	// pca.MainModel();
	// pca.openDir();
	// pca.recFace("D:/chensiyu/FaceRecognition/Image/BMP1-123/008/008-001.bmp");
	// }

	// 所有图片矩阵
	public Mat m_mTrainingImage = null;
	// 平均矩阵
	public Mat meanFaceMat = null;
	public Mat meanFaceMat1 = null;
	// 规格化后的矩阵
	public Mat normTrainFaaceMat = null;
	public Mat normTrainFaaceMat1 = null;
	// 特征值与特征向量
	public Mat eigenvalues = null;
	public Mat eigenvectors = null;
	public Mat sort_eigenvectors = null;
	// 存储特征值和特征值下标
	public Mat Sort_value = null;
	public Mat Sort_index = null;
	// 新的向量矩阵
	public Mat eig_vec = null;
	public Mat eig_vec1 = null;
	// 特征脸
	public Mat eigenface = null;
	// 特征脸投影
	public Mat eigen_train_sample = null;
	// 测试人脸矩阵
	public Mat testFaceMat = null;
	// 识别样本规格化矩阵
	public Mat normTestFaceMat = null;
	// 测试特征脸投影矩阵
	public Mat eigen_test_sample = null;
	// 距离矩阵
	private List<String> fileList = new ArrayList<>();
	List<Integer> position = new ArrayList<>();
	List<Double> total_num = new ArrayList<>();

	long len;
	int index = 0;
	String str = null;

	public void testDmeo() {
		List<String> list = new ArrayList<>();
		int count = 0;
		String Path = "D:/chensiyu/FaceRecognition/Image/BMP1-123/";
		File file = new File(Path);
		MainModel();
		openDir();
		if (file != null) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				String str = files[i].toString();
				str = str.replace("\\", "/");
				for (int j = 8; j < 10; j++) {
					if (i < 10) {
						list.add(str + "/00" + (i + 1) + "-00" + j + ".bmp");
					}
					if (i >= 10 && i < 100) {
						list.add(str + "/0" + (i + 1) + "-00" + j + ".bmp");
					}
					if (i >= 100) {
						list.add(str + "/" + (i + 1) + "-00" + j + ".bmp");
					}
				}
			}
			for (int i = 0; i < list.size(); i++) {
				int pos = recFace(list.get(i));
				String[] name = list.get(i).split("/");
				String person = name[name.length - 2];
				if ((pos / 7 + 1) == (Integer.parseInt(person))) {
					count++;
				}
			}
			System.out.println(count + " " + list.size());
			System.out.println("正确率为: " + count * 1.0 / list.size());
		}
	}

	public void MainModel() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public void openDir() {
		String Path = "D:/chensiyu/FaceRecognition/cut/";
		File file = new File(Path);
		if (file != null) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				String str = files[i].toString();
				str = str.replace("\\", "/");
				for (int j = 1; j < 8; j++) {
					if (i < 10) {
						fileList.add(str + "/00" + (i + 1) + "-00" + j + ".bmp");
					}
					if (i >= 10 && i < 100) {
						fileList.add(str + "/0" + (i + 1) + "-00" + j + ".bmp");
					}
					if (i >= 100) {
						fileList.add(str + "/" + (i + 1) + "-00" + j + ".bmp");
					}
				}
			}
			dealPic();
		}
	}

	// PCA
	public void dealPic() {
		double width = 0;
		double height = 0;
		for (int i = 0; i < fileList.size(); i++) {
			// 获取第一张图片
			Mat mat = Imgcodecs.imread(fileList.get(i));
			if (mat.width() > width) {
				width = mat.width();
			}
			if (mat.height() > height) {
				height = mat.height();
			}

		}
		len = (long) (width * height);

		// 初始化一个M*N大小的矩阵
		m_mTrainingImage = new Mat(fileList.size(), (int) len, CvType.CV_32F);
		meanFaceMat = new Mat(1, (int) len, CvType.CV_32F);
		meanFaceMat1 = new Mat(1, (int) len, CvType.CV_32F);
		normTrainFaaceMat = new Mat(fileList.size(), (int) len, CvType.CV_32F);
		normTrainFaaceMat1 = new Mat(fileList.size(), (int) len, CvType.CV_32F);
		m_mTrainingImage = turnToCol(m_mTrainingImage);
		// 平均矩阵
		meanFaceMat = meanTrain(m_mTrainingImage, meanFaceMat);
		// 规格化后的矩阵
		normTrainFaaceMat = normTrain(m_mTrainingImage, meanFaceMat, normTrainFaaceMat);
		eigen();
		// 新的特征向量矩阵
		int count = 0;
		double sum = 0;
		double total = 0;
		Scalar scalar = Core.sumElems(eigenvalues);
		sum = scalar.val[0] * 0.9;
		for (int i = 0; i < eigenvalues.rows(); i++) {
			total += eigenvalues.get(i, 0)[0];
			count++;
			if (total > sum) {
				break;
			}
		}
		System.out.println(count);
		// 初始化新特征向量矩阵
		eig_vec = new Mat(count, eigenvectors.height(), CvType.CV_32F);
		eig_vec1 = new Mat(count, eigenvectors.height(), CvType.CV_32F);
		for (int i = 0; i < eig_vec.rows(); i++)
			for (int j = 0; j < eig_vec.cols(); j++) {
				eig_vec1.put(i, j, Math.sqrt(eigenvalues.get(i, 0)[0]));
			} // 存放前m个特征值
		for (int i = 0; i < eig_vec.height(); i++) {
			for (int j = 0; j < eig_vec.width(); j++) {
				eig_vec.put(i, j, eigenvectors.get(i, j)[0] / eig_vec1.get(i, j)[0]);
			}
		} // 形成新的特征向量矩阵
		Core.transpose(eig_vec, eig_vec);
		// 获得样本的特征脸
		eigenface = new Mat();
		Core.gemm(normTrainFaaceMat1, eig_vec, 1, new Mat(), 0, eigenface);
		// 获得样本特征脸的投影
		eigen_train_sample = new Mat();
		Core.gemm(normTrainFaaceMat, eigenface, 1, new Mat(), 0, eigen_train_sample);
		// System.out.println(eigen_train_sample.dump());
	}

	public int recFace(String imagePath) {
		List<Double> distance = new ArrayList<>();
		int count = 0;
		Recognition rec = new Recognition();
		Mat image = null;
		try {
			image = rec.newrecognition(imagePath); // 对测试样本进行灰度、剪切处理、几何归一化
		} catch (Exception e) {
			str = "未检测到人脸";
			return 0;
		}
		testFaceMat = new Mat(1, image.width() * image.height(), CvType.CV_32F); // 初始化矩阵

		for (int m = 0; m < image.width(); m++) {
			for (int k = 0; k < image.height(); k++) {
				double[] temp = image.get(k, m);
				testFaceMat.put(0, count, temp[0]);
				count++;
			}
		}

		normTestFaceMat = new Mat(1, meanFaceMat.cols(), CvType.CV_32F);
		normTestFaceMat = normTrain(testFaceMat, meanFaceMat, normTestFaceMat);

		eigen_test_sample = new Mat(1, eig_vec.cols(), CvType.CV_32F);
		Core.gemm(normTestFaceMat, eigenface, 1, new Mat(), 0, eigen_test_sample);
		System.out.println("----------------------测试样本导入成功，开始进行识别----------------------");
		// 计算距离
		// int num = 0;
		// int mn = 0;
		for (int i = 0; i < eigen_train_sample.rows(); i++) {
			distance.add(getDistance(eigen_train_sample.row(i), eigen_test_sample));
			// num++;
			// if (num % 5 == 0) {
			// mn++;
			// System.out.print(distance.get(i) + " ");
			// System.out.println();
			// System.out.print(mn + ": ");
			// } else if (mn == 0) {
			// mn++;
			// System.out.print(mn + ": ");
			// System.out.print(distance.get(i) + " ");
			// } else
			// System.out.print(distance.get(i) + " ");
		}
		double min = distance.get(0);
		int minIndex = 0;
		for (int i = 1; i < distance.size(); i++) {
			if (min > distance.get(i)) {
				min = distance.get(i);
				minIndex = i;
			}
		}
		if (min < 1400) {
			System.out.println("姓名: " + (minIndex / 7 + 1));
			return minIndex;
		}
		return 0;
	}

	// 将图片进行转换，变成一行行向量
	public Mat turnToCol(Mat mat) {
		int count = 0;
		for (int i = 0; i < fileList.size(); i++) {
			Mat data = Imgcodecs.imread(fileList.get(i));
			for (int m = 0; m < data.width(); m++) {
				for (int k = 0; k < data.height(); k++) {
					double[] temp = data.get(k, m);
					mat.put(i, count, temp[0]);
					count++;
				}
			}
			count = 0;
		}
		return mat;
	}

	// 平均矩阵
	public Mat meanTrain(Mat m_mTrainingImage, Mat meanFaceMat) {
		// for (int i = 0; i < m_mTrainingImage.cols(); i++) {
		// meanFaceMat.put(0, i, 0);
		// }
		for (int i = 0; i < m_mTrainingImage.height(); i++) {
			Mat temp = m_mTrainingImage.row(i);
			Core.add(meanFaceMat, temp, meanFaceMat);
		}
		for (int i = 0; i < m_mTrainingImage.width(); i++) {
			meanFaceMat1.put(0, i, fileList.size());
		}
		Core.divide(meanFaceMat, meanFaceMat1, meanFaceMat);
		return meanFaceMat;

	}

	// 规格化矩阵
	public Mat normTrain(Mat m_mTrainingImage, Mat meanFaceMat, Mat normTrainFaaceMat) {
		for (int i = 0; i < m_mTrainingImage.rows(); i++) {
			Core.subtract(m_mTrainingImage.row(i), meanFaceMat, normTrainFaaceMat.row(i));
		}
		return normTrainFaaceMat;
	}

	// 特征向量与特征值
	public void eigen() {
		Mat dst = new Mat();
		eigenvalues = new Mat();
		eigenvectors = new Mat();
		Core.transpose(normTrainFaaceMat, normTrainFaaceMat1);
		Core.gemm(normTrainFaaceMat, normTrainFaaceMat1, 1, new Mat(), 0, dst);
		Core.eigen(dst, eigenvalues, eigenvectors);// 特征值 特征向量
	}

	public double getDistance(Mat elleigen_train_sample, Mat eigen_train_sample) {
		Mat temp = new Mat();
		Core.subtract(elleigen_train_sample, eigen_train_sample, temp);
		Core.multiply(temp, temp, temp);
		Scalar sum = Core.sumElems(temp);
		return Math.sqrt(sum.val[0]);
	}
}
