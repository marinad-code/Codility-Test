package mytests;

public class Test16_ThreeThreads {
	//public class Test16_ThreeThreads {

	    int status=1;
	    public static void main(String[] args) {

	        Test16_ThreeThreads Test16_ThreeThreads = new Test16_ThreeThreads();

	        Tread1 a=new Tread1(Test16_ThreeThreads);
	        Tread2 b=new Tread2(Test16_ThreeThreads);
	        Tread3 c=new Tread3(Test16_ThreeThreads);

	        a.start();
	        b.start();
	        c.start();
	    }
	}

	class Tread1 extends Thread{
	    Test16_ThreeThreads Test16_ThreeThreads;

	    Tread1(Test16_ThreeThreads Test16_ThreeThreads){
	        this.Test16_ThreeThreads = Test16_ThreeThreads;
	    }

	    @Override
	    public void run() {

	        try{
	            synchronized (Test16_ThreeThreads) {

	                for (int i = 0; i < 10; i++) {

	                    while (Test16_ThreeThreads.status != 1){
	                        Test16_ThreeThreads.wait();
	                    }

	                    System.out.println("thread A ");
	                    Test16_ThreeThreads.status = 2;
	                    Test16_ThreeThreads.notifyAll();
	                }

	            }
	        }catch (Exception e) {
	            System.out.println("Exception 1 :"+e.getMessage());
	        }

	    }

	}

	class Tread2 extends Thread{

	    Test16_ThreeThreads Test16_ThreeThreads;

	    Tread2(Test16_ThreeThreads Test16_ThreeThreads){
	        this.Test16_ThreeThreads = Test16_ThreeThreads;
	    }

	    @Override
	    public void run() {

	        try{
	            synchronized (Test16_ThreeThreads) {

	                for (int i = 0; i < 100; i++) {

	                 
	                    while (Test16_ThreeThreads.status != 2){
	                        Test16_ThreeThreads.wait();
	                    }
	                    System.out.println(" thread B ");
	                    Test16_ThreeThreads.status = 3;
	                    Test16_ThreeThreads.notifyAll();
	                }

	            }
	        }catch (Exception e) {
	            System.out.println("Exception 2 :"+e.getMessage());
	        }

	    }
	}


	class Tread3 extends Thread{

	    Test16_ThreeThreads Test16_ThreeThreads;

	    Tread3(Test16_ThreeThreads Test16_ThreeThreads){
	        this.Test16_ThreeThreads = Test16_ThreeThreads;
	    }

	    @Override
	    public void run() {

	        try{
	            synchronized (Test16_ThreeThreads) {

	                for (int i = 0; i < 100; i++) {

	                
	                    while (Test16_ThreeThreads.status != 3){
	                        Test16_ThreeThreads.wait();
	                    }

	                    System.out.println("  thread C ");
	                    Test16_ThreeThreads.status = 1;
	                    Test16_ThreeThreads.notifyAll();
	                }

	            }
	        }catch (Exception e) {
	            System.out.println("Exception 3 :"+e.getMessage());
	        }

	    }
}
