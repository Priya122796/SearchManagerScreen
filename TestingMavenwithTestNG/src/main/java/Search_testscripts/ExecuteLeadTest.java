package Search_testscripts;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author Nifa
 *
 */
public class ExecuteLeadTest {
	@Test
	public  void LeadTest() throws Exception {
		ArrayList data=new ArrayList();
		Keyword key=new Keyword(); 
		FileInputStream fis=new FileInputStream("E://AutomationForAliExpress//src//testcases//TestcaseLeadSuite.xlsx");
		XSSFWorkbook work=new XSSFWorkbook(fis);
		Sheet s=work.getSheet("TestSteps");
		Iterator itr=s.iterator();
		while(itr.hasNext()){
			Row r=(Row) itr.next();
			Iterator citr=r.iterator();
			while(citr.hasNext())
			{			
				Cell c=(Cell) citr.next();
				switch(c.getCellType()){
				case STRING:
					data.add(c.getStringCellValue());
					break;
				case NUMERIC:
					data.add(c.getNumericCellValue());
					break;
				}
			}
		}
		for(int i=0;i<data.size();i++){
			if(data.get(i).equals("openbrowser")){
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes"))
					key.openbrowser();
			}
			else if(data.get(i).equals("navigate")){
				String datas=(String) data.get(i+1);
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes"))
					key.navigate(datas);
			}
			else if(data.get(i).equals("input")){
				String datas=(String) data.get(i+1);
				String objectName=(String) data.get(i+2);
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes")){
					key.input(datas,objectName);}
			}else if(data.get(i).equals("click")){
				String objectName=(String) data.get(i+2);
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes")){
					key.click(objectName);}
			}
			else if(data.get(i).equals("dropdown")){
				String objectName=(String) data.get(i+2);
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes")){
					key.dropdown(objectName);}
			}
			else if(data.get(i).equals("select")){
				String objectName=(String) data.get(i+2);
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes")){
					key.select(objectName);}
			}


			else if(data.get(i).equals("verifyTitle")){
				String datas=(String) data.get(i+1);
				String runmode=(String) data.get(i+3);
				if(runmode.equals("yes")){
					String actual=key.verifyTitle();
					Assert.assertEquals(datas, actual);
				}}
		}


	}
}
