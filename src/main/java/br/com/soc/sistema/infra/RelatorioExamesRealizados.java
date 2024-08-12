package br.com.soc.sistema.infra;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import br.com.soc.sistema.vo.ExameRealizadoVo;

public class RelatorioExamesRealizados {
    private static final String FILE_PATH = "/home/glucio/Downloads/relatorio.xls";
    
    HSSFWorkbook workbook = new HSSFWorkbook();
    HSSFSheet sheet = workbook.createSheet("Relatório de exames realizados");
    
    public void gerarRelatorio(List<ExameRealizadoVo> exameRealizados) {
	int rowidx = 0;
	
	Row headerRow = sheet.createRow(rowidx++);
	int headerCellidx = 0;
	
	headerRow.createCell(headerCellidx++).setCellValue("ID FUNCIONÁRIO");
	headerRow.createCell(headerCellidx++).setCellValue("NOME FUNCIONÁRIO");
	headerRow.createCell(headerCellidx++).setCellValue("ID EXAME");
	headerRow.createCell(headerCellidx++).setCellValue("NOME EXAME");
	headerRow.createCell(headerCellidx++).setCellValue("DATA EXAME");
	
	HSSFCellStyle dateCellStyle = workbook.createCellStyle();
	HSSFDataFormat dateFormat = workbook.createDataFormat();
	dateCellStyle.setDataFormat(dateFormat.getFormat("dd/MM/yyyy"));
	
	for (ExameRealizadoVo exameRealizado : exameRealizados) {
	    Row row = sheet.createRow(rowidx++);
	    int cellidx = 0;
	    Cell cellIdFuncionario = row.createCell(cellidx++);
	    cellIdFuncionario.setCellValue(exameRealizado.getFuncionarioVo().getRowid());
	    Cell cellNomeFuncionario = row.createCell(cellidx++);
	    cellNomeFuncionario.setCellValue(exameRealizado.getFuncionarioVo().getNome());
	    Cell cellIdExame = row.createCell(cellidx++);
	    cellIdExame.setCellValue(exameRealizado.getExameVo().getRowid());
	    Cell cellNomeExame = row.createCell(cellidx++);
	    cellNomeExame.setCellValue(exameRealizado.getExameVo().getNome());
	    Cell cellDataExame = row.createCell(cellidx++);
	    cellDataExame.setCellValue(exameRealizado.getDataExame());
	    cellDataExame.setCellStyle(dateCellStyle);
	}
	
	try {
		FileOutputStream out = new FileOutputStream(new File(FILE_PATH));
		workbook.write(out);
		out.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
    }
    
    
}
