import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static HashMap<Integer, ListElement> list = new HashMap<>();
    final static String location = "src/list.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadFile();

        int choice = 0;
        while (choice != 6) {
            System.out.println("1. Add element\n2. Remove element\n3. Update element\n4. Display list\n5. Reload file\n6. Exit");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1: {
                    System.out.println("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter Description: ");
                    String description = sc.nextLine();
                    int id = nextId();
                    list.put(id, new ListElement(id, title, description));
                    saveFile();
                    break;
                }
                case 2: {
                    System.out.println("Enter Id: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    if (list.remove(id) != null) {
                        System.out.println("Removed " + id);
                        saveFile();
                    } else {
                        System.out.println("No such id");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter Id: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    ListElement le = list.get(id);
                    if (le == null) {
                        System.out.println("No such id");
                        break;
                    }
                    System.out.println("Enter new Title: ");
                    le.name = sc.nextLine();
                    System.out.println("Enter new Description: ");
                    le.description = sc.nextLine();
                    saveFile();
                    break;
                }
                case 4:
                    for (ListElement e : list.values()) e.show();
                    break;
                case 5:
                    loadFile();
                    break;
                default:
                    break;
            }
        }
    }

    static int nextId() {
        int max = 0;
        for (int k : list.keySet()) max = Math.max(max, k);
        return max + 1;
    }

    static void loadFile() {
        File file = new File(location);
        list = new HashMap<>();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating file");
            }
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",", 3);
                int id = Integer.parseInt(parts[0]);
                list.put(id, new ListElement(id, parts[1], parts.length > 2 ? parts[2] : ""));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void saveFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(location))) {
            for (ListElement ele : list.values()) {
                writer.write(ele.value + "," + ele.name + "," + ele.description);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}