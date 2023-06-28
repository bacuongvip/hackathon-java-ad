package bai2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so 10 chữ số: " );
        String numbers = scanner.nextLine();
        if(numbers.length() != 10) {
            System.err.println("Chuỗi không phải 10 số ");
        } else {
            boolean check = true;
            for (int i = 0; i < 10; i++) {
                if (!Character.isDigit(numbers.charAt(i))){
                    System.err.printf("Kí tự thứ %d không phải là số\n", i + 1);
                    check = false;
                }
            }
            if(check){
                for( int i = 0; i < numbers.length(); i++ ){
                    stack.push(numbers.charAt(i));
                }
                int result = 0;
                int index = 1;
                while (!stack.isEmpty()) {
                    result += Integer.parseInt(String.valueOf(stack.pop())) * index;
                    index++;
                }
                if(result % 11 == 0) {
                    System.out.println("Chuỗi là ISBN");
                }
            }
        }
    }
}
