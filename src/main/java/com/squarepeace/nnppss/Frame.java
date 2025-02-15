/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.squarepeace.nnppss;

import com.squarepeace.nnppss.Utilities;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Frame extends javax.swing.JFrame {

    /**
     * Creates new form Frame
     */
     private DefaultTableModel originalModel; // Variable para almacenar el modelo de datos original
     
    // Declaración del TableRowSorter
    private TableRowSorter<DefaultTableModel> rowSorter;
    
    private final Utilities utilities; // Utilizamos una variable final para guardar la instancia de Utilities
        
    // Variable para controlar el estado de la descarga
    private boolean downloadPaused = false;
    
    // Variable para controlar si hay descargas en curso
    private boolean downloading = false;
    
    public Frame(Utilities utilities) { // Modifica el constructor para aceptar una instancia de Utilities
        this.utilities = utilities; // Asigna la instancia recibida a la variable de clase
        initComponents(); // Asegúrate de llamar al constructor de la superclase si es necesario
        jbResumeAndPause.setEnabled(false); // Inicialmente deshabilitado
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbsearch = new javax.swing.JLabel();
        jbRefresh = new javax.swing.JButton();
        jtfSearch = new javax.swing.JTextField();
        jcbRegion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jpbDownload = new javax.swing.JProgressBar();
        jbResumeAndPause = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NNPPSS");

        jPanel1.setName("NNPPSS"); // NOI18N

        jbsearch.setText("Search:");

        jbRefresh.setText("Refresh");
        jbRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRefreshActionPerformed(evt);
            }
        });

        jtfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfSearchKeyReleased(evt);
            }
        });

        jcbRegion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbRegionItemStateChanged(evt);
            }
        });

        jtData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtDataMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtData);

        jLabel1.setText("Region: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jbsearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jbRefresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbsearch)
                    .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRefresh)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpbDownload.setStringPainted(true);

        jbResumeAndPause.setText("Pause");
        jbResumeAndPause.setActionCommand(":p");
        jbResumeAndPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbResumeAndPauseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jpbDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbResumeAndPause)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpbDownload, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jbResumeAndPause))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRefreshActionPerformed
        
        String url = null;
         try {
             url = utilities.getVitaGamesURL();
         } catch (IOException ex) {
             Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         // Descargar el archivo TSV si es necesario
        downloadFileInBackground(url, utilities.TSV, null , null);
    
    }//GEN-LAST:event_jbRefreshActionPerformed
     
    private void jtfSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSearchKeyPressed
        String searchText = jtfSearch.getText().trim();
        filtrarTablaPorTextoYRegion(searchText, (String) jcbRegion.getSelectedItem()); 
    }//GEN-LAST:event_jtfSearchKeyPressed

    private void jcbRegionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbRegionItemStateChanged
        
        String selectedRegion = (String) jcbRegion.getSelectedItem();
        System.out.println("Selected Region: " + selectedRegion); // Mensaje de depuración
        if (selectedRegion != null) {
            filtrarTablaPorTextoYRegion(jtfSearch.getText().trim(), selectedRegion);
        }
    }//GEN-LAST:event_jcbRegionItemStateChanged

    private void jtfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSearchKeyReleased
        
      String searchText = jtfSearch.getText().trim();
      filtrarTablaPorTextoYRegion(searchText, (String) jcbRegion.getSelectedItem());
        
    }//GEN-LAST:event_jtfSearchKeyReleased

    private void jtDataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDataMousePressed
        
        int selectedRow = jtData.getSelectedRow();
        if (selectedRow != -1) { // Verificar si se ha seleccionado una fila válida
            // Obtener el índice de la fila seleccionada en el modelo de la vista
            int modelRowIndex = jtData.convertRowIndexToModel(selectedRow);

            // Obtener el modelo de tabla filtrado a través del TableRowSorter
            DefaultTableModel filteredModel = (DefaultTableModel) jtData.getModel();

            // Obtener el valor de la columna "PKG direct link" en la fila seleccionada
            Object pkgDirectLinkValue = filteredModel.getValueAt(modelRowIndex, getColumnIndexByName("PKG direct link"));

            // Verificar si el valor de pkgDirectLinkValue es MISSING o CART ONLY
            if (pkgDirectLinkValue.equals("MISSING")) {
                // Mostrar mensaje de que el juego no se puede descargar porque el link de descarga no está registrado
                JOptionPane.showMessageDialog(this, "You cannot download this game because the download link is not registered.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (pkgDirectLinkValue.equals("CART ONLY")) {
                // Mostrar mensaje de que el juego solo se encuentra en formato físico
                JOptionPane.showMessageDialog(this, "This game is available in cart only.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else if (pkgDirectLinkValue.equals("NOT REQUIRED")) {
                // Mostrar mensaje de que el juego solo se encuentra en formato físico
                JOptionPane.showMessageDialog(this, "NO download required", "Información", JOptionPane.INFORMATION_MESSAGE);
            }else {
                // El juego está disponible para descarga
                Object nameValue = filteredModel.getValueAt(modelRowIndex, getColumnIndexByName("Name"));
                Object fileSizeValue = filteredModel.getValueAt(modelRowIndex, getColumnIndexByName("File Size"));
                Object zRIFValue = filteredModel.getValueAt(modelRowIndex, getColumnIndexByName("zRIF"));
                String pkgDirectLink = pkgDirectLinkValue.toString();
                String fileName = pkgDirectLink.substring(pkgDirectLink.lastIndexOf("/") + 1);
                String zRIF = zRIFValue.toString();

                // Mostrar el cuadro de diálogo de confirmación para descargar el archivo
                int option = JOptionPane.showConfirmDialog(this,
                        "¿You want to download " + nameValue + ", Size is " + utilities.convertFileSize(fileSizeValue) + "?",
                        "Download File",
                        JOptionPane.YES_NO_OPTION);

                // Verificar la opción seleccionada por el usuario
                if (option == JOptionPane.YES_OPTION) {
                    // Lógica para descargar el archivo aquí
                    downloadFileInBackground(pkgDirectLink, fileName, fileName, zRIF);
                }
            }
        } 
    }//GEN-LAST:event_jtDataMousePressed

    private void jbResumeAndPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbResumeAndPauseActionPerformed
        // Cambiar el estado de la descarga
        downloadPaused = !downloadPaused;
        // Actualizar el texto del botón
        if (downloadPaused) {
            jbResumeAndPause.setText("Resume");
        } else {
            jbResumeAndPause.setText("Pause");
        }
    }//GEN-LAST:event_jbResumeAndPauseActionPerformed
    
    public void fillTableAndComboBox(){
    
    // Crear un nuevo modelo de tabla usando los datos del archivo TSV
        try {
            originalModel = utilities.readTSV();
        } catch (IOException e) {
            // Manejar cualquier excepción que pueda ocurrir al leer el archivo TSV
            e.printStackTrace();
            // Si ocurre un error al leer el archivo, salir del método
            return;
        }
        //Carga el modelo a la Jtable
        jtData.setModel(originalModel);

        // Crear el TableRowSorter si no existe
        if (rowSorter == null) {
            rowSorter = new TableRowSorter<>(originalModel);
            jtData.setRowSorter(rowSorter);
        }

        // Obtener el número de columnas
        int regionColumnIndex = jtData.getColumn("Region").getModelIndex();

        // Verificar si la columna de la región existe
        if (regionColumnIndex != -1) {
            // Crear un conjunto para almacenar valores únicos de la columna de la región
            Set<String> regionSet = new HashSet<>();

            // Iterar sobre las filas para obtener los valores únicos de la región
            for (int row = 0; row < originalModel.getRowCount(); row++) {
                // Obtener el valor de la región en la fila actual
                String region = (String) originalModel.getValueAt(row, regionColumnIndex);

                // Agregar el valor al conjunto
                regionSet.add(region);
            }

            // Limpiar el JComboBox
            jcbRegion.removeAllItems();
            // Agregar la opción para mostrar todas las regiones
            jcbRegion.addItem("All regions");

            // Agregar los elementos únicos al JComboBox
            for (String region : regionSet) {
                jcbRegion.addItem(region);
            }
        } else {
            System.out.println("The region column does not exist in the table.");
        }
        
    }
    
    private void filtrarTablaPorTextoYRegion(String searchText, String region) {
    // Crear un RowFilter para filtrar por el texto ingresado y la región seleccionada
    RowFilter<DefaultTableModel, Integer> rowFilterByText = null;
    RowFilter<DefaultTableModel, Integer> rowFilterByRegion = null;
    try {
        // Filtrar por texto ingresado
        rowFilterByText = RowFilter.regexFilter("(?i)" + searchText); // Ignore case

        // Filtrar por región seleccionada si no se selecciona "Todas las regiones"
        if (!region.equals("All regions")) {
            rowFilterByRegion = RowFilter.regexFilter("(?i)" + region, getColumnIndexByName("Region"));
        }

        // Combinar los filtros
        List<RowFilter<DefaultTableModel, Integer>> filters = new ArrayList<>();
        if (rowFilterByText != null) filters.add(rowFilterByText);
        if (rowFilterByRegion != null) filters.add(rowFilterByRegion);

        RowFilter<DefaultTableModel, Integer> combinedRowFilter = RowFilter.andFilter(filters);

        // Establecer el RowFilter en el TableRowSorter
        rowSorter.setRowFilter(combinedRowFilter);
    } catch (java.util.regex.PatternSyntaxException e) {
        // Si hay un error en la expresión regular, simplemente no aplicamos ningún filtro
        rowSorter.setRowFilter(null);
        return;
    }
}
    
    private int getColumnIndexByName(String columnName) {
    for (int i = 0; i < originalModel.getColumnCount(); i++) {
        if (originalModel.getColumnName(i).equals(columnName)) {
            return i;
        }
    }
    return -1; // Si no se encuentra la columna, retornar -1
}
    
    public void downloadFileInBackground(String fileURL, String localFilePath, String fileName,String zRIF) {        
    // Hilo de descarga para no bloquear la interfaz de usuario
    SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
        @Override
        protected Void doInBackground() throws Exception {
            // Establecer la variable de descarga en true
            downloading = true;      
            // Verificar si el archivo ya existe
            File file = new File(localFilePath);
            if (file.exists()) {
                JOptionPane.showMessageDialog(Frame.this, "The file already exists. There is no need to download it again.");                 
                return null; // Salir si el archivo ya existe
            }
            
            // Habilitar el botón jbResumeAndPause
            jbResumeAndPause.setEnabled(true);
            
            // Verificar si las carpetas db y games existen, si no, crearlas
            File dbFolder = new File("db");
            File gamesFolder = new File("games");
            if (!dbFolder.exists()) {
                dbFolder.mkdir();
            }
            if (!gamesFolder.exists()) {
                gamesFolder.mkdir();
            }
            long bytesDownloaded = 0;
            try (BufferedInputStream in = new BufferedInputStream(new URL(fileURL).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(localFilePath)) {
                
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                
                
                
                // Si el archivo ya existe, saltar al final de este
                if (file.exists()) {
                    bytesDownloaded = file.length();
                    in.skip(bytesDownloaded);
                }
                
                long fileSize = utilities.getFileSize(fileURL);
                
                // Leer y escribir datos del archivo
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    // Si la descarga está pausada, esperar
                    while (downloadPaused) {
                        Thread.sleep(1000); // Esperar 1 segundo antes de verificar de nuevo
                    }
                    
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                    bytesDownloaded += bytesRead;
                    
                    // Calcular y publicar el progreso
                    int progress = (int) (bytesDownloaded * 100 / fileSize);
                    publish(progress);
                }
            } catch (IOException e) {
                // Manejar la excepción
                e.printStackTrace(); // Imprimir la traza de la excepción para depuración
            }
            return null;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            // Actualizar la barra de progreso con el último valor publicado
            int progress = chunks.get(chunks.size() - 1);
            jpbDownload.setValue(progress);
        }

        @Override
        protected void done() {
            // Establecer la variable de descarga en false cuando la descarga haya terminado
            downloading = false;
            
            // Desabilitar el botón jbResumeAndPause
            jbResumeAndPause.setEnabled(false);
            // Verificar la extensión del archivo descargado
            String extension = localFilePath.substring(localFilePath.lastIndexOf(".") + 1).toLowerCase();
            switch (extension) {
                case "tsv":
                                        
                    // Mover el archivo a la carpeta "db"
                    utilities.moveFile(localFilePath, "db/" + localFilePath.substring(localFilePath.lastIndexOf("/") + 1));                   
                    JOptionPane.showMessageDialog(Frame.this, "Database loaded");
                    fillTableAndComboBox();
                    
                    break;
                case "pkg":
                    
                    // Mover el archivo a la carpeta "games"
                    utilities.moveFile(localFilePath, "games/" + localFilePath.substring(localFilePath.lastIndexOf("/") + 1));
                    JOptionPane.showMessageDialog(Frame.this, "PKG download completed.");
                    String command = utilities.buildCommand(fileName, zRIF);
                    utilities.runCommandWithLoadingMessage(command);
                    break;
                default:
                    // No hacer nada si la extensión no está definida
                    break;
            }
            
            // Notificar al usuario que la descarga ha finalizado
            //JOptionPane.showMessageDialog(Frame.this, "Descarga completada.");
            //fillTableAndComboBox();
        }
    };

    // Ejecutar el SwingWorker
    worker.execute();
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbRefresh;
    private javax.swing.JButton jbResumeAndPause;
    private javax.swing.JLabel jbsearch;
    private javax.swing.JComboBox<String> jcbRegion;
    private javax.swing.JProgressBar jpbDownload;
    private javax.swing.JTable jtData;
    private javax.swing.JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
}
