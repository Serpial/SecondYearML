
public class lab4task2 {
    public static void main (String args[]) {
        int X[] = new int[4];
        int W[][] = new int[3][4];
        int score[];
        int label=0, prediction, epoch=0;


        //  Set bias
        X[3] = 1;

        // Init weights
        for (int i=0; i<W.length; i++) {
            for (int j=0; j<W[0].length; j++) {
                W[i][j] = 1;
            }
        }

        do {
            switch (epoch%3) {
            case 0:
                X[0]=1; X[1]=0; X[2]=0; label=0; break;
            case 1:
                X[0]=0; X[1]=1; X[2]=0; label=1; break;
            case 2:
                X[0]=0; X[1]=0; X[2]=1; label=2; break;
            }

            // Calculate Prediction
            score = new int[W.length];
            for (int i=0; i<W.length; i++) {
                score[i]=0;
                for (int j=0; j<W[0].length;j++) {
                    score[i]+=W[i][j]*X[j];                    
                }                
            }
            
            prediction=0;
            for (int i=1; i<W.length;i++) {
                if (score[i]>score[prediction]) {
                    prediction=i;
                }
            }

            // Train
            for (int i=0; i<W[0].length; i++) {
                W[prediction][i] -= X[i];
                W[label][i] += X[i];
            }

            System.out.println("epoch "+epoch++ +" training on "+X[0]+" "+X[1]+" "+X[2]+" "+X[3]+" label = "+label+" prediction = " +prediction+
                               " W01 = "+W[0][0]+" W02 = "+W[0][1]+" W03 = "+W[0][2]+" W04 = "+W[0][3]+
                               " W11 = "+W[1][0]+" W12 = "+W[1][1]+" W13 = "+W[1][2]+" W14 = "+W[1][3]+
                               " W21 = "+W[2][0]+" W22 = "+W[2][1]+" W23 = "+W[2][2]+" W24 = "+W[2][3]
                               );
        } while (epoch<6);
    }
}

