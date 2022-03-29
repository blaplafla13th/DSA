package hw4_20001976.bai7;

import hw4_20001976.bai3.LinkedListQueue;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Session {
    private static final Scanner input = new Scanner(System.in);
    private static ArrayList<Client> clients = new ArrayList<>();
    private static LinkedListQueue<Integer> clientQueue = new LinkedListQueue<>();
    private static int count = 0;
    private static Employee employee = new Employee("Demo");
    private static long start = 0;
    private static boolean onJob;

    public static void main(String[] args) {
        String command;
        while (true) {
            System.out.print("Demo> ");
            command = input.nextLine().toLowerCase().trim();
            run(command);
        }
    }

    private static void run(String command) {
        switch (command) {
            case "enqueue" -> clientQueue.enqueue(++count);
            case "start session" -> {
                if (clientQueue.isEmpty()) {
                    System.out.println("Empty queue");
                    return;
                }
                if (onJob) {
                    System.out.println("end session please");
                    return;
                }
                clientQueue.dequeue();
                employee.addClientCount();
                start = System.currentTimeMillis();
                onJob = true;
            }
            case "end session" -> {
                onJob = false;
                long time = System.currentTimeMillis() - start;
                employee.addTime(time);
            }
            case "new user" -> {
                if (!onJob) {
                    System.out.println("start session please");
                    return;
                }
                System.out.print("Name: ");
                String name = input.nextLine();
                System.out.print("Info: ");
                String info = input.nextLine();
                String phoneNumber = "0" + new DecimalFormat("000000000").format(new Random().nextInt(999999999));
                Client temp = new Client(name, phoneNumber, info);
                System.out.println("Accept:?(y/n)\n" + temp + "\n?");
                String opt = input.nextLine().toLowerCase();
                if (opt.equals("y") || opt.equals("yes")) {
                    System.out.println("Created");
                    clients.add(temp);
                }
            }
            case "search" -> {
                System.out.println("Input phone number: ");
                for (int i = 0; i < clients.size(); i++) {
                    if (clients.get(i).getPhoneNumber().equals(input.nextLine())) {
                        System.out.println("ClientId = " + i);
                        System.out.println(clients.get(i));
                        return;
                    }
                }
                System.out.println("Not found");
            }
            case "edit info" -> {
                System.out.println("ClientId: ");
                Client temp;
                try {
                    int id = Integer.parseInt(input.nextLine());
                    temp = clients.get(id);
                } catch (Exception e) {
                    System.out.println("Not found");
                    return;
                }
                System.out.println(temp);
                System.out.print("Info: ");
                String info = input.nextLine();
                temp.setInfo(info);
                System.out.println("done");
            }
            case "edit name" -> {
                System.out.print("ClientId: ");
                Client temp;
                try {
                    int id = Integer.parseInt(input.nextLine());
                    temp = clients.get(id);
                } catch (Exception e) {
                    System.out.println("Not found");
                    return;
                }
                System.out.println(temp);
                System.out.println("Name: ");
                String name = input.nextLine();
                temp.setName(name);
                System.out.println("done");
            }
            case "info" -> System.out.println(employee);
            case "queue" -> System.out.println(clientQueue.size());
            case "exit" -> {
                System.out.println("Bye!");
                System.exit(0);
            }
            case "help" -> System.out.println("""
                    info: get employee info
                    enqueue: add client to queue
                    start session: dequeue clientQueue and start session
                    end session: end session with Client
                    queue: get how many client in enqueue
                    new user: create client account
                    search: find client by phone number
                    edit info: edit info of client
                    edit name: edit name of client
                    exit: exit program
                    """);
            default -> System.out.println("Unknown input. Type 'help' to get command list");
        }
    }
}
