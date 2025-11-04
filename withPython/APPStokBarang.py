from Barang import Barang

class APPStokBarang:
    def __init__(self):
        self.daftar_barang = []

    def tambah_barang(self):
        kode = input("Masukkan kode barang: ")
        nama = input("Masukkan nama barang: ")
        jumlah = int(input("Masukkan jumlah awal: "))
        barang = Barang(kode, nama, jumlah)
        self.daftar_barang.append(barang)
        print("✅ Barang berhasil ditambahkan!\n")

    def hapus_barang(self):
        kode = input("Masukkan kode barang yang ingin dihapus: ")
        for barang in self.daftar_barang:
            if barang.kode == kode:
                self.daftar_barang.remove(barang)
                print("🗑️ Barang berhasil dihapus!\n")
                return
        print("❌ Barang tidak ditemukan!\n")

    def tambah_stok(self):
        kode = input("Masukkan kode barang: ")
        jumlah = int(input("Masukkan jumlah yang ingin ditambah: "))
        for barang in self.daftar_barang:
            if barang.kode == kode:
                barang.tambah_stok(jumlah)
                print("✅ Stok berhasil ditambahkan!\n")
                return
        print("❌ Barang tidak ditemukan!\n")

    def kurangi_stok(self):
        kode = input("Masukkan kode barang: ")
        jumlah = int(input("Masukkan jumlah yang ingin dikurangi: "))
        for barang in self.daftar_barang:
            if barang.kode == kode:
                barang.kurangi_stok(jumlah)
                print("✅ Stok berhasil dikurangi!\n")
                return
        print("❌ Barang tidak ditemukan!\n")

    def tampilkan_stok(self):
        if not self.daftar_barang:
            print("📦 Belum ada barang di stok.\n")
        else:
            print("\n=== DAFTAR STOK BARANG ===")
            for barang in self.daftar_barang:
                print(barang)
            print()

    def menu(self):
        while True:
            print("==== APLIKASI STOK BARANG ====")
            print("1. Tambah Barang Baru")
            print("2. Hapus Barang")
            print("3. Tambah Stok")
            print("4. Kurangi Stok")
            print("5. Tampilkan Semua Barang")
            print("6. Keluar")

            pilihan = input("Pilih menu (1-6): ")
            print()

            if pilihan == "1":
                self.tambah_barang()
            elif pilihan == "2":
                self.hapus_barang()
            elif pilihan == "3":
                self.tambah_stok()
            elif pilihan == "4":
                self.kurangi_stok()
            elif pilihan == "5":
                self.tampilkan_stok()
            elif pilihan == "6":
                print("Terima kasih! Program selesai.")
                break
            else:
                print("❌ Pilihan tidak valid!\n")


if __name__ == "__main__":
    app = APPStokBarang()
    app.menu()
