package org.dselent.course_load_scheduler.client.errorstring;

/**
 * Place to hard-code error messages
 * This one is for error messages related to an invalid login with empty fields
 * 
 * @author dselent
 *
 */

public class InvalidAddModifyCourseStrings
{
	public static final String EMPTY_SECTION_FIELD = "All section fields must be filled in.";
	public static final String EMPTY_COURSE_FIELD = "All course fields must be filled in and there must be at least one section.";
	public static final String INTEGER_SECTION_FIELDS = "CRN, year, and expected population must be Integers.";
	public static final String INTEGER_COURSE_FIELDS = "Frequency must be an integer";
	public static final String DUPLICATE_COURSE_NAME = "A course with this number already exists.";

}
