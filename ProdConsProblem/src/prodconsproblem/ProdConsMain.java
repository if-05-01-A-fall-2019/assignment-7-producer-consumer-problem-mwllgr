/*
 * WALLINGER Marc
 * 3AHIF
 */
package prodconsproblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author user
 */
public class ProdConsMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create pool w/ 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        consumerSemaphore procon = new consumerSemaphore();

        // produce
        executor.execute(new Runnable() {
            @Override
            public void run()
            {
                try {
                    procon.produce();
                } catch (InterruptedException e) {
                    // stop immediately
                    e.printStackTrace();
                }
            }
        });

        // consume
        executor.execute(new Runnable() {
            @Override
            public void run()
            {
                try {
                    procon.consume();
                } catch (InterruptedException e) {
                    // stop immediately
                    e.printStackTrace();
                }
            }
        });

        // bye
        executor.shutdown();
    }
    
}
