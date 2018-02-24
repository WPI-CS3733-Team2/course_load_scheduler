package org.dselent.course_load_scheduler.client.model;

import java.util.Date;

public class Request extends Model {
	
		// attributes
		
		private Integer id;
		private Integer facultyId;
		private Integer type;
		private Integer state;
		private Integer course;
		private Integer section;
		private String data;
		private Date createdAt;
		private Date updatedAt;


		// methods
		
		public int getId()
		{
			return id;
		}

		public void setId(Integer id)
		{
			this.id = id;
		}
		
		public int getFacultyId()
		{
			return facultyId;
		}

		public void setFacultyId(Integer facultyId)
		{
			this.facultyId = facultyId;
		}
		
		public int getType()
		{
			return type;
		}

		public void setType(Integer type)
		{
			this.type = type;
		}
		
		public int getState()
		{
			return state;
		}

		public void setState(Integer state)
		{
			this.state = state;
		}
		
		public int getCourse()
		{
			return course;
		}

		public void setCourse(Integer course)
		{
			this.course = course;
		}
		
		public int getSection()
		{
			return section;
		}

		public void setSection(Integer section)
		{
			this.section = section;
		}
		
		public String getData()
		{
			return data;
		}

		public void setData(String data)
		{
			this.data = data;
		}
		//////////////////
		public Date getCreatedAt()
		{
			return createdAt;
		}

		public void setCreatedAt(Date createdAt)
		{
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt()
		{
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt)
		{
			this.updatedAt = updatedAt;
		}
		

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			result = prime * result + ((section == null) ? 0 : section.hashCode());
			result = prime * result + ((course == null) ? 0 : course.hashCode());
			result = prime * result + ((state == null) ? 0 : state.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			result = prime * result + ((facultyId == null) ? 0 : facultyId.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
			{
				return true;
			}
			if (obj == null)
			{
				return false;
			}
			if (!(obj instanceof Request))
			{
				return false;
			}
			Request other = (Request) obj;
			//**********
			if (createdAt == null)
			{
				if (other.createdAt != null)
				{
					return false;
				}
			}
			else if (!createdAt.equals(other.createdAt))
			{
				return false;
			}
			//**********
			if(id == null)
			{
				if(other.id != null)
				{
					return false;
				}
			}
			else if(!id.equals(other.id))
			{
				return false;
			}
			//**********
			if(facultyId == null)
			{
				if(other.facultyId != null)
				{
					return false;
				}
			}
			else if(!facultyId.equals(other.facultyId))
			{
				return false;
			}
			//**********
			if(type == null)
			{
				if(other.type != null)
				{
					return false;
				}
			}
			else if(!type.equals(other.type))
			{
				return false;
			}
			//**********
			if(state == null)
			{
				if(other.state != null)
				{
					return false;
				}
			}
			else if(!state.equals(other.state))
			{
				return false;
			}
			//**********
			if(course == null)
			{
				if(other.course != null)
				{
					return false;
				}
			}
			else if(!course.equals(other.course))
			{
				return false;
			}
			//**********
			if(section == null)
			{
				if(other.section != null)
				{
					return false;
				}
			}
			else if(!section.equals(other.section))
			{
				return false;
			}
			//**********
			if(data == null)
			{
				if(other.data != null)
				{
					return false;
				}
			}
			else if(!data.equals(other.data))
			{
				return false;
			}
			//**********
			return true;
		}
		
		@Override
		public String toString()
		{
			StringBuilder builder = new StringBuilder();
			builder.append("Request [id=");
			builder.append(id);
			builder.append(", facultyId=");
			builder.append(facultyId);
			builder.append(", type=");
			builder.append(type);
			builder.append(", state=");
			builder.append(state);
			builder.append(", course=");
			builder.append(course);
			builder.append(", section=");
			builder.append(section);
			builder.append(", data=");
			builder.append(data);
			builder.append(", createdAt=");
			builder.append(createdAt);
			builder.append(", updatedAt=");
			builder.append(updatedAt);
			builder.append("]");
			return builder.toString();
		}
}
