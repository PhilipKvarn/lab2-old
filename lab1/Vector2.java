public class Vector2 {
    public double x;
    public double y;

    Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    /***
     * Static method which returns the zero-vector
     * @return returns a Vector2 object of the zero-vector
     */
    static public Vector2 zero(){
        return new Vector2(0, 0);
    }

    /***
     * Adds two doubles onto the vector, one for the x-axis and one for the y-axis
     * @param x Value to be added to the x-axis of this vector
     * @param y Value to be added to the y-axis of this vector
     */
    static public Vector2 add(Vector2 v, double x, double y){
        v.x += x;
        v.y += y;
        return v;
    }

    /***
     * Adds two doubles onto the vector, one for the x-axis and one for the y-axis
     * @param x Value to be added to the x-axis of this vector
     * @param y Value to be added to the y-axis of this vector
     */
    public void add(double x, double y){
        this.x += x;
        this.y += y;
    }

    /**
     * Rotates this vector by a angle in degrees.
     * @param rotation the angle, in degrees, which the vector will rotate to.
     */
    public void rotateByDeg(double rotation){
        double convert = Math.PI/180.00;
        double radian = rotation*convert;
        double cos = Math.cos(radian);
        double sin = Math.sin(radian);
        double nextX = x*cos - y*sin;
        this.y = x*sin + y*cos;
        this.x = nextX;
    }

    public static double VectorLength(Vector2 vec){
        return Math.sqrt(vec.x*vec.x + vec.y * vec.y );
    }

    public double VectorLength(){
        return Math.sqrt(this.x*this.x + this.y * this.y );
    }

    public static double VectorAngle(Vector2 vec1, Vector2 vec2){
        double vl1_hyp = vec1.VectorLength();
        double vl2_hyp = vec2.VectorLength();
        double vl1_angle = Math.acos(vec1.x/vl1_hyp);  
        double vl2_angle = Math.acos(vec2.x/vl2_hyp);  
        return (vl2_angle - vl1_angle) % (Math.PI*2);
    }
    

    public static double DotProduct(Vector2 vec1, Vector2 vec2){
        double product = vec1.VectorLength()*vec2.VectorLength()*Math.cos(VectorAngle(vec1, vec2));
        return product;
    } 

    public double DotProduct(Vector2 multVector){
        double product = this.VectorLength()*multVector.VectorLength()*Math.cos(VectorAngle(this, multVector));
        return product;
    }
}
