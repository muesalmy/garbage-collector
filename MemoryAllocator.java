import java.util.ArrayList;
import java.util.List;

public class MemoryAllocator {
    private final List<MemoryConsumer> consumers = new ArrayList<>();
    private int count = 0;

    public void allocateMemory() {
        while (true) {
            consumers.add(new MemoryConsumer(1)); // allocate 1MB
            count++;

            System.out.println("Allocated " + count + " MB");

            // Sleep every loop to slow down memory growth
            try {
                Thread.sleep(50); // Lower = faster, Higher = slower
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Clear memory and request GC every 200MB
            if (count % 200 == 0) {
                consumers.clear();
                System.gc();
                System.out.println("Memory cleared and GC suggested.");
                try {
                    Thread.sleep(1000); // Let GC do its work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
