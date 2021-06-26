import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;

public class ATM extends Account {
//    private final int capacity = 100000000;
    private String nameBank;
    ArrayList<String> tradeHistory = new ArrayList<String>();

    public ATM() {

    }

    public ATM(String nameBank, String name, int accountBalance) {
        super(name, accountBalance);
        this.nameBank = nameBank;
    }

    public String getNameBank() {
        return nameBank;
    }

    public int checkBalance() {
        return super.getAccountBalance();
    }

    public void getCheckBalance() {
        System.out.println("So du tai khoan khach hang la:" + checkBalance());
        System.out.println("Bam nut theo menu de tiep tuc dich vu ATM");
        System.out.println("===========================================");
    }

    public void deposit(int amount) {
        super.addToBalance(amount);
    }

    public void withdraw(int amount) {
        super.subFromBalance(amount);
    }

    public void setDeposit() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Giao dich nap tien");
        System.out.print("Vui long nhap so tien: ");
        int amountDeposit = 0;

        try {
            amountDeposit = scan.nextInt();
        } catch (InputMismatchException e) {
            e.getStackTrace();
            System.out.println("Gia tri khong hop le");
            System.out.println("Bam nut theo menu de tiep tuc dich vu ATM");
            System.out.println("===========================================");
            return;
        }

        if (amountDeposit == 0) {
                System.out.println("So tien nap khong phu hop! Vui long thuc hien lai giao dich");
            } else {
                deposit(amountDeposit);
                System.out.println("Giao dich thanh cong. Ban vua nap " + amountDeposit + "VND thanh cong");
                System.out.println("So du tai khoan cua khach hang la: " + checkBalance() + "VND");
                System.out.println("Bam nut theo menu de tiep tuc dich vu ATM");
                System.out.println("===========================================");
                tradeHistory.add("Nap tien: " + amountDeposit + "VND");
            }
        }

    public void setWithdraw() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Giao dịch Rut tien");
        System.out.print("Vui long nhap so tien: ");
        int amountWith = 0;

        try {
            amountWith = scan.nextInt();
        } catch (InputMismatchException e) {
            e.getStackTrace();
            System.out.println("Gia tri khong hop le");
            System.out.println("Bam nut theo menu de tiep tuc dich vu ATM");
            System.out.println("===========================================");
            return;
        }

        if (amountWith > getAccountBalance()) {
            System.out.println("So tien nap khong phu hop! Vui long thuc hien lai giao dich");
            System.out.println("Bam nut theo menu de tiep tuc dich vu ATM");
            System.out.println("===========================================");
        } else {
            withdraw(amountWith);
            System.out.println("Giao dich thanh cong. Ban vua rut " + amountWith + "VND thanh cong");
            System.out.println("So du tai khoan cua khach hang la: " + checkBalance() + "VND");
            System.out.println("Bam nut theo menu de tiep tuc dich vu ATM");
            System.out.println("===========================================");
            tradeHistory.add("Rut tien: " + amountWith + "VND");
        }
    }

    public void checkTradeHistory() {
        for(int i = tradeHistory.size() - 1, j = 1; i > tradeHistory.size() - 4 && i >= 0; i--, j++) {
            System.out.println(j + ". " + tradeHistory.get(i));
        }
        System.out.println("Bam nut theo menu de tiep tuc dich vu ATM");
        System.out.println("===========================================");
    }

    public void exitATM() throws IOException {
        writeFile();
        System.out.println("Cam on ban da su dung dich vu " + "ATM");
        System.exit(0);
    }

    public void writeFile() throws IOException {
        try {
            Date now = new Date();
            FileWriter fw = new FileWriter("inforCustomer.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("\n" + String.valueOf(now));
            bw.write("\n" + toString() + "\n");
            for (int i = 0; i < tradeHistory.size(); i++) {
                bw.write((i + 1) + ". " + tradeHistory.get(i) + "\n");
            }
            bw.write("\n");
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    @Override
//    public String toString() {
//        return "ATM{" +
//                ", nameBank='" + nameBank + '\'' +
//                ", amount=" + amount +
//                ", tradeHistory=" + tradeHistory +
//                ", scan=" + scan +
//                '}';
//    }
}
