import java.text.DecimalFormat;
import java.util.Formatter;
public class Triangle {
	private double sideA;
	private double sideB;
	private double sideC;
	public static final double DEFAULT_SIDE =1.0;
	public static final String POLYGONSHAPE = "Triangle";


	public static boolean isTriangle(double a, double b, double c) {
		if(a>0&& b>0&&c>0) {
			if((a+b>c)&&(a+c>b)&& (b+c>a)){
				return true;
			}
			}
			return false;
		}
	 public Triangle() {
	        this.sideA = DEFAULT_SIDE;
	        this.sideB = DEFAULT_SIDE;
	        this.sideC = DEFAULT_SIDE;
	    }	
	public Triangle(double[] sides) {
		this();
		if(isTriangle(sides)) {
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];
		}
		else {
			 this.sideA = DEFAULT_SIDE;
		        this.sideB = DEFAULT_SIDE;
		        this.sideC = DEFAULT_SIDE;
		}
		}
	public Triangle(double sideA, double sideB, double sideC) {
        if (Triangle.isTriangle(sideA, sideB, sideC)) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        } else {
            this.sideA = DEFAULT_SIDE;
            this.sideB = DEFAULT_SIDE;
            this.sideC = DEFAULT_SIDE;
        }
    }
	public Triangle(Triangle triangle) {
		
		 
        this.sideA = DEFAULT_SIDE;
        this.sideB = DEFAULT_SIDE;
        this.sideC = DEFAULT_SIDE;
    }
	



	
		
	public double getSideA() {
		return sideA;
	}
	
	public double getSideB() {
		return sideB;
	}
	
	public double getSideC() {
		return sideC;
	}
	public double[] getSides() {
		return new double[] {sideA, sideB, sideC};
	}
	public static double lawOfCosines(double a, double b, double c) {
        return Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2.0 * a * b)));
    }
	public double getAngleA() {
		return lawOfCosines(sideC, sideB, sideA);
	}
	public double getAngleB() {
		return lawOfCosines(sideC, sideA, sideB);
	}
	public double getAngleC() {
		return lawOfCosines(sideA, sideB, sideC);
	}
	public double[] getAngles() {
	        return new double[] {getAngleA(), getAngleB(), getAngleC()};
	    }
	public boolean setSideA(double sideA) {
		if(isTriangle(sideA, sideB, sideC)) {
            this.sideA = sideA;
            return true;
        }
        return false;
    }
	public boolean setSideB(double sideB) {
		if(isTriangle(sideA, sideB, sideC)) {
            this.sideB = sideB;
            return true;
        }
        return false;
    }
	public boolean setSideC(double sideC) {
		if(isTriangle(sideA, sideB, sideC)) {
            this.sideC = sideC;
            return true;
        }
        return false;
    }
	 public boolean setSides(double[] sides) {
	        if ( sides==null  || sides.length != 3 ) {
	        	return false;
	        }
	            if(isTriangle(sides[0], sides[1], sides[2])) {
	                this.sideA = sides[0];
	                this.sideB = sides[1];
	                this.sideC = sides[2];
	                return true;
	            } else {
	                return false;
	            }
	        
	        
	    }
	 public static boolean isTriangle(double[] sides) {
	        if (sides != null && sides.length == 3) {
	            if (sides[0] > 0 && sides[1] > 0 && sides[2] > 0) {
	                if (sides[0] + sides[1] > sides[2] && sides[2] + sides[1] > sides[0] && sides[0] + sides[2] > sides[1]) {
	                    return true;
	                }
	            }else {
	                return false;
	            }
	        }
	        return false;
	            

	       }
	    
	
	 public String toString() {
		
	     return POLYGONSHAPE + "(" + String.format("%.4f", sideA) + ", " + String.format("%.4f", sideB) + ", " + String.format("%.4f", sideC) + ")";
	  
		}



	
	
}