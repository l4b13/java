import java.lang.Math.*;

public class lab1 {
  public static void main(String[] args) {
    int[] d = new int[] {19, 17, 15, 13, 11, 9, 7, 5, 3};
    double[] x = new double[] {3.23d, 1.83d, -3.7d, 0d, 6d, -1.39d, 4.5d, 2.77d, 5.01d, 2.37d, 4.95d, -3d, -1.11d, -1.55d, 3.69d, -0.05d, 0.54d};
    //double[] x = new double[] {4.20d, 3.81d, -2.22d, 3.00d, 1.11d, -4.00d, 3.57d, 1.34d, 0.01d, -0.19d, 2.99d, -3.8d, -2.49d, -2.90d, 3.07d, 6.00d, 4.11d};
    //double[] x = new double[] {-3.01d, 2.00d, 3.00d, 5.00d, 6.00d, 0.34d, 1.99d, 2.45d, 1.00d, 3.99d, 4.95d, -1.44d, 4.98d, 2.04d, 5.46d, -3.05d, 3.84d};
    double[][] m = new double[9][17];
    int i,j = 0;
    for (i = 0; i < 9; i++) {
    	for (j = 0; j < 17; j++) {
    		if (d[i] == 7) {
    			m[i][j] = Math.pow(0.5/Math.atan(0.75 * (x[j] + 1) * Math.E + 1), Math.tan(Math.pow(0.75 / (x[j] - 3), x[j])));
    		} else if (d[i] == 3 || d[i] == 5 || d[i] == 13 || d[i] == 15) {
  				m[i][j] = Math.cos(Math.cbrt(Math.pow(Math.E, x[j])));
  			} else {
  				m[i][j] = Math.sin(Math.tan(Math.cbrt(Math.cos(x[j]))));
  			}
  			if (j < 16) {
  				System.out.printf("%6.3f ", m[i][j]);
  			} else System.out.printf("%6.3f%n", m[i][j]);
    	}
    }
  }
}