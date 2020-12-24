package autogaragegui2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



class Data  {
    public String name,post;
    private double salary;

    public Data(String name,String post,double salary) {
        this.name=name;
        this.post=post;
        this.salary=salary;
    }
    
    public void display(){
        System.out.println("\n\nName: "+this.name+"\nPost: "+this.post+"\nSalary: "+this.salary);
        
    }
    
}

public class Employer {
    public Employer() {   
    }
    
    public String list(){
        String list=new String("Employees List");
        File fn=new File("name.txt");
        File fp=new File("post.txt");
        File fs=new File("salary.txt");
        try {
            Scanner sn=new Scanner(fn);
            Scanner sp=new Scanner(fp);
            Scanner ss=new Scanner(fs);
            while(sn.hasNextLine()&&sp.hasNextLine()&&ss.hasNextLine()){
                list+="\n---------------\nName:"+sn.nextLine()+"\nPost:"+sp.nextLine()+"\nSalary:"+ss.nextLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Employer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void saveData(String name,String post,String salary) {
        try {
            System.out.println(name);
            OutputStream fo=new FileOutputStream(new File("name.txt"),true);
            OutputStream fo2=new FileOutputStream(new File("post.txt"),true);
            OutputStream fo3=new FileOutputStream(new File("salary.txt"),true);
            fo.write(name.getBytes(), 0, name.length());
            fo2.write(post.getBytes(), 0, post.length());
            fo3.write(salary.getBytes(), 0, salary.length());
            fo.close();
            fo2.close();
            fo3.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Employer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Employer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
