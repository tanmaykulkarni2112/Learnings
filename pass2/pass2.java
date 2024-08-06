 package pass2;

// import java.io.*;
// import java.util.Scanner;
// public class pass2 {
//     static Obj[] symb_table = new Obj[10];
//     static Obj[] literal_table = new Obj[10];
//     static int symb_found = 0;
//     public static void main(String[] args) throws IOException{
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter Total Number of Symbols: ");
//         int total_symb = sc.nextInt();
//         int pos, num;
//         for(int i = 0;  i < total_symb; i++) {
//             symb_table[i] = new Obj("",0);
//             System.out.println("Enter Symbol Name");
//             symb_table[i].addr = sc.nextInt();
//             System.out.println("Enter Symbol Address : ");
//             symb_table[i].addr = sc.nextInt();
//         }
//         System.out.println("Enter the total number of literals");
//         int total_ltr = sc.nextInt();
//         for(int i = 0; i < total_ltr; i++) {
//             literal_table[i] = new Obj("", 0);
//             System.out.println("Enter literal name: ");
//             literal_table[i].name = sc.next();
//             System.out.println("Enter the literal address");
//             literal_table[i].addr = sc.nextInt();
//         }
//         System.out.println("\n ****************SYMBOL TABLE **********");
//         System.out.println("\n SYMBOL \t ADDRESS");
//         for(int i = 0; i <total_symb; i++) {
//             System.out.println(symb_table[i].name + "\t" + symb_table[i].addr);
//             System.out.println("**********LITERAL TABLE ******");
//             System.out.println("\n Index \t Literal \t Address");
//         }
//         for(int i = 0; i < total_ltr; i++) {
//             System.out.println((i+1) + "\t" + literal_table[i].name + "\t" + literal_table[i].addr);
//         }
//         BufferedReader br2 = new BufferedReader(new FileReader("pass2/output.txt"));
//         String line;
//         boolean symbol_error = false , undef_mnemonic = false;
//         System.out.println("*********OUTPUT FILE*********");
//         lab: while((line = br2.readLine()) != null) {
//             String[] token_list = line.split("\\s+",5);
//             symbol_error = undef_mnemonic = false;
//             lab1: for(String token : token_list) {
//                 if (token.length() > 0) {
//                     pos = -1;
//                     if(token.matches("---")){
//                         System.out.println("\t ---");
//                         undef_mnemonic = true;
//                     }
//                     else if (token.matches("[0-9]+")) System.out.println("\n\n" + token);
//                     else{
//                         String letters = token.replaceAll("[^A-za-z]+", "");
//                         num = Integer.parseInt(token.replaceAll("[^0-9]+", ""));
//                         if(token.matches("\\[0-9]+\\")) System.out.println("\t" + num);
//                         else {
//                             switch (letters.toUpperCase()) {
//                                 case "S": if (symb_table[num-1].addr == 0) {
//                                     System.out.println("\t---");
//                                     symbol_error = true;
//                                 } else {
//                                     System.out.println("\t" +symb_table[num-1].addr);
//                                 }
//                                     break;
//                                 case "L": System.out.println("\t" + literal_table[num-1].addr);
//                                     break;
//                                 case "AD": System.out.println("\n");
//                                     continue lab;
//                                 case "DL": switch(num) {
//                                     case 1: System.out.println("\n");
//                                     continue lab;
//                                     case 2: System.out.println("\t 00 \t 00");
//                                     continue lab;
//                                 }
//                                 case "C" : System.out.println("\t" + num);
//                                 break;
//                                 default:
//                                     System.out.println("\t" + "00" + num);
//                             }
//                         }
//                     }
//                 }
//             }
//             if(symbol_error) System.out.println("\n\n ****** SYMBOL IS NOT DEFINED **********");
//             if(undef_mnemonic) System.out.println("************INVALID MNEMONIC **********");
//         }
//         int[] flag = new int[total_symb];
//         for(int i = 0; i < total_symb; i++) {
//             symb_found = 0; 
//             for(int j = 0; j < total_symb; j++) {
//                 if (symb_table[i].name.equalsIgnoreCase(symb_table[j].name) && flag[j] == 0) {
//                     symb_found++;
//                     flag[i] = flag[j] = 1;
//                 } if (symb_found > 1) {
//                     System.out.println(symb_table[i].name +" IS DUPLICATE SYMBOL");
//                 }
//             }
//         }
//         br2.close();
//         sc.close();
//     }
// }





