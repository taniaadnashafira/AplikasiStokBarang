/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.appstokbarang;

/**
 *
 * @author lenovo
 */

import java.util.ArrayList;
import java.util.Scanner;

public class APPStokBarang {
    static ArrayList<Barang> daftarBarang = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== APLIKASI STOK BARANG ===");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Hapus Barang");
            System.out.println("3. Tambah Stok Barang");
            System.out.println("4. Kurangi Stok Barang");
            System.out.println("5. Tampilkan Daftar Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // membersihkan buffer

            switch (pilihan) {
                case 1 -> tambahBarang();
                case 2 -> hapusBarang();
                case 3 -> tambahStok();
                case 4 -> kurangiStok();
                case 5 -> tampilkanBarang();
                case 0 -> System.out.println("Keluar dari program...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    static void tambahBarang() {
        System.out.print("Masukkan kode barang: ");
        String kode = input.nextLine();
        System.out.print("Masukkan nama barang: ");
        String nama = input.nextLine();
        System.out.print("Masukkan jumlah stok awal: ");
        int stok = input.nextInt();

        daftarBarang.add(new Barang(kode, nama, stok));
        System.out.println("Barang berhasil ditambahkan!");
    }

    static void hapusBarang() {
        System.out.print("Masukkan kode barang yang akan dihapus: ");
        String kode = input.nextLine();
        boolean ditemukan = false;

        for (int i = 0; i < daftarBarang.size(); i++) {
            if (daftarBarang.get(i).getKode().equals(kode)) {
                daftarBarang.remove(i);
                System.out.println("Barang berhasil dihapus!");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan!");
        }
    }

    static void tambahStok() {
        System.out.print("Masukkan kode barang: ");
        String kode = input.nextLine();
        for (Barang b : daftarBarang) {
            if (b.getKode().equals(kode)) {
                System.out.print("Masukkan jumlah yang akan ditambah: ");
                int jumlah = input.nextInt();
                b.setStok(b.getStok() + jumlah);
                System.out.println("Stok berhasil ditambahkan!");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan!");
    }

    static void kurangiStok() {
        System.out.print("Masukkan kode barang: ");
        String kode = input.nextLine();
        for (Barang b : daftarBarang) {
            if (b.getKode().equals(kode)) {
                System.out.print("Masukkan jumlah yang akan dikurangi: ");
                int jumlah = input.nextInt();
                if (jumlah <= b.getStok()) {
                    b.setStok(b.getStok() - jumlah);
                    System.out.println("Stok berhasil dikurangi!");
                } else {
                    System.out.println("Jumlah melebihi stok yang tersedia!");
                }
                return;
            }
        }
        System.out.println("Barang tidak ditemukan!");
    }

    static void tampilkanBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada data barang!");
        } else {
            System.out.println("\n=== DAFTAR STOK BARANG ===");
            for (Barang b : daftarBarang) {
                System.out.println("Kode: " + b.getKode() + " | Nama: " + b.getNama() + " | Stok: " + b.getStok());
            }
        }
    }
}

