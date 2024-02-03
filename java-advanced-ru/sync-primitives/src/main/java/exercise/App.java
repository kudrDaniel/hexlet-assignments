package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        var safetyList = new SafetyList();

        var t1 = new ListThread(safetyList);
        var t2 = new ListThread(safetyList);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Size of safety list - " + safetyList.getSize());
        // END
    }
}

