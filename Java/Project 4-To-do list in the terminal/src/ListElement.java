public class ListElement {
    public int value;
    public String name,description;
    public ListElement(int value,String name,String description){
        this.value=value;
        this.name=name;
        this.description=description;
    }
    public void show(){
        System.out.println(value+" "+name+" "+description);
    }
}
