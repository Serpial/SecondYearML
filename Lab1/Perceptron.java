public class Perceptron {

	double W1, W2, b; String name;
	public Perceptron(double W1i, double W2i, double bi, String ni){ 

		W1 = W1i; W2 = W2i; b = bi; name = ni;
		System.out.println("Perceptron '" + name + "' created: W1 = " +
                           W1 + " W2 = " + W2 + " b = " + b);

	}

	double output(double X1, double X2){
		double a =(X1*W1) + (X2*W2) + b;
        System.out.println("Perceptron '" + name + "' running: X1 = " + X1 +
                           " X2 = " + X2 + " activation = "  + a + " output = " + (a<0?0:1));
        return a<0?0:1;
	}

	public static void check(boolean e) { 
		if (!e){
			System.out.println("unexpected result");
			System.exit(0);
		}
	}
    public static void main(String[] args) {

        /*
		Perceptron Pand = new Perceptron(1,1,-1.5, "and");
		check(Pand.output(0,0) == 0);
		check(Pand.output(0,1) == 0);
		check(Pand.output(1,0) == 0);
		check(Pand.output(1,1) == 1);

		Perceptron Por = new Perceptron(1,1,-.5,"or");
		check(Por.output(0,0) == 0);
		check(Por.output(0,1) == 1);
		check(Por.output(1,0) == 1);
		check(Por.output(1,1) == 1);

        Perceptron Pnor = new Perceptron(-1,-1,.5,"nor");
        check(Pnor.output(0,0) == 1);
		check(Pnor.output(1,0) == 0);
		check(Pnor.output(0,1) == 0);
		check(Pnor.output(1,1) == 0);
        */
        
        System.out.println("Learning XNOR ...");
        
        Perceptron H1 = new Perceptron(1,1,-1, "H1");
        Perceptron H3 = new Perceptron(-1,-1,1, "H2");
        Perceptron O = new Perceptron(-1,-1,1, "O");

        double x1 = 0; double x2 = 0;
        double o1 = H1.output(x1,x2);
        double o3 = H3.output(x1,x2);
        check(O.output(o1, o3) == 1);

        x1 = 1; x2 = 0;
        o1 = H1.output(x1,x2);
        o3 = H3.output(x1,x2);
        check(O.output(o1, o3) == 0);

        x1 = 0; x2 = 1;
        o1 = H1.output(x1,x2);
        o3 = H3.output(x1,x2);
        check(O.output(o1, o3) == 0);
        
        x1 = 1; x2 = 1;
        o1 = H1.output(x1,x2);
        o3 = H3.output(x1,x2);
        check(O.output(o1, o3) == 1);
        

    }
    
}
