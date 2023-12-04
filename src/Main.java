import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue messageQueue = new Queue(3); // Khởi tạo một Queue có thể chứa tối đa 3 tin nhắn
        Stack errorStack = new Stack(3); // Khởi tạo một Stack có thể chứa tối đa 3 tin nhắn lỗi

        Scanner scanner = new Scanner(System.in);
        String userMessage;

        // Nhập tin nhắn từ người dùng và đưa vào Queue
        System.out.println("Nhập 3 tin nhắn của bạn: ");
        for (int i = 0; i < 3; i++) {
            userMessage = scanner.nextLine();
            messageQueue.insert(userMessage);
        }

        // Kiểm tra và xử lý tin nhắn
        int count = 0;
        while (!messageQueue.isEmpty()) {
            String message = messageQueue.remove();
            if (message.length() >= 200) {
                errorStack.push(Long.parseLong(message));
                System.out.println("Lỗi : tin nhắn dài hơn 200 ký tự");
            } else {
                // Xử lý tin nhắn
                System.out.println("Xử lý tin nhắn: " + message);
            }
            count++;
            if (count == 3) {
                System.out.println("Lỗi: Gửi 3 tin nhắn nhận 1 tin");
                break;
            }
        }

        // In ra các tin nhắn lỗi trong Stack
        System.out.println("Các tin nhắn lỗi:");
        while (!errorStack.isEmpty()) {
            long error = errorStack.pop();
            System.out.println(error);
       }
    }
}