/**
 * Авторо программы - HomeWork_5, СергейЯ. Дата создания: 10.10.16.
 * Наследование классов.
 */
import java.util.*;

class HomeWork_5{

    public static void main(String[] args) {
        // Animal a = new Animal("Bobik","blaсk",7,4,4,4);
        // a.show();
        Animal[] Animals = new Animal[3];
        Animals[0] = new Dog("Bobik","blaсk",7);
        Animals[1] = new Horse("Cool","white",37);
        Animals[2] = new Cat("Bars","broune",17);

        for (Animal i : Animals) {
            i.show();
            System.out.println(i.Run());
            System.out.println(i.Swim());
            System.out.println(i.Jump());
        }
    }
}


class Animal {
    protected String name, color;
    protected int  age, run, swim, jump;

    Animal (String name, String color, int age, int run, int swim, int jump) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.run = run;
        this.swim = swim;
        this.jump = jump;
    }

    int Run  () { return run; }
    int Swim () { return run; }
    int Jump () { return jump; }

    void show() {
        System.out.println(name +", color:"+ color +", age:"+ age +", speed run:"+ run +", speed swim:"+ swim +", height jump:"+ jump);
    }

}

class Dog extends Animal {
    Dog (String name, String color, int age) {
        super(name, color, age, 20, 30, 50);
    }
}

class Horse extends Animal {
    Horse (String name, String color, int age) {
        super(name, color, age, 50, 40, 120);
    }
}

class Cat extends Animal {
    Cat (String name, String color, int age) {
        super(name, color, age, 10, 0, 200);
    }     
} 










