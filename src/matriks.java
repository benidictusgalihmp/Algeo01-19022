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
     for(int i=0; i< M1.bar; i++){
        for(int j=0; j<M1.kol; j++){
            System.out.print("\nMasukkan elemen matriks baris "+(i+1)+" kolom "+(j+1)+" : ");
            M1.M[i][j]=input.nextFloat();
        }    
     }
     return M1;
}

public matriks InputMatriks(matriks M1, int m, int n){
    if(m==0 && n==0){
        System.out.print("Masukkan ukuran baris matriks: ");
        M1.bar=m=input.nextInt();
        System.out.print("Masukkan ukuran kolom matriks: ");
        M1.kol=n=input.nextInt();
    }
     for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            System.out.print("\nMasukkan elemen matriks baris "+(i+1)+" kolom "+(j+1)+" : ");
            M1.M[i][j]=input.nextFloat();
        }    
}
     return M1;
}

public matriks InputMatriksAug(matriks M1, int m, int n){
System.out.print("Silahkan input matriks berbentuk augmented\n");
if(m==0 && n==0){
        System.out.print("Masukkan ukuran baris matriks: ");
        M1.bar=m=input.nextInt();
        System.out.print("Masukkan ukuran kolom matriks: ");
        M1.kol=n=input.nextInt();
    }
for(int i=0; i< M1.bar; i++){
    for(int j=0; j<M1.kol; j++){
    	if(j==M1.kol-1){
    		System.out.println("Masukkan nilai B" +j+1 +":");
    		M1.M[i][j]=input.nextFloat();
    	}
    	else{
    		System.out.println("Masukkan nilai koefisien (A)"+(i+1)+(j+1)+" : ");
    	    M1.M[i][j]=input.nextFloat();	
    	}
    }
   }
    return M1;
}


public matriks makeMatriksIdentitas(matriks MIn, matriks MOut, int length){
    MOut.bar = length;
    MOut.kol = length*2;

    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            if (i == j) {
                MOut.M[i][j + length] = 1;
                MOut.M[i][j] = MIn.M[i][j];
            }
            else{
                MOut.M[i][j + length] = 0;
                MOut.M[i][j] = MIn.M[i][j];
            }
        }
    }

    return MOut;
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

