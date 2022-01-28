package creator.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class Main {
    public static void main(String[] args) {

        Decorator builder1 = new ConcreteDecorator1(new Parlour());
        ProjectManager manager = new ProjectManager();
        manager.setDecorator(builder1);
        Parlour parlour1 = manager.decorate();
        System.out.println(parlour1.toString());


        Decorator builder2 = new ConcreteDecorator1(new Parlour());
        manager.setDecorator(builder2);
        Parlour parlour2 = manager.decorate();
        System.out.println(parlour2.toString());
    }
}

@Data
@ToString
class Parlour{
    private String wall;
    private String tv;
    private String sofa;
}

interface Decorator{
    void buildWall();
    void buildTV();
    void buildSofa();
    Parlour getResult();
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ConcreteDecorator1 implements Decorator{
    private Parlour parlour;

    @Override
    public void buildWall() {
        this.parlour.setWall("set wall by decorator1");
    }

    @Override
    public void buildTV() {
        this.parlour.setTv("set tv by decorator1");
    }

    @Override
    public void buildSofa() {
        this.parlour.setSofa("set sofa by decorator1");
    }

    @Override
    public Parlour getResult() {
        return this.parlour;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ConcreteDecorator2 implements Decorator{
    private Parlour parlour;

    @Override
    public void buildWall() {
        this.parlour.setWall("set wall by decorator2");
    }

    @Override
    public void buildTV() {
        this.parlour.setTv("set tv by decorator2");
    }

    @Override
    public void buildSofa() {
        this.parlour.setSofa("set sofa by decorator2");
    }

    @Override
    public Parlour getResult() {
        return this.parlour;
    }
}

@Data
class ProjectManager{
    private Decorator decorator;

    public Parlour decorate(){
        this.decorator.buildSofa();
        this.decorator.buildTV();
        this.decorator.buildWall();
        return decorator.getResult();
    }
}

