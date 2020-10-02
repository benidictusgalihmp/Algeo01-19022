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

        menu = input.nextInt();
        switch (menu) {
            case 1:
                SPLMenu();
                SPL=input.nextInt();
                while(SPL>4 || SPL<1){
                    System.out.print("Pilihan tidak valid, silahkan ulangi lagi!");
                    SPL=input.nextInt();
                }
                        
                if(SPL==1){
                    matriks M = new matriks();
                    matriks X = new matriks();
                    M.InputMatrikAug(M);
                    M.MatriksEselon(M);
                    boolean undef = false;
                    int i = M.bar - 1;
                    int j = M.kol - 2;

                    while(i >= 0 && !undef){
                        int count = 0;
                        if(M.SearchNonZeroBrs(M, i, j, 0))
                        {
                            count++;
                            if (M.SearchNonZeroIdxBrs(M, i, j, 0) == i) 
                            {
                                if(count == 1)
                                {
                                    X.M[0][i] = M.M[i][M.kol - 1];
                                }
                                else
                                {
                                    System.out.println("Misalkan x"+j+" sama dengan s"+j);
                                }
                                i--;
                            } 
                            else 
                            {
                                j++;
                            }
                        }
                        else
                        {
                            if (M.M[i][j + 1] == 0) 
                            {
                                i--;
                            } 
                            else 
                            {
                                undef = true;
                                System.out.println("Solusi tidak ada");
                            }
                        }
                    }
                    break;
                }
            
                
                else if(SPL==2){
                    matriks M = new matriks();
                    M.InputMatrikAug(M);
                    M.matriksEselonReduksi(M);

                    break;
                }
             
                else if(SPL==3){
                    matriks A=new matriks();
                    matriks B=new matriks();
                    matriks Adj=new matriks();
                    B.kol=1;
                    System.out.println("\nSilahkan input isi matriks koefisien (A)");
                    A.InputMatriksSQ(A);
                    System.out.println("\nSilahkan input isi matriks B");
                    B.bar=A.bar;
                    B.InputMatriks(B, B.bar, B.kol);
                    Adj=A.MinorKofaktor(A).Transpose(A.MinorKofaktor(A));
                    if(A.Determinan(A)==0){
                        System.out.print("Matriks ini tidak memiliki determinan,"
                                + "\nsehingga pencarian solusinya tidak dapat menggunakan metode matriks balikan."
                                + "\nSilahkan gunakan metode lain");
                    }
                    matriks Inv=new matriks();
                    for (int i=0; i<A.bar; i++) {  
                        for (int j = 0; j<A.kol; j++) { 
                           Inv.M[i][j]=Adj.M[i][j]/A.Determinan(A);
                        }
                    }
                    
                    matriks Hasil=new matriks();
                    for (int i=0; i<A.bar; i++) {  
                        for (int j = 0; j<B.kol; j++) { 
                            for (int k = 0; k<B.bar; k++) { 
                                Hasil.M[i][j]+=(Inv.M[i][k]*B.M[k][j]);
                            }
                        }
                    }
                    
                    for (int i=0; i<A.bar; i++) {  
                           System.out.println("X"+(i+1)+" = "+Hasil.M[i][0]);
                        }
                    
                    
                    break;
                }
                
                else if(SPL==4){
                    
                    break;
                }
        
            
            case 2:
                DETMenu();
                int DET = input.nextInt();
                while(DET>2 || DET<1){
                    System.out.print("Pilihan tidak valid, silahkan ulangi lagi!");
                    DET=input.nextInt();
                }
                        
                if(DET==1){
                    matriks MatriksDt = new matriks();
                    MatriksDt.InputMatriksSQ(MatriksDt);
                    if(MatriksDt.bar == 0){
                        System.out.println("Determinan dari matriks kosong adalah tak terdefinisi !");
                    }
                    else{
                        System.out.println("Determinan matriks tersebut adalah "+ MatriksDt.M[MatriksDt.GetLastIdxBrs(MatriksDt)][MatriksDt.GetLastIdxKol(MatriksDt)]);
                    }
                    break;

                }
                
                else if(DET==2){
                    matriks A=new matriks();
                    A.InputMatriksSQ(A);
                    System.out.println("Determinan matriks tersebut adalah "+ A.Determinan(A));
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
                    matriks M = new matriks();
                    matriks MTemp = new matriks();
                    M.InputMatriksSQ(M);
                    if (M.bar == 0) {
                        System.out.println("Matriks kosong dan matriks balikannya adalah matriks kosong []");
                    }
                    else{
                        M.makeMatriksIdentitas(M, MTemp, M.bar);
                        MTemp.matriksEselonReduksi(MTemp);
                        for (int i = 0; i < M.bar; i++) {
                            for (int j = 0; j < M.bar; j++) {
                                M.M[i][j] = MTemp.M[i][j + M.bar];
                            }
                        }
                        System.out.println("\nInvers matriks tersebut adalah:\n");
                        M.PrintMatriks(M);
                    }
                    break;
                }
                
                else if(Balik==2){
                    matriks A=new matriks();
                    matriks Adj=new matriks();
                    System.out.println("\nSilahkan input isi matriks koefisien (A)");
                    A.InputMatriksSQ(A);
                    Adj=A.MinorKofaktor(A).Transpose(A.MinorKofaktor(A));
                    if(A.Determinan(A)==0){
                        System.out.print("Matriks ini tidak memiliki determinan,"
                                + "\nsehingga pencarian solusinya tidak dapat menggunakan metode matriks balikan."
                                + "\nSilahkan gunakan metode lain");
                    }
                    System.out.println("\nInvers matriks tersebut adalah:\n");
                    for (int i=0; i<A.bar; i++) {  
                        for (int j = 0; j<A.kol; j++) { 
                           System.out.print(Adj.M[i][j]/A.Determinan(A)+" ");
                        }
                        System.out.println();
                    }
                    
                    break;
                }
             
            
            case 4:
        
            case 5:
        
            case 6:
                continue;
            default: 
                System.out.print("\nInput menu tidak valid, silahkan input kembali!\n");
            }
        }while(menu != 6);
        System.out.print("\nTerimakasih telah menggunakan layanan kami ^^ \n");
    }
    
    

static void SPLMenu(){
    System.out.print("\n========SPL Method========\n"
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
    System.out.print("\n========Inverse Matrix Method========\n"
                                + "1. Metode Reduksi Baris\n"
                                + "2. Metode Invers dengan Adjoint\n"
                                + "\nMasukkan pilihan anda : ");
}


}
