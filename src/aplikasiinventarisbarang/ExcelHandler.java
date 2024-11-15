package aplikasiinventarisbarang;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


public class ExcelHandler {
    
    public static void exportTableToExcel(JTable table, JFrame parent) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Simpan File Excel");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            if (fileChooser.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (!file.getName().endsWith(".xlsx")) {
                    file = new File(file.getAbsolutePath() + ".xlsx");
                }
                
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Data Inventaris");
                
                // Create header row
                Row headerRow = sheet.createRow(0);
                for (int i = 0; i < table.getColumnCount(); i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(table.getColumnName(i));
                }
                
                // Create data rows
                for (int i = 0; i < table.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);
                        Object value = table.getValueAt(i, j);
                        
                        if (value instanceof Date) {
                            cell.setCellValue((Date) value);
                            CellStyle cellStyle = workbook.createCellStyle();
                            CreationHelper createHelper = workbook.getCreationHelper();
                            cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
                            cell.setCellStyle(cellStyle);
                        } else if (value != null) {
                            cell.setCellValue(value.toString());
                        }
                    }
                }
                
                // Auto size columns
                for (int i = 0; i < table.getColumnCount(); i++) {
                    sheet.autoSizeColumn(i);
                }
                
                // Write to file
                try (FileOutputStream outputStream = new FileOutputStream(file)) {
                    workbook.write(outputStream);
                }
                workbook.close();
                
                JOptionPane.showMessageDialog(parent, "Data berhasil disimpan ke Excel", 
                    "Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(parent, "Error: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void importExcelToTable(DefaultTableModel tableModel, JFrame parent) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Pilih File Excel");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            if (fileChooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                
                try (FileInputStream fis = new FileInputStream(file);
                     Workbook workbook = WorkbookFactory.create(fis)) {
                    
                    Sheet sheet = workbook.getSheetAt(0);
                    
                    // Clear existing table data
                    tableModel.setRowCount(0);
                    
                    // Skip header row (row 0) and start from row 1
                    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                        Row row = sheet.getRow(i);
                        if (row != null) {
                            Vector<Object> dataRow = new Vector<>();
                            
                            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                                Cell cell = row.getCell(j);
                                if (cell != null) {
                                    switch (cell.getCellType()) {
                                        case NUMERIC:
                                            if (DateUtil.isCellDateFormatted(cell)) {
                                                dataRow.add(cell.getDateCellValue());
                                            } else {
                                                dataRow.add(cell.getNumericCellValue());
                                            }
                                            break;
                                        case STRING:
                                            dataRow.add(cell.getStringCellValue());
                                            break;
                                        default:
                                            dataRow.add("");
                                    }
                                } else {
                                    dataRow.add("");
                                }
                            }
                            tableModel.addRow(dataRow);
                        }
                    }
                    
                    JOptionPane.showMessageDialog(parent, "Data berhasil dimuat dari Excel",
                        "Sukses", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(parent, "Error: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}