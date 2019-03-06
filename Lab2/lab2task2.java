public class lab2task2 {
    public static void main (String args[]) {
        int x[] = new int[3], w[] = new int[3];
        int error, label=0, prediction=0;
        int counter = 0;
        int epochCounter = 0;

        // x[2] should always be 1
        x[2]=1;

        // Setting initial wieght
        w[0]=1; w[1]=1; w[2]=0;
        
        do {
            switch (counter%4) {
            case 0:
                x[0] = 0; x[1]= 0; label=0; epochCounter++; break;
            case 1:
                x[0] = 1; x[1]= 0; break;
            case 2:
                x[0] = 0; x[1]= 1; break;
            case 3:
                x[0] = 1; x[1]= 1; label=1;
            }

            // Get prediction
            prediction=0;
            for (int i=0; i<3; i++) {
                prediction += (x[i] * w[i]);
            }
            prediction = prediction>=0? 1 : 0;

            // Get error
            error = label - prediction;

            // Get new weights
            for (int i=0; i<3; i++) {
                w[i] += error * x[i];
            }

            // Print result
            System.out.println ("epoch "+epochCounter+ " training on " +x[0]+" "+x[1]+" "+x[2]+" label = " + label + " prediction = " + prediction + " error = " + error + " W1 = " + w[0] + " W2 = " + w[1] + " W3 = " + w[2]);
            
            counter++;    
        } while(counter < 16);
        
    }
}
