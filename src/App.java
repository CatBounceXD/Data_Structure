import com.datastruct.Bst.MyLinearList;;

class MyData   
{
    int id;
    String name;
    
    MyData(int theid, String thename)
    {
        id = theid;
        name = thename;
    }

    @Override //toString dari class String
    public String toString()
    {
        return (Integer.toString(id) + ": " + name + " ");
    }
}

public class App 
{
     public static void main(String[] args) 
     {
        MyLinearList<Integer> List1 = new MyLinearList<>();
        List1.pushQ(10);
        List1.pushQ(20);
        List1.pushQ(30);
        List1.cetakList();

        MyLinearList<Character> List2 = new MyLinearList<>();
        List2.pushS('a');
        List2.pushS('b');
        List2.pushS('c');
        String out;
        while (!List2.isEmpty())
        {
            out = List2.remove().toString();
            System.out.print(out);
        }
        System.out.println();

        MyLinearList<MyData> List3 = new MyLinearList<>();
        MyData data1 = new MyData(1, "Lely");
        MyData data2 = new MyData(2, "Hiryanto");
        MyData data3 = new MyData(3, "Bella");

        List3.pushS(data1);
        List3.pushS(data2);
        List3.pushS(data3);
        List3.cetakList();
        if(List3.remove(data2))
            System.out.println("Berhasil!");
        List3.cetakList();
     }   
}
