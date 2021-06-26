
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        ATM atm = new ATM("Ngan hang VCB", "Nguyen Van A", 1200000);

        char choice;

        System.out.println(atm.getNameBank() + "kinh chao Quy khach" + atm.getName());
        System.out.println("Menu:");
        System.out.println("\t1. Nhan phim A de kiem tra tai khoan");
        System.out.println("\t2. Nhan phim D de nap tien");
        System.out.println("\t3. Nhan phim W de rut tien");
        System.out.println("\t4. Nhan phim H de xem lich su 3 lan");
        System.out.println("\t5. Nhan phim X de thoat");
        System.out.println("===========================================");

        do {
            System.out.print("\nNhap lua chon cua ban: ");
            choice = scan.next().charAt(0);

            switch (choice) {
                case 'A':
                    atm.getCheckBalance();
                    break;
                case 'D':
                    atm.setDeposit();
                    break;
                case 'W':
                    atm.setWithdraw();
                    break;
                case 'H':
                    atm.checkTradeHistory();
                    break;
                case 'X':
                    atm.exitATM();
                    break;
                default:
                    System.out.println("Ban nhap sai chuc nang");
                    System.out.println("Bam nut theo menu de tiep tuc dich vu ATM");
                    System.out.println("===========================================");
                    break;
            }
        } while (true);
    }
}
