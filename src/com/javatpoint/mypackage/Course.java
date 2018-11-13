package com.javatpoint.mypackage;

public class Course
	{
		int id;
		int coursename;

		public int getId()
			{
				return id;
			}

		public void setId(int id)
			{
				this.id = id;
			}

		public int getCoursename()
			{
				return coursename;
			}

		public void setCoursename(int coursename)
			{
				this.coursename = coursename;
			}

		public Course(int id, int coursename)
			{
				super();
				this.id = id;
				this.coursename = coursename;
			}
	}
