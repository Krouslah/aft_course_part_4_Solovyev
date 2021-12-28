import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner src = new Scanner(System.in);
        int i = 1;
        while (i != 0) {
            i = mainMenuCycle(src);
            if (i == 1) {
//      Практическая 1
                System.out.println("Количество пробелов в строке: " + count(src.nextLine()));
//      Конец Практической 1 (исключая написанный метод count)
            }
            if (i == 2){
//      Практическая 2
                print(src.nextDouble());
//      Конец практической 2
            }
            if (i == 3){
//      Практическая 3
                System.out.print("Введите число: ");
                Thread.sleep(2000);
                String a = src.next();
                System.out.print("Введите количество листов: ");
                int listCount = src.nextInt();
                List<List<Integer>> hugeList = new ArrayList<>();
                while (listCount > 0){
                    List<Integer> smallList = new ArrayList<>();
                    listCount-=1;
                    System.out.print("Введите количество элементов в листе: ");
                    int listElementsCount = src.nextInt();
                    for(int k = listElementsCount; k>0; k--){
                        smallList.add(src.nextInt());
                    }
                    System.out.println(smallList);
                    hugeList.add(smallList);
                    System.out.println(hugeList);
                }
                System.out.println(check(a, hugeList));
//      Конец практической 3
            }
            if (i == 4){
                System.out.print("Введите количество элементов в массиве: ");
                int elementCount = src.nextInt();
                int[] array = new int[elementCount];
                for (int j = 0; j < elementCount; j++) {
                    array[j] = src.nextInt();
                }
                System.out.print("Введите число: ");
                int number = src.nextInt();
                System.out.println(checkForSum(number,array));
            }
            if (i == 5){
                Map<String, Double> studentMap = new HashMap<>();
                System.out.print("Введите количество студентов в карте: ");
                int countStudents = src.nextInt();
                for (int j = 0; j < countStudents; j++) {
                    System.out.println("Введите фамилию студента №"+(j+1));
                    String secondName = src.next();
                    System.out.println("Введите средний балл студента "+ secondName);
                    double score = src.nextDouble();
                    studentMap.put(secondName, score);
                }
                Map.Entry<String, Double> studentMax = checkForHighestScore(studentMap);
                System.out.println("Студент " + studentMax.getKey() + " с максимальным средним баллом: "+studentMax.getValue());
            }
        }
    }
    public static int count(String line){
        int i = line.length();
        int count = 0;
        while (i != 0){
            if (line.charAt(i - 1) == ' ')
                count += 1;
            i-=1;
        }
        return count;
    }
    public static void print(double number){
        while (number != 0){
            System.out.print(number + " ");
            number -= 1;
        }
        System.out.println();
    }
    public static int mainMenuCycle(Scanner src) {
        System.out.println("Введите номер практической для проверки или 0 для завершения работы");
        return src.nextInt();
    }
    public static boolean check(String line, List<List<Integer>> hugeList){
        try {
            for (int i = 0; i < line.length(); i++) {
                if (Integer.parseInt(String.valueOf(line.charAt(i))) != hugeList.get(i).size())
                    return false;
            }
        }
        catch (IndexOutOfBoundsException ei){return false;}
            return line.length() == hugeList.size();

    }
    public static boolean checkForSum(int number, int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (number == array[j]+array[i])
                    return true;
            }

        }
        return false;
    }
    public static Map.Entry<String, Double> checkForHighestScore (Map<String, Double> studentMap){
        Map.Entry<String, Double> studentMax = null;
        for (Map.Entry<String, Double> student:studentMap.entrySet()) {
            if (studentMax == null) {studentMax = student; continue;}
            if (studentMax.getValue() < student.getValue())
                studentMax = student;
        }
        return studentMax;
    }
}