package exercise;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.CompletableFuture;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String fp1, String fp2, String fpr) throws NoSuchFileException {
        Path dest = Paths.get(fpr).toAbsolutePath().normalize();
        if (Files.notExists(dest)) {
            try {
                Files.createFile(dest);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        var asyncRead1 = CompletableFuture.supplyAsync(() -> {
           try {
               return String.join("", Files.readAllLines(
                       Paths.get(fp1).toAbsolutePath().normalize()
               ));
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
        }).exceptionally(e -> {
            System.out.println(e);
            return e.toString();
        });
        var asyncRead2 = CompletableFuture.supplyAsync(() -> {
            try {
                return String.join("", Files.readAllLines(
                        Paths.get(fp2).toAbsolutePath().normalize()
                ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(e -> {
            System.out.println(e);
            return e.toString();
        });
        return asyncRead1.thenCombine(asyncRead2,(con1, con2) -> {
            String result = con1.trim() + "\n" + con2.trim();
            try {
                Files.writeString(dest, result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result;
        }).exceptionally(e -> {
            System.out.println(e);
            return e.toString();
        });
    }

    public static CompletableFuture<Long> getDirectorySize(String p) {
        return CompletableFuture.supplyAsync(() -> {
            try (var files = Files.walk(Paths.get(p).toAbsolutePath().normalize(), 1, FileVisitOption.FOLLOW_LINKS)) {
                return files.map(file -> {
                    if (!Files.isDirectory(file)) {
                        try {
                            return Files.size(file);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        return 0L;
                    }
                }).reduce(0L, Long::sum);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        var fp1 = Path.of(App.class.getClassLoader().getResource("file1.txt").toURI()).toString();
        var fp2 = Path.of(App.class.getClassLoader().getResource("file2.txt").toURI()).toString();

        try {
            System.out.println(unionFiles(fp1, fp2, "dest.txt").get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(getDirectorySize(".").get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // END
    }
}

