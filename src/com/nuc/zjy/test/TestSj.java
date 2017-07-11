package com.nuc.zjy.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @项目名称：ticket
 * @类名称：TestSj
 * @类描述：
 * 
 * @author 赵建银
 * @date 2017-7-11
 * @time 上午8:17:02
 * @version 1.0
 */
public class TestSj {
	public static void main(String[] args) {
		List<Teacher> teachers = new ArrayList<Teacher>();
		teachers.add(new Teacher("张老师", 8000));
		teachers.add(new Teacher("李老师", 5000));
		teachers.add(new Teacher("苍老师", 10000));
		// 判断是否为空
		if (teachers.isEmpty()) {
			System.out.println("空");
		} else {
			System.out.println("不为空");
		}
		// 判断是否包含张老师
		if (teachers.contains(new Teacher("张老师", 8000))) {
			boolean flag = teachers.remove(new Teacher("张老师", 8000));
			if (flag) {
				// 迭代器遍历
				System.out.println("存在，已删除");
				System.out.println("-------------第一次遍历-----------");
				Iterator<Teacher> iterator = teachers.iterator();
				while (iterator.hasNext()) {
					Teacher teacher = (Teacher) iterator.next();
					System.out.println(teacher);
				}

			}

		} else {
			System.out.println("不存在");
		}
		// 另一个集合
		List<Teacher> teachers2 = new ArrayList<Teacher>();
		teachers2.add(new Teacher("刘老师", 4000));
		teachers2.add(new Teacher("王老师", 5000));
		teachers2.add(new Teacher("张老师", 6000));
		System.out.println("--------------第二次遍历--------");
		// 添加到第一个集合中
		teachers.addAll(teachers2);
		// for循环遍历输出
		for (int i = 0; i < teachers.size(); i++) {
			System.out.println(teachers.get(i));
		}
	}
}

class Teacher {
	String name;
	int salar;

	public Teacher() {
		super();
	}

	public Teacher(String name, int salar) {
		super();
		this.name = name;
		this.salar = salar;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salar != other.salar)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", salar=" + salar + "]";
	}

}
