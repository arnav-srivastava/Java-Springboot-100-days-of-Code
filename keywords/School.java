package keywords;

class Student{
    void studClass(){
        System.out.println("Student is studying in class");
    }
}

public class School extends  Student{

    String name;

    //this keyword
    School(String name){
        this.name=name;
    }
 // use of super keyword to class parent class function
    void studClass(){
        super.studClass();
        System.out.println("after student data this school print");
    }

    //static keyword
    static int add(int a, int b){
       return a+b;
    }

    //final keyword
    final int phone=987654322;

    public static void main(String[] args) {

        School s = new School("MySchool");
        s.studClass();
        System.out.println(School.add(5, 10));

    }
}
