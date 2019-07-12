
package com.wipro.telstra.automationFW.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonConstants {
	
	public static List<String> expHighLowUsageTableHeaders = Arrays.asList("MACHINE, MODEL, SITE, LABEL 1, LABEL 2, AVG. USAGE HOURS PER DAY, USAGE INDICATOR");

	public static List<String> expInspectionTemplateTableHeaders = Arrays.asList("INSPECTION TEMPLATE CUSTOMER SITES ACTIVE ADDITIONAL RECURRING % RANDOM SAMPLE RANGE % OPERATIONS");
	
	public static List<String> expRecipientGroupsTableHeaders = Arrays.asList("DENOTATION RECIPIENT LIST OPERATIONS");
	
	public static List<String> expNotificationsGroupsTableHeaders = Arrays.asList("DENOTATION DESCRIPTION EVENTS CUSTOMERS SITES OPERATIONS");

	public static List<String> expRoomTypesTableHeaders = Arrays.asList("DENOTATION ADDITION DESCRIPTION ROOMGROUP OPERATIONS");

	public static List<String> expInspectionCriterionTableHeaders = Arrays.asList("REFERENCE NUMBER	DENOTATION DESCRIPTION ACTIVE OPERATIONS");

	public static List<String> expInspectionCriterionDropdown = Arrays.asList("Select, All, Active, Inactive");

	public static List<String> expInspectionGroupTableHeaders = Arrays.asList("REFERENCE NUMBER DENOTATION ADDITIONAL COMMENT DESCRIPTION ACTIVE OPERATIONS");

	public static List<String> expInspectionGroupDropdown = Arrays.asList("--, Main Component, Other Inventory, Floor, Wall/Ceiling, Difficult Visible Area");

	public static List<String> expRatingTextTableHeaders = Arrays.asList("REFERENCE NUMBER DENOTATION RATING LEVEL RATING TEXT 1 RATING TEXT 2 RATING TEXT 3 RATING TEXT 4 RATING TEXT 5 ACTIVE OPERATIONS");

	public static List<String> expRoomManagementTableHeaders = Arrays.asList("ROOM NUMBER CUSTOMER SITE DENOTATION ROOM TYPE FLOOR LEVEL STATUS	OPERATIONS");

	public static List<String> expRoomManagementAdditionalFields = Arrays.asList("Height, Square Meter, Floor Covering, Windows Square meters, Surface Material, Wall Material, Cleaning Frequency, Conditions, Obstruction, Cleaning level, Cost Unit, District, Key List, Access, Check Cleaning, Heating Devices, Luminious Element, Air Condition, Power Outlet, Fire Detector, Water Available, Security, Plants");

	public static List<String> expRoomsBarcodeReportsTableHeaders = Arrays.asList("REFERENCE NUMBER	CUSTOMER SITE ROOM NUMBER DENOTATION FLOOR LEVEL ROOM TYPE BARCODE");

	public static List<String> expInspectionResultsReportTableHeaders = Arrays.asList("DATE TIME INSPECTED BY INSPECTION TYPE INSPECTION TEMPLATE ROOMS OPERATIONS");
}
