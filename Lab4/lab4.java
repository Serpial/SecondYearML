import java.util.ArrayList;

class lab4 {
    static int image_size = 28*28 + 1;
    static double W[][] = new double [10][image_size];

    public static void main (String args[]) {
        double X[] = new double[];
        int prediction, label, epoch=0;
        
        X[3]=1;

        // Initialise weights to 1
        for (int i=0; i<W.length; i++) {
            for (int j=0; j<W[0].length; j++) {
                W[i][j]=1.0;
            }
        }
        
        do {
            
            
            epoch++;
        } while (epoch<7);
    }

	private static void check(boolean e) {
		if (!e) {
			System.out.println("unexpected results");
			System.exit(0);
		}
	}
    
    public static int output(double X[]) {
        int out = -1;
        double a_max= -1e10;
        for (int c=0; c<10; c++) {
            check(X.length == W[c].length);
            double a = 0;
            for (int i=0; i<X.length; i++) {
                a += W[c][i]*X[i];
            }
            if (a> a_max) {
                a_max = a;
                out = c;
            }
        }
        check (0 <= out && out < 10);
        return out;
    }
}

