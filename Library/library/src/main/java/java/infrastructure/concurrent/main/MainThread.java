package java.infrastructure.concurrent.main;

/**
 *  MainThread represents ability to change the execution flow between background thread to UI thread
 */
public interface MainThread {
  /**
   * Run the passed runnable in the UI thread
   * @param runnable
   */
  void run(final Runnable runnable);
  /**
   * Run the passed block in the UI thread
   * @param block
   */
  void run(final MainThreadBlock block);
}
