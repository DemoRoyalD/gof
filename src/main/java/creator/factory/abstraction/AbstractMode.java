package creator.factory.abstraction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class AbstractMode {
    public static void main(String[] args) {
        AbstractFactory factoryOne = AbstractFactory.newFactory(AbstractFactory.Factory.ONE);
        Product1 product11 = factoryOne.newProduct1();
        System.out.println(product11.toString());
        product11.show1();
        Product2 product12 = factoryOne.newProduct2();
        System.out.println(product12.toString());
        product12.show2();


    }
}

interface Product1{
    void show1();
}

interface Product2{
    void show2();
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class ConcreteProduct11 implements Product1{
    private String name;

    @Override
    public void show1() {
        System.out.println("|show product |" + this.getName());
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class ConcreteProduct12 implements Product1{
    private String name;

    @Override
    public void show1() {
        System.out.println("|show product |" + this.getName());
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class ConcreteProduct21 implements Product2{
    private String name;

    @Override
    public void show2() {
        System.out.println("|show product |" + this.getName());
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class ConcreteProduct22 implements Product2{
    private String name;

    @Override
    public void show2() {
        System.out.println("|show product |" + this.getName());
    }
}

abstract class  AbstractFactory{
     Product1 newProduct1(){return null;}
     Product2 newProduct2(){return null;}
     public static AbstractFactory newFactory(Factory factory){
         switch (factory){
             case ONE:
                 return new ConcreteFactory1("factory1");
             case TWO:
                 return new ConcreteFactory2("factory2");
             default:
                 return null;
         }
     }

     enum Factory{
         ONE,TWO
     }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ConcreteFactory1 extends AbstractFactory{

    private String name;

    @Override
    public Product1 newProduct1() {
        return new ConcreteProduct11("factory1 produce product1");
    }

    @Override
    public Product2 newProduct2() {
        return new ConcreteProduct21("factory1 produce product2");
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ConcreteFactory2 extends AbstractFactory{

    private String name;

    @Override
    public Product1 newProduct1() {
        return new ConcreteProduct12("factory2 produce product1");
    }

    @Override
    public Product2 newProduct2() {
        return new ConcreteProduct22("factory2 produce product2");
    }
}




