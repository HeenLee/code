package com.base.map;

import java.util.Objects;

/**
 * TreeSet是有序存储。存储自定义元素时两种情况：
 * 1. 元素自身具备比较性。需要实现Comparable接口，重写compareTo方法。这种方式是自然排序，也称默认排序
 * 2. 容器具备比较性
 * 当元素自身不具备比较性，或者自身具备的比较性不是所需要的。那么此时可以让容器自身具备。需要定义一个类实现接口Comparator，
 * 重写compare方法，并将该接口的子类实例对象作为参数传递给TreeMap集合的构造方法。
 *
 */
public class Person{
	private String name;
	private int age;

	public Person() {
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return age == person.age &&
				Objects.equals(name, person.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
}
