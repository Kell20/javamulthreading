public class Main{
    public static void main(String []args){
       th thread1=new th();
       thread1.tel.start();       
    }
}
class th implements Runnable{
    Thread tel;
    th(){
      tel=new Thread(this);
    }

   @Override
    public void run(){
        try{
            Thread.sleep(7000);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("hello..this is simple multthreading program");
    }
}