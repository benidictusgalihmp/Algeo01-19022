
package algeo;

import java.util.Scanner;

/**
 * Package dibuat seragam aja ya namanya algeo
 * @author HP
 */
import java.util.Scanner;
public class main {
static Scanner input = new Scanner(System.in);
public static void main(String[] args) {
    int menu;
    int SPL;
    do{
        System.out.print("\n========MENU========\n"
            + "1. Sistem Persamaan Linier\n"
            + "2. Determinan\n"
            + "3. Matriks Balikan\n"
            + "4. Interpolasi Polinom\n"
            + "5. Regresi Liner Berganda\n"
            + "6. Keluar\n"
            + "Masukkan pilihan anda : ");
        menu=input.nextInt();
        switch (menu) {
            case 1:
                SPLMenu();
                SPL=input.nextInt();
                while(SPL>4 || SPL<1){
                    System.out.print("Pilihan tidak valid, silahkan ulangi lagi!");
                    SPL=input.nextInt();
                }
                        
                if(SPL==1){
                    
                    break;
                }
                
                else if(SPL==2){
                    
                    break;
                }
             
                else if(SPL==3){
                    
                    break;
                }
               
            case 2:
                SPLMenu();
                SPL=input.nextInt();
                while(SPL>4 || SPL<1){
                    System.out.print("Pilihan tidak valid, silahkan ulangi lagi!");
                    SPL=input.nextInt();
                }
                        
                if(SPL==1){
                    
                    break;
                }
                
                else if(SPL==2){
                    
                    break;
                }
             
                else if(SPL==3){
                    
                    break;
                }

            case 3:
                SPLMenu();
                SPL=input.nextInt();
                while(SPL>4 || SPL<1){
                    System.out.print("Pilihan tidak valid, silahkan ulangi lagi!");
                    SPL=input.nextInt();
                }
                        
                if(SPL==1){
                    
                    break;
                }
                
                else if(SPL==2){
                    
                    break;
                }
             
                else if(SPL==3){
                    
                    break;
                }

            case 4:
                
            case 5:
            }
        }while(menu!=6);
               

    }
    
    

static void SPLMenu(){
    System.out.print("\n========SPL METHOD========\n"
                                + "1. Metode Eliminasi Gauss\n"
                                + "2. Metode Eliminasi Gauss-Jordan\n"
                                + "3. Metode Matriks Balikan\n"
                                + "4. Kaidah Cramer\n"
                                + "Masukkan pilihan anda ");
}


 public static int[][]T(int T[][],int m, int n){
    for(int i=0; i<=m; i++){
        for(int j=0; j<=n; j++){
            System.out.println("Masukkan elemen matriks baris "+i+"kolom "+j);
            T[i][j]=input.nextInt();
        }    
}
    return T;
}
}


