/*
 * WALLLINGER Marc
 * 3AHIF
 */
package prodconsproblem;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author user
 */
public class consumerSemaphore {
    // Randomg gen. and int for data
    Random random = new Random();
    int data;

    static LinkedList<Integer> buffer = new LinkedList<Integer>();
    
    // Upper limit
    static final int limit = 15;

    // Semaphores for consumer and producer
    static Semaphore consumerSemaphore = new Semaphore(0);
    static Semaphore producerSemaphore = new Semaphore(1);
    
    void produce() throws InterruptedException {
        while(true) {
            // Wait for better visibility
            Thread.sleep(1000);

            try {
                if (buffer.size() == limit) {
                    producerSemaphore.acquire();
                }
            }
            catch (InterruptedException ex) {
                // Quit
                System.err.println("Fatal error: "+ex.getMessage());
            }

            data = random.nextInt(1501);
            buffer.add(data);
            System.out.println("Produced: " + data + " (" + buffer.size() + ")");

            if (buffer.size() >= 1){
                consumerSemaphore.release();
            }
        }
    }

    void consume() throws InterruptedException {
        while(true){
            try {
                if (buffer.isEmpty()){
                    consumerSemaphore.acquire();
                }
            }
            catch (InterruptedException e) {
                // Quit
                System.err.println("Fatal error: " + e.getMessage());
            }

            System.out.println("Consumed: " + buffer.getLast() + " (" + buffer.size() + ")");
            buffer.removeLast();

            
            if (buffer.size() == limit - 1) {
                producerSemaphore.release();
            }
            
            // Wait for better visibility
            Thread.sleep(1000);
        }
    }
}
