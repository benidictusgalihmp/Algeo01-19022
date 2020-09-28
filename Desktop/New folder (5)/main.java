
package algeo;

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
            + "\nMasukkan pilihan anda : ");
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
                    matriks A=new matriks();
                    matriks B=new matriks();
                    B.kol=1;
                    A.InputMatriksSQ();
                    B.bar=A.bar;
                    B.InputMatriks();
                    
                    
                    break;
                }
                
                else if(SPL==4){
                    
                    break;
                }
            
            case 2:
                DETMenu();
                int DET=input.nextInt();
                while(DET>4 || DET<1){
                    System.out.print("Pilihan tidak valid, silahkan ulangi lagi!");
                    DET=input.nextInt();
                }
                        
                if(DET==1){
                    
                    break;
                }
                
                else if(DET==2){
                    
                    break;
                }
             
            
            case 3:
                BalikanMenu();
                int Balik=input.nextInt();
                while(Balik>2 || Balik<1){
                    System.out.print("Pilihan tidak valid, silahkan ulangi lagi!");
                    Balik=input.nextInt();
                }
                        
                if(Balik==1){
                    
                    break;
                }
                
                else if(Balik==2){
                    
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
                                + "\nMasukkan pilihan anda : ");
}

static void DETMenu(){
    System.out.print("\n========Determinan Counting Method========\n"
                                + "1. Metode Reduksi Baris\n"
                                + "2. Metode Ekspansi Kofaktor\n"
                                + "\nMasukkan pilihan anda : ");
}

static void BalikanMenu(){
    System.out.print("\n========SPL METHOD========\n"
                                + "1. Metode Reduksi Baris\n"
                                + "2. Metode Invers dengan Adjoint\n"
                                + "\nMasukkan pilihan anda : ");
}
 
}


