import java.util.Scanner;
public class matriks {
static Scanner input=new Scanner(System.in);
    int bar;
    int kol;
    int idxeff;
    float [][]M=new float[100][100];
     matriks() {
        for (int i=0; i <100; i++) {
            for (int j=0; j <100; j++) {
                this.M[i][j] =0;
            }
        }
        this.bar = 0;
        this.kol = 0;
    }

public matriks InputMatriksSQ(matriks M1){
    System.out.print("Masukkan ukuran matriks: ");
    M1.bar=M1.kol=input.nextInt();
     for(int i=0; i<this.bar; i++){
        for(int j=0; j<this.kol; j++){
            System.out.println("\nMasukkan elemen matriks baris "+(i+1)+" kolom "+(j+1)+" : ");
            M1.M[i][j]=input.nextFloat();
        }    
     }
     return M1;
}

public matriks InputMatriks(matriks M1, int m, int n){
    if(m==0 && n==0){
        System.out.print("Masukkan ukuran baris matriks: ");
        m=input.nextInt();
        System.out.print("Masukkan ukuran kolom  matriks: ");
        n=input.nextInt();
    }
     for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            System.out.println("\nMasukkan elemen matriks baris "+(i+1)+" kolom "+(j+1)+" : ");
            M1.M[i][j]=input.nextFloat();
        }    
}
     return M1;
}
     
public int GetLastIdxBrs(matriks M1){
    return M1.bar-1;
}
     
public int GetLastIdxKol(matriks M1){
    return M1.kol-1;
}

float GetElmtDiagonal (matriks M1, int i){
	return(M1.M[i][i]);
}

public void PrintMatriks(){
    for(int i=0; i<this.bar; i++){
        for(int j=0; j<this.kol; j++){
            System.out.printf("0.3f",this.M[i][j]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
 
matriks CopyMatriks (matriks MIn){
    matriks MOut=new matriks();
    for (int i = 0; i <= GetLastIdxBrs(MIn); i++){
        for (int j = 0; j <= GetLastIdxKol(MIn); j++){
            MOut.M[i][j] = MIn.M[i][j];
        }
    }
   return MOut;
}

 public matriks Transpose(){
    matriks Trans = new matriks();
    Trans.bar = this.kol;
    Trans.kol = this.bar;
    for(int i=0; i < this.kol ; i++) {
        for(int j=0; j < this.bar ; j++) {
            Trans.M[i][j] = this.M[j][i];
        }
    }
    return Trans;      
}
 matriks TambahMatriks (matriks  M1, matriks M2){
	matriks M3 = new matriks();
	for (int i=0; i <= GetLastIdxBrs(M1); i++){
            for (int j=0; j <= GetLastIdxKol(M1); j++){
                M3.M[i][j]=M1.M[i][j]-M2.M[i][j];
        }
    }
    return M3;
}
matriks KurangMatriks (matriks  M1, matriks M2){
	matriks M3 = new matriks();
	for (int i=0; i <= GetLastIdxBrs(M1); i++){
            for (int j=0; j <= GetLastIdxKol(M1); j++){
                M3.M[i][j]=M1.M[i][j]-M2.M[i][j];
        }
    }
    return M3;
}

matriks KaliMatriks (matriks  M1, matriks M2){
	matriks M3 = new matriks();
	for (int i=0; i <= GetLastIdxBrs(M1); i++){
            for (int j=0; j <= GetLastIdxKol(M1); j++){
                for(int k=0; k<= GetLastIdxKol(M1); k++){
                    M3.M[i][j]=M1.M[i][k]*M2.M[k][j];
                }
        }
    }
    return M3;
}

public matriks eselonbarispertama(matriks M1,int iddiagon){
    float var;
    if(M1.M[iddiagon][iddiagon]!= 1){
        var = M1.M[iddiagon][iddiagon];
        for(int i=0; i<=GetLastIdxBrs(M1); i++){
            M1.M[iddiagon][i] = M1.M[iddiagon][i] / var;
        }
    }

    //Pengecekan pada kolom yang sama dari indeks elemen pertama
    for(int i=1; i<GetLastIdxKol(M1); i++){
        if(M1.M[i][iddiagon] != 1 && M1.M[i][iddiagon] != 0){
            //Pengurangan setiap elemen dalam baris
            var = M1.M[i][iddiagon];
            for(int j=iddiagon; i<GetLastIdxKol(M1); i++){
                M1.M[i][j] = M1.M[i][j] - (M1.M[iddiagon][j]*var);
            }
        }
    }
    return M1;
}

public matriks tukarbaris(matriks M3, int brs1, int brs2){
    float var = 0;
    for(int i=0; i<=GetLastIdxBrs(M3); i++){
        M3.M[brs1][i] = var;
        M3.M[brs1][i] = M3.M[brs2][i];
        M3.M[brs2][i] = var;
    }
    return M3;
}

public matriks eselonbaris(matriks M2){
    eselonbarispertama(M2,0);
    int i = 1;
    int j = 1;
    
    while(i < GetLastIdxKol(M2) && j < GetLastIdxBrs(M2)){
        // Kasus ketika baris setelah leading one = 0
        int A;
        if(M2.M[i][j] == 0){
            boolean loop = true;
            A = i + 1;
                
            // Pengecekan kolom di bawah kolom 0 apakah ada nilai 
            while(loop && A < GetLastIdxBrs(M2)){
                if(M[A][j] != 0){
                    tukarbaris(M2,i,A);
                    eselonbarispertama(M2,i);
                    loop = false;
                    i += 1;
                }
                else{
                    if(A == GetLastIdxBrs(M2)){
                        loop = false;
                    }
                    else{
                        A += 1;
                    }
                }
            }
            // Pergerakan dilanjutkan dengan baris yang sama
            j += 1;     
        }
    
        else if(M2.M[i][j]!= 1){
            eselonbarispertama(M2,i);
            // Pergerakan dilanjutkan diagonal 
            i += 1;
            j += 1;
        }
    }
    return M2;
}



}

    
    
    




