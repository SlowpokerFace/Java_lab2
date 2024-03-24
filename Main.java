import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя входного файла: ");
        String inputFileName = scanner.nextLine();

        System.out.print("Введите имя выходного файла: ");
        String outputFileName = scanner.nextLine();


        HashMap<Character, Integer> charCountMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            while (reader.ready()) {
                String s = reader.readLine();
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                        charCountMap.put(s.charAt(i), charCountMap.getOrDefault(s.charAt(i), 0) + 1);
                    }
                }
            }

        } catch (FileNotFoundException ee) {
            System.out.println(ee.getMessage());
            return;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFileName))) {
            for (char symbol : charCountMap.keySet()) {
                writer.println(symbol + ": " + charCountMap.get(symbol));
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл " + e.getMessage());
            return;
        }


        System.out.println("Результаты подсчета символов записаны в файл: " + outputFileName);
    }

}

