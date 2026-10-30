import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static HashMap<Integer, ListElement> list = new HashMap<>();
    public static File file;
    static int value=0;
    public static BufferedWriter writer;
    public static BufferedReader reader;
    final static String location="src/list.txt";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LoadFile();
//        ListElement test=new ListElement(1,"KKK","This is a test");
//        WriteToFile(test);
//        WriteToFile(1,"Test","This is a test");
//        WriteToFile(2,"Test2","This is a test2");
//        WriteToFile(3,"Test3","This is a test3");
//
        for (ListElement element : list.values()) {
            System.out.println(element.value + " " + element.name + " " + element.description);
        }
        int choice=0;
        while(choice!=6){
            System.out.println("1. Add element\n2. Remove element\n3. Update element\n4. Display list\n5. Reload file\n6. Exit");
        switch(choice){
            case 1:
                System.out.println("Enter Title: ");
                String title=sc.nextLine();
                System.out.println("Enter Description: ");
                String description=sc.nextLine();
                value=list.size()+1;
                list.put(value,new ListElement(value,title,description));
                break;
            case 2:
                System.out.println("Enter Id: ");
                value=sc.nextInt();
                System.out.println("This will be removed--");
                list.remove(value);

                break;
            case 3:
                System.out.println("3.Update element");
                break;
            case 4:
                System.out.println("4.Display list");
                break;
            default:
                break;
        }
        ReloadFile();
        }
    }
    static void ReloadFile(){
        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LoadFile();
    }
    static void LoadFile(){
        file = new File(location);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("Error creating file");
            }
        }
        else{
            System.out.println("File already exists");
        }
        System.out.println("Trying to init Writer and Reader");
        try{

            writer=new BufferedWriter(new FileWriter(file));
            reader= new BufferedReader(new FileReader(file));
            System.out.println("Connected");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ParseFileToList();
    }
    static boolean WriteToFile(int value,String name,String description){
        try {
            writer.write(value+","+name+","+description);
            writer.newLine();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static boolean WriteToFile(ListElement ele){
        try {
            writer.write(ele.value+","+ele.name+","+ele.description);
            writer.newLine();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int ParseFileToList(){
        int count=0;
        try {
            String line;
            list =new  HashMap<>();
            while((line=reader.readLine())!=null){
                String[] parts=line.split(",");
                int value=Integer.parseInt(parts[0]);
                String name=parts[1];
                String description=parts[2];
                list.put(value,new ListElement(value,name,description));
                count++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
