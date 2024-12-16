If you want to access static variables/ static methods  inside a non static method or non static area then you need to access it by className. 

```
public void sayHello(){
        Main.main(new String[10]);
    }

    public static void main(String[] args) {

}
```


If you want to access non static variables/ methods into static area then you need to create object of the class then you will be able to access it. 

```
public void sayHello(){
        
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.sayHello();
    }
```


Default :
        1. if we are using default access modifier then variables and methods are accessible only inside same package but outside the package they are not accesible. 

Private:
        1. if you are using private access modifier with variables and methods then variables and methods are accesible inside same class but outside class not accessible. 

Public :
        1. if we are using public access modifier with variables and methods then it is accesible everywhere. 

* Inheritance 

        1. Child class can use reference of parent class but parent class cannot use reference of child class. 
        2. If we are using reference of Parent class and object of child class then whatever methods and variables present in parent class then that variables and method will only be accesible. 
