class Person implements Comparable<Person>{

	String name;
	int age;

	public Person(String n, int a){
		name = n;
		age = a;
	}

	// public boolean compareTo(Person that){
	// 	return this.age.compareTo(that.age);
	// }

	// public boolean compareTo(Person that){

	// 	if(this.age < that.age){
	// 		return -1;
	// 	}
	// 	if(this.age > that.age)
	// 		return +1;
	// 	else
	// 		return 0;
	// }

	// public int compareTo(Person that){
	// 	Integer len1 = this.name.length();
	// 	Integer len2 = that.name.length();
	// 	int compare = len1.compareTo(len2);
	// 	if(compare != 0){
	// 		return compare;
	// 	}
	// 	else{
	// 		return this.name.compareTo(that.name);
	// 	}

	// }

	public int compareTo(Person that){
		return this.name.compareTo(that.name);
	}

	public String toString()
	{
		return this.name;
	}
}
