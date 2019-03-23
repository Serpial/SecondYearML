import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class lab4task3 {
	static int image_size= 28*28;
	static int W[];
	
	static class Image {
		double[] pixels ;
		int label;
		
		Image() {
			pixels = new double[image_size];
		}
		void set(int pixel, int value) {
			pixels[pixel] =value;
		}
		void setLabel(int value) {
			label = value;
		}
	}
	
	public static void main(String args[]) {
		Image[] dataTest = null;
		Image[] dataTrain = null;
		
		W = new int[image_size];
		for (int i=0;i<image_size;i++) {
			W[i]=0;
		}
		
		try {
			dataTest = Read("./test.txt");
			dataTrain = Read("./train.txt");
			
			
			for (int epoch=0; epoch<100; epoch++) {
				// for every line
				for (int j=0; j<dataTrain.length; j++) {
					train(dataTrain[j]);
				}
				
				
				System.out.print("Epoch:");
				System.out.print(epoch);
				System.out.print(" train:");
				PrintAccuracy(dataTrain);
				System.out.print(" test:");
				PrintAccuracy(dataTest);
				System.out.println();
			}
			
		}catch (Exception e) {
			System.out.println("Error reading from file");
		}
	}
	
	static Image[] Read(String fileName) throws Exception {
		File file = new File (fileName);
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		int numberOfLines = 0;
		while ((st = br.readLine())!= null) {
			numberOfLines++;
		}
		int numberOfImages = numberOfLines/28;
		Image[] t = new Image[numberOfImages];
		br.close();
		br = new BufferedReader(new FileReader(file));
		for (int i=0; i<numberOfImages; i++) {
			t[i] = new Image();
			for (int row=0; row<28; row++) {
				st = br.readLine();
				String[] lineParts = st.split("[\t ]+");
				int label = Integer.parseInt(lineParts[0]);
				for (int pixel=0; pixel<28; pixel++) {
					int value = Integer.parseInt(lineParts[1+pixel]);
					t[i].set(row*28+pixel, value);
				}
				if (label >= 5) {
					t[i].setLabel(1);
				} else {
					t[i].setLabel(0);
				}
			}
		}
		br.close();
		return t;
	}
	
	private static void train(Image x) {
        int error, prediction=0;

        
	    // Get prediction
	    for (int i=0; i<x.pixels.length; i++) {
	        prediction += (x.pixels[i] * W[i]);
	    }
	    prediction = prediction>=0? 1 : 0;
	
	    // Get error
	    error = x.label - prediction;
	
	    // Get new weights
	    for (int i=0; i<x.pixels.length; i++) {
	        W[i] += error * x.pixels[i];
	    }
	
	}
		
	private static void check(boolean e) {
		if (!e) {
			System.out.println("unexpected results");
			System.exit(0);
		}
	}
	
	private static int output(double X[]) {
		double a = 0;
		check (X.length == W.length);
		for (int i=0; i<X.length;i++) {
			a += W[i]*X[i];
		}
		if (a >= 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	private static void PrintAccuracy (Image data[]) {
		float err=0;
		for (int i=0; i<data.length; i++) {
			int p = output(data[i].pixels);
			if (p != data[i].label) {
				err +=1;
			}
		}
		System.out.print(100 -(int)(100*err/data.length));
	}
}
