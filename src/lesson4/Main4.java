package lesson4;

public class Main4 {
    public static void main(String[] args) {
        RelatedList rl = new RelatedList();
        rl.pushHead(new Cat(2, "cat2"));
        rl.pushHead(new Cat(3, "cat3"));
        rl.pushHead(new Cat(4, "cat4"));
        rl.pushHead(new Cat(5, "cat5"));
        rl.pushTail(new Cat(1, "cat1"));
//        System.out.println(rl);
        System.out.println(rl.popHead());
        System.out.println(rl);
        rl.printFromHead();
        rl.printFromTail();
    }
    //reset();
    //next();
    //getCurrent();
    //hasNext();
    //atEnd();
    //insertAfter();
    //*insertBefore();
    //deleteCurrent();

}
