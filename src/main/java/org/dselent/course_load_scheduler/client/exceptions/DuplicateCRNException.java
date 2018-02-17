package org.dselent.course_load_scheduler.client.exceptions;

/**
 * Custom exception for when an empty String is given (when there should not be one)
 * 
 * @author dselent
 *
 */
public class DuplicateCRNException extends Exception
{

	private static final long serialVersionUID = 1L;
	
	public DuplicateCRNException()
	{
		
	}

}
