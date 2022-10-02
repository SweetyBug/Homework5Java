import java.lang.reflect.Array;
import java.util.*;

public class Task1 {
    public static Scanner iScan = new Scanner(System.in);
    public static Map<String, List<String>> pb = new HashMap<>();
    public static void main(String[] args) {
        boolean i = true;
        while (i) {
            System.out.println("Выберите цифру");
            System.out.println(menu());
            String user = iScan.nextLine();
            if (user.equals("4")) {
                System.out.println("Пока!");
                break;
            }else if (user.equals("1")) {
                System.out.println(addUser());
            } else if (user.equals("2")) {
                System.out.println(insert());
            } else if (user.equals("3")) {
                System.out.println(phoneBook());
            }
        }
    }

    public static Map<String, List<String>> phoneBook() {
        return pb;
    }

    public static String addUser() {
        boolean i = false;
        String s = null;
        while (i == false) {
            System.out.println("Проименуйте контакта: ");
            String userName = iScan.nextLine();
            if (userName.equals("end")) {
                break;
            } else if (pb.containsKey(userName)) {
                System.out.println("Даный контакт уже есть в списке!");
                System.out.println("Дополнить контакт номером можно в другом разделе");
                System.out.println("Для выхода введите\"end\"");
                System.out.println();
            } else {
                System.out.println("Введите номер телефона.");
                System.out.println("Если номеров несколько укажите их через пробел: ");
                String userPhone = iScan.nextLine();
                String[] up = userPhone.split(" ");
                ArrayList<String> temp = new ArrayList<>();
                for (String item:up) {
                    temp.add(item);
                }
                pb.put(userName, temp);
                i = true;
                s = "Контакт успешно добвален!";
            }
        }
        return s;
    }

    public static String insert() {
        String s = null;
        boolean i = false;
        while (i == false) {
            System.out.println("Введите контакта, которому хотите добавить номер");
            System.out.println(pb.keySet());
            String userName = iScan.nextLine();
            if (userName.equals("end")) {
                break;
            } else if (!pb.containsKey(userName)) {
                System.out.println("Вы ошиблись, такого контакта нет.");
                System.out.println("Создать контакт можно в другом разделе");
                System.out.println("Для выхода введите\"end\"");
                System.out.println();
            } else {
                System.out.println("Введите номер телефона.");
                System.out.println("Если номеров несколько укажите их через пробел: ");
                String userPhone = iScan.nextLine();
                String[] up = userPhone.split(" ");
                for (String item : up) {
                    pb.get(userName).add(item);
                }
                i = true;
                s = "Контакт успешно добвален!";
            }
        }
        return s;
    }
    public static String menu() {
        String userMenu = "1. Создать контакт\n" +
                        "2. Добавить номер к существующему контакту\n" +
                        "3.Посмотреть контакты\n" +
                        "4.Выйти";
        return userMenu;
    }
}
