package exercise;

// BEGIN
class ListThread extends Thread {
    private final SafetyList list;

    public ListThread(SafetyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (this) {
                try {
                    this.wait(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (i % 2 == 0) {
                this.list.add(i);
            } else {
                this.list.add(i * -1);
            }
        }
    }
}
// END
