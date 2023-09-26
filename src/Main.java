import java.util.Scanner;

public class Main {
    public static double[] countarr(int antaletantstallda, Scanner val123) {
        double[] anstallda = new double[antaletantstallda];
        for (int i = 0; i < anstallda.length; i++) {
            int anstalldNr = i + 1 ;
            System.out.println("Ange lönen för anställd nummmer " + anstalldNr + ":");
            anstallda [i] = val123.nextInt();
            val123.nextLine();
            anstallda[i] = (double) anstallda [i] * 0.7;
        }
        return anstallda;

    }
    public static int readInt(Scanner val123, String message){
        int userInput = 0;
        int enterCheck = 0;
        do {
            try {
                userInput = val123.nextInt();
                val123.nextLine();
                enterCheck = 1;
            } catch (java.util.InputMismatchException e) {
                System.out.println(message);
                val123.nextLine();
            }
        } while (enterCheck == 0);
        return userInput;
    }

    public static void main(String[] args) {
        Scanner val123 = new Scanner(System.in);
        int enterCheck = 0;
        int userchoose = 0;
        double kontosaldot = 900000;
        System.out.printf("Välkomna! Välj ett av alternativ! %n 1:Betala ut löner till anställda! %n 2:Skapa ny faktura! %n 3:Betala en eller flera fakturor! %n 4:Exit %n");
        do {

            try {
                userchoose = val123.nextInt();
                val123.nextLine();
                if (userchoose >= 1 && userchoose <= 4) {
                    enterCheck = 1;
                } else {
                    System.out.println("Vänligen, välj alternativ 1, 2, 3 eller 4 för att forsätta!: ");

                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Vänligen, välj alternativ 1, 2, 3 eller 4 för att forsätta! (Tänk på att skriva en siffra): ");
                val123.nextLine();
            }
        } while (enterCheck == 0);
        switch (userchoose){
            case 1:
                System.out.println("Ange antal anställda!");
                int antalanst;
                do {
                    antalanst = readInt(val123, "Skriv i siffror!");
                    if(antalanst < 0) {
                        System.out.println("Skriv en giligt antal!");
                    }
                } while(antalanst < 0);
                double[] anstalda = countarr(antalanst, val123);
                for (int i = 0; i < anstalda.length; i++) {
                    System.out.println(anstalda[i]);
                }

                break;
            case 2:
                System.out.println("Skriv din summa!");
                int summakund;
                double summafaktura1 = 0;
                do {
                    summakund = readInt(val123, "Skriv i siffror!");
                    if(summakund < 0) {
                        System.out.println("Skriv en giltigt antal!");
                    }
                } while (summakund < 0);
                double moms = (double)summakund * 0.25;
                summafaktura1 = moms + summakund;
                kontosaldot = kontosaldot - summafaktura1;

                System.out.println("Dim summa är " + summakund + " kronor,moms är " + moms + " din totala summa är " + summafaktura1 + " kronor. Din nya saldot ar" + kontosaldot + " Kronor");


                break;
            case 3:
                System.out.println("Skriv antal fakturor!");
                int fakturor;
                do {
                    fakturor = readInt(val123, "Skriv antal fakturor");
                    if(fakturor < 0) {
                        System.out.println("Skriv en giltigt antal!");
                    }
                } while (fakturor < 0);
                int summafaktura = 0;
                int[] fakturantal = new int [fakturor];
                for (int i = 0; i < fakturantal.length; i++) {
                    int fakturaNr = i + 1;
                    System.out.println("Skriv summan av faktura nummer " + fakturaNr + ":");
                    fakturantal[i] = val123.nextInt();
                    val123.nextLine();
                    if (fakturantal[i] < 0) {
                        System.out.println("Skriv en giltigt summa!");
                        i = i - 1;
                    } else {
                        summafaktura = summafaktura + fakturantal[i];

                    }


                }
                kontosaldot = kontosaldot - summafaktura;
                System.out.println("Din resterande belopp på kontot är " + kontosaldot + " kronor! Ha en trevligt dag!");
                break;
            case 4:
                System.out.println("Bye");
                System.exit(0);
                break;
        }
        val123.close();

    }
}