import java.io.*;
import java.util.Scanner;

public class pass2 {
    static Obj[] symb_table = new Obj[10];
    static Obj[] literal_table = new Obj[10];
    static int symb_found = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Total Number of Symbols: ");
        int total_symb = sc.nextInt();
        for (int i = 0; i < total_symb; i++) {
            symb_table[i] = new Obj("", 0);
            System.out.println("Enter Symbol Name:");
            symb_table[i].name = sc.next();
            System.out.println("Enter Symbol Address:");
            symb_table[i].addr = sc.nextInt();
        }

        System.out.println("Enter the total number of literals:");
        int total_ltr = sc.nextInt();
        for (int i = 0; i < total_ltr; i++) {
            literal_table[i] = new Obj("", 0);
            System.out.println("Enter literal name:");
            literal_table[i].name = sc.next();
            System.out.println("Enter the literal address:");
            literal_table[i].addr = sc.nextInt();
        }

        System.out.println("\n ****************SYMBOL TABLE **********");
        System.out.println("\n SYMBOL \t ADDRESS");
        for (int i = 0; i < total_symb; i++) {
            System.out.println(symb_table[i].name + "\t" + symb_table[i].addr);
        }

        System.out.println("\n**********LITERAL TABLE ******");
        System.out.println("\n Index \t Literal \t Address");
        for (int i = 0; i < total_ltr; i++) {
            System.out.println((i + 1) + "\t" + literal_table[i].name + "\t" + literal_table[i].addr);
        }

        BufferedReader br2 = new BufferedReader(new FileReader("pass2/output.txt"));
        String line;
        boolean symbol_error = false, undef_mnemonic = false;
        System.out.println("*********OUTPUT FILE*********");
        lab: while ((line = br2.readLine()) != null) {
            String[] token_list = line.split("\\s+");
            symbol_error = undef_mnemonic = false;
            lab1: for (String token : token_list) {
                if (token.length() > 0) {
                    int num;
                    try {
                        num = Integer.parseInt(token.replaceAll("[^0-9]", ""));
                    } catch (NumberFormatException e) {
                        num = -1; // or handle differently
                    }

                    if (token.matches("---")) {
                        System.out.println("\t ---");
                        undef_mnemonic = true;
                    } else if (token.matches("[0-9]+")) {
                        System.out.println("\n\n" + token);
                    } else {
                        String letters = token.replaceAll("[^A-Za-z]+", "");
                        if (num >= 0) {
                            switch (letters.toUpperCase()) {
                                case "S":
                                    if (num - 1 < total_symb && symb_table[num - 1].addr != 0) {
                                        System.out.println("\t" + symb_table[num - 1].addr);
                                    } else {
                                        System.out.println("\t---");
                                        symbol_error = true;
                                    }
                                    break;
                                case "L":
                                    if (num - 1 < total_ltr) {
                                        System.out.println("\t" + literal_table[num - 1].addr);
                                    } else {
                                        System.out.println("\t---");
                                        symbol_error = true;
                                    }
                                    break;
                                case "AD":
                                    System.out.println("\n");
                                    continue lab;
                                case "DL":
                                    switch (num) {
                                        case 1:
                                            System.out.println("\n");
                                            continue lab;
                                        case 2:
                                            System.out.println("\t 00 \t 00");
                                            continue lab;
                                    }
                                    break;
                                case "C":
                                    System.out.println("\t" + num);
                                    break;
                                default:
                                    System.out.println("\t00" + num);
                            }
                        }
                    }
                }
            }
            if (symbol_error) System.out.println("\n\n ****** SYMBOL IS NOT DEFINED **********");
            if (undef_mnemonic) System.out.println("************INVALID MNEMONIC **********");
        }

        int[] flag = new int[total_symb];
        for (int i = 0; i < total_symb; i++) {
            symb_found = 0;
            for (int j = 0; j < total_symb; j++) {
                if (symb_table[i].name.equalsIgnoreCase(symb_table[j].name) && flag[j] == 0) {
                    symb_found++;
                    flag[i] = flag[j] = 1;
                }
                if (symb_found > 1) {
                    System.out.println(symb_table[i].name + " IS DUPLICATE SYMBOL");
                }
            }
        }

        br2.close();
        sc.close();
    }
}
