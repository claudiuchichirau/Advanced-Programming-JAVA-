package laborator_7.compulsory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Robot extends Thread {
    private MapExplorer explorer;
    private Lock lock;
    private int token;
    private int id;

    public Robot(String name, MapExplorer explorer) {
        super(name);
        this.explorer = explorer;
        this.lock = new ReentrantLock();
    }

    public int getToken() {
        return token;
    }

    public void putToken(int token) {
        this.token = token;
    }

    private void move(int row, int col) {
        if (row >= 0 && row < explorer.getN() && col >= 0 && col < explorer.getN()) {
            boolean visited = explorer.visit(row, col, id);
            if (!visited) {
                return;
            }
            lock.lock();
            try {
                if (token > 0) {
                    token--;
                    System.out.println(getName() + " extracted token " + (explorer.getN() * explorer.getN() - token));
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private void moveRandomly() {
        while (true) {
            int row = (int) (Math.random() * explorer.getN());
            int col = (int) (Math.random() * explorer.getN());
            if (row == 0 && col == 0) {
                continue;
            }
            move(row, col);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        this.id = Integer.parseInt(getName().split(" ")[1]);
        while (true) {
            moveRandomly();
        }
    }
}