package laborator_7.homework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import laborator_7.homework.MapExplorer;

class Robot extends Thread {
    private MapExplorer explorer;
    private Lock lock;
    private int token;
    private int id;
    private boolean isActive;
    private int row; // linia curentă a robotului
    private int col; // coloana curentă a robotului


    public Robot(String name, MapExplorer explorer) {
        super(name);
        this.explorer = explorer;
        this.lock = new ReentrantLock();
        this.isActive = true;
    }

    public int getToken() {
        return token;
    }

//    public boolean getActive() {
//        return isActive;
//    }
//
//    public void setActive(boolean isActive) {
//        this.isActive = isActive;
//    }
//
//    public void putToken(int token) {
//        this.token = token;
//    }

    private void move(int row, int col) {
        if (row >= 0 && row < explorer.getN() && col >= 0 && col < explorer.getN()) {
            boolean visited = explorer.visit(row, col, id);
            if (!visited) {
                return;
            }
            explorer.increaseVisitedCells();
            lock.lock();
            try {
                if (token > 0) {
                    token--;
                    System.out.println(getName() + " extracted token " + (explorer.getN() * explorer.getN() - token));
                }
            } finally {
                lock.unlock();
            }

            this.row = row; // actualizează linia curentă a robotului
            this.col = col; // actualizează coloana curentă a robotului
        }
    }

    private void moveRandomly() {
        while (true) {
            if (explorer.isRobotActive(this.id)) {
                int row = (int) (Math.random() * explorer.getN());
                int col = (int) (Math.random() * explorer.getN());
                if (row == 0 && col == 0) {
                    continue;
                }
                move(row, col);

                int visitedCells = explorer.getVisitedCells();
                if (visitedCells == explorer.getN() * explorer.getN() - 1) {
                    explorer.stopExploration();
                    break;
                }
            }
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                // ignore the exception
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

//    public int getRow() {
//        return row;
//    }
//
//    public int getCol() {
//        return col;
//    }
}