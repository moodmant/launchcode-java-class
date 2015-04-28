/**
 * Created by dshook on 4/28/15.
 */
public class Computer {
    private String keyboard;
    private int memory;
    private double screen;
    private int processor;
    private String brand;

    public Computer(String keyboard, int memory, double screen, int processor, String b) {
        this.keyboard = keyboard;
        this.memory = memory;
        this.screen = screen;
        this.processor = processor;
        this.brand = b;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String b) {
        this.brand = b;
    }

    public int getProcessor() {
        return this.processor;
    }

    public int getMemory() {
        return this.memory;
    }

    public void setMemory(int mem) {
        this.memory = mem;
    }

    public void addMemory(int newMem) {
        int blah = 2;
        if (this.memory + newMem < 8) {
            this.setMemory(this.memory + newMem);
        } else {
            System.out.println("Max memory reached");
        }
    }

    public static void main(String args[]) {
        Computer c = new Computer("English", 8, 13.5, 10000000, "Lenovo");
        Computer mac = new Computer("English", 4, 15, 1000000, "Apple");

        System.out.println(c.getBrand());
        System.out.println(mac.getBrand());
        c.setBrand("Apple");
        System.out.println(c.getBrand());
        c.addMemory(2);

    }
}
