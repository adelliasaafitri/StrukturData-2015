
/**
 * Write a description of class Vector3D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector3D
{
    // instance variables - replace the example below with your own
    private double x,y,z;

    /**
     * Constructor for objects of class Vector3D
     */
    public Vector3D(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        
        
    }
    
        public double getX(){
          //this.x = x;
          return x;
        }
        
        public double getY(){
        //this.y = y;
        return y;
        }
        
        public double getZ(){
        //this.z = z;
        return z;
        }

}