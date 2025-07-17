package Wrappers;

public class WebCommonPath {

	public static String extentReportPath = System.getProperty("user.dir") + "/reports/report" + "_"
			+ WebCurrentTime.getCurrentDateTimeFormat() + ".html";
	public static String testDatafileTims = System.getProperty("user.dir") + "/TestData/TimsCredential.properties";	
	public static String testDatafile = System.getProperty("user.dir") + "/TestData/Crendential.properties";
	public static String HTMLOUTPUT_PATH = System.getProperty("user.dir") + "/reports/output.html";
	public static String CSV_Upload_Data = System.getProperty("user.dir") + "/TestData/POImportTemplate.csv";
	public static String phlebotomist_File = System.getProperty("user.dir") + "/Downloads/phlebotomist_sample_data.csv";
	public static String shTestGold_csv = System.getProperty("user.dir") + "/TestData/SexualHealthGold.csv";
	public static String shTestBlue_csv = System.getProperty("user.dir") + "/TestData/SexualHealthBlue.csv";
	public static String DNAKitCreation_csv = System.getProperty("user.dir") + "/TestData/DNAKitCreation.csv";
	public static String shTestGoldUnconfirmed = System.getProperty("user.dir") + "/TestData/SexualHealthGoldUnconfirmed.csv";
	public static String shTestBlueUnconfirmed = System.getProperty("user.dir") + "/TestData/SexualHealthBlueUnconfirmed.csv";
	public static String bloodHormoneMenopause = System.getProperty("user.dir") + "/TestData/BloodHormoneMenopause.csv";
	public static String dnaWeight = System.getProperty("user.dir") + "/TestData/DNAWeight.csv";
	public static String createKit_csv = System.getProperty("user.dir") + "/TestData/CreateKitCsv.csv";
}