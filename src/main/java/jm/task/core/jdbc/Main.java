package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        List<User> users = userService.getAllUsers();
        if (users != null) {
            users.forEach(System.out::println);
        } else {
            System.out.println("Список пользователей пуст.");
        }

        userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("John", "Doe", (byte) 30);

        userService.saveUser("Jane", "Smith", (byte) 25);

        userService.saveUser("Michael", "Brown", (byte) 40);

        userService.saveUser("Emily", "Davis", (byte) 35);
        System.out.println("Список пользователей:");

        userService.getAllUsers().forEach(System.out::println);

        userService.cleanUsersTable();
        System.out.println("Таблица пользователей очищена");

        userService.dropUsersTable();
        System.out.println("Таблица пользователей удалена");
    }
}