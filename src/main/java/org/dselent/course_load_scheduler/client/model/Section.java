package org.dselent.course_load_scheduler.client.model;

public class Section extends Model
{	
	// attributes
	
	private String sectionName;
	private Integer crn;
	private String type;
	private Integer expectedPopulation;
	private Integer frequency;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sectionName == null) ? 0 : sectionName.hashCode());
		result = prime * result + ((crn == null) ? 0 : crn.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((expectedPopulation == null) ? 0 : expectedPopulation.hashCode());
		result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
		return result;
	}

	

	public String getSectionName() {
		return sectionName;
	}


	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}


	public int getCrn() {
		return crn;
	}


	public void setCrn(int crn) {
		this.crn = crn;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getExpectedPopulation() {
		return expectedPopulation;
	}


	public void setExpectedPopulation(int expectedPopulation) {
		this.expectedPopulation = expectedPopulation;
	}


	public int getFrequency() {
		return frequency;
	}


	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		if (sectionName == null) {
			if (other.sectionName != null)
				return false;
		} else if (!sectionName.equals(other.sectionName))
			return false;
		if (crn == null) {
			if (other.crn != null)
				return false;
		} else if (!crn.equals(other.crn))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (expectedPopulation == null) {
			if (other.expectedPopulation != null)
				return false;
		} else if (!expectedPopulation.equals(other.expectedPopulation))
			return false;
		if (frequency == null) {
			if (other.frequency != null)
				return false;
		} else if (!frequency.equals(other.frequency))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "FacultyCourse [sectionName=" + sectionName + ", crn=" + crn + ", type=" + type + ", expectedPopulation="
				+ expectedPopulation + ", frequency=" + frequency + "]";
	}
	
}
