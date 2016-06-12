package java.infrastructure.concurrent.background;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executor can be used to execute tasks in background threads
 */
public class ExecutorImpl implements Executor, java.util.concurrent.Executor {

    private int NUM_THREADS = 0;
    private ExecutorService executor;


    /**
     * Returns a new ThreadExecutor with n threads where n is the number of processors availables
     */
    public ExecutorImpl() {
        NUM_THREADS = Runtime.getRuntime().availableProcessors();
        executor = Executors.newFixedThreadPool(NUM_THREADS);
    }

    /**
     * Returns a new ThreadExecutor with int threads
     */
    public ExecutorImpl(int threads) {
        NUM_THREADS = threads;
        executor = Executors.newFixedThreadPool(NUM_THREADS);
    }


    /**
     * Runs a interactor in a bg thread
     * @param interactor: piece of code executed in bg
     */
    @Override
    public void run(Interactor interactor) {
        if (interactor == null){
            throw new IllegalArgumentException("Interactor can't be null");
        }
        execute(interactor);
    }

    @Override
    public void execute(Runnable runnable) {
        if (runnable == null){
            throw new IllegalArgumentException("Runnable can't be null");
        }
        executor.execute(runnable);
    }
}
