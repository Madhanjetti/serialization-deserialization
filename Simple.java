
import java.io.*;

class Employee implements Serializable {
    int eid;
    String ename;
    double esalary;

    public Employee(int eid,
            String ename,
            double esalary) {
        this.eid = eid;
        this.ename = ename;
        this.esalary = esalary;
    }
}

// Serialnddeserial
class Simple {
    public static void serializationImpl() throws Exception {
        Employee emp = new Employee(1, "madhan", 10000);
        FileOutputStream fos = new FileOutputStream("D:/output/test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(emp);
        oos.flush();
        oos.close();
    }

    public static void normalReadFile() throws Exception {

        File f = new File("D:/output/test.txt");

        FileReader fr = new FileReader(f);

        BufferedReader br = new BufferedReader(fr);

        String a = br.readLine();

        System.out.println(a);

        br.close();
    }

    public static void deserializationImpl() throws Exception {

        FileInputStream fis = new FileInputStream("D:/output/test.txt");

        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee empObj = (Employee) ois.readObject();

        System.out.println(empObj.eid + " " + " " + empObj.ename + "" + empObj.esalary);
        ois.close();
    }

    public static void main(String args[]) throws Exception {

        serializationImpl();

        normalReadFile();

        deserializationImpl();
    }
}