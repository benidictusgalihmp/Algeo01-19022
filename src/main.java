
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int menu;
        int SPL;
        do {
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
                    SPL = input.nextInt();
                    while (SPL > 4 || SPL < 1) {
                        System.out.print("\nPilihan tidak valid, silahkan ulangi lagi!\n");
                        SPL = input.nextInt();
                    }

                    if (SPL == 1) {
                        matriks M = new matriks();

                        M.InputMatriksAug(M, M.bar, M.kol);
                        M.MatriksEselon(M);
                        for (int i = M.bar - 1; i >= 0; i--) 
                        {
                            if (M.SearchLeadingOne(M, i, 0, M.kol - 1)) 
                            {
                                System.out.printf("x%d = %2f", M.SearchIdxLeadingOne(M, i, 0, M.kol - 1), M.M[i][M.kol - 1]);
                                for (int k = M.SearchIdxLeadingOne(M, i, 0, M.kol - 1) + 1; k < M.kol - 2; k++) 
                                {
                                    if (M.M[i][k] != 0) 
                                    {
                                        System.out.printf("%2fx%d", M.M[i][k], k + 1);
                                    }
                                }
                                System.out.println();
                            }
                            else
                            {
                                if (M.M[M.bar - 1][M.kol - 1] != 0)
                                {
                                    System.out.println("Tidak ada solusi !");
                                }
                            }
                        }
                        
                        break;
                        
                    } else if (SPL == 2) {
                        matriks M = new matriks();
                        M.InputMatriksAug(M, M.bar, M.kol);
                        M.matriksEselonReduksi(M);
                        
                        for (int i = M.bar - 1; i >= 0; i--) 
                        {
                            if (M.SearchLeadingOne(M, i, 0, M.kol - 1)) 
                            {
                                System.out.printf("x%d = %2f", M.SearchIdxLeadingOne(M, i, 0, M.kol - 1), M.M[i][M.kol - 1]);
                                for (int k = M.SearchIdxLeadingOne(M, i, 0, M.kol - 1) + 1; k < M.kol - 2; k++) 
                                {
                                    if (M.M[i][k] != 0) 
                                    {
                                        System.out.printf("%2fx%d", M.M[i][k], k + 1);
                                    }
                                }
                                System.out.println();
                            }
                            else
                            {
                                if (M.M[M.bar - 1][M.kol - 1] != 0)
                                {
                                    System.out.println("Tidak ada solusi !");
                                }
                            }
                        }
                        break;
                        
                    } else if (SPL == 3) {
                        matriks A = new matriks();
                        matriks B = new matriks();
                        B.kol = 1;
                        System.out.println("\nSilahkan input isi matriks koefisien (A)");
                        A.InputMatriksSQ(A);
                        System.out.println("\nSilahkan input isi matriks B");
                        B.bar = A.bar;
                        B.InputMatriks(B, B.bar, B.kol);

                        matriks Adj = new matriks();
                        Adj = A.MinorKofaktor(A).Transpose(A.MinorKofaktor(A));

                        if (A.Determinan(A) == 0) {
                            System.out.print("Matriks ini tidak memiliki determinan," );
                        }

                        matriks Inv = new matriks();
                        for (int i = 0; i < A.bar; i++) {
                            for (int j = 0; j < A.kol; j++) {
                                Inv.M[i][j] = Adj.M[i][j] / A.Determinan(A);
                            }
                        }

                        matriks Hasil = new matriks();
                        for (int i = 0; i < A.bar; i++) {
                            for (int j = 0; j < B.kol; j++) {
                                for (int k = 0; k < B.bar; k++) {
                                    Hasil.M[i][j] += (Inv.M[i][k] * B.M[k][j]);
                                }
                            }
                        }

                        for (int i = 0; i < A.bar; i++) {
                            System.out.println("X" + (i + 1) + " = " + Hasil.M[i][0]);
                        }

                        boolean save = SaveHasil();
                        if (save) {
                            SaveFile(MatriksToString(Hasil, A.bar, A.kol));
                        }
                        break;
                        
                    } else if (SPL == 4) {
                        matriks A = new matriks();
                        System.out.println("Silahkan input matriks berbentuk augmented");
                        A.InputMatriks(A, A.bar, A.kol);
                        A.Cramer(A);

                        boolean save = SaveHasil();
                        if (save) {
                            SaveFile(MatriksToString(A.Cramer(A), A.bar, A.kol));
                        }
                        break;
                    }

                case 2:
                    DETMenu();
                    int DET = input.nextInt();
                    while (DET > 4 || DET < 1) {
                        System.out.print("\nPilihan tidak valid, silahkan ulangi lagi!\n");
                        DET = input.nextInt();
                    }

                    if (DET == 1) {
                        matriks MatriksDt = new matriks();
                        MatriksDt.InputMatriksSQ(MatriksDt);
                        MatriksDt.MatriksDeterminanReduksi(MatriksDt);
                        System.out.println("Determinan matriks tersebut adalah " + MatriksDt.M[MatriksDt.GetLastIdxBrs(MatriksDt)][MatriksDt.GetLastIdxKol(MatriksDt)]);
                        
                        boolean save = SaveHasil();
                        if (save) {
                            SaveFile(Float.toString(MatriksDt.M[MatriksDt.GetLastIdxBrs(MatriksDt)][MatriksDt.GetLastIdxKol(MatriksDt)]));
                        }
                        break;

                    } else if (DET == 2) {
                        matriks A = new matriks();
                        A.InputMatriksSQ(A);
                        System.out.println("\nDeterminan matriks tersebut adalah " + A.Determinan(A));

                        boolean save = SaveHasil();
                        if (save) {
                            SaveFile(Float.toString(A.Determinan(A)));
                        }

                        break;
                    }

                case 3:
                    BalikanMenu();
                    int Balik = input.nextInt();
                    while (Balik > 2 || Balik < 1) {
                        System.out.print("Pilihan tidak valid, silahkan ulangi lagi!\n");
                        Balik = input.nextInt();
                    }

                    if (Balik == 1) {
                        matriks M = new matriks();
                        matriks MTemp = new matriks();
                        M.InputMatriksSQ(M);
                        if (M.bar == 0) {
                            System.out.println("Matriks kosong dan matriks balikannya adalah matriks kosong []");
                        } else {
                            M.makeMatriksIdentitas(M, MTemp, M.bar);
                            MTemp.matriksEselonReduksi(MTemp);
                            for (int i = 0; i < M.bar; i++) {
                                for (int j = 0; j < M.bar; j++) {
                                    M.M[i][j] = MTemp.M[i][j + M.bar];
                                }
                            }
                            System.out.println("\nInvers matriks tersebut adalah:\n");
                            M.PrintMatriks(M);
                            
                            boolean save = SaveHasil();
                        if (save) {
                            SaveFile((MatriksToString(M, M.bar, M.kol)));
                        }
                        
                            break;
                        }
                        
                        
                    } else if (Balik == 2) {
                        matriks A = new matriks();
                        matriks Adj = new matriks();
                        System.out.println("\nSilahkan input isi matriks");
                        A.InputMatriksSQ(A);
                        Adj = A.MinorKofaktor(A).Transpose(A.MinorKofaktor(A));

                        matriks Inv = new matriks();

                        if (A.Determinan(A) == 0) {
                            System.out.println("Matriks ini memiliki determinan = 0, sehingga tidak memiliki balikan");
                            break;
                        }

                        System.out.println("\nInvers matriks tersebut adalah:\n");
                        for (int i = 0; i < A.bar; i++) {
                            for (int j = 0; j < A.kol; j++) {
                                System.out.print(Adj.M[i][j] / A.Determinan(A) + " ");
                            }
                            System.out.println();
                        }

                        boolean save = SaveHasil();
                        if (save) {
                            SaveFile((MatriksToString(Inv, A.bar, A.kol)));
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
        } while (menu != 6);
        System.out.print("\nTerimakasih telah menggunakan layanan kami ^^ \n");
    }

    static void SPLMenu() {
        System.out.print("\n========SPL Method========\n"
                + "1. Metode Eliminasi Gauss\n"
                + "2. Metode Eliminasi Gauss-Jordan\n"
                + "3. Metode Matriks Balikan\n"
                + "4. Kaidah Cramer\n"
                + "\nMasukkan pilihan anda : ");
    }

    static void DETMenu() {
        System.out.print("\n========Determinan Counting Method========\n"
                + "1. Metode Reduksi Baris\n"
                + "2. Metode Ekspansi Kofaktor\n"
                + "\nMasukkan pilihan anda : ");
    }

    static void BalikanMenu() {
        System.out.print("\n========Inverse Matrix Method========\n"
                + "1. Metode Reduksi Baris\n"
                + "2. Metode Invers dengan Adjoint\n"
                + "\nMasukkan pilihan anda : ");
    }

    static boolean SaveHasil() {
        boolean save = false;
        while (true) {
            System.out.print("\nSimpan hasil ke dalam file .txt ?\n"
                    + "1. Ya\n"
                    + "2. Tidak\n");
            System.out.print("Pilih nomor jawaban : ");
            int pilih = input.nextInt();
            if (pilih == 1) {
                save = true;
                break;
            }
            if (pilih == 2) {
                break;
            } else {
                System.out.print("Pilihan tidak valid, silahkan input kembali!");
            }
        }
        return save;
    }

    static void SaveFile(String hasil) {
        boolean success = true;
        System.out.print("\nMasukkan path dan nama file yang diinginkan  \n"
                + "Format path   : Drive:\\\\NamaFolder\\\\....\\\\(namaFile yang diinginkan).txt\n"
                + "Contoh        : C:\\\\Folderku\\\\jawaban.txt\n"
                + ""
                + "Masukkan path anda : ");
        String path = input.nextLine();
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(hasil);
            bw.close();
        } catch (Exception e) {
            System.out.println("\nTerjadi kesalahan pada pemrosesan file.\n"
                    + "Silahkan coba kembali.");
            success = false;
        }
        if (success == true) {
            System.out.print("\nFile berhasil diproses!\n");
        }
    }

    public static String MatriksToString(matriks M1, int m, int n) {
        String hasil = "";
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                hasil += Float.toString(M1.M[i][j]) + (j == n - 1 ? "\n" : " ");
            }
        }
        return hasil;
    }

}
