public class ThreadsTesting {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Runnable task = () -> {
                System.out.println("I am a new task");
            };
            Thread theJob = new Thread(task);
            theJob.start();
        }
    }
}