public void PrintMatriks(matriks M1){
    for(int i = 0; i < M1.bar; i++){
        for(int j=0; j < M1.kol; j++){
            System.out.print(M1.M[i][j]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
 
public matriks CopyMatriks (matriks MIn){
    matriks MOut=new matriks();
    for (int i = 0; i <= GetLastIdxBrs(MIn); i++){
        for (int j = 0; j <= GetLastIdxKol(MIn); j++){
            MOut.M[i][j] = MIn.M[i][j];
        }
    }
   return MOut;
}

public matriks Transpose(matriks M1){
    matriks Trans = new matriks();
    Trans.bar = M1.kol;
    Trans.kol = M1.bar;
    for(int i=0; i < M1.kol ; i++) {
        for(int j=0; j < M1.bar ; j++) {
            Trans.M[i][j] = M1.M[j][i];
        }
    }
    return Trans;      
}
 
public matriks TukarBaris(matriks M3, int brs1, int brs2){
    matriks var=new matriks();
    var.bar=M3.bar;
    var.kol=M3.kol;
    var.M[brs1]=M3.M[brs1];
    M3.M[brs1] = M3.M[brs2];
    M3.M[brs2] = var.M[brs2];
    return M3;
}

public boolean SearchLeadingOne(matriks M, int idxbrs, int idxkol1, int idxkol2)
{
    boolean found = false;
    int i = idxkol1;
    int j = idxkol2;

    while(i < j && !found)
    {
        if (M.M[idxbrs][i] == 1) 
        {
            found = true;
        }
        else
        {
            i++;
        }
    }
    return found;
}

public int SearchIdxLeadingOne(matriks M, int idxbrs, int idxkol1, int idxkol2)
{
    boolean found = false;
    int i = idxkol1;
    int j = idxkol2;

    while(i < j && !found)
    {
        if (M.M[idxbrs][i] == 1) 
        {
            found = true;
        }
        else
        {
            i++;
        }
    }
    return i;
}

public boolean SearchOneKol(matriks M1, int idxbrs, int idxkol){
	boolean found = false;
    int i = idxbrs;

	while(i < M1.bar && !found){
		if(M[i][idxkol]==1){
			found = true;
		}
		else{
			i++;
		}
	}
	return found;
}

public int SearchOneIdxKol(matriks M1, int idxbrs, int idxkol){
	boolean found = false;
    int i = idxbrs;

	while(i < M1.bar && !found){
		if(M[i][idxkol]==1){
			found = true;
		}
		else{
			i++;
		}
	}
	return i;
}

public boolean SearchNonZeroBrs(matriks M1, int idxbrs, int idxkol1, int idxkol2){
	boolean found = false;
    int i = idxkol1;
    int j = idxkol2;
    
	while(i >= j && !found){
		if(M1.M[idxbrs][i]!=0){
			found = true;
		}
		else{
			i--;
		}
	}
	return found;
}

public int SearchNonZeroIdxBrs(matriks M1, int idxbrs, int idxkol1, int idxkol2){
	boolean found = false;
    int i = idxkol1;
    int j = idxkol2;
    
	while(i >= j && !found){
		if(M1.M[idxbrs][i]!=0){
			found = true;
		}
		else{
			i--;
		}
	}
	return i;
}

public boolean SearchNonZeroKol(matriks M1, int idxbrs1, int idxbrs2, int idxkol){
	boolean found = false;
    int i = idxbrs1;
    int j = idxbrs2;
    
	while(i < j && !found){
		if(M1.M[i][idxkol]!=0){
			found = true;
		}
		else{
			i++;
		}
	}
	return found;
}

public int SearchNonZeroIdxKol(matriks M1, int idxbrs1, int idxbrs2, int idxkol){
	boolean found = false;
    int i = idxbrs1;
    int j = idxbrs2;

	while(i < j && !found){
        if(M1.M[i][idxkol]!=0){
			found = true;
		}
		else{
			i++;
		}
	}
	return i;
}

public matriks OperasiBaris(matriks M1, int idxbrs1, int idxbrs2, int idxkol){
	float var = M1.M[idxbrs2][idxkol];
    for(int j = 0; j < M1.kol; j++){
    	M1.M[idxbrs2][j] = M1.M[idxbrs2][j] - var*M[idxbrs1][j];
	}
	return M1;
}

public matriks MakeLeadOne(matriks M1, int idxbrs,  int idxkol){
	float var=M1.M[idxbrs][idxkol];
    for(int i=idxkol; i<M1.kol; i++){
    	M1.M[idxbrs][i]=M1.M[idxbrs][i]/var;
	}
	return M1;
}

// Pembuatan kode dibuat dalam python lalu diubah ke dalam java
public matriks MatriksEselon(matriks M1){
	int i = 0;
    int j = 0;
    boolean valid = true;

    while (i < M1.bar && j < M1.kol && valid){
        if (M1.M[i][j] == 1){
        	for(int k = i + 1; k < M1.bar; k++){ // Pencarian dalam kolom yang elemennya tidak 0
                if (SearchNonZeroKol(M1, k, M1.bar, j)){
                    OperasiBaris(M1,i,SearchNonZeroIdxKol(M1, k, M1.bar, j),j);
                }
            }
            i += 1;
            j += 1;
        }

       	else if(M1.M[i][j] == 0){
       		if (i == 0 && j == 0){                            // Elemen bernilai 0 dan pada M[0][0]
                if (SearchOneKol(M1,i,j)){
                    TukarBaris(M1,i,SearchOneIdxKol(M1,i,j));

                    for(int k=i+1; k<M1.bar; k++){                   // Pencarian dalam kolom yang elemennya tidak 0
                        if (SearchNonZeroKol(M1, k, M1.bar, j)){
                            OperasiBaris(M1,i,SearchNonZeroIdxKol(M1, k, M1.bar, j),j);
                        }
                    }       
                    i += 1;                         
                    j += 1;                                      
       			}

       			else if(SearchNonZeroKol(M1, i, M1.bar, j)){
       				TukarBaris(M1,i,SearchNonZeroIdxKol(M1, i, M1.bar, j));
                    MakeLeadOne(M1,i,j);
                    for(int k = i + 1; k < M1.bar; k++){                   // Pencarian dalam kolom yang elemennya tidak 0
                        if (SearchNonZeroKol(M1, k, M1.bar, j)){
                            OperasiBaris(M1,i,SearchNonZeroIdxKol(M1, k, M1.bar, j),j);
                        }
                    }
                    i += 1 ;                         
                    j += 1;                                      
       			}

       			else{
       				valid = false;
                    int kol = 0;
                    while (kol < M1.kol && !valid){
                        if (M1.M[0][kol] != 0){
                            valid = true;
                        }
                        else{
                            kol += 1;
                        }
                    }

                    if(valid==false){
                    	System.out.println("Input tidak valid!");
                    }
                    else{
                    	j += 1;
                    }
                }
       		}

       		else{
       			boolean found = false;
       			int brs = i;

       			while(brs < M1.bar && !found){
       				if(M1.M[brs][j] != 0){
       					found = true;
       					if(M1.M[brs][j] == 1){
       						TukarBaris(M1, i, SearchOneIdxKol(M1, i, j));
							for(int k = i + 1; k < M1.bar; k++){       		
								if(SearchNonZeroKol(M1, i+1, M1.bar, j)){
									OperasiBaris(M1,i,SearchNonZeroIdxKol(M1, k, M1.bar, j),j);
								}
							}
							i += 1;
							j += 1;
						}
       					else{
                            MakeLeadOne(M1,brs,j);
                            TukarBaris(M1,i,SearchNonZeroIdxKol(M1, i, M1.bar, j));
       						for(int k = i + 1; k < M1.bar; k++){       		
								if(SearchNonZeroKol(M1, i + 1, M1.bar, j)==true){
									OperasiBaris(M1,i,SearchNonZeroIdxKol(M1, k, M1.bar, j),j);
								}
							}
							i+=1;
							j+=1;
						}
       				}
       				else{
       					brs+=1;
       				}
       			}
       			if (found == false){
                    j += 1;
       			}
       		}
        }
       	else{
       		if(SearchOneKol(M1, i, j)){
                TukarBaris(M1, i, SearchOneIdxKol(M1, i, j));
                   
				for(int k = i + 1; k < M1.bar; k++){       		
					if(SearchNonZeroKol(M1, i + 1, M1.bar, j)){
						OperasiBaris(M1,i,SearchNonZeroIdxKol(M1, k, M1.bar, j),j);
					}
				}
				i+=1;
				j+=1;
       		}
       		else{
                MakeLeadOne(M1,i,j);
                   
       			for(int k = i + 1; k < M1.bar; k++){       		
					if(SearchNonZeroKol(M1, i + 1, M1.bar, j)){
						OperasiBaris(M1,i,SearchNonZeroIdxKol(M1, k, M1.bar, j),j);
					}
				}
				i+=1;
				j+=1;
       		}
       	}
    }
    return M1;
}

public float Determinan (matriks A){
    float det=0;
    if(A.bar!=A.kol){
        System.out.println("Determinan matriks ini tidak ada.");
        System.out.println("Silahkan gunakan matriks koefisien berbentuk persegi\n atau silahkan menggunakan metode lain");
    }
    else{
        if(A.kol==1){
            det=A.M[0][0];
        }
        else if(A.kol==2){
            det=((A.M[0][0]*A.M[1][1])-(A.M[0][1]*A.M[1][0]));
        }
        else if(A.kol>2){
            for (int i=0; i<A.bar; i++) {  
                if(i%2==0){
                    det+=A.M[i][0]*Kofaktor(A, i, 0).Determinan(Kofaktor(A, i, 0));
                }
                else{
                    det+=-1*(A.M[i][0])*Kofaktor(A, i, 0).Determinan(Kofaktor(A, i, 0));
                }
            }  
        }  
    }
    return det;  
}

public matriks Kofaktor(matriks A, int bar, int kol){    
    matriks Kof = new matriks();  
    Kof.bar=A.bar-1;
    Kof.kol=A.bar-1;  
    
    int cbar=0;   
    int ckol=0;
    for (int i=0; i<A.bar; i++) {  
        if(i!=bar){
        for (int j = 0; j<A.kol; j++) {  
            if(j!=kol){
                Kof.M[cbar][ckol]=A.M[i][j];  
                ckol++;
            }
        } 
        cbar++;
        ckol=0;
        }
    }
  return Kof;  
}

public matriks MinorKofaktor(matriks A){
    matriks MinKof=new matriks();
    MinKof.bar=A.bar;
    MinKof.kol=A.kol;
    for (int i=0; i<A.bar; i++) {  
        for (int j = 0; j<A.kol; j++) {  
                if((i+j)%2==0){
                    MinKof.M[i][j]=Kofaktor(A, i,j).Determinan(Kofaktor(A, i,j));  
                }
                else{
                    MinKof.M[i][j]=-1*Kofaktor(A, i,j).Determinan(Kofaktor(A, i,j));
                }
            }
 
    }
     return MinKof;
}

public matriks MatriksKolomKeI(matriks A, matriks t, int kolom){
        for (int i = 0; i < t.bar; i++) {
            for (int j = 0; j < t.kol; j++) {
                 if (j == kolom) {
                    t.M[i][j] = A.M[i][A.kol];
                } else {
                    t.M[i][j] = A.M[i][j];
                }
            }
        }
        return t;
    }

public matriks Cramer(matriks A) {
	matriks t = new matriks();
        t.bar = A.bar;
        t.kol = A.kol-1;
        for (int i = 0; i < t.bar; i++) {
            for (int j = 0; j < t.kol; j++) {
                t.M[i][j] = A.M[i][j];
            }
        }
        float detAwal = t.Determinan(t);
        
        
        matriks Hasil=new matriks();
        if (detAwal == 0) {
            System.out.println("Tidak ada solusi cramer");
                   }
        for (int i = 0; i < t.kol; i++) {
            float DetmatriksI = MatriksKolomKeI(A, t, i).Determinan(MatriksKolomKeI(A, t, i));
            float det = DetmatriksI / detAwal;
            System.out.printf("%.3f\n",det);
            Hasil.M[i][0]=det;
        }
       return Hasil;
}

public matriks matriksEselonReduksi(matriks M1){
    int i = 0;
    int j = 0;
    boolean valid = true;

    while(i <M1.bar && j < M1.kol && valid){
        if(M1.M[i][j] == 1){
            if(i == 0 && j == 0){
                for(int k=i+1; k<M1.bar; k++){
                    if (SearchNonZeroKol(M1,k,M1.bar,j)){
                        OperasiBaris(M1,i,SearchNonZeroIdxKol(M1,k,M1.bar,j),j);
                    }
                }
            }
            else{
                for(int k=i+1; k<M1.bar; k++){
                    if (SearchNonZeroKol(M1,k,M1.bar,j)){
                        OperasiBaris(M1,i,SearchNonZeroIdxKol(M1,k,M1.bar,j),j);
                    }
                }
                for(int k=0; k<i; k++){
                    if (SearchNonZeroKol(M1,k,i,j)){
                        OperasiBaris(M1,i,SearchNonZeroIdxKol(M1,k,i,j),j);
                    }
                }
            }
            i += 1;
            j += 1;
        }

        else if(M1.M[i][j] == 0){
            if(i == 0 && j == 0){
                if(SearchOneKol(M1,i,j)==true){
                    TukarBaris(M1,i,SearchOneIdxKol(M1,i,j));
                    for (int k=i+1; k<M1.bar; k++){
                        if (SearchNonZeroKol(M1,k,M1.bar,j)==true){
                            OperasiBaris(M1,i,SearchNonZeroIdxKol(M1,k,M1.bar,j),j);
                        }
                    }
                    for(int k=0; k<i; k++){
                        if (SearchNonZeroKol(M1,k,i,j)==true){
                            OperasiBaris(M1,i,SearchNonZeroIdxKol(M1,k,i,j),j);
                        }
                    }
                    i += 1;
                    j += 1;
                }

                else if (SearchNonZeroKol(M1,i,M1.bar,j)){
                    TukarBaris(M1,i,SearchNonZeroIdxKol(M1,i,M1.bar,j));
                    MakeLeadOne(M1,i,j);
                    for(int k=0; k<i; k++){
                        if (SearchNonZeroKol(M1,k,M1.bar,j)==true){
                            OperasiBaris(M1,i,SearchNonZeroIdxKol(M1,k,M1.bar,j),j);
                        }
                    }
                    for(int k=0; k<i; k++){
                        if (SearchNonZeroKol(M1,k,i,j)==true){
                            OperasiBaris(M1,i,SearchNonZeroIdxKol(M1,k,i,j),j);
                        }
                    }
                    i += 1;
                    j += 1;
                }
                 
                else{
                    valid = false;
                    int kol = 0;
                    while (kol < M1.kol && valid==false){
                        if (M1.M[0][kol] != 0){
                            valid = true;
                        }
                        else{
                            kol += 1;
                        }
                    }

                    if (valid == false){                        
                        System.out.println("Input tidak valid!");
                    }
                    else{                                       
                        j += 1;
                    }
                }
            }

            else{
                if (SearchNonZeroKol(M1,i,M1.bar,j)){
                    TukarBaris(M1,i,SearchNonZeroIdxKol(M1,i,M1.bar,j));
                    if(M1.M[i][j] != 1){
                        MakeLeadOne(M1,i,j);
                    }
                    for(int k = i + 1; k < M1.bar; k++){
                        if (SearchNonZeroKol(M1,k,M1.bar,j)){
                            OperasiBaris(M1,i,SearchNonZeroIdxKol(M1,k,M1.bar,j),j);
                        }
                    }
                    for(int k = 0; k < i; k++){
                        if (SearchNonZeroKol(M1,k,i,j)){
                            OperasiBaris(M1,i,SearchNonZeroIdxKol(M1,k,i,j),j);
                        }
                    }
                    i += 1;
                    j += 1;
                    }
                

                else{
                    j += 1;
                }
            }
        }

        else{
            if(SearchOneKol(M1,i,j)){
                TukarBaris(M1,i,SearchOneIdxKol(M1,i,j));
            }
            else{
                MakeLeadOne(M1,i,j);
            }

            for(int k = i + 1; k < M1.bar; k++){
                if (SearchNonZeroKol(M1,k,M1.bar,j)){
                    OperasiBaris(M1,i,SearchNonZeroIdxKol(M1,k,M1.bar,j),j);
                }
            }
            for(int k = 0; k < i; k++){
                if (SearchNonZeroKol(M1,k,i,j)){
                    OperasiBaris(M1,i,SearchNonZeroIdxKol(M1,k,i,j),j);
                }
            }
            i += 1;
            j += 1;
            
        }

    }
    return M1;
}


public matriks MatriksDeterminanReduksi(matriks M1){
	int i = 0;
    int j = 0;
    boolean valid = true;

    while (i < M1.bar && j < M1.kol && valid){
        if(i == M1.bar - 1 && j == M1.kol - 1)
        {
            valid = false;
        }
        else{
        if (M1.M[i][j] == 1){
        	for(int k = i + 1; k < M1.bar; k++){ // Pencarian dalam kolom yang elemennya tidak 0
                if (SearchNonZeroKol(M1, k, M1.bar, j)){
                    OperasiBaris(M1,i,SearchNonZeroIdxKol(M1, k, M1.bar, j),j);
                }
            }
            i += 1;
            j += 1;
        }

       	else if(M1.M[i][j] == 0){
       		if (i == 0 && j == 0){                            // Elemen bernilai 0 dan pada M[0][0]
                if (SearchOneKol(M1,i,j)){
                    TukarBaris(M1,i,SearchOneIdxKol(M1,i,j));

                    for(int k=i+1; k<M1.bar; k++){                   // Pencarian dalam kolom yang elemennya tidak 0
                        if (SearchNonZeroKol(M1, k, M1.bar, j)){
                            OperasiBaris(M1,i,SearchNonZeroIdxKol(M1, k, M1.bar, j),j);
                        }
                    }       
                    i += 1;                         
                    j += 1;                                      
       			}

       			else if(SearchNonZeroKol(M1, i, M1.bar, j)){
       				TukarBaris(M1,i,SearchNonZeroIdxKol(M1, i, M1.bar, j));
                    MakeLeadOne(M1,i,j);
                    for(int k = i + 1; k < M1.bar; k++){                   // Pencarian dalam kolom yang elemennya tidak 0
                        if (SearchNonZeroKol(M1, k, M1.bar, j)){
                            OperasiBaris(M1,i,SearchNonZeroIdxKol(M1, k, M1.bar, j),j);
                        }
                    }
                    i += 1 ;                         
                    j += 1;                                      
       			}

       			else{
       				valid = false;
                    int kol = 0;
                    while (kol < M1.kol && !valid){
                        if (M1.M[0][kol] != 0){
                            valid = true;
                        }
                        else{
                            kol += 1;
                        }
                    }

                    if(valid==false){
                    	System.out.println("Input tidak valid!");
                    }
                    else{
                    	j += 1;
                    }
                }
       		}

       		else{
       			boolean found = false;
       			int brs = i;

       			while(brs < M1.bar && !found){
       				if(M1.M[brs][j] != 0){
       					found = true;
       					if(M1.M[brs][j] == 1){
       						TukarBaris(M1, i, SearchOneIdxKol(M1, i, j));
							for(int k = i + 1; k < M1.bar; k++){       		
								if(SearchNonZeroKol(M1, i+1, M1.bar, j)){
									OperasiBaris(M1,i,SearchNonZeroIdxKol(M1, k, M1.bar, j),j);
								}
							}
							i += 1;
							j += 1;
						}
       					else{
                            MakeLeadOne(M1,brs,j);
                            TukarBaris(M1,i,SearchNonZeroIdxKol(M1, i, M1.bar, j));
       						for(int k = i + 1; k < M1.bar; k++){       		
								if(SearchNonZeroKol(M1, i + 1, M1.bar, j)==true){
									OperasiBaris(M1,i,SearchNonZeroIdxKol(M1, k, M1.bar, j),j);
								}
							}
							i+=1;
							j+=1;
						}
       				}
       				else{
       					brs+=1;
       				}
       			}
       			if (found == false){
                    j += 1;
       			}
       		}
        }
       	else{
       		if(SearchOneKol(M1, i, j)){
                TukarBaris(M1, i, SearchOneIdxKol(M1, i, j));
                   
				for(int k = i + 1; k < M1.bar; k++){       		
					if(SearchNonZeroKol(M1, i + 1, M1.bar, j)){
						OperasiBaris(M1,1,SearchNonZeroIdxKol(M1, k, M1.bar, j),j);
					}
				}
				i+=1;
				j+=1;
       		}
       		else{
                MakeLeadOne(M1,i,j);
                   
       			for(int k = i + 1; k < M1.bar; k++){       		
					if(SearchNonZeroKol(M1, i + 1, M1.bar, j)){
						OperasiBaris(M1,i,SearchNonZeroIdxKol(M1, k, M1.bar, j),j);
					}
				}
				i+=1;
				j+=1;
       		}
        }
        }

    }
    return M1;
}


}

