package uas.revo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    private BarangService service = new BarangService();
    private ObservableList<Barang> data = FXCollections.observableArrayList();
    private TableView<Barang> table = new TableView<>();
    private TextField tfNama = new TextField();
    private TextField tfStok = new TextField();
    private Barang selectedBarang = null;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("CRUD Barang - JavaFX");

        // Kolom Tabel
        TableColumn<Barang, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setMinWidth(50);

        TableColumn<Barang, String> colNama = new TableColumn<>("Nama Barang");
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colNama.setMinWidth(200);

        TableColumn<Barang, Integer> colStok = new TableColumn<>("Stok Barang");
        colStok.setCellValueFactory(new PropertyValueFactory<>("stok")); 
        colStok.setMinWidth(100);

        table.getColumns().addAll(colId, colNama, colStok);
        table.setItems(data);

        // Selection Listener
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            selectedBarang = newVal;
            if (newVal != null) {
                tfNama.setText(newVal.getNama());
                tfStok.setText(String.valueOf(newVal.getStok())); // ✅ konversi ke String
            }
        });

        tfNama.setPromptText("Nama Barang");
        tfStok.setPromptText("Stok Barang");

        Button btnTambah = new Button("Tambah");
        Button btnUpdate = new Button("Update");
        Button btnHapus = new Button("Hapus");

        btnTambah.setOnAction(e -> {
            String nama = tfNama.getText().trim();
            String stokText = tfStok.getText().trim();

            if (!nama.isEmpty() && stokText.matches("\\d+")) {
                int stok = Integer.parseInt(stokText);
                service.tambahBarang(nama, stok);
                refreshTable();
                clearForm();
            }
        });

        btnUpdate.setOnAction(e -> {
            if (selectedBarang != null) {
                String namaBaru = tfNama.getText().trim();
                String stokText = tfStok.getText().trim();

                if (!namaBaru.isEmpty() && stokText.matches("\\d+")) {
                    int stokBaru = Integer.parseInt(stokText);
                    service.updateBarang(selectedBarang.getId(), namaBaru, stokBaru);
                    refreshTable();
                    clearForm();
                }
            }
        });

        btnHapus.setOnAction(e -> {
            if (selectedBarang != null) {
                service.hapusBarang(selectedBarang.getId());
                refreshTable();
                clearForm();
            }
        });

        HBox formBox = new HBox(10, tfNama, tfStok, btnTambah, btnUpdate, btnHapus);
        VBox root = new VBox(10, formBox, table);
        root.setPadding(new javafx.geometry.Insets(10));

        stage.setScene(new Scene(root, 700, 400));
        stage.show();

        refreshTable();
    }

    private void refreshTable() {
        data.setAll(service.getAll());
    }

    private void clearForm() {
        tfNama.clear();
        tfStok.clear();
        selectedBarang = null;
    }
}
