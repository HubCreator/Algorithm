import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {

        // singleThread로 돌려야 원하는 값을 얻을 수 있음
        ExecutorService service = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Callable<String> world = () -> {
            Thread.sleep(3000L);
            return "world";
        };

        Callable<String> leo = () -> {
            Thread.sleep(1000L);
            return "leo";
        };

        // invokeAll은 세 개의 Callable이 모두 끝날 때까지 기다림
        List<Future<String>> futures = service.invokeAll(Arrays.asList(hello, world, leo));
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
    }
}