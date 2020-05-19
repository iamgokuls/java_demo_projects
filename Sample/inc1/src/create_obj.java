
import java.io.*;
import java.lang.reflect.*;

public class create_obj implements Cloneable, Serializable{
	
	String name1;
	String name2;
	
	 
	public create_obj(String name1, String name2) 
	    { 
	        this.name1 = name1; 
	        this.name2= name2;
	    } 
	public void display() 
		{
		System.out.println(this.name1);
		System.out.println(this.name2);
		}
	@Override
    protected Object clone() throws CloneNotSupportedException 
    	{ 
        return super.clone(); 
    	} 
	
	public static void main(String[] args) {
//1.Creating object of class test using new keyword.
		create_obj obj1 = new create_obj("printing","typing");
		obj1.display();
		
//2.Creating object of class test using New Instance.
		try 
		{
			Class cls = Class.forName("create_obj"); 
			create_obj obj2 = (create_obj) cls.getConstructor(String.class, String.class).newInstance("printing","typing"); 
	        obj2.display();
			
		}
		catch (Exception e) 
        { 
            e.printStackTrace(); 
        } 
        
//3.Creating object of test class using Clone method.
		try
        { 
			create_obj obj3 = (create_obj) obj1.clone(); 
            obj3.display(); 
        } 
        catch (CloneNotSupportedException e) 
        { 
            e.printStackTrace(); 
        } 
		
//4.Using Serialization and dezerialization of objects		
		 try
	     { 
			 	create_obj d = new create_obj("GeeksForGeeks","vjhv"); 
	            FileOutputStream f = new FileOutputStream("object.txt"); 
	            ObjectOutputStream oos = new ObjectOutputStream(f); 
	            oos.writeObject(d); 
	            oos.close(); 
	            f.close(); 
	            d.display();
	     } 
	     catch (Exception e) 
	     { 
	            e.printStackTrace(); 
	     } 
		
		 try
	     { 
			 create_obj d; 
			 FileInputStream f = new FileInputStream("object.txt"); 
	         ObjectInputStream oos = new ObjectInputStream(f); 
	         d = (create_obj)oos.readObject(); 
	     } 
	     catch (Exception e) 
	     { 
	            e.printStackTrace(); 
	     } 
	        //System.out.println(d.name1);
//5.Creating object using newInstance() method of Constructor class.
		 
		 try
	     { 
	            Constructor<create_obj> constructor = create_obj.class.getConstructor(String.class, String.class); 
	            create_obj obj5 = constructor.newInstance("printing","typing"); 
	            obj5.display();
	     }
	     catch (Exception e) 
	     { 
	            e.printStackTrace(); 
	     } 
	        
	}

}

