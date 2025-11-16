import java.util.Stack;
import java.util.Scanner;

class TextEditor {
    private String text = "";
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    public void write(String newText) {
        undoStack.push(text);     // simpan kondisi sebelum menulis
        redoStack.clear();        // redo tidak valid setelah write
        text += newText;          // tambah teks baru
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Tidak ada yang bisa di-undo.");
            return;
        }
        redoStack.push(text);     // simpan kondisi saat ini ke redo
        text = undoStack.pop();   // kembali ke kondisi sebelumnya
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Tidak ada yang bisa di-redo.");
            return;
        }
        undoStack.push(text);     // simpan kondisi sekarang
        text = redoStack.pop();   // pulihkan kondisi lebih baru
    }

    public void show() {
        System.out.println("Isi Text Editor: " + text);
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
            System.out.print("Pilih: ");
            int pilihan = input.nextInt();
            input.nextLine();  

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan teks: ");
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
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
