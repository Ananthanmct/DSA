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
