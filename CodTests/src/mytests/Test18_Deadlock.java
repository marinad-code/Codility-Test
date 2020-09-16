package mytests;

public class Test18_Deadlock {
	
	     
	    public static void main(String args[]) {
	         
	        final Object resourceOne = "res1";
	        final Object resourceTwo = "res2";
	         
	        new Thread(new Runnable() {
	             
	            @Override
	            public void run() {
	                 
	                synchronized(resourceOne) {
	                    System.out.println(Thread.currentThread().getName() + " accquired resource 1");
	                    try {
	                        Thread.sleep(2000);
	                    } catch (InterruptedException e) {
	                        
	                        e.printStackTrace();
	                    }
	                    synchronized(resourceTwo) {
	                        System.out.println(Thread.currentThread().getName() + " accquired resource 2");
	                    }
	                }
	            }
	        }).start();
	         
	        new Thread(new Runnable() {
	             
	            @Override
	            public void run() {
	                synchronized(resourceTwo) {
	                    try {
	                        Thread.sleep(2000);
	                    } catch (InterruptedException e) {
	                       
	                        e.printStackTrace();
	                    }
	                    System.out.println(Thread.currentThread().getName() + " accquired resource 2");
	                    synchronized(resourceOne) {
	                        System.out.println(Thread.currentThread().getName() + " accquired resource 1");
	                    }
	                }
	            }
	        }).start();
	         
	    }
	 
	}

