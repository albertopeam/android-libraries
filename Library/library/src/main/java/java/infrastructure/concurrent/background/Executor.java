package java.infrastructure.concurrent.background;

/**
 * Executor can be used to execute tasks in background threads
 */
public interface Executor {
    /**
     * Runs a interactor in a bg thread
     * @param interactor: piece of code executed in bg
     */
    void run(final Interactor interactor);
}
