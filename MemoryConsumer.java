public class MemoryConsumer {
    private byte[] memoryBlock;

    public MemoryConsumer(int sizeInMB) {
        // Allocate a block of memory of specified size in MB
        this.memoryBlock = new byte[sizeInMB * 1024 * 1024];
    }
}
