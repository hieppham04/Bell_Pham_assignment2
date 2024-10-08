import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Driver class for the Doubly Linked List Driver.
 */
public class DoublyLinkedListDriver {

    /**
     * Uses a scanner to get a number and insert it.
     * @param <T> the type of the item
     * @param list the list to insert in
     * @param sc the scanner to use
     * @param type the type of list
     */
    private static <T extends Comparable<T>> void doInsert
    (DoublyLinkedList<T> list, Scanner sc, String type) {
        T item = null;
        if (type.compareTo("i") == 0) {
            System.out.print("Enter a number to insert: ");
            item = (T) (Integer) sc.nextInt();
        } else if (type.compareTo("d") == 0) {
            System.out.print("Enter a number to insert: ");
            item = (T) (Double) sc.nextDouble();
        } else if (type.compareTo("s") == 0) {
            System.out.print("Enter a string to insert: ");
            item = (T) sc.next();
        }
        list.insertItem(item);
        list.print();
        list.printReverse();
    }

    /**
     * Deletes an item from the user.
     * @param <T> the type of the item
     * @param list the list to delete from
     * @param sc the scanner to use
     * @param type the type of the list
     */
    private static <T extends Comparable<T>> void doDelete
    (DoublyLinkedList<T> list, Scanner sc, String type) {
        T item = null;

        if (type.compareTo("i") == 0) {
            System.out.print("Enter a number to delete: ");
            item = (T) (Integer) sc.nextInt();
        } else if (type.compareTo("d") == 0) {
            System.out.print("Enter a number to delete: ");
            item = (T) (Double) sc.nextDouble();
        } else if (type.compareTo("s") == 0) {
            System.out.print("Enter a string to delete: ");
            item = (T) sc.next();
        }
        list.deleteItem(item);

    }

    /**
     * Prints the list.
     * @param <T> the type of the item
     * @param list the list to print
     */
    private static <T extends Comparable<T>> void doPrint(DoublyLinkedList<T> list) {
        list.print();
    }

    /**
     * Prints the reverse of the list.
     * @param <T> the type of the items
     * @param list the list to print the reverse of
     */
    private static <T extends Comparable<T>> void doPrintReverse(DoublyLinkedList<T> list) {
        list.printReverse();
    }

    /**
     * Prints the length of the list.
     * @param <T> the type of the items
     * @param list the list to get the length of
     */
    private static <T extends Comparable<T>> void doLength(DoublyLinkedList<T> list) {
        int len = list.length();
        System.out.println("The length of the list is " + len);
    }

    /**
     * Deletes a subsection of the list.
     * @param <T> the type of the items
     * @param list the list to do the deletion on
     * @param sc the scanner to use for input
     * @param type the type of the list
     */
    private static <T extends Comparable<T>> void doDeleteSubsection
    (DoublyLinkedList<T> list, Scanner sc, String type) {
        T lower = null;
        T upper = null;
        if (type.compareTo("i") == 0) {
            System.out.print("Enter lower bound: ");
            lower = (T) (Integer) sc.nextInt();
            System.out.print("Enter upper bound: ");
            upper = (T) (Integer) sc.nextInt();
        } else if (type.compareTo("d") == 0) {
            System.out.print("Enter lower bound: ");
            lower = (T) (Double) sc.nextDouble();
            System.out.print("Enter upper bound: ");
            upper = (T) (Double) sc.nextDouble();
        } else if (type.compareTo("s") == 0) {
            System.out.print("Enter lower bound: ");
            lower = (T) sc.next();
            System.out.print("Enter upper bound: ");
            upper = (T) sc.next();
        }
        list.printList("Original list: ");
        list.deleteSubsection(lower, upper);
        list.printList("Modified list: ");
    }

    /**
     * Prints the input list and reversed list.
     * @param <T> the type of the items
     * @param list the list to do the prints for
     */
    private static <T extends Comparable<T>> void doReverseList(DoublyLinkedList<T> list) {
        list.printList("Input list: ");
        list.reverseList();
        list.printList("Reversed list: ");
    }

    /**
     * Swaps the alternates and prints.
     * @param <T> the type of the itmes
     * @param list the list to do the prints for
     */
    private static <T extends Comparable<T>> void doSwapAlternate(DoublyLinkedList<T> list) {
        list.printList("Original list: ");
        list.swapAlternate();
        list.printList("Swapped list: ");
    }

    /**
     * The main method.
     * @param args the path to the text file to start the list
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a file name as an argument.");
            return;
        }

        String fileName = args[0];
        File file = new File(fileName);
        Scanner commandInput = new Scanner(System.in);
        Scanner fileInput = null;

        try {
            fileInput = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return;
        }

        System.out.print("Enter list type (i - int, d - double, s - string): ");
        String type = commandInput.next();
        DoublyLinkedList list;

        if (type.compareTo("i") == 0) {
            list = new DoublyLinkedList<Integer>();
            while (fileInput.hasNextInt()) {
                Integer next = fileInput.nextInt();
                list.insertItem(next);
            }
        } else if (type.compareTo("d") == 0) {
            list = new DoublyLinkedList<Double>();
            while (fileInput.hasNextDouble()) {
                Double next = fileInput.nextDouble();
                list.insertItem(next);
            }
        } else if (type.compareTo("s") == 0) {
            list = new DoublyLinkedList<String>();
            while (fileInput.hasNext()) {
                String next = fileInput.next();
                list.insertItem(next);
            }
        } else {
            System.out.println("Invalid type. Exiting.");
            return;
        }


        printCommands();
        doCommands(commandInput, list, type);
    }

    /**
     * Gets the command input from the user.
     * @param commandInput the scanner to use
     * @param list the list being used
     * @param type the type of the items
     */
    private static void doCommands(Scanner commandInput, DoublyLinkedList list, String type) {
        System.out.print("Enter a command: ");
        String command = commandInput.next();
        while (command.compareTo("q") != 0) {
            if (command.compareTo("i") == 0) {
                doInsert(list, commandInput, type);
            } else if (command.compareTo("d") == 0) {
                doDelete(list, commandInput, type);
            } else if (command.compareTo("p") == 0) {
                doPrint(list);
            } else if (command.compareTo("l") == 0) {
                doLength(list);
            } else if (command.compareTo("t") == 0) {
                doPrintReverse(list);
            } else if (command.compareTo("r") == 0) {
                doReverseList(list);
            } else if (command.compareTo("b") == 0) {
                doDeleteSubsection(list, commandInput, type);
            } else if (command.compareTo("s") == 0) {
                doSwapAlternate(list);
            } else {
                System.out.println("Invalid command. Try again");
            }
            System.out.print("Enter a command: ");
            command = commandInput.next();
        }
        System.out.println("Exiting the program...");
    }

    /**
     * Prints the comand options.
     */
    private static void printCommands() {
        System.out.println("Commands:\n" +
            "(i) - Insert value\n" +
            "(d) - Delete value\n" +
            "(p) - Print list\n" +
            "(l) - Length\n" +
            "(t) - Print reverse\n" +
            "(b) - Delete subsection\n" +
            "(s) - Swap alternate\n" +
            "(q) - Quit program");
    }
}
