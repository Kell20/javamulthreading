import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Table table=new Table();
        Semaphore sem=new Semaphore(1,true);

        Tel det1=new Tel("usa",sem,table);
        Tel2 det2=new Tel2("japan",sem,table);

        det1.tet.start();
        det2.th.start();
    }
}

class Table{
    void table(){
        for(int i=1;i<26;i++){
            int v=25*i;
            System.out.printf("25 x %d=%d\n",i,v);
        }
    }
}

class Tel implements Runnable{
    Thread tet;
    String name;
    Semaphore sm;
    Table tel;

    Tel(String name,Semaphore t,Table tel){
        this.name=name;
        tet=new Thread(this);
        sm=t;
        this.tel=tel;
        System.out.println("class 1");
    }

    public void run(){
        try{
            Thread.sleep(9000);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("class1 is running");
        tel.table();
    }
}
class Tel2 implements Runnable{
    Thread th;
    Semaphore sm;
    String name;
    Table tel1;

    Tel2(String name, Semaphore t,Table tel1){
        th=new Thread(this);
        this.name=name;
        sm=t;
        this.tel1=tel1;
        System.out.println("class 2");
    }

    @Override
    public void run(){
        System.out.println("class2 is running");
        tel1.table();
    }
}