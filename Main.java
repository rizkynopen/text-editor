import java.util.Stack;
import java.util.Scanner;

class TextEditor {
    private String text = "";
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    public void write(String newText) {
        undoStack.push(text); 
        redoStack.clear(); 
        text += newText; 
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("tidak ada yang bisa di undo.");
            return;
        }
        redoStack.push(text);
        text = undoStack.pop();  
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("tidak ada yang bisa di-redo.");
            return;
        }
        undoStack.push(text);
        text = redoStack.pop();
    }

    public void show() {
        System.out.println("isi text editor : " + text);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\n==== MENU TEXT EDITOR ====");
            System.out.println("1. Write");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show");
            System.out.println("5. Exit");
            System.out.print("pilih: ");
            int pilihan = input.nextInt();
            input.nextLine();  

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan teks : ");
                    String t = input.nextLine();
                    editor.write(t);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.show();
                    break;

                case 5:
                    System.out.println("Keluar...");
                    return;

                default:
                    System.out.println("pilihan tidak ada!");
            }
        }
    }
}
